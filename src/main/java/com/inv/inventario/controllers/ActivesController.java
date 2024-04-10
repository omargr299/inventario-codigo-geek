package com.inv.inventario.controllers;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.inv.inventario.Dtos.ActivoCreateDto;
import com.inv.inventario.Dtos.ActivoEditDto;
import com.inv.inventario.Dtos.ActivoProperDto;
import com.inv.inventario.Models.Activo;
import com.inv.inventario.Models.Association;
import com.inv.inventario.Models.Ubicacion;
import com.inv.inventario.Services.ActivoService;
import com.inv.inventario.Services.AssociationService;
import com.inv.inventario.Services.UbicacionService;

import jakarta.validation.Valid;

@RestController()
@RequestMapping(value="/activo")
public class ActivesController {
    
    @Autowired
    private ActivoService activoService;

    @Autowired UbicacionService ubicacionService;

    

    @GetMapping()
    public List<Activo> getAll() {
        return this.activoService.getAll();
    }

    @PostMapping(value = "", consumes = "*/*", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody ActivoCreateDto newActivo) {
        Ubicacion ubicacion = ubicacionService.getById(newActivo.getUbicacion());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        
        Optional<Activo> find_activo = null;
        try{
            find_activo = activoService.getById(newActivo.getIdActivo());
            
        }
        catch(Exception e){
            System.err.println(e);
        }

        if(find_activo!=null && !find_activo.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El activo ya existe:id");
        } 
        
        Activo activo = new Activo();
        activo.setIdActivo(newActivo.getIdActivo());
        activo.setNombre(newActivo.getNombre());
        activo.setDescripcion(newActivo.getDescripcion());
        activo.setFechaAdqui(formatter.parse(newActivo.getFechaAdqui(),new ParsePosition(0)));
        activo.setTotal(newActivo.getTotal());
        activo.setIva(newActivo.getTotal()*0.16f);
        activo.setValorDepreciado(newActivo.getTotal()*0.05f);
        activo.setDetalle(newActivo.getDetalle());
        activo.setStatus(newActivo.getStatus().value());
        activo.setUbicacion(ubicacion);
        activo.setFechaRevisado(formatter.parse(newActivo.getFechaRevisado(),new ParsePosition(0)));

        System.out.println("Activo: "+activo.getStatus()   );
        try{
            activoService.create(activo);
        }
        catch(DataIntegrityViolationException e){
            System.out.println(e);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El activo ya existe:id");
        }
    
        return "create an active";
    }

    @GetMapping(value = "/{id}", consumes = "*/*", produces = "application/json")
    public Activo getById(@PathVariable int id) {
        Activo act = activoService.getById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Activo no encontrado"));
        return act;
    }

    @DeleteMapping(value = "/{id}", consumes = "*/*", produces = "application/json")
    public String delete(@PathVariable int id) {
        activoService.delete(id);
        return "delete an active";
    }

    @PutMapping(value = "/{id}", consumes = "*/*", produces = "application/json")
    public String update(@PathVariable int id, @RequestBody ActivoEditDto activo) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Activo act = activoService.getById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Activo no encontrado"));
        act.setNombre(activo.getNombre());
        act.setDescripcion(activo.getDescripcion());
        act.setFechaAdqui(formatter.parse(activo.getFechaAdqui(),new ParsePosition(0)));
        act.setTotal(activo.getTotal());
        act.setDetalle(activo.getDetalle());
        act.setStatus(activo.getStatus());
        act.setUbicacion(ubicacionService.getById(activo.getUbicacion()));
        act.setFechaRevisado(formatter.parse(activo.getFechaRevisado(),new ParsePosition(0)));
        activoService.update(act);
        return "update an active";
    }

    
}

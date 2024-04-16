package com.inv.inventario.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inv.inventario.Dtos.UbicacionCresteDto;
import com.inv.inventario.Dtos.UbicacionDto;
import com.inv.inventario.Models.Ubicacion;
import com.inv.inventario.Services.UbicacionService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value="/ubicacion")
public class UbicacionController {

    @Autowired
    private UbicacionService ubicacionService;
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String errorType(HttpServletRequest req, Exception ex){
    	System.out.println("eerror");
    	return ex.getMessage();
    }
    
    @GetMapping(value="",consumes = "*/*", produces = "application/json")
    public List<Ubicacion> getAll(){
        return ubicacionService.getAll();
    }

    @PostMapping(value="",consumes = "*/*", produces = "application/json")
    public Ubicacion create(@RequestBody @Valid UbicacionCresteDto ubicacion){
      
        
        Ubicacion newUbicacion = new Ubicacion();
        newUbicacion.setCalle(ubicacion.getCalle());
        newUbicacion.setNumero(ubicacion.getNumero());
        newUbicacion.setColonia(ubicacion.getColonia());
        newUbicacion.setMunicipio(ubicacion.getMunicipio());
        newUbicacion.setEstado(ubicacion.getEstado());
        newUbicacion.setCp(ubicacion.getCp());
        ubicacionService.create(newUbicacion);
        
        return newUbicacion;
    }
}

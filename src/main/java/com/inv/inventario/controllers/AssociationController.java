package com.inv.inventario.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inv.inventario.Models.Association;
import com.inv.inventario.Models.Propietario;
import com.inv.inventario.Services.ActivoService;
import com.inv.inventario.Services.AssociationService;
import com.inv.inventario.Services.PropietarioService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/asociacion")
public class AssociationController {
    
    @Autowired
    private AssociationService associationService;

    @Autowired
    private ActivoService activosService;

    @Autowired
    private PropietarioService propietarioService;
    
    @PostMapping(value="", consumes = "*/*", produces = "application/json")
    public void asscociate(@RequestBody Association associateDto){
        
        associationService.create(associateDto);
    }

    @GetMapping(value="/{id}/propietario", consumes = "*/*", produces = "application/json")
    public Propietario getPropietario(@PathVariable("id") int IdActivo) {
        System.out.print("id: ");
        System.out.println(IdActivo);

        Association association = associationService.getByActivo(IdActivo);
        return propietarioService.getById(association.getIdPropietario()).get();
    }
}

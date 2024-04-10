package com.inv.inventario.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inv.inventario.Models.Ubicacion;
import com.inv.inventario.Repositories.UbicacionRepository;

@Service
public class UbicacionService {

    @Autowired
    private UbicacionRepository ubicacionRepository;

    public List<Ubicacion> getAll(){
        return ubicacionRepository.findAll();
    }

    public Ubicacion getById(int id){
        return ubicacionRepository.findById(id).get();
    }

    public Ubicacion create (Ubicacion ubicacion){
        return ubicacionRepository.save(ubicacion);
    }
}

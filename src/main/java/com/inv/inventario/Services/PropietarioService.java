package com.inv.inventario.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inv.inventario.Models.Propietario;
import com.inv.inventario.Repositories.PropietarioRepository;

@Service
public class PropietarioService {
    
    @Autowired
    private PropietarioRepository propietarioRepository;

    public List<Propietario> getAll(){
        return propietarioRepository.findAll();
    }

    public Optional<Propietario> getById(int id){
        return propietarioRepository.findById(id);
    }

    public Propietario create(Propietario propietario){;
        if (propietario == null) throw new IllegalArgumentException("Propietario no puede ser nulo");

        return propietarioRepository.save(propietario);
    }
}

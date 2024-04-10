package com.inv.inventario.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.inv.inventario.Models.Activo;
import com.inv.inventario.Models.Association;
import com.inv.inventario.Models.Propietario;
import com.inv.inventario.Repositories.AssociationRepository;

@Service
public class AssociationService {

    @Autowired
    private AssociationRepository associationRepository;

    @Autowired
    private ActivoService activoService;

    @Autowired
    private PropietarioService propietarioService;

    public Association getById(int id) {
        Optional<Association> association = associationRepository.findById(id);

        if (association.isEmpty()) throw new IllegalArgumentException("Asociación no encontrada");

        return association.get();
    }

    public Association getByActivo(int id) {
        Specification<Association> specification = (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("idActivo"), id);

        Optional<Association> association = associationRepository.findOne(specification);

        if (association.isEmpty()) throw new IllegalArgumentException("Asociación no encontrada");

        return association.get();
    }

    public Association create(Association association) {
        if (association == null) throw new IllegalArgumentException("Association no puede ser nulo");


        Optional<Activo> activo = activoService.getById(association.getIdActivo());

        if (activo.isEmpty()) throw new IllegalArgumentException("Activo no encontrado");

        Optional<Propietario> propietario = propietarioService.getById(association.getIdPropietario());

        if (propietario.isEmpty()) throw new IllegalArgumentException("Propietario no encontrado");

        return associationRepository.save(association);
    }
}

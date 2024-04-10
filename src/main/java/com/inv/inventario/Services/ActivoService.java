package com.inv.inventario.Services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.inv.inventario.Models.Activo;
import com.inv.inventario.Repositories.ActivoRepository;
import com.inv.inventario.Repositories.UbicacionRepository;
import com.inv.inventario.Specifications.ActivoSpecification;
import com.mysql.cj.util.StringUtils;

@Service
public class ActivoService {

    @Autowired
    ActivoRepository activoRepository;

    @Autowired
    UbicacionRepository ubicacionRepository;

    public List<Activo> getAll(){
        return (List<Activo>) activoRepository.findAll();
    }

    public int getCount(){
        return (int) activoRepository.count();
    }

    public int getCount(String queryLike,String fechaAdquiStart,String fechaAdquiEnd,int ubicacionLike, String statusLike){
        Specification<Activo> filters = Specification
        .where(StringUtils.isEmptyOrWhitespaceOnly(queryLike) ? null : ActivoSpecification.queryLike(queryLike))
        .and(
            StringUtils.isEmptyOrWhitespaceOnly(fechaAdquiStart) && StringUtils.isEmptyOrWhitespaceOnly(fechaAdquiEnd)  ? 
            null : 
            ActivoSpecification.fechaAdquiLike(fechaAdquiStart,fechaAdquiEnd)
        )
        .and(ubicacionLike == 0 ? null : ActivoSpecification.ubicacionLike(ubicacionLike))
        .and(ubicacionLike <= 2 ? null : ActivoSpecification.remoteLike(ubicacionLike))
        .and(StringUtils.isEmptyOrWhitespaceOnly(statusLike) ? null : ActivoSpecification.status(statusLike));
        
        return (int) activoRepository.count(filters);
    }

    public Page<Activo> getAll(String queryLike,String fechaAdquiStart,String fechaAdquiEnd,int ubicacionLike, String statusLike,int page){
        Specification<Activo> filters = Specification
        .where(StringUtils.isEmptyOrWhitespaceOnly(queryLike) ? null : ActivoSpecification.queryLike(queryLike))
        .and(
            StringUtils.isEmptyOrWhitespaceOnly(fechaAdquiStart) 
            && StringUtils.isEmptyOrWhitespaceOnly(fechaAdquiEnd)  
            ? null 
            : ActivoSpecification.fechaAdquiLike(fechaAdquiStart,fechaAdquiEnd)
        )
        .and(ubicacionLike == 0 ? null : ActivoSpecification.ubicacionLike(ubicacionLike))
        .and(ubicacionLike <= 2 ? null : ActivoSpecification.remoteLike(ubicacionLike))
        .and(StringUtils.isEmptyOrWhitespaceOnly(statusLike) ? null : ActivoSpecification.status(statusLike));
        
        return (Page<Activo>) activoRepository.findAll(filters,PageRequest.of(page-1,4));
    }

    public Optional<Activo> getById(int id){
        return activoRepository.findById(id);
    }

    public void create(Activo activo){
        if (activo == null) throw new IllegalArgumentException("Activo no puede ser nulo");
            activoRepository.save(activo);
    }

    public void delete(int id){
        activoRepository.deleteById(id);
    }

    public void update(Activo activo){
        if (activo == null) throw new IllegalArgumentException("Activo no puede ser nulo");
        activoRepository.save(activo);
    }
}

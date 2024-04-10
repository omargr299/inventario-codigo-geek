package com.inv.inventario.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inv.inventario.Models.Ubicacion;

@Repository
public interface UbicacionRepository extends JpaRepository<Ubicacion, Integer>{

}

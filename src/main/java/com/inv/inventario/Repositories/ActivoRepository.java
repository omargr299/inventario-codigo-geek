package com.inv.inventario.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.inv.inventario.Models.Activo;

@Repository
public interface ActivoRepository extends JpaRepository<Activo, Integer>, JpaSpecificationExecutor<Activo>{

}

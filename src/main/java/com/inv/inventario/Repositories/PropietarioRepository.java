package com.inv.inventario.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inv.inventario.Models.Propietario;

@Repository
public interface PropietarioRepository extends JpaRepository<Propietario, Integer>{

}

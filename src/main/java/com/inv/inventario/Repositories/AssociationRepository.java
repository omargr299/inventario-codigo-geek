package com.inv.inventario.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.inv.inventario.Models.Association;

@Repository
public interface AssociationRepository extends JpaRepository<Association, Integer>, JpaSpecificationExecutor<Association>{

}

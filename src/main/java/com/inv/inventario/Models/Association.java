package com.inv.inventario.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ActivoPropietario")
public class Association {
    @Id
    private int idAsignacion;
    @Column(name = "id_activo")
    private int idActivo;
    @Column(name = "id_propietario")
    private int idPropietario;

    public Association() {
    }
    
    public Association(int idAsignacion, int idActivo, int idPropietario) {
        this.idAsignacion = idAsignacion;
        this.idActivo = idActivo;
        this.idPropietario = idPropietario;
    }

    public int getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(int idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public int getIdActivo() {
        return idActivo;
    }

    public void setIdActivo(int idActivo) {
        this.idActivo = idActivo;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

    
}

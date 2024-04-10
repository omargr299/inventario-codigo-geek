package com.inv.inventario.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Ubicacion")
public class Ubicacion {
    @Id
    private int IdUbicacion;
    private String calle;
    private int numero;
    private String colonia;
    private String municipio;
    private String estado;
    private int cp;

    public Ubicacion() {
    }

    public Ubicacion(int idUbicacion, String calle, int numero, String colonia, String municipio, String estado, int cp) {
        IdUbicacion = idUbicacion;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.municipio = municipio;
        this.estado = estado;
        this.cp = cp;
    }

    public int getIdUbicacion() {
        return IdUbicacion;
    }

    public void setIdUbicacion(int idUbicacion) {
        IdUbicacion = idUbicacion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    @Override
    public String toString() {
        return  "calle " + calle + " #" + numero + " colonia "
                + colonia + ", " + municipio + ", " + estado + " " + cp;
    }

    
}

package com.inv.inventario.Dtos;

import com.inv.inventario.Enums.StatusValues;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

public class ActivoCreateDto {


    private String nombre;

    private float total;
    private String fechaAdqui;
    private StatusValues status;
    private String detalle;
    private String descripcion;
    private int ubicacion;


    public ActivoCreateDto() {
    }


    public ActivoCreateDto( String nombre, float total, String fechaAdqui, StatusValues status, String detalle,
        String descripcion, int ubicacion) {
    
        this.nombre = nombre;
        this.total = total;
        this.fechaAdqui = fechaAdqui;
        this.status = status;
        this.detalle = detalle;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
  
    }

    



    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public float getTotal() {
        return total;
    }
    public void setTotal(float total) {
        this.total = total;
    }
    public String getFechaAdqui() {
        return fechaAdqui;
    }
    public void setFechaAdqui(String fechaAdqui) {
        this.fechaAdqui = fechaAdqui;
    }
    public StatusValues getStatus() {
        return status;
    }
    public void setStatus(StatusValues status) {
        this.status = status;
    }
    public String getDetalle() {
        return detalle;
    }
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(int ubicacion) {
        this.ubicacion = ubicacion;
    }


    
}

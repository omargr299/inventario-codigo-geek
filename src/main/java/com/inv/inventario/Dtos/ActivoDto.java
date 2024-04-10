package com.inv.inventario.Dtos;

import java.sql.Date;

import org.springframework.context.annotation.Bean;

import com.inv.inventario.Models.Ubicacion;


public class ActivoDto {
    private int IdActivo;
    private String nombre;
    private float total;
    private float iva;
    private float valorDepreciado;
    private Date fechaAdqui;
    private String status;
    private String detalle;
    private String descripcion;
    private Ubicacion ubicacion;
    private Date fechaRevisado;
    
    public int getIdActivo() {
        return IdActivo;
    }
    public void setIdActivo(int idActivo) {
        IdActivo = idActivo;
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
    public float getIva() {
        return iva;
    }
    public void setIva(float iva) {
        this.iva = iva;
    }
    public float getValorDepreciado() {
        return valorDepreciado;
    }
    public void setValorDepreciado(float valorDepreciado) {
        this.valorDepreciado = valorDepreciado;
    }
    public Date getFechaAdqui() {
        return fechaAdqui;
    }
    public void setFechaAdqui(Date fechaAdqui) {
        this.fechaAdqui = fechaAdqui;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
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
    public Ubicacion getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }
    public Date getFechaRevisado() {
        return fechaRevisado;
    }
    public void setFechaRevisado(Date fechaRevisado) {
        this.fechaRevisado = fechaRevisado;
    }

    @Bean
    public boolean isRemote (){
        return this.ubicacion.getIdUbicacion() != 1 && this.ubicacion.getIdUbicacion() != 2;
    }
}

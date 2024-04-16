package com.inv.inventario.Models;

import java.util.Date;

import org.yaml.snakeyaml.util.EnumUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.inv.inventario.Enums.StatusValues;
import com.inv.inventario.Exceptions.NameException;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "Activo")
public class Activo {
    @Id
    private int IdActivo;
    private String nombre;
    @Column(name = "total", nullable = true)
    private Float total;
    @Column(name = "IVA", nullable = true)
    private Float iva;
    @Column(name = "valor_depreciado", nullable = true)
    private Float valorDepreciado;
    @Column(name = "fecha_adqui")
    private Date fechaAdqui;
    @Column(name = "status", nullable = true)
    private String status;
    @Column(name = "detalle", nullable = true)
    private String detalle;
    @Column(name = "descripcion", nullable = true)
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "id_ubicacion",nullable = true)
    private Ubicacion ubicacion;

    @Column(name = "fecha_revisado", nullable = true)
    private Date fechaRevisado;
    


    public Activo() {
    }

    public Activo(int idActivo, String nombre, float total, float iva, float valorDepreciado, Date fechaAdqui,
        String status, String detalle, String descripcion, Ubicacion ubicacion, Date fecha_revisado) {
        this.IdActivo = idActivo;
        this.nombre = nombre;
        this.total = total;
        this.iva = iva;
        this.valorDepreciado = valorDepreciado;
        this.fechaAdqui = fechaAdqui;
        this.status = status;
        this.detalle = detalle;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.fechaRevisado = fecha_revisado;
    }

    public int getIdActivo() {
        return this.IdActivo;
    }

    public void setIdActivo(int idActivo) {
        this.IdActivo = idActivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new NameException("El nombre no puede ser nulo o vacio:nombre");
        }
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
        if (status == null || status.isEmpty()) {
            throw new NameException("El status no puede ser nulo o vacio:status");
        }

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
        return this.ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Date getFechaRevisado() {
        return fechaRevisado;
    }

    public void setFechaRevisado(Date fecha_revisado) {
        this.fechaRevisado = fecha_revisado;
    }
    


    public boolean isRemote (){
        return this.ubicacion!=null && this.ubicacion.getIdUbicacion() != 1 && this.ubicacion.getIdUbicacion() != 2;
    }
}

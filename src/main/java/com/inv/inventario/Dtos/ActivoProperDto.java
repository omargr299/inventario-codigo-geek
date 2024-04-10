package com.inv.inventario.Dtos;

public class ActivoProperDto {
    private Integer idActivo;
    private String nombre;
    private float total;
    private String fechaAdqui;
    private String status;
    private String detalle;
    private String descripcion;
    private int ubicacion;
    private String fechaRevisado;
    private int idPropietario;
    private String nombrePropietario;
    private String apellidoPropietario;
    private String emailPropietario;

    public ActivoProperDto(Integer idActivo, String nombre, float total, String fechaAdqui, String status,
            String detalle, String descripcion, int ubicacion, String fechaRevisado, int idPropietario,
            String nombrePropietario, String apellidoPropietario, String emailPropietario) {
        this.idActivo = idActivo;
        this.nombre = nombre;
        this.total = total;
        this.fechaAdqui = fechaAdqui;
        this.status = status;
        this.detalle = detalle;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.fechaRevisado = fechaRevisado;
        this.idPropietario = idPropietario;
        this.nombrePropietario = nombrePropietario;
        this.apellidoPropietario = apellidoPropietario;
        this.emailPropietario = emailPropietario;
    }
    
    public Integer getIdActivo() {
        return idActivo;
    }
    public void setIdActivo(Integer idActivo) {
        this.idActivo = idActivo;
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
    public int getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(int ubicacion) {
        this.ubicacion = ubicacion;
    }
    public String getFechaRevisado() {
        return fechaRevisado;
    }
    public void setFechaRevisado(String fechaRevisado) {
        this.fechaRevisado = fechaRevisado;
    }
    public int getIdPropietario() {
        return idPropietario;
    }
    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }
    public String getNombrePropietario() {
        return nombrePropietario;
    }
    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }
    public String getApellidoPropietario() {
        return apellidoPropietario;
    }
    public void setApellidoPropietario(String apellidoPropietario) {
        this.apellidoPropietario = apellidoPropietario;
    }
    public String getEmailPropietario() {
        return emailPropietario;
    }
    public void setEmailPropietario(String emailPropietario) {
        this.emailPropietario = emailPropietario;
    }

    
}

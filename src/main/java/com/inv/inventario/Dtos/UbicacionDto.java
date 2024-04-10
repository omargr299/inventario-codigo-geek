package com.inv.inventario.Dtos;

public class UbicacionDto {
    private String calle;
    private int numero;
    private String colonia;
    private String municipio;
    private String estado;
    private int cp;

    public UbicacionDto() {
    }

    public UbicacionDto(String calle, int numero, String colonia, String municipio, String estado, int cp) {
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.municipio = municipio;
        this.estado = estado;
        this.cp = cp;
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
    public void setNumero(String numero) {
        this.numero = Integer.parseInt(numero);
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


}

package com.inv.inventario.Dtos;

public class AssociateDto {
    private int idActivo;
    private int idPropietario;

    public AssociateDto(int idActivo, int idPropietario) {
        this.idActivo = idActivo;
        this.idPropietario = idPropietario;
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

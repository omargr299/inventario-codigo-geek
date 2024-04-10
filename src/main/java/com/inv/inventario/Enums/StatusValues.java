package com.inv.inventario.Enums;

public enum StatusValues {
    en_uso("en uso"),
    descompuesto("descompuesto"),
    almacenado("almacenado"),
    no_encontrado("no encontrado");

    private final String value;

    StatusValues(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }


}

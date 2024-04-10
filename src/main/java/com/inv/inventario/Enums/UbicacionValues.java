package com.inv.inventario.Enums;

public enum UbicacionValues {
    BODEGA(1),
    OFICINA(2),
    CASA(3),
    OTRO(4);

    private final int value;

    UbicacionValues(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

package com.inv.inventario.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "La fecha de inicio debe ser menor a la fecha de fin")
public class RangeDateException extends RuntimeException {
    public RangeDateException(String message) {
        super(message);
    }
}

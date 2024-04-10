package com.inv.inventario.Exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = org.springframework.http.HttpStatus.BAD_REQUEST)
public class NameException extends IllegalArgumentException{
    public NameException(String message){
        super(message);
    }
}

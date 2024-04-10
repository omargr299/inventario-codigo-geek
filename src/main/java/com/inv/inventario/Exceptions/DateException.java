package com.inv.inventario.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "las fechas deben de estar en un formato valido")
public class DateException extends RuntimeException{

}

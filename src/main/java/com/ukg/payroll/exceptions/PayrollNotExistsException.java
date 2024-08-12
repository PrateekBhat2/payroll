package com.ukg.payroll.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PayrollNotExistsException extends RuntimeException{
    public PayrollNotExistsException(String message){
        super(message);
    }
}


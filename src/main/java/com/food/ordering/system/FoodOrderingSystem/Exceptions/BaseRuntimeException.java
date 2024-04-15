package com.food.ordering.system.FoodOrderingSystem.Exceptions;

import lombok.Data;

@Data
public class BaseRuntimeException extends RuntimeException {

    private int errorCode;

    public BaseRuntimeException(String message, int errorcode) {
        super(message);
        this.errorCode = errorcode;
    }
}
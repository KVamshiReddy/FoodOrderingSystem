package com.food.ordering.system.FoodOrderingSystem.Exceptions;

public class BadRequestException extends BaseRuntimeException {

    public BadRequestException(String message, int errorcode) {
        super(message, errorcode);
    }
}

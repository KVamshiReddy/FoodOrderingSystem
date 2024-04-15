package com.food.ordering.system.FoodOrderingSystem.Exceptions;

public class ResourceNotFoundException extends BaseRuntimeException {

    public ResourceNotFoundException(String message, int errorcode) {
        super(message, errorcode);
    }
}

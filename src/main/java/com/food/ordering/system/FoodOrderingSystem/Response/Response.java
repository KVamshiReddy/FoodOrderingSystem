package com.food.ordering.system.FoodOrderingSystem.Response;

import lombok.Data;

@Data
public class Response {

    private Object data;

    public Response(){
        super();
    }

    public Response(Object data){
        this.data = data;
    }

}

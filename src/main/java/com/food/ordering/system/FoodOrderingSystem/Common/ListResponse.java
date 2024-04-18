package com.food.ordering.system.FoodOrderingSystem.Common;

import lombok.Data;

@Data
public class ListResponse {
    private Object data;
    private long count;

    public ListResponse() {
    }

    public ListResponse(Object data, long count) {
        this.data = data;
        this.count = count;
    }

    public ListResponse(Object data) {
        this.data = data;
    }
}
package com.food.ordering.system.FoodOrderingSystem;

import com.food.ordering.system.FoodOrderingSystem.Common.CommonConstants;
import lombok.Data;

import java.util.UUID;

@Data
public class RestaurantSearchRequest {

    private UUID restaurantId;
    private String searchText;


}

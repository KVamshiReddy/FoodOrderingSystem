package com.food.ordering.system.FoodOrderingSystem.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItems {

    private UUID itemId;
    private String name;
    private double price;
    private double quantity;

}

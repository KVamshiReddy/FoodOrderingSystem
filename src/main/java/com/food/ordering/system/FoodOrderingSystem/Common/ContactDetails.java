package com.food.ordering.system.FoodOrderingSystem.Common;

import lombok.Data;

import java.util.UUID;

@Data
public class ContactDetails {

    private UUID id;
    private String name;
    private String mobile;
    private String countryCode;
    private String email;
}

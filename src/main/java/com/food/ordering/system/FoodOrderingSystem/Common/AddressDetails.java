package com.food.ordering.system.FoodOrderingSystem.Common;

import lombok.Data;

@Data
public class AddressDetails {
    private String countryName;
    private String stateName;
    private String cityName;
    private String localityName;
    private String addressLine1;
    private String addressLine2;
    private String landmark;
    private String zipCode;
}

package com.food.ordering.system.FoodOrderingSystem.Models;

import com.food.ordering.system.FoodOrderingSystem.Common.AddressDetails;
import com.food.ordering.system.FoodOrderingSystem.Common.CommonConstants;
import com.food.ordering.system.FoodOrderingSystem.Common.ContactDetails;
import com.github.f4b6a3.uuid.UuidCreator;
import lombok.Data;
import org.apache.catalina.LifecycleState;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Data
@Document
public class Restaurant {

    @Id
    private UUID id;
    private String name;
    private String parentName;
    @Transient
    private List<Items> menu;
    private CommonConstants.RESTAURANT_TYPE type;
    private ContactDetails contactDetails;
    private AddressDetails addressDetails;

    public Restaurant(){
        if (this.id == null){
            this.id = UuidCreator.getTimeOrderedWithRandom();
        }
    }

}

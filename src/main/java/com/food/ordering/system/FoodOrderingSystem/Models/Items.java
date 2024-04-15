package com.food.ordering.system.FoodOrderingSystem.Models;

import com.food.ordering.system.FoodOrderingSystem.Common.CommonConstants;
import com.github.f4b6a3.uuid.UuidCreator;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Data
@Document
public class Items {

    @Id
    private UUID foodId;
    private UUID restaurantId;
    private String name;
    private String desc;
    private CommonConstants.FOOD_TYPE foodType;
    private CommonConstants.TYPE type;
    private List<String> image;
    private double actualPrice;
    private double offeredPrice;

    private Items(){
        if (this.foodId == null) {
            this.foodId = UuidCreator.getTimeOrderedWithRandom();
        }
    }

}

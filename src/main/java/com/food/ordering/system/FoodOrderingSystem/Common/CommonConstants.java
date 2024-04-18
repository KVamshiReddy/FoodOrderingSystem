package com.food.ordering.system.FoodOrderingSystem.Common;

import lombok.Data;
import lombok.Getter;

@Data
public class CommonConstants {

    public enum CUSTOMER_TYPE{
        INDIVIDUAL, REPRESENTATIVE
    }

    public enum TYPE{
        BREAKFAST, LUNCH, DINNER, STARTER, SNACKS, DESSERT, DRINKS, ANY
    }

    public enum FOOD_TYPE{
        VEG, NON_VEG, VEGAN, GLUTEN_FREE
    }

    public enum RESTAURANT_TYPE{
        DHABA, CAFE, CLOUD_KITCHEN, BISTRO, PATISSERIE, RESTAURANT
    }

    public enum ORDER_STATUS{
        NEW, PREPARING, PACKED, ENROUTE, DELIVERED, NOT_DELIVERED, CANCELLED
    }

    @Getter
    public enum COUPON_TYPE{
        COUPON_A("CONGO", 0.1), COUPON_B("I_RETURN", 0.2),COUPON_C("TRY_NEW", 0.3);

        private final String name;
        private final double discount;

        COUPON_TYPE(String name, double discount) {
            this.name = name;
            this.discount = discount;
        }

    }
}

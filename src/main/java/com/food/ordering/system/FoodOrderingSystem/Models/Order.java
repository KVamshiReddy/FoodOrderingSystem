package com.food.ordering.system.FoodOrderingSystem.Models;

import com.food.ordering.system.FoodOrderingSystem.Common.CommonConstants;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Document
public class Order {

    @Id
    private UUID orderId;
    @NotNull(message = "Customer is mandatory")
    private UUID customerId;
    @NotNull(message = "Restaurant is mandatory")
    private UUID restaurantId;
    @NotEmpty(message = "At least one item should be there to place an order")
    private List<OrderItems> orderItems;
    private CommonConstants.ORDER_STATUS status;
    private Date createdTimeStamp;
    private Date updatedTimeStamp;


    public Order(){
        if (this.orderId == null){
            this.orderId = UUID.randomUUID();
            this.createdTimeStamp = new Date();
            this.updatedTimeStamp = createdTimeStamp;
        }
    }

}

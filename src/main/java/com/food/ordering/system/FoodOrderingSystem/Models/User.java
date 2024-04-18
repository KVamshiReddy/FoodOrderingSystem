package com.food.ordering.system.FoodOrderingSystem.Models;

import com.food.ordering.system.FoodOrderingSystem.Common.CommonConstants;
import com.food.ordering.system.FoodOrderingSystem.Common.ContactDetails;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Data
@Document
public class User {

    @Id
    private UUID customerId;
    @NotNull
    private ContactDetails contactDetails;
    @NotNull
    private CommonConstants.CUSTOMER_TYPE type;
    private Date createdTimeStamp;
    private Date updatedTimeStamp;

    public User(){
        if (this.customerId == null){
            this.customerId = UUID.randomUUID();
            this.createdTimeStamp = new Date();
            this.updatedTimeStamp = createdTimeStamp;
        }
    }

}

package com.food.ordering.system.FoodOrderingSystem.Repository;

import com.food.ordering.system.FoodOrderingSystem.Models.Items;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ItemRepository extends MongoRepository<Items, UUID> {

    @Query("{'restaurantId':?0}")
    List<Items> itemsByRestaurant(UUID restaurantId);

}

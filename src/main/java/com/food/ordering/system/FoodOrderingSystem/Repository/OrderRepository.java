package com.food.ordering.system.FoodOrderingSystem.Repository;

import com.food.ordering.system.FoodOrderingSystem.Models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends MongoRepository<Order, UUID> {
}

package com.food.ordering.system.FoodOrderingSystem.Repository;

import com.food.ordering.system.FoodOrderingSystem.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends MongoRepository<User, UUID> {
}

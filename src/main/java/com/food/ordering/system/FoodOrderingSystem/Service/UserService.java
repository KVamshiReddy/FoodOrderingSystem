package com.food.ordering.system.FoodOrderingSystem.Service;

import com.food.ordering.system.FoodOrderingSystem.Models.User;
import com.food.ordering.system.FoodOrderingSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

}

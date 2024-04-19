package com.food.ordering.system.FoodOrderingSystem.Service;

import com.food.ordering.system.FoodOrderingSystem.Common.CommonConstants;
import com.food.ordering.system.FoodOrderingSystem.Exceptions.ResourceNotFoundException;
import com.food.ordering.system.FoodOrderingSystem.Models.User;
import com.food.ordering.system.FoodOrderingSystem.Repository.UserRepository;
import com.mongodb.client.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public String deleteUser(UUID customerId){
        Optional<User> existinguser = userRepo.findById(customerId);
        if (existinguser.isEmpty()){
            throw new ResourceNotFoundException("user doesn't exist",799);
        }
        else{
            userRepo.delete(existinguser.get());
            return "User is deleted successfully";
        }
    }


    public User getUser(UUID customerId) {
        Optional<User> userOptional = userRepo.findById(customerId);
        if (userOptional.isPresent()){
            return userOptional.get();
        }
        else {
            throw new ResourceNotFoundException("User not found",700);
        }

    }
}

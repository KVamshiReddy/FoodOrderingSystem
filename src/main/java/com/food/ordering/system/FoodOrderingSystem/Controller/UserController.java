package com.food.ordering.system.FoodOrderingSystem.Controller;

import com.food.ordering.system.FoodOrderingSystem.Common.Response;
import com.food.ordering.system.FoodOrderingSystem.Models.User;
import com.food.ordering.system.FoodOrderingSystem.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

//    @Operation(summary = "Create or Update a User")
//    @PostMapping(path = "")
//    public Response createUser(@Validated @RequestBody User data){
//        return new Response(userService.createUser(data));
//    }

}

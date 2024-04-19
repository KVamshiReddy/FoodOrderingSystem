package com.food.ordering.system.FoodOrderingSystem.Controller;

import com.food.ordering.system.FoodOrderingSystem.Common.Response;
import com.food.ordering.system.FoodOrderingSystem.Models.User;
import com.food.ordering.system.FoodOrderingSystem.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Create or Update a User")
    @PostMapping(path = "")
    public Response createUser(@Validated @RequestBody User user){
        return new Response(userService.createUser(user));
    }

    @DeleteMapping(path = "")
    public Response deleteUser(@RequestParam UUID customerId){
        return new Response(userService.deleteUser(customerId));
    }
    @GetMapping(path = "")
    public Response getUser(@RequestParam UUID customerId){
        return new Response(userService.getUser(customerId));
    }

}

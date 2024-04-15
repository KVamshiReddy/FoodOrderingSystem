package com.food.ordering.system.FoodOrderingSystem.Controller;

import com.food.ordering.system.FoodOrderingSystem.Common.Response;
import com.food.ordering.system.FoodOrderingSystem.Models.Restaurant;
import com.food.ordering.system.FoodOrderingSystem.RestaurantSearchRequest;
import com.food.ordering.system.FoodOrderingSystem.Service.RestaurantService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @Operation(summary = "Create a new Restaurant")
    @PostMapping(path = "/create")
    public Response createRestaurant(@RequestBody Restaurant data){
        return new Response(restaurantService.createRestaurant(data));
    }

//    @Operation(summary = "Get Restaurant With Menu")
//    @GetMapping(path = "/search")
//    public Response getRestaurant(@RequestBody RestaurantSearchRequest data){
//        return new Response(restaurantService.getRestaurant(data));
//    }

    @Operation(summary = "Get Restaurant Specific Menu")
    @GetMapping(path = "/menu")
    public Response getRestaurant(@RequestParam UUID restaurantId){
        return new Response(restaurantService.getRestaurantMenu(restaurantId));
    }

}

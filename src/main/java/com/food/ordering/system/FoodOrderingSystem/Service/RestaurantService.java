package com.food.ordering.system.FoodOrderingSystem.Service;

import com.food.ordering.system.FoodOrderingSystem.Exceptions.ResourceNotFoundException;
import com.food.ordering.system.FoodOrderingSystem.Models.Items;
import com.food.ordering.system.FoodOrderingSystem.Models.Restaurant;
import com.food.ordering.system.FoodOrderingSystem.Repository.ItemRepository;
import com.food.ordering.system.FoodOrderingSystem.Repository.RestaurantRepo;
import com.food.ordering.system.FoodOrderingSystem.RestaurantSearchRequest;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Service
public class RestaurantService {

    private static final String RestaurantRepoName = "RestaurantRepo";

    @Autowired
    private RestaurantRepo restaurantRepo;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private MongoOperations mongoOperations;

    public Restaurant createRestaurant(Restaurant data){
        data.setParentName(data.getParentName().toUpperCase());
        for (Items item : data.getMenu()){
            item.setRestaurantId(data.getId());
            itemRepository.save(item);
        }
        return restaurantRepo.save(data);
    }

//    public List<Restaurant> getRestaurant(@RequestBody RestaurantSearchRequest data){
//        Query query = new Query();
//        if (data.getRestaurantId() != null){
//            query.addCriteria(Criteria.where("id").in(data.getRestaurantId()));
//        }
//        if (!TextUtils.isBlank(data.getSearchText())){
//            query.addCriteria(Criteria.where("name").regex(data.getSearchText(), "i"));
//        }
//        List<Restaurant> restaurants = mongoOperations.find(query, Restaurant.class, RestaurantRepoName);
//        for (Restaurant restaurant : restaurants){
//            List<Items> items = getRestaurantMenu(restaurant.getId());
//            restaurant.setMenu(items);
//        }
//        return restaurants;
//    }

    public List<Items> getRestaurantMenu(@RequestParam UUID restId){
        if (restId != null){
            return itemRepository.itemsByRestaurant(restId);
        }
        else {
            throw new ResourceNotFoundException("Could Not Find The Restaurant", 1000);
        }
    }

}

package com.food.ordering.system.FoodOrderingSystem.Service;

import com.food.ordering.system.FoodOrderingSystem.Common.ListResponse;
import com.food.ordering.system.FoodOrderingSystem.Exceptions.ResourceNotFoundException;
import com.food.ordering.system.FoodOrderingSystem.Models.Items;
import com.food.ordering.system.FoodOrderingSystem.Models.Restaurant;
import com.food.ordering.system.FoodOrderingSystem.Repository.ItemRepository;
import com.food.ordering.system.FoodOrderingSystem.Repository.RestaurantRepo;
import com.food.ordering.system.FoodOrderingSystem.RestaurantSearchRequest;
import org.apache.http.ParseException;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
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
    private MongoTemplate mongoTemplate;

    public Restaurant createRestaurant(Restaurant data){
        data.setParentName(data.getParentName().toUpperCase());
        for (Items item : data.getMenu()){
            item.setRestaurantId(data.getId());
            itemRepository.save(item);
        }
        data.getContactDetails().setId(data.getId());
        return restaurantRepo.save(data);
    }

    public ListResponse getRestaurant(RestaurantSearchRequest data) throws ParseException {
        long count = 0;
        Sort sort = Sort.by("name");
        Pageable pageable = PageRequest.of(data.getPageNo(), data.getSize(), sort);
        Query query = new Query();
        List<Criteria> criteriaList = new ArrayList<>();
        if (data.getRestaurantId() != null){
            criteriaList.add(Criteria.where("id").in(data.getRestaurantId()));
        }
        if (!TextUtils.isBlank(data.getSearchText())){
            criteriaList.add(new Criteria().orOperator(Criteria.where("name").regex(data.getSearchText(), "i"),
                    Criteria.where("parentName").regex(data.getSearchText(), "i")));
        }
        if (data.getType() != null){
            criteriaList.add(Criteria.where("type").is(data.getType()));
        }
        if (!criteriaList.isEmpty()){
            query.addCriteria( new Criteria().andOperator(criteriaList.toArray(new Criteria[criteriaList.size()])));
        }
        count = mongoTemplate.count(query, Restaurant.class);
        query.with(pageable);
        List<Restaurant> restaurants = mongoTemplate.find(query, Restaurant.class);
        for (Restaurant restaurant : restaurants){
            List<Items> items = getRestaurantMenu(restaurant.getId());
            restaurant.setMenu(items);
        }
        ListResponse listResponse = new ListResponse(restaurants, count);
        return listResponse;
    }

    public List<Items> getRestaurantMenu(@RequestParam UUID restId){
        if (restId != null){
            return itemRepository.itemsByRestaurant(restId);
        }
        else {
            throw new ResourceNotFoundException("Could Not Find The Restaurant", 1000);
        }
    }

}

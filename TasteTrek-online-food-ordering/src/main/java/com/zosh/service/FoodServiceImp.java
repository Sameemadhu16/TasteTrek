package com.zosh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zosh.model.Category;
import com.zosh.model.Food;
import com.zosh.model.Restaurant;
import com.zosh.repository.FoodRepository;
import com.zosh.request.CreateFoodRequest;



public class FoodServiceImp implements FoodService{

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant) {

        Food food = new Food();
        food.setFoodcategory(category);
        food.setRestaurant(restaurant);
        food.setDescription(req.getDescription());
        food.setImages(req.getImages());
        food.setName(req.getName());
        food.setPrice(req.getPrice());
        food.setIngrediants(req.getIngredients());
        food.setSeasonal(req.isSeasional());
        food.setVegetarian(req.isvegtarain());
        
        Food saveFood = foodRepository.save(food);

        
        restaurant.getFoods().add(saveFood);
        return saveFood;
    }

    @Override
    public void deleteFood(Long foodId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Food> getRestaurantsFood(Long restaurantId, boolean isvegtarain, boolean isNonveg, boolean isSeasonal, String foodCategory) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Food> searchFood(String keyword) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Food findFoodById(Long foodId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Food updateAvailabilityStatus(Long foodId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

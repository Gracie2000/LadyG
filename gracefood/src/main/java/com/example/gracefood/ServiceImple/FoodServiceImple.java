package com.example.gracefood.ServiceImple;

import com.example.gracefood.Entity.Food;
import com.example.gracefood.Exception.FoodException;
import com.example.gracefood.Repository.FoodRepository;
import com.example.gracefood.Service.Foodservice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImple implements Foodservice {
    private FoodRepository foodRepository;

    public FoodServiceImple(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public Food addfood(Food food) {

        return foodRepository.save(food);
    }

    @Override
    public List<Food> getAllfoods() {
        return foodRepository.findAll();
    }

    @Override
    public Food getfoodById(Long id) {
    Food food = foodRepository.findById(id)
            .orElseThrow(()->new FoodException("food not found"));
        return food;
    }

    @Override
    public Food updatefood(Long id, Food food) {
        Food existingfood =foodRepository.findById(id)
                .orElseThrow(()->new FoodException("food not found"));
        existingfood.setFood_id(food.getFood_id());
        existingfood.setFood_name(food.getFood_name());
        existingfood.setFood_desc(food.getFood_desc());
        existingfood.setFood_type(food.getFood_type());
        existingfood.setFood_order(food.getFood_order());
        existingfood.setFood_price(food.getFood_price());
        Food updateFood =foodRepository.save(existingfood);

        return updateFood;
    }

    @Override
    public void deletefood(Long id) {
        Food deleteFood =foodRepository.findById(id)
                .orElseThrow(()->new FoodException("food not found"));
        foodRepository.delete(deleteFood);
    }
}

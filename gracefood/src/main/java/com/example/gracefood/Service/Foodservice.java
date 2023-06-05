package com.example.gracefood.Service;

import com.example.gracefood.Entity.Food;

import java.util.List;

public interface Foodservice {
   //create
    Food addfood(Food food);
     //read get all foods
    List<Food> getAllfoods();
    //get food by id
    Food getfoodById(Long id);
    //update
    Food updatefood(Long id, Food food);
    //delete
    void deletefood(Long id);


}

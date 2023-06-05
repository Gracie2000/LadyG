package com.example.gracefood.Controller;

import com.example.gracefood.Entity.Food;
import com.example.gracefood.Service.Foodservice;
import org.springframework.data.util.CustomCollectionRegistrar;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/g/food Table")
public class FoodController {

    private Foodservice foodservice;

    public FoodController(Foodservice foodservice) {
        this.foodservice = foodservice;
    }

    //add food
    @PostMapping
    public ResponseEntity<Food> addFood(@RequestBody Food food) {
        Food add = foodservice.addfood(food);
        return new ResponseEntity<>(add, HttpStatus.CREATED);
    }

    //get all customers
    @GetMapping()
    public List<Food> getAllFoods() {
        return foodservice.getAllfoods();
    }

    //get food by id
    @GetMapping("{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable Long id) {
        return new ResponseEntity<>(foodservice.getfoodById(id), HttpStatus.OK);


    }

    //update food by id
    @PutMapping("{id}")
    public ResponseEntity<Food> update(@PathVariable Long id, @RequestBody Food food) {
        return new ResponseEntity<>(foodservice.updatefood(id, food), HttpStatus.OK);
    }

    //delete
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFood(@PathVariable Long id) {
        foodservice.deletefood(id);
        return new ResponseEntity<>("food deleted", HttpStatus.OK);
    }
}
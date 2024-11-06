package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.City;
import com.example.demo.entity.Restaurant;
import com.example.demo.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
	
	@Autowired
	RestaurantService restaurantService;
	
	@GetMapping("/findAll")
	public List<Restaurant> findAll(){
		return restaurantService.findAll();
	}
	
	/*@GetMapping("/findAll")
    public ResponseEntity<List<Restaurant>> findAll() {
        List<Restaurant> restaurants = restaurantService.findAll();
        return ResponseEntity.ok(restaurants);
    }*/
	
	@GetMapping("/findById/{id}")
	public Optional<Restaurant> findById(@PathVariable int id){
		return restaurantService.findById(id);
	}
	
	@PostMapping("/save")
	public void save(@RequestBody Restaurant restaurant) {
		restaurantService.save(restaurant);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		restaurantService.delete(id);
	}
	
	@PutMapping("/update/{id}")
	public void update(@RequestBody Restaurant restaurant, @PathVariable int id) {
		restaurantService.update(restaurant, id);
	}
	
	@GetMapping("/findByCity/{cityName}")
    public ResponseEntity<List<Restaurant>> findByCityName(@PathVariable String cityName) {
        List<Restaurant> restaurants = restaurantService.findRestaurantsByCityName(cityName);
        if (restaurants.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(restaurants);
    }
	
	
	
	
	
	
	
	
	
}

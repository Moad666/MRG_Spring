package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	
	
	
	
	
	
	
	
}

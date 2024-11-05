package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.City;
import com.example.demo.entity.Restaurant;
import com.example.demo.repository.CityRepository;
import com.example.demo.repository.RestaurantRepository;

@Service
public class RestaurantService {
	
	@Autowired
	RestaurantRepository restaurantRepository;
	
	 @Autowired
	 private CityRepository cityRepository;
	
	
	public List<Restaurant> findAll(){
		return restaurantRepository.findAll();
	}
	
	public void save(Restaurant restaurant) {
		if (restaurant.getCity() != null && restaurant.getCity().getId() > 0) {
            City city = cityRepository.findById(restaurant.getCity().getId()).orElse(null);
            
            if (restaurant != null) {
            	restaurant.setCity(city);
            }
        }
		restaurantRepository.save(restaurant);
	}
	
	public Optional<Restaurant> findById(int id) {
		return restaurantRepository.findById(id);
	}
	
	public void delete(int id) {
		restaurantRepository.deleteById(id);
	}
	
	public void update(Restaurant restaurant, int id) {
		Optional<Restaurant> rest = restaurantRepository.findById(id);
		if(rest.isPresent()) {
			Restaurant existRest = rest.get();
			
			existRest.setName(restaurant.getName());
			existRest.setAverageRating(restaurant.getAverageRating());
			existRest.setDescription(restaurant.getDescription());
			existRest.setFermer(restaurant.getFermer());
			existRest.setOuvert(restaurant.getOuvert());
			existRest.setImage(restaurant.getImage());
			existRest.setPhone(restaurant.getPhone());
			existRest.setLocation(restaurant.getLocation());
			existRest.setCity(restaurant.getCity());
			
			restaurantRepository.save(existRest);
		}else {
			System.out.println("Restaurant with ID " + id + " not found.");
		}
	}
	
	
	

}

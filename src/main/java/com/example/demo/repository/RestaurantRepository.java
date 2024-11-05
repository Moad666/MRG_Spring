package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.City;
import com.example.demo.entity.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{
	
	@Query("SELECT r FROM Restaurant r WHERE r.city.name = ?1")
    List<Restaurant> findByCityName(String cityName);

}

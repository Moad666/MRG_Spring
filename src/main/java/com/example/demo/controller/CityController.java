package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.City;
import com.example.demo.service.CityService;

@RestController
@RequestMapping("/city")
public class CityController {
	
	@Autowired
	CityService cityservice;
	
	@GetMapping("/findAll")
	public List<City> findAll(){
		return cityservice.findAll();
	}
	
	@PostMapping("/save")
	public void save(@RequestBody City city) {
		cityservice.save(city);
	}

	
	
	
	
}

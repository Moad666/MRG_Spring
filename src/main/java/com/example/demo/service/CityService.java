package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.City;
import com.example.demo.repository.CityRepository;

@Service
public class CityService {
	
	@Autowired
	CityRepository cityrepository;
	
	public List<City> findAll(){
		return cityrepository.findAll();
	}
	
	public void save(City city) {
		cityrepository.save(city);
	}

}

package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/admin")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PutMapping("/update")
    public ResponseEntity<String> updateUserRole(@RequestParam Long userId, 
                                                 @RequestParam String roleName) {
        userService.update(userId, roleName);
        return ResponseEntity.ok("User role updated");
    }
	
	@GetMapping("/findAll")
	public List<User> findAll(){
		return userService.findAll();
	}
	
	@GetMapping("/findById/{userId}")
	public UserDTO findById(@PathVariable Long userId){
		return userService.findById(userId);
	}

}

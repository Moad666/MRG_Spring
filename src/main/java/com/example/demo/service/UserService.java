package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.UserDTO;
import com.example.demo.entity.AppRole;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userrepository;
	
	@Autowired
	RoleRepository rolerepository;
	
	public void update(Long userId, String roleName) {
		User user = userrepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
		AppRole appRole = AppRole.valueOf(roleName);
        Role role = rolerepository.findByroleName(appRole)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        user.setRole(role);
        userrepository.save(user);
		
	}
	
	public List<User> findAll(){
		return userrepository.findAll();
	}
	
	public UserDTO findById(Long userId){
		//return adminrepository.findById(userId);
		User user = userrepository.findById(userId).orElseThrow();
        return convertToDto(user);
	}
	
	private UserDTO convertToDto(User user) {
        return new UserDTO(
                user.getUserId(),
                user.getUserName(),
                user.getEmail(),              
                user.getRole()
        );
    }
	
	public User findByUsername(String username) {
        Optional<User> user = userrepository.findByuserName(username);
        return user.orElseThrow(() -> new RuntimeException("User not found with username: " + username));
    }

}

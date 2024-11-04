package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.AppRole;
import com.example.demo.entity.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
	
	Optional<Role> findByroleName(AppRole appRole);
}

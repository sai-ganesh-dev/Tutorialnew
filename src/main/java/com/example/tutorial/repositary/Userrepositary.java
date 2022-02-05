package com.example.tutorial.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tutorial.entity.User;

@Repository
public interface Userrepositary extends JpaRepository<User,Integer> {
	
	

}

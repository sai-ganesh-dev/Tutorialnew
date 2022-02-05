package com.example.tutorial.service;

import java.util.List;
import com.example.tutorial.entity.User;



public interface Userservice  {
	
	public abstract void create(User user);
	public abstract List<User> getall();

	
	
	
	

}

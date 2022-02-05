package com.example.tutorial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.tutorial.entity.User;
import com.example.tutorial.repositary.Userrepositary;

import org.springframework.data.domain.Sort;

@Service
public class UserserviceImpl implements Userservice {
	
	@Autowired
	private Userrepositary userrepo;

	@Override
	public void create(User user) {
		
		userrepo.save(user);
	}

	@Override
	public List<User> getall() {
	
		return userrepo.findAll();
	}
	
	public List<User> findUsersWithSorting(String field){
        return  userrepo.findAll(Sort.by(Sort.Direction.ASC,field));
    }


    public Page<User> findusersWithPagination(int offset,int pageSize){
        Page<User> users = userrepo.findAll(PageRequest.of(offset, pageSize));
        return  users;
    }

    public Page<User> findProductsWithPaginationAndSorting(int offset,int pageSize,String field){
        Page<User> users = userrepo.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
        return  users;
    }

}

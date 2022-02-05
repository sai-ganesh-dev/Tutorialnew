package com.example.tutorial.controller;

import java.util.List;

import org.apache.tomcat.jni.Thread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tutorial.common.Apiresponse;
import com.example.tutorial.common.Apiresponse1;
import com.example.tutorial.entity.User;
import com.example.tutorial.service.Userservice;
import com.example.tutorial.service.UserserviceImpl;

@Validated
@RestController
@RequestMapping("/rest/users")
public class Usercontroller {
	
	@Autowired
	private Userservice userservice;
	@Autowired
	public  UserserviceImpl userimpl ;
	
	//@valid this is used for the validate the object if it fails return 400 bad request and MethodArgumentNotValidException would get in client side
	@PostMapping("/create")
	public  ResponseEntity<Apiresponse>  create(@RequestBody User user){
		
		      userservice.create(user);
		
		return  new ResponseEntity<Apiresponse>(new Apiresponse(true, "created successfully."),HttpStatus.CREATED );
		
	}
	
	@GetMapping("/getall")
	public ResponseEntity<List<User>> getusers(){
		
		List<User> list = userservice.getall();
		
		
		return  new ResponseEntity<List<User>>(list,HttpStatus.OK);
		
		}
	@GetMapping("/{field}")
    private List<User> getProductsWithSort(@PathVariable String field) {
        List<User> allProducts = userimpl.findUsersWithSorting(field);
        //return  new Apiresponse1()<>(allProducts.size(),allProducts);
        
        return allProducts;
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    private Page<User>  getProductsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
        Page<User> productsWithPagination = userimpl.findusersWithPagination(offset, pageSize);
        return   productsWithPagination;
    }

    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
    private Page<User> getProductsWithPaginationAndSort(@PathVariable int offset, @PathVariable int pageSize,@PathVariable String field) {
        Page<User> productsWithPagination = userimpl.findProductsWithPaginationAndSorting(offset, pageSize, field);
        return  productsWithPagination;
    }
	

}

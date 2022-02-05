package com.example.tutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.tutorial.entity.Product;
import com.example.tutorial.service.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {
	
	       
	
	@Autowired
	ProductService productservice;
	
	@RequestMapping(value ="/saveproducts",method = RequestMethod.POST)
	public ResponseEntity<Object> createproduct(@RequestBody Product product) {
		
		productservice.createproduct(product);
		
		
		return  new  ResponseEntity<>("product created successfull",HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value ="/getproduct",method =RequestMethod.GET)
	public ResponseEntity<Object> getproduct(){
		
	 return  new ResponseEntity<>( productservice.selectproduct(),HttpStatus.OK);
		
     }
	@RequestMapping(value ="/updateproduct/{id}",method =RequestMethod.PUT)
	public ResponseEntity<Object> updateproduct(@PathVariable("id") Integer id,@RequestBody Product product){
		
		productservice.updateproduct(id, product);
		
		return  new ResponseEntity<Object>("product updates successfully",HttpStatus.OK);
		
		
	}
	
	@RequestMapping(value ="/deleteproduct/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteproduct(@PathVariable("id") Integer id){
		
		productservice.deleteproduct(id);
		
		return new ResponseEntity<Object>("Product deleted successfully", HttpStatus.OK);
		
	}
	
	
	
	
}

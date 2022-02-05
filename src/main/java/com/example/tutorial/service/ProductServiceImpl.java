package com.example.tutorial.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.example.tutorial.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	
 private static Map<Integer,Product> map = new HashMap<Integer,Product>();
  static {
	 
	  Product p1 = new Product();
	  
	  p1.setId(1);
	  p1.setName("sai");
	  
	  map.put(p1.getId(), p1);
	  Product p2 = new Product();
	  
	  p2.setId(2);
	  p2.setName("ganesh");
	  
	  map.put(p2.getId(), p2);
	  
         }
	

	@Override
	public void createproduct(Product product) {
		
		
		map.put(product.getId(), product);
		
	}

	@Override
	public Collection<Product> selectproduct() {
		
		return map.values() ;
	}

	@Override
	public void updateproduct(Integer id, Product product) {
		
	  map.remove(id);
	  product.setId(id);
	  map.put(id, product);
	  
		
		
	}

	@Override
	public void deleteproduct(Integer id) {
		
		map.remove(id);
	}
	
	
	

	
	
	
}

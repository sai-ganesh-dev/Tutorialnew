package com.example.tutorial.service;

import java.util.Collection;
import com.example.tutorial.entity.Product;

public interface ProductService {
	
	public abstract void createproduct(Product product);
	public abstract Collection<Product> selectproduct();
	public abstract void updateproduct(Integer id,Product product);
	public abstract void deleteproduct(Integer id);

}

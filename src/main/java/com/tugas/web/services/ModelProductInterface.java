package com.tugas.web.services;

import java.util.List;

import com.tugas.web.entity.Product;

public interface ModelProductInterface {
	
	public List<Product> getAllProduct();
	public String addProduct (Product product);
	public List<Product> getProductByName(String name);
	public Product getByIdProduct(String id);
	public String deletePoroductById(String id);

}

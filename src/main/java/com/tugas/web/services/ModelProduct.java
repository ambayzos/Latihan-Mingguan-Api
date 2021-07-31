package com.tugas.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tugas.web.entity.Product;
import com.tugas.web.repository.ProductRepository;

@Service
public class ModelProduct implements ModelProductInterface {
	
	@Autowired ProductRepository productRepo;

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return this.productRepo.findAll();
	}

	@Override
	public String addProduct(Product product) {
		// TODO Auto-generated method stub
		this.productRepo.save(product);
		return "Berhasil memasukan data";
	}

}

package com.tugas.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tugas.web.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query(value = "Select * from product where nama_product LIKE %?1%",nativeQuery = true)
	List<Product>  findProductByName(String name);
	

}

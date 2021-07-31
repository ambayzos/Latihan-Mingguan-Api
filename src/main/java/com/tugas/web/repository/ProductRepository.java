package com.tugas.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tugas.web.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

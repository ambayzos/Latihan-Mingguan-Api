package com.tugas.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tugas.web.entity.Product;
import com.tugas.web.entity.ResponseProduct;
import com.tugas.web.services.ModelProduct;

@RestController
@RequestMapping("/variant")
public class ProductController {
	
	@Autowired
	ModelProduct modelPeserta;
	
	@GetMapping("/")
	public ResponseEntity<ResponseProduct> getAll(){
		
		ResponseProduct response = new ResponseProduct();
		
		response.setStatusCode(200);
		response.setPesan("Berhasil memasukan data");
		response.setData(this.modelPeserta.getAllProduct());
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(response);
		
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<ResponseProduct> addData (@RequestBody Product product){
		
		ResponseProduct response = new ResponseProduct();
		
		response.setStatusCode(200);
		response.setPesan("Berhasil memasukan data");
		response.setData(this.modelPeserta.addProduct(product));
		
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(response);

	}
	
	

}

package com.tugas.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.tugas.web.entity.Product;
import com.tugas.web.services.ModelProduct;
import com.tugas.web.utility.FileUtility;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ModelProduct modelProduct;
	
	@GetMapping("/")
	public ResponseEntity<List<Product>> getAll(){
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(this.modelProduct.getAllProduct());

	}
	
	@PostMapping("/add")
	public String addProduct(@RequestParam(value = "file") MultipartFile images, @ModelAttribute(value = "data") String dataJson) throws IOException{
		
		String filename = StringUtils.cleanPath(images.getOriginalFilename());
		
		
		String uploadDir ="src/main/java/user-photos/";
		FileUtility.saveFile(uploadDir, filename, images);
		Product product = new Gson().fromJson(dataJson, Product.class);
		product.setImage_url(filename);
		return this.modelProduct.addProduct(product);
	}
	
	@GetMapping(value ="/image/{name}", produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] getImageWithMediaType(@PathVariable String name) throws IOException{
		final InputStream in = getClass().getResourceAsStream("/user-photos/"+name);
				return IOUtils.toByteArray(in);
	}

	@GetMapping("/{name}")
	public List<Product> getProductByName(@PathVariable String name){
		return this.modelProduct.getProductByName(name);
	}
	
	@GetMapping("/id/{id}")
	public Product getProductById(@PathVariable String id) {
		return this.modelProduct.getByIdProduct(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteData(@PathVariable String id){
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.APPLICATION_JSON)
				.body(this.modelProduct.deletePoroductById(id));
	} 
	

}

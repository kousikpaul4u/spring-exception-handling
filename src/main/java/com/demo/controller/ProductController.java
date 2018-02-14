package com.demo.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.domain.Product;
import com.demo.exception.ResourceNotFoundException;

@RequestMapping("/product")
@Controller
public class ProductController {
	
	@RequestMapping("/ping")
	@ResponseBody
	public String ping() {
		return "Ping Successful on " + new Date();
	}
	
	@GetMapping(value = "all")
	public ResponseEntity<Product> getProduct() {
		Product product = null;
		product = new Product();
		product.setId(24234);
		product.setProductName("Bluedio Wireless Headphone");
		product.setProductType("Headphone");
		product.setQuantity(400);
		String a = null;
		System.out.println(a.toString());
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
	@GetMapping(value = "detail/{productId}")
	public ResponseEntity<Product> getProduct2(@PathVariable Integer productId) {
		if(null == productId || productId <= 0) {
			throw new ResourceNotFoundException("productId is null");
		}
		Product product = new Product();
		product.setId(productId);
		product.setProductName("Bluedio Wireless Headphone");
		product.setProductType("Headphone");
		product.setQuantity(400);
		
		return new ResponseEntity<>(product, HttpStatus.OK);
		
	}
}

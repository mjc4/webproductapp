package com.products;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.products.model.Product;
import com.products.repository.ProductRepository;

@SpringBootApplication
public class WebproductsApplication implements CommandLineRunner{

	@Autowired
    ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(WebproductsApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception { 
		
		productRepository.save(new Product("Macbook","This is the description of this Macbook", 1200.34));
		productRepository.save(new Product("iPad","This is the description of this iPad", 230.45));
		productRepository.save(new Product("iPhone","This is the description of this iPhone", 750.35));
		productRepository.save(new Product("Smartphone","This is the description of this Smartphone: Samsung Galaxy S10", 600.25));
	}

}

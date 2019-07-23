package com.products.repository;

import org.springframework.data.repository.CrudRepository;

import com.products.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

}

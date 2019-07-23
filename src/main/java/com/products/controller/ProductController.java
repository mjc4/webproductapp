package com.products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.products.model.Customer;
import com.products.model.Product;
import com.products.repository.ProductRepository;

@Controller
public class ProductController {
	
	@Autowired
	ProductRepository repository;
	
	@GetMapping(value="/products")
	public String productsList(Model model) {
		model.addAttribute("products", repository.findAll());
		return "products";
	}
	
	@GetMapping(value="/product/{id}")
	public String getProduct(@PathVariable Long id, Model model) {
		model.addAttribute("product", repository.findById(id).orElse(null));
		return "product";
	}
	
	@PostMapping(value="/cart/{id}")
	public String addToCart(@PathVariable Long id, Model model) {
    	
		//get the current Customer instance
		Customer instance = Customer.getInstance();
		
		// get the product 
		Product product = repository.findById(id).get();
				
		if(product != null) {
			// add the product to the cart
			instance.getCart().add(product);
			model.addAttribute("message", "Produit ajouté au panier !");
		} else {
			model.addAttribute("message", "Le panier est vide !");
		}
		
		// return the cart to the view
        model.addAttribute("cart", instance.getCart());
        
        return "redirect:/cart";
        
    }
	
	@GetMapping(value="/cart")
	public String cart(Model model) {
		//get the current Customer instance
		Customer instance = Customer.getInstance();
		
		if(instance.getCart().isEmpty())
			model.addAttribute("message", "Le panier est vide !");
		
		model.addAttribute("cart", instance.getCart());
		
		return "cart";
	}

}

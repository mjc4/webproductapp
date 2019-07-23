package com.products.model;

import java.util.ArrayList;


public class Customer {
	
	// static variable single_instance of type Customer 
    private static Customer singleInstance = null; 
	
	private ArrayList<Product> cart;
	
	public Customer() {
		// TODO Auto-generated constructor stub
		this.cart = new ArrayList<Product>();
	}
	
	// this method always return the same instance of the Customer Object
	public static Customer getInstance() {
		
		if(singleInstance == null) {
			
			singleInstance = new Customer();
		}
		
		return singleInstance;
	}
	
	public ArrayList<Product> getCart() {
		return cart;
	}
	
	public void setCart(ArrayList<Product> cart) {
		this.cart = cart;
	}

}

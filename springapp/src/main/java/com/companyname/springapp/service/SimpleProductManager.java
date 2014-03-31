package com.companyname.springapp.service;

import java.util.List;

import com.companyname.springapp.domain.Product;

public class SimpleProductManager implements ProductManager{

	//numero de serie dos ficheiros, para saber qual classe os criou.
	private static final long serialVersionUID = 1L;
	private List<Product> products;

	public void increasePrice(int percentage) {
		//quando o metodo ainda nao foi implementado é uma boa opçao retornar um UnsupportedOperationException(); 
	
			if (products != null) {
	            for (Product product : products) {
	                double newPrice = product.getPrice().doubleValue() * 
	                                    (100 + percentage)/100;
	                product.setPrice(newPrice);
	            }
	        }
	}

	public List<Product> getProducts() {
		return products; 
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;     
    }
}

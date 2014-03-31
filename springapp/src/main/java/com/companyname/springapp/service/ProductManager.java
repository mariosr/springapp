package com.companyname.springapp.service;

import java.io.Serializable;
import java.util.List;

import com.companyname.springapp.domain.Product;
/*
 * en la camada de servicio hay q hacer una interfaz porque el uso de interfaces implica 
 * que JDK Proxying (una caracter�stica del lenguaje Java) puede ser usada para hacer el 
 * servicio transaccional, en lugar de usar CGLIB (una librer�a de generaci�n de c�digo).
 * */

public interface ProductManager extends Serializable{

	public void increasePrice(int percentage);
    
    public List<Product> getProducts();
	
	
}

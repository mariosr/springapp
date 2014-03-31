package com.companyname.springapp.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.companyname.springapp.domain.Product;

public class SimpleProductManagerTests {

	private SimpleProductManager productManager;

	private List<Product> products;

	private static int PRODUCT_COUNT = 2;

	private static Double CHAIR_PRICE = new Double(20.50);
	private static String CHAIR_DESCRIPTION = "Chair";

	private static String TABLE_DESCRIPTION = "Table";
	private static Double TABLE_PRICE = new Double(150.10);

	private static int POSITIVE_PRICE_INCREASE = 10;

	@Before
	public void setUp() throws Exception {
		productManager = new SimpleProductManager();
		products = new ArrayList<Product>();

		// stub up a list of products
		Product product = new Product();
		product.setDescription("Chair");
		product.setPrice(CHAIR_PRICE);
		products.add(product);

		Product product2 = new Product();
		product2.setDescription("Table");
		product2.setPrice(TABLE_PRICE);
		products.add(product2);

		productManager.setProducts(products);

	}
	
	@Test
	public void testGetProductsWithNoProducts() {
		assertNotNull(productManager.getProducts());
	}

	@Test
	public void testGetProducts() {
		
		List<Product> products = productManager.getProducts();
		assertNotNull(products);
		assertEquals(PRODUCT_COUNT, productManager.getProducts().size());

		Product product = products.get(0);
		assertEquals(CHAIR_DESCRIPTION, product.getDescription());
		assertEquals(CHAIR_PRICE, product.getPrice());

		product = products.get(1);
		assertEquals(TABLE_DESCRIPTION, product.getDescription());
		assertEquals(TABLE_PRICE, product.getPrice());
	}

	@Test
	public void testIncreasePriceWithNullListOfProducts() {

		try {
			SimpleProductManager productManager2 = new SimpleProductManager();
			productManager2.increasePrice(POSITIVE_PRICE_INCREASE);
			assertNotNull(productManager.getProducts());
			

		} catch (NullPointerException ex) {
			fail("Lista de Produtos nula");
		}
	}

	@Test
	public void testIncreasePriceWithEmptyListOfProducts() {

		try {
			productManager.increasePrice(POSITIVE_PRICE_INCREASE);
			assertNotEquals(productManager.getProducts().size(),0 , 0);

		} catch (Exception e) {
			fail("Você tentou incrementar o preço em uma lista sem produtos !");
		}
	}

	//metodo responsavel por testar se o percentual foi realmente incrementado
	@Test
	public void testIncreasePriceWithPositivePercentage(){
	
			productManager.increasePrice(POSITIVE_PRICE_INCREASE);
			Double produto1 = productManager.getProducts().get(0).getPrice();
			Double produto2 = productManager.getProducts().get(1).getPrice();
			//o terceiro valor é o delta, serve para dizer o quao EXATO você deseja que os numeros sejam iguais
			assertEquals(22.55, produto1, 0);
			assertEquals(165.11, produto2, 0);
	}
}
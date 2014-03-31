package com.companyname.springapp.repository.jpa;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.companyname.springapp.domain.Product;
import com.companyname.springapp.repository.ProductDao;

public class JPAProductDaoTests {
	
	private ApplicationContext context;
    private ProductDao productDao;

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("classpath:test-context.xml");
        productDao = (ProductDao) context.getBean("productDao");
    }
    
    @Test
    public void testGetProductList(){
    	List<Product> products = productDao.getProductList();
    	// até no momento existem 3 produtos no meu arquivo populate
    	assertEquals(products.size(), 3, 0);
    }
    
}

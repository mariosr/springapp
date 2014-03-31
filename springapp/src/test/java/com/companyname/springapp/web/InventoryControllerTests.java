package com.companyname.springapp.web;

import static org.junit.Assert.*;
import java.util.Map;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.companyname.springapp.service.SimpleProductManager;


public class InventoryControllerTests {

    @Test
    public void testHandleRequestView() throws Exception{		
        
    	InventoryController controller = new InventoryController();
        controller.setProductManager( new SimpleProductManager());

        ModelAndView modelAndView = controller.handleRequest(null, null);
        
        assertNotNull(modelAndView.getModel());
        //verificando se ele me retorna a view home.jsp
        assertEquals("home", modelAndView.getViewName());
        
        @SuppressWarnings("unchecked")
        Map<String, Object> modelMap = (Map<String, Object>) modelAndView.getModel().get("model");
        assertNotNull(modelMap.get("now").toString());
        
    }

}
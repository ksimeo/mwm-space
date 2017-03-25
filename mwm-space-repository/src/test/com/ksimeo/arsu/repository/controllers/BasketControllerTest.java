package com.ksimeo.arsu.repository.controllers;

import com.ksimeo.arsu.entities.models.*;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Ksimeo 13.10.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:mwm-space-repository/src/main/webapp/WEB-INF/dispatcher-servlet.xml"})
@WebAppConfiguration
public class BasketControllerTest {
    @InjectMocks
    BasketsController basketsController;

    MockMvc mockMvc;

    @Autowired
    WebApplicationContext wac;

    @Before
    public void prepare() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testAddNewBasket() throws Exception {
        ProdGroup prodGroup1 = new ProdGroup(1, "Кухонная техника");
        ProdType prodType1 = new ProdType(1, "Кофеварки", prodGroup1);
        Product product1 = new Product(1, "Утюг", "PHILIPS", "GC4914/20", "Утюг паровой", prodType1, "Польша", 3.99,
                CurrencyType.UAH, UnitsType.PIECE);
        Product product2 = new Product(2, "Утюг", "SUPRA", "12314", "Пылесос", prodType1, "Болгария", 234.50,
                CurrencyType.USD, UnitsType.PIECE);
        Basket basket = new Basket("Вася", "Пупкин", "0938181491", null);
        Map<Product, Integer> order = new HashMap<Product, Integer>();
        basket.addOrder(product1, 1);
        basket.addOrder(product2, 2);
        ObjectMapper om = new ObjectMapper();
        String data = om.writeValueAsString(basket);

        this.mockMvc.perform(post("addnewbasket").content(data).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
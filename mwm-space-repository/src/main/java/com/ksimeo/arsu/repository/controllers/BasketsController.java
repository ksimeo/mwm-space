package com.ksimeo.arsu.repository.controllers;

import com.ksimeo.arsu.core.models.Basket;
import com.ksimeo.arsu.repository.services.IBasketService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Ksimeo 12.10.2015.
 */
@Controller
public class BasketsController {
    @Autowired
    IBasketService basketService;

    private ObjectMapper om = new ObjectMapper();

    @RequestMapping(value = "newbasket", method = RequestMethod.POST)
    @ResponseBody
    public void addNewBasket(@RequestBody Basket basket) {
        basketService.save(basket);
    }

    @RequestMapping(value = "getallbaskets", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE +
            ";charset=UTF-8")
    @ResponseBody
    public List<Basket> getAllBaskets() {
        return basketService.getNew();
    }

    @RequestMapping(value = "getneworders", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE +
            ";charset=UTF-8")
    @ResponseBody
    public List<Basket> getNewOrders() {
        return basketService.getNew();
    }
}
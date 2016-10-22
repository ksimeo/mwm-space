package com.ksimeo.arsu.repository.services.impl;

import com.ksimeo.arsu.core.models.Basket;
import com.ksimeo.arsu.repository.services.IBasketService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by @author Ksimeo on 14.01.2016 at 19:13. For project: MArsMarketSpace.
 */
//@Service
public class BasketService implements IBasketService {

    @Override
    public void save(Basket basket) {

    }

    public void addBasket(Basket basket) {

    }

    public List<Basket> getNew() {
        return new ArrayList<Basket>();
    }

    public List<Basket> getPage(int page) {
        return new ArrayList<Basket>(10);
    }

    public List<Basket> getBaskets() {
        return null;
    }
}

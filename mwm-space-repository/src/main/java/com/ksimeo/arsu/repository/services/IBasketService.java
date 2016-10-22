package com.ksimeo.arsu.repository.services;

import com.ksimeo.arsu.core.models.Basket;

import java.util.List;

/**
 * @author Ksimeo 12.10.2015.
 */
public interface IBasketService {

    void save(Basket basket);
    List<Basket> getNew();
    List<Basket> getPage(int page);
}

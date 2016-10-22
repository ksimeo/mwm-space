package com.ksimeo.arsu.admin.services;

import com.ksimeo.arsu.core.models.Basket;

import java.util.List;

/**
 * @author Ksimeo 11.11.2015 20:21. Project: MArsMarketSpace.
 */
public interface IOrderService {

    List<Basket> getNewOrders() throws Exception;
    List<Basket> getOrderPage(int page);
    List<Basket> getOrders(int from, int to);
    void consider(int id) throws Exception;
    void delOrder(int id);
}
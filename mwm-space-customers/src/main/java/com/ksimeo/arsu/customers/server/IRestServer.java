package com.ksimeo.arsu.view.server;

import com.ksimeo.arsu.core.models.Basket;
import com.ksimeo.arsu.core.models.ProdGroup;
import com.ksimeo.arsu.core.models.ProdType;
import com.ksimeo.arsu.core.models.Product;

import java.util.List;

/**
 * @author Ksimeo 18.08.2015.
 */
public interface IRestServer {

    List<ProdType> getTypes(int id);
    ProdType getType(int groupId, int typeId);
    ProdType getType(int typeId);
    List<ProdGroup> getAllGroups();
    ProdGroup getGroup(int id);
    List<Product> getProducts(int id);
    Product getProduct(int groupId, int typeId, int prodId);
    Product getProduct(int prodId);
    void addBasket(Basket basket);
//    List<Order> getOrders();
}
package com.ksimeo.arsu.view.server;

import com.ksimeo.arsu.core.models.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ksimeo 18.08.2015.
 */
public class RestServerMock implements IRestServer {
    private List<ProdGroup> groups;
    private List<ProdType> types;
    private List<Product> products;
    private Product product;
    private List<Order> orders;
    private Basket basket;

    public RestServerMock() {
        groups = new ArrayList<ProdGroup>();
        ProdGroup prodGroup1 = new ProdGroup(1, "Кухонная техника");
        ProdGroup prodGroup2 = new ProdGroup(2, "Электроника");
        ProdGroup prodGroup3 = new ProdGroup(3, "Самовары");
        ProdGroup prodGroup4 = new ProdGroup(4, "Компьютеры");
        ProdGroup prodGroup5 = new ProdGroup(5, "Ковры");
        types = new ArrayList<ProdType>();
        ProdType prodType1 = new ProdType(1, "Кофеварки", prodGroup1);
        ProdType prodType2 = new ProdType(2, "Электрочайники", prodGroup2);
        ProdType prodType3 = new ProdType(3, "Микроволновки", prodGroup3);
        products = new ArrayList<Product>();
        Product product1 = new Product(1, "Утюг", "PHILIPS", "GC4914/20", "Утюг паровой", prodType1, "Польша", 3.99,
                CurrencyType.UAH, UnitsType.PIECE);
        Product product2 = new Product(2, "Утюг", "SUPRA", "12314", "Пылесос", prodType2, "Болгария", 234.50, CurrencyType.USD,
                UnitsType.PIECE);
        Product product3 = new Product(3, "Утюг", "Rowenta", "fdssdf", "Чайник", prodType2, "Швеция", 345.50, CurrencyType.UAH,
                UnitsType.PIECE);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        prodType1.setProducts(products);
        prodType2.setProducts(products);
        prodType3.setProducts(products);
        types.add(prodType1);
        types.add(prodType2);
        types.add(prodType3);
        prodGroup1.setTypes(types);
        prodGroup2.setTypes(types);
        prodGroup3.setTypes(types);
        prodGroup4.setTypes(types);
        prodGroup5.setTypes(types);
        groups.add(prodGroup1);
        groups.add(prodGroup2);
        groups.add(prodGroup3);
        groups.add(prodGroup4);
        groups.add(prodGroup5);
    }

    public ProdGroup getGroup(int id) {
        for (ProdGroup group : groups) {
            if(id == group.getId())
                return group;
        }
        return null;
    }

    public ProdType getType(int groupId, int typeId) {
        List<ProdType> types = getGroup(groupId).getTypes();
        for (ProdType type : types) {
            if(type.getId() == typeId)
                return type;
        }
        return null;
    }

    public ProdType getType(int typeId) {
        for (ProdType type : types) {
            if(type.getId() == typeId)
                return type;
        }
        return null;
    }

    public List<ProdGroup> getAllGroups() {
        return groups;
    }

    public List<ProdType> getTypes(int id) {
        return types;
    }

    public List<Product> getProducts(int id) {
        return products;
    }

    public Product getProduct (int groupId, int prodId, int id) {
        ProdType prodType = getType(groupId, prodId);
        List<Product> products = prodType.getProducts();
        for (Product prod : products) {
            if (prod.getId() == id) {
               return prod;
            }
        }
        return null;
    }

    public Product getProduct(int id) {
        for (Product prod : products) {
            if (prod.getId() == id) {
                return prod;
            }
        }
        return null;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void addBasket(Basket basket) {
        this.basket = basket;
    }
}
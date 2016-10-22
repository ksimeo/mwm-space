package com.ksimeo.arsu.core.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.*;

/**
 * @author Ksimeo 25.08.2015.
 */
@Entity(name = "baskets")
public class Basket {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String telnumber;
    @Column
    private Date date;
    @Column
    private String email;
    @Column
    private Map<Product, Integer> orders;
    @Column
    private boolean isConsider;

    public boolean isConsider() {
        return isConsider;
    }

    public void setIsConsider(boolean isConsider) {
        this.isConsider = isConsider;
    }

    private volatile static Basket basket;

    public Basket() {
    }

    public Basket(int id, String name, String telnumber, Map<Product, Integer> orders) {
        this.id = id;
        this.name = name;
        this.telnumber = telnumber;
        this.orders = orders;
    }

//    public Basket(int id, String name, String surname, String telnumber, String email) {
//        this.id = id;
//        this.name = name;
//        this.surname = surname;
//        this.telnumber = telnumber;
//        this.email = email;
//    }

    public Basket(int id, String name, String surname, String telnumber, String email, Map<Product, Integer> orders) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.telnumber = telnumber;
        this.date = new Date();
        this.email = email;
        this.orders = orders;
    }

    public Basket(String name, String surname, String telnumber, String email) {
        this.name = name;
        this.surname = surname;
        this.telnumber = telnumber;
        this.email = email;
    }

    public static Basket getInstance() {
        if (basket == null) {
            synchronized (Basket.class) {
                basket = new Basket();
            }
        }
        return basket;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelnumber() {
        return telnumber;
    }

    public void setTelnumber(String telnumber) {
        this.telnumber = telnumber;
    }

    public Map<Product, Integer> getOrders() {
        return orders;
    }

    public void setOrders(Map<Product, Integer> orders) {
        this.orders = orders;
    }

    public boolean isEmpty() {
        if (orders == null) return true;
        else if (orders.size() == 0) return true;
        else return false;
    }

    public int getQuant(Product prod) {
        if (!isEmpty()) {
            Integer quant = orders.get(prod);
            if (quant != null) {
                return quant;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    public void addOrder(Product prod, int addQuant) {
        if (isEmpty()) orders = new HashMap<Product, Integer>();
        orders.put(prod, getQuant(prod) + addQuant);
    }

    public void delOrder(Product prod) {
        Set<Map.Entry<Product, Integer>> entries = orders.entrySet();
        Iterator<Map.Entry<Product, Integer>> iter = entries.iterator();
        Map.Entry<Product, Integer> tmp;
        while (iter.hasNext()) {
            tmp = iter.next();
            if (tmp.getKey().getId() == prod.getId()) iter.remove();
        }
//        orders.remove(prod);
//        System.err.println("Продукт был удален из корзины! doGet");
//        System.out.println(orders);
    }

    public void changeQuant(int prodID, int quant) {
        Set<Map.Entry<Product, Integer>> entries = orders.entrySet();
        Iterator<Map.Entry<Product, Integer>> iter = entries.iterator();
        Map.Entry<Product, Integer> tmp;
        while (iter.hasNext()) {
            tmp = iter.next();
            if (tmp.getKey().getId() == prodID) {
                tmp.setValue(quant);
                return;
            }
        }
    }

    public double getPrice() {
        Set<Map.Entry<Product, Integer>> entries = orders.entrySet();
        Iterator<Map.Entry<Product, Integer>> iter = entries.iterator();
        Map.Entry<Product, Integer> tmp;
        double summ = 0;
        while (iter.hasNext()) {
            tmp = iter.next();
            summ = summ + tmp.getKey().getPrice()*tmp.getValue();
        }
        return summ;
    }
}
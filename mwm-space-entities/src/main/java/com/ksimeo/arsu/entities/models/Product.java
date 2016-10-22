package com.ksimeo.arsu.core.models;

import javax.persistence.*;

/**
 * @author Ksimeo 18.08.2015.
 */
@Entity(name = "products")
public class Product {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @Column
    private ProdType prodType;
    @Column
    private String name;
    @Column
    private String producer;
    @Column
    private String model;
    @Column
    private String description;
    @Column
    private String country;
    @Column
    private double price;
    @Column
    private CurrencyType currType;
    @Column
    private UnitsType units;

    public Product() { }

    public Product(String name, String producer, String model, String description, ProdType prodType, String country, double price,
                   CurrencyType currType, UnitsType units) {
        this.name = name;
        this.producer = producer;
        this.model = model;
        this.description = description;
        this.prodType = prodType;
        this.country = country;
        this.price = price;
        this.currType = currType;
        this.units = units;
    }

    public Product(int id, String name, String producer, String model, String description, ProdType prodType, String country, double price,
                   CurrencyType currType, UnitsType units) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.model = model;
        this.description = description;
        this.prodType = prodType;
        this.country = country;
        this.price = price;
        this.currType = currType;
        this.units = units;
    }

    public Product(ProdType prodType, String name, String producer, String model, String description, String country, double price,
                   CurrencyType currType, UnitsType units) {
        this.prodType = prodType;
        this.name = name;
        this.producer = producer;
        this.model = model;
        this.description = description;
        this.prodType = prodType;
        this.country = country;
        this.price = price;
        this.currType = currType;
        this.units = units;
    }

    public Product(String name, String producer, String model, String description, String country, double price) {
        this.name = name;
        this.producer = producer;
        this.model = model;
        this.description = description;
        this.country = country;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProdType getProdType() {
        return prodType;
    }

    public void setProdType(ProdType prodType) {
        this.prodType = prodType;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CurrencyType getCurrType() {
        return currType;
    }

    public void setCurrType(CurrencyType currType) {
        this.currType = currType;
    }

    public UnitsType getUnits() {
        return units;
    }

    public void setUnits(UnitsType units) {
        this.units = units;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @Override
//     public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Product product = (Product) o;
//
//        if (id != product.id) return false;
//        if (prodType != null ? !prodType.equals(product.prodType) : product.prodType != null) return false;
//        if (producer != null ? !producer.equals(product.producer) : product.producer != null) return false;
//        if (model != null ? !model.equals(product.model) : product.model != null) return false;
//        if (description != null ? !description.equals(product.description) : product.description != null) return false;
//        if (country != null ? !country.equals(product.country) : product.country != null) return false;
//        if (price != product.price) return false;
//        if (currType != null ? !currType.equals(product.currType) : product.currType != null) return false;
//        if (units != null ? !units.equals(product.units) : product.units != null) return false;
//
//        return true;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id == product.id)
            return true;
        else return false;
    }
}
package com.ksimeo.arsu.core.models;

import javax.persistence.*;
import java.util.List;

/**
 * @author Ksimeo 18.08.2015.
 */
@Entity(name = "types")
public class ProdType {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @Column
    private ProdGroup prodGroup;
    @Column
    private String name;
    @OneToMany
    @JoinTable(name="product_id")
    @Column
    private List<Product> products;

    public ProdType() { }

    public ProdType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProdType(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }

    public ProdType(String name) {
        this.name = name;
    }

    public ProdType(int id, String name, List<Product> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public ProdType(int id, String name, ProdGroup prodGroup) {
        this.id = id;
        this.name = name;
        this.prodGroup = prodGroup;
    }

    public ProdType(ProdGroup prodGroup, String name, List<Product> products) {
        this.prodGroup = prodGroup;
        this.name = name;
        this.products = products;
    }

    public ProdType(int id, ProdGroup prodGroup, String name, List<Product> products) {
        this.id = id;
        this.prodGroup = prodGroup;
        this.name = name;
        this.products = products;
    }

    public ProdType(int id, ProdGroup prodGroup, String name) {
        this.id = id;
        this.prodGroup = prodGroup;
        this.name = name;
    }

    public ProdType(ProdGroup prodGroup, String name) {
        this.prodGroup = prodGroup;
        this.name = name;
    }

    public ProdGroup getProdGroup() {
        return prodGroup;
    }

    public void setProdGroup(ProdGroup prodGroup) {
        this.prodGroup = prodGroup;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Product getProduct(int id) {
        for (Product product : products) {
            if(id == product.getId())
                return product;
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProdType prodtype = (ProdType) o;

        if (id != prodtype.id) return false;
        if (prodGroup != null ? !prodGroup.equals(prodtype.prodGroup) : prodtype.prodGroup != null) return false;
        if (name != null ? !prodtype.equals(prodtype.name) : prodtype.name != null) return false;
        if (products != null ? !products.equals(prodtype.products) : prodtype.products != null) return false;

        return true;
    }
}
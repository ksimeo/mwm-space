package com.ksimeo.arsu.admin.services.test;

import com.ksimeo.arsu.admin.services.IProdService;
import com.ksimeo.arsu.core.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by @author Ksimeo on 17.11.2015 at 16:04. For project: MArsMarketSpace.
 */
@Service
public class ProdServiceMock implements IProdService {
    private List<Product> products;
    private Product prod1;

    public ProdServiceMock() {
        products = new ArrayList<>();
        prod1 = new Product();
        prod1.setId(1);
        prod1.setModel("A321");
        prod1.setName("Кофеварка");
        prod1.setProducer("BOSH");
        prod1.setCountry("Болгария");
        prod1.setDescription("Чудо-кофеварка, которая варит сама по себе!");
        prod1.setPrice(9.99d);
        Product prod2 = new Product();
        prod2.setId(2);
        prod2.setName("Электрочайник");
        prod2.setModel("B210");
        prod2.setProducer("PHILIPS");
        prod2.setCountry("Польша");
        prod2.setDescription("Этот чайник способен заменить вам два самовара!");
        prod2.setPrice(2.55);
        Product prod3 = new Product();
        prod3.setId(3);
        prod3.setName("Утюг");
        prod3.setModel("L38K");
        prod3.setProducer("Rowenta");
        prod3.setCountry("Германия");
        prod3.setDescription("Утюг который способен гладить вещи из любого материала.");
        prod3.setPrice(3.14);
        products.add(prod1);
        products.add(prod2);
        products.add(prod3);
    }

    public List<Product> getProducts(int groupID) {
        return products;
    }

    public void addProduct(Product prod) {
        products.add(prod);
    }

    public Product getProduct(int id) {
        return products.get(id - 1);
    }

    public void delProduct(int id) {
        products.remove(id - 1);
    }

    public void saveProduct(Product prod) {
        products.remove(prod.getId());
        products.add(prod.getId(), prod);
    }

    public List<Product> getAllProducts() {
        return products;
    }
}

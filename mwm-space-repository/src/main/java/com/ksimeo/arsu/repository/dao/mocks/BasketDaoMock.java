package com.ksimeo.arsu.repository.dao.mocks;

import com.ksimeo.arsu.core.models.Basket;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ksimeo 12.10.2015.
 */
@Repository
public class BasketDaoMock implements IBasketDao {

    List<Basket> baskets = new ArrayList<Basket>();

    public void save(Basket basket) {
        baskets.add(basket);
    }

    public List<Basket> findAll() {
        return baskets;
    }
}
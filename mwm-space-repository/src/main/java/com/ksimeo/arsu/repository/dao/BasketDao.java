package com.ksimeo.arsu.repository.dao;

import com.ksimeo.arsu.entities.models.Basket;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by @author Ksimeo on 15.01.2016 at 18:34. For project: MArsMarketSpace.
 */
@Repository
public interface BasketDao extends CrudRepository<Basket, Integer> {

    @Query(value = "select * from users where isConsider=:false", nativeQuery = true)
    List<Basket> getNew();
}

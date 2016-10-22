package com.ksimeo.arsu.repository.repository;

import com.ksimeo.arsu.core.models.Basket;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by @author Ksimeo on 15.01.2016 at 18:34. For project: MArsMarketSpace.
 */
@Repository
@Qualifier("basketDao")
public interface BasketRepository extends CrudRepository<Basket, Integer> {
}

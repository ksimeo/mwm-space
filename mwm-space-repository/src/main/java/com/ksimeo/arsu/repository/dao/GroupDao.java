package com.ksimeo.arsu.repository.dao;

import com.ksimeo.arsu.entities.models.ProdGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupDao extends CrudRepository<ProdGroup, Integer> {
}

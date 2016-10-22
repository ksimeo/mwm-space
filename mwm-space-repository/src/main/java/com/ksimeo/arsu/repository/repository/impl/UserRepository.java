package com.ksimeo.arsu.repository.repository.impl;

import com.ksimeo.arsu.core.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ksimeo 09.11.2015.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> { }

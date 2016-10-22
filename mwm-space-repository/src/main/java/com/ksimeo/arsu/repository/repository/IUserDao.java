package com.ksimeo.arsu.repository.repository;

import com.ksimeo.arsu.core.models.User;

import java.util.List;

/**
 * Created by @author Ksimeo on 22.01.2016 at 21:49. For project: mars-market-space.
 */
public interface IUserDao {
    User save(User user) throws Exception;
    User findOne(int id) throws Exception;
    boolean exists(int id);
    List<User> findAll();
    void delete(int id);
    void deleteAll();
}

package com.ksimeo.arsu.repository.repository;

import com.ksimeo.arsu.core.models.User;

import java.util.List;

/**
 * @author Ksimeo 12.10.2015.
 */
public interface IBasketDao  {

    User save(User user) throws Exception;
    User findOne(int id) throws Exception;
    boolean exists(int id);
    List<User> findAll();
    void delete(int id);
    void deleteAll();
//    <S extends T> S save(S entity);
//    <S extends T> Iterable<S> save(Iterable<S> entities);
//    Basket findOne(Integer integer);
//    boolean exists(Integer integer);
//    Iterable<Basket> findAll(Iterable<Integer> integers);
//    long count();
//    void delete(Integer integer);
//    void delete(Basket entity);
//    void delete(Iterable<? extends Basket> entities);
//    void deleteAll();

}
package com.ksimeo.arsu.repository.dao;

import com.ksimeo.arsu.entities.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao extends CrudRepository<User, Integer> {

    @Query(value = "select * from users where login=:login, password=:password", nativeQuery = true)
    User getOne(@Param("login") String login, @Param("password") String password);
}

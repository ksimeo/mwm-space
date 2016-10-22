package com.ksimeo.arsu.admin.services;

import com.ksimeo.arsu.core.models.User;

import java.util.List;

/**
 * @author Ksimeo 05.11.2015.
 */
public interface IUserService {

    User getUser(String login, String password) throws Exception;
    User getUser(int id);
    List<User> getUsers();
    void addUser(User newUser);
    void delUser(int id);
    boolean isPasswCorrect(String passw);
    void setNewPassw(String passw);
    void saveUser(User user);
}

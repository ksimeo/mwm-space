package com.ksimeo.arsu.admin.services.test;

import com.ksimeo.arsu.admin.services.IUserService;
import com.ksimeo.arsu.core.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ksimeo 05.11.2015.
 */
@Service
public class UserServiceMock implements IUserService {
    private List<User> users;

    public UserServiceMock() {
        users = new ArrayList<>();
        users.add(new User(1, "Ars", "#1234", "Арсен", "Тумоян", true));
        users.add(new User(2, "Smagini", "#1234", "Ваня", "Смагин", false));
    }
    public User getUser(String login, String password) {
        User admin = new User(1, "Ars", "#1234", "Арсен", "Тумоян", true);
        User user1 = new User(2, "Smagini", "#1234", "Ваня", "Смагин", false);
        if((login.equalsIgnoreCase(admin.getLogin()))&&(password.equals(admin.getPassword()))) return admin;
        else if(((login.equalsIgnoreCase(user1.getLogin())&&(password.equals(user1.getPassword()))))) return user1;
        else return null;
    }
    public User getUser(int id) {
        return users.get(id - 1);
    }

    public boolean isPasswCorrect(String passw) {
        return true;
    }

    public void setNewPassw(String passw) {
        //NOP
    }

    public void addUser(User newUser) {
        users.add(newUser);
    }

    public void delUser(int id) {
        users.remove(id);
    }

    public List<User> getUsers() {
        return users;
    }

    public void saveUser(User user) {
        users.remove(user.getId());
        users.add(user);
    }
}
package com.ksimeo.arsu.repository.dao.mocks;

import com.ksimeo.arsu.core.models.User;
import com.ksimeo.arsu.repository.services.IUserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by @author Ksimeo on 16.01.2016 at 17:46. For project: MArsMarketSpace.
 */
@Service
public class UserServiceMock implements IUserService {

    private List<User> users;
    private User testUser;

    public UserServiceMock() {
        users = new ArrayList<>();
        testUser = new User(1, "Ars", "#1234", "Арсен", "Тумоян", true);
        users.add(testUser);
        users.add(new User(2, "Smagini", "#1234", "Ваня", "Смагин", false));
    }

    @Override
    public User getOne(String login, String password) {
        System.out.println(testUser);
        return testUser;
    }

    /**
     * This method gets parameters "login" and "password" and returns status of user ("user" or "admin") if user whith
     * these parametrs are exsist or "null" if not exist.
     * @param login
     * @param password
     * @return
     */
    public String checkStatus(String login, String password) {
        return "admin";
    }

    @Override
    public List<User> getAll() {
        return users;
    }
}
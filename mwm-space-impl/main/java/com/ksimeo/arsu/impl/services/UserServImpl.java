package com.ksimeo.arsu.impl.services;

import com.ksimeo.arsu.api.dao.UserDAO;
import com.ksimeo.arsu.api.services.UserService;
import com.ksimeo.arsu.entities.DTO.UserDTO;
import com.ksimeo.arsu.entities.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ksimeo. Created on 18.12.2016 at 19:22 for "mwm-space" project.
 * @version 1.0
 * @since 1.0
 */
@Service
public class UserServImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    public boolean checkByLoginPassword(UserDTO usr) {
        return false;
    }

    public List<User> getAll() {
        return null;
    }
}

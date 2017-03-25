package com.ksimeo.arsu.api.services;

import com.ksimeo.arsu.entities.DTO.UserDTO;
import com.ksimeo.arsu.entities.models.User;

import java.util.List;

/**
 * @author Ksimeo. Created on 18.12.2016 at 19:12 for "mwm-space" project.
 * @version 1.0
 * @since 1.0
 */
public interface UserService {

    boolean checkByLoginPassword(UserDTO usr);
    List<User> getAll();
}

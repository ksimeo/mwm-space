package com.ksimeo.arsu.api.dao;

/**
 * @author Ksimeo. Created on 18.12.2016 at 19:29 for "mwm-space" project.
 * @version 1.0
 * @since 1.0
 */
public interface UserDAO {

        boolean isExist(String login, String password);
}
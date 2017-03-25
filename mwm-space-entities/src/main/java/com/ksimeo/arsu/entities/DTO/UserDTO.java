package com.ksimeo.arsu.entities.DTO;

/**
 * @author Ksimeo. Created on 18.12.2016 at 13:48 for "mwm-space" project.
 * @version 1.0
 * @since 1.0
 */
public class UserDTO {
    // form:input - login
    public String login;
    // form:input - password
    public String password;

    public UserDTO() {
    }

    public UserDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package com.ksimeo.arsu.core.models;

import javax.persistence.*;

/**
 * @author Ksimeo 05.11.2015.
 */
@Entity
@Table(name="users")
public class User {
    @Id
    @Column
    @GeneratedValue
    private int id;
    @Column
    private String login;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String password;
    @Column(name = "status")
    private boolean isAdmin;
    @Column(name = "email")
    private String eMail;

    public User() { }

    public User(String login, String password, String name, String surname, boolean isAdmin) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.isAdmin = isAdmin;
    }

    public User(int id, String login, String password, String name, String surname, boolean isAdmin) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.isAdmin = isAdmin;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public String toString() {
            return "User{" +
                    "id=" + id +
                    ", login='" + login + '\'' +
                    ", name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", password='" + password + '\'' +
                    ", isAdmin='" + isAdmin + '\'' +
                    '}';
    }
}
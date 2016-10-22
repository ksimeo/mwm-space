package com.ksimeo.arsu.repository.repository.impl;

import com.ksimeo.arsu.core.models.User;
import com.ksimeo.arsu.repository.repository.ConnConfig;
import com.ksimeo.arsu.repository.repository.IUserDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * @author Ksimeo 01.11.2015.
 */
public class UserDao implements IUserDao {

    @Override
    public User save(User user) throws Exception {
        try {
            Connection conn = null;
            PreparedStatement ps = null;
            try {
                conn = DriverManager.getConnection(ConnConfig.JDBC_URL, ConnConfig.USER_NAME, ConnConfig.USER_PASSWORD);
                ps = conn.prepareStatement("INSERT INTO marsmarket_db.users (login, name, surname, password, status)" +
                        " VALUES(?, ?, ?, ?, ?)");
                ps.setString(1, user.getLogin());
                ps.setString(2, user.getName());
                ps.setString(3, user.getSurname());
                ps.setString(4, user.getPassword());
                ps.setBoolean(5, user.getIsAdmin());
                int res = ps.executeUpdate();
                ResultSet lastID = ps.getGeneratedKeys();
                user.setId(lastID.getInt(1));
                return user;
            } finally {
                if (conn != null) {
                    conn.close();
                    conn = null;
                }
                if (ps != null) {
                    ps.close();
                    ps = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User findOne(int id) throws Exception {
        try {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet res = null;
            try {
                conn = DriverManager.getConnection(ConnConfig.JDBC_URL, ConnConfig.USER_NAME, ConnConfig.USER_PASSWORD);
                ps = conn.prepareStatement("SELECT FROM marsmarket.users WHERE id = '" + id + "'");
                res = ps.executeQuery();
                User toSend = null;
                if (res != null) {
                    toSend = new User(res.getInt("id"), res.getString("login"), res.getString("name"),
                            res.getString("surname"), "", res.getBoolean("status"));
                }
                return toSend;
            } finally {
                if (res != null) {
                    res.close();
                    res = null;
                }
                if (ps != null) {
                    ps.close();
                    ps = null;
                }
                if (conn != null) {
                    conn.close();
                    conn = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public User findOne(String login, String password) {
        try {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet res = null;
            try {
                conn = DriverManager.getConnection(ConnConfig.JDBC_URL, ConnConfig.USER_NAME, ConnConfig.USER_PASSWORD);
                ps = conn.prepareStatement("SELECT FROM marsmarket_db WHERE login = '" + login  + "' password = '" + password + "'");
                res = ps.executeQuery();
                User toSend = null;
                if (res != null) {
                    toSend = new User(res.getInt("id"), res.getString("login"), res.getString("name"),
                            res.getString("surname"), "", res.getBoolean("status"));
                }
                return toSend;
            } finally {
                if (res != null) {
                    res.close();
                    res = null;
                }
                if (ps != null) {
                    ps.close();
                    ps = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> findAll() {
        try {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet res = null;
            try {
                conn = DriverManager.getConnection(ConnConfig.JDBC_URL, ConnConfig.USER_NAME, ConnConfig.USER_PASSWORD);
                ps = conn.prepareStatement("WHERE * FROM marsmarket.users");
                res = ps.executeQuery();
                List<User> toSend = null;
                while (res.next()) {
                    toSend.add(new User(res.getInt("id"), res.getString("login"), res.getString("name"),
                            res.getString("surname"), "", res.getBoolean("status")));
                }
                return toSend;
            } finally {
                if (res != null) {
                    res.close();
                    res = null;
                }
                if (ps != null) {
                    ps.close();
                    ps = null;
                }
                if (conn != null) {
                    conn.close();
                    conn = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean exists(int id) {
        return false;
    }

    @Override
    public void delete(int id) {


    }

    @Override
    public void deleteAll() {

    }
}

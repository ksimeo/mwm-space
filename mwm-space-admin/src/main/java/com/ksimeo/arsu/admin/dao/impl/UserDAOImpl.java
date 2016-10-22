package com.ksimeo.arsu.admin.dao.impl;

import com.ksimeo.arsu.admin.dao.ConnectConf;
import com.ksimeo.arsu.admin.dao.UserDAO;
import com.ksimeo.arsu.admin.helpers.PasswCoder;
import com.ksimeo.arsu.core.models.User;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by @author Ksimeo on 29.03.2016 at 17:40. For project: marsexpress-space.
 */
@Repository
public class UserDAOImpl implements UserDAO {
    @Override
    public User save(User user) {
        try {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                user.setPassword(PasswCoder.String2Hash(user.getPassword()));
                conn = DriverManager.getConnection(ConnectConf.dbConnPath, ConnectConf.dbConnName, ConnectConf.dbConnPass);
                ps = conn.prepareStatement("INSERT INTO marsmarket.users (login, name, surname, password, status, email)" +
                "VALUES (?, ?, ?, ?, ?, ?)");
                ps.setString(1, user.getLogin());
                ps.setString(2, user.getName());
                ps.setString(3, user.getSurname());
                ps.setString(4, user.getPassword());
                ps.setBoolean(5, user.isAdmin());
                ps.setString(6, user.geteMail());
                int res = ps.executeUpdate();
                if (res == 0) return null;
                    rs = ps.getGeneratedKeys();
                if (rs.next()) user.setId(rs.getInt(1));
            } finally {
                if (conn != null) {
                    conn.close();
                    conn = null;
                }
                if (ps != null) {
                    ps.close();
                    ps = null;
                }
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}

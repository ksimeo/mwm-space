package com.ksimeo.arsu.admin.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by @author Ksimeo on 11.03.2016 at 21:30. For project: marsexpress-space.
 */
@WebServlet(urlPatterns = "/adduser2.do")
public class CreateUser2Controller extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/json; UTF-8");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String login = req.getParameter("login");
        boolean isAdmin = Boolean.parseBoolean(req.getParameter(""));
    }
}

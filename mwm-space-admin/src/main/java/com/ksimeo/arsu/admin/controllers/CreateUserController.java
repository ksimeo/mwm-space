package com.ksimeo.arsu.admin.controllers;

import com.ksimeo.arsu.admin.services.IUserService;
import com.ksimeo.arsu.core.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by @author Ksimeo on 16.12.2015 at 20:02. For project: MArsMarketSpace.
 */
@WebServlet(urlPatterns = "/adduser.do")
@Controller
public class CreateUserController extends HttpServlet {
    @Autowired
    private IUserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/createuser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        try {
            String login = req.getParameter("name");
            String password = req.getParameter("password");
            String name = req.getParameter("name");
            String surname = req.getParameter("surname");
            boolean status = Boolean.parseBoolean(req.getParameter("status"));
            User user = new User(name, password, name, surname, status);
            userService.addUser(user);
            resp.sendRedirect("/users.do");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

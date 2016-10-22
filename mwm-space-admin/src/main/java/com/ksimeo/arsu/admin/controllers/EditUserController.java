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
 * Created by @author Ksimeo on 16.12.2015 at 20:49. For project: MArsMarketSpace.
 */
@WebServlet(urlPatterns = "/edituser.do")
@Controller
public class EditUserController extends HttpServlet {
    @Autowired
    private IUserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("text/html; charset=UTF-8");
            int id = Integer.parseInt(req.getParameter("id"));
            User user = userService.getUser(id);
            req.setAttribute("id", id);
            req.setAttribute("login", user.getLogin());
            req.setAttribute("name", user.getName());
            req.setAttribute("surname", user.getSurname());
            String status = user.getIsAdmin() ? "adm" : "usr";
            req.setAttribute(status, "selected");
            req.setAttribute("status", user.getIsAdmin());
            req.getRequestDispatcher("WEB-INF/corruser.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            int id = Integer.parseInt(req.getParameter("id"));
            String login = req.getParameter("login");
            String name = req.getParameter("name");
            String surname = req.getParameter("surname");
            boolean status = Boolean.parseBoolean(req.getParameter("status"));
            User user = userService.getUser(id);
            if (login != user.getLogin()) user.setLogin(login);
            if (name != user.getName()) user.setName(name);
            if (surname != user.getSurname()) user.setSurname(surname);
            if (status != user.getIsAdmin()) user.setIsAdmin(status);
            userService.saveUser(user);
            req.getRequestDispatcher("WEB-INF/coruser.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.ksimeo.arsu.admin.controllers;

import com.ksimeo.arsu.core.models.User;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by @Ksimeo on 16.11.2015 at 21:38. For project MArsMarketSpace.
 */
@WebServlet(urlPatterns = "/savechange.do")
@Controller
public class SetPasswController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext();
        String oldPassw = req.getParameter("oldpassw");
        User visitor = (User)req.getAttribute("user");
        if ((visitor.getPassword()).equals(oldPassw)) {
            String newPassw1 = req.getParameter("newpassw1");
            String newPassw2 = req.getParameter("newpassw2");
            if (newPassw1.equals(newPassw2)) {
                req.getRequestDispatcher("/main.do").forward(req, resp);
            }
        }
    }
}
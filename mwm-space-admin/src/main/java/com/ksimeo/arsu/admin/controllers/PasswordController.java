package com.ksimeo.arsu.admin.controllers;

import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by @Ksimeo on 16.11.2015 at 21:20. For project MArsMarketSpace.
 */
@WebServlet(urlPatterns = "/changepassw.do")
@Controller
public class PasswordController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/changepassw.jsp").forward(req, resp);
    }
}

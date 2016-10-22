package com.ksimeo.arsu.admin.controllers;

import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by @author Ksimeo on 17.11.2015 at 13:21. For project: MArsMarketSpace.
 */
@WebServlet(urlPatterns = "/addtype.do")
@Controller
public class NewTypeController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String type = req.getParameter("typetitle");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

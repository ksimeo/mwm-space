package com.ksimeo.arsu.view.controllers;

import com.ksimeo.arsu.core.models.ProdGroup;
import com.ksimeo.arsu.view.server.IRestServer;
import com.ksimeo.arsu.view.server.RestServerMock;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Ksimeo 18.08.2015.
 */
@WebServlet(urlPatterns = "/index")
public class WelcomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            IRestServer rs = new RestServerMock();
            List<ProdGroup> groups = rs.getAllGroups();
            req.setAttribute("groups", groups);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
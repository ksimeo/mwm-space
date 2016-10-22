package com.ksimeo.arsu.view.controllers;

import com.ksimeo.arsu.core.models.Basket;
import com.ksimeo.arsu.core.models.Product;
import com.ksimeo.arsu.view.server.IRestServer;
import com.ksimeo.arsu.view.server.RestServerMock;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author Ksimeo 07.09.2015.
 */
@WebServlet(urlPatterns = "/basket")
public class BasketController extends HttpServlet {

    IRestServer restServer = new RestServerMock();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");
            Map<Product, Integer> orders = Basket.getInstance().getOrders();
            req.setAttribute("orders", orders);
            if (!orders.isEmpty()) {
                Basket basket = Basket.getInstance();
                req.setAttribute("orders", basket.getOrders());
                req.setAttribute("summ", basket.getPrice());
//                req.setAttribute("curr", basket.);
                req.getRequestDispatcher("/basket.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("/emptybasket.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
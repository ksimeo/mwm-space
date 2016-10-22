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

/**
 * @author Ksimeo 06.09.2015.
 */
@WebServlet(urlPatterns = "/order")
public class OrderController extends HttpServlet {

    IRestServer restServer = new RestServerMock();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");
            Integer prodID = Integer.parseInt(req.getParameter("id"));
            Integer addQuant = Integer.parseInt(req.getParameter("quant"));
            String typeID = req.getParameter("type");
            String groupID = req.getParameter("group");
            Product prod = restServer.getProduct(prodID);
            Basket basket = Basket.getInstance();
            basket.addOrder(prod, addQuant);
            resp.sendRedirect("/type?id="+typeID+"&group="+groupID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
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
 * @author Ksimeo 06.10.2015.
 */
@WebServlet(urlPatterns = "/delete")
public class DeleteController extends HttpServlet {

    IRestServer restServer = new RestServerMock();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");
            Integer prodID = Integer.parseInt(req.getParameter("id"));
            Product prod = restServer.getProduct(prodID);
            Basket basket = Basket.getInstance();
            basket.delOrder(prod);
//            System.err.println("Продукт был удален из корзины! doGet");
            resp.sendRedirect("/basket");
//            req.getRequestDispatcher("/basket").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Продукт не удален из корзины! Что-то полшло не так!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
//            req.setCharacterEncoding("UTF-8");
//            resp.setContentType("text/html; charset=UTF-8");
//            Integer prodID = Integer.parseInt(req.getParameter("id"));
//            Product prod = restServer.getProduct(prodID);
//            Map<Product, Integer> orders = Basket.getInstance().getOrders();
//            orders.remove(prod);
//            System.out.println("Продукт был удален из корзины! doPost");
            resp.sendRedirect("/index");
//            req.getRequestDispatcher("/basket").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Продукт не удален из корзины! Что-то полшло не так!");
        }

    }
}

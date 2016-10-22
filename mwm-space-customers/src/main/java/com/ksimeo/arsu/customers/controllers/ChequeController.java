package com.ksimeo.arsu.view.controllers;

import com.ksimeo.arsu.core.models.Basket;
import com.ksimeo.arsu.core.models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author Ksimeo 07.10.2015.
 */
@WebServlet(urlPatterns = "/ordering")
public class ChequeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");
            Basket basket = Basket.getInstance();
            Map<Product, Integer> orders = basket.getOrders();
            double summPrice = basket.getPrice();
            req.setAttribute("orders", orders);
            req.setAttribute("summ", summPrice);
            req.getRequestDispatcher("/cheque.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Что-то пошло не так в методе doGet(...) экземпляра класса ChequeController");
        }
    }
}

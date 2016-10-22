package com.ksimeo.arsu.view.controllers;

import com.ksimeo.arsu.core.models.Basket;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ksimeo 07.10.2015.
 */
@WebServlet(urlPatterns = "/savechangequant")
public class SaveChangeController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");
            Integer prodID = Integer.parseInt(req.getParameter("prodid"));
            Integer newQuant = Integer.parseInt(req.getParameter("quant"));
            Basket.getInstance().changeQuant(prodID, newQuant);
            resp.sendRedirect("/basket");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Что-то пошло не так при выполнении метода doPost() в экземпляре класса " +
                    "SaveChangeController");
        }
    }
}

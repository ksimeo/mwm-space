package com.ksimeo.arsu.view.controllers;

import com.ksimeo.arsu.core.models.Basket;
import com.ksimeo.arsu.view.server.IRestServer;
import com.ksimeo.arsu.view.server.RestServerMock;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author Ksimeo 14.09.2015.
 */
@WebServlet(urlPatterns="/dorder")
public class FinishController extends HttpServlet {
    IRestServer restServer;

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        req.getRequestDispatcher("ordered.jsp").forward(req, resp);
//        resp.sendRedirect("/ordered.jsp");
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");
            String telephone = req.getParameter("tel");
            String name = req.getParameter("name");
            if (null == telephone || telephone.isEmpty() && null == name || name.isEmpty()) {
                req.setAttribute("ErrorField", "Поле не заполнено");
                req.getRequestDispatcher("/ordering.jsp").forward(req, resp);
            } else {
                req.removeAttribute("ErrorField");
            }
            Basket basket = Basket.getInstance();
            basket.setName(name);
            basket.setTelnumber(telephone);
            HttpSession session = req.getSession();
            restServer = new RestServerMock();
            restServer.addBasket(basket);
            Cookie nameCookie = new Cookie("name", name);
//            Cookie telCookie = new Cookie("tel", telephone);
            nameCookie.setMaxAge(30*60);
//            telCookie.setMaxAge(30*60);
            resp.addCookie(nameCookie);
//            resp.addCookie(telCookie);
            req.getRequestDispatcher("/ordered.jsp").forward(req, resp);
//            resp.sendRedirect("/ordered.jsp");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

package com.ksimeo.arsu.view.controllers;

import com.ksimeo.arsu.core.models.Basket;

import com.ksimeo.arsu.view.server.IRestServer;
import com.ksimeo.arsu.view.server.RestServerMock;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author Ksimeo 07.10.2015.
 */
@WebServlet(urlPatterns = "/acquire")
public class AcquireController extends HttpServlet {

    IRestServer restServer = new RestServerMock();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String name = req.getParameter("firstname");
        String surname = req.getParameter("secondname");
        String phoneNumber = req.getParameter("phonenumb");
        String email = req.getParameter("email");
        Basket basket = Basket.getInstance();
        basket.setName(name);
        if (surname != null) basket.setSurname(surname);
        basket.setTelnumber(phoneNumber);
        if (email != null) basket.setEmail(email);
        restServer.addBasket(basket);
        Cookie customName = new Cookie("name", name);
        customName.setMaxAge(30*60);
        resp.addCookie(customName);
//        HttpSession session = req.getSession();
        resp.sendRedirect("/ordered.jsp");
    }
}

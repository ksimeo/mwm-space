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
 * @author Ksimeo 07.10.2015.
 */
@WebServlet(urlPatterns = "/edit")
public class EditController extends HttpServlet {

    IRestServer restServer = new RestServerMock();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");
            Integer prodID = Integer.parseInt(req.getParameter("id"));
            req.setAttribute("prodid", prodID);
            Basket basket = Basket.getInstance();
            Product prod = restServer.getProduct(prodID);
            int quant = Integer.parseInt(req.getParameter("quant"));
//            req.setAttribute("groupname", group.getName());
//            req.setAttribute("types", type.getName());
            req.setAttribute("name", prod.getName());
            req.setAttribute("group_id", prod.getId());
            req.setAttribute("type_id", prod.getId());
            req.setAttribute("producer", prod.getProducer());
            req.setAttribute("model", prod.getModel());
            req.setAttribute("descr", prod.getDescription());
            req.setAttribute("type", prod.getCurrType());
            req.setAttribute("q", quant);
//            req.setAttribute("typename", type.getName());
            req.setAttribute("country", prod.getCountry());
            req.setAttribute("price", prod.getPrice());
            req.getRequestDispatcher("/changeprod.jsp").forward(req, resp);

        } catch(Exception e) {
            e.printStackTrace();
            System.err.println("Что-то пошло не так в методе doGet экземпляра класса EditController");
        }
    }
}

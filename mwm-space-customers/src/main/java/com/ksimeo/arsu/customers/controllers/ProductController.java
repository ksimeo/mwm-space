package com.ksimeo.arsu.view.controllers;

import com.ksimeo.arsu.core.models.ProdGroup;
import com.ksimeo.arsu.core.models.ProdType;
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
 * @author Ksimeo 22.08.2015.
 */
@WebServlet(urlPatterns = "/product")
public class ProductController extends HttpServlet {
    private IRestServer restServer;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");
            String groupId = req.getParameter("group");
            String typeId = req.getParameter("type");
            String productId = req.getParameter("id");
            req.setAttribute("prodid", productId);
            req.setAttribute("groupid", groupId);
            req.setAttribute("typeid", typeId);
            restServer = new RestServerMock();
            Product prod = restServer.getProduct(Integer.parseInt(productId));
            ProdType type = restServer.getType(Integer.parseInt(typeId));
            ProdGroup group = restServer.getGroup(Integer.parseInt(groupId));
            req.setAttribute("groupname", group.getName());
            req.setAttribute("types", type.getName());
            req.setAttribute("group_id", prod.getId());
            req.setAttribute("type_id", prod.getId());
            req.setAttribute("producer", prod.getProducer());
            req.setAttribute("model", prod.getModel());
            req.setAttribute("descr", prod.getDescription());
            req.setAttribute("type", prod.getCurrType());
            req.setAttribute("typename", type.getName());
            req.setAttribute("country", prod.getCountry());
            req.setAttribute("price", prod.getPrice());
            req.getRequestDispatcher("/product.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
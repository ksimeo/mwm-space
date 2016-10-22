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
import java.util.List;

/**
 * @author Ksimeo 22.08.2015.
 */
@WebServlet(urlPatterns = "/type")
public class TypeController extends HttpServlet {
    IRestServer restServer;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");
            String groupId = req.getParameter("group");
            String typeId = req.getParameter("id");
            restServer = new RestServerMock();
            ProdType prodType = restServer.getType(Integer.parseInt(typeId));
            ProdGroup prodGroup = restServer.getGroup(Integer.parseInt(groupId));
            req.setAttribute("typename", prodType.getName());
            req.setAttribute("groupname", prodGroup.getName());
            req.setAttribute("gid", groupId);
            req.setAttribute("tid", typeId);
            List<Product> products = prodType.getProducts();
            req.setAttribute("products", products);
            req.getRequestDispatcher("type.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
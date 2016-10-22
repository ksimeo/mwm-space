package com.ksimeo.arsu.view.controllers;

import com.ksimeo.arsu.core.models.ProdGroup;
import com.ksimeo.arsu.core.models.ProdType;
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
@WebServlet(urlPatterns = "/group")
public class GroupController extends HttpServlet {
    private IRestServer restServer;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");
            String groupId = req.getParameter("id");
            restServer = new RestServerMock();
            ProdGroup prodGroup = restServer.getGroup(Integer.parseInt(groupId));
//            ProdType type = restServer.getType(Integer.parseInt(typeId));
//            ProdGroup group = restServer.getGroup(Integer.parseInt(groupId));
            req.setAttribute("groups", prodGroup.getName());
//            req.setAttribute("types", type.getName());
            List<ProdType> types = prodGroup.getTypes();
            req.setAttribute("title", prodGroup.getName());
            req.setAttribute("types", types);
            req.setAttribute("gid", groupId);
            req.getRequestDispatcher("group.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
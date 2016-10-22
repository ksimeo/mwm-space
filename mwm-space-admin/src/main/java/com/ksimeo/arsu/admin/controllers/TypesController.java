package com.ksimeo.arsu.admin.controllers;

import com.ksimeo.arsu.admin.services.ITypeService;
import com.ksimeo.arsu.core.models.ProdType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by @author Ksimeo on 06.12.2015 at 19:57. For project: MArsMarketSpace.
 */
@WebServlet(urlPatterns = "/types.do")
@Controller
public class TypesController extends HttpServlet {
    @Autowired
    private ITypeService typeService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        List<ProdType> types = typeService.getAllTypes();
        req.setAttribute("types", types);
        req.getRequestDispatcher("WEB-INF/types.jsp").forward(req, resp);
    }
}

package com.ksimeo.arsu.admin.controllers;

import com.ksimeo.arsu.admin.services.ITypeService;
import com.ksimeo.arsu.core.models.ProdType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by @author Ksimeo on 16.11.2015 at 22:28. For project: MArsMarketSpace.
 */
@WebServlet(urlPatterns = "/newtype.do")
@Controller
public class CreateTypeController extends HttpServlet {
    @Autowired
    private ITypeService typeService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String typeName = req.getParameter("name");
        typeService.addType(new ProdType(typeName));
        resp.sendRedirect("/types.do");
//        req.getRequestDispatcher("WEB-INF/createtype.jsp").forward(req, resp);
    }
}

package com.ksimeo.arsu.admin.controllers;

import com.ksimeo.arsu.admin.services.IOrderService;
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
 * Created by @author Ksimeo on 13.12.2015 at 21:52. For project: MArsMarketSpace.
 */
@WebServlet(urlPatterns = "/consider.do")
@Controller
public class ConsideController extends HttpServlet{
    @Autowired
    private IOrderService prodService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            prodService.consider(id);
            req.setAttribute("Error", "");
            resp.sendRedirect("/main.do");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("Error", "Что-то пошло не так! Попробуйте еще раз!");
            resp.sendRedirect("/main.do");
        }
    }
}
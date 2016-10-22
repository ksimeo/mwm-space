package com.ksimeo.arsu.admin.controllers;

import com.ksimeo.arsu.admin.services.IOrderService;
import com.ksimeo.arsu.core.models.Basket;
import com.ksimeo.arsu.core.models.User;
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
import java.util.List;

/**
 * @author Ksimeo 14.11.2015/15:15. Project: MArsMarketSpace.
 */
@WebServlet(urlPatterns = "/main.do")
@Controller
public class MainController extends HttpServlet {
    @Autowired
    private IOrderService orderService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Basket> orders = orderService.getNewOrders();
            User currUsr = (User)req.getSession().getAttribute("user");
            req.setAttribute("username", currUsr.getName());
            req.setAttribute("orders", orders);
            req.setAttribute("Error", "");
            req.getRequestDispatcher("WEB-INF/admin.jsp").forward(req, resp);
        } catch (Exception e) {
            req.setAttribute("Error", "Список заказов временно недоступен. Пожалуйста, попробуйте через время еще раз.");
            e.printStackTrace();
        }
    }
}
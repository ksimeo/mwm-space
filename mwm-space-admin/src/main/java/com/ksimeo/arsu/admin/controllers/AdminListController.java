package com.ksimeo.arsu.admin.controllers;

import com.ksimeo.arsu.admin.services.IOrderService;
import com.ksimeo.arsu.core.models.Basket;
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
 * Created by @Ksimeo on 15.11.2015 at 17:11. For project MArsMarketSpace.
 */
@WebServlet(urlPatterns = "/seehistory.do")
@Controller
public class AdminListController extends HttpServlet {
    @Autowired
    private IOrderService orderService;
//    = new OrderServiceMock();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int page = Integer.parseInt(req.getParameter("p"));
            req.setAttribute("currpage", page);
            List<Basket> baskets = orderService.getOrderPage(page);
            req.setAttribute("orders", baskets);
            req.getRequestDispatcher("WEB-INF/adminslist.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

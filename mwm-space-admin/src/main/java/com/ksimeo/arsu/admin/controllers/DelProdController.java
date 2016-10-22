package com.ksimeo.arsu.admin.controllers;

import com.ksimeo.arsu.admin.services.IProdService;
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
 * Created by @author Ksimeo on 12.12.2015 at 22:46. For project: MArsMarketSpace.
 */
@WebServlet(urlPatterns = "/delprod.do")
@Controller
public class DelProdController extends HttpServlet {
    @Autowired
    private IProdService prodService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            int id = Integer.parseInt(req.getParameter("id"));
            String tid = req.getParameter("tid");
            String gid = req.getParameter("gid");
            prodService.delProduct(id);
            resp.sendRedirect("products.do?tid=" + tid + "&gid=" + gid + "&prev_tid=" + tid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.ksimeo.arsu.admin.controllers;

import com.ksimeo.arsu.admin.services.IProdService;
import com.ksimeo.arsu.core.models.Product;
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
 * Created by @author Ksimeo on 05.12.2015 at 19:33. For project: MArsMarketSpace.
 */
@WebServlet(urlPatterns = "/createprod.do")
@Controller
public class CreateProdController extends HttpServlet {
    @Autowired
    IProdService productService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String tid = req.getParameter("tid");
        String gid = req.getParameter("gid");
        req.setAttribute("tid", tid);
        req.setAttribute("gid", gid);
        req.getRequestDispatcher("WEB-INF/createproduct.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        try {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");
            String typeID = req.getParameter("tid");
            String groupID = req.getParameter("gid");
            String prodName = req.getParameter("prod_name");
            String prodModel = req.getParameter("prod_model");
            String producer = req.getParameter("producer");
            String country = req.getParameter("country");
            String description = req.getParameter("description");
            String prodPrice = req.getParameter("prod_price");
            if(prodName != null &&
               prodModel != null &&
               producer != null &&
               country != null &&
               prodPrice != null) {
                double price = Double.parseDouble(prodPrice);
                Product newProduct = new Product(prodName, prodModel, producer, country, description, price);
                productService.addProduct(newProduct);
                resp.sendRedirect("/products.do?tid=" + typeID + "&gid=" + groupID + "&prev_tid=" + typeID);
            } else {
                req.setAttribute("formError", "Вы не заполнили все необходимые поля!");
                req.getRequestDispatcher("WEB-INF/createproduct.jsp").forward(req, resp);
            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            req.setAttribute("formError", "К сожалению не удалось сохранить новый продукт./r/n" +
//                    "Пожалуйста, попробуйте, повторить вашу попытку позже.");
//            req.getRequestDispatcher("WEB-INF/createproduct.jsp").forward(req, resp);
//        }
    }
}

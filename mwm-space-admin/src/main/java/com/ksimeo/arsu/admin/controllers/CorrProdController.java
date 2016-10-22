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
 * Created by @author Ksimeo on 05.12.2015 at 20:12. For project: MArsMarketSpace.
 */
@WebServlet(urlPatterns = "/corprod.do")
@Controller
public class CorrProdController extends HttpServlet {
    @Autowired
    private IProdService productService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        int typeID = Integer.parseInt(req.getParameter("tid"));
        int groupID = Integer.parseInt(req.getParameter("gid"));
        int prodID = Integer.parseInt(req.getParameter("id"));
        Product prod = productService.getProduct(prodID);
        req.setAttribute("type_id", typeID);
        req.setAttribute("group_id", groupID);
        req.setAttribute("prod_id", prodID);
        req.setAttribute("prev_name", prod.getName());
        req.setAttribute("prev_model", prod.getModel());
        req.setAttribute("producer", prod.getProducer());
        req.setAttribute("country", prod.getCountry());
        req.setAttribute("description", prod.getDescription());
        req.setAttribute("prev_price", prod.getPrice());
        req.getRequestDispatcher("WEB-INF/corproduct.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product prod = new Product();
        try {
            req.setCharacterEncoding("UTF-8");
            int id = Integer.parseInt(req.getParameter("prod_id"));
            String groupID = req.getParameter("group_id");
            String typeID = req.getParameter("type_id");
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
                prod = productService.getProduct(id);
                if (!(prod.getName()).equals(prodName)) prod.setName(prodName);
                if (!(prod.getModel()).equals(prodModel)) prod.setModel(prodModel);
                if (!(prod.getProducer()).equals(producer)) prod.setProducer(producer);
                if (!(prod.getCountry()).equals(country)) prod.setCountry(country);
                if (!(prod.getDescription()).equals(description)) prod.setDescription(description);
                productService.addProduct(prod);
                resp.sendRedirect("/products.do?tid=" + typeID + "&gid=" + groupID + "&prev_tid=" + typeID);
            } else {
                req.setAttribute("formError", "Вы не заполнили все необходимые поля формы!");
                req.getRequestDispatcher("WEB-INF/createproduct.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("prod_id", prod.getId());
            req.setAttribute("prev_name", prod.getName());
            req.setAttribute("prev_model", prod.getModel());
            req.setAttribute("producer", prod.getProducer());
            req.setAttribute("country", prod.getCountry());
            req.setAttribute("description", prod.getDescription());
            req.setAttribute("prev_price", prod.getPrice());
            req.setAttribute("formError", "К сожалению не удалось сохранить изменения! Попробуйте, пожалуйста, ещё раз!");
            req.getRequestDispatcher("WEB-INF/corproduct.jsp").forward(req, resp);
        }
    }
}

package com.ksimeo.arsu.admin.controllers;

import com.ksimeo.arsu.admin.services.IGroupService;
import com.ksimeo.arsu.admin.services.IProdService;
import com.ksimeo.arsu.admin.services.ITypeService;
import com.ksimeo.arsu.core.models.ProdGroup;
import com.ksimeo.arsu.core.models.ProdType;
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
import java.util.List;

/**
 * Created by @author Ksimeo on 17.11.2015 at 15:43. For project: MArsMarketSpace.
 */
@WebServlet(urlPatterns = "/products.do")
@Controller
public class ProdController extends HttpServlet {
    @Autowired
    private ITypeService typeService;
    @Autowired
    private IGroupService groupService;
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
            resp.setContentType("text/html; charset=UTF-8");
            String prevTypeID = req.getParameter("prev_tid");
            if (prevTypeID == null) prevTypeID = "0";
            int p_type = Integer.parseInt(prevTypeID);
            int tid = Integer.parseInt(req.getParameter("tid"));
            int gid = Integer.parseInt(req.getParameter("gid"));
            req.setAttribute("type_id", tid);
            List<ProdType> types = typeService.getAllTypes();
            List<ProdGroup> groups = groupService.getGroups(tid);
            List<Product> products = prodService.getProducts(gid);
            req.setAttribute("types", types);
            if (tid != 0) {
                req.setAttribute("groups", groups);
                req.setAttribute("typeID", tid);
                if (gid == 0) {
                    req.setAttribute("tabler", "hidden");
                    req.setAttribute("disabled_", "disabled");
                } else {
                    req.setAttribute("t_instead", "hidden");
                    if (p_type == tid) {
                        req.setAttribute("typeID", tid);
                        req.setAttribute("groupID", gid);
                        req.setAttribute("products", products);
                    } else {

                        req.setAttribute("selected", "selected");
                    }
                }
            } else {
                req.setAttribute("tabler", "hidden");
                req.setAttribute("disabled", "disabled");
                req.setAttribute("disabled_", "disabled");
            }
            req.setAttribute("prev_tid", tid);
            req.getRequestDispatcher("WEB-INF/products.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
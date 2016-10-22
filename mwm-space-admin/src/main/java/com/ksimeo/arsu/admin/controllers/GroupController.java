package com.ksimeo.arsu.admin.controllers;

import com.ksimeo.arsu.admin.services.IGroupService;
import com.ksimeo.arsu.admin.services.ITypeService;
import com.ksimeo.arsu.core.models.ProdGroup;
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
 * Created by @author Ksimeo on 06.12.2015 at 21:28. For project: MArsMarketSpace.
 */
@WebServlet(urlPatterns = "/groupes.do")
@Controller
public class GroupController extends HttpServlet {
    @Autowired
    private IGroupService groupService;
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
        String tid = req.getParameter("tid");
        int typeID = Integer.parseInt(tid);
        List<ProdGroup> groups = groupService.getGroups(typeID);
        String typeName = typeService.getType(typeID).getName();
        req.setAttribute("groups", groups);
        req.setAttribute("typename", typeName);
        req.setAttribute("type_id", tid);
        req.getRequestDispatcher("WEB-INF/groups.jsp").forward(req, resp);
    }
}
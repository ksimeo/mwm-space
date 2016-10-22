package com.ksimeo.arsu.admin.filters;

import com.ksimeo.arsu.core.models.User;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by @author Ksimeo on 18.12.2015 at 14:14. For project: MArsMarketSpace.
 */
//@WebFilter(urlPatterns = "/*")
public class SecureFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession(false);
        String uri = req.getRequestURI();
        Cookie[] cookies = req.getCookies();
        boolean isLogedIn = false;
        User currUser;
        if (session != null && cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    currUser = (User) session.getAttribute("user");
                    if (currUser == null) break;
                    isLogedIn = (cookie.getValue()).equalsIgnoreCase(currUser.getLogin());
                    break;
                }
            }
        }
        if (!isLogedIn && (uri.endsWith(".do"))) {
            resp.sendRedirect("/index.jsp");
        }
//        else {
//            if (currUser != null) {
//                if (uri.endsWith("/logout")) filterChain.doFilter(servletRequest, servletResponse);
//            } else if (!(currUser.isAdmin()) &&
//                    !(uri.endsWith(".do"))
//                    ) {
//                resp.sendRedirect("/404.jsp");
//            } else if (!currUser.isAdmin() &&
//                    !(uri.endsWith("/user.do"))
////                    &&
//
//                    ) {
//                resp.sendRedirect("/404.jsp");
//            } else {
                filterChain.doFilter(servletRequest, servletResponse);
//            }
//        }
    }

    @Override
    public void destroy() { }
}

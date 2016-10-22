//package com.ksimeo.arsu.admin.filters;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @author Ksimeo 14.11.2015/13:59. Project: MArsMarketSpace.
// */
//@WebFilter(urlPatterns = "/*.do")
//public class LoginFilter implements Filter {
//    public void init(FilterConfig filterConfig) throws ServletException { }
//
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//           HttpServletRequest req = (HttpServletRequest) servletRequest;
//           HttpServletResponse resp = (HttpServletResponse) servletResponse;
//           String login = req.getParameter("login");
//           String password = req.getParameter("password");
//           boolean isError = false;
//           if ((login == null) || (login.isEmpty())) {
//               req.setAttribute("Error", "Вы не заполнили все поля!");
//               req.getRequestDispatcher("/index.jsp").forward(req, resp);
//           }
//           if ((login == null) || (login.isEmpty())) {
//               req.setAttribute("Error", "Вы не заполнили все поля!");
//               req.getRequestDispatcher("/index.jsp").forward(req, resp);
//           }
//           filterChain.doFilter(servletRequest, servletResponse);
//    }
//
//    public void destroy() { }
//}
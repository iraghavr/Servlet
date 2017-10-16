package com.autumn.zen.java;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/setContext")
public class ContextSetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        String key = request.getParameter("key");
        String value = request.getParameter("value");
        if (key == null || key.length() == 0 || key == null || key.length() == 0) {
            out.println("key or value cannot be null or empty.");
            return;
        }

        // set context
        ServletContext context = getServletContext();
        context.setAttribute(key,value);
        out.println("Success");
    }}

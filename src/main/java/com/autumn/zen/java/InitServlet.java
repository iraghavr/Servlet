package com.autumn.zen.java;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class InitServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        ServletConfig config = getServletConfig();

        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();

        Enumeration<String> initParams = config.getInitParameterNames();
        while (initParams.hasMoreElements()) {
            String initParam = initParams.nextElement();
            out.println(initParam + ":" + config.getInitParameter(initParam));
        }
    }
}

package com.areaofit.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class HelloServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String contextPath = req.getContextPath();
        System.out.println("contextPath: "+contextPath);

        System.out.println("CharacterEncoding: "+req.getCharacterEncoding());

        Enumeration<?> enumeration = req.getHeaderNames();
        while (enumeration.hasMoreElements()){
            String headName = (String) enumeration.nextElement();
            System.out.println(headName+": "+req.getHeader(headName));
        }
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("<h2>HelloServlet,我是黄金文</h2>");
        printWriter.flush();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}

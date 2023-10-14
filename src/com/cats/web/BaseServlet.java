package com.cats.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String method = request.getParameter("method");
        if (method == null || method.isEmpty() || method.trim().isEmpty()) {
            method = "execute";
        }
        System.out.println("method=" + method);
        try {
            Method method1 = this.getClass().getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            System.out.println(method1);
            if (method1 != null) {
                String invoke = (String) method1.invoke(this, request, response);
                if (invoke != null && !invoke.trim().isEmpty()) {
                    System.out.println(invoke);
                    request.getRequestDispatcher(invoke).forward(request, response);
                } else {
                    System.out.println("BaseServlet.invoke is null");
                }
            }
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

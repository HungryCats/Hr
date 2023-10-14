package com.cats.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        //处理post请求的乱码问题
        request.setCharacterEncoding("UTF-8");
        //判断访问路径是否和登录注册页面相关
        String[] urls = {"/userServlet","/login.jsp","/register.jsp","/brandServlet","/css","/images"};
        //获取当前访问的资源路径
        String url = req.getRequestURI().toString();

        //循环判断
        for (String u : urls) {
            if (url.contains(u)) {
                //找到了
                //放行
                chain.doFilter(request, response);
                return;
            }
        }
        //1.判断session 中是否有user
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");

        //2. 判断user 是否为null
        if(user != null){
            //登录过了
            //放行
            chain.doFilter(request, response);
        }else {
            // 没有登录
            req.setAttribute("login_msg","您尚未登录");
            req.getRequestDispatcher("/login.jsp").forward(req,response);
        }

    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

}

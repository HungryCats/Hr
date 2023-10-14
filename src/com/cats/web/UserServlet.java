package com.cats.web;

import com.cats.pojo.User;
import com.cats.service.Impl.UserServiceImpl;
import com.cats.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/userServlet")
public class UserServlet extends BaseServlet {
    private final UserService userService = new UserServiceImpl();

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接受用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 获取复选框数据
        String remember = request.getParameter("remember");
        //调用service查询
        User user = userService.login(username, password);
        //3. 判断user释放为null
        if (user != null) {
            // 登陆成功,跳转到查询所有的BrandServlet

            //判断用户是否勾选记住我
            if ("1".equals(remember)) {
                //勾选了，发送Cookie
                //1.创建发送Cookie对象
                Cookie c_username = new Cookie("username", username);
                Cookie c_password = new Cookie("password", password);

                //设置Cookie存活时间
                c_username.setMaxAge(60 * 60 * 24 * 7);
                c_password.setMaxAge(60 * 60 * 24 * 7);

                //2.发送
                response.addCookie(c_username);
                response.addCookie(c_password);
            }

            // 将登录成功后的user对象，存储到session
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            //动态虚拟目录
            String contextPath = request.getContextPath();
            //重定向
            response.sendRedirect(contextPath + "/brandServlet?method=selectAllBrand");
        } else {
            // 登陆失败
            // 跳转 404.jsp
            request.getRequestDispatcher("404.jsp").forward(request, response);
        }
    }

    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取用户名和密码数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //调用service注册
        User user = userService.register(username, password);
        if (user != null && !username.equals(request.getParameter("username"))) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            request.setAttribute("register_msg", "用户名已存在");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }

    }
}

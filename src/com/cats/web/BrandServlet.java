package com.cats.web;

import com.cats.pojo.Brand;
import com.cats.service.BrandService;
import com.cats.service.Impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/brandServlet")
public class BrandServlet extends BaseServlet {
    private final BrandService brandService = new BrandServiceImpl();

    /**
     * 查询所有
     * @param request 请求
     * @param response 响应
     * @throws ServletException 抛异常
     * @throws IOException 抛异常
     */
    public void selectAllBrand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用BrandService完成查询
        List<Brand> brands = brandService.selectAllBrand();
        //2.存入request域中
        request.setAttribute("brands", brands);
        //3.转发到brand.jsp
        request.getRequestDispatcher("brand.jsp").forward(request, response);
    }

    /**
     * 添加数据
     * @param request 请求
     * @param response 响应
     * @throws ServletException 抛异常
     * @throws IOException 抛异常
     */
    public void addBrand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理post请求的乱码问题
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //1.接受表单提交的数据
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        String money = request.getParameter("money");
        //2.调用brandService完成添加
        Brand brand = brandService.addBrand(name, pwd, money);
        //3.转发到查询所有Servlet
        selectAllBrand(request, response);

    }

    /**
     * 删除数据
     * @param request 请求
     * @param response 响应
     * @throws ServletException 抛异常
     * @throws IOException 抛异常
     */
    public void deleteById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接受表单提交的数据
        String id = request.getParameter("id");
        //2.调用brandService完成删除
        Brand brand = brandService.deleteById(id);
        //3.转发到查询所有Servlet
        selectAllBrand(request, response);
    }

    /**
     * 修改数据前的回显数据
     * @param request 请求
     * @param response 响应
     * @throws ServletException 抛异常
     * @throws IOException 抛异常
     */
    public void selectById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接受表单提交的数据
        String id = request.getParameter("id");
        //1.调用BrandService完成查询
        Brand brand = brandService.selectById(id);
        //2.存入request域中
        request.setAttribute("brand", brand);
        //3.转发到updateBrand.jsp
        request.getRequestDispatcher("updateBrand.jsp").forward(request, response);
    }

    /**
     * 修改数据
     * @param request 请求
     * @param response 响应
     * @throws ServletException 抛异常
     * @throws IOException 抛异常
     */
    public void updateBrand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理post请求的乱码问题
        request.setCharacterEncoding("UTF-8");
        //设置response编码
        response.setCharacterEncoding("UTF8");
        //设置相应内容（告诉浏览器这是一个什么东西，以什么编码加载啊它）
        response.setContentType("text/html;charset=UTF8");

        //1.接受表单提交的数据，封装为一个Brand对象
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        String money = request.getParameter("money");

        Brand brand = new Brand();
        //brand.setId(Integer.parseInt(id));
        brand.setName(name);
        brand.setPwd(pwd);
        brand.setMoney(money);
        //2.调用brandService完成修改
        int i = brandService.updateBrand(brand, id);
        //3.转发到查询所有Servlet
        selectAllBrand(request, response);
    }
}

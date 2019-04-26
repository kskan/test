package com.imooc.servlet;

import com.imooc.servicempl.CourseDao;
import com.imooc.servicempl.CourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SelectUserServlet")
public class SelectUserServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //显示所有管理员
        CourseService cd = new CourseDao();
        request.getSession().setAttribute("list",cd.getAllUsers());
        response.sendRedirect(request.getContextPath()+"/pages/admin/selectUsers.jsp");
    }
}

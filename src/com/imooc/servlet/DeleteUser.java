package com.imooc.servlet;

import com.imooc.servicempl.CourseDao;
import com.imooc.servicempl.CourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //删除用户信息
        CourseService cd = new CourseDao();
        String deleteuser=request.getParameter("username");
        cd.delUser(deleteuser);
        request.getRequestDispatcher("/pages/admin/selectUsers.jsp").forward(request,response);

    }
}

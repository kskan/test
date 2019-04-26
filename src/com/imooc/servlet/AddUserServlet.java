package com.imooc.servlet;

import com.imooc.servicempl.CourseDao;
import com.imooc.servicempl.CourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //添加管理员
        CourseService cd = new CourseDao();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String message="";
        //检查用户是否正确
        if(!password.matches("[0-9a-zA-Z_]{3,12}"))message="密码输入不正确";
        if(!username.matches("[0-9a-zA-Z_]{3,12}"))message="用户名输入不正确";
        if("".equals(message)){
            cd.addUser(username,username);
            request.getRequestDispatcher("/pages/admin/addUser.jsp?flag=2").forward(request,response);
            return;

        }else{
            request.setAttribute("message",message);
            request.getRequestDispatcher("/pages/admin/addUser.jsp?flag=1").forward(request,response);
            return;
        }
    }



}

package com.imooc.servlet;


import com.imooc.servicempl.CourseDao;
import com.imooc.servicempl.CourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //登陆
        CourseService cd = new CourseDao();
        HttpSession session = request.getSession();
        String adminname = request.getParameter("username");
        String adminpassword = request.getParameter("password");
        String code=request.getParameter("checkCode");
        String sessionCode=(String)session.getAttribute("code");
        if(code.toUpperCase().equals(sessionCode)) {


            if (cd.login(adminname, adminpassword) == 1) {

                session.setAttribute("loginname", adminname);

                request.getRequestDispatcher("/pages/admin/server.jsp").forward(request, response);

            } else {
                request.getRequestDispatcher("/index.jsp?flag=1").forward(request, response);
            }
        }else {
            request.getRequestDispatcher("/index.jsp?flag=2").forward(request,response);
        }


    }

}

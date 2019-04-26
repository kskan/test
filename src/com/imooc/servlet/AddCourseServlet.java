package com.imooc.servlet;

import com.imooc.domain.Course;
import com.imooc.servicempl.CourseDao;
import com.imooc.servicempl.CourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddCourseServlet")
public class AddCourseServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      添加课程信息
        CourseService cd = new CourseDao();
        String courseId = request.getParameter("courseId");
        String courseName = request.getParameter("courseName");
        String courseType = request.getParameter("courseType");
        String description = request.getParameter("description");
        String courseTime = request.getParameter("courseTime");
        String operator = request.getParameter("operator");

//      确认是否留空
        if (!"".equals(courseId) && !"".equals(courseName) && !"".equals(courseType) && !"".equals(description) && !"".equals(courseTime)
                && !"".equals(operator)) {
            Course course = new Course(courseId, courseName, courseType, description, courseTime, operator);
            System.out.println(course.toString());
            cd.addCourse(course);
            request.getRequestDispatcher("/pages/admin/addCourse.jsp?flag=1").forward(request, response);

        } else {
            request.getRequestDispatcher("/pages/admin/addCourse.jsp?flag=2").forward(request, response);
        }
    }


}

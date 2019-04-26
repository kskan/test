package com.imooc.servlet;

import com.imooc.servicempl.CourseDao;
import com.imooc.servicempl.CourseService;
import com.imooc.servicempl.ExcelService;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ExportCourseServlet")
public class ExportCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //导出 Excel
        CourseService cd=new CourseDao();
         cd.exportCourse(response);
    }
}

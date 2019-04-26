package com.imooc.servlet;

import com.imooc.domain.Course;
import com.imooc.dto.ImportExcelParamDto;
import com.imooc.dto.ImportExcelResultDto;
import com.imooc.dto.ParamDto;
import com.imooc.servicempl.CourseDao;
import com.imooc.servicempl.CourseService;
import com.imooc.servicempl.ExcelService;
import com.imooc.util.RequestUtil;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/CourseImportServlet")
public class CourseImportServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //批量上传课程
        if(ServletFileUpload.isMultipartContent(request)){
            CourseService cd=new CourseDao();
             ParamDto dto = RequestUtil.parseParam(request);
             ImportExcelParamDto paramDto = new ImportExcelParamDto();
             paramDto.setTitle(dto.getParamMap().get("file1"));
             paramDto.setExcel(dto.getFileMap().get("file1"));
//             System.out.println(dto.getFileMap());
//             System.out.println(dto.getParamMap());

             ExcelService service = new ExcelService();
             ImportExcelResultDto resultDto = service.imp(paramDto);
            ArrayList<ArrayList<String>> list1=new ArrayList<ArrayList<String>>();
            for(Course course:resultDto.getCourseList()){
                ArrayList<String> list2=new ArrayList<>();
                list2.add(course.getCourseId());
                list2.add(course.getCourseName());
                list2.add(course.getCourseType());
                list2.add(course.getDescription());
                list2.add(course.getCourseTime());
                list2.add(course.getOperator());
//                System.out.println(list2);
                list1.add(list2);
            }

            cd.importCourse(list1);
             request.setAttribute("result",resultDto);
            request.getRequestDispatcher("/pages/admin/courseImport.jsp?massage="+resultDto.getMsg()).forward(request,response);
            return;
         }
        request.getRequestDispatcher("/pages/admin/courseImport.jsp").forward(request,response);

    }


}

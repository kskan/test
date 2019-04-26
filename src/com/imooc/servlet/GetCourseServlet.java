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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/GetCourseServlet")
public class GetCourseServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //显示课程信息
        CourseService cd = new CourseDao();
        List<Course> list=new ArrayList<>();
        List<Course> seachlist=new ArrayList<>();
        String name=request.getParameter("name");
        //搜索功能：若没有搜索内容，则返回全部列表
        if (null != name && !"".equals(name)) {
            request.getSession().setAttribute("name",name);
            for(Course course:cd.getAllCourse()){
                if(course.getCourseName().contains(name)){
                    seachlist.add(course);
                }
            }

        } else {
            request.getSession().setAttribute("name",null);
            for(Course course:cd.getAllCourse()) {
                seachlist.add(course);
            }
        }

        String pageStr = request.getParameter("page");
        int page = 1;
        if (null != pageStr && !"".equals(pageStr)) {
            page = Integer.parseInt(pageStr);
        }
//      分页
        int totalProducts = seachlist.size();
        int totallast=0;
        request.getSession().setAttribute("totalProducts",totalProducts);
        int totalPage = totalProducts % 5 > 0 ? totalProducts / 5 + 1 : totalProducts / 5;

        request.setAttribute("curPage", page);
        request.setAttribute("prePage", page > 1 ? page - 1 : 1);
        request.setAttribute("nextPage", totalPage > page ? page + 1 : totalPage);
        request.setAttribute("totalPage", totalPage);

        try{
        for(int i=(page*5)-5 ;i<(page*5);i++){
            //遍历，显示所局部信息
            list.add(seachlist.get(i));
            totallast=i;

//            System.out.println(cd.getAllCourse().get(i).toString());
        }}catch (Exception e){
            e.printStackTrace();
        }

        request.getSession().setAttribute("totallast",totallast+1);
        request.getSession().setAttribute("list", list);
       request.getRequestDispatcher("/pages/admin/showCourse.jsp").forward(request,response);
    }
}

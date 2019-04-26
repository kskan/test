package com.imooc.servicempl;

import com.imooc.domain.Course;
import org.apache.poi.ss.usermodel.Workbook;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseDao implements CourseService  {

    public CourseDaoImpl mpl;
    //登陆
    public int login(String username, String password) {
        int flag=0;
        for(Map map:mpl.usersTable){
            if(username.equals(map.get("adminname"))&&password.equals(map.get("adminpassword")))
                flag=1;
        }
        return flag;
    }
     //添加管理员
    public void addUser(String username, String password){
        Map<String, Object> map=new HashMap<String,Object>();
        map.put("adminname",username);
        map.put("adminpassword",password);
        mpl.usersTable.add(map);


    }
    //获取所有管理员
    public List<Map<String, Object>> getAllUsers(){
        return mpl.usersTable;
    }
    //删除用户
    public void delUser(String username){
        List <Map<String,Object>> delmap=new ArrayList<>();
        for(Map map:mpl.usersTable){
            if(map.get("adminname").equals(username)){
                delmap.add(map);

            }
        }
        mpl.usersTable.removeAll(delmap);

    }
    //添加管理员
    public void addCourse(Course couse){
        mpl.coursesTable.add(couse);

    }
    //获取所有课程
    public List<Course> getAllCourse(){

        return mpl.coursesTable;
    }
    //导入课程表
    public void importCourse(ArrayList<ArrayList<String>> courseList){
        for(List list:courseList){
            Course course=new Course();
            course.setCourseId(String.valueOf(list.get(0)));
            course.setCourseName(String.valueOf(list.get(1)));
            course.setCourseType(String.valueOf(list.get(2)));
            course.setDescription(String.valueOf(list.get(3)));
            course.setCourseTime(String.valueOf(list.get(4)));
            course.setOperator(String.valueOf(list.get(5)));
//            System.out.println(course.toString());
            this.addCourse(course);
        }

    }
//  导出课程表
    @Override
    public void exportCourse(HttpServletResponse response) {
        ExcelService service = new ExcelService();
        Workbook workbook = service.export(true);
        response.setHeader("Content-Disposition", "attachment;filename=export.xlsx");
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            // 直接将文件输出提供下载导出
            workbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
            workbook.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}

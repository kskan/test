package com.imooc.servicempl;

import com.imooc.domain.Course;


import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface CourseService  {
    public int login(String username, String password);
    public void addUser(String username, String password);
    public List<Map<String, Object>> getAllUsers();
    public void delUser(String username);
    public void addCourse(Course course);
    public List<Course> getAllCourse();
    public void importCourse(ArrayList<ArrayList<String>> courseList);
    public void exportCourse(HttpServletResponse response);

}

package com.imooc.servicempl;

import com.imooc.domain.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface CourseServiceImpl {
    CourseDao cd = new CourseDaoImpl();
    public static final List<Map<String, Object>> usersTable=new ArrayList<Map<String, Object>>();
    public static final List<Course> coursesTable=new ArrayList<>();
    

}

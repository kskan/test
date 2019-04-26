package com.imooc.servicempl;

import com.imooc.domain.Course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseDaoImpl extends CourseDao  implements CourseServiceImpl{
  //管理员表
    public static final List<Map<String, Object>> usersTable=new ArrayList<Map<String, Object>>();
//    课程表
    public static final List<Course> coursesTable=new ArrayList<>();
    static {
        Map<String,Object> imooc=new HashMap<String,Object>();
        imooc.put("adminname","imooc");
        imooc.put("adminpassword","imooc");
        usersTable.add(imooc);
    }
}

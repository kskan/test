package com.imooc.dto;

import com.imooc.domain.Course;

import java.util.List;

public class ImportExcelResultDto {
    private String title;
    private List<Course> CourseList;
    private  String msg;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Course> getCourseList() {
        return CourseList;
    }

    public void setCourseList(List<Course> courseList) {
        CourseList = courseList;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

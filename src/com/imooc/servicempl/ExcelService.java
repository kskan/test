package com.imooc.servicempl;

import com.imooc.domain.Course;
import com.imooc.dto.ImportExcelParamDto;
import com.imooc.dto.ImportExcelResultDto;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelService {

//   Excel导入课程
    public ImportExcelResultDto imp(ImportExcelParamDto dto) {

        ImportExcelResultDto result =new ImportExcelResultDto();
        result.setTitle(dto.getTitle());
        List<Course> courseList = new ArrayList<>();
        result.setCourseList(courseList);



        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(dto.getExcel().getInputStream());
            Sheet sheet = workbook.getSheetAt(0);
            int rowNum = sheet.getLastRowNum();
            for(int i = 1; i <= rowNum; i++) {
                Row row = sheet.getRow(i);
                Course course = new Course();
                courseList.add(course);
                course.setCourseId(String.valueOf((int)row.getCell(0).getNumericCellValue()));
                course.setCourseName(row.getCell(1).getStringCellValue());
                course.setCourseType(row.getCell(2).getStringCellValue());
                course.setDescription(row.getCell(3).getStringCellValue());
                course.setCourseTime(String.valueOf((int)row.getCell(4).getNumericCellValue()));
                course.setOperator(row.getCell(5).getStringCellValue());
//                System.out.println(course.toString());


            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg("解析Excel失败！");
        } finally {
            if(workbook != null) {
                try {
                    workbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }
//    导出到Excel
    public Workbook export(boolean isXlsx) {
        Workbook workbook;
        if(isXlsx) {
            workbook = new XSSFWorkbook();
        } else {
            workbook = new HSSFWorkbook();
        }
        Sheet sheet = workbook.createSheet("My Sheet");
        List<List<String>> content = this.getContent();
        for(int i = 0; i < content.size(); i++) {
            Row row = sheet.createRow(i);
            List<String> rowData = content.get(i);
            for(int j  = 0; j < rowData.size(); j++) {
                row.createCell(j).setCellValue(rowData.get(j));
            }
        }
        return workbook;
    }
    //制作课程表
    private List<List<String>> getContent() {
        List<List<String>> result = new ArrayList<>();
        List<String> row = new ArrayList<>();
        result.add(row);
        row.add("课程ID");
        row.add("课程名");
        row.add("方向");
        row.add("描述");
        row.add("时长");
        row.add("操作人");
        CourseService cd=new CourseDao();
        List<Course> list=cd.getAllCourse();
        for(Course co:list){
            row = new ArrayList<>();
            result.add(row);
            row.add(co.getCourseId());
            row.add(co.getCourseName());
            row.add(co.getCourseType());
            row.add(co.getDescription());
            row.add(co.getCourseTime());
            row.add(co.getOperator());

        }
        return result;
    }
}

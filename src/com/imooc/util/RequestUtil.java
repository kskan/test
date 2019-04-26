package com.imooc.util;

import com.imooc.dto.ParamDto;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

public class RequestUtil {

    /**
     * 从request流中解析参数与上传的文件
     * @param request
     */
    public static ParamDto parseParam(HttpServletRequest request) {
        ParamDto result = new ParamDto();
        ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
        upload.setHeaderEncoding("UTF-8");
        try {
            List<FileItem> fileItemList = upload.parseRequest(request);
            for(FileItem fileItem : fileItemList) {
                if(fileItem.isFormField()) {
                } else {
                    String fileName=fileItem.getName();
                    String uuidFileName=UploadUtils.getUUIDFileName(fileName);
                    result.getParamMap().put(fileItem.getFieldName(),uuidFileName);
                    String path=request.getServletContext().getRealPath("/upload");
                    fileItem.write(new File(path +"/"+ uuidFileName));
                    System.out.println(path+uuidFileName);
                    result.getFileMap().put(fileItem.getFieldName(),fileItem);
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

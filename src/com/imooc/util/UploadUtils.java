package com.imooc.util;

import java.util.UUID;

public class UploadUtils {
	public static String getUUIDFileName(String fileName) {
		//重新更改文件名字（避免同文件名）
		int idx=fileName.lastIndexOf(".");
		String extention=fileName.substring(idx);
		String uuidFileName=UUID.randomUUID().toString().replace("-", "")+extention;
		return uuidFileName;
	}
//    public static void main(String[] args) {
//    	System.out.println(getUUIDFileName("1.jpg"));
//    }

}

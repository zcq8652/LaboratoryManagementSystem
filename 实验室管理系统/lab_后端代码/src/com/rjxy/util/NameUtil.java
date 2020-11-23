package com.rjxy.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class NameUtil {
	public static String getName() {
        // 获得当前时间
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        // 转换为字符串
        String formatDate = format.format(new Date());
        // 随机生成文件编号
        int random = new Random().nextInt(10000);
        return new StringBuffer().append(formatDate).append(
                random).toString();
    }
	public static String getFileType(String filename){
	        if(filename.endsWith(".jpg") || filename.endsWith(".jepg")){
	        	return ".jpg";
	        }else if(filename.endsWith(".png") || filename.endsWith(".PNG")){
	        	return ".png";
	        } else{
	            return "application/octet-stream";
	        }
	}
}

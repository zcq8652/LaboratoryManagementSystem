package com.rjxy.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class NameUtil {
	public static String getName() {
        // ��õ�ǰʱ��
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        // ת��Ϊ�ַ���
        String formatDate = format.format(new Date());
        // ��������ļ����
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

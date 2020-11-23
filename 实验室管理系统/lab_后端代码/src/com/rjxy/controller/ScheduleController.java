package com.rjxy.controller;

import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.rjxy.model.Lab;
import com.rjxy.model.Schedule;
import com.rjxy.service.ILabService;
import com.rjxy.service.IScheduleService;


@Controller
@RequestMapping("/Schedule")
public class ScheduleController {
	private IScheduleService scheduleService;
	@Resource
	public void setScheduleService(IScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}
	private ILabService labService;
	@Resource
	public void setLabService(ILabService labService) {
		this.labService = labService;
	}
	@RequestMapping("/upload")
	public void upload(@RequestParam("file") MultipartFile file,HttpServletRequest request, HttpServletResponse response){
		try {
			// @RequestParam("file") MultipartFile file 是用来接收前端传递过来的文件
			// 创建workbook对象，读取整个文档
			InputStream inputStream = file.getInputStream();
			POIFSFileSystem poifsFileSystem = new POIFSFileSystem(inputStream);
			HSSFWorkbook wb = new HSSFWorkbook(poifsFileSystem);
			//获取实验室数据
			List<Lab> labs = labService.list();
			//对接数据
			for(int e = 0 ; e < labs.size() ; e++){
				String id = labs.get(e).getL_Id();
				for(int f = 0 ; f < wb.getNumberOfSheets() ; f++){
					if(wb.getSheetAt(f).getSheetName().equals(id)){
						HSSFSheet sheetAt = wb.getSheetAt(f);
						//创建数据封装类
						Schedule schedule = new Schedule();
						//循环判断变量
						int a = 2;
						int b = 4;
						int c = 1;
						for(int i = 0 ; i < 6 ; i++){
							// 循环读取特定行数据
							int n = 1;
							for(int l = a ; l < a+4 ; l++){
								Row row = sheetAt.getRow(l);
								// 循环读取特定列数据
								for(int j = 2 ; j <= 8 ; j++){
									if(n == 1){
										switch(j){
										case 2:
												schedule.setMon(row.getCell(j).getStringCellValue());
												break;
										case 3:
												schedule.setTue(row.getCell(j).getStringCellValue());
												break;
										case 4:
												schedule.setWed(row.getCell(j).getStringCellValue());
												break;
										case 5:
												schedule.setThurs(row.getCell(j).getStringCellValue());
												break;
										case 6:
												schedule.setFri(row.getCell(j).getStringCellValue());
												break;
										case 7:
												schedule.setSat(row.getCell(j).getStringCellValue());
												break;
										case 8:
												schedule.setSun(row.getCell(j).getStringCellValue());
												break;
										}
									}else{
										switch(j){
										case 2:
												schedule.setMon(schedule.getMon()+"\n"+row.getCell(j).getStringCellValue());
												break;
										case 3:
												schedule.setTue(schedule.getTue()+"\n"+row.getCell(j).getStringCellValue());
												break;
										case 4:
												schedule.setWed(schedule.getWed()+"\n"+row.getCell(j).getStringCellValue());
												break;
										case 5:
												schedule.setThurs(schedule.getThurs()+"\n"+row.getCell(j).getStringCellValue());
												break;
										case 6:
												schedule.setFri(schedule.getFri()+"\n"+row.getCell(j).getStringCellValue());
												break;
										case 7:
												schedule.setSat(schedule.getSat()+"\n"+row.getCell(j).getStringCellValue());
												break;
										case 8:
												schedule.setSun(schedule.getSun()+"\n"+row.getCell(j).getStringCellValue());
												break;
										}
									}
								}
								n++;
							}
							if(c%2 == 0){
								a = a+b+1;
							}else{
								a += b;
							}
							c++;
							schedule.setL_Id(id);
							scheduleService.add(schedule);
						}
					}
				}
			}
			wb.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package com.rjxy.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rjxy.model.Attendance;
import com.rjxy.service.IAttendanceService;

@Controller
@RequestMapping("/Attendance")
public class AttendanceController {
	private IAttendanceService attendanceService;
	@Resource
	public void setAttendanceService(IAttendanceService attendanceService) {
		this.attendanceService = attendanceService;
	}
	@RequestMapping(value="/query",method=RequestMethod.GET)
	public String quert(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")Date start_time,@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")Date end_time,String t_name,Model model){
		List<Attendance> attendances = null;
		Attendance attendance = new Attendance();
		attendance.setT_name(t_name);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(start_time != null && end_time != null && attendance.getT_name() != ""){
			attendance.setStart_time(Timestamp.valueOf(sdf.format(start_time)));
			attendance.setEnd_time(Timestamp.valueOf(sdf.format(end_time)));
			attendances = attendanceService.listAnd(attendance);
		}else if(start_time != null && end_time != null){
			attendance.setStart_time(Timestamp.valueOf(sdf.format(start_time)));
			attendance.setEnd_time(Timestamp.valueOf(sdf.format(end_time)));
			attendances = attendanceService.listOr(attendance);
		}else{
			attendances = attendanceService.listOr(attendance);
		}
		model.addAttribute("attendances", attendances);
		model.addAttribute("path", "attendance.jsp");
		return "admin/main/main";
	}
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	public String delete(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")Date delete_time,Model model){
		Attendance attendance = new Attendance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(delete_time != null){
			attendance.setEnd_time(Timestamp.valueOf(sdf.format(delete_time)));
			attendanceService.deleteList(attendance);
		}
		return "redirect:/Main/toAttendance";
	}
}

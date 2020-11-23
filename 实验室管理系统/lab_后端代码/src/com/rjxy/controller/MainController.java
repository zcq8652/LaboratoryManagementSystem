package com.rjxy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rjxy.model.Adjust;
import com.rjxy.model.Admin;
import com.rjxy.model.Attendance;
import com.rjxy.model.Fault;
import com.rjxy.model.Health;
import com.rjxy.model.Img;
import com.rjxy.model.Lab;
import com.rjxy.model.Notice;
import com.rjxy.model.Safe;
import com.rjxy.service.IAdjustService;
import com.rjxy.service.IAttendanceService;
import com.rjxy.service.IFaultService;
import com.rjxy.service.IHealthService;
import com.rjxy.service.IImgService;
import com.rjxy.service.ILabService;
import com.rjxy.service.INoticeService;
import com.rjxy.service.ISafeService;

@Controller
@RequestMapping("/Main")
public class MainController {
	private IAttendanceService attendanceService;
	@Resource
	public void setAttendanceService(IAttendanceService attendanceService) {
		this.attendanceService = attendanceService;
	}
	private ISafeService safeService;
	@Resource
	public void setSafeService(ISafeService safeService) {
		this.safeService = safeService;
	}
	private IHealthService healthService;
	@Resource
	public void setHealthService(IHealthService healthService) {
		this.healthService = healthService;
	}
	private INoticeService noticeService;
	@Resource
	public void setNoticeService(INoticeService noticeService) {
		this.noticeService = noticeService;
	}
	private IImgService imgService;
	@Resource
	public void setImgService(IImgService imgService) {
		this.imgService = imgService;
	}
	private IAdjustService adjustService;
	@Resource
	public void setAdjustService(IAdjustService adjustService) {
		this.adjustService = adjustService;
	}
	private ILabService labService;
	@Resource
	public void setLabService(ILabService labService) {
		this.labService = labService;
	}
	//注销功能
	@RequestMapping(value="/toCancel",method=RequestMethod.GET)
	public String toCancel(HttpSession session){
		session.invalidate();
		return "redirect:/Main/toLogin";
	}
	@RequestMapping(value="/toLogin")
	public String toLogin(){
		return "admin/login";
	}
	private IFaultService faultService;
	@Resource
	public void setFaultService(IFaultService faultService) {
		this.faultService = faultService;
	}
	//考勤检查
	@RequestMapping(value="/toAttendance",method=RequestMethod.GET)
	public String toAttendance(Model model){
		List<Attendance> attendances = attendanceService.list();
		model.addAttribute("attendances", attendances);
		model.addAttribute("path", "attendance.jsp");
		return "admin/main/main";
	}
	//安全记录
	@RequestMapping(value="/toSafe",method=RequestMethod.GET)
	public String toSafe(Model model){
		List<Safe> safes = safeService.list();
		model.addAttribute("safes", safes);
		model.addAttribute("path", "safe.jsp");
		return "admin/main/main";
	}
	//卫生考察
	@RequestMapping(value="/toHealth",method=RequestMethod.GET)
	public String toHealth(Model model,HttpServletRequest req){
		//查询卫生记录数据
		List<Health> healths = healthService.list();
		//查询对应图片
		for (Health health : healths) {
			//获取图片数据
			List<Img> imgs = imgService.listId(health.getH_Id());
			//获取文件路径
			String path = req.getContextPath();
			String request_path = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+path;
			//整合路径
			List<String> imgsPath = new ArrayList<String>();
			for (int i = 0; i<imgs.size(); i++) {
				imgsPath.add(request_path + "/pic_file/" +imgs.get(i).getI_name());
			}
			health.setImgsPath(imgsPath);
		}
		model.addAttribute("healths", healths);
		model.addAttribute("path", "health.jsp");
		return "admin/main/main";
	}
	//课表上传
	@RequestMapping("/toSchedule")
	public String toSchedule(Model model){
		model.addAttribute("path", "schedule.jsp");
		return "admin/main/main";
	}
	//公告管理
	@RequestMapping(value="/toNotice",method=RequestMethod.GET)
	public String toNotice(Model model){
		//获取公告数据
		List<Notice> notices = noticeService.list();
		model.addAttribute("notices", notices);
		model.addAttribute("path", "notice.jsp");
		return "admin/main/main";
	}
	//故障申报
	@RequestMapping(value="/toFault",method=RequestMethod.GET)
	public String toFault(Model model){
		//获取故障数据
		List<Fault> faults = faultService.list();
		model.addAttribute("faults", faults);
		model.addAttribute("path", "fault.jsp");
		return "admin/main/main";
	}
	//调停课申请
	@RequestMapping(value="/toAdjust",method=RequestMethod.GET)
	public String toAdjust(Model model,HttpSession session){
		//获取当前用户
		Admin admin = (Admin) session.getAttribute("admin");
		//获取调停课待审批数据
		List<Adjust> adjusts = adjustService.listId(admin.getU_rank());
		model.addAttribute("adjusts", adjusts);
		model.addAttribute("path", "adjust.jsp");
		return "admin/main/main";
	}
	//注册实验室
	@RequestMapping(value="/toLab",method=RequestMethod.GET)
	public String toLab(Model model,HttpServletRequest req,String message){
		if(!message.equals("NULL")){
			req.setAttribute("message", Integer.parseInt(message));
		}
		model.addAttribute("path","registerLaboratory.jsp");
		return "admin/main/main";
	}
	//重置密码
	@RequestMapping(value="/toPassword",method=RequestMethod.GET)
	public String toPassword(Model model,HttpServletRequest req,String message){
		if(!message.equals("NULL")){
			req.setAttribute("message", Integer.parseInt(message));
		}
		model.addAttribute("path","registerLaboratory.jsp");
		return "admin/main/main";
	}
	//实验室信息显示
	@RequestMapping(value="/toLabShow",method=RequestMethod.GET)
	public String toLabShow(Model model,String message,HttpServletRequest req){
		if(!message.equals("NULL")){
			req.setAttribute("message", Integer.parseInt(message));
		}
		//查询实验室信息
		List<Lab> labs = labService.list();
		model.addAttribute("labs", labs);
		model.addAttribute("path", "showLaboratory.jsp");
		return "admin/main/main";
	}
}

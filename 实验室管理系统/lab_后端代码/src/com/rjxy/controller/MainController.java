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
	//ע������
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
	//���ڼ��
	@RequestMapping(value="/toAttendance",method=RequestMethod.GET)
	public String toAttendance(Model model){
		List<Attendance> attendances = attendanceService.list();
		model.addAttribute("attendances", attendances);
		model.addAttribute("path", "attendance.jsp");
		return "admin/main/main";
	}
	//��ȫ��¼
	@RequestMapping(value="/toSafe",method=RequestMethod.GET)
	public String toSafe(Model model){
		List<Safe> safes = safeService.list();
		model.addAttribute("safes", safes);
		model.addAttribute("path", "safe.jsp");
		return "admin/main/main";
	}
	//��������
	@RequestMapping(value="/toHealth",method=RequestMethod.GET)
	public String toHealth(Model model,HttpServletRequest req){
		//��ѯ������¼����
		List<Health> healths = healthService.list();
		//��ѯ��ӦͼƬ
		for (Health health : healths) {
			//��ȡͼƬ����
			List<Img> imgs = imgService.listId(health.getH_Id());
			//��ȡ�ļ�·��
			String path = req.getContextPath();
			String request_path = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+path;
			//����·��
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
	//�α��ϴ�
	@RequestMapping("/toSchedule")
	public String toSchedule(Model model){
		model.addAttribute("path", "schedule.jsp");
		return "admin/main/main";
	}
	//�������
	@RequestMapping(value="/toNotice",method=RequestMethod.GET)
	public String toNotice(Model model){
		//��ȡ��������
		List<Notice> notices = noticeService.list();
		model.addAttribute("notices", notices);
		model.addAttribute("path", "notice.jsp");
		return "admin/main/main";
	}
	//�����걨
	@RequestMapping(value="/toFault",method=RequestMethod.GET)
	public String toFault(Model model){
		//��ȡ��������
		List<Fault> faults = faultService.list();
		model.addAttribute("faults", faults);
		model.addAttribute("path", "fault.jsp");
		return "admin/main/main";
	}
	//��ͣ������
	@RequestMapping(value="/toAdjust",method=RequestMethod.GET)
	public String toAdjust(Model model,HttpSession session){
		//��ȡ��ǰ�û�
		Admin admin = (Admin) session.getAttribute("admin");
		//��ȡ��ͣ�δ���������
		List<Adjust> adjusts = adjustService.listId(admin.getU_rank());
		model.addAttribute("adjusts", adjusts);
		model.addAttribute("path", "adjust.jsp");
		return "admin/main/main";
	}
	//ע��ʵ����
	@RequestMapping(value="/toLab",method=RequestMethod.GET)
	public String toLab(Model model,HttpServletRequest req,String message){
		if(!message.equals("NULL")){
			req.setAttribute("message", Integer.parseInt(message));
		}
		model.addAttribute("path","registerLaboratory.jsp");
		return "admin/main/main";
	}
	//��������
	@RequestMapping(value="/toPassword",method=RequestMethod.GET)
	public String toPassword(Model model,HttpServletRequest req,String message){
		if(!message.equals("NULL")){
			req.setAttribute("message", Integer.parseInt(message));
		}
		model.addAttribute("path","registerLaboratory.jsp");
		return "admin/main/main";
	}
	//ʵ������Ϣ��ʾ
	@RequestMapping(value="/toLabShow",method=RequestMethod.GET)
	public String toLabShow(Model model,String message,HttpServletRequest req){
		if(!message.equals("NULL")){
			req.setAttribute("message", Integer.parseInt(message));
		}
		//��ѯʵ������Ϣ
		List<Lab> labs = labService.list();
		model.addAttribute("labs", labs);
		model.addAttribute("path", "showLaboratory.jsp");
		return "admin/main/main";
	}
}

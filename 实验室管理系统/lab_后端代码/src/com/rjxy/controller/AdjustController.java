package com.rjxy.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rjxy.model.Adjust;
import com.rjxy.model.Admin;
import com.rjxy.model.TeacherAdjust;
import com.rjxy.service.IAdjustService;
import com.rjxy.service.ITeacherAdjustService;

@Controller
@RequestMapping("/Adjust")
public class AdjustController {
	private IAdjustService adjustService;
	@Resource
	public void setAdjustService(IAdjustService adjustService) {
		this.adjustService = adjustService;
	}
	private ITeacherAdjustService teacherAdjustService;
	@Resource
	public void setTeacherAdjustService(ITeacherAdjustService teacherAdjustService) {
		this.teacherAdjustService = teacherAdjustService;
	}
	@RequestMapping(value="/{id}/agree",method=RequestMethod.PUT)
	public String agree(int id,HttpSession session){
		//��ȡ��ǰ�û���Ϣ
		Admin admin = (Admin) session.getAttribute("admin"); 
		//��װ����
		Adjust adjust = new Adjust();
		TeacherAdjust teacherAdjust = new TeacherAdjust();
		adjust.setAd_Id(id);
		teacherAdjust.setTa_Id(id);
		//�ж��û����
		if(admin.getU_rank().equals("2")){
			adjust.setAd_state("1");
			teacherAdjust.setTa_state("1");
		}else if(admin.getU_rank().equals("1")){
			adjust.setAd_state("0");
			teacherAdjust.setTa_state("0");
		}
		//�޸����ݿ�����
		adjustService.update(adjust);
		teacherAdjustService.update(teacherAdjust);
		return "redirect:/Main/toAdjust";
	}
	@RequestMapping(value="/{id}/disagree",method=RequestMethod.PUT)
	public String disagree(int id){
		//��װ����
		Adjust adjust = new Adjust();
		TeacherAdjust teacherAdjust = new TeacherAdjust();
		adjust.setAd_Id(id);
		teacherAdjust.setTa_Id(id);
		adjust.setAd_state("3");
		teacherAdjust.setTa_state("3");
		//�޸����ݿ�����
		adjustService.update(adjust);
		teacherAdjustService.update(teacherAdjust);
		return "redirect:/Main/toAdjust";
	}
	@RequestMapping(value="/select1",method=RequestMethod.GET)
	public String select1(Model model,HttpSession session){
		//��ȡ��ǰ�û�
		Admin admin = (Admin) session.getAttribute("admin");
		//��ȡ��ͣ�δ���������
		List<Adjust> adjusts = adjustService.listId(admin.getU_rank());
		model.addAttribute("adjusts", adjusts);
		model.addAttribute("path", "adjust.jsp");
		return "admin/main/main";
	}
	@RequestMapping(value="/select2",method=RequestMethod.GET)
	public String select2(Model model,HttpSession session){
		//��ȡ��ͣ�δ���������
		List<Adjust> adjusts = adjustService.listId30();
		model.addAttribute("adjusts", adjusts);
		model.addAttribute("path", "adjust.jsp");
		return "admin/main/main";
	}
}

package com.rjxy.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rjxy.model.Lab;
import com.rjxy.service.IAdminService;
import com.rjxy.service.ILabService;

@Controller
@RequestMapping("/Lab")
public class LabController {
	private ILabService labService;
	@Resource
	public void setLabService(ILabService labService) {
		this.labService = labService;
	}
	private IAdminService adminService;
	@Resource
	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}
	//ע��ʵ����
	@RequestMapping("/addLab")
	public String addLab(Lab lab,HttpServletRequest req){
		//��ѯʵ�����Ƿ��ѱ�ע��
		Lab select_lab = labService.load(lab.getL_Id());
		//��־ע���Ƿ�ɹ�
		int message = 0;
		if(select_lab == null){
			message = labService.addLab(lab);
		}
		return "redirect:/Main/toLab?message="+message;
	}
	//�޸�ʵ���ҹ���Ա
	@RequestMapping("/updateLabAdmin")
	public String updateLabAdmin(String l_id,String a_id){
		//��־ע���Ƿ�ɹ�
		int message = 0;
		//��װ����
		Lab lab = new Lab();
		lab.setA_Id(a_id);
		lab.setL_Id(l_id);
		//�鿴�Ƿ���ڸù���Ա
		if(adminService.load(a_id) != null){
			message = labService.updatea_id(lab);
		}
		return "redirect:/Main/toLabShow?message="+message;
	}
}

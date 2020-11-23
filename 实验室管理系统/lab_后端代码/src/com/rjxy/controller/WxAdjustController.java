package com.rjxy.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rjxy.model.Adjust;
import com.rjxy.model.AdminAdjust;
import com.rjxy.model.Lab;
import com.rjxy.model.TeacherAdjust;
import com.rjxy.service.IAdjustService;
import com.rjxy.service.IAdminAdjustService;
import com.rjxy.service.ILabService;
import com.rjxy.service.ITeacherAdjustService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/WxAdjust")
public class WxAdjustController {
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
	private IAdminAdjustService adminAdjustService;
	@Resource
	public void setAdminAdjustService(IAdminAdjustService adminAdjustService) {
		this.adminAdjustService = adminAdjustService;
	}
	private ILabService labService;
	@Resource
	public void setLabService(ILabService labService) {
		this.labService = labService;
	}
	//��ʾ��������
	@RequestMapping("/selete")
	public void selete(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//���ñ�����Ӧ��ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		JSONObject jsonObject = new JSONObject();
		//��ȡ�û����Ȩ��
		String u_rank = req.getParameter("u_rank");
		//��ȡ�û�Id
		String u_Id = req.getParameter("u_Id");
		//��ѯʵ��������
		List<Lab> labs = labService.list();
		//����Ȩ�޲�ѯ����
		List<Adjust> adjusts = new ArrayList<Adjust>();
		List<AdminAdjust> adminAdjusts = new ArrayList<AdminAdjust>();
		if(u_rank != null){
			if(u_rank.equals("2")){
				adjusts = adjustService.list();
			}else if(u_rank.equals("1")){
				adjusts = adjustService.listId1();
			}else if(u_rank.equals("0")){
				adminAdjusts = adminAdjustService.listId(u_Id);
			}
		}
		jsonObject.put("adminAdjusts", adminAdjusts);
		jsonObject.put("adjusts", adjusts);
		jsonObject.put("labs", labs);
		resp.getWriter().write(jsonObject.toString());
	}
	//������������
	@RequestMapping("/update")
	public void update(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//���ñ�����Ӧ��ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		//��ȡ�û����Ȩ��
		String u_rank = req.getParameter("u_rank");
		//��ȡ��������id
		int ad_Id = Integer.valueOf(req.getParameter("ad_Id"));
		//��ȡ�������
		String result = req.getParameter("result");
		//��ȡ������ԱId
		String a_Id = req.getParameter("a_Id");
		//�������ݷ�װ����
		Adjust adjust = new Adjust();
		AdminAdjust  adminAdjust = new AdminAdjust();
		adjust.setAd_Id(ad_Id);
		TeacherAdjust ta = new TeacherAdjust();
		ta.setTa_Id(ad_Id);
		//�ж��û����Ȩ��
		if(u_rank != null){
			if(u_rank.equals("2")){
				//�ж���˽��
				if(result.equals("1")){
					adjust.setAd_state("1");
					ta.setTa_state("1");
				}else if(result.equals("0")){
					adjust.setAd_state("3");
					ta.setTa_state("3");
				}
			}else if(u_rank.equals("1")){
				if(result.equals("1")){
					adjust.setAd_state("0");
					ta.setTa_state("0");
					//����ͨ�������ʵ��Ա
					Adjust ad = adjustService.selectId(ad_Id);
					adminAdjust.setT_name(ad.getT_name());
					adminAdjust.setAa_content(ad.getAd_content());
					adminAdjust.setAa_date(ad.getAd_date());
					adminAdjust.setAa_state("1");
					adminAdjust.setU_Id(a_Id);
					adminAdjust.setAd_state("0");
					adminAdjustService.add(adminAdjust);
				}else if(result.equals("0")){
					adjust.setAd_state("3");
					ta.setTa_state("3");
				}
			}
			adjustService.update(adjust);
			teacherAdjustService.update(ta);
		}
	}
	//��������Ա����Ϣ��ʾ
	@RequestMapping("/updateNew")
	public void updateNew(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//���ñ�����Ӧ��ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		JSONObject jsonObject = new JSONObject();
		//��ȡ����Id
		int aa_Id = Integer.valueOf(req.getParameter("aa_Id"));
		//��ȡ����ԱId
		String u_Id = req.getParameter("u_Id");
		//�������ݷ�װ��
		AdminAdjust adminAdjust = new AdminAdjust();
		adminAdjust.setAa_Id(aa_Id);
		adminAdjust.setAa_state("0");
		//�޸�����״̬
		adminAdjustService.update(adminAdjust);
		//��ѯ��������
		List<AdminAdjust> adminAdjusts = adminAdjustService.listId(u_Id);
		jsonObject.put("adminAdjusts", adminAdjusts);
		resp.getWriter().write(jsonObject.toString());
	}
	//ɾ����������
	@RequestMapping("/delete")
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//���ñ�����Ӧ��ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		JSONObject jsonObject = new JSONObject();
		//��ȡ�û����Ȩ��
		String u_rank = req.getParameter("u_rank");
		//��ȡ����id
		int ad_Id = Integer.valueOf(req.getParameter("ad_Id"));
		//ɾ������
		adjustService.dalete(ad_Id);
		//��ѯ������������
		List<Adjust> adjusts = adjustService.listId1();
		jsonObject.put("adjusts", adjusts);
		resp.getWriter().write(jsonObject.toString());
	}
}

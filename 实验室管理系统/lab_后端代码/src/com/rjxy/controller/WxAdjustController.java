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
	//显示申请数据
	@RequestMapping("/selete")
	public void selete(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//设置编码响应格式
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		JSONObject jsonObject = new JSONObject();
		//获取用户身份权限
		String u_rank = req.getParameter("u_rank");
		//获取用户Id
		String u_Id = req.getParameter("u_Id");
		//查询实验室数据
		List<Lab> labs = labService.list();
		//根据权限查询数据
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
	//审批申请数据
	@RequestMapping("/update")
	public void update(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//设置编码响应格式
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		//获取用户身份权限
		String u_rank = req.getParameter("u_rank");
		//获取审批数据id
		int ad_Id = Integer.valueOf(req.getParameter("ad_Id"));
		//获取审批结果
		String result = req.getParameter("result");
		//获取推送人员Id
		String a_Id = req.getParameter("a_Id");
		//创建数据封装对象
		Adjust adjust = new Adjust();
		AdminAdjust  adminAdjust = new AdminAdjust();
		adjust.setAd_Id(ad_Id);
		TeacherAdjust ta = new TeacherAdjust();
		ta.setTa_Id(ad_Id);
		//判断用户身份权限
		if(u_rank != null){
			if(u_rank.equals("2")){
				//判断审核结果
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
					//推送通过申请给实验员
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
	//消除管理员新消息提示
	@RequestMapping("/updateNew")
	public void updateNew(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//设置编码响应格式
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		JSONObject jsonObject = new JSONObject();
		//获取数据Id
		int aa_Id = Integer.valueOf(req.getParameter("aa_Id"));
		//获取管理员Id
		String u_Id = req.getParameter("u_Id");
		//创建数据封装类
		AdminAdjust adminAdjust = new AdminAdjust();
		adminAdjust.setAa_Id(aa_Id);
		adminAdjust.setAa_state("0");
		//修改数据状态
		adminAdjustService.update(adminAdjust);
		//查询最新数据
		List<AdminAdjust> adminAdjusts = adminAdjustService.listId(u_Id);
		jsonObject.put("adminAdjusts", adminAdjusts);
		resp.getWriter().write(jsonObject.toString());
	}
	//删除申请数据
	@RequestMapping("/delete")
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//设置编码响应格式
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		JSONObject jsonObject = new JSONObject();
		//获取用户身份权限
		String u_rank = req.getParameter("u_rank");
		//获取数据id
		int ad_Id = Integer.valueOf(req.getParameter("ad_Id"));
		//删除数据
		adjustService.dalete(ad_Id);
		//查询最新申请数据
		List<Adjust> adjusts = adjustService.listId1();
		jsonObject.put("adjusts", adjusts);
		resp.getWriter().write(jsonObject.toString());
	}
}

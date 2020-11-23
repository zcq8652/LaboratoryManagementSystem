package com.rjxy.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rjxy.model.Img;
import com.rjxy.service.IHealthService;
import com.rjxy.service.IImgService;

@Controller
@RequestMapping("/Health")
public class HealthController {
	private IHealthService healthService;
	@Resource
	public void setHealthService(IHealthService healthService) {
		this.healthService = healthService;
	}
	private IImgService imgService;
	@Resource
	public void setImgService(IImgService imgService) {
		this.imgService = imgService;
	}
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	public String delete(HttpServletRequest req){
		//��ѯ����ͼƬ��Ϣ
		List<Img> imgs = imgService.list();
		//��ȡ�ļ�·��
		String pic_path = req.getSession().getServletContext().getRealPath("pic_file"); 
		//����·��,ɾ������
		for (int i = 0; i<imgs.size(); i++) {
			File file = new File(pic_path + "/" +imgs.get(i).getI_name());
			file.delete();
		}
		//ɾ��������¼���ݣ��������ɾ��img��¼
		healthService.deleteAll();
		return "redirect:/Main/toHealth";
	}
}

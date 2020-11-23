package com.rjxy.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.rjxy.model.Health;
import com.rjxy.model.Img;
import com.rjxy.service.IHealthService;
import com.rjxy.service.IImgService;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/WxHealth")
public class WxHealthController {
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
	//���������ɨ��¼
	@RequestMapping("/add")
	public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//���ñ�����Ӧ��ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		JSONObject jsonObject = new JSONObject();
		//��ȡ�û���Ϣ
		String h_u_Id = req.getParameter("u_Id");
		String h_u_name = req.getParameter("u_name");
		String h_content = req.getParameter("h_content");
		//��ȡϵͳ��ǰʱ��
		Date date = new Date();
		String h_time = new SimpleDateFormat("MM-dd HH:mm").format(date);
		//��װ����
		Health health = new Health();
		health.setH_u_Id(h_u_Id);
		health.setH_u_name(h_u_name);
		health.setH_content(h_content);
		health.setH_time(h_time);
		//��������
		healthService.add(health);
		jsonObject.put("h_Id", health.getH_Id());
		resp.getWriter().write(jsonObject.toString());
	}
	//�ϴ�������ɨ��Ƭ
	@RequestMapping("/uploadImg")
	public void uploadImg(HttpServletRequest req, HttpServletResponse resp,@RequestParam("file")MultipartFile file) throws FileUploadException, IOException{
		if(file!=null){
			//��ȡid
			int h_Id = Integer.parseInt(req.getParameter("h_Id"));
			//��ȡ�ϴ��ļ���ԭʼ����
			String originalFilename = file.getOriginalFilename();
			String newFileName ="";
			String pic_path;
			// �ϴ�ͼƬ			
			if ( originalFilename != null && originalFilename.length() > 0) {				
				//��ȡ��Ŀ��tomcatĿ¼�µ�·��,������pic_file�ļ���				
				pic_path = req.getSession().getServletContext().getRealPath("pic_file");  									
				// �µ�ͼƬ����				
				newFileName =UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
        		Img img = new Img();
        		img.setH_Id(h_Id);
        		img.setI_name(newFileName);
        		imgService.add(img);
				//�ж��ļ�Ŀ¼�Ƿ����
				File picFile = new File(pic_path);
				if(picFile.exists() == false ){
					picFile.mkdir();
				}
				// ��ͼƬ				
				File newFile = new File(pic_path,newFileName);				
				// ���ڴ��е�����д�����				
				file.transferTo(newFile);			
				}
			}
		
//		//��ȡid
//		int h_Id = Integer.parseInt(req.getParameter("h_Id"));
//        //��ȡ�ļ���Ҫ�ϴ�����·��
//        String path = req.getServletContext().getRealPath("/image");
//        if(files != null){
//        	for(MultipartFile file:files){
//        		String fileName = file.getOriginalFilename();
//        		String imgName = NameUtil.getName()+""+NameUtil.getFileType(fileName);
//        		File f = new File(path + "/" + imgName);
//        		FileUtils.copyInputStreamToFile(file.getInputStream(), f);
//        		Img img = new Img();
//        		img.setH_Id(h_Id);
//        		img.setI_name(imgName);
//        		imgService.add(img);
//        	}
//        }
		
		//���ñ�����Ӧ��ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		JSONObject jsonObject = new JSONObject();
		//��ѯ����������¼����
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
		jsonObject.put("healths", healths);
		resp.getWriter().write(jsonObject.toString());
	}
	//�鿴������¼
	@RequestMapping("/select")
	public void select(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//���ñ�����Ӧ��ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		JSONObject jsonObject = new JSONObject();
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
		jsonObject.put("healths", healths);
		resp.getWriter().write(jsonObject.toString());
	}
	//ɾ��������¼
	@RequestMapping("/delete")
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//���ñ�����Ӧ��ʽ
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		JSONObject jsonObject = new JSONObject();
		//��ȡid
		int h_Id = Integer.parseInt(req.getParameter("h_Id"));
		//��ȡͼƬ����
		List<Img> imgs = imgService.listId(h_Id);
		//��ȡ�ļ�·��
		String pic_path = req.getSession().getServletContext().getRealPath("pic_file"); 
		//����·��,ɾ������
		for (int i = 0; i<imgs.size(); i++) {
			File file = new File(pic_path + "/" +imgs.get(i).getI_name());
			file.delete();
		}
		//ɾ��������¼���ݣ��������ɾ��img��¼
		healthService.delete(h_Id);
		//��ȡ�ļ�·��
		String path = req.getContextPath();
		String request_path = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+path;
		//��ѯ����������¼���ݺ�img
		List<Health> healths = healthService.list();
		//��ѯ��ӦͼƬ
		for (Health health : healths) {
			//��ȡͼƬ����
			List<Img> imgss = imgService.listId(health.getH_Id());
			//����·��
			List<String> imgsPath = new ArrayList<String>();
			for (int i = 0; i<imgss.size(); i++) {
				imgsPath.add(request_path + "/pic_file/" +imgss.get(i).getI_name());
			}
			health.setImgsPath(imgsPath);
		}
		jsonObject.put("healths", healths);
		resp.getWriter().write(jsonObject.toString());
	}
}

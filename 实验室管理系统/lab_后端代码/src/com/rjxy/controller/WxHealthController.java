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
	//添加卫生打扫记录
	@RequestMapping("/add")
	public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//设置编码响应格式
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		JSONObject jsonObject = new JSONObject();
		//获取用户信息
		String h_u_Id = req.getParameter("u_Id");
		String h_u_name = req.getParameter("u_name");
		String h_content = req.getParameter("h_content");
		//获取系统当前时间
		Date date = new Date();
		String h_time = new SimpleDateFormat("MM-dd HH:mm").format(date);
		//封装数据
		Health health = new Health();
		health.setH_u_Id(h_u_Id);
		health.setH_u_name(h_u_name);
		health.setH_content(h_content);
		health.setH_time(h_time);
		//保存数据
		healthService.add(health);
		jsonObject.put("h_Id", health.getH_Id());
		resp.getWriter().write(jsonObject.toString());
	}
	//上传卫生打扫照片
	@RequestMapping("/uploadImg")
	public void uploadImg(HttpServletRequest req, HttpServletResponse resp,@RequestParam("file")MultipartFile file) throws FileUploadException, IOException{
		if(file!=null){
			//获取id
			int h_Id = Integer.parseInt(req.getParameter("h_Id"));
			//获取上传文件的原始名称
			String originalFilename = file.getOriginalFilename();
			String newFileName ="";
			String pic_path;
			// 上传图片			
			if ( originalFilename != null && originalFilename.length() > 0) {				
				//获取项目在tomcat目录下的路径,并创建pic_file文件夹				
				pic_path = req.getSession().getServletContext().getRealPath("pic_file");  									
				// 新的图片名称				
				newFileName =UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
        		Img img = new Img();
        		img.setH_Id(h_Id);
        		img.setI_name(newFileName);
        		imgService.add(img);
				//判断文件目录是否存在
				File picFile = new File(pic_path);
				if(picFile.exists() == false ){
					picFile.mkdir();
				}
				// 新图片				
				File newFile = new File(pic_path,newFileName);				
				// 将内存中的数据写入磁盘				
				file.transferTo(newFile);			
				}
			}
		
//		//获取id
//		int h_Id = Integer.parseInt(req.getParameter("h_Id"));
//        //获取文件需要上传到的路径
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
		
		//设置编码响应格式
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		JSONObject jsonObject = new JSONObject();
		//查询卫最新生记录数据
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
		jsonObject.put("healths", healths);
		resp.getWriter().write(jsonObject.toString());
	}
	//查看卫生记录
	@RequestMapping("/select")
	public void select(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//设置编码响应格式
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		JSONObject jsonObject = new JSONObject();
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
		jsonObject.put("healths", healths);
		resp.getWriter().write(jsonObject.toString());
	}
	//删除卫生记录
	@RequestMapping("/delete")
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//设置编码响应格式
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/plain;charset=utf-8");
		JSONObject jsonObject = new JSONObject();
		//获取id
		int h_Id = Integer.parseInt(req.getParameter("h_Id"));
		//获取图片数据
		List<Img> imgs = imgService.listId(h_Id);
		//获取文件路径
		String pic_path = req.getSession().getServletContext().getRealPath("pic_file"); 
		//整合路径,删除数据
		for (int i = 0; i<imgs.size(); i++) {
			File file = new File(pic_path + "/" +imgs.get(i).getI_name());
			file.delete();
		}
		//删除卫生记录数据，运用外键删除img记录
		healthService.delete(h_Id);
		//获取文件路径
		String path = req.getContextPath();
		String request_path = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+path;
		//查询最新卫生记录数据和img
		List<Health> healths = healthService.list();
		//查询对应图片
		for (Health health : healths) {
			//获取图片数据
			List<Img> imgss = imgService.listId(health.getH_Id());
			//整合路径
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

package com.csq.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("pictureController")
public class PictureController {
	
	/**
	 * 文件上传
	 * url: pictureController/fileUpload
	 * @param desc	上传文件描述
	 * @param img 上传图片
	 * @return	返回结果
	 * @throws IOException 
	 */
	@RequestMapping("fileUpload")
	@ResponseBody
	public Map<String, Integer> fileUpload(HttpServletRequest request, @RequestParam("file") MultipartFile file, Map<String, Integer> map ) throws IOException
	{
//		String fileName = file.getOriginalFilename();
//		System.out.println("文件描述： " + desc );
		//1定义输入流
//		InputStream input = file.getInputStream();
		//2定义输出流
//		String path = request.getSession().getServletContext().getRealPath("/");
//		System.out.println("path:" + path);
//		String newPath = this.gets
//		System.out.println("newPath : " + );
//		String outPath = PictureController.class.getResource("").getPath() + File.separator + "file" + File.separator + fileName;
//		System.err.println("outPath : " + PictureController.class.getResource("").getPath());
//		System.out.println("文件类型：" + file.getContentType());
//		System.out.println("文件组件名称：" + file.getName());
//		System.out.println("文件大小：" + file.getSize());
		if(!file.isEmpty()) {
			//构建上传文件的路径
			String path = request.getServletContext().getRealPath("/upload/");
			System.out.println("path:" + path);
			//获取上传的文件名称，并结合存放路径，构建新的文件名称
			String fileName = file.getOriginalFilename();
			File filePath = new File(path, fileName);
			//判断路径是否存在，如果不存在，则创建一个
			if(!filePath.getParentFile().exists()) {
				filePath.getParentFile().mkdir();
			}
			//将文件保存到目标文件目录
			file.transferTo(new File(path + File.separator + fileName));
			System.out.println("保存成功");
			map.put("code", 100);
		}else {
			System.out.println("err");
			map.put("code", 200);
		}
		
//		OutputStream out = new FileOutputStream("/");
//		int len = -1;
//		byte [] bt = new byte[1024];
//		//3读文件
//		while((len = input.read(bt)) != -1) {
//			//4写文件
//			out.write(bt, 0, len);
//		}
//		out.close();
//		input.close();
//		System.out.println("上传成功");
		return map;
	}
	
	
	/**
	 * url: pictureController/download
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/download")
    public String downloadFile(HttpServletRequest request, HttpServletResponse response) {
        String fileName = "dalaoyang.jpeg";// 文件名
        if (fileName != null) {
            //设置文件路径
            File file = new File("C:\\Users\\bozpower\\AppData\\Local\\Temp\\tomcat-docbase.6413280501796712769.8080\\upload\\logo.png");
            //File file = new File(realPath , fileName);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    return "下载成功";
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return "下载失败";
    }

}

package com.csq.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.csq.entity.New;
import com.csq.entity.PageData;
import com.csq.service.NewService;
import com.csq.utils.DefaultUtils;

@Controller
@RequestMapping("newController")
public class NewController {

	@Autowired
	private NewService newService;
	
	

	/**
	 * url : newController/newUpload
	 * 
	 * @param newfile
	 * @param file
	 * @param map
	 * @return
	 * @throws IOException
	 * @throws IllegalStateException
	 */
//	@RequestMapping("newUpload")
//	public String newUpload(HttpServletRequest request, New newfile, MultipartFile file, Map<Object, Object> map)
//			throws IllegalStateException, IOException {
//		String fileName = file.getOriginalFilename();
//
//		if (!file.isEmpty()) {
//			String path = request.getServletContext().getRealPath("/upload/");
//			String newFileName = UUID.randomUUID() + fileName;
//			System.out.println(newFileName);
//			File filePath = new File(path, newFileName);
//			// 判断路径是否存在
//			if (!filePath.getParentFile().exists()) {
//				filePath.getParentFile().mkdir();
//			}
//			// 将文件保存到新的文件目录中
//			file.transferTo(new File(path + File.separator + newFileName));
//			System.out.println("保存成功");
//			map.put("result", "上传成功");
//			map.put("href", "../system/new.html");
//		} else {
//			System.out.println("上传失败");
//		}
//		return "uploadSuccess";
//	}

	/**
	 * newController/selectNew
	 * 
	 * @return
	 */
	@RequestMapping("selectNewList")
	public String selectNewList(PageData pageData, Map<String, Object> map) {
		try {
//			System.out.println(1/0);
			pageData = DefaultUtils.getPageData(pageData);
			List<New> news = newService.selectNewList(pageData);
			//得到总页数
			int pages = newService.getPages(pageData.getLimit());
			pageData.setPages(pages);
			//得到当前页的总条数
			pageData.setCount(news.size());
//			map.put("result", "查询成功");
			map.put("news", news);
			map.put("pageData", pageData);
			map.put("href", "selectNewList");
			
			return "new_result";
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", "查询失败");
			map.put("href", "selectNewList");
			return "result";
		}
	}
	
	
	/**
	 * url: newController/selectNewById
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "selectNewById/{id}", method = RequestMethod.GET)
	public String selectNewById(@PathVariable("id") int id, Map<String, Object> map) {
		New news = newService.selectNewById(id);
		System.out.println(news.toString());
		System.out.println(news);
		map.put("news", news);
		return "new_edit";
	}


	/**
	 * url: newController/insertNew
	 * 
	 * @return
	 */
	@RequestMapping("insertNew")
	public String insertNew(HttpServletRequest request, New news, MultipartFile file, Map<Object, Object> map) {
		String fileName = file.getOriginalFilename();
		System.out.println(news);
		try {
			if (!file.isEmpty()) {
				String path = request.getServletContext().getRealPath("/upload/");
				String newFileName = UUID.randomUUID() + fileName;
//		System.out.println(newFileName);
				File filePath = new File(path, newFileName);
				// 判断路径是否存在
				if (!filePath.getParentFile().exists()) {
					filePath.getParentFile().mkdir();
				}
				// 将文件保存到新的文件目录中
				file.transferTo(new File(path + File.separator + newFileName));
				news.setRemarks(newFileName);
				newService.insertNew(news);

				map.put("href", "../new.html");
				map.put("result", "上传成功");
			} else {
				map.put("result", "上传成功");
				news.setRemarks("#");
				newService.insertNew(news);
//				map.put("href", "../new.html");
			}
		} catch (Exception e) {
			map.put("result", "上传失败");
//			map.put("href", "../new.html");
			e.printStackTrace();
		}
		map.put("text", "点击查看");
		return "result";
	}
	
	
	@RequestMapping(value = "deleteNewById/{id}" , method = RequestMethod.GET)
	public String deleteNewById(@PathVariable("id") int id, Map<String, String> map) {
		try {
			newService.deleteNewById(id);
			map.put("result", "删除成功");
			return "result";
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", "删除失败");
			return "result";
		}
		
	}
	
	
	/**
	 * 更新新闻信息
	 * @param news
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "editNew" )
	public String editNew( New news, Map<String, String> map) {
		try {
			newService.editNew(news);
			map.put("result", "更新成功");
			map.put("href", "selectNewList");
		} catch (Exception e) {
			// TODO: handle exception
			map.put("result", "更新失败");
		}
		return "result";
	}

}

package com.csq.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csq.entity.Classes;
import com.csq.entity.PageData;
import com.csq.service.ClassesService;
import com.csq.utils.DefaultUtils;

/**
 * 教室控制器
 * @author bozpower
 *
 */
@Controller
@RequestMapping("classesController")
public class ClassesController {
	
	@Autowired
	private ClassesService classesService;
	
	/**
	 * classesController/selectClassesList
	 * @param pageData
	 * @param map
	 * @return
	 */
	@RequestMapping("selectClassesList")
	public String selectClassesList(PageData pageData, Map<String, Object> map) {
		
		try {
//			System.out.println(1/0);
			pageData = DefaultUtils.getPageData(pageData);
			List<Classes> classesList = classesService.selectClassesList(pageData);
			pageData.setCount(classesList.size());
			pageData.setPages(classesService.getPages(pageData.getLimit()));
			
			map.put("classesList", classesList);
			map.put("pageData", pageData);
			map.put("location", "selectClassesList");
			return "classes_query";

		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", "查询失败");
			map.put("href", "selectClassesList");
			return "result";
		}
	}
	
	
	/**
	 * url: classesController/selectClassesById
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "selectClassesById/{id}", method = RequestMethod.GET)
	public String selectClassesById(@PathVariable("id") Integer id, Map<String, Object> map) {
		
		try {
			Classes classes = classesService.selectClassesById(id);
			map.put("obj", classes);
			return "classes_edit";
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", "查询失败");
			return "result";
		}
	}
	
	
	/**
	 * url: classesController/editClasses
	 * @param classes
	 * @param map
	 * @return
	 */
	@RequestMapping("editClasses/{id}/{state}")
	public String editClasses(@PathVariable("id") int id,@PathVariable("state")  int state,
			Map<String, Object> map) {
		
		try {
//			System.out.println(1/0);
			Classes classes = new Classes();
			classes.setId(id);
			classes.setApplyState(state);
			classesService.editClasses(classes);
			List<Classes> list = new ArrayList<Classes>();
			list.add(classes);
			map.put("classesList", list);
			
			return "redirect:../../selectClassesList";
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", "审核失败");
			map.put("href", "../../selectClassesList");
			return "result";
		}
	}
	
	
	/**
	 * url: classesController/deleteClasses
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping("deleteClasses/{id}")
	public String deleteClasses(@PathVariable("id") int id, Map<String, Object> map) {
		
		try {
//			System.out.println(1/0);
			classesService.deleteClassesById(id);
			return "redirect:classes_query";
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", "删除失败");
			map.put("href", "../selectClassesList");
			return "result";
		}
	}

}

package com.csq.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csq.entity.Complain;
import com.csq.entity.PageData;
import com.csq.service.ComplainService;
import com.csq.utils.DefaultUtils;

/**
 * 教室控制器
 * @author bozpower
 *
 */
@Controller
@RequestMapping("complainController")
public class ComplainController {
	
	@Autowired
	private ComplainService complainService;
	
	private static final String location = "selectComplainList";
	
	/**
	 * complainController/selectComplainList
	 * @param pageData
	 * @param map
	 * @return
	 */
	@RequestMapping("selectComplainList")
	public String selectComplainList(PageData pageData, Map<Object, Object> map) {
		
		try {
			pageData = DefaultUtils.getPageData(pageData);
			List<Complain> complainList = complainService.selectComplainList(pageData);
			pageData.setCount(complainList.size());
			pageData.setPages(complainService.getPages(pageData.getLimit()));
			
//			map.put("complainList", complainList);
//			map.put("pageData", pageData);
//			map.put("location", "selectComplainList");
			map = DefaultUtils.getSelectSuccessMap(map, complainList, pageData, location);
			return "complain_query";

		} catch (Exception e) {
			e.printStackTrace();
			map = DefaultUtils.getSelectErrorMap(map, location);
			return "result";
		}
	}
	
	
	/**
	 * url: classesController/selectClassesById
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "selectComplainById/{id}", method = RequestMethod.GET)
	public String selectComplainById(@PathVariable("id") Integer id, Map<String, Object> map) {
		
		try {
			Complain complain = complainService.selectComplainById(id);
			map.put("obj", complain);
			return "complain_edit";
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
	@RequestMapping("editComplain/{id}/{state}")
	public String editComplain(@PathVariable("id") int id,@PathVariable("state")  int state,
			Map<String, Object> map) {
		try {

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
	@RequestMapping("deleteComplain/{id}")
	public String deleteComplain(@PathVariable("id") int id, Map<String, Object> map) {
		
		try {
			complainService.deleteComplainById(id);
			return "redirect:../selectComplainList";
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", "删除失败");
			map.put("href", "../selectComplainList");
			
			return "result";
		}
	}

}

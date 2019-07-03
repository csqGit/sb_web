package com.csq.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csq.entity.Repair;
import com.csq.entity.PageData;
import com.csq.service.RepairService;
import com.csq.utils.DefaultUtils;

/**
 * 教室控制器
 * @author bozpower
 *
 */
@Controller
@RequestMapping("repairController")
public class RepairController {
	
	@Autowired
	private RepairService repairService;
	
	/**
	 * RepairController/selectRepairList
	 * @param pageData
	 * @param map
	 * @return
	 */
	@RequestMapping("selectRepairList")
	public String selectRepairList(PageData pageData, Map<String, Object> map) {
		
		try {
			pageData = DefaultUtils.getPageData(pageData);
			List<Repair> repairList = repairService.selectRepairList(pageData);
			pageData.setCount(repairList.size());
			pageData.setPages(repairService.getPages(pageData.getLimit()));
			
			map.put("repairList", repairList);
			map.put("pageData", pageData);
			map.put("location", "selectRepairList");
			return "repair_query";

		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", "查询失败");
			map.put("href", "selectRepairList");
			return "result";
		}
	}
	
	
	/**
	 * url: classesController/selectClassesById
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "selectRepairById/{id}", method = RequestMethod.GET)
	public String selectRepairById(@PathVariable("id") Integer id, Map<String, Object> map) {
		try {
			Repair Repair = repairService.selectRepairById(id);
			map.put("obj", Repair);
			return "repair_edit";
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
	@RequestMapping("editRepair/{id}/{state}")
	public String editRepair(@PathVariable("id") int id,@PathVariable("state")  int state,
			Map<String, Object> map) {
		try {

			return "redirect:../../selectRepairList";
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", "审核失败");
			map.put("href", "../../selectRepairList");
			return "result";
		}
	}
	
	
	/**
	 * url: classesController/deleteClasses
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping("deleteRepair/{id}")
	public String deleteRepair(@PathVariable("id") int id, Map<String, Object> map) {
		
		try {
			repairService.deleteRepairById(id);
			return "redirect:../selectRepairList";
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", "删除失败");
			map.put("href", "../selectRepairList");
			
			return "result";
		}
	}

}

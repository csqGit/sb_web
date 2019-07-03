package com.csq.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csq.entity.PageData;
import com.csq.entity.SchoolBus;
import com.csq.service.SchoolBusService;
import com.csq.utils.DefaultUtils;


@Controller
@RequestMapping("schoolBusController")
public class SchoolBusController {
	
	@Autowired
	private SchoolBusService schoolBusService;
	
	
	
	/**
	 * url: schoolBusController/addSchoolBus
	 * @param schoolBus
	 * @param map
	 * @return
	 */
	@RequestMapping("addSchoolBus")
	public String addSchoolBus(SchoolBus schoolBus, Map<String, Object> map) {
		schoolBusService.insertSchoolBus(schoolBus);
		map.put("result", "添加成功");
		return "schoolBus_result";
	}
	
	
	/**
	 * url: schoolBusController/selectSchoolBusList
	 * @param pageData
	 * @param map
	 * @return
	 */
	@RequestMapping("selectSchoolBusList")
	public String selectSchoolBusList(PageData pageData, Map<String, Object> map) {
		try {
			
			pageData = DefaultUtils.getPageData(pageData);
			List<SchoolBus> schoolbusList = schoolBusService.selectSchoolBusList(pageData);
			//得到总页数
			int pages = schoolBusService.getPages(pageData.getLimit());
			pageData.setPages(pages);
			//得到当前页的总条数
			pageData.setCount(schoolbusList.size());
			//设置当前页
//			pageData.setCurrentPage(pageData.getCurrentPage());
			map.put("pageData", pageData);
			map.put("schoolbusList", schoolbusList);
//			System.err.println("schoolbusList:" + schoolbusList);
			map.put("location", "selectSchoolBusList");
			return "schoolBus_query";
		} catch (Exception e) {
			e.printStackTrace();
			return "schoolBus_query";
		}
	}
	
	
	
	
	/**
	 * 根据id查询校车信息
	 * url: schoolBusController/selectSchoolBusList
	 * @param pageData
	 * @param map
	 * @return
	 */
	@RequestMapping("selectSchoolBusById/{id}")
	public String selectSchoolBusById(@PathVariable("id") int id, Map<String, Object> map) {
		SchoolBus schoolbus = null;
		try {
			schoolbus = schoolBusService.selectSchoolBusById(id);
			map.put("schoolbus", schoolbus);
			return "schoolBus_edit";
		} catch (Exception e) {
			map.put("error", "暂无信息");
			map.put("result", "查询失败");
			map.put("href", "../selectSchoolBusList");
			return "result";
		}
	}
	
	
	/**
	 * url: schoolBusController/editSchoolBus
	 * @param schoolBus
	 * @param map
	 * @return
	 */
	@RequestMapping("editSchoolBus")
	public String editSchoolBus(SchoolBus schoolBus, Map<String, Object> map) {
		try {
			schoolBusService.editSchoolBus(schoolBus);
			map.put("result", "编辑成功");
		} catch (Exception e) {
			map.put("result", "编辑失败");
			e.printStackTrace();
		}
		
		return "schoolBus_result";
	}
	
	
	
	/**
	 * url: schoolBusController/deleteSchoolBusById
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping("deleteSchoolBusById/{id}")
	public String deleteSchoolBusById(@PathVariable("id") int id, Map<String, Object> map) {
		try {
			schoolBusService.deleteSchoolBusById(id);
			return "redirect:../selectSchoolBusList";
		} catch (Exception e) {
			map.put("result", "删除失败");
			map.put("href", "../selectSchoolBusList");
			e.printStackTrace();
			return "result";
		}
	}

	
}

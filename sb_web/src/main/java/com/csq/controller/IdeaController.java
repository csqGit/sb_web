package com.csq.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csq.entity.Idea;
import com.csq.entity.PageData;
import com.csq.service.IdeaService;
import com.csq.utils.DefaultUtils;

/**
 * 失物招领Controller
 * @author bozpower
 *
 */
@Controller
@RequestMapping("ideaController")
public class IdeaController {
	
	@Autowired
	private IdeaService ideaService;
	
	private static final  String url = "selectIdeaList";
	
	
	/**
	 * url: IdeaController/selectIdeaList
	 * 	分页查询失物招领信息
	 * @param pageData
	 * @param map
	 * @return
	 * request 域
	 */
	@RequestMapping(value = "selectIdeaList", method = RequestMethod.GET)
	public String selectIdeaList(PageData pageData, Map<Object, Object> map) {
		try {
			pageData = DefaultUtils.getPageData(pageData);
			List<Idea> ideaList = ideaService.selectIdeaList(pageData);
			pageData.setPages(ideaService.getPages(pageData.getLimit()));
			pageData.setCount(ideaService.selectObjectCount());
			map = DefaultUtils.getSelectSuccessMap(map,ideaList, pageData, url);
			return "idea_query";
		} catch (Exception e) {
			e.printStackTrace();
			map = DefaultUtils.getSelectErrorMap(map, url);
			return "result";
		}
	}

}

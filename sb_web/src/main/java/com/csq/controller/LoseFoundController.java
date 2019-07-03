package com.csq.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csq.entity.LoseFound;
import com.csq.entity.PageData;
import com.csq.service.LoseFoundService;
import com.csq.utils.DefaultUtils;

/**
 * 失物招领Controller
 * @author bozpower
 *
 */
@Controller
@RequestMapping("loseFoundController")
public class LoseFoundController {
	
	@Autowired
	private LoseFoundService loseFoundService;
	
	private static final  String url = "selectLoseFoundList";
	
	
	/**
	 * url: loseFoundController/selectLoseFoundList
	 * 	分页查询失物招领信息
	 * @param pageData
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "selectLoseFoundList", method = RequestMethod.GET)
	public String selectLoseFoundList(PageData pageData, Map<Object, Object> map) {
		try {
			pageData = DefaultUtils.getPageData(pageData);
			List<LoseFound> loseFoundList = loseFoundService.selectLoseFoundList(pageData);
			pageData.setPages(loseFoundService.getPages(pageData.getLimit()));
			pageData.setCount(loseFoundService.selectObjectCount());
//			map.put("objList", loseFoundList);
//			map.put("pageData", pageData);
//			map.put("location", "selectLoseFoundList");
			map  = DefaultUtils.getSelectSuccessMap(map, loseFoundList, pageData, url);
			return "losefound_query";
		} catch (Exception e) {
			e.printStackTrace();
			map.put("result", "查询错误");
			map.put("href", "selectLoseFoundList");
			return "result";
		}
	}

}

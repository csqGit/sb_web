package com.csq.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csq.entity.Happiness;
import com.csq.service.HappinessService;

//@Controller
//@RequestMapping("happinessController")
public class HappinessController {
//	@Autowired
	private HappinessService happinessService;
	
	@RequestMapping("findHappinessByCity")
	public String findHappinessByCity(String city, Map<String, Happiness> map) {
		Happiness happ = happinessService.findHappinessByCity(city);
		System.err.println(happ);
		map.put("happiness", happ);
		return "happiness";
	}
	
	
	@RequestMapping("insertHappiness")
	public String insertHappiness(String city, int num, Map<String, String> map) {
		happinessService.insertHappiness(city, num);
		map.put("msg", "添加成功");
		return "result";
	}

}

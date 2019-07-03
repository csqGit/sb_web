package com.csq.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csq.entity.Produce;

@RequestMapping("helloController")
@Controller
public class HelloController {
	
	
	@RequestMapping("hello")//helloController/hello
	@ResponseBody
	public String hello () {
		System.out.println("hello world");
		return "hello world";
	}
	
	
	@RequestMapping("welcome")//helloController/hello
	public String welcome (Map<String, Object> map) {
		System.out.println("hello world");
		map.put("welcome", "welcome thymeleaf");
		
		//查询产品名称和价格
		Produce pro = new Produce();
		pro.setName("java");
		pro.setPrice(23.2);
		Produce pro2 = new Produce();
		pro2.setName("C++");
		pro2.setPrice(23.2);
		List<Produce> proList = new ArrayList<Produce>();
		proList.add(pro);
		proList.add(pro2);
		map.put("allProducts", proList);
		
		//utext 和text
		map.put("utext", "<h1>utext</h1>");
		map.put("text", "<h1>text</h1>");
		map.put("calendars", "2019/09/21");
		return "result";
	}

}

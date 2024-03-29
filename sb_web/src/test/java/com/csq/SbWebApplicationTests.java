package com.csq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.csq.entity.Classes;
import com.csq.service.ClassesService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SbWebApplicationTests {
	
	@Autowired
	private ClassesService classesService;

	@Test
	public void contextLoads() {
		Classes classes = classesService.selectClassesById(2);
		System.out.println(classes);
	}

}

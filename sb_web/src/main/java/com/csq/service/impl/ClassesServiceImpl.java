package com.csq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csq.entity.Classes;
import com.csq.entity.PageData;
import com.csq.mapper.ClassesMapper;
import com.csq.service.ClassesService;

@Service
public class ClassesServiceImpl implements ClassesService {
	
	@Autowired
	private ClassesMapper classesMapper;

	@Override
	public Classes selectClassesById(int id) {
		// TODO Auto-generated method stub
		return classesMapper.selectClassesById(id);
	}

	@Override
	public List<Classes> selectClassesList(PageData pageData) {
		// TODO Auto-generated method stub
		return classesMapper.selectClassesList(pageData);
	}

	@Override
	public void insertClasses(Classes classes) {
		classesMapper.insertClasses(classes);

	}

	@Override
	public void editClasses(Classes classes) {
		classesMapper.editClasses(classes);

	}

	@Override
	public void deleteClassesById(int id) {
		classesMapper.deleteClassesById(id);

	}

	@Override
	public int selectObjectCount() {
		
		return classesMapper.selectClassesCount();
	}

	@Override
	public int getPages(int limit) {
		if(limit == 0) {
			limit = 10;
		}
		int count = this.selectObjectCount();
		int pages = count / limit;
		if(count % limit != 0)
			pages ++;
		return pages;
	}

}

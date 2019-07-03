package com.csq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csq.entity.New;
import com.csq.entity.PageData;
import com.csq.mapper.NewMapper;
import com.csq.service.NewService;

@Service
public class NewServiceImpl implements NewService {
	
	@Autowired
	private NewMapper newMapper;

	@Override
	public New selectNewById(int id) {
		
		return newMapper.findNewById(id);
	}

	@Override
	public List<New> selectNewList(PageData pageData) {
		// TODO Auto-generated method stub
		return newMapper.selectNewList( pageData);
	}

	@Override
	public void insertNew(New news) {
		newMapper.insertNew(news);
		
	}

	@Override
	public void editNew(New news) {
		
		newMapper.editNew(news);
	}

	@Override
	public void deleteNewById(int id) {
		newMapper.deleteNewById(id);
	}

	@Override
	public int selectObjectCount() {
		
		return newMapper.selectNewCount();
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

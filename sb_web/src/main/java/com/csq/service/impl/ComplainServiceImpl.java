package com.csq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csq.entity.Complain;
import com.csq.entity.PageData;
import com.csq.mapper.ComplainMapper;
import com.csq.service.ComplainService;

@Service
public class ComplainServiceImpl implements ComplainService {

	@Autowired
	private ComplainMapper complainMapper;

	@Override
	public Complain selectComplainById(int id) {
		// TODO Auto-generated method stub
		return complainMapper.selectComplainById(id);
	}

	@Override
	public List<Complain> selectComplainList(PageData pageData) {
		// TODO Auto-generated method stub
		return complainMapper.selectComplainList(pageData);
	}

	@Override
	public void insertComplain(Complain complain) {
		complainMapper.insertComplain(complain);
	}

	@Override
	public void editComplain(Complain complain) {
		complainMapper.editComplain(complain);

	}

	@Override
	public void deleteComplainById(int id) {
		complainMapper.deleteComplainById(id);
	}

	@Override
	public int selectObjectCount() {
		// TODO Auto-generated method stub
		return complainMapper.selectComplainCount();
	}

	@Override
	public int getPages(int limit) {
		if (limit == 0) {
			limit = 10;
		}
		int count = this.selectObjectCount();
		int pages = count / limit;
		if (count % limit != 0)
			pages++;
		return pages;
	}

}

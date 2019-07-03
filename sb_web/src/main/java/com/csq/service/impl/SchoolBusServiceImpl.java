package com.csq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csq.entity.PageData;
import com.csq.entity.SchoolBus;
import com.csq.mapper.SchoolBusMapper;
import com.csq.service.SchoolBusService;

/**
 * 
 * @author bozpower
 *
 */
@Service
public class SchoolBusServiceImpl implements SchoolBusService {
	
	@Autowired
	private SchoolBusMapper schoolBusMapper;

	@Override
	public List<SchoolBus> selectSchoolBusList(PageData pageData) {
		
		return schoolBusMapper.selectSchoolBusList(pageData);
	}

	@Override
	public void insertSchoolBus(SchoolBus schoolBus) {
		schoolBusMapper.insertSchoolBus(schoolBus);
		
	}

	@Override
	public SchoolBus selectSchoolBusById(int id) {
		// TODO Auto-generated method stub
		return schoolBusMapper.selectSchoolBusById(id);
	}

	@Override
	public void editSchoolBus(SchoolBus schoolBus) {
		schoolBusMapper.editSchoolBus(schoolBus);
	}

	@Override
	public void deleteSchoolBusById(int id) {
		schoolBusMapper.deleteSchoolBusById(id);
	}

	@Override
	public int selectObjectCount() {
		// TODO Auto-generated method stub
		return schoolBusMapper.selectSchoolBusCount();
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

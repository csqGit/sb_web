package com.csq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csq.entity.PageData;
import com.csq.entity.Repair;
import com.csq.mapper.RepairMapper;
import com.csq.service.RepairService;


@Service
public class RepairServiceImpl implements RepairService {
	
	@Autowired
	private RepairMapper repairMapper;

	@Override
	public Repair selectRepairById(int id) {
		// TODO Auto-generated method stub
		return repairMapper.selectRepairById(id);
	}

	@Override
	public List<Repair> selectRepairList(PageData pageData) {
		// TODO Auto-generated method stub
		return repairMapper.selectRepairList(pageData);
	}

	@Override
	public void insertRepair(Repair repair) {
		// TODO Auto-generated method stub
		repairMapper.insertRepair(repair);
	}

	@Override
	public void editRepair(Repair repair) {
		// TODO Auto-generated method stub
		repairMapper.editRepair(repair);
	}

	@Override
	public void deleteRepairById(int id) {
		// TODO Auto-generated method stub
		repairMapper.deleteRepairById(id);
	}

	@Override
	public int selectObjectCount() {
		// TODO Auto-generated method stub
		return repairMapper.selectRepairCount();
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

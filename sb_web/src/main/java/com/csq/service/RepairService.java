package com.csq.service;

import java.util.List;

import com.csq.entity.Repair;
import com.csq.entity.PageData;

public interface RepairService {
	
	public Repair selectRepairById(int id);
	
	public List<Repair> selectRepairList(PageData pageData);

	public void insertRepair(Repair repairs);
	
	public void editRepair(Repair repairs);
	
	public void deleteRepairById(int id);
	
	/**
	 * 查询总条数
	 * @return
	 */
	public int selectObjectCount();
	
	
	/**
	 * 计算总页数
	 * @return
	 */
	public int getPages(int limit);

}

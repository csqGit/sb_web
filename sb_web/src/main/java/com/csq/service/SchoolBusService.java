package com.csq.service;

import java.util.List;

import com.csq.entity.PageData;
import com.csq.entity.SchoolBus;

public interface SchoolBusService {
	/**
	 * 分页查询校车信息列表
	 * 
	 * @param pageData
	 * @return
	 */
	public List<SchoolBus> selectSchoolBusList(PageData pageData);

	/**
	 * 新增校车信息
	 * 
	 * @param schoolBus
	 */
	public void insertSchoolBus(SchoolBus schoolBus);

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	public SchoolBus selectSchoolBusById(int id);

	/**
	 * 查询总条数
	 * 
	 * @return
	 */
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
	/**
	 * 编辑校车信息
	 * 
	 * @param schoolBus
	 */
	public void editSchoolBus(SchoolBus schoolBus);

	/**
	 * 删除校车信息
	 * 
	 * @param id
	 */
	public void deleteSchoolBusById(int id);

}

package com.csq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.csq.entity.PageData;
import com.csq.entity.SchoolBus;

@Mapper
public interface SchoolBusMapper {

	/**
	 * 分页查询校车信息列表
	 * @param pageData
	 * @return
	 */
	public List<SchoolBus> selectSchoolBusList(PageData pageData);
	
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public SchoolBus selectSchoolBusById(int id);
	
	
	/**
	 * 查询总条数
	 * @return
	 */
	public int selectSchoolBusCount();
	
	
	/**
	 * 编辑校车信息
	 * @param schoolBus
	 */
	public void editSchoolBus(SchoolBus schoolBus);
	
	
	/**
	 * 编辑校车信息
	 * @param id
	 */
	public void deleteSchoolBusById(int id);
	
	
	
	
	
	/**
	 * 新增校车信息
	 * @param schoolBus
	 */
	public void insertSchoolBus(SchoolBus schoolBus);
	
}

package com.csq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.csq.entity.Repair;
import com.csq.entity.PageData;

/**
 * 教室申请审核接口
 * selectRepairList  
 * selectRepairById  
 * selectRepairCount  
 * editRepair 
 * deleteRepairById   
 * insertRepair
 * @author bozpower
 *
 */

@Mapper
public interface RepairMapper {
	/**
	 * 分页查询校车信息列表
	 * @param pageData
	 * @return
	 */
	public List<Repair> selectRepairList(PageData pageData);
	
	
	/**
	 * 
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Repair selectRepairById(int id);
	
	
	/**
	 * 查询总条数
	 * @return
	 */
	public int selectRepairCount();
	
	
	/**
	 * 编辑校车信息
	 * @param Repair
	 */
	public void editRepair(Repair repair);
	
	
	/**
	 * 编辑校车信息
	 * @param id
	 */
	public void deleteRepairById(int id);
	
	
	
	/**
	 * 新增校车信息
	 * @param Repair
	 */
	public void insertRepair(Repair repair);
	
}

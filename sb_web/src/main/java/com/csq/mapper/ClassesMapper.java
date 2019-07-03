package com.csq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.csq.entity.Classes;
import com.csq.entity.PageData;

/**
 * 教室申请审核接口
 * selectClassesList  
 * selectClassesById  
 * selectClassesCount  
 * editClasses 
 * deleteClassesById   
 * insertClasses
 * @author bozpower
 *
 */
@Mapper
public interface ClassesMapper {
	/**
	 * 分页查询校车信息列表
	 * @param pageData
	 * @return
	 */
	public List<Classes> selectClassesList(PageData pageData);
	
	
	/**
	 * 
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Classes selectClassesById(int id);
	
	
	/**
	 * 查询总条数
	 * @return
	 */
	public int selectClassesCount();
	
	
	/**
	 * 编辑校车信息
	 * @param Classes
	 */
	public void editClasses(Classes classes);
	
	
	/**
	 * 编辑校车信息
	 * @param id
	 */
	public void deleteClassesById(int id);
	
	
	
	/**
	 * 新增校车信息
	 * @param Classes
	 */
	public void insertClasses(Classes classes);
	
}

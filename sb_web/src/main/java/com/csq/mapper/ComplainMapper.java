package com.csq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.csq.entity.Complain;
import com.csq.entity.PageData;

/**
 * 教室申请审核接口
 * selectComplainList  
 * selectComplainById  
 * selectComplainCount  
 * editComplain 
 * deleteComplainById   
 * insertComplain
 * @author bozpower
 *
 */

@Mapper
public interface ComplainMapper {
	/**
	 * 分页查询校车信息列表
	 * @param pageData
	 * @return
	 */
	public List<Complain> selectComplainList(PageData pageData);
	
	
	/**
	 * 
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Complain selectComplainById(int id);
	
	
	/**
	 * 查询总条数
	 * @return
	 */
	public int selectComplainCount();
	
	
	/**
	 * 编辑校车信息
	 * @param Complain
	 */
	public void editComplain(Complain complain);
	
	
	/**
	 * 编辑校车信息
	 * @param id
	 */
	public void deleteComplainById(int id);
	
	
	
	/**
	 * 新增校车信息
	 * @param Complain
	 */
	public void insertComplain(Complain complain);
	
}

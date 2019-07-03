package com.csq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.csq.entity.LoseFound;
import com.csq.entity.PageData;

/**
 * 	失物招领接口
 * 
 *
 */
@Mapper
public interface LoseFoundMapper {
	/**
	 * 分页查询丢失物品信息列表
	 * @param pageData
	 * @return
	 */
	public List<LoseFound> selectLoseFoundList(PageData pageData);
	
	
	/**
	 * 
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public LoseFound selectLoseFoundById(int id);
	
	
	/**
	 * 查询总条数
	 * @return
	 */
	public int selectLoseFoundCount();
	
	
	/**
	 * 编辑校车信息
	 * @param LoseFound
	 */
	public void editLoseFound(LoseFound loseFound);
	
	
	/**
	 * 编辑校车信息
	 * @param id
	 */
	public void deleteLoseFoundById(int id);
	
	
	
	/**
	 * 新增校车信息
	 * @param LoseFound
	 */
	public void insertLoseFound(LoseFound loseFound);
	
}

package com.csq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.csq.entity.Idea;
import com.csq.entity.PageData;

/**
 * 教室申请审核接口
 * 
 *
 */
@Mapper
public interface IdeaMapper {
	/**
	 * 分页查询校车信息列表
	 * @param pageData
	 * @return
	 */
	public List<Idea> selectIdeaList(PageData pageData);
	
	
	/**
	 * 
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public Idea selectIdeaById(int id);
	
	
	/**
	 * 查询总条数
	 * @return
	 */
	public int selectIdeaCount();
	
	
	/**
	 * 编辑校车信息
	 * @param Idea
	 */
	public void editIdea(Idea idea);
	
	
	/**
	 * 编辑校车信息
	 * @param id
	 */
	public void deleteIdeaById(int id);
	
	
	
	/**
	 * 新增校车信息
	 * @param Idea
	 */
	public void insertIdea(Idea idea);
	
}

package com.csq.service;

import java.util.List;

import com.csq.entity.Idea;
import com.csq.entity.PageData;

public interface IdeaService {
	
	public Idea selectIdeaById(int id);
	
	public List<Idea> selectIdeaList(PageData pageData);

	public void insertIdea(Idea ideas);
	
	public void editIdea(Idea ideas);
	
	public void deleteIdeaById(int id);
	
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

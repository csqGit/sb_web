package com.csq.service;

import java.util.List;

import com.csq.entity.New;
import com.csq.entity.PageData;

public interface NewService {
	
	public New selectNewById(int id);
	
	public List<New> selectNewList(PageData pageData);

	public void insertNew(New news);
	
	public void editNew(New news);
	
	public void deleteNewById(int id);
	
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

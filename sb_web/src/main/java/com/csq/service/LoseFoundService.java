package com.csq.service;

import java.util.List;

import com.csq.entity.LoseFound;
import com.csq.entity.PageData;

public interface LoseFoundService {
	
	public LoseFound selectLoseFoundById(int id);
	
	public List<LoseFound> selectLoseFoundList(PageData pageData);

	public void insertLoseFound(LoseFound loseFounds);
	
	public void editLoseFound(LoseFound loseFounds);
	
	public void deleteLoseFoundById(int id);
	
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

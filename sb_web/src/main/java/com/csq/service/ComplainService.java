package com.csq.service;

import java.util.List;

import com.csq.entity.Complain;
import com.csq.entity.PageData;

public interface ComplainService {
	
	public Complain selectComplainById(int id);
	
	public List<Complain> selectComplainList(PageData pageData);

	public void insertComplain(Complain complains);
	
	public void editComplain(Complain complains);
	
	public void deleteComplainById(int id);
	
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

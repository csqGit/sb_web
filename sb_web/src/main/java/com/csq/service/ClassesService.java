package com.csq.service;

import java.util.List;

import com.csq.entity.Classes;
import com.csq.entity.PageData;

public interface ClassesService {
	
	public Classes selectClassesById(int id);
	
	public List<Classes> selectClassesList(PageData pageData);

	public void insertClasses(Classes classess);
	
	public void editClasses(Classes classess);
	
	public void deleteClassesById(int id);
	
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

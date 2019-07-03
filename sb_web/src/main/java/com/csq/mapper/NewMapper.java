package com.csq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.csq.entity.New;
import com.csq.entity.PageData;

@Mapper
public interface NewMapper {

	public New findNewById(@Param("id") int id);
	
	public List<New> selectNewList(PageData pageData);
	
	public New selectNewById(int id);
	
	public void insertNew(New news);
	
	public void editNew(New news);
	
	public void deleteNewById(int id);
	
	/**
	 * 查询总条数
	 * @return
	 */
	public int selectNewCount();
	
	

	
}

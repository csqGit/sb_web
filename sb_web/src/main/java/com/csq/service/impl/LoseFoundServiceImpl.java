package com.csq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csq.entity.PageData;
import com.csq.entity.LoseFound;
import com.csq.mapper.LoseFoundMapper;
import com.csq.service.LoseFoundService;


@Service
public class LoseFoundServiceImpl implements LoseFoundService {
	
	@Autowired
	private LoseFoundMapper loseFoundMapper;

	@Override
	public LoseFound selectLoseFoundById(int id) {
		// TODO Auto-generated method stub
		return loseFoundMapper.selectLoseFoundById(id);
	}

	@Override
	public List<LoseFound> selectLoseFoundList(PageData pageData) {
		// TODO Auto-generated method stub
		return loseFoundMapper.selectLoseFoundList(pageData);
	}

	@Override
	public void insertLoseFound(LoseFound loseFound) {
		// TODO Auto-generated method stub
		loseFoundMapper.insertLoseFound(loseFound);
	}

	@Override
	public void editLoseFound(LoseFound loseFound) {
		// TODO Auto-generated method stub
		loseFoundMapper.editLoseFound(loseFound);
	}

	@Override
	public void deleteLoseFoundById(int id) {
		// TODO Auto-generated method stub
		loseFoundMapper.deleteLoseFoundById(id);
	}

	@Override
	public int selectObjectCount() {
		// TODO Auto-generated method stub
		return loseFoundMapper.selectLoseFoundCount();
	}

	@Override
	public int getPages(int limit) {
		if(limit == 0) {
			limit = 10;
		}
		int count = this.selectObjectCount();
		int pages = count / limit;
		if(count % limit != 0)
			pages ++;
		return pages;
	}

}

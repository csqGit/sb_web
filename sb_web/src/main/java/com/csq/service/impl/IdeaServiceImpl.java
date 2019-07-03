package com.csq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csq.entity.Idea;
import com.csq.entity.PageData;
import com.csq.mapper.IdeaMapper;
import com.csq.service.IdeaService;


@Service
public class IdeaServiceImpl implements IdeaService {
	
	@Autowired
	private IdeaMapper ideaMapper;

	@Override
	public Idea selectIdeaById(int id) {
		// TODO Auto-generated method stub
		return ideaMapper.selectIdeaById(id);
	}

	@Override
	public List<Idea> selectIdeaList(PageData pageData) {
		// TODO Auto-generated method stub
		return ideaMapper.selectIdeaList(pageData);
	}

	@Override
	public void insertIdea(Idea Idea) {
		// TODO Auto-generated method stub
		ideaMapper.insertIdea(Idea);
	}

	@Override
	public void editIdea(Idea Idea) {
		// TODO Auto-generated method stub
		ideaMapper.editIdea(Idea);
	}

	@Override
	public void deleteIdeaById(int id) {
		// TODO Auto-generated method stub
		ideaMapper.deleteIdeaById(id);
	}

	@Override
	public int selectObjectCount() {
		// TODO Auto-generated method stub
		return ideaMapper.selectIdeaCount();
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

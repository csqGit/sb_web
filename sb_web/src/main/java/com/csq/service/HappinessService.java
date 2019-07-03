package com.csq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csq.entity.Happiness;
import com.csq.mapper.HappinessMapper;

//@Service
public class HappinessService {

//	@Autowired
	private HappinessMapper happinessMapper;
	
	public Happiness findHappinessByCity(String city) {
		return happinessMapper.findHappinessByCity(city);
	}
	
	
	public void insertHappiness(String city, int num) {
		happinessMapper.insertHappiness(city, num);
	}
}

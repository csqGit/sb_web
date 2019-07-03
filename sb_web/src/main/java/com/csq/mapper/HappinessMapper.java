package com.csq.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.csq.entity.Happiness;

//@Mapper
public interface HappinessMapper {
	
	@Select("select * from happiness where city = #{city}")
	public Happiness findHappinessByCity(@Param("city") String city);
	
	
	@Insert("insert into happiness (city, num) values (#{city}, #{num})")
	public void insertHappiness(@Param("city")String city, @Param("num")int num);

}

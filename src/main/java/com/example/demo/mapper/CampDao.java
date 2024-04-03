package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Camp;

@Mapper
public interface CampDao {

	public Camp findCamp(String camp_no);
	
}

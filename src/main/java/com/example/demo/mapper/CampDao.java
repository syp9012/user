package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Camp;

@Mapper
public interface CampDao {
	
	public Camp findCamp(String camp_no);
	public List<Camp> searchCampList(Camp camp);
	public int getListCount(Camp camp);
	
}

package com.example.demo.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Camp;
import com.example.demo.model.Tour;

@Mapper
public interface RecommendDao {
	
	public String recommendLoc();
	public List<Camp> recommendCamp(String loc);
	public List<Tour> recommendTour(String loc);


}

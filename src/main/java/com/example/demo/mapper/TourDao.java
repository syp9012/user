package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Camp;
import com.example.demo.model.Tour;

@Mapper
public interface TourDao {

	public Tour findTour(String tour_id);
	
}

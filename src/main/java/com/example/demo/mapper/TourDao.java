package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Camp;
import com.example.demo.model.Tour;

@Mapper
public interface TourDao {

	public Tour findTour(String tour_id);

	public int getListCount(Tour tour);

	public List<Tour> searchTourList(Tour tour);
	
}

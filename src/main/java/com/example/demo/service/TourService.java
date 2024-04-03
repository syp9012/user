package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.TourDao;
import com.example.demo.model.Tour;

@Service
public class TourService {
	@Autowired
	TourDao dao;
	
	public Tour findTour(String tour_id) {
		return dao.findTour(tour_id);
	}
	
	
}

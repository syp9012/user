package com.example.demo.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.RecommendDao;
import com.example.demo.model.Camp;
import com.example.demo.model.Tour;

@Service
public class RecommendService {

	@Autowired
	private RecommendDao dao;

	public String recommendLoc() {
		return dao.recommendLoc();
	}
	public List<Tour> recommendTour(String loc) {
		System.out.println("service 접속");
		return dao.recommendTour(loc);
	}
	public List<Camp> recommendCamp(String loc) {
		System.out.println("service 접속");
		return dao.recommendCamp(loc);
	}
}

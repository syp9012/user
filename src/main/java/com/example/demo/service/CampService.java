package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.CampDao;
import com.example.demo.model.Camp;

@Service
public class CampService {
	@Autowired
	CampDao dao;
	
	public Camp findCamp(String camp_no) {
		return dao.findCamp(camp_no);
	}
	
	
}

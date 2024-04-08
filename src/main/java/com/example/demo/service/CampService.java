package com.example.demo.service;

import java.util.List;

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

	public List<Camp> searchCampList(Camp camp) {
		return dao.searchCampList(camp);
	}

	public int getListCount(Camp camp) {
		return dao.getListCount(camp);
	}
	
	
}

package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Camp;
import com.example.demo.service.CampService;

@Controller
public class CampController {
	@Autowired
	CampService service;
	
	
	@RequestMapping("campDetail.do")
	public String campDetail(@RequestParam("camp_no")String camp_no, Model model) {
		System.out.println(camp_no);
		Camp campDetail = service.findCamp(camp_no);
		
		model.addAttribute("camp",campDetail);
		
		return "camp/campDetail";
	}
	
}

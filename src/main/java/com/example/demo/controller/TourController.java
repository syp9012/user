package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Tour;
import com.example.demo.service.TourService;

@Controller
public class TourController {
	@Autowired
	TourService service;
	
	
	@RequestMapping("tourDetail.do")
	public String tourDetail(@RequestParam("tour_id")String tour_id, Model model) {
		System.out.println(tour_id);
		Tour tourDetail = service.findTour(tour_id);
		
		model.addAttribute("tour",tourDetail);
		
		return "tour/tourDetail";
	}
	
}
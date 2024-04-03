package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Camp;
import com.example.demo.model.Tour;
import com.example.demo.service.RecommendService;

@Controller
public class RecommendController {
	
	@Autowired
	private RecommendService service;
	
	
	@RequestMapping("recommend.do")
	public String recommandTour(Model model) {
		
		String loc = service.recommendLoc();
		System.out.println(loc);
		
		List<Tour> tourList = service.recommendTour(loc);
		List<Camp> campList = service.recommendCamp(loc);
		
		for(Tour tour : tourList) {
			if(tour.getTour_images()!="") {
				String[] image = tour.getTour_images().split(",");
				tour.setTour_image1(image[0]);
			}
			String[] addr = tour.getTour_addr1().split(" ");
			tour.setTour_addr1st(addr[0]);
			tour.setTour_addr2nd(addr[1]);
		}


		model.addAttribute("campList",campList);
		model.addAttribute("tourList",tourList);
		
		return "main/mainPage";
		
	}
	
	
}

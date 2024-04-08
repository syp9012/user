package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Camp;
import com.example.demo.model.Tour;
import com.example.demo.service.MainService;

@Controller
public class MainController {
	
	@Autowired
	private MainService service;
	
	
	@RequestMapping("main.do")
	public String recommendCampTour(Model model) {
		
		String loc = service.recommendLoc();
		//System.out.println(loc);
		
		List<Tour> tourList = service.recommendTour(loc);
		List<Camp> campList = service.recommendCamp(loc);
		
		for(Tour tour : tourList) {
			if(tour.getTour_images()!="") {
				String[] image = tour.getTour_images().split(",");
				tour.setTour_image1(image[0]);
			} else {
				tour.setTour_image1("");
			}
			String[] addr = tour.getTour_addr1().split(" ");
			tour.setDo_name(addr[0]);
			tour.setCity_name(addr[1]);
		}


		model.addAttribute("campList",campList);
		model.addAttribute("tourList",tourList);
		
		return "main";
		
	}
	
	
}

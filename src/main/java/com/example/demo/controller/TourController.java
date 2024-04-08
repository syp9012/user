package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	//조건에 맞는 캠핑장 리스트를 조회하는 기능
	
	  @RequestMapping("tourSearch.do")
	  public String tourSearch(@RequestParam(value="page", defaultValue = "1") int page,
			  					@ModelAttribute Tour tour, Model model) {
	  
	  System.out.println("search word:"+tour.getSearch_word());
	  System.out.println("search do_name:"+tour.getDo_name());
	  System.out.println("search city_name:"+tour.getCity_name());
	  
	  List<Tour> searchTourList = new ArrayList<Tour>();
	  
	  int limit=10;
	  
	  //데이터 갯수 
	  int listcount = service.getListCount(tour);
	  System.out.println(listcount);
	  
	  int maxPage = listcount / limit + ((listcount % limit == 0) ? 0 : 1);
	  
	  int startPage = ((page - 1) / 10) * limit + 1; // 1, 11, 21.. 
	  int endPage = startPage + 10 - 1; // 10, 20, 30..
	  
	  if (endPage > maxPage) endPage = maxPage;
	  
	  int startRow=(page-1) * 10+1; 
	  int endRow=page*10;
	  
	  tour.setStartRow(startRow); 
	  tour.setEndRow(endRow); 
	  tour.setLimit(limit);
	  
	  
	  searchTourList = service.searchTourList(tour);
	  
	  for(Tour tourList : searchTourList) {
			if(tourList.getTour_images()!="") {
				String[] image = tourList.getTour_images().split(",");
				tourList.setTour_image1(image[0]);
			} else {
				tourList.setTour_image1("");
			}
	  }
	  
	  
	  System.out.println("startRow"+startRow); System.out.println("endRow"+endRow);
	  System.out.println("tour"+tour);
	  System.out.println("tourList"+searchTourList); System.out.println("page"+
	  page); System.out.println("startPage"+ startPage);
	  System.out.println("endPage"+ endPage); System.out.println("maxPage"+
	  maxPage); System.out.println("listcount"+ listcount); //검색조건에 맞는 tour list를 가져옵니다.
	  
	  model.addAttribute("tour",tour);
	  model.addAttribute("tourList",searchTourList); model.addAttribute("page",
	  page); model.addAttribute("startPage", startPage);
	  model.addAttribute("endPage", endPage); model.addAttribute("maxPage",
	  maxPage); model.addAttribute("listcount", listcount);
	  
	  
	  return "tour/tourSearch"; 
	  }
	 
}
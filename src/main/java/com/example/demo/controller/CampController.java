package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Camp;
import com.example.demo.service.CampService;

@Controller
public class CampController {
	@Autowired
	CampService service;
	
	//캠핑장 상세페이지
	@RequestMapping("campDetail.do")
	public String campDetail(@RequestParam(value="page", defaultValue = "1") int page,
							@RequestParam("camp_no")String camp_no, Model model) {
		// camp_no를 가지고 camp 객체를 구해옵니다.
		Camp campDetail = service.findCamp(camp_no);
		model.addAttribute("page",page);
		model.addAttribute("camp",campDetail);
		
		return "camp/campDetail";
	}
	
	//조건에 맞는 캠핑장 리스트를 조회하는 기능
	@RequestMapping("campSearch.do")
	public String campSearch(@RequestParam(value="page", defaultValue = "1") int page,
							@ModelAttribute Camp camp, Model model) {
		
		System.out.println("search word:"+camp.getSearch_word());
		System.out.println("search do_name:"+camp.getDo_name());
		System.out.println("search city_name:"+camp.getCity_name());
		
		List<Camp> searchCampList = new ArrayList<Camp>();
		
		int limit=10;
		
		//데이터 갯수
		int listcount = service.getListCount(camp);
		System.out.println(listcount);
		
		int maxPage = listcount / limit + ((listcount % limit == 0) ? 0 : 1);

		int startPage = ((page - 1) / 10) * limit + 1; 		// 1,  11, 21..
		int endPage = startPage + 10 - 1; 			   		// 10, 20, 30..
		
		if (endPage > maxPage)
			endPage = maxPage;
		
		int startRow=(page-1) * 10+1;
		int endRow=page*10;

		camp.setStartRow(startRow);
		camp.setEndRow(endRow);
		camp.setLimit(limit);
		
		
		searchCampList = service.searchCampList(camp);
		
		
		System.out.println("startRow"+startRow);
		System.out.println("endRow"+endRow);
		System.out.println("camp"+camp);
		System.out.println("campList"+searchCampList);
		System.out.println("page"+ page);
		System.out.println("startPage"+ startPage);
		System.out.println("endPage"+ endPage);
		System.out.println("maxPage"+ maxPage);
		System.out.println("listcount"+ listcount);
		//검색조건에 맞는 camp list를 가져옵니다.
		
		model.addAttribute("camp",camp);
		model.addAttribute("campList",searchCampList);
		model.addAttribute("page", page);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("listcount", listcount);


		return "camp/campSearch";
	}
	
	
}

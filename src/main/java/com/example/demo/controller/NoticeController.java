package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Notice;
import com.example.demo.service.NoticeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService service;

	//공지사항 작성 폼으로 으로 이동
	@RequestMapping("insertNoticeForm.do")
	public String insertNoticeForm(Model model, HttpSession session) {
		return "notice/noticeForm";
	}
	
	
	//공지사항 작성
	@RequestMapping("insertNotice.do")
	public String insertNotice(@ModelAttribute Notice notice, Model model, HttpSession session) {
		
		service.insertNotice(notice);
		
		return "redirect:noticeList.do";
	}
	
	//리스트로 이동
	@GetMapping("noticeList.do")
	public String noticeList(@RequestParam(value="page", defaultValue = "1") int page,
							@ModelAttribute Notice notice, Model model, HttpSession session) {

		int limit = 10;
		int listcount = service.getListCount(notice);
		
		int startRow = (page-1) * limit; // limit는 인덱스로 계산
		int endRow = startRow + limit - 1;
		
		// 게시판 순번
		int no = listcount - startRow + 1;    
		int startPage = page - (page-1) % limit;
		int endPage = startPage + limit -1;
		int maxPage = (listcount/limit)+((listcount%limit==0) ? 0 : 1) ;
		
		if(endPage>maxPage) {
			endPage=maxPage;
		}
		
		notice.setStartRow(startRow);
		notice.setEndRow(endRow);
		notice.setLimit(limit);
		
		List<Notice> noticeList = service.getList(notice);
		
		System.out.println();
		
		System.out.println(no);
		System.out.println(notice);
		System.out.println(noticeList);
		System.out.println(page);
		System.out.println(startPage);
		System.out.println(endPage);
		System.out.println(maxPage);
		System.out.println(listcount);
		
		
		
		model.addAttribute("no",no);
		model.addAttribute("notice",notice);
		model.addAttribute("noticeList",noticeList);
		model.addAttribute("page", page);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("listcount", listcount);
		
		return "notice/list";
	}
	
	
	//공지사항 상세페이지로 이동
	@RequestMapping("noticeDetail.do")
	public String noticeDetail(@RequestParam(value="page", defaultValue = "1") int page,
						@ModelAttribute Notice notice, HttpSession session, Model model) {
		
		model.addAttribute("page",page);
		
		
		return "noticeDetail";
	}
	

	//업데이트 form으로 이동
	@RequestMapping("updateNoticeForm.do")
	public String updateNoticeForm(@RequestParam(value="page", defaultValue = "1") int page,
			@ModelAttribute Notice notice, HttpSession session, Model model) {
		
		model.addAttribute("notice",notice);
		model.addAttribute("page",page);	
		
		return "noticeUpdate";
	}
	
	@RequestMapping("updateNotice.do")
	public String updateNotice(@RequestParam(value="page", defaultValue = "1") int page,
								@ModelAttribute Notice notice, HttpSession session, Model model) {
		service.updateNotice(notice);
		
		String searchWord=notice.getSearchWord();

		return "noticeList.do?page="+page+"&searchWord="+searchWord;
	}
	
	
	// 삭제
	@RequestMapping("deleteNotice.do")
	public String deleteNotice(@RequestParam(value="page", defaultValue = "1") int page,
							@ModelAttribute Notice notice, HttpSession session, Model model) {
		
		service.deleteNotice(notice);
		return "noticeList.do?page="+page;
	}
	
		
	
}

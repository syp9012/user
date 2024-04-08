package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.NoticeDao;
import com.example.demo.model.Notice;

@Service
public class NoticeService {

	@Autowired
	private NoticeDao dao;

	public int getListCount(Notice notice) {
		return dao.getListCount(notice);
	}

	public List<Notice> getList(Notice notice) {
		return dao.getList(notice);
	}

	public void insertNotice(Notice notice) {
		dao.insertNotice(notice);
		
	}

	public void deleteNotice(Notice notice) {
		dao.deleteNotice(notice);
	}

	public void updateNotice(Notice notice) {
		dao.updateNotice(notice);
		
	}
	
}

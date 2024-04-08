package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Notice;

@Mapper
public interface NoticeDao {

	public int getListCount(Notice notice);

	public List<Notice> getList(Notice notice);

	public void insertNotice(Notice notice);

	public void deleteNotice(Notice notice);

	public void updateNotice(Notice notice);
	
	
}

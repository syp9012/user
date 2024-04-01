package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserDao;
import com.example.demo.model.User;

@Service
public class UserService {
	@Autowired
	UserDao dao;
	
	//로그인 인증
	public User checkUser(String u_id) {
		return dao.checkUser(u_id);
	}
	
	// ID중복 체크
	public int checkUserId(String u_id) {
		int result = -1; // 사용가능
		User user = dao.checkUser(u_id);
		if(user != null) {
			result = 1; // 1은 사용 불가
		}
		return result;
	}
	

	//회원가입
	public int insertUser(User user) {
//		String rawPassword=user.getU_pwd();
//		String encPassword=encoder.encode(rawPassword);
		
		return dao.insertUser(user);
	}

	public int editUser(User user) {
		return dao.editUser(user);
		
	}

	public void updateUser(User user) {
		dao.updateUser(user);
	}

	public int deleteUser(String u_id) {
		int result = dao.deleteUser(u_id);
		return result;
		
	}
	
	
	
	// 
	
}

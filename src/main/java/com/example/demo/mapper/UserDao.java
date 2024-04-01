package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.User;

@Mapper
public interface UserDao {

	public User checkUser(String u_id);
	public int insertUser(User user);
	public int editUser(User user);
	public void updateUser(User user);
	public int deleteUser(String u_id);
	
	
}

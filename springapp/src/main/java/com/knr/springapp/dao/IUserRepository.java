package com.knr.springapp.dao;

import java.util.List;

import com.knr.springapp.vo.UserVO;

public interface IUserRepository {

	public List<UserVO> userList();

	public UserVO getUserInfo(String id);

	public void insertUser(UserVO user);

	public void updateUser(UserVO user);

	public void deleteUser(UserVO user);

	public String getPassword(String userid);
	
	public int userIdCheck(String userId);

}

package com.knr.springapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.knr.springapp.vo.UserVO;

@Repository
public class UserRepository implements IUserRepository{

	@Override
	public List<UserVO> userList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO getUserInfo(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertUser(UserVO user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(UserVO user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(UserVO user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getPassword(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int userIdCheck(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * RowMapper<UserVO> userMapper = new RowMapper<UserVO>() {
	 * 
	 * @Override public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException
	 * { UserVO user = new UserVO(); user.setUserId(rs.getString("user_id"));
	 * user.setPassword(rs.getString("password"));
	 * user.setName(rs.getString("name")); user.setTel(rs.getString("tel"));
	 * user.setPicture(rs.getBytes("picture"));
	 * user.setPictureSize(rs.getLong("picture_size")); return null; } };
	 * 
	 */

}


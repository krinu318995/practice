package com.knr.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.knr.springapp.dao.IUserRepository;
import com.knr.springapp.vo.UserVO;

@Service
public class UserService implements IUserService {

	@Autowired
	@Qualifier("userRepository")
	IUserRepository userRepository;

	
	@Autowired
	BCryptPasswordEncoder bpe;
	
	@Override
	public List<UserVO> userList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO getUserInfo(String id) {
		// TODO Auto-generated method stub
		return userRepository.getUserInfo(id);
	}

	@Override
	public void insertUser(UserVO user) {
		user.setPassword(bpe.encode(user.getPassword()));
		userRepository.insertUser(user);
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
		return userRepository.getPassword(userid);
	}

	@Override
	public int userIdCheck(String userId) {
		// TODO Auto-generated method stub
		return userRepository.userIdCheck(userId);
	}

	
}

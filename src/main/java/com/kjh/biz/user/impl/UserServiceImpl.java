package com.kjh.biz.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kjh.biz.user.UserService;
import com.kjh.biz.user.UserVO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	public UserServiceImpl() {
	}

	@Override
	public UserVO getUser(UserVO vo){
		return this.userDAO.getUser(vo);
	}

	@Override
	public List<UserVO> getUserList(UserVO vo) {
		return this.userDAO.getUserList(vo);
	}
}

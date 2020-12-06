package com.kjh.biz.user.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kjh.biz.user.UserVO;

@Repository
public class UserDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public UserDAO() {
	}
	
	public UserVO getUser(UserVO vo){
		return this.sqlSession.selectOne("userDAO.getUser", vo);
	}

	public List<UserVO> getUserList(UserVO vo){
		return this.sqlSession.selectList("userDAO.getUserList", vo);

	}
}

package com.kjh.biz.user;

import java.util.List;

public interface UserService {

	UserVO getUser(UserVO vo);

	List<UserVO> getUserList(UserVO vo);
}
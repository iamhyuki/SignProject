package com.kjh.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kjh.biz.user.UserService;
import com.kjh.biz.user.UserVO;

@Controller
public class UserContoller {

	@Autowired
	private UserService userService;
	
	public UserContoller() {
	}
	
	/**
	 * 인덱스페이지에서 로그인페이지로 이동
	 * */
	@RequestMapping(value="/loginForm.do")
	public String loginView(@ModelAttribute("easyLogin")UserVO vo){
		vo.setUser_id("user9");
		vo.setUser_pw("user");
		return "login.jsp";
	}
	
	/**
	 * 로그인 버튼 클릭 시 요청사항
	 * 로그인 처리 및 세션에 저장 / getSignMain.do 요청
	 * */
	@RequestMapping(value="/getUser.do")
	public String getUser(UserVO vo, HttpSession session){
		UserVO user = this.userService.getUser(vo);
		if(user != null){
			session.setAttribute("user", user);
			return "getSignMain.do";
		} else {
			return "login.jsp";
		}
	}
	
	/**
	 * 로그아웃 버튼 클릭 시 요청사항
	 * 세션종료 / loginForm.do 요청
	 * */
	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session){
		session.invalidate();
		return "index.jsp";
	}
	
	/**
	 * 결재선 지정 클릭 시 요청사항 
	 * 사원목록 조회 후 결재선 지정화면 window.open
	 */
	@RequestMapping(value = "/getUserList.do")
	public String signLineUp(UserVO vo, Model model) {
		model.addAttribute("userList", this.userService.getUserList(vo));
		return "signLineUp.jsp";
	}
	
}

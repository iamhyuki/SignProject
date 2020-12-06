package com.kjh.view.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice("com.kjh.view")
public class CommonExceptionHandler {

	public CommonExceptionHandler() {
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView HandleException(Exception e){
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.setViewName("/common/error.jsp");
		return mav;
	}

}

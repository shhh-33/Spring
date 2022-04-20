package com.sasac.education.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

//없으면 pom.xml가서 버전번경 5.3.5
//전역 모든곳에서 오류
@ControllerAdvice
public class ExceptionController {
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public String handelr404(HttpServletRequest request , Model model) {
		
		model.addAttribute("message","존재하지않는 페이지입니다.");
		model.addAttribute("url", request.getRequestURI());
		
		
		return "error/errorPage404";
		
	}
	

	

}

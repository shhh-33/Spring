package com.sesac.springBootMVCProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	
	@RequestMapping("/hello1.do")
	public String method1(Model model) {
		
		model.addAttribute("myname", "aa");
		return "hello1"; ///WEB-INF/views/hello1.jsp
	}
}

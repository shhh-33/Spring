package kr.co.sesac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SesacController {
	
	@RequestMapping("/hello2.do")
	@ResponseBody
	public String hello2() {
		return "hello2";
	}

}

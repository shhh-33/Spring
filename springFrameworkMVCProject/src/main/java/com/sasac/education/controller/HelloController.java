package com.sasac.education.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.sasac.vo.BookVO;

@Controller
@RequestMapping("/test") // 주소에 공통적인 부분
//type level에 요청주소 작성하기 
public class HelloController {

	// servlet-context랑 보기

	// method level에 요청주소 전달
	@RequestMapping("/hello1") // 자신만 가지고 있는 부분
	public String hello1(HttpServletRequest request) {

		System.out.println("Hello1 요청");

		return "helloPage1"; // Page로 forward
		// /WEB-INF/views/helloPage1.jsp 로 썼었음
	}

	@RequestMapping("/hello2")
	public ModelAndView hello12(HttpServletRequest request) {

		System.out.println("Hello2 요청");
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", "SpringFrameWork 학습");
		mv.addObject("price", 500);
		mv.addObject("book", new BookVO(0, "java", "랄", "3", "아오"));

		mv.setViewName("helloPage1");
		return mv;

	}

	// 주소 여러개 배열로 가능
	@RequestMapping(value = { "/hello3", "hello4.do", "/hello3.test" })
	public String hello3(Model model) {

		model.addAttribute("myname", "jin");
		model.addAttribute("phone", "010");
		return "helloPage3";
	}

	@RequestMapping(value = { "/hello5" })
	public void hello5(Model model) {

		model.addAttribute("myname", "jin");
		model.addAttribute("phone", "010");
		// return "hello5.jsp"; 해야하는데 void면 ?
		// 리턴값없으면 주소값 value랑 똑같아야
	}

	// get방식은 생략가능
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGet() {

		return "user/loginForm";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(String userid, String userpass, Model model) {

		System.out.println("userid : " + userid);
		System.out.println("userpass : " + userpass);

		if (userid == null) {
			// 변수이름쓸때 띄어쓰기 조심하셈,................
			model.addAttribute("message", "로그인 아이디 없음 ");
		} else {
			model.addAttribute("message", "로그인 성공 ");

		}
		return "user/loginResult";
	}

	@RequestMapping(value = {"helloParam.do"},
			params = {"userid=sesac", "userpass", "!email"}, 
			method = RequestMethod.GET)
	public String helloParam(Model model, String userid, String userpass) {
		System.out.println("userid:" + userid);
		System.out.println("userpass:" + userpass);
	 
		model.addAttribute("message", "helloParam.do 로그인 성공하였습니다.");
		return "user/loginResult";
	}
//http://localhost:8080/education/test/helloParam.do?

}

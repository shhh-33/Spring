package com.sesac.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sesac.domain.MemberVO;

//bean으로 등록, Controller로 사용됨을 Spring Framework에 알린다.
//view 화면 return

@Controller
public class SampleController {
	@GetMapping("/sample1")
	public void sample1(Model model) {

		model.addAttribute("greeting", "안녕하세요");
	}
	
	@GetMapping("/sample2")
	public void sample2(Model model) {

		MemberVO vo = new MemberVO(227, "휴..", "비번..", "하..", new Timestamp(System.currentTimeMillis()));

		model.addAttribute("vo", vo);

	}
	
	//MemberVO객체를 리스트에 담아서 화면출력 
	@GetMapping("/sample3")
	public void sample3(Model model) {

		List<MemberVO> list = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			list.add(new MemberVO(228, "아이디" + i, "비밀번호" + i, "하길동씨" + i, new Timestamp(System.currentTimeMillis())));
		}
		model.addAttribute("list", list);

	}
	
	@GetMapping("/sample4")
	public void sample4(Model model) {

		List<MemberVO> list = new ArrayList<>();

		for (int i = 0; i < 10; i++) {

			list.add(new MemberVO(i, "u000" + i % 3, "p0000" + i % 3, "홍길동" + i,
					new Timestamp(System.currentTimeMillis())));
		}

		model.addAttribute("list", list);

	}
	

	@GetMapping("/sample5")
	public void sample5(Model model) {

		String result = "SUCCESS";

		model.addAttribute("result", result);

	}
	
	@GetMapping("/sample6")
	public void sample6(Model model) {

		List<MemberVO> list = new ArrayList<>();

		for (int i = 0; i < 10; i++) {

			list.add(new MemberVO(i, "u0" + i, "p0" + i, "부길동" + i,
					new Timestamp(System.currentTimeMillis())));
		}

		model.addAttribute("list", list);

		String result = "SUCCESS";

		model.addAttribute("result", result);

	}
	
	@GetMapping("/sample7")
	public void sample7(Model model) {

		model.addAttribute("now", new Date());
		model.addAttribute("price", 22745678);
		model.addAttribute("title", "배고픔 아이고");
		model.addAttribute("options", Arrays.asList("가","나","다","라"));
		
	}
	
	// /sample1과 같은 경로를 화면에서 처리
	@GetMapping("/sample8")
	public void sample8(Model model) {
		
	}
	

	
	@GetMapping("/sample/hello")
	public void hello(){
		
	}
}

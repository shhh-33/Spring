package com.sesac.boot1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sesac.boot1.domain.SampleVO;

/*
 * 스프링빈으로 등록
 * jsp,html파일 생성안해도 바로 브라우저로 전달가능
 * 
 */
@RestController 
public class SampleController {
    //주소 이렇게 
	@GetMapping("/hello")
	public String sayHello() {

		return "Hello World";
	}
	
	@GetMapping("/sample")
	public SampleVO makeSample() {

		SampleVO vo = new SampleVO();
		vo.setVal1("v1");
		vo.setVal2("v2");
		vo.setVal3("v3");

		System.out.println(vo);

		return vo;

	}
}

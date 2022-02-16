package com.sesac.springBootMVCProject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sesac.springBootMVCProject.repository.BoardRepository;
import com.sesac.springBootMVCProject.vo.BoardVO;
import com.sesac.springBootMVCProject.vo.CarVO;

@RestController // @Controller + @ResponseBody
public class RestfullController {

	@Autowired
	BoardRepository bRepo;
	

	
	@RequestMapping("/board/list2")
	public Iterable<BoardVO> selectByWriter(String writer){
		return bRepo.findByWriter(writer);
	}
	
	@RequestMapping("/board/list")
	public Iterable<BoardVO> selectAll(){
		return bRepo.findAll();
	}
	
	@RequestMapping("/hello3.do")
	public String test3() {

		return "@RestController에서 리턴";
	}

	@RequestMapping("/hello4.do")
	public CarVO test4() {

		CarVO car = CarVO.builder().model("차가격ㅋ").price(45).build();

		return car;
	}
	@RequestMapping("/hello5.do")
	public List<CarVO> test5() {
		
		List<CarVO> carlist = new ArrayList<>();
		
		CarVO car = CarVO.builder().model("차가격ㅋ").price(45).build();
		carlist.add(car);
		carlist.add(new CarVO("차2", 47889));
		return carlist;
	}
}

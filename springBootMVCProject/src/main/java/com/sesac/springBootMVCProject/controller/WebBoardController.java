package com.sesac.springBootMVCProject.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sesac.springBootMVCProject.repository.FreeBoardRepository;
import com.sesac.springBootMVCProject.vo.FreeBoard;
import com.sesac.springBootMVCProject.vo.PageMaker;
import com.sesac.springBootMVCProject.vo.PageVO;

@Controller
public class WebBoardController {
 
	
	@Autowired
	FreeBoardRepository boardRepo; //FreeBoardRepository(인터페이스) 변수 선언

	
	//글리스트보여주기
	@RequestMapping("/webboard/list")
	public String boardList(PageVO pageVO, Model model) {
		
		if (pageVO == null) {
			pageVO = new PageVO();
		} 
		
		//거의 다 내장된 기능
		Pageable pageable = PageRequest.of(pageVO.getPage(), pageVO.getSize(), Sort.by("bno").descending());
		Page<FreeBoard> result = boardRepo.findAll(pageable);

		model.addAttribute("blist", new PageMaker<>(result)); //blist란 이름으로 넘김
		return "board/list";
	}


	
	//글상세정보
	@GetMapping("/webboard/detail")
	public String boardDetail(Long bno, Model model) {
		model.addAttribute("board", boardRepo.findById(bno).get());
		return "board/detail";
	}

	
	
	@PostMapping("/webboard/update")
	public String boardDetailUpdate(FreeBoard board) {
		boardRepo.findById(board.getBno()).ifPresent(b -> {
			b.setTitle(board.getTitle());
			b.setWriter(board.getWriter());
			b.setContent(board.getContent());
			boardRepo.save(b);
		});

		return "redirect:list";
	}

	@GetMapping("/webboard/delete")
	public String boardDelete(Long bno) {
		boardRepo.deleteById(bno);
		return "redirect:list";
	}

	@GetMapping("/webboard/insert")
	public String boardInsert() {

		return "board/insertForm";
	}

	@PostMapping("/webboard/insert")
	public String boardInsert(FreeBoard board) {
		boardRepo.save(board);
		return "redirect:list";
	}

}
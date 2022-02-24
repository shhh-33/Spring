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
	FreeBoardRepository boardRepo; // FreeBoardRepository(인터페이스) 변수 선언

	// 글리스트보여주기
	@RequestMapping("/webboard/list")
	public String boardList(PageVO pageVO, Model model) {

		if (pageVO == null) {
			pageVO = new PageVO();
		}

		// 거의 다 내장된 기능 //Repository에 Paging을 요청할 때 사용하는 것 : 몇페이지 ,페이지 사이즈 , 정렬
		Pageable pageable = PageRequest.of(pageVO.getPage(), pageVO.getSize(), Sort.by("bno").descending());
		Page<FreeBoard> result = boardRepo.findAll(pageable); // 페이지 정보 주기
		// findAll : 해당 테이블에 있는 모든걸 가져옴
		model.addAttribute("blist", new PageMaker<>(result)); // Model : blist란 이름으로 넘김 /pageMaker호출
		return "board/list";
	}

	// 글 상세정보
	@GetMapping("/webboard/detail")
	public String boardDetail(Long bno, Model model) {
		model.addAttribute("board", boardRepo.findById(bno).get()); //글번호만 select해서 상세조회
		return "board/detail";
	}

	
	// 글 수정
	@PostMapping("/webboard/update")
	public String boardDetailUpdate(FreeBoard board) {
		boardRepo.findById(board.getBno()).ifPresent(b -> {
			b.setTitle(board.getTitle());
			b.setWriter(board.getWriter());
			b.setContent(board.getContent());
			boardRepo.save(b);
		});

		return "redirect:list?page=0&size=10";
	}

	// 글삭제
	@GetMapping("/webboard/delete")
	public String boardDelete(Long bno) {
		boardRepo.deleteById(bno);
		return "redirect:list?page=0&size=10";
	}

	// 새글등록
	@GetMapping("/webboard/insert") // <a href="insert"> 누르면 여기로
	public String boardInsert() {

		return "board/insertForm";  //insertForm.jsp로 가고 
	}

	@PostMapping("/webboard/insert")
	public String boardInsert(FreeBoard board) {
		boardRepo.save(board);  //저장
		return "redirect:list?page=0&size=10";  
	}

}

package com.sesac.springBootMVCProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sesac.springBootMVCProject.repository.FreeBoardReplyRepository;
import com.sesac.springBootMVCProject.repository.FreeBoardRepository;
import com.sesac.springBootMVCProject.vo.FreeBoard;
import com.sesac.springBootMVCProject.vo.FreeBoardReply;
import com.sesac.springBootMVCProject.vo.PageMaker;
import com.sesac.springBootMVCProject.vo.PageVO;

@RestController
public class ReplyRestController {

	@Autowired
	FreeBoardReplyRepository replyRepo;
	
	@Autowired
	FreeBoardRepository boardRepo;
	
	@PostMapping("/replies/add/{bno}")
	public List<FreeBoardReply> insert(
			@RequestBody FreeBoardReply reply, @PathVariable("bno") Long boardNo){
		System.out.println(reply);
		System.out.println("보드번호:" + boardNo);
		
		FreeBoard board =boardRepo.findById(boardNo).orElse(null);
		if(board==null) return null;
		
		reply.setBoard(board);
		replyRepo.save(reply);
		
		
		List<FreeBoardReply> replyList = replyRepo.findByBoard(board);
		return replyList;
	}


	
	@RequestMapping("replies/list/{bno}")
	public List<FreeBoardReply> selectAllByBoard(@PathVariable("bno") Long boardNo
			,PageVO pageVO, Model model) {
		FreeBoard board = boardRepo.findById(boardNo).orElse(null);
		if(board==null) return null;
		//보드에 해당하는 댓글을 뽑는다.
		
		if(pageVO==null) pageVO = new PageVO(); 
		Pageable pageable = PageRequest.of(pageVO.getPage(), pageVO.getSize(), Sort.by("bno").descending()); 
			     
		Page<FreeBoardReply> result = replyRepo.findAll(pageable);
		//전부 조회한 내역을 가지고 
		model.addAttribute("rlist", new PageMaker<>(result));
		//페이지를 만들어가지고 가져가라
		List<FreeBoardReply> replyList = replyRepo.findByBoard(board);
		return replyList;
	}
}



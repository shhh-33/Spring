package com.sesac.springBootMVCProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sesac.springBootMVCProject.repository.FreeBoardReplyRepository;
import com.sesac.springBootMVCProject.repository.FreeBoardRepository;
import com.sesac.springBootMVCProject.vo.FreeBoard;
import com.sesac.springBootMVCProject.vo.FreeBoardReply;

@RestController
public class ReplyRestContoller {

	@Autowired
	FreeBoardReplyRepository replyRepo;
	
	@Autowired
	FreeBoardRepository boardRepo;
	
	@RequestMapping("/replies/add/{bno}")
	public List<FreeBoardReply> insert(@RequestBody FreeBoardReply reply,
			                          @PathVariable("bno") Long boardNo){
		System.out.println("댓글번호"+reply);
		System.out.println("보드번호"+boardNo);
		
		FreeBoard board = boardRepo.findById(boardNo).orElse(null);
		reply.setBoard(board);
		replyRepo.save(reply);
		if(board==null) return null;
		List<FreeBoardReply> replyList =replyRepo.findByBoard(board);
		return replyList;
		
	}
	
	
	
	//@PathVariable("bno"){}가 주소창에 값으로 감
	@RequestMapping("/replies/list/{bno}")
	public List<FreeBoardReply> selectAllByBoard( @PathVariable("bno") Long boardNo) {
		FreeBoard board = boardRepo.findById(boardNo).orElse(null);
		if(board==null) return null;
		List<FreeBoardReply> replyList =replyRepo.findByBoard(board);
		return replyList;
	}
	
}

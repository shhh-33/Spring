package com.sasac.education.model;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sasac.vo.BoardFileVO;
import kr.co.sasac.vo.BoardVO;



@Service
public class BoardService {
	
	/**
	 * 전체게시글 조회
	 */
	
	
	@Autowired
	//BoardDAO dao; //JDBC직접이용
	BoardDAO_Mybatis dao; //Mybatis를 이용함
	
	public List<BoardVO> selectAllBoard(String keyword, String contents) {
		
		return dao.selectAllBoard(keyword,contents);
	}
	/**
	 * 게시물번호 추출(seq_tbl_board_no)
	 */
	public int selectBoardNo() {
		
		return dao.selectBoardNo();
	}
	
	/**
	 * 새글등록
	 */
	public int insertBoard(BoardVO board) {
		
		return dao.insertBoard(board);
	
	}
	
	/**
	 * 조회수 증가
	 */
	public int viewCnt(int boardNo) {
		return dao.viewCnt(boardNo);
		
	}
	
	/**
	 * 게시글 상세 보기
	 * @param boardNo
	 * @return
	 */
	public BoardVO selectBoardByNo(int boardNo) {
		
		return dao.selectBoardByNo(boardNo);
	}
	
	//삭제
	public int deleteByNo(int boardNo) {
		return dao.deleteByNo(boardNo);
	}
	
	/**
	 * 게시물 수정 (제목, 작성, 내용)
	 */
	public int updateBoard(BoardVO board) {
		return dao.updateBoard(board);
	}
	
	/**
	 * 페이징
	 */
	public int boardCnt() {
		
		return dao.boardCnt();
	}
	
	/**
	 * 첨부파일 CRUD
	 */
	public int insertFile(BoardFileVO fileVO) {
		
		return dao.insertFile(fileVO);
		
	}
	
	public List<BoardFileVO> selectFileByNo(int boardNo) {
		
		return dao.selectFileByNo(boardNo);
		
	}
}


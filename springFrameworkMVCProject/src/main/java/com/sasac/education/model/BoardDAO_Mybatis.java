package com.sasac.education.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.sasac.vo.BoardFileVO;
import kr.co.sasac.vo.BoardVO;



@Repository
public class BoardDAO_Mybatis {

	@Autowired
	SqlSession session;
	//SqlSession session :sql문 실행단위 :연결 , sql문 실행, 결과받기
	
	final String namespace= "com.sasac.board.";

	/**
	 * 전체게시글 조회
	 */
	public List<BoardVO> selectAllBoard(String keyword, String contents) {

        Map<String,String> myMap = new HashMap<>();
        myMap.put("keyword", keyword);
        myMap.put("contents", "%"+contents+"%");
        
		//List<BoardVO> blist= session.selectList(namespace+"selectAll");
		//return blist해서 찍어보든지
		return session.selectList(namespace+"selectAll",myMap);
		
	}

	/**
	 
	 * 게시물번호 추출(seq_tbl_board_no)
	 */
	public int selectBoardNo() {

		return session.selectOne(namespace + "selectBoardNo");
	}

	/**
	 * 새글등록
	 */
	public int insertBoard(BoardVO board) {
		                                            //파라미터
      return session.insert(namespace+"insertBoard" ,board);
	}

	/**
	 * 조회수 증가
	 */
	public int viewCnt(int boardNo) {
		
		return session.update(namespace+ "viewCnt" ,boardNo);

	}

	/**
	 * 게시글 상세 보기
	 */
	public BoardVO selectBoardByNo(int boardNo) {

		
		return session.selectOne(namespace+"selectBoardByNo" ,boardNo );
	}

	// 삭제
	public int deleteByNo(int boardNo) {
		
		
		return session.delete(namespace+ "deleteByNo",boardNo);

	}

	/**
	 * 게시물 수정 (제목, 작성, 내용)
	 */
	public int updateBoard(BoardVO board) {
		
		return session.update(namespace+ "updateBoard", board);
	}

	/**
	 * 페이징
	 */
	public int boardCnt() {
		
		return session.selectOne(namespace + "boardCnt");

	}

	/**
	 * 첨부파일 CRUD
	 */
	public int insertFile(BoardFileVO fileVO) {

		return session.insert(namespace+"insertFile" , fileVO);
	}

	public List<BoardFileVO> selectFileByNo(int boardNo) {

		return session.selectList(namespace+"selectFileByNo",boardNo);
	}
}

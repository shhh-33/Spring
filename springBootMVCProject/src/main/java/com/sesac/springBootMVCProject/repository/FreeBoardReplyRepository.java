package com.sesac.springBootMVCProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sesac.springBootMVCProject.vo.FreeBoard;
import com.sesac.springBootMVCProject.vo.FreeBoardReply;

public interface FreeBoardReplyRepository extends CrudRepository<FreeBoardReply, Long> {
    
	//1.규칙에 맞는 메서드를 정의  --쉬움
	public List<FreeBoardReply> findByBoard(FreeBoard board);

	//JPQL이용
	@Query("select r from FreeBoardReply r where r.board=?1 and r.rno >0 order by r.rno asc ")
	public List<FreeBoardReply> getRepliesOfBoard(FreeBoard board);
}

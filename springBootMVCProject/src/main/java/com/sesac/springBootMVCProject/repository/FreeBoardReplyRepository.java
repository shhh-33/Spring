package com.sesac.springBootMVCProject.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.sesac.springBootMVCProject.vo.FreeBoard;
import com.sesac.springBootMVCProject.vo.FreeBoardReply;
                                                    //페이징하려고 상속받음
public interface FreeBoardReplyRepository extends PagingAndSortingRepository<FreeBoardReply, Long> {
    
	//1.규칙에 맞는 메서드를 정의  --쉬움
	public List<FreeBoardReply> findByBoard(FreeBoard board);

	
	//JPQL이용 : 테이블이 아닌 엔티티 객체를 대상으로 검색 ,별칭 사용이 필수(=r) 
	@Query("select r from FreeBoardReply r where r.board=?1 and r.rno >0 order by r.rno asc ")
	public Page<FreeBoardReply> getRepliesOfBoard(FreeBoard board);
	
	//
	public Page<FreeBoardReply> findByReply(String writer,Pageable paging);
	
}

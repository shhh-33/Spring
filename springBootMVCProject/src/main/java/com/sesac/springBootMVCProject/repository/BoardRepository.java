package com.sesac.springBootMVCProject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sesac.springBootMVCProject.vo.BoardVO;
//인터페이스 설계
public interface BoardRepository extends CrudRepository<BoardVO, Long> {

	//CrudRepository 기본제공 : findAll() ,findById(),save(),delete(),count()
    //규칙에 맞는 메서드 추가한다.
	List<BoardVO> findByTitle(String title);
	List<BoardVO> findByWriter(String writer);
	List<BoardVO> findByContent(String content);
	List<BoardVO> findByTitleAndWriter(String title,String writer);
	List<BoardVO> findByBnoBetween(Long bno,Long bno2);
	
	List<BoardVO> findByContentLike(String content);
	List<BoardVO> findByContentContaining(String content);
	List<BoardVO> findByContentContainingAndBnoGreaterThan(String content,Long bno);
	
	long countByWriter(String writer);

	Iterable<BoardVO> findByContentStartingWith(String content);
	
	List<BoardVO> findByFirstnameLike(String writer);
}

package com.sesac.springBootMVCProject.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.sesac.springBootMVCProject.vo.BoardVO;
//인터페이스 설계  //extends CrudRepository<BoardVO, Long>
public interface BoardRepository extends PagingAndSortingRepository <BoardVO, Long> {

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
	List<BoardVO> findByContentContainingAndBnoGreaterThanOrderByBnoDesc(String content,Long bno);
	
	long countByWriter(String writer);

	Iterable<BoardVO> findByContentStartingWith(String content);
	
	//List<BoardVO> findByFirstnameLike(String writer);
	
	//paging 추가 
	//List<BoardVO> findByContentContainingAndBnoGreaterThanOrderByBnoDesc(String content,Long bno ,Pageable paging);
	
	//데이터 정보만 리턴
	List<BoardVO> findByContentContaining(String content,Pageable paging);
	
	//페이지와 데이터정보 리턴
	Page<BoardVO> findByBnoGreaterThan(Long bno, Pageable paging);
	
	//JPQL(JPA Query LAnguge) jpa가 자동으로 생성되는 함수로는 한계 ->JPQL이용해서 해결
	                                    //%?1% : 첫번째파라미터=title and ?2: bno
	@Query("select b from BoardVO b where b.title like %?1% and b.bno > ?2 order by b.bno desc")
	List<BoardVO> findByTitle2(String title , Long bno);
	
	//param을 이용
	@Query("select b from BoardVO b where b.title like %:title% and b.bno > :bno2 order by b.bno desc")
	List<BoardVO> findByTitle3(@Param("bno2")Long bno, @Param("title") String title);
	
	
	@Query("select b from #{#entityName} b where b.title like %:title% and b.bno > :bno2 order by b.bno desc")
	List<BoardVO> findByTitle4(@Param("bno2")Long bno, @Param("title") String title);
	
	

	
	@Query(value = "select * from tbl2_boards where title like %?2% and bno > ?1 order by bno desc", nativeQuery = true)
	   List<BoardVO> findByTitle5(Long bno, String title);
	   
	
	
}

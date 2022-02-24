package com.sesac.boot3.persistence;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sesac.boot3.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>,
      QuerydslPredicateExecutor<Board>
      {

	// JPA는 메소드의 이름만으로 원하는 쿼리를 실행한다.(쿼리=select만 해당)
	// find클래스명By칼럼명
	// 리턴값 : Collection<T>형태로 주로 list, page
	public List<Board> findBoardByTitle(String title);

	// Collection: 예쁘게 출력된다..
	public Collection<Board> findByWriter(String writer);

	// 작성자에 대한 like % 키워드 %
	public Collection<Board> findByWriterContaining(String writer);

	// OR조건의 처리
	// findBy + 'Title'Containing + Or + 'Content'Containing --title과 content로 찾겠다
	public Collection<Board> findByTitleContainingOrContentContaining(String title, String content);

	// title LIKE % ? % AND BNO > ?
	// GreaterThan or LessThan 사용
	// findBy + 'Title'Containing+ And+ 'Bno'GreaterThan
	// title에 특정문자 포함 bno가 특정 숫자 초과인 데이터 조회
	public Collection<Board> findByTitleContainingAndBnoGreaterThan(String keywoard, Long num);

	// bno > ? ORDER BY bno DESC
	// findBy + 'Bno'GreaterThan + OrderBy'Bno' + Desc or Asc
	public Collection<Board> findByBnoGreaterThanOrderByBnoDesc(Long bno);

	// bno > ? ORDER BY bno DESC limit ?, ?
	/*
	 * <Pageable> 페이징 처리에 필요한 정보 제공 import org.springframework.data.domain.Pageable;
	 * 리턴값 : List<>,or Page<>
	 */
	public List<Board> findByBnoGreaterThanOrderByBnoDesc(Long bno, Pageable paging);

	public Page<Board> findByBnoGreaterThan(Long bno, Pageable paging);

	// JPQL이용 -> JPA에서 사용하는 쿼리랭귀지..
	/*
	 * %?1% ? : JDBC의 PreparedStatement ?1 : 첫번째로 전달되는 파라미터
	 */
	@Query("SELECT b FROM Board b WHERE b.title like %?1% and b.bno > 0 ORDER BY b.bno desc")
	public List<Board> findByTitle(String title);

	
	@Query("select board.bno, board.title, board.writer, board.regdate "
			+ " from Board board where board.title like %?1% and board.bno > 0 order by board.bno desc")
	public List<Object[]> findByTitle2(String title);

	@Query("select board from Board board where board.bno > 0 order by board.bno desc")
	public List<Board> findBypage(Pageable pageable);

	//@Param("컬럼명")
	@Query("SELECT b from Board b WHERE b.content like %:content%  and b.bno > 0 order by b.bno desc")
	public List<Board> findByContent(@Param("content") String content);

}
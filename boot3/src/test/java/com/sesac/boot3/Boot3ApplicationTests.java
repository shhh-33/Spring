package com.sesac.boot3;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.sesac.boot3.domain.Board;
import com.sesac.boot3.persistence.BoardRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
class Boot3ApplicationTests {
	
	@Autowired
	private BoardRepository repo;

	//@Test
	public void testInsert30() {

		for (int i = 1; i <= 30; i++) {

			Board board = new Board();
			board.setTitle("오늘뭐먹지" + i);
			board.setContent("잘 모르겠네" + i + "흠 ");
			board.setWriter("소크라테스" + (i % 10));
			repo.save(board);

		}

	}
	
	/*
	 * <출력>
	 * Board(bno=201, title=오늘뭐먹지1, writer=소크라테스1, content=잘 모르겠네1흠 , regdate=2022-02-24 09:35:10.996, updatedate=2022-02-24 09:35:10.996)
	 */

	//@Test
	public void testByTitle() {

		repo.findBoardByTitle("오늘뭐먹지1").forEach(board -> System.out.println(board));

	}
	
	/*
	 * Board(bno=201, title=오늘뭐먹지1, writer=소크라테스1, content=잘 모르겠네1흠 ,~)
       Board(bno=211, title=오늘뭐먹지11, writer=소크라테스1 ,~)
	 */
	
	//@Test
	public void testByWriter() {

		//특정한 칼럼의값을 조회 
		Collection<Board> results = repo.findByWriter("소크라테스1");

		results.forEach(board -> System.out.println(board));
	}


	/*
	 * Writer에 1들어간거 다 출력
	 */
	
	//@Test
	public void testByWriterContaining() {

		Collection<Board> results = repo.findByWriterContaining("1");

		results.forEach(board -> System.out.println(board));
	}

	
	//@Test
	public void testByTitleAndBno() {
         //제목에 5 포함, 게시물 번호 220보다 큰거 조회
		Collection<Board> results = repo.findByTitleContainingAndBnoGreaterThan("5", 220L);

		results.forEach(board -> System.out.println(board));

	}
	
	//@Test
	public void testBnoOrderBy() {
        //220보다 큰 데이터 정렬  : 230,229 ~~
		Collection<Board> results = repo.findByBnoGreaterThanOrderByBnoDesc(220L);
		results.forEach(board -> System.out.println(board));

	}

	//@Test
	public void testBnoOrderByPaging() {
		
		//첫번째 페이지부터 10건의 데이터 가져옴 (인덱스 번호는 0부터 시작)
		//230~221 출력
		Pageable paging = PageRequest.of(0, 10);

		Collection<Board> results = repo.findByBnoGreaterThanOrderByBnoDesc(0L, paging);
		results.forEach(board -> System.out.println(board));

	}
	
	/*
	 *
       PAGE SIZE: 10
       TOTAL PAGES: 3
       TOTAL COUNT: 30
       NEXT: Page request [number: 1, size 10, sort: bno: ASC]
       201~210번 출력
	 */
	@Test
	public void testBnoPagingSort() {

		Pageable paging = PageRequest.of(0, 10, Sort.Direction.ASC, "bno");

		Page<Board> result = repo.findByBnoGreaterThan(0L, paging);
		
		System.out.println("PAGE SIZE: " + result.getSize());
		System.out.println("TOTAL PAGES: " + result.getTotalPages());
		System.out.println("TOTAL COUNT: " + result.getTotalElements());
		System.out.println("NEXT: " + result.nextPageable());
		
		List<Board> list = result.getContent();
		
		list.forEach(board -> System.out.println(board));
		
	}
   
	//제목에 17들어간거 그냥 출력
	@Test
	public void testByTitle2() {

		repo.findByTitle("17").forEach(board -> System.out.println(board));

	}
	
	//배열로 출력
	//@Test
	public void testByTitle17() {

		repo.findByTitle2("17").forEach(arr -> System.out.println(Arrays.toString(arr)));

	}

	
	
	
	
	
	

}

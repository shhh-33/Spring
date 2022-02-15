package com.sesac.springBootMVCProject;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sesac.springBootMVCProject.repository.BoardRepository;
import com.sesac.springBootMVCProject.vo.BoardVO;

@SpringBootTest
public class BoardTest {

	@Autowired
	BoardRepository bRepo;

	@Test
	public void findByFirstnameLike() {
		String writer = "제갈";
		bRepo.findByFirstnameLike(writer).forEach(board -> {
			System.out.println(board);
		});

	}

	// @Test
	public void test22() {

		String content = "화려한";
		Iterable<BoardVO> blist = bRepo.findByContentStartingWith(content);
		List<BoardVO> blist2 = (List<BoardVO>) blist;

		if (blist2.size() == 0) {
			System.out.println("없음");

		} else {
			for (BoardVO b : blist2) {
				System.out.println(b);
			}
		}

	}

	// @Test
	public void findByContentContainingAndBnoGreaterThan() {
		List<BoardVO> blist = bRepo.findByContentContainingAndBnoGreaterThan("SpringBoot 8", 50L);
		for (BoardVO board : blist) {
			System.out.println(board);
		}
	}

	// @Test
	public void countByWriter() {

		String writer = "제갈남궁7";
		long count = bRepo.countByWriter(writer);
		System.out.println(count);

	}

	// @Test
	public void findByContentContaining() {

		List<BoardVO> blist = bRepo.findByContentContaining("너무");
		for (BoardVO board : blist) {
			System.out.println(board);
		}

	}

	// @Test
	public void findByContentLike() {

		List<BoardVO> blist = bRepo.findByContentLike("%너무멋져%");
		for (BoardVO board : blist) {
			System.out.println(board);
		}

	}

	// @Test
	public void findByBnoBetween() {
		List<BoardVO> blist = bRepo.findByBnoBetween(10L, 15L);

		for (BoardVO board : blist) {
			System.out.println(board);
		}
	}

	// @Test
	public void findByTitleAndWriter() {
		String title = "완전좋다";
		String writer = "제갈남궁1";
		bRepo.findByTitleAndWriter(title, writer).forEach(board -> {

			System.out.println(board);
		});

	}

	// @Test
	public void findByContentTest() {
		String content = "빛이 나를 감싸는 SpringBoot 6";
		bRepo.findByTitle(content).forEach(board -> {
			System.out.println(board);
		});
	}

	// @Test
	public void findByWriterTest() {
		String writer = "제갈남궁1";
		bRepo.findByTitle(writer).forEach(board -> {
			System.out.println(board);
		});
	}

	// @Test
	public void findByTitleTest() {
		String title = "화려한12";
		bRepo.findByTitle(title).forEach(board -> {
			System.out.println(board);
		});
	}

	// @Test
	public void boardCount() {
		long cnt = bRepo.count();
		System.out.println("전체건수" + cnt);
	}

	// @Test
	public void boardDelete() {
		Long bno = 11L; // 11번 지움
		bRepo.deleteById(bno);
	}

	// @Test
	public void boardUpdate() {
		Long bno = 10L;
		bRepo.findById(bno).ifPresent(board -> {
			board.setTitle("수정");
			board.setWriter("작성자");
			board.setContent("드르렁");
			bRepo.save(board); // update set
		});

	}

	// @Test
	public void test3() {
		int i = 10;
		Long bno = 1078L; // long..은 L
		bRepo.findById(bno).ifPresent(board -> {
			System.out.println(board);
		});

		System.out.println("=================");

		bRepo.findById(bno).ifPresentOrElse(board -> {
			System.out.println("찾음" + board);

		}, () -> {
			System.out.println(bno + "없음");
		});
	}

	// @Test
	public void test2() {
		bRepo.findAll().forEach(board -> {
			System.out.println(board);

		});
	}

	// @Test
	public void test1() {
		IntStream.rangeClosed(1, 100).forEach(i -> {
			BoardVO board = BoardVO.builder().title("화려한" + i).writer("제갈남궁" + i % 10)
					.content("빛이 나를 감싸는 SpringBoot " + i % 10).build();
			bRepo.save(board);
		});
	}

}
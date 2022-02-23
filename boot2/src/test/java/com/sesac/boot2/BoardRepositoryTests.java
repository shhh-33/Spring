package com.sesac.boot2;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sesac.boot2.domain.Board;
import com.sesac.boot2.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest // 이것만 쓰면 application context 전부 로딩해서 무거워진다. 위에거 쓰는 이유
public class BoardRepositoryTests {

	@Autowired
	private BoardRepository boardRepo; // CrudRepository 상속받으려고

	/*
	 * 만들어진 클래스 정보 조사 <출력> com.sun.proxy.$Proxy107
	 * com.sesac.boot2.persistence.BoardRepository
	 * org.springframework.data.repository.Repository
	 * org.springframework.transaction.interceptor.TransactionalProxy
	 * org.springframework.aop.framework.Advised
	 * org.springframework.core.DecoratingProxy
	 */
	// @Test
	public void inspect() {

		Class<?> clz = boardRepo.getClass();

		System.out.println(clz.getName());

		Class<?>[] interfaces = clz.getInterfaces();

		Stream.of(interfaces).forEach(inter -> System.out.println(inter.getName()));

		Class<?> superClasses = clz.getSuperclass();

		System.out.println(superClasses.getName());
	}

	/*
	 * 등록 CrudRepository에서 save()라는 메소드 이용
	 */
	// @Test
	public void testInsert() {

		Board board = new Board();
		board.setTitle("2월23일");
		board.setContent("11시..졸려");
		board.setWriter("졸린사람");

		boardRepo.save(board);

	}

	/*
	 * 조회 findByID 이용 Hibernate: select board0_.bno as bno1_0_0_, board0_.content as
	 * content2_0_0_, board0_.regdate as regdate3_0_0_, board0_.title as
	 * title4_0_0_, board0_.updatedate as updatedate5_0_0_, board0_.writer as
	 * writer6_0_0_ from tbl_boards board0_ where board0_.bno=? Hibernate: select
	 * hibernate_sequence.nextval from dual
	 */

	// @Test
	public void testRead() {

		// Board board = boardRepo.findOne(1L);

		// System.out.println(board);

		boardRepo.findById(1L).ifPresent((board) -> {
			System.out.println(board);
		});

	}

	
	// @Test
	public void testUpdate() {

		System.out.println("수정 전 제목~_~");
		Board board = boardRepo.findById(561L).get(); // 기본키 번호 ==bno

		System.out.println("수정 후 제목~_~");
		board.setTitle("안졸린데?");

		System.out.println("저장해줄게~");
		boardRepo.save(board);

	}

	@Test
	public void testDelete() {
		System.out.println("삭제");
		boardRepo.deleteById(561L);
}
}
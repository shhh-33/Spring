package com.sesac.springBootMVCProject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.sesac.springBootMVCProject.repository.PDSBoardRepository;
import com.sesac.springBootMVCProject.vo.PDSBoard;
import com.sesac.springBootMVCProject.vo.PDSFile;

import lombok.extern.java.Log;

@Commit
@SpringBootTest
@Log
public class PDSBoardFileTest {

	@Autowired
	PDSBoardRepository boardRepo;
	@Autowired
	PDSBoardRepository fileRepo;

	@Test
	public void test6() {
		log.info("one은 수정하고 many는 추가");

		boardRepo.findById(145L).ifPresentOrElse(b -> {
		 System.out.println(b);
		 System.out.println(b.getFiles2().size()+"건");
		 System.out.println("---수정---");
		 b.setPname("바꾼다..바꾸자...이름을");
		 b.setPwriter("제갈명수");
		 b.getFiles2().add(PDSFile.builder().pdsfilename("첨부파일1.png").build());
		 boardRepo.save(b);
		}, () -> {
			System.out.println("해당board는 존재하지 않는다.");
		});
	}

	@Test
	@Transactional
	public void test5() {
		boardRepo.updatePDSFile(123L, "바뀌어줘라.jpg");

	}

	// @Test
	public void test4() {
		log.info("---onetwomany연습 : 삭제-----");
		fileRepo.deleteById(135L);

	}

	// @Test //아이디당 파일이 몇개씩 있는지 출력
	public void test3() {
		log.info("===============OneToMany 연습: Eager============");
		boardRepo.findAll().forEach(b -> {
			//System.out.println(b.getPid() + "==>" + b.getFiles2().size());
			System.out.println(b +"->"+b.getFiles2().size());
		});
	}

	// @Test
	public void test2() {
		log.info("---onetwomany연습 : Eager------");
		boardRepo.findAll().forEach(b -> {
			System.out.println(b.getPid() + "-->" + b.getFiles2().size());
		});
	}

	// @Test
	public void test1() {
		log.info("---onetwomany연습------");
		IntStream.rangeClosed(1, 10).forEach(i -> {

			List<PDSFile> fileList = new ArrayList<>();
			IntStream.rangeClosed(100, 105).forEach(j -> {
				fileList.add(PDSFile.builder().pdsfilename("파일" + i + "-" + j + "jpg").build());
			});

			PDSBoard board = PDSBoard.builder().pname("어쩌고" + i).pwriter("명수" + i % 2).files2(fileList).build();
			boardRepo.save(board);
		});
	}

}

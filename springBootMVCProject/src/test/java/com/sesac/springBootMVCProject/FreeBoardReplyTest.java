package com.sesac.springBootMVCProject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.sesac.springBootMVCProject.repository.FreeBoardReplyRepository;
import com.sesac.springBootMVCProject.repository.FreeBoardRepository;
import com.sesac.springBootMVCProject.vo.FreeBoard;
import com.sesac.springBootMVCProject.vo.FreeBoardReply;

@SpringBootTest
public class FreeBoardReplyTest {

   @Autowired
   FreeBoardRepository boardRepo;
   @Autowired
   FreeBoardReplyRepository replyRepo;

   
   @Test
   public void test9() {
	   boardRepo.findAll().forEach(b->{
		   System.out.println(b);
	   });
   }
   
   
   
   //@Test
   public void test8() {
	   Pageable paging =PageRequest.of(0, 5, Sort.by("bno").descending());
	   Page<FreeBoard> result= boardRepo.findByWriter("독고명수",paging);
	   System.out.println("size"+result.getSize());
	   System.out.println("TotalElements" +result.getTotalElements());
	   System.out.println("TotalPages" + result.getTotalPages());
	   System.out.println("next page : " +result.nextPageable());
	   List<FreeBoard> blist =result.getContent();
	   blist.forEach(b->{System.out.println(b);});
   //next page : INSTANCE 다음페이지 없어서 이렇게 뜨는거 
   }
   
   
   
   
   //@Test//건수 가져오기
   public void test7() {
      //Board정보와 댓글의 건수를 가져오기
      FreeBoard board = boardRepo.findById(221L).get();
      System.out.println(board);
      System.out.println("댓글의 개수 : " + board.getReplies().size() +"개");
      board.getReplies().forEach(reply->{
         System.out.println(reply);
      });
      
   }
   //@Test
   public void test6() {
	   FreeBoard board =boardRepo.findById(221L).get();
	   replyRepo.findByBoard(board).forEach(b->{
		   System.out.println(b.getBoard().getWriter()+" 작성자의 댓글->"+b);
		   
	   });
	   
   }
   
   
   //@Test
   public void test5() {
	   //FreeBoardReply에 삽입 (insert)
	   FreeBoard board =boardRepo.findById(221L).get();
	   FreeBoardReply reply =FreeBoardReply.builder()
			                 .board(board)
			                 .reply("말벌아저씨는 바로 나")
			                 .replyer("윤선")
			                 .build();
	   replyRepo.save(reply);
   }
   
   
  // @Test
   public void test4() {
	   
	   boardRepo.findByTitleContaining("화나게").forEach(b->{
		   System.out.println(b);
	   });
	   
   }
   //@Test
   public void test3() {
	   
	   boardRepo.findAll().forEach(b->{
		   System.out.println(b);
	   });
	   
   }
   
   
   
   //@Test
   public void test2() {
	   //board만 추가
	   IntStream.rangeClosed(1, 5).forEach(i->{
		  
		   FreeBoard board = FreeBoard.builder()
	               .title("화나게 하지마!!!"+i)
	               .writer("독고명수")
	               .content("장난치지마"+i)
	               .build();
		   
		   boardRepo.save(board);
		   
	   });
   }
   
   
   
   
   
   //@Test
   public void test1() {
      System.out.println("---------board추가-------reply도 추가-------------------");
      
      IntStream.rangeClosed(1, 5).forEach(i->{
      
         FreeBoard board = FreeBoard.builder()
               .title("화나게 하지마!!!"+i)
               .writer("선")
               .content("장난치지마"+i)
               .build();
         
         List<FreeBoardReply> replies = new ArrayList<>();
         
      for(int j=1; j<=3; j++) {
         replies.add(FreeBoardReply.builder()
               .reply("왜 이렇게 힘들어")
               .replyer("YOUN" + j)
               .board(board)
               .build());         
      }
      board.setReplies(replies);
      boardRepo.save(board);
      });
   }

}
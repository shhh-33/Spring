package com.sesac.springBootMVCProject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
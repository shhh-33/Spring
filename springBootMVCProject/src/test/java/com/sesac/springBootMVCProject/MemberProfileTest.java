package com.sesac.springBootMVCProject;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sesac.springBootMVCProject.repository.MemberRepository;
import com.sesac.springBootMVCProject.repository.ProfileRepository;

import com.sesac.springBootMVCProject.vo.MemberRole;
import com.sesac.springBootMVCProject.vo.MemberVO;
import com.sesac.springBootMVCProject.vo.ProfileDTO;

import lombok.extern.java.Log;

@SpringBootTest
@Log
public class MemberProfileTest {

	@Autowired
	MemberRepository mRepo;
	
	@Autowired
	ProfileRepository pRepo;
	


	   @Test
	   public void test6() {
	      List<Object[]> mylist = mRepo.getProfileCountByMember2();
	      mylist.forEach(row->{
	         //row는 object 배열 
	         System.out.println(Arrays.toString(row));
	         System.out.println("==================");
	         System.out.println(row[0] + "--->" + row[1]);
	      });
	      
	   }
	//@Test
	public void test5() {
	
		MemberVO member =mRepo.findById("aaa2").get();
		List<ProfileDTO> plist =pRepo.findByMember(member);
		plist.forEach(p->{
			//System.out.println(p);
			log.info(p.toString());
		});
	}
	
	
	//@Test
	public void test4() {
		//특정멤버조회
		System.out.println("===특정멤버조회==============");
		MemberVO member =mRepo.findById("aaa2").get();
		System.out.println(member);
		//특정프로파일 조회..멤버정보가 온다.
		System.out.println("===특정프로파일조회==============");
		ProfileDTO profile= pRepo.findById(113L).get();
		System.out.println(profile);
		System.out.println("프로파일의 멤버정보만 보기 :" + profile.getMember());
		
	}
	//@Test
	public void test3() {
		//MemberVO member =mRepo.findById("aaa1").orElseThrow();
		MemberVO member =mRepo.findById("aaa2").get();
		IntStream.rangeClosed(1,3).forEach(i->{
			ProfileDTO profile =ProfileDTO.builder()
					            .fname("2번사람거" +i)
					            .currentYn(i==3?true:false)
					            .member(member)
					            .build();
			System.out.println(profile);
			pRepo.save(profile);
		});
	}
	
	
	//@Test
	public void test2() {
		
		IntStream.rangeClosed(1,5).forEach(i->{
			MemberVO member = MemberVO.builder() //builder써서 직관적으로 표현
					         .mid("aaa" +i)
					         .mname("내이름"+i)
					         .mpassword("1234")
					         .mrole(i%2==0?MemberRole.Manager:MemberRole.User)
					         .build();
			mRepo.save(member);
		});
	
		
		
	}
	
	//@Test
	public void test1() {
		MemberVO m1 = MemberVO.builder().mid("국밥대장").mname("아오1").build();
		MemberVO m2 = MemberVO.builder().mid("국밥대장").mname("아오2").build();
		
		System.out.println(m1==m2); //주소비교
		System.out.println(m1.equals(m2));
	}
}

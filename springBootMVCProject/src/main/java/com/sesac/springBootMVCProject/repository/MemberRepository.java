package com.sesac.springBootMVCProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sesac.springBootMVCProject.vo.MemberVO;

public interface MemberRepository extends CrudRepository<MemberVO, String> {

	//member를 통해서 profile의 건수를 조회하기
	
	//JPQL을 이용한다. JPA Query Language
	   @Query(value = "select m.mid, count(p.fname) from tbl2_members m left outer join tbl2_profile p"
	         + " on m.mid = p.member_mid "
	         + " group by m.mid ", nativeQuery = true)
	   public List<Object[]> getProfileCountByMember();
	   //select 하고 from 사이에 column이 가변으로 온다. 그럴 때는 object[] 을 넣는다

	   
	   @Query(value = "select m.mid, count(p.fname) from MemberVO m left outer join ProfileDTO p"
	         + " on m.mid = p.member "
	         + " group by m.mid ") //profileDTO에 있는 변수 이름이 member_mid 가 아니고 member 다.
	   public List<Object[]> getProfileCountByMember2();
	
	
}

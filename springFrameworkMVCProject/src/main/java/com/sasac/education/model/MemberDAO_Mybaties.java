package com.sasac.education.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.sasac.vo.MemberVO;

@Repository  //@Component + DB사용
public class MemberDAO_Mybaties {
	
	
	@Autowired
	SqlSession session;
	
	String namespace = "com.sesac.member.";
	public List<MemberVO> selectAll(){
		 return session.selectList(namespace+"selectAll");
	}
	public MemberVO selectById(String id){
		 return session.selectOne(namespace+"selectById", id);
	}
	public int insertMember(MemberVO member){
		 return session.insert(namespace+"insert", member);
	}
	public int updateMember(MemberVO member){
		 return session.update(namespace+"update", member);
	}
	public int deleteMember(String id){
		 return session.delete(namespace+"delete", id);
	}
	
}










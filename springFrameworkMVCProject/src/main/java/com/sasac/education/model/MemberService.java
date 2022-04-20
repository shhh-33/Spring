package com.sasac.education.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sasac.vo.MemberVO;

@Service
public class MemberService {
	
	@Autowired
	MemberDAO_Mybaties mdao;
	
	public List<MemberVO> selectAll(){
		 return mdao.selectAll();
	}
	public MemberVO selectById(String id){
		 return mdao.selectById(id);
	}
	public int insertMember(MemberVO member){
		 return mdao.insertMember(member);
	}
	public int updateMember(MemberVO member){
		 return mdao.updateMember(member);
	}
	public int deleteMember(String id){
		 return mdao.deleteMember(id);
	}
}

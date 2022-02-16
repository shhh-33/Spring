package com.sesac.springBootMVCProject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sesac.springBootMVCProject.vo.MemberVO;
import com.sesac.springBootMVCProject.vo.ProfileDTO;

public interface ProfileRepository extends CrudRepository<ProfileDTO, Long> {

	//기본 crud작업 : findAll(), findById(), save(), count(), deleteByID()
	//규칙에 맞게 메서드 추가가능
	
	List<ProfileDTO> findByMember(MemberVO mem);
}

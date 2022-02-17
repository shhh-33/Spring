package com.sesac.springBootMVCProject.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sesac.springBootMVCProject.vo.FreeBoard;

// CrudRepository :  . findAll() 만 제공 
//PagingAndSortingRepository : 위에거 + findAll(Pagable paging)  --> 페이징도 하고 싶어서 씀
public interface FreeBoardRepository extends PagingAndSortingRepository<FreeBoard, Long> {

	
	List<FreeBoard> findByTitleContaining(String title); //타이틀로 찾기
	
	
	//특정 작성자가 작성한 board정보를 페이지 정보와 함께 리턴하기 
	//List-> 다음페이지 및 여러가지 페이지에 대한 내용을 가져올 수 없다.
	Page<FreeBoard> findByWriter(String writer,Pageable paging);
	
}

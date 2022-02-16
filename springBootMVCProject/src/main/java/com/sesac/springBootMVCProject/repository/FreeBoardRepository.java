package com.sesac.springBootMVCProject.repository;

import org.springframework.data.repository.CrudRepository;

import com.sesac.springBootMVCProject.vo.FreeBoard;


public interface FreeBoardRepository extends CrudRepository<FreeBoard, Long> {

}

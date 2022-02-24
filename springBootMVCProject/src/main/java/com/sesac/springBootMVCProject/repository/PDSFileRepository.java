package com.sesac.springBootMVCProject.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sesac.springBootMVCProject.vo.PDSFile;



public interface PDSFileRepository extends CrudRepository<PDSFile, Long> {
	
	
}

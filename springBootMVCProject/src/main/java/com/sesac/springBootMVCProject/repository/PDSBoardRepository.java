package com.sesac.springBootMVCProject.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sesac.springBootMVCProject.vo.PDSBoard;

public interface PDSBoardRepository extends CrudRepository<PDSBoard, Long> {

	@Modifying
    @Query("update from PDSFile f set f.pdsfilename =?2 where f.fno = ?1")
	int updatePDSFile(Long fno, String newFileName);
}

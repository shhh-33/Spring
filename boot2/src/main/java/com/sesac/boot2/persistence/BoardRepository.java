package com.sesac.boot2.persistence;

import org.springframework.data.repository.CrudRepository;

import com.sesac.boot2.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {

}
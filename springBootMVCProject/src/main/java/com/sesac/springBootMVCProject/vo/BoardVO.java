package com.sesac.springBootMVCProject.vo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//엔티티설계
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tbl2_boards")
@Entity
public class BoardVO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long bno;
    @NotNull //java에서 객체생성시 필수이다.
    @Column(nullable = false) //db에서 not null컬럼으로 설정 
	private String title;
	private String writer;
	@Column(length =100)
	private String content;
	@CreationTimestamp //생성시 입력됨
	private Timestamp regdate;
	@UpdateTimestamp //생성시 입력되고 수정시 수정됨 
	private Timestamp updatedate;
	
	//db에 저장됐음
}







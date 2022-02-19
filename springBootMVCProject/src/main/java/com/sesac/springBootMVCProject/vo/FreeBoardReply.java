package com.sesac.springBootMVCProject.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "board") //양방향일때 무한loop주의 
@EqualsAndHashCode(of="rno") //참조할때
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbl_free_replies")
public class FreeBoardReply implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//oracle:sequence, mysql:identity
	Long rno; //댓글번호
	String reply; //댓글내용
	String replyer; //작성자
	@CreationTimestamp
	Timestamp regdate; //등록일
	@UpdateTimestamp
	Timestamp updatedate; //수정일 
	
	@JsonIgnore
	@ManyToOne //댓글여러개는 한개의 board와 연관관계
	FreeBoard board;  //board_bno칼럼이 생성 
	
	
}

package com.sesac.springBootMVCProject.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//DTO =vo==entity 데이터를 전송하는 목적이야.. db에 테이블 만드는중
@Getter@Setter@ToString
@Builder //new 안하고 다양하게 객체 내용 바꿀 수 있다
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name="tbl2_profile")
public class ProfileDTO {
	
	@Id //기본키
	@GeneratedValue(strategy =GenerationType.AUTO)
	Long fno;
	String fname;
	boolean currentYn; //대문자 하면 알아서 db에 _ 생김
	
	//profile 여러개가 하나의 Member 소유이다.
	@ManyToOne
	MemberVO member; //칼럼이름은 member_mid
	

}

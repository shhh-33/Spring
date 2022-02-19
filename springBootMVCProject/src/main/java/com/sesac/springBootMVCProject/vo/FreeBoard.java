package com.sesac.springBootMVCProject.vo;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;



//boardVO
@Getter
@Setter
@ToString(exclude = "replies") //제외할거야
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_freeboards")
@EqualsAndHashCode(of = "bno") //equals :  두 객체의 내용이 같은지, 동등성(equality) 를 비교하는 연산자, hashCode : 두 객체가 같은 객체인지, 동일성(identity) 를 비교하는 연산자
public class FreeBoard  {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)//oracle:sequence, mysql:identity
	private Long bno;
    @NonNull
    @Column(nullable = false)  
	private String title;
	private String writer;
	@Column(length = 100)
	private String content;	
	@CreationTimestamp
	private Timestamp regdate;
	@UpdateTimestamp
	private Timestamp updatedate;	
	
	
	@BatchSize(size=100) //성능좋아져
	
	//1:N 일대다 (1이 주인 N에 외래키)
	/*
	 * EAGER : 연관 관계에 있는 Entity 들 모두 가져온다 select 한번에 (board를 가져올 때 replies도 가져옴)
	 * LAZY : 엔티티 사용할때만 해당 엔티티 조회-getter 로 접근할 때 가져온다 (board만 가져올때)
	 * 
	 */
	@OneToMany(mappedBy = "board", 
			  cascade = CascadeType.ALL  , fetch = FetchType.EAGER )  
	List<FreeBoardReply> replies;
	
	
	
}

package com.sesac.springBootMVCProject.vo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder //new 안하고 다양하게 객체 내용 바꿀 수 있다
@NoArgsConstructor @AllArgsConstructor
@Getter 
@Setter
@ToString(exclude="files2")
@Entity @Table(name="tbl_pdsboard") @EqualsAndHashCode(of="pid")
public class PDSBoard {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long pid;
private String pname;
private String pwriter;

@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER) //같이조회될것
@JoinColumn(name="pdsno")  //PDSFile칼럼에 생성 
private List<PDSFile> files2;
}

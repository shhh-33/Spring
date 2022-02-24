package com.sesac.springBootMVCProject.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor

@ToString


@Data
@Builder
@AllArgsConstructor
public class CarVO {

	@NonNull
	String model;
	int price;
	
	
	
}

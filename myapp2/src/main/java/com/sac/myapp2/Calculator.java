package com.sac.myapp2;

import org.springframework.stereotype.Component;

//Core Concern : 핵심로직, 주관심사, 비지니스로직 

@Component
public class Calculator {

	public void add() {
		System.out.println("arg0개 add결과:" );
	}
	public void add(int x ) {
		 
		System.out.println("arg1개 add결과:" + x);
	}
	
	public void add(int x, int y) {
		int result = x+y;
		System.out.println("arg2개 add결과:" + result);
	}
	public void subtract(int x, int y) {
		int result = x-y;
		System.out.println("arg2개 subtract결과:" + result);
	}
	public void multiply(int x, int y) {
		int result = x*y;
		System.out.println("arg2개 multiply결과:" + result);
	}
	public void divide(int x, int y) {
		 
		int result = x/y;
		System.out.println("arg2개 divide결과:" + result);
		
	}
}

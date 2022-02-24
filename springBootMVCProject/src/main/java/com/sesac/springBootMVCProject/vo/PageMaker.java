package com.sesac.springBootMVCProject.vo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.java.Log;

@Getter
@ToString(exclude = "pageList") //pageList를 toString결과에서 제외시킴
@Log
public class PageMaker<T> {

	private Page<T> result; //Page<T> : 화면에 출력할 결과 생성자로 전달받는다.
	
	private Pageable prevPage; // 이전으로 이동하는데 필요한 정보를 가짐
	private Pageable nextPage; //다음
	private Pageable currentPage; //현재
	private int currentPageNum; // 화면에 보이는 1부터 시작하는 페이지번호
	private int totalPageNum; //실제로 사용되는 페이지 수
	
	private List<Pageable> pageList;  

	public PageMaker(Page<T> result) {
                                      //get : 내장기능
		this.result = result;  //모든 결과 여기에 넣음
		this.currentPage = result.getPageable();
		this.currentPageNum = currentPage.getPageNumber() + 1; //0부터 시작하니까 +1
		this.totalPageNum = result.getTotalPages();  
		this.pageList = new ArrayList<Pageable>();
		calcPage();  //밑에 함수 호출
	}
    
	//페이징 계산
	public void calcPage() {
		int cnt = 20; // pagelist의 갯수를 default로 20개로 잡음
		int tempEndNum = (int) (Math.ceil(currentPageNum / (cnt * 1.0)) * cnt); // 20개중 마지막숫자
		int startNum = tempEndNum - (cnt - 1); // -(19)
		Pageable startPage = this.currentPage;
		
		
		for (int i = startNum; i < this.currentPageNum; i++) {
			startPage = startPage.previousOrFirst(); // 20페이지라면 1페이지….40페이지라면
		}
		
		//이전페이지
		this.prevPage = startPage.getPageNumber() <= 0 ? null : startPage.previousOrFirst();
		
		log.info("tempEndNum:" + tempEndNum);
		log.info("totalPageNum:" + totalPageNum);
		
		if (this.totalPageNum < tempEndNum) {
			tempEndNum = this.totalPageNum;
			this.nextPage = null;
		}

		for (int i = startNum; i <= tempEndNum; i++) {
			pageList.add(startPage);
			startPage = startPage.next();
		}
		
		this.nextPage = startPage.getPageNumber() + 1 < totalPageNum ? startPage : null;
	}
}

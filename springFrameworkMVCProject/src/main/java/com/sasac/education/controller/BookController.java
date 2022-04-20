package com.sasac.education.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import kr.co.sasac.vo.BookVO;

@Controller
@RequestMapping("/book")

public class BookController {

	List<BookVO> blist = new ArrayList<>();

	public BookController() {
		// TODO Auto-generated constructor stub List<BookVO> blist = new ArrayList<>();
		blist.add(new BookVO(1, "a", "작가는", "출판사", "2022-0208"));
		blist.add(new BookVO(2, "a2", "작가는", "출판사", "2022-0208"));
		blist.add(new BookVO(3, "a3", "작가는", "출판사", "2022-0208"));
		blist.add(new BookVO(4, "a4", "작가는", "출판사", "2022-0208"));
		blist.add(new BookVO(5, "a5", "작가는", "출판사", "2022-0208"));

	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String bookInsert() {
		return "book/bookInsertForm";
	}

	// @RequestParam : int bookNo = Integer.parseInt(request.getParamter("bno"))
	// @RequestParam은 변수이름과 파라미터 이름이 값다면 생략한다.

	// @ModelAttribute("book") : 파라미터로 받은 값을 View값을 전달하기
	// ==model.addAttribute("book2", book3);
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String bookInsertPost(
			// @RequestParam("가져올 데이터의 이름") [데이터타입] [가져온데이터를 담을 변수]
			// bookNo라는 이름을 쓰고 싶을 때, RequestParam으로 작성 가능
			@RequestParam("bno") int bookNo,

			String title, String author, String pub, String pubDate, int status, @ModelAttribute("book") BookVO book, // 전달의
																														// 목적
																														// 거기서
																														// 쓰이는게
																														// book
			BookVO book3, Model model, RedirectAttributes redirctAttr) {

		/*
		 * System.out.println("bno: " + bookNo); System.out.println("title: " + title);
		 * System.out.println("author: " + author); System.out.println("pub: " + pub);
		 * System.out.println("pubDate: " + pubDate); System.out.println("status: " +
		 * status); System.out.println("BookVO받기: " + book);
		 */
		// System.out.println(book);
		// System.out.println(book3);
		model.addAttribute("myname", "아");
		model.addAttribute("book2", book3); // book2라는 이름으로 book3등록
		blist.add(book3);

		redirctAttr.addFlashAttribute("message", "입력성공");
		// return "book/bookResult";
		return "redirect:/book/list"; // 신규책등록후 다시 돌아감

	}

	/*
	 * 한꺼번에 묶어서 하기
	 * 
	 * @RequestMapping(value ="/insert",method = RequestMethod.POST) public String
	 * bookInsertPost(BookVO book) {
	 * 
	 * System.out.println(book); return "book/bookResult";
	 * 
	 * }
	 */
	
	/*
	 * //하나의 컨트롤러에서 exception 처리
	 * 
	 * @ExceptionHandler(Exception.class) public String processException(Exception
	 * ex) { ex.printStackTrace(); System.out.println("오류 : "+ex.getMessage());
	 * return "error/errorPage500";
	 * 
	 * }
	 */
	
	
	
	
	
	
	
	
	@RequestMapping("/list")
	public String booklist(Model model, HttpServletRequest request) {
		
		//연산오류나게
		//int a =10/0;
		//System.out.println(a);
		
		Map<String, ?>flashMap = RequestContextUtils.getInputFlashMap(request);

		
		if(flashMap!=null) {
			String msg = (String)flashMap.get("message");
			System.out.println(msg);
			model.addAttribute("message",msg);
		}
		model.addAttribute("booklist", blist);

		return "book/booklist";

	}

	@RequestMapping("/detail")
	public String bookDetail(int bno, Model model) {

		// List에서 bno 찾는다.
		BookVO book = null;
		for (BookVO b : blist) {
			if (b.getBno() == bno) {
				book = b;
				break;
			}

		}
		// 정보를 model에 저장한다.
		model.addAttribute("book", book);
		// detail페이지에 forward한다.
		return "book/detail";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(BookVO book, RedirectAttributes redirctAttr) {
		System.out.println("수정된 book" + book);
		for (BookVO b : blist) {
			if (b.getBno() == book.getBno()) {
				b.setAuthor(book.getAuthor());
				b.setPub(book.getPub());
				b.setPubDate(book.getPubDate());
				b.setStatus(book.getStatus());
				b.setTitle(book.getTitle());
				break;
			}
		}
		// 매개변수 Model model 있을땐 ..
		// model.addAttribute("message", "수정성공");
		redirctAttr.addFlashAttribute("message", "입력성공");
		return "redirect:/book/list"; // 새로운 요청

	}
	
	
	@RequestMapping(value = "/delete")
	public String delete(int bno, RedirectAttributes redirctAttr) {
	
		for (BookVO b : blist) {
			if (b.getBno() == bno) {
				blist.remove(b);
				break;
			}
		}
		
		
		redirctAttr.addFlashAttribute("message", "삭제성공");
		return "redirect:/book/list"; // 새로운 요청

	}
	
	
	

}

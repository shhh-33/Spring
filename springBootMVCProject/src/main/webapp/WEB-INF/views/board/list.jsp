<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<style>
h1 {
	background: linear-gradient(to right top, #C7D7F2, #4E8AF2);
	text-align: center;
}

th {
	background: linear-gradient(to right top, #FFE8FA, #F298EF);
	text-align: center;
}
</style>
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>


</head>
<body>
	<c:set var="path" value="${pageContext.request.contextPath}" />
	<!--변수지정해서 src 편하게 쓰려고  -->
	<span><h1>✿ʕ•ﻌ•ʔ 게 시 목 록 ʕ•ﻌ•ʔ✿</h1></span>
	<br>
	<h2 align="center">
		<a href="insert">[̲̅$̲̅(̲̅ ͡° ͜ʖ ͡°̲̅)̲̅$̲̅] <!--누르면 이렇게 이동 http://localhost:9090/myapp/webboard/insert  -->
			<img alt="명수사진" src="${path}/images/명수.jpg" width="300" height="200">
			๑새글등록๑
		</a>
	</h2>
	
	
	<table class="table  table-striped table-bordered table-hover ">
		<tr>
			
			<th>๑순서๑</th>
			<th>๑작성자๑</th>
			<th>๑제목๑ ๑댓글갯수๑</th>		
			<th>๑생성일๑</th>		
		</tr>

		<!-- blist : webBoardController에서 model로 등록  -->
		<!-- 순서표현하는변수 나중에 (역순으로 고치기) -->
		<c:forEach items="${blist.result.content }" var="board"
			varStatus="bstatus">
			<tr>
				
				<!--freeBoard 즉 VO에 있는 애들 데려오는중 -->
				<td>${bstatus.count}</td>
				<td>${board.writer }</td>
				<td><a href="detail?bno=${board.bno}">${board.title }</a>
				<span class="badge">${board.replies.size() }</span></td>
				<td>${board.regdate }</td>
			<%-- 	<td><button class="delButton" data-bno="${board.bno }">삭제</button></td> --%>
			</tr>
		</c:forEach>

	</table>

	<!-- 페이지 이동 처리 -->
	<nav>
		<div>
			<ul class="pagination">

				<!--이전 페이지  -->
				<c:if test="${blist.prevPage}">
				<!--li : 페이지 누르는 버튼  -->
					<li class="page-item"><a href="${blist.prevPage.pageNumber+1}">PREV${blist.prevPage.pageNumber+1}</a>
					</li>
				</c:if>
				<!--리스트  -->
				<c:forEach items="${blist.pageList}" var="p">
					<li class="page-item"
						class="${p.pageNumber==blist.currentPageNum-1}?active:''"><a
						href="${p.pageNumber}">${p.pageNumber+1}</a></li>
				</c:forEach>
				<!--다음 페이지  -->
				<c:if test="${blist.nextPage}">
					<li class="page-item"><a href="${blist.nextPage.pageNumber+1}">NEXT${blist.nextPage.pageNumber+1}</a>
					</li>
				</c:if>

			</ul>
		</div>
	</nav>
	
	<!--페이지 이동을 위한 form 추가  -->
	<!--현재 페이지 다시 조회하러 action list  -->
	<form id="f1" action="list" method="get">
		<input type="text" name="page" value="${blist.currentPageNum}">
		<input type="text" name="size" value="${blist.currentPage.pageSize}">
	</form>


	<!--버튼 함수  -->
	<script>
		$(function() {
			$(".delButton").click(function() {
				//=${board.bno }
				location.href = "delete?bno=" + $(this).attr("data-bno");

			});

			//.pagination클래스(ul) a를 누름
			$(".pagination a").click(function(e) {
				//alert($(this).attr('href')); //현재 누른애의 href속성을 얻어라
				e.preventDefault(); //본래 기능은 취소한다. 다른목적으로 쓸거니까 
				//아이디가 f1인 form에서, 이름이 page인 input을 찾고, value를 위에서 지정한 href 속성으로 바꾼다 
				$("#f1").find("[name='page']").val($(this).attr('href'));
				$("#f1").submit();
			});

		});
	</script>
</body>
</html>
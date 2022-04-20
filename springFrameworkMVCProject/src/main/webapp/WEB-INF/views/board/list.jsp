<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/layout.css">
<link rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/board.css">
<script
	src="${ pageContext.request.contextPath }/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						$('#insertBtn')
								.click(
										function() {
											location.href = "${pageContext.request.contextPath}/board/writeForm.do"
										})

						$('#search').on(
								"click",
								function() {

									var mydata = {
										"keyword" : $("#keyword").val(),
										"contents" : $("#contents").val()

									};
									console.log(mydata);
									alert(mydata.keyword + " 검색내용 : "
											+ mydata.contents);

									//서버에 다녀오기(화면 이동없이 이 자리로 돌아와 )
									$.ajax({
										url : "",
										data : mydata,
										success : function(responseData) {
											alert("다녀옴" + responseData);
											$('#here').html(responseData);
										}
									});

								});
					})

	function goWriteForm() {
		location.href = "writeForm.jsp"
	}

	function doAction(boardNo) {

		location.href = '${ pageContext.request.contextPath }/board/detail.do?no='
				+ boardNo

	}
</script>
</head>
<body>
	<%--  <header>
      <jsp:include page="/jsp/include/topMenu.jsp" />
   </header> --%>
	<section>
		<div align="center">
			<hr>
			<h2>게시판 목록</h2>

			<span>전체건수 : ${boardCnt}</span> <span>${message }</span>
			<hr>

			조건조회 : <select id="keyword">
				<option value="title">타이틀</option>
				<option value="writer">글쓴이</option>
			</select> <input type="text" id="contents">
			<button id="search">검색</button>

			<hr>
			<br>
			<div id="here">
				<table border="1" class="list">
					<tr>
						<th width="7%">번호</th>
						<th>제목</th>
						<th width="16%">글쓴이</th>
						<th width="s10%">조회수</th>
						<th width="20%">등록일</th>
					</tr>
					<!-- $띄어쓰기x -->
					<c:forEach items="${ list }" var="board" varStatus="bstatus">
						<tr>
							<td>${boardCnt-bstatus.index+1 }</td>
							<td><a href="javascript:doAction(${ board.no })"> <c:out
										value="${ board.title }" />
							</a></td>
							<td>${ board.writer }</td>
							<td>${ board.viewCnt }</td>
							<td>${ board.regDate }</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<br>
			<%-- <c:if test="${ not empty userVO }"> --%>
			<button id="insertBtn">새글등록</button>
			<%-- 		</c:if> --%>
		</div>
	</section>
	<footer>
		<%--      <%@ include file="/jsp/include/footer.jsp" %> --%>
	</footer>
</body>
</html>


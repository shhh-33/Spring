

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

</head>
<body>
	<header>
		<%-- 	<jsp:include page="/jsp/include/topMenu.jsp" /> --%>
	</header>
	<section>
		<div align="center">
			<hr>
			<h2>게시판 수정</h2>
			<hr>
			<br>
			<form action="update.do" method="post">
				<input type="hidden" name="no" value="${board.no}">
				<table border="1">
					<tr>
						<th width="25%">번호</th>
						<td>${board.no}</td>
					</tr>
					<tr>
						<th width="25%">제목</th>
						<td><input type="text" name="title" value="${board.title}"></td>
					</tr>
					<tr>
						<th width="25%">작성자</th>
						<td><input type="text" name="writer" value="${board.writer}"></td>
					</tr>
					<tr>
						<th width="25%">내용</th>
						<td><input type="text" name="content" value="${board.content}"></td>
					</tr>
					<tr>
						<th width="25%">조회수</th>
						<td><input type="text" name="viewCnt" value="${board.viewCnt}"
							disabled="disabled"></td>
					</tr>
					<tr>
						<th width="25%">등록일</th>
						<td><input type="text" name="regDate" value="${board.regDate}"
							disabled="disabled"></td>
					</tr>
					<tr>
						<th width="25%">첨부파일</th>
						<td><c:forEach items="${ fileList }" var="file">
								<a
									href="${ pageContext.request.contextPath }/upload/${ file.fileSaveName }">
									${ file.fileOriName } </a>(${ file.fileSize } bytes)<br>
							</c:forEach></td>
					</tr>

				</table>
					<tr>
						<td colspan="2"></td>
						<input type ="submit" value="수정">
					</tr>
			</form>
			<br>

		</div>
	</section>
	<footer>
		<%-- <%@ include file="/jsp/include/footer.jsp" %> --%>
	</footer>
</body>
</html>

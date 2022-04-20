<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<table border="1" class="list">
	<tr>
		<th width="7%">번호</th>
		<th>제목</th>
		<th width="16%">글쓴이</th>
		<th width="10%">조회수</th>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>상세보기</h1>
${book }
<form action="update" method="post" >
bno : <input type="text" name="bno" value="${book.bno}" ><br>
title : <input type="text" name="title" value="${book.author}" ><br>
author : <input type="text" name="author" value="${book.author}" ><br>
pub : <input type="text" name="pub" value="${book.pub}" ><br>
pubDate : <input type="text" name="pubDate" value="${book.pubDate}" ><br>
status : <input type="text" name="status" value="${book.status}" ><br>
  <input type="submit" value="책등록" ><br>

</form>
</body>
</html>
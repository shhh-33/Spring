<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>책정보등록하기</h1>

<form action="insert" method="post">
bno: <input type="text" name="bno"><br>
title: <input type="text" name="title"><br>
author: <input type="text" name="author"><br>
pub: <input type="text" name="pub"><br>
pubDate: <input type="text" name="pubDate"><br>
status: <input type="text" name="status"><br>
 <input type="submit" value="책등록"><br>
 <!--submit누르면 액션으로  -->

</form>

</body>
</html>
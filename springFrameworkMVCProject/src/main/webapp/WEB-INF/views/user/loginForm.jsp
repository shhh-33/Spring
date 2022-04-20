<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인하기</h1>
<form action="login" method="post">
사용자번호 : <input type="text" name ="userid" value="zzilre">
비밀번호 : <input type="password" name ="userpass" value="1234">
<!-- 서버에 전송하니까  -->
<input type="submit" value="로그인">

</form>
</body>
</html>
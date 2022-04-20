<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world! ${myname }</h1>

	<P>The time on the server is ${serverTime}.</P>

	<!--get방식으로 로그인 창 열기 -->
	<!-- 컨트롤러를 요청해야함 jsp 말고   -->
	<!-- @RequestMapping(value="/login" 여기서 맨위에 test있으니까 적어야 -->

	<!-- 상대경로.....  -->
	<a href="test/login">로그인창 상대</a>
	<!-- / 절대경로.. -->
	<a href="/education/test/login">로그인창 절대</a>

	<form action="test/login">
  	  <input type="submit" value="로그인창3 겟">
	</form>
	<hr>
	
	
	
	<form action="test/login" method="post">
	<input type ="text" name="userid" value="sesac"><br>
	<input type ="text" name="userpass" value="aa"><br>
  	  <input type="submit" value="로그인창5 포스트">
	</form>
<hr>

 <script src="https://code.jquery.com/jquery-3.6.0.min.js">
 </script>
 <button id ="btn1">로그인하기4(JS)</button>
 <form action="test/helloParam.do">
		<input type="text" name="userid" value="sesac"><br> 
		<input type="text" name="userpass" value="aaaa"><br> 
		<input	type="submit" value="파라메터보내기">
	</form>
 
 <script>
 //고전
 $(function(){
	 $("#btn1").click(function(){
		 //BOM(Brower Object Model) :window, document,lacation,history,screen
		 location.href="test/login";
		 
	 });
 });
 
 
 </script>
 
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<h1>게시글 등록하기</h1>
	<!-- readonly="readonly" -->
	<form action="insert" method="post">

		<div class="form-group">
			<label for="title">title</label> <input type="text"
				class="form-control" id="title" name="title" required="required">
		</div>
		<div class="form-group">
			<label for="writer">writer</label> <input type="text"
				class="form-control" id="writer" name="writer" required="required">
		</div>
		<div class="form-group">
			<label for="content">content</label> <input type="text"
				class="form-control" id="content" name="content" required="required">
		</div>

		<div class="form-group">
			
			<input type="submit" value="입력">
			

		</div>


	</form>
	
</body>
</html>
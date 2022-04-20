<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글등록 페이지</title>
<link rel = "stylesheet" href="${ pageContext.request.contextPath }/resources/css/layout.css" >
<link rel = "stylesheet" href="${ pageContext.request.contextPath }/resources/css/board.css" >
<style type="text/css">
	hr, table{
		width: 80%
	}
</style>
<script type="text/javascript">
	function doWrite() {
		
		let f = document.inputForm
		
		if(f.title.value == ''){
			alert('제목을 입력하세요')
			f.title.focus()
			return false
		}
		
		if(f.content.value == ''){
			alert('내용을 입력하세요')
			f.content.focus()
			return false
		}
		
		return true
	}

</script>
</head>
<body>
	<div align="center">
		<hr>
		<h2>새글 등록</h2>
		<hr>
		<br>
		<form action="${ pageContext.request.contextPath }/board/write.do" method="post" 
		name="inputForm" onsubmit="return doWrite()" > 
		<!-- onsubmit : 필수 입력 처리 -->
			
			
			
			<table border="1">
				<tr>
					<th width="23%">제목</th>
					<td><input type="text" name="title"></td> <!-- required : 필수 입력 처리 -->
				</tr>
				<tr>
					<th>글쓴이</th>
					<td><input type="text" name="writer" value="${ userVO.id }"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="content" rows="7" cols=100%></textarea></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td>
						<input type="file" name="attachfile1"><br>
						<input type="file" name="attachfile2"><br>
					</td>
				</tr>
			</table>
			<br>
			<input type="submit" value="새글등록">
		</form>
	</div>
</body>
</html>
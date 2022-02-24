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
	<h1>✿ʕ•ﻌ•ʔ게시글상세보기ʕ•ﻌ•ʔ✿</h1>
	<!-- readonly="readonly" -->
	<form action="update" method="post">
	         <!--model.addAttribute("board",~)  -->
		<div class="form-group">
			<!-- 수정할필요없으니 hidden, 그치만 반드시 넘겨야 -->
			<input type="hidden" class="form-control" id="bno" name="bno"
				value="${board.bno}">
		</div>
	
		<div class="form-group">
			<label for="title">title</label> <input type="text"
				class="form-control" id="title" name="title" value="${board.title}">
				                                         <!--value로 원래적혔던거 받아옴--> 
		</div>
		<div class="form-group">
			<label for="writer">writer</label> <input type="text"
				class="form-control" id="writer" name="writer"
				value="${board.writer}">
		</div>
		<div class="form-group">
			<label for="content">content</label> <input type="text"
				class="form-control" id="content" name="content"
				value="${board.content}">
		</div>

		<div class="form-group">
			<!--submit은 여러개일수없다 //action에서 update로 간다고 해놓음 -->
			<input type="submit" value="수정">
		
			<input type="button" id="delButton" value="삭제"> 
			<input type="button" id="listButton" value="목록">

		</div>


	</form>

	<hr>
	<br>

	<div>
		<button data-toggle="modal" data-target="#myModal"
			class="btn btn-warning pull-right" id="addReply" data-msg="add"
			data-myname="jin">댓글추가</button>
	</div>



	<hr>
	<!--댓글  -->
	<h1>✿ʕ•ﻌ•ʔ댓글 목록ʕ•ﻌ•ʔ✿</h1>
	<table class="table table-striped table-bordered  table-hover">
		<thead>
			<tr>
				<th>๑댓글번호๑</th>
				<th>๑내용๑</th>
				<th>๑작성자๑</th>
			</tr>
		</thead>
		<tbody id="replyTable" data-toggle="modal">

		</tbody>
	</table>


<!-- 페이지 이동 처리 -->
	<nav>
		<div>
			<ul class="pagination">

				<!--이전 페이지  -->
				<c:if test="${rlist.prevPage}">
				<!--li : 페이지 누르는 버튼  -->
					<li class="page-item"><a href="${rlist.prevPage.pageNumber+1}">PREV${rlist.prevPage.pageNumber+1}</a>
					</li>
				</c:if>
				<!--리스트  -->
				<c:forEach items="${rlist.pageList}" var="p">
					<li class="page-item"
						class="${p.pageNumber==rlist.currentPageNum-1}?active:''"><a
						href="${p.pageNumber}">${p.pageNumber+1}</a></li>
				</c:forEach>
				<!--다음 페이지  -->
				<c:if test="${rlist.nextPage}">
					<li class="page-item"><a href="${rlist.nextPage.pageNumber+1}">NEXT${rlist.nextPage.pageNumber+1}</a>
					</li>
				</c:if>

			</ul>
		</div>
	</nav>
	
	<!--페이지 이동을 위한 form 추가  -->
	<!--현재 페이지 다시 조회하러 action list  -->
	<form id="f1" action="list" method="get">
		<input type="text" name="page" value="${rlist.currentPageNum}">
		<input type="text" name="size" value="${rlist.currentPage.pageSize}">
	</form>








	<div id="myModal" class="modal fade " role="dialog">
		<div class="model_dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">๑modal-title변경๑</h4>
				</div>

				<div class="modal-body">

					<input type="hidden" name="rno" class="form-control"> <label>๑댓글내용๑</label>
					<textarea name="reply" rows="5" cols="80" class="form-control"></textarea>
					<label>๑작성자๑</label> <input type="text" name="replyer"
						class="form-control" value="${session.user.name}">
				</div>
				<div class="modal-footer">
					<button id="modalSaveBtn" class="btn btn-info">
						๑Save(insert or update)๑</button>
					<button id="modalDelBtn" class="btn btn-info">๑Delete๑</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>



<!--댓글 스크립트  -->
	<script>
         $.ajax({
              url:"/myapp/replies/list/" +${board.bno},
              success:function(responseData){
                 // alert(responseData);
                  //console.log(responseData);
                  printList(responseData);
                  }
            }); 

	function printList(arr){
		  var str="";
          $.each(arr,function(index,item){
        	    str += "<tr>";
	    		str += "<td>" + "<span class='badge'>" + index + "</span>" + item.rno+ "</td>";
	    		str += "<td>" +  item.reply + "</td>";
	    		str += "<td>" +  item.replyer + "</td>";
	    		str += "</tr>";

                $("#replyTable").html(str);
              });
		}
	
	</script>
	
	
	<script>
      $(function() {
         //삭제 버튼
         $("#delButton").click(function() {
            if (confirm("삭제하시겠습니까?")) {
               location.href = "delete?bno=${board.bno}"; //href겟방식 
          $
            }
         });


        //목록버튼 
         $("#listButton").click(function() {
            location.href = "list?page=0&size=10"; //1페이지로 가게 하려고
         });


         //댓글추가버튼
         $("#modalSaveBtn").click(function(){
				//alert("저장해줄게" + $("textarea[name='reply']").val())
		    	var replyText = $("textarea[name='reply']").val();
		    	var replyer = $("input[name='replyer']").val();
		    	var obj={
		    		"bno": "${board.bno}" ,
		    		"reply": replyText ,
		    		"replyer": replyer
		    	};
		    	console.log(obj);
		    	console.log("/myapp/replies/add/" + ${board.bno});
		    	$.ajax({
                 url:"/myapp/replies/add/" + ${board.bno},
                 data:  JSON.stringify(obj),
                 type: "post",
     			dataType: "json",
     			contentType: "application/json",
                 success:function(responseData){
                     //alert(responseData);
                     printList(responseData);
                 }
			    });
		    	$("#myModal").modal("hide");
			});

        
        
    });
	</script>
</body>
</html>
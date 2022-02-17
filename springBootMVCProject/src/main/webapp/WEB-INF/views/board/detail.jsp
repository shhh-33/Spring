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
	<h1>✿ʕ•ﻌ•ʔ게시글상세보기ʕ•ﻌ•ʔ✿</h1>
	<!-- readonly="readonly" -->
	<form action="update" method="post">
		<div class="form-group">
			<!-- 수정할필요없어서 그치만 반드시 넘겨야 -->
			<input type="hidden" class="form-control" id="bno" name="bno"
				value="${board.bno}">
		</div>
		<div class="form-group">
			<label for="title">title</label> <input type="text"
				class="form-control" id="title" name="title" value="${board.title}">
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
			<!--submit은 여러개일수 없어  -->
			<input type="submit" value="수정">
			<!-- action에 update로 간다고 해놓음 ->컨트롤러 고치기 -->
			<input type="button" id="delButton" value="삭제"> <input
				type="button" id="listButton" value="조회">

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

	<div id="myModal" class="modal fade " role="dialog">
		<div class="model_dialog">
			Modal content
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




	<script>
        $.ajax({
              url:"/myapp/replies/list/" +${board.bno},
              success:function(responseData){
                  alert(responseData);
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
         $("#delButton").click(function() {
            if (confirm("삭제하시겠습니까?")) {
               location.href = "delete?bno=${board.bno}"; //href겟방식 
          $
            }
         });
  
         $("#listButton").click(function() {
            location.href = "list";
         });

         
         $("#modalSaveBtn").click(function(){
				alert("저장해줄게" + $("textarea[name='reply']").val())
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
                     alert(responseData);
                     printList(responseData);
                 }
			    });
		    	$("#myModal").modal("hide");
			});

        
        
    });
	</script>
</body>
</html>
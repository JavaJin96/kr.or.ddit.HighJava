<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>

<script>
$(function(){
	$.ajax({
		
		
		// 교수가 보는 강의공지 화면
		
		// 자신이 쓴 강의공지 불러오기
		url : "<%=request.getContextPath()%>/pNotice.do",
		method : "post",
		success : function(res){
			code = "";
			
			code += "<h2><img id='icon' src='<%=request.getContextPath()%>/images/icon/ee.png'>강의 공지사항</h2>";
			code += "<table border='1' class='table table-light'>";
			
<%-- 			code += "<img id='icon' src='<%=request.getContextPath()%>/images/icon/ee.png'>"; --%>
			code += "<tr><td>강의명</td><td>글제목</td><td>글내용</td><td>작성일</td></tr>";
			$.each(res, function(i, v){
			 	code += "<tr><td>" + v.sub_name + "</td>";
			 	code += "<td>" + v.board_title + "</td>";
			 	code += "<td> " + v.board_cont + "</td>";
			 	code += "<td>" + v.board_date + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
			 	code += "<input type='button' value='수정' class='btn btn-danger modify' data-toggle='modal' data-target='#myModal' data='" + v.board_num + "'>";
			 	code += "<input type='button' value='삭제' class='btn btn-danger delete ' data='" + v.board_num + "'></td></tr>";
			})
			code += "</table>";
			$("body").append(code);
		},
		error : function(xhr){
			alert("상태 : " + xhr.status)
		},
		dataType : "json"
	})
	
	
	// 내가 쓴 강의 공지 리스트에서 수정버튼 이벤트(모달창으로 시작)
	$("body").on("click", ".modify", function(){
		bnum = $(this).attr("data");
		alert(bnum);
		$("#ff").attr("action", "<%=request.getContextPath()%>/modifyNotice.do");
		codem = "<table border='1' class='table table-light'>";
		codem += "<tr><td>글제목</td>";
		codem += "<td><input type='text' name='title'></td></tr>";
		codem += "<tr><td>글내용</td>";
		codem += "<td><input type='text' name='cont'>";
		codem += "<input type='text' hidden value='" + bnum + "' name='bnum'><td></tr>";
		codem += "</table>";
		$(".modal-body").empty().append(codem);
	})
	
	// 내가 쓴 강의 공지 리스트에서 삭제버튼 이벤트(모달창)
	$("body").on("click", ".delete", function(){
		bnum2 = $(this).attr("data");
		alert(bnum2);
		$.ajax({
			url : "<%=request.getContextPath()%>/deleteNotice.do",
			data : {
				"bnum" : bnum2
			},
			method : "post",
			success : function(res){
				if(res.sw == "ok"){
					alert("삭제되었습니다.");
					location.href="<%=request.getContextPath()%>/work_psj/notice/pindex.jsp";			
				}
			},
			error : function(xhr){
				alert("상태 : " + xhr.status)
			},
			dataType : "json"
		})
		
		
	})
		

	
})
</script>
</head>
<body>


<div class="modal" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Modal Heading</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>
	
	  <form action="" method="post" id="ff">
      <!-- Modal body -->
      <div class="modal-body" id="d4">

      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <input type="submit" class="btn btn-danger"  value='등록'>
        <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
      </div>
      </form>

    </div>
  </div>
</div>
</body>
</html>
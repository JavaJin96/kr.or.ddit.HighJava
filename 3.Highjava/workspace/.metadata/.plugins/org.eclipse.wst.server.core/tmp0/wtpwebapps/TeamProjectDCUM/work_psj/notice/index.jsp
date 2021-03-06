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
		
		
		// 강의 공지사항을 불러오는 부분
		url : "<%=request.getContextPath()%>/Notice.do",
		method : "post",
		success : function(res){
			code = "";
			code += "<table border='1' class='table table-light'>";
			code += "<tr><h3>강의공지사항</h3></tr>";
			code += "<tr><td>강의명</td><td>글제목</td><td>글내용</td><td>작성일</td><td>작성자</td></tr>";
			$.each(res, function(i, v){
			 	code += "<tr><td>" + v.sub_name + "</td>";
			 	code += "<td>" + v.board_title + "</td>";
			 	code += "<td> " + v.board_cont + "</td>";
			 	code += "<td>" + v.board_date + "</td>";
			 	code += "<td>" + v.board_writer + "</td></tr>";
			})
			code += "</table>";
			$("body").html(code);
		},
		error : function(xhr){
			alert("상태 : " + xhr.status)
		},
		dataType : "json"
	})
})
</script>
</head>
<body>

</body>
</html>
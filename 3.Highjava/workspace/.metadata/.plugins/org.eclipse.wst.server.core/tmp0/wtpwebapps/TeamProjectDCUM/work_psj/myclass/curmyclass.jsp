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
<style>
div{

	width : 98%;
	height : 100px;
	margin : 1px;
	padding : 5px;
}
#d1{
	height : 200px;
}
#d2{
	height : 500px;
}
#d3,#d4,#d5{
	width : 32.579%;
	height : 350px;
	float : left;
	margin : 1px;
	padding : 0px;
}
</style>
<script>

//	depth2번(강의실 - 내수강강의) 눌렀을때 jsp







$(function(){
	
	// 공지사항을 불러오는 ajax
	$.ajax({
		url : "<%=request.getContextPath()%>/Notice.do",
		method : "post",
		success : function(res){
			code = "";
			code += "<table border='1' class='table table-light'>";
			code += "<tr><h2>공지사항</h2></tr>";
			code += "<tr><td>강의명</td><td>글제목</td><td>글내용</td><td>작성일</td><td>작성자</td></tr>";
			$.each(res, function(i, v){
			 	code += "<tr><td>" + v.sub_name + "</td>";
			 	code += "<td>" + v.board_title + "</td>";
			 	code += "<td> " + v.board_cont + "</td>";
			 	code += "<td>" + v.board_date + "</td>";
			 	code += "<td>" + v.mem_id + "</td></tr>";
			})
			code += "</table>";
			$("#d4").html(code);
		},
		error : function(xhr){
			alert("상태 : " + xhr.status)
		},
		dataType : "json"
	})
	
	// 마이페이지 요약을 불러오는 ajax
	$.ajax({
		url : "<%=request.getContextPath()%>/Mypage.do",
		method : "post",
		success : function(res){
			code = "<table border='1'>";
			code += "<tr><h2>마이페이지</h2></tr>";
			code += "<tr><td class='mypage'>" + res.mem_name + " 님 반갑습니다.</td><tr>";
			code += "<td class='mypage'>이곳은 뭔가 적을만한거 적는곳</td><tr>";
			code += "<td class='mypage'>이곳은 뭔가 적을만한거 적는곳</td><tr>";
			code += "<td class='mypage'>이곳은 뭔가 적을만한거 적는곳</td><tr>";
			code += "<td class='mypage'>이곳은 뭔가 적을만한거 적는곳</td><tr>";
			code += "</table>";
			$("#d3").html(code);
		},
		error : function(xhr){
			alert("상태 : " + xhr.status)
		},
		dataType : "json"
	})
	
	// 강의 목록을 불러오는 ajax

	$.ajax({
		url : "<%=request.getContextPath()%>/classList.do",
		//data : "",
		method : "post",
		success : function(res){
			code = "";
			code += "<table class='table'>";
			code += "<tr><h2>내 강의 목록</h2></tr>";
			$.each(res, function(i, v){
				var subname = v.sub_name;
				code += "<tr><td>강의명</td>";
				code += "<td class='subname'>" + v.sub_name + "</td></tr>"; 
// 				code += "<tr><td>담당교수</td>";
// 				code += "<td>" + v.mem_id  + "</td></tr>";				
			})
			code += "</table>";
			$("#d2").html(code);
		},
		error : function(xhr){
			alert("상태 : " + xhr.status);
		},
		dataType : "json"
	})
	
	// 강의리스트에서 강의를 눌렀을 때 이동하는 script
	$("#d2").on("click",".subname", function(){
		subname = $(this).text();
		
		$.ajax({
			url : "<%=request.getContextPath()%>/subnameIn.do",
			data : {
				"subname" : subname
			},
			method : "post",
			success : function(res){
				location.href="<%=request.getContextPath()%>/work_psj/class/index.jsp";
			},
			error : function(xhr){
				alert("상태 : " + xhr.status);
			},
			dataType : "json"
		})
	/*  	location.href="<%=request.getContextPath()%>/work_psj/class/index.jsp";*/	

	})
	
	// 마이페이지에서 무언가를 눌렀을 때 이동하는 script
	$("#d3").on("click", ".mypage", function(){
		location.href="<%=request.getContextPath()%>/work_psj/mypage/index.jsp";
	})
	
})
</script>
</head>
<body>
	<div id="d2"> <h1>내강의목록</h1></div>



</body>
</html>
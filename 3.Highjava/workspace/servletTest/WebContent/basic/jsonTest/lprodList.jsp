<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<script src="../../js/jquery-3.6.0.min.js"></script>

<script>
$(function(){
	

$("#btn1").on("click", function(){
	$.ajax({
		url : "<%=request.getContextPath()%>/lprodListServlet.do",
		method : "get",
		success : function(res){
			code = "<table border='1'>"
			code += "<tr>";
			code += "<td> LPROD_ID </td>"
			code += "<td> LPROD_GU </td>"
			code += "<td> LPROD_NM </td>"
			code += "</tr>"
			
			$.each(res, function(i, v){
				code += "<tr><td>" + v.lprod_id + "</td>"
				code += "<td>" + v.lprod_gu + "</td>"
				code += "<td>" + v.lprod_nm + "</td></tr>"
			})
			code += "</table>"
			$("#result1").html(code);
		},
		error : function(xhr){
			alert("상태 : " + xhr.status)
		},
		dataType : "json"
	})
	
})

	$("#btn2").on("click", function(){
		location.href = "<%=request.getContextPath()%>/lprodListNonAjaxServlet.do";
	})


})

</script>

</head>
<body>
	<input type="button" value="Lprod자료 비동기 가져오기(Ajax)" id="btn1" name="load">
	<input type="button" value="Lprod자료 동기 가져오기(NonAjax)" id="btn2" name="load">
	
	
	<h1>Lprod 자료 목록</h1>
	<div id="result1">
	</div>
	
</body>
</html>
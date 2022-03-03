<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.6.0.min.js"></script>
<script>
$(function(){
	$("#btn1").on("click", function(){
		window.location = "<%=request.getContextPath()%>/member/join.jsp";	
	})
	
	
	
	$.ajax({
		url : "<%=request.getContextPath()%>/allMemberList.do",
		method : "get",
		success : function(res){
// 			code = "<table border='1'>"
// 			code +=	"<tr>"
// 			code += '<td id="d1">'
// 			code += '<input type="submit" value="회원추가" id="btn1" ></td></tr>'
// 			code +=	'<tr><td>ID</td><td>비밀번호</td><td>이름</td><td>전화</td><td>주소</td></tr>'

			code = "";
			$.each(res, function(i, v){
				code += "<tr><td>" + v.mem_id + "</td>";
				code += "<td>" + v.mem_pass + "</td>"
				code += "<td>" + v.mem_name + "</td>"
				code += "<td>" + v.mem_tel + "</td>"
				code += "<td>" + v.mem_addr + "</td></tr>"
			})
			$("#memList").html(code);
			
		},
		error : function(xhr){
			alert("상태 : " + xhr.status)
		},
		dataType : "json"
	})
})

</script>
<style>
#btn1{
	float : right;
}
</style>
</head>
<body>
	<h1>회원 목록 보기</h1>
	
	<div id="div1">
	<table border='1'>
	<thead>
		<tr>
			<td id="d1">
			<input type="submit" value="회원추가" id="btn1" ></td>
		</tr>
		
		<tr>
			<td>ID</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>전화</td>
			<td>주소</td>
		</tr>
	</thead>
	<tbody id="memList">
	
	</tbody>	
	
	</table>
	</div>
</body>
</html>
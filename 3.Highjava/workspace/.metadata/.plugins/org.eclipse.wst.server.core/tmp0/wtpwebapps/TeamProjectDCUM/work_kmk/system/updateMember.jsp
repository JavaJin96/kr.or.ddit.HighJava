<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.dcum.vo.temp_StudentInfoVO"%>
<%@page import="kr.or.ddit.dcum.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<!-- Core theme CSS (includes Bootstrap) -->
<link href="css/styles.css" rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<style>
table,tr,th,td{
	text-align: center;
}
</style>
<script>
$(function(){
	$('.btn').on('click',function(){
		mem_name= $('#mem_name').text()
		console.log("ajax시작")
		$.ajax({
			url : '<%=request.getContextPath()%>/updateStatusByProfessor.do',
			data : {
				"result": $(this).val(),
				"student_id": $('#mem_id').text(),
				"status":$('#status').text()
			},
			type :'post',
			success : function(res){
				alert(mem_name+"님 "+res)
				location.href='<%=request.getContextPath()%>/statusChangeList.do'
			},
			error : function(xhr){
				alert("오류....ㅠㅠ"+xhr.status)	
			},
			dataType : 'json'
		})
	})
})
</script>
</head>
<% 
MemberVO loginMember = (MemberVO)session.getAttribute("loginUser");
String dep_name = (String)session.getAttribute("dep_name");
List<temp_StudentInfoVO> waitList = (List<temp_StudentInfoVO>)request.getAttribute("waitList");
List<temp_StudentInfoVO> totalList = (List<temp_StudentInfoVO>)request.getAttribute("totalList");
%>
<body>
<br>
	<div class="container">
		<h3>학생관리</h3>
		<hr>

		<div id="div1">
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th colspan="6" style="text-align: left;">휴/복학/자퇴 신청현황</th>
					</tr>
				</thead>
				<thead class="thead-light">
					<tr>
						<th>순번</th>
						<th>이름</th>
						<th>학과</th>
						<th>학번</th>
						<th>진행상태</th>
						<th>승인</th>
					</tr>
				</thead>
<%if(waitList!=null){
	for(int i = 0 ; i < waitList.size() ; i++){
	if(waitList.get(i).getStatus().length()>2){%>
				<tbody>
					<tr>
						<td><%=i+1%></td>
						<td id="mem_name"><%=waitList.get(i).getMem_name() %></td>
						<td id="dep_name"><%=dep_name%></td>
						<td id="mem_id"><%=waitList.get(i).getMem_id() %></td>
						<td id="status"><%=waitList.get(i).getStatus() %></td>
						<td>
							<input type="button" class="btn btn-warning btn-sm ok-but" value="승인">
							<input type="button" class="btn btn-danger btn-sm no-but" value="반려">
						</td>
					</tr>
<%}}}else{ %>
					<tr>
						<td>신청내역이 없습니다.</td>
					</tr>
<%}%>
				</tbody>
			</table>
		</div>
		
	</div>

</body>
</html>
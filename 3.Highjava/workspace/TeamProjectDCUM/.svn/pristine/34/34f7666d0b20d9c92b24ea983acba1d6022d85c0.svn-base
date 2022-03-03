<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.dcum.vo.temp_StudentInfoVO"%>
<%@page import="kr.or.ddit.dcum.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
table th,td {
	width: 100px;
	text-align: center;
}

caption {
	caption-side: top;
}
select{
	width: 100%;
}
button {
	width: 100px;
	margin: 0 100px;
}
.cause{
	width: 500px;
    float: left;
}
</style>
<% 
MemberVO loginMember = (MemberVO)session.getAttribute("loginUser");
temp_StudentInfoVO studentInfo = (temp_StudentInfoVO)request.getAttribute("studentInfo");
String pro_name = (String)request.getAttribute("pro_name");
%>
<script>
$(function(){
	$('#hu-but').on('click',function(){
		$("#hu").show();
		$("#bok").hide();
		$("#ja").hide();
	})
	
	$('#bok-but').on('click',function(){
		$("#bok").show();
		$("#hu").hide();
		$("#ja").hide();
	})
	
	$('#ja-but').on('click',function(){
		$("#ja").show();
		$("#hu").hide();
		$("#bok").hide();
	})
	
	
})	
</script>
</head>
<body>
<br>
	<div class="container">
		<h3>휴/복학/자퇴 신청</h3>
		<!--   <p id="p1">인적사항 외 수정사항은 관리자에게 문의하세요.</p> -->
		<hr>
		<caption>학과정보</caption>
		<table class="table dark-table">
			<thead class="thead-dark">
				<tr>
					<th class="table-active">이름</th>
					<th class="table-active">학과</th>
					<th class="table-active">학번</th>
					<th class="table-active">입학일</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><%=loginMember.getMem_name() %></td>
					<td><%=studentInfo.getDep_name()%></td>
					<td><%=studentInfo.getMem_id()%></td>
					<td><%=studentInfo.getStart_date()%></td>
				</tr>
			</tbody>
		</table>

		<hr>

		<form action="<%=request.getContextPath()%>/updateStudentStatus.do">
			<table class="table">
				<caption>[ 학적조회 ]</caption>
				<tr>
					<th class="table-active">담당교수</th>
					<td><%=pro_name%></td>
					<th class="table-active">재학여부</th>
					<td style="color:blue;font-weight: bold;">
					[ <%=studentInfo.getStatus()%> ]</td>
				</tr>
				<tr>
					<th colspan="2">신청서작성</th>
					<td colspan="2">
					<%if(studentInfo.getStatus().equals("재학")){ %>
						<button type="button" id="hu-but" class="btn btn-warning" >휴학</button>
					<%}else if(studentInfo.getStatus().equals("휴학")){ %>
						<button type="button" id="bok-but" class="btn btn-success">복학</button>
					<%}else if(studentInfo.getStatus().equals("휴학신청")||
							   studentInfo.getStatus().equals("복학신청")||
							   studentInfo.getStatus().equals("자퇴신청")){ %>
						<button type="submit" id="reset-but" name="status" 
						value="<%=studentInfo.getStatus()%>" class="btn btn-success">신청취소</button>
					<%}else if(studentInfo.getStatus().equals("자퇴")){%>
					<span style="color:red;font-weight: bold;">자퇴처리완료 _ 재입학 처리 부탁드립니다.</span>
					<%}if(!studentInfo.getStatus().equals("자퇴신청")){ %>
						<button type="button" id="ja-but" class="btn btn-danger">자퇴</button>
					<%} %>
					</td>
				</tr>
			</table>
		</form>
				<hr>
		<div  id="hu" style="display: none">
		<form action="<%=request.getContextPath()%>/updateStudentStatus.do">
			<table class="table">
				<caption>[ 휴학_신청정보 ]</caption>
				<tr>
					<th class="table-active">휴학학기</th>
					<td>
						<select name="hacki">
							<option value="1">1학기</option>
							<option value="2">2학기</option>
							<option value="3">3학기</option>
							<option value="4">4학기</option>
						</select>
					</td>
					<th class="table-active">휴학사유</th>
					<td>
						<input type="text" name="cause" class="cause">
					</td>
					<td>
						<button type="submit" style="float: right;" 
						name="status" value="휴학" class="btn btn-dark">제출</button>
					</td>
			</table>
		</form>
		</div>

		<div id="bok" style="display: none">
		<form action="<%=request.getContextPath()%>/updateStudentStatus.do">
			<table class="table">
				<caption>[ 복학_신청정보 ]</caption>
				<tr>
					<td>
						<button type="submit" style="float: right;"
						name="status" value="복학" class="btn btn-dark">제출</button>
					</td>
				</tr>
			</table>
		</form>
		</div>
		
		<div id="ja" style="display: none">
		<form action="<%=request.getContextPath()%>/updateStudentStatus.do">
			<table class="table">
				<caption>[ 자퇴_신청정보 ]</caption>
				<tr>
					<th class="table-active">자퇴사유</th>
					<td>
						<input type="text" name="cause" class="cause">
					</td>
					<td>
						<button type="submit" style="float: right;"
						name="status" value="자퇴" class="btn btn-dark">제출</button>
					</td>
				</tr>
			</table>
		</form>
		</div>

	</div>
</body>
</body>
</html>
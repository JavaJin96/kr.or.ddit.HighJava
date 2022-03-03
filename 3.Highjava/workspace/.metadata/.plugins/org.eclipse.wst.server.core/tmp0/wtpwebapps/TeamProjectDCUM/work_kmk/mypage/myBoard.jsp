<%@page import="kr.or.ddit.dcum.vo.CommunityVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.dcum.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- jquery -->
<link rel="stylesheet"	href="<%=request.getContextPath()%>/css/updateInfo.css">
<script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<!-- 외부소스 -->
<link rel="stylesheet"	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<%
MemberVO loginMember = (MemberVO)session.getAttribute("loginUser");
List<CommunityVO> boardList = (List<CommunityVO>)request.getAttribute("boardList");
%>
<style>
#selectBox {
	float: right;
	width: 100px;
}
.sort-body {
	font-weight: bold;
	color: #2f561f;
}
.sort{
	width: 50px;
}
.date{
	width: 100px;
}
.cont-aTag{
	color :black;
}
</style>
<script>

</script>
<body>
	<div class="container">
	
		<br>
		<h3>게시물관리</h3>
		<p>
			<span id="p1">내가 쓴 글 내역입니다.</span>
			<select id="selectBox" name="cmu_sort">
				<option value="전체" selected="selected">전체</option>
				<option value="질의응답">질의응답</option>
				<option value="비교과">비교과</option>
				<option value="물물교환">물물교환</option>
			</select>
		</p>
		<hr>
		<caption>[ 커뮤니티 ]</caption>
		<table class="table dark-table">
			<thead class="thead-dark">
				<tr>
					<th class="sort">말머리</th>
					<th class="cont">제목</th>
					<th class="date">작성날짜</th>
				</tr>
			</thead>
			<tbody>
				<%
					if (boardList == null) {
				%>
				<tr>
					<td colspan="3">
						<p style="text-align: center;">내가쓴 게시물이 없습니다.</p>
					<td>
				</tr>
				<%
					} else {
						for (CommunityVO b : boardList) {
				%>
				<tr>
					<td class="room" class="sort-body">[ <%=b.getCmu_sort()%> ]</td>
					<td class="room">
						<a class="cont-aTag" 
						 href="<%=request.getContextPath()%>/communityView.do?cmu_num=<%= b.getCmu_num() %>">
						 <%=b.getCmu_title()%></a>
					</td>
					<td class="room"><%=b.getCmu_date()%></td>
				</tr>
				<%
						}
					}
				%>
			</tbody>
		</table>
		<hr>
	</div>
</body>
</html>
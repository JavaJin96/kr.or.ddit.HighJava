<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.dcum.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.6.0.min.js"></script>
</head>
<!-- 안쓰는 파일**************************************************************************************************  -->































<% 
// 세션 데이터 가져오기 
MemberVO loginMember = (MemberVO)session.getAttribute("loginUser");
%>
<body>
<% if(loginMember==null){ %>

	<form action="<%=request.getContextPath()%>/login.do" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" id="id" name="mem_id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" id="pass" name="mem_pass"></td>
			</tr>
			<tr>
				<td colspan="2" id="radioTd">
					<input type="radio" class="sort" name="mem_sort_num" value=1> 학생 
					<input type="radio" class="sort" name="mem_sort_num" value=2> 교수 
					<input type="radio" class="sort" name="mem_sort_num" value=3> 직원</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="로그인" id="login">
					<input type="button" value="비밀번호찾기" id="bibun">
				</td>
			</tr>
		</table>
	</form>
<% }else{ %>
	<div style="text-align: center;margin:10% auto;">
		<h2><%=loginMember.getMem_name()%>님 반갑습니다.</h2>
		<a href="<%=request.getContextPath()%>/logout.do">로그아웃</a>
	</div>	
<% } %>		
	
</body>
</html>
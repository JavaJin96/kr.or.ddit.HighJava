<%@page import="kr.or.ddit.basic.session.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
form {
	text-align: center;
	margin-top: 50px;
}
</style>

<% 

	MemberVO vo = (MemberVO)session.getAttribute("loginUser");

%>


<body>

<% 
if(vo == null){
%>
	<form action="<%=request.getContextPath()%>/sessionDBLogin.do" method="post">
		<input type="text" name="id" value="아이디"><br>
		<input type="password" name="pw" value="비밀번호"><br>
		<input type="submit" value="login"><br>
	</form>
	
<%}else{ %>
	
	<h3><%= vo.getMem_name() %> 님 반갑습니다.</h3>
	<a href='<%= request.getContextPath()%>/sessionDBLogout.do'>로그아웃</a>
	
	
	
<% } %>
</body>
</html>
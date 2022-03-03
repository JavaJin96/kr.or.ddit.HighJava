<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	<!-- JSP문서에서는 HttpSession객체가 자동으로 생성되어 session이라는 변수에 저장되어 있다.  -->
	
	
	<%if(session.getAttribute("id") == null) {%>
	<form action="<%=request.getContextPath()%>/sessionLogin.do" method="get">
		ID<input type="text" name="id"><br><br>
		PASSWORD<input type="password" name="pw"><br><br>
		<input type="submit" >
	</form>
	
	
	<%}else{ %>
	<h2> <%=session.getAttribute("id") %> 님 반갑습니다.</h2>
	<a href='<%= request.getContextPath()%>/sessionLogout.do'>로그아웃</a>
	<% }%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 테스트 2번~~~~~</title>
</head>
<body>
	<a href="<%=request.getContextPath()%>/cookieCountServlet.do">Cookie Count 증가하기</a> <br><br><hr>
	<a href="<%=request.getContextPath()%>/cookieCountDelServlet.do">Cookie Count 초기화 하기</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>IMG태그의 src속성에 Servlet으로 이미지 처리하기</h2><br><hr><br>
<img src="../../images/수지.jpg"><br><br>

<img src="<%=request.getContextPath() %>/images/수지.jpg"><br><br>

<img src="<%=request.getContextPath() %>/images/imageSrcView.do?filename=보노보노.png"><br><br>
<img src="<%=request.getContextPath() %>/images/imageSrcView.do?filename=영화1.jpg"><br><br>
</body>
</html>
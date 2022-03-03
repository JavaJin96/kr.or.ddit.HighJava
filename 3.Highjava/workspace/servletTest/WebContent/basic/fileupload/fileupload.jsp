<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Servlet File Upload</title>
</head>
<body>
<h2>File Upload 연습</h2>

<!-- file upload시 method=post, enctype="multipart/form-data" 는 필수 속성이다. -->
<form action="<%=request.getContextPath()%>/fileUpLoadServlet.do" method="post" enctype="multipart/form-data">
	ID : <input type="text" name="userid"><br><br>
	한 개 파일 선택 : <input type="file" name="upFile1"><br><br>
	여러 개 파일 선택 : <input type="file" name="upFile2" multiple="multiple"><br><br>
	<button type="submit">전송</button>
</form>
<br><hr><br>

<a href="<%= request.getContextPath()%>/uploadFileList.do">Upload된 전체 파일 목록 보기</a>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script>
	//안 쓰는 파일 *******************************************************************************다른쪽으로 기능 병합
	$(function(){
		$("#sbm").on("click", function(){
			console.log($("#sbm"));
		})
	})
</script>
</head>
<body>
	<form action="<%= request.getContextPath() %>/insertClass.do" method="post" enctype="multipart/form-data">
		<input type = "text" name="name" value="강의명"><br>
		<input type = "text" name="comment" value='강의설명'><br>
		<input type = "file" name="file" value='강의파일'><br>
		<input type = "submit" value='등록' id="sbm">
		<input type = "reset" value = "취소">
	</form>
</body>
</html>
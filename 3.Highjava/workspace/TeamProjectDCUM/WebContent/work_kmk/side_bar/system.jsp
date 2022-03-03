<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/side-bar.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<br>
<div class="container" >
		<h4>관리자메뉴</h4>
		<br>
		<table class="table table-hover">
				<tr>
					<td>
						<a href="<%=request.getContextPath()%>/gongji.do" target="ifr-main" class="board">공지사항</a>
					</td>
				</tr>
				<tr>
					<td>
						<a href="<%=request.getContextPath()%>/work_kmk/system/InsertMember.jsp" target="ifr-main"class="management">신규등록</a>
					</td>
				</tr>
				<tr>
					<td>
						<a href="<%=request.getContextPath()%>/allStudentList.do" target="ifr-main"class="management">학생리스트</a>
					</td>
				<tr>
					<td>
						<a href="<%=request.getContextPath()%>/allProList.do" target="ifr-main"class="management">직원리스트</a>
					</td>
				</tr>
		</table>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
  <title>Bootstrap Example</title>
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
		<h4>학사관리</h4>
		<br>
		<table class="table table-hover">
				<tr>
					<td>
						<a href="<%=request.getContextPath()%>/work_ysh/SubjectSelect.jsp" target="ifr-main" class="hacsa">성적관리</a>
					</td>
				</tr>
				<tr>
					<td>
						<a href="<%=request.getContextPath()%>/work_ysh/SubjectSelect.jsp" target="ifr-main" class="hacsa">수강관리</a>
					</td>
				</tr>
				<tr>
					<td>
						<a href="#" target="ifr-main" class="hacsa">학적관리</a>
					</td>
				</tr>
				<tr>
					<td>
					<a href="<%=request.getContextPath()%>/allProfessorList.do" 
					target="ifr-main" class="hacsa">휴/복학/자퇴</a>
					</td>
				</tr>
		</table>
	</div>


</body>
</html>
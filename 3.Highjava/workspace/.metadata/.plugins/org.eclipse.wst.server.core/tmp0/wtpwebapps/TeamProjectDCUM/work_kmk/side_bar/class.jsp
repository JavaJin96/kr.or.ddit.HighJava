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
		<h4>강의실</h4>
		<br>
		<table class="table table-hover">
				<tr>
					<td>
						<a href="<%=request.getContextPath()%>/work_psj/myclass/curmyclass.jsp" target="ifr-main">수강중인 강의</a>
					</td>
				</tr>
				<tr>
					<td>
						<a href="<%=request.getContextPath()%>/work_psj/qnaboard/index.jsp" target="ifr-main">- 질문</a>
					</td>
				</tr>
				<tr>
					<td>
						<a href="<%=request.getContextPath()%>/work_psj/homework/index.jsp" target="ifr-main">- 과제</a>
					</td>
				</tr>
				<tr>
					<td>
						<a href="<%=request.getContextPath()%>/work_psj/Test/indexs.jsp" target="ifr-main">- 시험</a>
					</td>
				</tr>
				<tr>
					<td>
						<a href="<%=request.getContextPath()%>/work_psj/notice/pindex.jsp" target="ifr-main">강의공지사항</a>
					</td>
				</tr>
				<tr>
					<td>
						<a href="<%=request.getContextPath()%>/work_psj/classComent/index.jsp" target="ifr-main">강의 평가</a>
					</td>
				</tr>
		</table>
	</div>


</body>
</html>
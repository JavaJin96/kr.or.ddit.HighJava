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
		<h4>마이페이지</h4>
		<br>
		<table class="table table-hover">
				<tr>
					<td>
						<a href="<%=request.getContextPath()%>/work_kmk/mypage/updateInfo.jsp" target="ifr-main">개인정보 수정</a>
					</td>
				</tr>
				<tr>
					<td>
						<a href="<%=request.getContextPath()%>/selectMyBoard.do"target="ifr-main">게시글관리</a>
					</td>
				</tr>
				<tr>
					<td>
						<a href="<%=request.getContextPath()%>/work_kmk/mypage/reservation.jsp"
						target="ifr-main">시설물 예약</a>
					</td>
				</tr>
				<tr>
					<td>
						<a href="<%=request.getContextPath()%>/allRentList.do"
						target="ifr-main">시설물 예약현황</a>
					</td>
				</tr>
		</table>
	</div>


</body>
</html>
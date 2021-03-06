<%@page import="kr.or.ddit.dcum.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Coming Soon - Start Bootstrap Theme</title>
<meta charset="UTF-8">
<script src="../js/jquery-3.6.0.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" crossorigin="anonymous"></script>
<!-- Google fonts-->
<link rel="preconnect" href="https://fonts.gstatic.com" />
<link href="https://fonts.googleapis.com/css2?family=Tinos:ital,wght@0,400;0,700;1,400;1,700&amp;display=swap" rel="stylesheet" />
<link href="https://fonts.googleapis.com/css2?family=DM+Sans:ital,wght@0,400;0,500;0,700;1,400;1,500;1,700&amp;display=swap" rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap) -->
<link href="css/styles.css" rel="stylesheet" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>


<style type="text/css">
tr,td{
	padding: 5px;
}
<%
	// 세션 데이터 가져오기 
	MemberVO loginMember = (MemberVO) session.getAttribute("loginUser");
%>
</style>
<script>
$(function(){
	$('#bibun-but').on('click',function() {
		$("#myModal").modal("show");
	})

	$('#modal-but').on('click',function(){
		mem_id = $('#bibun-id').val().trim();
		mem_mail = $('#bibun-mail').val().trim();
	
		if(mem_id.length >0  && mem_mail.length >0 ){
			$.ajax({
				url: '<%=request.getContextPath()%>/resetPass.do',
				method : 'post',
				data : { 
					"mem_id" : mem_id ,
					"mem_mail" : mem_mail	
				},
				success : function(res){
					alert(res)
					$('.modal fade').val("");
					$("#myModal").modal("hide");
				},
				error : function(xhr){
					alert("status : "+xhr.status)
				},
				dataType : 'json'
			})
		}
	})
})	
</script>
</head>
<body>
<%
	if (loginMember == null) {
%>
	<!-- Background Video-->
	<video class="bg-video" playsinline="playsinline" autoplay="autoplay"
		muted="muted" loop="loop">
		<source src="assets/mp4/bg.mp4" type="video/mp4" />
	</video>
	
	<!-- Masthead-->
	<div class="masthead" data-backdrop="static">
		<div class="masthead-content text-white">
			<div class="container-fluid px-4 px-lg-0">
				<h1 class="fst-italic lh-1 mb-4">Deadeok Human Resource Developememt Center</h1>
				<p class="mb-5">안녕하세요. <br>대덕인재개발원 사이버강의실입니다.</p>
				<form id="contactForm" action="http://localhost/TeamProjectDCUM/login.do" method="post">
					<table>
						<tr>
							<td colspan="2" id="radioTd">
							<input type="radio"
								class="sort" name="mem_sort_num" value=1> 학생 
							<input
								type="radio" class="sort" name="mem_sort_num" value=2>
								교수 
						</tr>
						<tr>
							<td>아이디</td>
							<td><input class="form-control" type="text" id="id"
								name="mem_id"></td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input class="form-control" type="password" id="pass"
								name="mem_pass"></td>
						</tr>
						<tr class="col-auto">
							<td><input type="submit" class="btn btn-primary" value="로그인" id="login"></td>
							<td>
								<button class="btn btn-primary" id="bibun-but" type="button">비밀번호초기화</button>
							</td>
						</tr>
					</table>
				</form>
			</div>
			                       
		</div>
	</div>	
	

<!-- The Modal -->
	<div class="modal fade" id="myModal" >
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title"> 비밀번호 초기화 🗝  </h4>
				</div>  
				<!-- Modal body -->
				<div class="modal-body">
					<div id="div1" class="form-group">
						<label>아이디</label> 
						<input type="text" class="form-control" id="bibun-id" name="mem_id" required>
					</div>
					<div id="div2" class="form-group">
						<label>이메일</label> 
						<input type="mail"	class="form-control" id="bibun-mail" name="mem_mail"
						placeholder="ex) Sample@naver.com" required>
					</div>
				</div>
				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="submit" class="btn btn-secondary btn-lg btn-block" id="modal-but">확인</button>
				</div>
			</div>
		</div>
	</div>

<% }else if(loginMember.getMem_sort_num().equals("1")){ %>
	<script>location.href = "http://localhost/TeamProjectDCUM/main/main.jsp"; </script>
<% }else if(loginMember.getMem_sort_num().equals("2")){ %>
	<script>location.href = "http://localhost/TeamProjectDCUM/main/mainp.jsp"; </script>
<% } %>	

	
</body>

</html>
<%@page import="kr.or.ddit.dcum.vo.temp_StudentInfoVO"%>
<%@page import="kr.or.ddit.dcum.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/card.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
 <script src="../../js/jquery-3.6.0.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
</head>
<style>
	div {
	}
		body{
		font-family: 'Jua', sans-serif;
	}
</style>

<% 
MemberVO loginMember = (MemberVO)session.getAttribute("loginUser");
temp_StudentInfoVO studentInfo = (temp_StudentInfoVO)session.getAttribute("studentInfo");
String dep_name = (String)session.getAttribute("dep_name");
%>

<script>
	$(function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/mainNotice.do",
			method : "post",
			success : function(res){
				cres1 =0 ;
				cres2=0;
				cres3= 0;
				$.each(res.clist, function(i,v){
					cres1++;
				})
				
				$.each(res.tlist, function(i,v){
					cres2++;
				})
				
				$.each(res.t2list, function(i,v){
					cres3++;
				})
				code76 = "<table border='1'  class='table table-light'> <tr><td>미수강강의</td><td><a href='../../work_psj/myclass/index.jsp' target='ifr-main'>" + cres1 + "개</a></td></tr>";
				code76 += "<tr><td>미제출과제</td><td><a href='../../work_psj/homework/index.jsp' target='ifr-main'>" + cres2 + "개</a></td></tr>";
				code76 += "<tr><td>미응시시험</td><td><a href='../../work_psj/Test/indexs.jsp' target='ifr-main'>" + cres3 + "개</a></td></tr>";
			
				$("#d4res").empty().append(code76);
			},
			error : function(xhr){
				alert("상태 : " + xhr.status)
			},
			dataType : "json"
		})
		
		$.ajax({
      		url : "<%=request.getContextPath()%>/classList.do",
			method : "post",
			success : function(res) {
				code = "";
				code += "<table class='table'>";
					$.each(res, function(i, v) {
						var subname = v.sub_name;
						code += "<tr>";
						code += "<td class='subname'> ▪ "+ v.sub_name+ "</td></tr>";
					})
				code += "</table>";
				$("#pro-d4res").html(code);
				},
					error : function(xhr) {
						alert("상태 : " + xhr.status);
					},
					dataType : "json"
				})
			})
</script>
<body>
<!-- 학생 정보 -->
<% if(loginMember.getMem_sort_num().equals("1")){ %>
	<div class="Info">
		<div >
		<img class="photo" src="../../images/main/사자2.jpg" align="left">
			<div class="cont">	
				<span id="name"><%=loginMember.getMem_name()%>님</span>
				<span id="status">[ <%=studentInfo.getStatus()%> ]</span>
				<br>
				<span id="type"><%=studentInfo.getDep_name()%></span>
				<br>
				<a href="<%=request.getContextPath()%>/work_ysh/mail.jsp" target="ifr-main">
				<img  class="icon" src="../../images/icon/쪽지.png" alt="쪽지"> 쪽지함
				</a>
				<br>
			</div>	
		</div>	
		<br>
		<br>
			<a type="button" class="btn btn-primary btn-secondary"
			href="<%=request.getContextPath()%>/work_kmk/mypage/updateInfo.jsp" target="ifr-main"'>
			정보수정</a>
			<button type="button" class="btn btn-primary btn-dark"
			 onclick='window.top.location.href="<%=request.getContextPath()%>/logout.do"'>로그아웃</button>
</div>
<div id="d4">
<h3>
	<img id="icon"src="<%=request.getContextPath()%>/images/icon/알람시계.PNG">
	일정관리
</h3>
	<div id="d4res"></div>
</div>
<!-- 교수 정보 -->	
<%}else if(loginMember.getMem_sort_num().equals("2")){ %>
	<div class="Info">
		<div >
		<img class="photo" src="../../images/main/사자2.jpg" align="left">
			<div class="cont">	
				<span id="name"><%=loginMember.getMem_name()%>님</span>
				<br>
				<span id="type"><%=dep_name%></span>
				<br>
				<img class="icon" src="../../images/icon/쪽지.png" alt="쪽지"> 쪽지함
				<br>
			</div>	
		</div>	
		<br>
		<br>
			<a type="button" class="btn btn-primary btn-secondary"
			href="<%=request.getContextPath()%>/work_kmk/mypage/updateInfo.jsp" target="ifr-main"'>
			정보수정</a>
			<button type="button" class="btn btn-primary btn-dark"
			 onclick='window.top.location.href="<%=request.getContextPath()%>/logout.do"'>로그아웃</button>
	</div>
	<div id="d4">
<h3>
	<img id="icon"src="<%=request.getContextPath()%>/images/icon/목록.PNG">
	강의목록
</h3>
	<div id="pro-d4res"></div>
</div>
<%}%>
	
</body>
</html>


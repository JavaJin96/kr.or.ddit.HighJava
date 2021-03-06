<%@page import="kr.or.ddit.dcum.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ddit cyber university</title>

<link rel="stylesheet" href="../css/main.css">
<!-- jquery -->
<script src="../js/jquery-3.6.0.min.js"></script>

<!-- 사진 슬라이드 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<!-- <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script> -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script>
$(function(){
	$('a').on('click',function(){
		target= $(this).attr('class')
// 		alert(target)  //검사용alert - 지울예정
		$('#side-frame').attr('src',"<%=request.getContextPath()%>/work_kmk/side_bar/"+target+".jsp")
	});
});

</script>
<style>
video {
	height : 300px;
}
</style>	
</head>
<body>
<% 
MemberVO loginMember = (MemberVO)session.getAttribute("loginUser");
%>

<!-- 메인 비디오 이미지 -->
	<video class="bg-video" playsinline="playsinline" autoplay="autoplay"
		muted="muted" loop="loop">
		<source src="assets/mp4/bg.mp4" type="video/mp4" />
	</video>

	<!-- 교수메뉴 -->
	<nav class="clearfix" id="top-nav">
		<a id="imgAtag" href="./mainp.jsp"><img alt="로고.png" src="../images/main/로고2.png"></a>
		<ul>
			<li>
				<div class="dropdown">
					<a href="<%=request.getContextPath()%>/work_psj/p_subject/index.jsp" class="upmoo" target="ifr-main">
						학사업무
					</a>
						
					<div class="dropdown-content">
						<a href="<%=request.getContextPath()%>/work_psj/p_subject/index.jsp" target="ifr-main" class='upmoo'>과목개설</a>
						<a href="<%=request.getContextPath()%>/statusChangeList.do" target="ifr-main"class="upmoo">학생관리</a>
					</div>
				</div>
			</li>
			
			<li>
				<div class="dropdown">
					<a href="<%=request.getContextPath()%>/work_psj/myclass/index.jsp" class="pro_class" target="ifr-main">강의실</a>
						
					<div class="dropdown-content">
						<a href="<%=request.getContextPath()%>/work_psj/myclass/index.jsp" target="ifr-main" class="pro_class">수강중강의</a>
						<a href="<%=request.getContextPath()%>/work_psj/Test/index.jsp" target="ifr-main" class="pro_class">시험등록</a>
						<a href="<%=request.getContextPath()%>/work_psj/p_manageStudent/index.jsp" target="ifr-main" class="pro_class">강의업무</a>
						<a href="<%=request.getContextPath()%>/work_psj/notice/pindex.jsp" target="ifr-main" class="pro_class">강의공지사항</a>
					</div>
				</div>
			</li>
			<li>
				<div class="dropdown">
					<a class="system">관리자메뉴</a>

					<div class="dropdown-content">
					<a href="<%=request.getContextPath()%>/gongji.do" target="ifr-main" class="system">공지사항</a>
					<a href="<%=request.getContextPath()%>/gongji.do" target="ifr-main" class="board">게시판 관리</a>
						<a href="<%=request.getContextPath()%>/work_kmk/system/InsertMember.jsp"
							target="ifr-main" class="system">신규등록</a>
						<a href="<%=request.getContextPath()%>/allStudentList.do"
							target="ifr-main" class="system">학생리스트</a>
						<a href="<%=request.getContextPath()%>/allProList.do" target="ifr-main"class="system">직원리스트</a>	
					</div>
				</div>
			</li>	
				<span>
					<%=loginMember.getMem_name()%>님 반갑습니다.
					<a href="<%=request.getContextPath()%>/logout.do">로그아웃</a>
				</span>
		</ul>	
	</nav>


<aside id="leftside">
<div id="d1">
	<aside>
		<iframe name="ifr-aside" id="side-frame" src="../work_kmk/iframe_kmk/card.jsp"></iframe>
	</aside>
</div>
</aside>

<div id="d2">
	<iframe name="ifr-main" id="main-frame" src='main_pro_show.jsp'></iframe>
</div>

	<footer style="margin:auto; font-weight: bold; text-size:15px; text-align: center; position:relative; height: 110px;">
		<div style="position:absolute; top:50%; left:50%; transform:translate(-50%,-50%)">
			<p>
			대전광역시 중구 계룡로 846, 3-4층 대표전화 : 042-222-8202 팩스 : 070-8768-2972
			<br>
			COPYRIGHT © 2020 (재)대덕인재개발원 ALL RIGHTS RESERVED
			<p>
		</div>
	</footer>






</body>
</html>
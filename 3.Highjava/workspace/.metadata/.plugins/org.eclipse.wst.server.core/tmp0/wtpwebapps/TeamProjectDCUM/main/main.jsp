<%@page import="kr.or.ddit.dcum.vo.temp_StudentInfoVO"%>
<%@page import="kr.or.ddit.dcum.vo.StudentVO"%>
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

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<!-- <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script> -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<style type="text/css">
</style>
<script>
$(function(){
	$('a').on('click',function(){
		target= $(this).attr('class')
// 		alert(target)  //검사용alert - 지울예정
		$('#side-frame').attr('src',"<%=request.getContextPath()%>/work_kmk/side_bar/"+target+".jsp")
	})
	
})

</script>	
</head>
<body>
<% 
MemberVO loginMember = (MemberVO)session.getAttribute("loginUser");
temp_StudentInfoVO studentInfo = (temp_StudentInfoVO)session.getAttribute("studentInfo");
%>
<!-- 팝업창 -->
<%if (loginMember.getMem_pass().equals(loginMember.getMem_bir())) {%>
<script>
	$('.modal fade').ready(function() {
		$("#myModal").modal("show");
		
		// 비밀번호 규칙 정규식 : 6~20 영문 대소문자  , 최소 1개의 숫자 혹은 특수 문자를 포함해야 함
		passreg =/^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{6,20}$/
		passvalue =""
		chkpassvalue =""
		$('#newPass').on('keyup',function(){
			passvalue = $(this).val().trim();
			if(passreg.test(passvalue)) {
				$(this).css('border', '2px solid green');
			}
		})
		$('#chkPass').on('keyup',function(){
			chkpassvalue = $(this).val().trim();
			if(passreg.test(passvalue)) {
				$(this).css('border', '2px solid green');
			}
		})
		
		$('#modal-but').on('click', function() {
			if(passvalue.length < 1 ){
				alert("비밀번호를 입력해주세요.")
				$('#newPass').css('border', '2px solid red');
			}
			else if(!passreg.test(passvalue)) {
				alert("비밀번호가 올바르지 않습니다.\n영문 대소문자(최소 1개의 숫자 혹은 특수문자 포함) 6자리 이상으로\n만들어야합니다.")
				$('#newPass').css('border', '2px solid red');
			}
			else if(chkpassvalue< 1 ){
				alert("비밀번호를 재입력해주세요.")
				$('#chkPass').css('border', '2px solid red');
			}
			else if(chkpassvalue != passvalue) {
				alert("비밀번호가 일치하지 않습니다.")
				$('#chkPass').css('border', '2px solid red');
			}
			else{
				$.ajax({
					url : "<%=request.getContextPath()%>/updatePass.do",
					data : { 'mem_pass': passvalue },
					type : 'post',
					success : function() {
						alert("변경성공");
						$('.form-control').val("");
						$("#myModal").modal("hide");
					},
					error : function(xhr) {
						alert("상태 : " + xhr.status);
					},
					dataType : 'html'
				})
			}
		})
	 	
	})
	
</script>




<!-- The Modal -->
	<div class="modal fade" id="myModal" >
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">초기 비밀번호를 변경해주세요🔒</h4>
				</div>
				<!-- Modal body -->
				<div class="modal-body">
					<div id="div1" class="form-group">
						<label for="pwd">변경할 비밀번호 입력</label> 
						<input type="password" class="form-control" id="newPass" 
						placeholder="영문 대소문자 6자리 (최소 1개의 숫자 혹은 특수문자 포함)" name="mem_pass" required>
					</div>
					<div id="div2" class="form-group">
						<label for="pwd">변경할 비밀번호 재입력</label> 
						<input type="password"	class="form-control" id="chkPass" 
						placeholder="Enter password" required>
					</div>
				</div>
				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="submit" class="btn btn-secondary btn-lg btn-block" id="modal-but" >확인</button>
				</div>
			</div>
		</div>
	</div>
<%}%>

<!-- 메인 비디오 이미지 -->
	<video class="bg-video" playsinline="playsinline" autoplay="autoplay"
		muted="muted" loop="loop">
		<source src="assets/mp4/bg.mp4" type="video/mp4" />
	</video>

	<!-- 학생메뉴 -->
	<nav class="clearfix" id="top-nav">
		<a id="imgAtag" href="./main.jsp"><img alt="로고.png" src="../images/main/로고2.png"></a>
		<ul>
			<li>
				<div class="dropdown">
					<a href="<%=request.getContextPath()%>/work_kmk/mypage/updateInfo.jsp" 
					   class="mypage" target="ifr-main">
						마이페이지
					</a>
						
					<div class="dropdown-content">
						<a href="<%=request.getContextPath()%>/work_kmk/mypage/updateInfo.jsp" target="ifr-main" class="mypage">개인정보 수정</a>
						<a href="<%=request.getContextPath()%>/selectMyBoard.do"target="ifr-main" class="mypage">게시글관리</a>
						<a href="<%=request.getContextPath()%>/work_kmk/mypage/reservation.jsp"target="ifr-main" class="mypage">시설물 예약</a>
						<a href="<%=request.getContextPath()%>/allRentList.do" target="ifr-main" class="mypage">시설물 예약현황</a>
					</div>
				</div>
			</li>
			
			<li>
				<div class="dropdown">
					<a href="<%=request.getContextPath()%>/work_ysh/student.jsp" target="ifr-main" class="hacsa">학사관리</a>
						
					<div class="dropdown-content">
						<a href="<%=request.getContextPath()%>/work_ysh/student.jsp" target="ifr-main" class="hacsa">성적관리</a>
						<a href="<%=request.getContextPath()%>/work_ysh/student.jsp" target="ifr-main" class="hacsa">수강관리</a>
						<a href="<%=request.getContextPath()%>/work_ysh/student.jsp" target="ifr-main" class="hacsa">학사관리</a>
						<a href="<%=request.getContextPath()%>/allProfessorList.do" 
					target="ifr-main" class="hacsa">휴/복학/자퇴</a>
					</div>
				</div>
			</li>
			
			<li>
				<div class="dropdown">
					<a href="<%=request.getContextPath()%>/work_psj/myclass/index.jsp" target="ifr-main" class="class">강의실</a>
						
					<div class="dropdown-content">
						<a href="<%=request.getContextPath()%>/work_psj/myclass/curmyclass.jsp" target="ifr-main" class="class">수강중인 강의</a>
						<a href="<%=request.getContextPath()%>/work_psj/qnaboard/index.jsp" target="ifr-main" class="class">- 질문</a>
						<a href="<%=request.getContextPath()%>/work_psj/homework/index.jsp" target="ifr-main" class="class">- 과제</a>
						<a href="<%=request.getContextPath()%>/work_psj/Test/indexs.jsp" target="ifr-main" class="class">- 시험</a>
						<a href="<%=request.getContextPath()%>/work_psj/notice/index.jsp" target="ifr-main" class="class">강의공지사항</a>
						<a href="<%=request.getContextPath()%>/work_psj/classComent/index.jsp" target="ifr-main" class="class">강의 평가</a>
					</div>
				</div>
			</li>	
			
			<li>
				<div class="dropdown">
					<a href="<%=request.getContextPath()%>/gongji.do" target="ifr-main" class="board">커뮤니티</a>
						
					<div class="dropdown-content">
						<a href="<%=request.getContextPath()%>/gongji.do" target="ifr-main" class="board">공지사항</a>
						<a href="<%=request.getContextPath()%>/community.do" target="ifr-main" class="board">커뮤니티</a>
						<a href="<%=request.getContextPath()%>/study.do" target="ifr-main" class="board">스터디모집</a>
						<a href="<%=request.getContextPath()%>/bamboo.do" target="ifr-main" class="board">대나무숲</a>
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
	<iframe name="ifr-main" id="main-frame" src='<%=request.getContextPath()%>/main/mainshow.jsp'></iframe>
</div>

	<!-- footer -->
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
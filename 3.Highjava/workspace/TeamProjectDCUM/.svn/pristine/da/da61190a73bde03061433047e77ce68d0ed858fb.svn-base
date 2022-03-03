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
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
<% 
MemberVO loginMember = (MemberVO)session.getAttribute("loginUser");
%>
<!-- 팝업창 -->
<%if (loginMember.getMem_sort_num().equals("1")) {%>
  <%if (loginMember.getMem_pass().equals("1234")) {%>
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
					<button type="submit" class="btn btn-secondary btn-lg btn-block" id="modal-clese" >닫기</button>
				</div>
			</div>
		</div>
	</div>
<%}
}%>

	<!-- 헤더 -->
	<header>
		<a href="./main.jsp"><img alt="로고.png" src="../images/main/로고2.png"></a>
		<span>[<%=loginMember.getMem_sort_nm()%>] <%=loginMember.getMem_name() %>님 반갑습니다.</span>
		<a href="<%=request.getContextPath()%>/logout.do">로그아웃</a>
	</header>

	<!-- 학생메뉴 -->
	<nav class="clearfix" id="main">
		<ul>
			<li>
				<div class="dropdown">
					<a href="<%=request.getContextPath()%>/work_kmk/mypage/mypage_main.jsp" 
					   class="dropbtn" target="ifr-main">
						마이페이지
					</a>
						
					<div class="dropdown-content">
						<a href="#"target="ifr-main">쪽지관리</a>
						<a href="#"target="ifr-main">개인정보 수정</a>
						<a href="#"target="ifr-main">대관 신청</a>
					</div>
				</div>
			</li>
			
			<li>
				<div class="dropdown">
					<a href="<%=request.getContextPath()%>/work_ysh/student.jsp" target="ifr-main" class="dropbtn">학사관리</a>
						
					<div class="dropdown-content">
						<a href="#">학사신청 안내</a>
						<a href="<%=request.getContextPath()%>/work_ysh/SelectScore.jsp" target="ifr-main" class="dropbtn">성적관리</a>
						<a href="#">수강관리</a>
						<a href="#">장학관리</a>
						<a href="#">졸업관리</a>
						<a href="#">학적</a>
					</div>
				</div>
			</li>
			
			<li>
				<div class="dropdown">
					<a href="<%=request.getContextPath()%>/work_psj/myclass/index.jsp" target="ifr-main" class="dropbtn">강의실</a>
					
					<div class="dropdown-content">
						<a href="<%=request.getContextPath()%>/work_psj/myclass/curmyclass.jsp" target="ifr-main">수강중인 강의</a>
						<a href="#" target="ifr-main">질문</a>
						<a href="#" target="ifr-main">강의 평가</a>
						<a href="#" target="ifr-main">공지사항</a>
						<a href="#" target="ifr-main">과제</a>
					</div>
				</div>
			</li>	
			
			<li>
				<div class="dropdown">
					<a href="#" class="dropbtn">커뮤니티</a>
						
					<div class="dropdown-content">
						<a href="<%=request.getContextPath()%>/bamboo.do" target="ifr-main">대나무숲</a>
						<a href="#">공지사항</a>
						<a href="#">질의응답</a>
						<a href="#">비교과 수강신청</a>
						<a href="#">스터디</a>
						<a href="#">물물교환</a>
					</div>
				</div>
			</li>
		</ul>	
	</nav>


<div class="main" style="margin-top:1px">
	<aside>
		<iframe name="ifr-aside" id="side" src="../work_kmk/iframe_kmk/card.jsp"></iframe>
	</aside>

	<section style="float:rigth">
		<iframe name="ifr-main" id="main" src="../work_kmk/iframe_kmk/slider.jsp"></iframe>
	</section>
</div>
	<!-- footer -->
	<footer style="margin-bottom:0">
		<p>Copyright (c)2021 Kang<p>
	</footer>






</body>
</html>
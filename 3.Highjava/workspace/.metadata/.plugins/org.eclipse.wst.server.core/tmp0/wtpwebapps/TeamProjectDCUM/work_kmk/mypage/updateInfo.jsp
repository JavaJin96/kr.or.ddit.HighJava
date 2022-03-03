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
<!-- jquery -->
<script src="<%=request.getContextPath() %>/js/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="http://localhost/TeamProjectDCUM/css/updateInfo.css">
<link rel="stylesheet" href="http://localhost/TeamProjectDCUM/css/mypage.css">
  <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>  
<% 
MemberVO loginMember = (MemberVO)session.getAttribute("loginUser");
temp_StudentInfoVO studentInfo = (temp_StudentInfoVO)session.getAttribute("studentInfo");
%>

<script>
$(function(){
	$('#bibun-but').on('click',function(){
		$("#myModal").modal("show");
		
		// 비밀번호 규칙 정규식 : 6~20 영문 대소문자  , 최소 1개의 숫자 혹은 특수 문자를 포함해야 함
		passreg =/^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{6,20}$/
		oldpassvalue=""
		passvalue =""
		chkpassvalue =""
		
		$('#oldPass').on('keyup',function(){
			oldpassvalue = $(this).val().trim();
			if(oldpassvalue=="<%=loginMember.getMem_pass()%>") {
				$(this).css('border', '2px solid green');
			}
		})
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
			if(oldpassvalue.length < 1 ){
				alert("현재 비밀번호를 입력해주세요.")
				$('#oldPass').css('border', '2px solid red');
			}
			else if(oldpassvalue!="<%=loginMember.getMem_pass()%>"){
				alert("현재 비밀번호가 일치하지 않습니다.")
				$('#oldPass').css('border', '2px solid red');
			}
			else if(passvalue.length < 1 ){
				alert("변경할 비밀번호를 입력해주세요.")
				$('#newPass').css('border', '2px solid red');
			}
			else if(passvalue=="<%=loginMember.getMem_pass()%>"){
				alert("변경할 비밀번호는 현재 비밀번호와 다르게 입력해주세요")
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
	
	$('#modifyModal').on('hide.bs.modal',function(){
		$('.form-control').val("");
	})	
	
	
	$('#up-but').on('click',function(){
		$('#bibun-but').hide();
		bir = '<input type="text" class="updateInfo" style="width:500px;" value='+$('#bir').text()+'>';
		$('#bir').html(bir);
		hp = '<input type="text" class="updateInfo" style="width:500px;" value='+$('#hp').text()+'>';
		$('#hp').html(hp);
		mail = '<input type="mail" class="updateInfo"style="width:500px;"  value='+$('#mail').text()+'>';
		$('#mail').html(mail);
		cont = '\"'+$('#add').text()+'\"'
		add = '<input type="text" class="updateInfo" style="width:500px;" value='+cont+'>';
		$('#add').html(add);
		
		$('#submit').show();
		$('#no-but').show();
		$(this).hide();
	
	})
	
	$('#td-but-parent').on('click','#submit',function(){
		$.ajax({
			url:'<%=request.getContextPath()%>/updateInfo.do',
			data:{
				'mem_bir' : $('#bir .updateInfo').val().trim(),
				'mem_hp' :  $('#hp .updateInfo').val().trim(),
				'mem_mail' : $('#mail .updateInfo').val().trim(),
				'mem_add' : $('#add .updateInfo').val().trim()
			},
			method : 'post',
			success :function(res){
				if(res > 0){
					alert("회원정보 수정성공");
					location.reload(true);
				}
				else{
					alert("회원정보 수정실패");
				}
			},
			error : function(xhr){
				alert("status : "+xhr.status);
			},
			dataType : 'json'
		})
	})
	

	
	
})
</script>
<body>
<div class="container">
	<br>
  <h3>개인정보</h3>
<% if(loginMember.getMem_sort_num().equals("1")){ %>
  <p id="p1">인적사항 외 수정사항은 관리자에게 문의하세요.</p>
  <hr>
  <caption> 학과정보 </caption>
  <table class="table dark-table" >
    <thead class="thead-dark">
      <tr>
        <th>이름</th>
        <th>학과</th>
        <th>학번</th>
        <th>입학일</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td><%=loginMember.getMem_name() %></td>
        <td><%=studentInfo.getDep_name()%></td>
        <td><%=studentInfo.getMem_id()%></td>
        <td><%=studentInfo.getStart_date()%></td>
      </tr>
    </tbody>
  </table>
<%}else if(loginMember.getMem_sort_num().equals("2")){ %>
  <hr>
  <caption> 학과정보 </caption>
  <table class="table dark-table" >
    <thead class="thead-dark">
      <tr>
        <th>이름</th>
        <th>학과</th>
        <th>아이디</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td><%=loginMember.getMem_name() %></td>
        <td>컴퓨터학과</td>
        <td><%=loginMember.getMem_id()%></td>
      </tr>
    </tbody>
  </table>
<%}%>        
  <br>
  <caption > 인적사항 </caption>
  <table class="table">
    <thead class="thead-light">
      <tr class="img_t">
 		<td class="img_t"> <img id="photo" src="../../images/main/사자2.jpg" > </td>
		<td class="img_t" id="td-but-parent">
			<button type="button" class="btn btn-secondary" id="up-but" >인적사항수정</button>
			<button type="button" class="btn btn-secondary" style="display:none;" id="submit" >확인</button>
			<button class="btn btn-secondary" id="no-but" style="display:none;"  
					onclick="location.href='updateInfo.jsp'">취소</button>
			<button type="button" class="btn btn-secondary" id="bibun-but" >비밀번호변경</button>
      	</td>
      </tr>
      <tr>
      	<th>생년월일</th>
        <td id="bir"><%=studentInfo.getMem_bir()%></td>
      </tr>
      <tr>
        <th>핸드폰번호</th>
        <td id="hp"><%=studentInfo.getMem_hp()%></td>
      </tr>
    
      <tr>
        <th>이메일</th>
        <td id="mail"><%=studentInfo.getMem_mail()%></td>
      </tr>
      <tr>
        <th>주소</th>
        <td id="add"><%=studentInfo.getMem_add()%></td>
      </tr>
    </thead>
  </table>
</div>

<!-- The Modal -->
	<div class="modal fade" id="myModal" >
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">🔒비밀번호 변경🔒</h4>
				</div>
				<!-- Modal body -->
				<div class="modal-body">
					<div id="div1" class="form-group">
						<label for="pwd">현재 비밀번호 입력</label> 
						<input type="password" class="form-control" id="oldPass" placeholder="현재 비밀번호를 입력해주세요" required>
					</div>
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

</body>
</html>
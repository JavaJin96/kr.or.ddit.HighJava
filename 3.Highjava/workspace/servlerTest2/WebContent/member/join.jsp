<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.6.0.min.js"></script>
<script>

// 중복확인 버튼 동작
$(function(){
	$("#btn1").on("click", function(){
		idvalue = $("#id").val();
		$.ajax({
			url : "<%=request.getContextPath()%>/Join.do",
			data : {"id" : idvalue},
			method : "post",
			success : function(res){
				if(res.sw == 1){
					$("#bb2").html("중복된 아이디입니다.");
				}else{
					$("#bb2").html("사용가능한 아이디입니다.");
					$("#id").attr("readonly", true);
				}
				
			},
			error : function(xhr){
				alert("상태 : " + xhr.status)
			},
			dataType : "json"
		})	
	})
	
	
	// submit 이벤트에서는 return false시에 서버로 전송하지 않는다.
	$("id").on("submit", function(){
		
	})
	
	// 회원정보 입력 폼에서 회원목록으로 돌아가는 동작
	$("#golist").on("click", function(){
		location.href = "<%=request.getContextPath()%>/member/index.jsp";
	})
	
	
	
})
</script>
</head>
<body>
	<h1>회원 정보 입력 폼</h1>
	<table border="1">
		<tr>
			<td>회원ID</td>
			<td><input type="text" name="id" id="id"><input type="button" value="중복확인" id="btn1">
			<br><span id="bb2"></span></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="pw"></td>
		</tr>
		<tr>
			<td>비밀번호확인</td>
			<td><input type="password" name="pw2"></td>
		</tr>
		<tr>
			<td>회원이름</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type="text" name="tel"></td>
		</tr>
		<tr>
			<td>회원주소</td>
			<td><input type="text" name="addr"></td>
		</tr>
		<tr>
			<td>
				<input type="button" value="저장" name="save">
				<input type="reset" value="취소" name="reset">
				<input type="button" value="회원목록" name="golist" id="golist">
			</td>
		</tr>
	
	</table>
</body>
</html>
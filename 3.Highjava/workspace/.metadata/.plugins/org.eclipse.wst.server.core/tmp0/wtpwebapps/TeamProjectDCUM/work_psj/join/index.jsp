<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script>
$(function(){
	// 안쓰는파일*****************************************************************************************************************
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	$("#cs").on("click", function(){
		$("#sortnum").val("1").attr("readonly", true);
		$("#sortnm").val("학생").attr("readonly", true);
		inputValue = "";
		inputValue += "<table border='1'>"
		inputValue += "<tr><td>입학일</td>"
		inputValue += "<td><input type='text' id='sd' name='sd'></td></tr>"
		inputValue += "<tr><td>졸업일</td>"
		inputValue += "<td><input type='text' id='ed' name='ed'></td></tr>"
		inputValue += "<tr><td>학과번호</td>"
		inputValue += "<td><input type='text' class='dn' name='dn' id='dn1'></td></tr>"
		inputValue += "</table>"
		
		$("#trd1").html(inputValue);
	})
	
	$("#cp").on("click", function(){
		$("#sortnum").val("2").attr("readonly", true);
		$("#sortnm").val("교수").attr("readonly", true);
		inputValue = "";
		inputValue += "<table border='1'>"
		inputValue += "<tr><td>연구실 방번호</td>"
		inputValue += "<td><input type='text' id='prn' name='prn'></td></tr>"
		inputValue += "<tr><td>연구실 전화번호</td>"
		inputValue += "<td><input type='text' id='prh' name='prh'></td></tr>"
		inputValue += "<tr><td>학과번호</td>"
		inputValue += "<td><input type='text' class='dn' name='dn' id='dn2'></td></tr>"
		inputValue += "</table>"
		
		$("#trd1").html(inputValue);
	})
	
	$("#cm").on("click", function(){
		$("#sortnum").val("3").attr("readonly", true);
		$("#sortnm").val("직원").attr("readonly", true);
		inputValue = "";
		inputValue += "<table border='1'>"
		inputValue += "<tr><td>내선 번호</td>"
		inputValue += "<td><input type='text' id='ehp' name='ehp'></td></tr>"
		inputValue += "</table>"
		
		$("#trd1").html(inputValue);
	})
	
	$("#trd1").on("blur", "#dn1", function(){
		num1 = $("#sd").val().substr(0,4);
		num2 = $(".dn").val();
		$.ajax({
			url : "<%=request.getContextPath()%>/joinSelectS.do",
			data : {
				"num1" : num1,
				"num2" : num2
			},
			method : "post",
			success : function(res){
				$("#id").val(res.res);
			},
			error : function(xhr){
				alert("상태 : " + xhr.status)
			},
			dataType : "json"
		})	
			
/* 		num1 = $("#sd").val();
		num2 = $(".dn").val();
		num1 = num1.substr(0,4);
		resultNum = num1 + num2;
		$("#id").val(resultNum); */

		
	})
	
	$("#trd1").on("blur", "#dn2", function(){
		num1 = $("#dn2").val();
		console.log(num1);
		$.ajax({
			url : "<%=request.getContextPath()%>/joinSelectP.do",
			data : {"num1" : num1},
			method : "post",
			success : function(res){
				$("#id").val(res.res);
			},
			error : function(xhr){
				alert("상태 : " + xhr.status)
			},
			dataType : "json"
		})
	})
	
	
	$("#cm").on("click", function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/joinSelectE.do",
			method : "post",
			success : function(res){
				$("#id").val(res.res);
			},
			error : function(xhr){
				alert("상태 : " + xhr.status)
			},
			dataType : "json"
		})
	})	
	
	
})
</script>
</head>
<body>
	<h2> 회원가입 </h2>
	
	<form action="<%=request.getContextPath()%>/join.do" method="post" id="join">
		학생<input type="radio" id="cs" name="cc">
		교수<input type="radio" id="cp" name="cc">
		직원<input type="radio" id="cm" name="cc">
		<table border='1' id="t1">

			<tr>
				<td>이름</td>
				<td>
					<input type="text" id="name" name="name">
				</td>
			</tr>
			
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="password" id="password" name="password" value="1234">
				</td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td>
					<input type="text" id="bir" name="bir">
				</td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					남<input type="checkbox" id="male" name="male">
					여<input type="checkbox" id="female" name="male">
				</td>
			</tr>
			<tr>
				<td>주소</td>
				<td>
					<input type="text" id="add" name="add">
				</td>
			</tr>
			<tr>
				<td>메일</td>
				<td>
					<input type="text" id="mail" name="mail">
				</td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td>
					<input type="text" id="hp" name="hp">
				</td>
			</tr>
			
			
			
			

		</table>
		
		<div id="trd1">
		
		</div>
		
		<div id="trd2">	
		<table border="1">
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" id="id" name="id" readonly="readonly">
				</td>
			</tr>
			
			<tr>
				<td>분류번호</td>
				<td>
					<input type="text" id="sortnum" name="sortnum">
				</td>
			</tr>
			
			<tr>
				<td>분류명</td>
				<td>
					<input type="text" id="sortnm" name="sortnm">
				</td>
			</tr>
			
		</table>
		</div>
		
		<input type="submit" value="가입" >
		<input type="reset" value="취소">
	</form>
	
	
	
	
	
	
</body>
</html>
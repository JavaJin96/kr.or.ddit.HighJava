<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<!-- Core theme CSS (includes Bootstrap) -->
<link href="css/styles.css" rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<script type="text/javascript">
	$(function() {
		
		$("#add1").on("click", function(){
		    new daum.Postcode({
		        oncomplete: function(data) {
		        	tt = data.jibunAddress
		            $("#add").val(tt);
		        }
		    }).open();
			
		})
		
		$("#cs").on("click", function() {
			$("#sortnum").val("1").attr("readonly", true);
			$("#sortnm").val("학생").attr("readonly", true);
			$("#student").show();
			$("#id").val("");
			$("#professor").val("").hide();
			
			$("#dn1").on("change", function(){
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
			})
		})
		
		$("#cp").on("click", function(){
			$("#sortnum").val("2").attr("readonly", true);
			$("#sortnm").val("교수").attr("readonly", true);
			$("#professor").show();
			$("#id").val("");
			$("#student").val("").hide();
			$("#dn2").on("change", function(){
				num1 = $("#dn2").val();
				console.log(num1)
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
		})
		
				
})
</script>
<style>
h3{
 display: inline-block;
 padding-right: 7%;
}
.type{
padding-right: 7%;
font-weight: bold;
}
.info{
border-top: 1px solid;
border-bottom: 1px solid;
}
th{
width: 250px;
}

</style>
<body>
<br>
	<div class="container">
		<form action="<%=request.getContextPath()%>/join.do" method="post" id="join">
		<h3>신규 회원 등록</h3>
		<span class="type">학생<input type="radio" id="cs" name="cc"></span>
		<span class="type">교수<input type="radio" id="cp" name="cc"></span>
			<table class="table">
				<tr>
					<th class="thead-dark">이름</th>
					<td><input type="text" id="name" name="name"></td>
				</tr>

				<tr>
					<th class="thead-dark">비밀번호</th>
					<td><input type="password" id="password" name="password"
						value="1234"></td>
				</tr>
				<tr>
					<th class="thead-dark">생년월일</th>
					<td><input type="text" id="bir" name="bir"></td>
				</tr>
				<tr>
					<th class="thead-dark">성별
					</th>
					<td>
						남<input type="checkbox" id="male" name="male" value="남"> 
						여<input type="checkbox" id="female" name="male" value="여">
					</td>
				</tr>
				<tr>
					<th class="thead-dark">주소</th>
					<td><input type="text" id="add" name="add">&nbsp;&nbsp;&nbsp;<input type="button" id="add1" name="add" value="주소찾기"></td>
				</tr>
				<tr>
					<th class="thead-dark">메일</th>
					<td><input type="text" id="mail" name="mail"></td>
				</tr>
				<tr>
					<th class="thead-dark">전화번호</th>
					<td><input type="text" id="hp" name="hp"></td>
				</tr>
			</table>


			<div id="student" class="info" style="display: none">
				<table class="table">
					<tr>
						<th>입학일</th>
						<td><input type='date' id='sd' name='sd'></td>
					</tr>
					<tr>
						<th>학과번호</th>
						<td>
							<select class='dn' name='dn' id='dn1'>
								<option value="10">컴퓨터공학과</option>
								<option value="20">전자제어과</option>
								<option value="30">산업디자인학과</option>
								<option value="40">건축학과</option>
								<option value="50">경제학과</option>
								<option value="60">일본어과</option>
								<option value="70">영문학과</option>
								<option value="80">중국어과</option>
								<option value="90">IT 비즈니스과</option>
							</select></td>
					</tr>
				</table>
			</div>


			<div id="professor" class="info" style="display: none">
				<table class="table">
					<tr>
						<th>연구실 방번호</th>
						<td><input type='text' id='prn' name='prn'></td>
					</tr>
					<tr>
						<th>연구실 전화번호</th>
						<td><input type='text' id='prh' name='prh'></td>
					</tr>
					<tr>
						<th>학과번호</th>
						<td>
							<select class='dn' name='dn2' id='dn2'>
								<option value="10" selected>컴퓨터공학과</option>
								<option value="20">전자제어과</option>
								<option value="30">산업디자인학과</option>
								<option value="40">건축학과</option>
								<option value="50">경제학과</option>
								<option value="60">일본어과</option>
								<option value="70">영문학과</option>
								<option value="80">중국어과</option>
								<option value="90">IT 비즈니스과</option>
							</select>
						</td>
					</tr>
				</table>
			</div>

			<div id="trd2" >
				<table class="table">
					<tr>
						<th>아이디</th>
						<td><input type="text" id="id" name="id" readonly="readonly">
						</td>
					</tr>

					<tr>
						<th>분류번호</th>
						<td><input type="text" id="sortnum" name="sortnum"></td>
					</tr>

					<tr>
						<th>분류명</th>
						<td><input type="text" id="sortnm" name="sortnm"></td>
					</tr>
				</table>
			</div>
			<br><br>
			<input type="submit" value="가입"> <input type="reset"
				value="취소">
		</form>
	</div>
</body>
</html>
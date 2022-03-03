<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script>
	$(function(){
		$.ajax({
			url : "<%=request.getContextPath()%>/Subjectlist.do",
			method : "post",
			success : function(res){
				code = "<option class='o1'>과목을 선택하세요</option>";
				$.each(res, function(i, v){
					code += "<option class='o1'>" + v.sub_name + "</option>"
				})
				$("#s1").html(code)
			},
			error : function(xhr){
				alert("상태 : " + xhr.status)
			},
			dataType : "json"
		})
		
		$("#s1").on("change", function(){
			data = $(this).val();
			
			$.ajax({
				url : "<%=request.getContextPath()%>/Subjectlist2.do",
				data : {"data" : data},
				method : "post",
				success : function(res){
					code2 = "<option class='o1'>과목을 선택하세요</option>";
					$.each(res, function(i,v){
						code2 += "<option class='o2'>" + v.class_name + "</option>"
					})
					$("#s2").html(code2);
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
	<form action="<%=request.getContextPath()%>/insertQna.do" method="get">
		제목<input type="text" name="title"><br><br>
		<select id="s1" name="subject">
			<option>과목을 선택하세요</option>
		</select> 
		<select id="s2" name="class">
			<option>수업을 선택하세요</option>
		</select>
		<p>내용</p><textarea rows="20" cols="30" name="cont"></textarea><br><br>
		<input type="submit" value="등록" >
		<input type="reset" value="취소">
		
	</form>
	
	
</body>
</html>
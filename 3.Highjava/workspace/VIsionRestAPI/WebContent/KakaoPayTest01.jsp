<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>


<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-3.6.0.min.js"></script>
<script>
$(function(){
	$("#btn1").on("click", function(){
		
	
	$.ajax({
		url : "/v2/vision/product/detect",
		data : {e : "https://search.pstatic.net/sunny/?src=https%3A%2F%2Fopengraph.githubassets.com%2F9cc23a23eb65394a59c089eec5dfd95a68a5fa7aaa24ae445707678993075321%2Foktadev%2Fokta-java-rest-api-comparison-example&type=l340_165"},
		method : "post",
		headers : {Authorization: "3a7bedee850fdde6ed60a0e19290a896"},
		success : function(res){
			alert("성공했다우?");
		},
		error : function(xhr){
			alert("상태 : " + xhr.status);
		},
		dataType : "json"
		
	})
	
	})
	
})



</script>
</head>
<body>
	<input type="button" id="btn1">
</body>
</html>
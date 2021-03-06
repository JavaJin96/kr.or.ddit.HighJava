<%@page import="kr.or.ddit.dcum.vo.MemberVO"%>
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
<style>
#right, #left{
	display: inline-block;
	border : 1px solid black;
	width : 50%;
	float : left;
	height : 720px;
}
#left, #right{
	overflow: auto;
}

#answerpaper td{
	height : 60px;
}

#atd {
	width : 80px;
}

#q td {
	height : 150px;	
}
#tt {
	height : 60px;
}

</style>
<script>
	$(function(){

		
		$.ajax({
			
			// 학생이 보는 시험 페이지
			url : "<%=request.getContextPath()%>/MyTest.do",
			method : "post",
			success : function(res){
				code = "";
				$.each(res, function(i, v){
					code += "<tr><td>" + v.sub_name + "</td>";
					code += "<td>" + v.test_name + "</td>";
					code += "<td>" + v.score + "</td>";
					
					if(v.score == "N"){
						code += "<td><input type='button' value='문제풀기' class='btn btn-danger gotest' data-toggle='modal' data-target='#myModal' data='" + v.test_name + "'></td></tr>";					
					}
					
				})
				$("#restab").empty().append(code);
			},
			error : function(xhr){
				alert("상태 : " + xhr.status)
			},
			dataType : "json"
		})
		
		$("#restab").on("click" , ".gotest", function(){
			testname = $(this).attr("data");
			$.ajax({
				url : "<%=request.getContextPath()%>/MyTestDetail.do",
				data : {
					"testname" : testname
				},
				method : "post",
				success : function(res){
					code2 = "";
					$.each(res, function(i, v){
						
					
					code2 += "<tr id='tt'><th>" + v.sub_name + "</th><th>" + v.test_name + "</th></tr>"
					code2 += "<tr><td id='qtd'>문제1</td><td>" + v.q1 + "</td></tr>"
					code2 += "<tr><td>문제2</td><td>" + v.q2 + "</td></tr>"
					code2 += "<tr><td>문제3</td><td>" + v.q3 + "</td></tr>"
					code2 += "<tr><td>문제4</td><td>" + v.q4 + "</td></tr>"
					code2 += "<tr><td>문제5</td><td>" + v.q5 + "</td></tr>"
					code2 += "<tr><td>문제6</td><td>" + v.q6 + "</td></tr>"
					code2 += "<tr><td>문제7</td><td>" + v.q7 + "</td></tr>"
					code2 += "<tr><td>문제8</td><td>" + v.q8 + "</td></tr>"
					code2 += "<tr><td>문제9</td><td>" + v.q9 + "</td></tr>"
					code2 += "<tr><td>문제10</td><td>" + v.q10 + "</td></tr>"
					$("#han2").val(v.test_name);
					$("#han").val(v.answer);
					})
					
					$("#q").empty().append(code2);
					
					code3 = "";
					code3 += "<tr><th>답안지</th>"
					code3 += "<tr><td id='atd'>문제1</td><td>1<input type='checkbox' value='1' name='qa'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2<input type='checkbox' value='2' name='qa'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3<input type='checkbox' value='3' name='qa'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4<input type='checkbox' value='4' name='qa'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5<input type='checkbox' value='5' name='qa'></td>"
					code3 += "<tr><td>문제2</td><td>1<input type='checkbox' value='1' name='qa2'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2<input type='checkbox' value='2' name='qa2'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3<input type='checkbox' value='3' name='qa2'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4<input type='checkbox' value='4' name='qa2'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5<input type='checkbox' value='5' name='qa2'></td>"
					code3 += "<tr><td>문제3</td><td>1<input type='checkbox' value='1' name='qa3'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2<input type='checkbox' value='2' name='qa3'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3<input type='checkbox' value='3' name='qa3'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4<input type='checkbox' value='4' name='qa3'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5<input type='checkbox' value='5' name='qa3'></td>"
					code3 += "<tr><td>문제4</td><td>1<input type='checkbox' value='1' name='qa4'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2<input type='checkbox' value='2' name='qa4'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3<input type='checkbox' value='3' name='qa4'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4<input type='checkbox' value='4' name='qa4'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5<input type='checkbox' value='5' name='qa4'></td>"
					code3 += "<tr><td>문제5</td><td>1<input type='checkbox' value='1' name='qa5'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2<input type='checkbox' value='2' name='qa5'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3<input type='checkbox' value='3' name='qa5'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4<input type='checkbox' value='4' name='qa5'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5<input type='checkbox' value='5' name='qa5'></td>"
					code3 += "<tr><td>문제6</td><td>1<input type='checkbox' value='1' name='qa6'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2<input type='checkbox' value='2' name='qa6'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3<input type='checkbox' value='3' name='qa6'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4<input type='checkbox' value='4' name='qa6'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5<input type='checkbox' value='5' name='qa6'></td>"
					code3 += "<tr><td>문제7</td><td>1<input type='checkbox' value='1' name='qa7'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2<input type='checkbox' value='2' name='qa7'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3<input type='checkbox' value='3' name='qa7'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4<input type='checkbox' value='4' name='qa7'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5<input type='checkbox' value='5' name='qa7'></td>"
					code3 += "<tr><td>문제8</td><td>1<input type='checkbox' value='1' name='qa8'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2<input type='checkbox' value='2' name='qa8'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3<input type='checkbox' value='3' name='qa8'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4<input type='checkbox' value='4' name='qa8'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5<input type='checkbox' value='5' name='qa8'></td>"
					code3 += "<tr><td>문제9</td><td>1<input type='checkbox' value='1' name='qa9'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2<input type='checkbox' value='2' name='qa9'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3<input type='checkbox' value='3' name='qa9'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4<input type='checkbox' value='4' name='qa9'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5<input type='checkbox' value='5' name='qa9'></td>"
					code3 += "<tr><td>문제10</td><td>1<input type='checkbox' value='1' name='qa10'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2<input type='checkbox' value='2' name='qa10'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3<input type='checkbox' value='3' name='qa10'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4<input type='checkbox' value='4' name='qa10'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5<input type='checkbox' value='5' name='qa10'></td>"
					
					$("#answerpaper").empty().append(code3);
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
	<h2><img src='<%=request.getContextPath()%>/images/icon/ll.png'>진행중인 시험</h2>
	<hr>
	<div id="d1">
		<table border="1" class="table table-light" id="restab">
		
		</table>	
	</div>
	
	

<!-- The Modal -->
<div class="modal " id="myModal">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Modal Heading</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
       <form action="<%=request.getContextPath()%>/TestChk.do" method="post">
      <div class="modal-body">
        <div id="right">
        	<h3>문제지</h3>
        	<table border='1' id='q' class='table table-light'>
        	
        	</table>
        </div>
        
       
        <div id="left">
        	<h3>답안지</h3>
        	<table border='1' id='answerpaper' class='table table-light'>
        	
        	</table>
        	<input type='text' hidden name='answer' id='han'>
        	<input type='text' hidden name='testname' id='han2'>
        </div>
       
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <input type="submit" class="btn btn-danger" value='제출' id="bbbv">
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>
       </form>

    </div>
  </div>
</div>

	
</body>
</html>
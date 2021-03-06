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
			// 진행중인 시험 리스트 불러오기
			url : "<%=request.getContextPath()%>/selectTestMenu.do",
			method : "post",
			success : function(res){
				code = "";
				$.each(res, function(i, v){
					code += "<tr><td>" + v.sub_name + "</td>";
					code += "<td>" + v.test_name + "</td>";
					code += "<td><input type='button' value='상세보기' class='btn btn-danger chk' data='" + v.sub_name + "' data-toggle='modal' data-target='#myModal2'></td></tr>";
				})
				$("#restab").empty().append(code);
			},
			error : function(xhr){
				alert("상태 : " + xhr.status)
			},
			dataType : "json"
		})	
		
		// 리스트에서 상세보기 버튼 클릭 이벤트
		$("#restab").on("click", ".chk" , function(){
			subname = $(this).attr("data");
			$.ajax({
				url : "<%=request.getContextPath()%>/selectTest.do",
				data : {
					"subname" : subname
				},
				method : "post",
				success : function(res){
					code3 = "";
					$.each(res, function(i, v){
						code3 += "<tr><td>" + v.sub_name + "</td>";
						code3 += "<td>" + v.test_name + "</td>";
						code3 += "<td>" + v.mem_name + "</td>";
						code3 += "<td>" + v.score + "</td></tr>";
					})
					$("#restab3").empty().append(code3);
				},
				error : function(xhr){
					alert("상태 : " + xhr.status)
				},
				dataType : "json"
			})
		})
		
		// 시험등록 버튼 이벤트
		$("#btn00").on("click", function(){
			subnum = $(this).attr("data");
			$.ajax({
				url : "<%=request.getContextPath()%>/testSubjects.do",
				data : {
					"subnum" : subnum
				},
				method : "post",
				success : function(res){
					code2 = "";
					$.each(res, function(i, v){
						code2 += "<option>" + v.sub_name + "</option>"
					})
					$("#s1").append(code2);
				},
				error : function(xhr){
					alert("상태 : " + xhr.status)
				},
				dataType : "json"
			})
		})
		
		$("#s1").on("change", function(){
			subname = $(this).val();
			$("#hin").val(subname);
			
		})
		
	})
	
</script>
<style>
.t1{
	width : 350px;
}
</style>
</head>
<body>
	<div id="d1">
		<h3><img src="/TeamProjectDCUM/images/icon/cc.png">시험등록
<!-- 		<input type="button" value="등록하기" class="btn table-light" data-toggle='modal' data-target='#myModal' id="btn00"> -->
		<button type="button" class="btn table-light" data-toggle='modal' data-target='#myModal' id="btn00">
		등록하기  <img src="<%=request.getContextPath()%>/images/icon/aa.PNG"></button></h3>
	</div>
	
	<hr>
	
	<div id="d2">
		<h3><img src="/TeamProjectDCUM/images/icon/학사관리.png">진행중인 시험</h3>
		<table border="1" class="table table-light" id="restab">
			
		</table>
	</div>
	
	
	  <!-- The Modal -->
  <div class="modal" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">Modal Heading</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->        	
        <form action="<%=request.getContextPath()%>/insertTest.do" method="post">
        <div class="modal-body">
        	<select id="s1">
        		<option>과목을 선택해주세요.</option>
        	</select><br><br>	
        	
        	시험명&nbsp;&nbsp;&nbsp;<input type="text" name="test" class="t1"><br><br>
        	1번문항&nbsp;&nbsp;<input type=text name="q1" class="t1"><br><br>	
        	2번문항&nbsp;&nbsp;<input type=text name="q2" class="t1"><br><br>	
        	3번문항&nbsp;&nbsp;<input type=text name="q3" class="t1"><br><br>
        	4번문항&nbsp;&nbsp;<input type=text name="q4" class="t1"><br><br>	
        	5번문항&nbsp;&nbsp;<input type=text name="q5" class="t1"><br><br>	
        	6번문항&nbsp;&nbsp;<input type=text name="q6" class="t1"><br><br>	
        	7번문항&nbsp;&nbsp;<input type=text name="q7" class="t1"><br><br>	
        	8번문항&nbsp;&nbsp;<input type=text name="q8" class="t1"><br><br>	
        	9번문항&nbsp;&nbsp;<input type=text name="q9" class="t1"><br><br>	
        	10번문항&nbsp;<input type=text name="q10" class="t1"><br><br>
        	정답&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=text name="answer" class="t1"><br><br>
        	<input type="text" hidden name="subname" id="hin">
        		
        	
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <input type="submit" class="btn btn-danger" value="등록">
         
          <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
        </div>
        </form>
        
      </div>
    </div>
  </div>
  
  
  
  
    <div class="modal" id="myModal2">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">Modal Heading</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->        	
        <div class="modal-body">
			<table class='table table-light' id="restab3">
			
			</table>
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">         
          <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
        </div>
        
      </div>
    </div>
  </div>
	
</body>
</html>
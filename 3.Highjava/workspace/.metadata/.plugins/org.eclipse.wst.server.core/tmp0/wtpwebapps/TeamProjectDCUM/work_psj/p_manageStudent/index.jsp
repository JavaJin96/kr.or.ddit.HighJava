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
			
			// 학생관리 - select태그에 본인이 하고 있는 수업 리스트값 넣어주기
			url : "<%=request.getContextPath()%>/pSelectSubject.do",
			method : "post",
			success : function(res){
				code = "";
				$.each(res, function(i, v){
					code += "<option>" + v.sub_name + "</option>";
					
				})
				$("#s1").append(code);
			},
			error : function(xhr){
				alert("상태 : " + xhr.status)
			},
			dataType : "json"
		})
		
		
		// 첫번째 select 항목이 선택되면 실행되는 이벤트(버튼활성화, 두번재 select에 내용 넣어주기)
		$("#s1").on("change", function(){
			subname = $(this).val();
			$("#btn2").removeAttr("disabled");
			$("#btn3").removeAttr("disabled");
			$.ajax({
				url : "<%=request.getContextPath()%>/pSelectClass.do",
				method : "post",
				data : {
					"subname" : subname
				},
				success : function(res){
					code2 = "";
					code3 = "";
					$.each(res, function(i, v){
						code2 += "<option>" + v.class_name + "</option>"
					})
					code3 += "<input type='text' hidden value='" + subname + "' class='idata'>";
					$("#d3").html(code3);
					$("#s2").empty().append(code2);
				},
				error : function(xhr){
					alert("상태  : " + xhr.status)
				},
				dataType : "json"
			})
			
			
			// 첫번째 select가 선택되면 해당 수업을 듣고 있는 학생들의 리스트를 출력하는 부분
			$.ajax({
				url : "<%=request.getContextPath()%>/pSelectStudent.do",
				method : "post",
				data : {
					"subname" : subname
				},
				success : function(res){
					code4 = "";
					$.each(res, function(i, v){
						code4 += "<tr><td>" + v.mem_id + "</td>"
						code4 += "<td>" + v.mem_name + "</td>"
						code4 += "<td>" + v.mem_hp + "</td>"
						code4 += "<td>" + v.mem_add + "</td></tr>"
					})
					$("#restab").empty().append(code4);
				},
				error : function(xhr){
					alert("상태 : " + xhr.status)
				},
				dataType : "json"
			})
						
		})
		
		// 두번재 select가 선택되면 출석관리 버튼 활성화
		$("#s2").on("change", function(){
			$("#btn1").removeAttr("disabled");
		})
		
		// 출석관리 버튼 클릭 이벤트
		$("#btn1").on("click" , function(){
			classname = $("#s2").val();
			$.ajax({
				url : "<%=request.getContextPath()%>/ChkSelect.do",
				data : {
					"classname" : classname
				},
				method : "post",
				success : function(res){
					code5 = "<tr><td>강의명</td><td>이름</td><td>출석여부</td></tr>";
					$.each(res, function(i, v){
						code5 += "<tr><td>" + classname + "</td><td>" + v.mem_name + "</td><td>" + v.status + "</td></tr>"
					})
					$("#restab").empty().append(code5);
				},
				error : function(xhr){
					alert("상태  : " + xhr.status)
				},
				dataType : "json"
			})

		})
		
		
		// 과제관리 선택 이벤트(제출한 과제 리스트 출력)
		$("#btn2").on("click", function(){
			subname = $("#s1").val();
			$.ajax({
				url : "<%=request.getContextPath()%>/selectTasks.do",
				method : "post",
				data : {
					"subname" : subname
				},
				success : function(res){
					code6 = "<tr><td>과제명</td><td>제목</td><td>내용</td><td>제출자</td><td>점수</td><td></td></tr>";
					$.each(res, function(i, v){
						code6 += "<tr><td>" + v.task_name + "</td>";
						code6 += "<td>" + v.task_title + "</td>";
						code6 += "<td>" + v.task_comt + "</td>";
						code6 += "<td>" + v.mem_name + "</td>";
						code6 += "<td>" + v.task_score + "</td>";
						code6 += "<td><input type='button' value='평가하기' class='btn btn-danger chkbtn' data-toggle='modal' data-target='#myModal' data='" + v.task_num + "'></td></tr>"
					})
					$("#restab").empty().append(code6);
				},
				error : function(xhr){
					alert("상태 : " + xhr.status)
				},
				dataType : "json"
			})
		})
		
		// 과제 점수 입력 이벤트
		$("#restab").on("click", ".chkbtn", function(){
			tasknum = $(this).attr("data");
			code7 ="";
			code7 += "<table border='1' class='table table-dark'><tr><td>점수입력</td><td><input type='text' name='score'></td></tr><tr><td></td><td><input type='text' hidden value='" + tasknum + "' name='tasknum'></td></tr></table>";
			$(".modal-body").empty().append(code7);
		})
		
		// 성적입력을 필요 부분 성적입력 이벤트
		$("#btn3").on("click", function(){
			subname = $("#s1").val();
			$.ajax({
				url : "<%=request.getContextPath()%>/scoreNeedStudents.do",
				method : "post",
				data : {
					"subname" : subname
				},
				success : function(res){
					code8 = "";
					code8 += "<tr><td>과목명</td><td>이름</td><td>학번</td><td>점수</td><td></td></tr>"
					$.each(res, function(i, v){
						code8 += "<tr><td>" + v.sub_name + "</td>";
						code8 += "<td>" + v.mem_name + "</td>";
						code8 += "<td>" + v.mem_id + "</td>";
						code8 += "<td>" + v.sub_score + "</td>";
						code8 += "<td><input type='button' value='점수 부여' class='btn btn-danger inscore' data-toggle='modal' data-target='#myModal' data='" + v.sub_num + "'></td></tr>";
					})
					$("#restab").empty().append(code8);
				},
				error : function(xhr){
					alert("상태  : " + xhr.status)
				},
				dataType : "json"
			})			
		})
		
		
		
		// 점수입력 이벤트
		$("#restab").on("click", ".inscore" , function(){
			memid = $(this).attr("data");
			$("#ff").attr("action", "<%=request.getContextPath()%>/insertSScore.do");
			code9 = "";
			code9 += "<table border='1' class='table table-dark'><tr><td>점수입력</td><td><input type='text' name='score'></td></tr><tr><td></td><td><input type='text' hidden value='" + memid + "' name='memid'></td></tr></table>";
			$(".modal-body").empty().append(code9)
		})
		
	})
</script>
</head>
<body>
	<div id="d1">
		<br><br>
		<select id="s1">
			<option>과목명을 선택해주세요</option>
			<!-- 동적으로 수업 추가하기 -->
		</select>
		
		<select id="s2">
			<option>강의을 선택해주세요</option>
			<!-- 동적으로 강의명 추가하기 -->
		</select>
	</div>
	
	<div id="d2">
		<br><br>
		<input type="button" value="출석관리" id="btn1" class="btn btn-danger" disabled> &nbsp;&nbsp;&nbsp;
		<input type="button" value="과제관리" id="btn2" class="btn btn-danger" disabled> &nbsp;&nbsp;&nbsp;
		<input type="button" value="성적관리" id="btn3" class="btn btn-danger" disabled> &nbsp;&nbsp;&nbsp;
		<hr>
		<h2><img src="<%=request.getContextPath()%>/images/icon/ff.png">리스트</h2>
		<table class='table table-light' id="restab">
			<tr id="restr">
				<td>학번</td>
				<td>이름</td>
				<td>핸드폰번호</td>
				<td>주소</td>
			</tr>
		</table>
		
	</div>
	
	<div id="d3">
	
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

	  <form action="<%=request.getContextPath()%>/insertTaskScore.do" method="post" id="ff">
      <!-- Modal body -->
      <div class="modal-body">
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <input type="submit" class="btn btn-danger"  value="제출">
        <input type="button" class="btn btn-danger" data-dismiss="modal" value="닫기">
      </div>
      </form>

    </div>
  </div>
</div>
</body>
</html>
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
	<% int temp = 0;%>
	$(function(){
		$.ajax({
			
			// 내가 해야할 모든 과제를 불러오는 부분
			url : "<%=request.getContextPath()%>/selectAllMyTask.do",
			method : "get",
			success : function(res){
				code = "<tr><th>과목명</th><th>과제명</th> <th>과제기한</th> <th>제출여부</th> <th></th> </tr>"
				$.each(res, function(i, v){
					code += "<tr><td>" + v.sub_name + "</td>"
					code += "<td>" + v.task_name + "</td>"
					code += "<td>" + v.task_date + "</td>"
					code += "<td>" + v.task_chk + "</td>"
					code += "<td><input type='button' value='제출' data-toggle='modal' data='" + v.task_name + "' data-target='#myModal' class='btn2 btn btn-primary'></td></tr>"
				})
				$("#tb1").append(code);
			},
			error : function(xhr){
				alert("상태 : " + xhr.status)
			},
			dataType : "json"
		})
		
		// 내가 제출했었던 과제를 불러오는 부분
		$.ajax({
			url : "<%=request.getContextPath()%>/selectOldMyTask.do",
			method : "post",
			success : function(res){
				codes = "<tr><th>과목명</th><th>과제명</th> <th>과제기한</th> <th>제출여부</th> <th></th> </tr>"
					$.each(res, function(i, v){
						codes += "<tr><td>" + v.sub_name + "</td>"
						codes += "<td>" + v.task_name + "</td>"
						codes += "<td>" + v.task_date + "</td>"
						codes += "<td>" + v.task_chk + "</td>"
						codes += "<td><input type='button' value='상세보기' data-toggle='modal' data='" + v.task_name + "' data-target='#myModal' class='btn4 btn btn-primary'></td></tr>"
					})
					$("#tb2").append(codes);
			},
			error : function(xhr){
				alert("상태 : " + xhr.status)
			},
			dataType : "json"
			
		})
		
		// 제출했었던 과제의 상세보기 버튼 이벤트
		$("#tb2").on("click", ".btn4", function(){
			subname = $(this).attr("data");
			$.ajax({
				url : "<%=request.getContextPath()%>/selectOldMyTask.do",
				method : "post",
				success : function(res){
					codes2 = "<tr><th>과목명</th><th>과제명</th> <th>과제기한</th> <th>제출여부</th> <th></th> </tr>"
						$.each(res, function(i, v){
							codes2 += "<tr><td>" + v.sub_name + "</td>"
							codes2 += "<td>" + v.task_name + "</td>"
							codes2 += "<td>" + v.task_date + "</td>"
							codes2 += "<td>" + v.task_chk + "</td>"
							codes2 += "<td></td></tr>"
								codes2 += "<tr><td>" + v.task_title + "</td>"
								codes2 += "<td>" + v.task_comt + "</td>"
								codes2 += "<td>" + v.path + "</td>"
								codes2 += "<td></td>"
								codes2 += "<td></td></tr>"							
						})
						$("#tb33").html(codes2);
					
				},
				error : function(xhr){
					alert("상태 : " + xhr.status)
				},
				dataType : "json"
			})
			
		})
		
		// 제출버튼 클릭 이벤트
		$("#tb1").on("click", ".btn2", function(){
			subname = $(this).attr("data")
			codess = "<tr><td>제목></td><td><input type='text' name='title'></td></tr><td>내용</td><td><textarea cols='' rows='' name='cont'></textarea></td></tr><tr><td>첨부파일</td><td><input type='file' name='file'></td><td hidden='hidden' id='htd'><input type='text' name='subname' id='hin'></td></tr>";
			$("#tb33").html(codess);
			$("#hin").attr("value", subname);
		})
	})
</script>
</head>
<body>
	<h2><img src="<%=request.getContextPath()%>/images/icon/ii.png">나의 과제</h2>
	<table id="tb1" class="table table-light" border="1">

    </table>
    
    <hr>
    
    <h2><img src="<%=request.getContextPath()%>/images/icon/jj.png">점수 및 제출 현황</h2>
    <table id="tb2" class="table table-light" border="1">
    
    </table>

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
        <form action="<%=request.getContextPath()%>/insertTask.do" method="get">
        <div class="modal-body">
        	<table class="table table-light" id="tb33">
        		<tr>
        			<td>제목</td>
        			<td><input type="text" name="title"></td>
        		</tr>
        		<tr>
        			<td>내용</td>
        			<td><textarea cols="" rows="" name="cont"></textarea></td>
        		</tr>
        		<tr>
        			<td>첨부파일</td>
        			<td><input type="file" name="file"></td>
        			<td hidden="hidden" id="htd"><input type="text" name="subname" id="hin"></td>
        		</tr>
        	</table >


        	
        		
        
        	
        	
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <input type="submit" class="btn btn-danger" value="제출">
         
          <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
        </div>
        </form>
        
      </div>
    </div>
  </div>
  

    
</body>
</html>
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
		
		
		// 강의평가가 필요한 과목들을 불러오는 부분
		$.ajax({
			url : "<%=request.getContextPath()%>/ClassComent.do",
			method : "post",
			success : function(res){
				code = "<table border='1' class='table table-light'><tr><td>과목명</td><td>상황</td><td></td></tr>"
				$.each(res, function(i, v){
					code += "<tr><td>" + v.sub_name + "</td> <td>" + v.status + "</td>";
					code += "<td><input type='button' data='" + v.sub_name + "' class='btn btn-primary goco' data-toggle='modal' data-target='#myModal' value='등록'></td></tr>"
				})
				code += "</table>"
				$("#d1").append(code);
			},
			error : function(xhr){
				alert("상태 : " + xhr.status)
			},
			dataType : "json"
		})
		
		
		// 불러진 리스트 우측에 등록 버튼 이벤트
		$("#d1").on("click", ".goco", function(){
	
			subname = $(this).attr("data");
			$.ajax({
				url : "<%=request.getContextPath()%>/submitComent.do",
				method : "get",
				data : {
					"subname" : subname
				},
				success : function(res){
					cosole.log(res.gg);
				},
				error : function(xhr){
					alert("상태 : " + xhr.stauts)
				},
				dataType : "json"
			})
		})
		
		$("#sub0").on("click", function(){
			location.href="<%=request.getContextPath()%>/work_psj/classComent/index.jsp";
			alert("제출되었습니다.");
		})
		
	})
	
	
</script>
</head>
<body>
	<h2>강의평가</h2>
	<div id="d1"></div>
	
	

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
        <div class="modal-body">
         	<form>
         		<table border="1">
         			<tr>
         				<td>제목</td>
         				<td>체크해주세요</td>
         			</tr>
         			
         			<tr>
         				<td>1. 항목</td>
         				<td>
         					매우 만족<input type="checkbox">
         					만족<input type="checkbox">
         					보통<input type="checkbox">
         					불만족<input type="checkbox">
         					매우 불만족<input type="checkbox">	
         				</td>
         			</tr>
         			<tr>
         				<td>1. 항목</td>
         				<td>
         					매우 만족<input type="checkbox">
         					만족<input type="checkbox">
         					보통<input type="checkbox">
         					불만족<input type="checkbox">
         					매우 불만족<input type="checkbox">	
         				</td>
         			</tr>
         			<tr>
         				<td>1. 항목</td>
         				<td>
         					매우 만족<input type="checkbox">
         					만족<input type="checkbox">
         					보통<input type="checkbox">
         					불만족<input type="checkbox">
         					매우 불만족<input type="checkbox">	
         				</td>
         			</tr>
         			<tr>
         				<td>1. 항목</td>
         				<td>
         					매우 만족<input type="checkbox">
         					만족<input type="checkbox">
         					보통<input type="checkbox">
         					불만족<input type="checkbox">
         					매우 불만족<input type="checkbox">	
         				</td>
         			</tr>
         			<tr>
         				<td>1. 항목</td>
         				<td>
         					매우 만족<input type="checkbox">
         					만족<input type="checkbox">
         					보통<input type="checkbox">
         					불만족<input type="checkbox">
         					매우 불만족<input type="checkbox">	
         				</td>
         			</tr>
         		</table>
         			
         	</form>
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-danger" data-dismiss="modal" id="sub0">제출</button>
          <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
        </div>
        
      </div>
    </div>
  </div>
  
	
</body>
</html>


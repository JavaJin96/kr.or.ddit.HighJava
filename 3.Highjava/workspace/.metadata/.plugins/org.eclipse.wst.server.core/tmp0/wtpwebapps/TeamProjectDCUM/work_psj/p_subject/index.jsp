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
	function test(){
		$.ajax({
			// 수강신청 진행중인 과목 불러오기
			url : "<%=request.getContextPath()%>/selectInSubject.do",
			method : "post",
			success : function(res){
					code2 = "<h3><img id='icon'src='<%=request.getContextPath()%>/images/icon/gg.png'>수강신청 진행중 과목</h3><hr>";
				$.each(res, function(i, v){
					code2 += "<tr><td><input class='sss' type=text hidden value='" + v.sub_num + "'>" + v.sub_num + "</td>";
					code2 += "<td>" + v.sub_name + "</td>";
					code2 += "<td>" + v.sub_cnt + "</td>";
					code2 += "<td><input type='button' value='수강신청자 보기' data='" + v.sub_num + "' class='btn btn-danger view' data-toggle='modal' data-target='#myModal'></td>";
					code2 += "<td><input type='button' value='삭제' data='" + v.sub_num + "' class='btn btn-danger delbtn'></td></tr>";
				})
				$("#restab").html(code2);
			},
			error : function(xhr){
				alert("상태 : " + xhr.status);
			},
			dataType : "json"
		})
		
	}
	
	$(function(){
		test();
		// 수강신청 취소(삭제) 이벤트
		$("#restab").on("click", ".delbtn", function(){
			subnum = $(this).attr("data");
			$.ajax({
				url : "<%=request.getContextPath()%>/deleteSubject.do",
				data : {
					"subnum" : subnum
				},
				method : "post",
				success : function(res){
					if(res.sw == "성공"){
						alert("삭제되었습니다.");
						test();
						
					}else{
						alert("오류가 발생했습니다.")
					}
		
				},
				error : function(xhr){
				alert("상태 : " + xhr.status);
				},
				dataType : "json"
			})
				

		})
		
		// 수강신청자 보기 및 승인 창 이벤트
		$("#restab").on("click", ".view", function(){
			vsubnum = $(this).attr("data");
			$.ajax({
				url : "<%=request.getContextPath()%>/cistu.do",
				data : {
					"subnum" : vsubnum
				},
				method : "post",
				success : function(res){
					code3 = "";
					$.each(res, function(i, v){
						code3 += "<tr><td>" + v.sub_name + "</td>";
						code3 += "<td>" + v.sub_num + "</td>";
						code3 += "<td>" + v.mem_id + "</td>";
						code3 += "<td>" + v.mem_name + "</td></tr>";
					})
					$("#rres").empty().append(code3);
				},
				error : function(xhr){
					alert("상태 : " + xhr.status)
				},
				dataType : "json"
				
			})
		})
		
		// 승인버튼 눌렀을 때 이벤트
		$("#bbtn").on("click", function(){
			vvsubnum = $(".sss").val();
			$.ajax({
				url : "<%=request.getContextPath()%>/confirmStu.do",
				method : "post",
				data : {
					"subnum" : vvsubnum
				},
				success : function(res){
					test();
					
				},
				error : function(xhr){
					alert("상태 : " + xhr.status)
				},
				dataType : "json"
			})
		})
		

		// 수강 개설 버튼 눌렀을 때 이벤트
		$("#btn1").on("click", function(){
			subnum = $("#subnum").val();
			subname = $("#subname").val();
			cnt = $("#cnt").val();
			$.ajax({
				url : "<%=request.getContextPath()%>/insertSubject.do",
				method : "post",
				data : {
					"subnum" : subnum,
					"subname" : subname,
					"cnt" : cnt
				},
				success : function(res){
					code = "<tr><td>" + res.sub_num + "</td>";
					code += "<td>" + res.sub_name + "</td>";
					code += "<td>" + res.sub_cnt + "</td>"
					code += "<td><input type='button' value='수강신청자 보기' data='" + res.sub_num + "' class='btn btn-danger view' data-toggle='modal' data-target='#myModal'></td>"
					code += "<td> <input type='button' value='삭제' data='" + res.sub_num + "' class='btn btn-danger delbtn'></td></tr>";
					$("#restab").append(code);
					$("#subnum").val("");
					$("#subname").val("");
					$("#cnt").val("");
					alert("정상 등록되었습니다.")
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
	<div id="d1">
		<table class='table table-light' id="iptab">
			<tr>
				<td><a>과목코드</a></td>
				<td><a>과목명</a></td>
				<td><a>수강인원</a></td>
				<td><td>
			</tr>
			
			<tr>
				<td> <input type="text" name="subnum" id="subnum"></td>
				<td> <input type="text" name="subname" id="subname"></td>
				<td> <input type="text" name="cnt" id="cnt"></td>
				<td> <input type="button" value="등록" class="btn btn-danger" id="btn1"></td>
			</tr>
		</table>
	</div>
	
	<div>
		<table class='table table-light' id="restab">
			<tr>
				<td><a>과목코드</a></td>
				<td><a>과목명</a></td>
				<td><a>수강인원</a></td>
			</tr>
			

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
      <div class="modal-body">
			<table class='table table-light' id='rres'>
				
			</table>
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal" id="bbtn">승인</button>
        <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
      </div>

    </div>
  </div>
</div>
	
	
</body>
</html>
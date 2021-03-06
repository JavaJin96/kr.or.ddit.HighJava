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
<script>
	$(function(){
		number = "";
		
		$.ajax({
			
			// select에 과목 넣어주는 이벤트
			url : "<%=request.getContextPath()%>/Subjectlist.do",
			method : "post",
			success : function(res){
				code77 = "<option class='o1'>과목을 선택하세요</option>";
				$.each(res, function(i, v){
					code77 += "<option class='o1'>" + v.sub_name + "</option>"
				})
				$("#s1").html(code77)
			},
			error : function(xhr){
				alert("상태 : " + xhr.status)
			},
			dataType : "json"
		})
		
		// select가 선택되었을 때 이벤트
		$("#s1").on("change", function(){
			data = $(this).val();
			
			$.ajax({
				url : "<%=request.getContextPath()%>/Subjectlist2.do",
				data : {"data" : data},
				method : "post",
				success : function(res){
					code88 = "<option class='o1'>과목을 선택하세요</option>";
					$.each(res, function(i,v){
						code88 += "<option class='o2'>" + v.class_name + "</option>"
					})
					$("#s2").html(code88);
				},
				error : function(xhr){
					alert("상태 : " + xhr.status)
				},
				dataType : "json"
			})
		})
		
		// 질의응답 글 불러오는 이벤트
		$.ajax({
			url : "<%=request.getContextPath()%>/SelectQna.do",
			method : "post",
			success : function(res){
				code = "";
				codes = "";
				
				<%
				MemberVO vo = (MemberVO)session.getAttribute("loginUser");
				String loginName = vo.getMem_name();
				%>
				
				$.each(res, function(i,v){
					
					code += "<tr class='cont' ><td class='cc'>" + v.board_num + "</td>";
					code += "<td>" + v.board_title + "</td>";
					code += "<td>" + v.board_writer + "</td>";
					code += "<td>" + v.board_date + "</td><br><br><br><br>";
					code += "<td><input type='button' value='상세보기' data='" + v.board_num + "' class='btns btn btn-danger' data-toggle='modal' data-target='#myModal'></td></tr>"
					
					
					codes += "<tr class='cont' data-toggle='modal' data-target='#myModal'><td class='dd'>" + v.board_num + "</td>";
					codes += "<tr><td>제목</td><td>" + v.board_title + "</td></tr>";
					codes += "<tr><td>내용</td><td>" + v.board_cont + "</td></tr>";
					codes += "<tr><td>작성자</td><td>" + v.board_writer + "</td></tr>";
					
					
				})
				number = $('.cont .cc').text();
				$("#tab1").append(code);
				$("#tab2").append(codes);
			},
			error : function(xhr){
				alert("상태 : " + xhr.status);
			},
			dataType : "json"
		})
		
		
		$("#tab1").on("click", ".btns", function(){
			boardnum = $(this).attr("data");
			$.ajax({
				url : "<%=request.getContextPath()%>/SelectQna.do",
				method : "post",
				success : function(res){
					codes = "";
					$.each(res, function(i,v){
						
						if(v.board_num == boardnum){
							codes += "<form><tr class='cont' data-toggle='modal' data-target='#myModal'><td class='dd bn' data='"+v.baord_num+"'>" + v.board_num + "</td>";
							if(<%= "\"" +loginName +"\"" %> == v.board_writer){
 								codes += "<td><input type='button' class='modify btn btn-danger' data='" + v.board_num + "' value='수정' >"
								codes += "<input type='button' class='delete btn btn-danger' data='" + v.board_num + "' value='삭제'></td>" 
/* 								codebt += "<input type='button' class='modify btn btn-danger' data='" + v.board_num + "' value='수정' >"
								codebt += "<input type='button' class='delete btn btn-danger' data='" + v.board_num + "' value='삭제'>" */
							}
							codes += "<tr><td>제목</td><td data='"+v.board_title+"' class='title'>" + v.board_title + "</td></tr>";
							codes += "<tr><td>내용</td><td data='"+v.board_cont+"' class='cont'>" + v.board_cont + "</td></tr>";
							codes += "<tr><td>작성자</td><td data='"+v.board_writer+"' class='writer'>" + v.board_writer + "</td></tr></form>";	
						
						}
						
					})
					number = $('.cont .cc').text();
					$("#tab2").html(codes);
					//$(".modal-body").append(codebt);
					
				},
				error : function(xhr){
					alert("상태 : " + xhr.status);
				},
				dataType : "json"
			})
			
			// 댓글 불러오기
			$.ajax({
				url : "<%=request.getContextPath()%>/selectRe.do",
				method : "post",
				data : {
					"boardnum" : boardnum
				},
				success : function(res){
					codet = "<table border='1' class='table table-dark' id='tab55'>";
					codet += "<tr><td>작성자</td><td>내용</td><td>작성일</td></tr>";
					$.each(res, function(i, v){
						codet += "<tr><td>" + v.re_writer + "</td>";
						codet += "<td>" + v.re_cont + "</td>";
						codet += "<td>" + v.re_date + "</td></tr>";
					})
					codet += "</table>"
					$("#tab55").remove();
					$(".modal-body").append(codet);
					//history.back();
				},
				error : function(xhr){
					alert("상태  : " + xhr.status)
				},
				dataType : "json"
			}) 
		})
		
		
		$("#btn").on("click", function(){
			
		/*  location.href = "<%=request.getContextPath()%>/work_psj/qnaboard/insertqna.jsp"; */
		
		
		
		})
		
		// 상세보기 버튼 클릭시 이벤트
 		$("#btn3").on("click", function(){
 			recode = "";
 			recode += "<br><br>";
 			recode += "<form action='<%=request.getContextPath()%>/insertRep.do' method='get'> ";
 			recode += "<textarea cols='55' rows='7' name='cont'></textarea><br><br>";
 			recode += "<input type='text' name='bonum' hidden  id='hh' value='" + $('.cont .dd').text() + "'> "
 			recode += "<input type='submit' value='답글달기' class='btn btn-danger'>";
 			recode += "</form>"
 			
 			
 			$(".modal-body").append(recode);
 			

		})  
		
	$("#tab2").on("click" , ".modify", function(e){
// 		e.preventDefault();
		e.stopPropagation()

		
		$.ajax({
				url : "<%=request.getContextPath()%>/SelectQna.do",
				method : "post",
				success : function(res){
					modifyForm = "";
					$.each(res, function(i,v){
						
						if(v.board_num == boardnum){
							modifyForm += "<tr class='cont' data-toggle='modal' data-target='#myModal'><td class='dd bn' data='"+v.baord_num+"'>" + v.board_num + "</td>";
							if(<%= "\"" +loginName +"\"" %> == v.board_writer){
								modifyForm += "<td><input type='submit' class='modify btn btn-danger' data='" + v.board_num + "' value='수정완료' ></td>"
/* 								codebt += "<input type='button' class='modify btn btn-danger' data='" + v.board_num + "' value='수정' >"
								codebt += "<input type='button' class='delete btn btn-danger' data='" + v.board_num + "' value='삭제'>" */
							}
							modifyForm += "<tr><td>제목</td> <td><input type='text' name='title' value='"+v.board_title+"'></td></tr>";
							modifyForm += "<tr><td>내용</td> <td><input type='text' name='cont' value='"+v.board_cont+"'></td></tr>";
							modifyForm += "<tr><td>작성자</td><td data='"+v.board_writer+"' class='writer'>" + v.board_writer + "</td></tr>";	
							modifyForm += "<tr> <td><input type='text' hidden name='boardnum' value='" + v.board_num + "'></td></tr>";
						
						}
						
					})
					number = $('.cont .cc').text();
					$("#tab2").html(modifyForm);
					//$(".modal-body").append(codebt);
					
				},
				error : function(xhr){
					alert("상태 : " + xhr.status);
				},
				dataType : "json"
			})
			
<%-- 			$.ajax({
				url : "<%=request.getContextPath()%>/work_psj/qnaboard/modify.jsp",
				data : "",
				method : "",
				success : function(res){
					
				},
				error : function(xhr){
					alert("상태 : " + xhr.status);
				},
				dataType : "json"
			})  --%>
			
			/*location.href = "<%=request.getContextPath()%>/work_psj/qnaboard/modify.jsp";  */
		})
		
		
		$("#tab2").on("click" , ".delete", function(){
			boardnum = $(this).attr("data");
			$.ajax({
				url : "<%=request.getContextPath()%>/qnaBoardDelete.do",
				data : {
					"boardNum" : boardnum
				},
				method : "get",
				success : function(res){
					location.href = "<%=request.getContextPath()%>/work_psj/qnaboard/index.jsp";
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
		<h2><img src=<%=request.getContextPath()%>/images/icon/hh.png>질의응답 게시판</h2><br>
		<select>
			<option>전체</option>
			<option>제목</option>
			<option>작성자</option>
			<option>내용</option>
		</select>
		<input type="text" value="검색">
		<input type="button" value="검색" id="btn2" class="btn btn-danger">
		<input type="button" value="글등록" id="btn" class="btn btn-danger" data-toggle='modal' data-target='#myModal2'><br><br>
		
		<table border='1' class='table table-light' id="tab1">
			<tr>
				<td>글번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>작성일</td>
			</tr>
		</table>
	</div>
	
	<div class="container">
  		<ul class="pagination">
    		<li class="page-item"><a class="page-link" href="#">1</a></li>
  		</ul>
	</div>
	
	<div class="modal" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">질문글 상세보기</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
        	<form action='<%=request.getContextPath()%>/qnaModify.do' method='get'>
        		<table class='table table-light' id="tab2">

				</table>
			</form>
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-danger"  id="btn3" >답변달기</button>
          <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
        </div>
        
      </div>
    </div>
  </div>
  
  
  

<!-- The Modal -->
<div class="modal" id="myModal2">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">질문글 등록하기</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <form action="<%=request.getContextPath()%>/insertQna.do" method="get">
      <!-- Modal body -->
      <div class="modal-body">
      	<h4>제목</h4>
		<input type="text" name="title"><hr>
		<h4>질문 카테고리 선택</h4>
		<select id="s1" name="subject">
			<option>과목을 선택하세요</option>
		</select> <br>
		<select id="s2" name="class">
			<option>수업을 선택하세요</option>
		</select> <hr>
		<h4>내용</h4>
		<textarea rows="10" cols="30" name="cont"></textarea><br><br>
		
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <input type="submit" class="btn btn-danger" value='등록'>
        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
      </div>
	</form>

    </div>
  </div>
</div>

<!-- Fading modal -->
<div class="modal fade"></div>

<!-- Modal without animation -->
<div class="modal"></div>
  
  
</body>
</html>
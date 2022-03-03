<%@page import="kr.or.ddit.dcum.vo.StudyVO"%>
<%@page import="kr.or.ddit.dcum.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>

<!-- 게시글 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<style>
	#title{
		width : 550px;
		border : none;
	}
	
	input:focus{
		outline:none;
	}
	
	.content:focus {
  		outline: none;
	}
	
	.content {
  		resize: none;
  		border : none;
	}
</style>

<script>
<% 
	MemberVO loginMember = (MemberVO)session.getAttribute("loginUser");
%>

$(function(){
	//작성 버튼
	$('#insertStudy').on('click', function(){
		var str = $('#cont').val();
		str = str.replace(/(?:\r\n|\r|\n)/g, '<br/>');
		$('#cont').val(str);
	})
	
	//취소 버튼
	$('#back').on('click', function(){
		location.href="<%=request.getContextPath()%>/study.do";
	})
	
	//$('#cont').val().replace(/\n/g, "<br>");
	
})
</script>

</head>
<body>
	
	<div class="container">
	<h2>스터디</h2>
	<p>스터디게시판 입니다.</p>
		<form action="<%=request.getContextPath()%>/insertStudy.do" mothod="get">          
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>
							<select id="selectBox" name="sb_sort">
								<option value="모집">모집중</option>
								<option value="모집완료">모집완료</option>
							</select>
						</th>
					</tr>
				
					<tr>
						<th><input type="text" id="title" name="sb_title" placeholder="제목 입력"></th>
					</tr>
				</thead>
				
				<tbody>
					<tr>
						<td>
							<input type="hidden" value="<%=loginMember.getMem_name() %>" name="sb_writer">
							<input type="hidden" value="<%= loginMember.getMem_id() %>" name="mem_id">
							<textarea class="content" id="cont" name="sb_cont" rows="25" cols="150" placeholder="내용 입력"></textarea>
						</td>
					</tr>
					
					<tr>
						<td>
							정원 : <input type="number" name="total_cnt" min="1" max="10" value="">
						</td>
					</tr>
					
					<tr>
						<td>
							<input type="submit" value="확인" id="insertStudy">
							<input type="button" value="취소" id="back">
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
		
</body>
</html>
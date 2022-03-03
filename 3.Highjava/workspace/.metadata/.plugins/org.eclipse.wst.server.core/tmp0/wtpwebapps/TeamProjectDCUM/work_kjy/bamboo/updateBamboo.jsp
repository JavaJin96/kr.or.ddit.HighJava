<%@page import="kr.or.ddit.dcum.vo.MemberVO"%>
<%@page import="kr.or.ddit.dcum.vo.BambooVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="http://localhost/test/css/test.css">

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
	BambooVO bamVo = (BambooVO)request.getAttribute("bambooVo");
	MemberVO loginMember = (MemberVO)session.getAttribute("loginUser");
%>

$(function(){
	//수정 버튼
	$('#updateBamboo').on('click', function(){
		var str = $('#cont').val();
		str = str.replace(/(?:\r\n|\r|\n)/g, '<br/>');
		$('#cont').val(str);
	})

	//취소 버튼
	$('#back').on('click', function(){
		history.back();
	})
	
	//$('#cont').val().replace(/\n/g, "<br>");
	
})
</script>

</head>
<body>
	
	<div class="container mt-3">
	<h2>대나무숲</h2>
	<p>익명게시판 입니다.</p>
	
		<form action="<%=request.getContextPath()%>/updateBamboo.do" method="post">
			<input type="hidden" id="sec_num" name="sec_num" value="<%= bamVo.getSec_num() %>">   
			<input type="hidden" name="mem_id" value="<%= loginMember.getMem_id() %>">
		       
			<table class="table table-bordered">
				<thead>
					<tr>
						<th><input type="text" id="title" name="sec_title" value="<%= bamVo.getSec_title() %>"></th>
					</tr>
				</thead>
				
				<tbody>
					<tr>
						<td>
							<textarea class="content" id="cont" name="sec_cont" rows="25" cols="150"><%= bamVo.getSec_cont() %></textarea>
							<input type="hidden" id="writer" name="sec_writer" value="<%= bamVo.getSec_writer() %>">
						</td>
					</tr>
				</tbody>
			</table>
			<input type="submit" value="확인" id="updateBamboo">
			<input type="button" value="취소" id="back">
		</form>
		
	</div>
</body>
</html>
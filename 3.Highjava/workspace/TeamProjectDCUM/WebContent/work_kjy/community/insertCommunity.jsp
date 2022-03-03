<%@page import="kr.or.ddit.dcum.vo.MemberVO"%>
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
	MemberVO loginMember = (MemberVO)session.getAttribute("loginUser");
%>
$(function(){
	
	//글 입력시 줄바꿈
	$('#insertCommu').on('click', function(){
		var str = $('#cont').val();
		str = str.replace(/(?:\r\n|\r|\n)/g, '<br/>');
		$('#cont').val(str);
	})
	
	//취소 버튼
	$('#back').on('click', function(){
		location.href="<%=request.getContextPath()%>/community.do";
	})
	
	//말머리 추가
<%-- 	$('#selectBox').val('<%=  %>') --%>
		
// 	})
	
	
	//$('#cont').val().replace(/\n/g, "<br>");
	
})
</script>

</head>
<body>
	
	<div class="container">
	<h2>커뮤니티</h2>
	<p>커뮤니티게시판 입니다.</p>
		<form action="<%=request.getContextPath()%>/insertCommunity.do" mothod="post">          
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>
							<select id="selectBox" name="cmu_sort">
								<option value="전체" selected="selected">전체</option>
								<option value="질의응답">질의응답</option>
								<option value="비교과">비교과</option>
								<option value="물물교환">물물교환</option>
							</select>
						</th>
					</tr>
					
					<tr>
						<th><input type="text" id="title" name="cmu_title" placeholder="제목 입력"></th>
					</tr>
				</thead>
				
				<tbody>
					<tr>
						<td>
							<textarea class="content" id="cont" name="cmu_cont" rows="25" cols="150" placeholder="내용 입력"></textarea>
							<input type="hidden" id="writer" name="cmu_writer" value="<%= loginMember.getMem_name() %>">
							<input type="hidden" id="id" name="mem_id" value="<%= loginMember.getMem_id() %>">
						</td>
					</tr>
					
					<tr>
						<td>
							<input type="submit" value="확인" id="insertCommu">
							<input type="button" value="취소" id="back">
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
		
</body>
</html>
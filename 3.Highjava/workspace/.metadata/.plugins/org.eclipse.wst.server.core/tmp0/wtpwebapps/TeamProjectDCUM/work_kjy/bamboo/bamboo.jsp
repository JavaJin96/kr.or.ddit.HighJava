<%@page import="kr.or.ddit.dcum.vo.BambooVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ddit cyber university</title>

<!-- 게시판 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/cmu_board.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<script>
<%
	List<BambooVO> bamboo = (List<BambooVO>)request.getAttribute("bambooList");
%>
	//게시글 등록
	$(function(){
		$('#bambooForm').on('click', function(){
			location.href="<%=request.getContextPath()%>/bambooForm.do";
		})
	})
</script>
</head>
<body>
<br>	
	<div class="container">
	<h2>대나무숲</h2>  
	
	<!-- 검색(나중에 수정) -->
<%-- 	<form id="search" action="<%=request.getContextPath()%>/bambooSearch.do" method="get"> --%>
<!-- 		<input class="form-control mr-sm-2" type="text" placeholder="검색" name="cmu_cont"> -->
<!-- 		<input class="btn btn-success" type="submit" value="검색" id="contSearch"> -->
<!-- 	</form>       -->
	
	<p id="p1">익명게시판 입니다.</p>            

		<table class="table table-hover">
			<thead>
				<tr class="table-success">
					<th id="no">글번호</th>
					<th id="title">제목</th>
					<th id="date">날짜</th>
				</tr>
			</thead>
			<%
				for(BambooVO bvo : bamboo){
			%>
			<tbody>
		  		<tr>
					<td id="no"><%= bvo.getSec_num() %></td>
					<td id="title"><a id="title-aTag" href="<%= request.getContextPath() %>/bambooView.do?sec_num=<%= bvo.getSec_num() %>">
						<%= bvo.getSec_title() %></a></td>
					<td id="date"><%= bvo.getSec_date() %></td>
				</tr>
			</tbody>
			<% 
			}
			%>
  		</table>
  		
  		<input type="button" value="글쓰기" id="bambooForm" class="btn btn-secondary">
	</div>
	
	<div class="container">
		<ul class="pagination justify-content-center">
		    <li class="page-item"><a class="page-link" href="javascript:void(0);">1</a></li>
		    <li class="page-item"><a class="page-link" href="javascript:void(0);">Next</a></li>
    	</ul>
	</div>
	
</body>
</html>
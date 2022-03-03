<%@page import="kr.or.ddit.dcum.vo.MemberVO"%>
<%@page import="kr.or.ddit.dcum.vo.GongjiVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ddit cyber university</title>
<!-- 게시판 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/cmu_board.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script>
<%
	List<GongjiVO> Gongji = (List<GongjiVO>)request.getAttribute("gongjiList");
	MemberVO loginMember = (MemberVO)session.getAttribute("loginUser");
%>
	$(function(){
		//공지 등록
		$('#gongjiForm').on('click', function(){
			location.href="<%=request.getContextPath()%>/gongjiForm.do";
		})
	})
</script>
<style>
#search{
	float: right;
}
.form-control{
	width: 200px;
}
</style>
</head>
<body>
<br>	
	<div class="container">
	<h2>공지</h2>
	<p id="p1">학교 공지사항 게시판 입니다.</p>       
	<!-- 검색 -->
 <nav class="navbar navbar-expand-sm ">
	<form id="search" action="<%=request.getContextPath()%>/gongjiSearch.do" method="get">
		<input class="form-control mr-sm-2" type="text" placeholder="검색" name="gongji_nm">
		<input class="btn btn-success" type="submit" value="검색" id="Search">
	</form>
  </nav>    
		<table class="table table-hover">
			<thead>
				<tr class="table-danger">
					<th id="no">글번호</th>
					<th id="title">제목</th>
					<th id="date">날짜</th>
				</tr>
			</thead>
			<%
				for(GongjiVO gvo : Gongji){
			%>
			<tbody>
		  		<tr>
					<td id="no"><%= gvo.getGongji_num() %></td>
					<td id="title"><a id="title-aTag" href="<%= request.getContextPath() %>/gongjiView.do?gongji_num=<%= gvo.getGongji_num() %>">
						<%= gvo.getGongji_nm() %></a></td>
					<td id="date"><%= gvo.getGongji_date() %></td>
				</tr>
			</tbody>
			<% 
			}
			%>
  		</table>

  		<% if(loginMember != null && loginMember.getMem_sort_nm().equals("교수")) { %>
	  		<!-- 관리자만 보이게 수정 -->
	  		<input type="button" value="글쓰기" id="gongjiForm" class="btn btn-secondary" >
  		<% } %>
  		
	</div>
	
	<div class="container">
		<ul class="pagination justify-content-center">
		    <li class="page-item"><a class="page-link" href="javascript:void(0);">1</a></li>
		    <li class="page-item"><a class="page-link" href="javascript:void(0);">Next</a></li>
    	</ul>
	</div>
</body>
</html>
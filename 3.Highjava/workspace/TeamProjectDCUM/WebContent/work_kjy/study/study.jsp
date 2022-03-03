<%@page import="kr.or.ddit.dcum.vo.MemberVO"%>
<%@page import="kr.or.ddit.dcum.vo.StudyVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ddit cyber university</title>
<link rel="stylesheet" href="http://localhost/test/css/test.css">

<!-- 게시판 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/cmu_board.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>


<script>
<%
	List<StudyVO> study = (List<StudyVO>)request.getAttribute("studyList");
	MemberVO loginMember = (MemberVO)session.getAttribute("loginUser");
%>
	//게시글 등록
	$(function(){
		$('#studyForm').on('click', function(){
			location.href="<%=request.getContextPath()%>/studyForm.do";
		})
	})
</script>
</head>
<body>
<br>
	<div class="container">
	<h2>스터디 모집</h2>
	<p id="p1">스터디 모집 게시판 입니다.</p> 
		<!-- 말머리 -->
	<nav class="navbar navbar-expand-sm ">	
		<form id="sort-form" action="<%= request.getContextPath()%>/studySort.do">
			<select id="selectBox" name="sb_sort"  class="form-control mr-sm-2">
				<option value="전체">전체</option>
				<option value="모집">모집</option>
				<option value="완료">완료</option>
			</select>
			<button type="submit" id="sortSearch" class="btn btn-info">선택</button>
		</form>
		
		<!-- 검색 -->
		<form id="search" action="<%=request.getContextPath()%>/studySearch.do" method="get">
			<input class="form-control mr-sm-2" type="text" placeholder="검색" name="sb_title">
			<input class="btn btn-success" type="submit" value="검색" id="titleSearch">
		</form>
	</nav>	
	         
		<table class="table table-hover">
			<thead>
				<tr class="table-info">
					<th id="no">글번호</th>
					<th id="sort">말머리</th>
					<th id="title">제목</th>
					<th id="wr">글쓴이</th>
					<th id="date">날짜</th>
				</tr>
			</thead>
			<%
				for(StudyVO svo : study){
			%>
			<tbody>
		  		<tr>
					<td id="no"><%= svo.getSb_num() %></td>
					<td id="sort">[<%= svo.getSb_sort() %>] </td>
					<td id="title"><a id="title-aTag" href="<%= request.getContextPath() %>/studyView.do?sb_num=<%= svo.getSb_num() %>">
						<%= svo.getSb_title() %></a></td>
					<td id="wr"><%= svo.getSb_writer() %></td>
					<td id="date"><%= svo.getSb_date() %></td>
				</tr>
			</tbody>
			<% 
			}
			%>
  		</table>
  		
  		<input type="button" value="글쓰기" id="studyForm"  class="btn btn-secondary">
	</div>
	
	<div class="container">
		<ul class="pagination justify-content-center">
		    <li class="page-item"><a class="page-link" href="javascript:void(0);">1</a></li>
		    <li class="page-item"><a class="page-link" href="javascript:void(0);">Next</a></li>
    	</ul>
	</div>
</body>
</html>
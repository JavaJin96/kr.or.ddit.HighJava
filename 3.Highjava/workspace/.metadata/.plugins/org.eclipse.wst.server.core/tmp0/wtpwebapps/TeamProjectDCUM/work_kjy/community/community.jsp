<%@page import="kr.or.ddit.dcum.vo.CommunityVO"%>
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
	List<CommunityVO> commu = (List<CommunityVO>)request.getAttribute("commuList");
	String sort = (String)request.getAttribute("sort");
	if(sort==null) sort = "전체";
%>
$(function(){
	
	// $("#selectBox option[value='물물교환']").attr('selected', 'selected');
	
	 //게시글 등록
	$('#commuForm').on('click', function(){
		location.href="<%= request.getContextPath() %>/communityForm.do";
	})
	
// 	$('#selectBox').on('change', function(){
// 	      opval = $('option:selected', this).val();
// // 		 alert(opval);
		 
// 		 $('#selectBox').val(opval);
// 	})
	
   $('#sortSearch').on('click', function(){
		
	    $("#selectBox option[value=' +opval +']").attr('selected', true);
	    f = $('#sort-form');
		$(f).attr('action', '<%= request.getContextPath()%>/communitySort.do' );
		$(f).attr('method', 'get');
		$(f).submit();
	});
	
	$('#selectBox').val("<%=sort%>");	
})
</script>
</head>
<body>


<br>	
<div class="container">
  <h2>커뮤니티</h2>
  <p id="p1">물물교환 / 질의응답 / 비교과수강신청 _ 자유게시판 입니다.</p>
	<!-- 말머리 -->
  <nav class="navbar navbar-expand-sm ">
	<%-- <form id="sort-form" action="<%= request.getContextPath()%>/communitySort.do"> --%>
	 <form id="sort-form" >	
		<select id="selectBox" name="cmu_sort" class="form-control mr-sm-2">
			<option value="전체">전체</option>
			<option value="질의응답">질의응답</option>
			<option value="비교과">비교과</option>
			<option value="물물교환">물물교환</option>
		</select>
		<button type="button" id="sortSearch" class="btn btn-info">선택</button>
	</form>
	
	<!-- 검색 -->
	<form id="search" action="<%=request.getContextPath()%>/communitySearch.do" method="get">
		<input class="form-control mr-sm-2" type="text" placeholder="검색" name="cmu_cont">
		<input class="btn btn-success" type="submit" value="검색" id="contSearch">
	</form>
  </nav>
	
		<table class="table table-hover">
			<thead>
				<tr class="table-warning">
					<th id="no">글번호</th>
					<th id="sort">말머리</th>
					<th id="title">제목</th>
					<th id="date">날짜</th>
				</tr>
			</thead>
			<%
				for(CommunityVO cvo : commu){
			%>
			<tbody>
		  		<tr>
					<td id="no"><%= cvo.getCmu_num() %></td>
					<td id="sort"><%= cvo.getCmu_sort() %></td>
					<td id="title"><a id="title-aTag" href="<%= request.getContextPath() %>/communityView.do?cmu_num=<%= cvo.getCmu_num() %>">
						<%= cvo.getCmu_title() %></a></td>
					<td id="date"><%= cvo.getCmu_date() %></td>
				</tr>
			</tbody>
			<% 
			}
			%>
  		</table>
  		
  		<input type="button" value="글쓰기" id="commuForm"  class="btn btn-secondary">
	</div>
	
	<div class="container">
		<ul class="pagination justify-content-center">
		    <li class="page-item"><a class="page-link" href="javascript:void(0);">1</a></li>
		    <li class="page-item"><a class="page-link" href="javascript:void(0);">Next</a></li>
    	</ul>
	</div>
	
</body>
</html>
<%@page import="kr.or.ddit.dcum.vo.MemberVO"%>
<%@page import="kr.or.ddit.dcum.vo.GongjiVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/card.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
 <script src="../../js/jquery-3.6.0.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
</head>
<%
	List<GongjiVO> Gongji = (List<GongjiVO>)request.getAttribute("gongjiList");
	MemberVO loginMember = (MemberVO)session.getAttribute("loginUser");
%>
<style>
	div {
	}
		body{
		font-family: 'Jua', sans-serif;
	}
</style>
<body>
<h3>
	<img src="<%=request.getContextPath()%>/images/icon/스피커.PNG">
	공지사항
</h3>
<table>
			<%
				for(GongjiVO gvo : Gongji){
			%>
		  		<tr>
					<td id="no"><%= gvo.getGongji_num() %></td>
					<td id="title"><a id="title-aTag" href="<%= request.getContextPath() %>/gongjiView.do?gongji_num=<%= gvo.getGongji_num() %>">
						<%= gvo.getGongji_nm() %></a></td>
					<td id="date"><%= gvo.getGongji_date() %></td>
				</tr>
			<% 
			}
			%>
</table>
</body>
</html>
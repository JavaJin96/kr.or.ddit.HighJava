<%@page import="kr.or.ddit.baisc.json.LprodVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	List<LprodVO> list = (List<LprodVO>)request.getAttribute("list");

%>
</head>
<body>
	<h2>동기방식의 Lprod 목록 출력</h2>
	<table border='1'>
		<tr>
			<td>LPROD_ID</td>
			<td>LPROD_GU</td>
			<td>LPROD_NM</td>
		</tr>
<% 

	for(LprodVO lv : list){
%>
	<tr>
		<td><%= lv.getLprod_id() %> </td>
		<td><%= lv.getLprod_gu() %> </td>
		<td><%= lv.getLprod_nm() %> </td>
	</tr>


<%		
	}
%>
	</table>
</body>
</html>
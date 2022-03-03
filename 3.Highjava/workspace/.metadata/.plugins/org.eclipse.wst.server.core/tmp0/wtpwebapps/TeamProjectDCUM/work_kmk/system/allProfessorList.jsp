<%@page import="kr.or.ddit.dcum.vo.Temp_ProfessorVO"%>
<%@page import="kr.or.ddit.dcum.vo.temp_StudentInfoVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../css/main.css">
<!-- jquery -->
<script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<style>
h3{
	display: inline-block; 
	width: 300px;
}
#top-filter{
	float: right;
	width: 200px;
	margin-top: 15px;
}
</style>
<%
List<Temp_ProfessorVO> prolist = (List<Temp_ProfessorVO>)request.getAttribute("prolist"); 
%>
<script>
cnt = 1
$(function(){
	$('#all-filter').on('click',function(){
		$('#dep_num').hide()
		$('#status').hide()
		dep_num = $('#dn2').val();
		console.log(dep_num)
	})
	$('#dep-filter').on('click',function(){
		$('#status').hide()
		$('#dep_num').show()
	})
	$('status-filter').on('click',function(){
		$('#status').show()
		$('#dep_num').hide()
		status = $('#status').val();
		console.log(status)
	})
	
})
</script>
<body>
<div class="container">
<br>
<header>
  <h3>직원리스트</h3>
  	<select id="top-filter" >
  		<option id="all-filter">전체</option>
  		<option id="status-filter">재학여부</option>
  		<option id="dep-filter">학과별</option>
  	</select>
  	<select class='dep' name='dep_num' id='dep_num' style="display: none">
		<option value="10">컴퓨터공학과</option>
		<option value="20">전자제어과</option>
		<option value="30">산업디자인학과</option>
		<option value="40">건축학과</option>
		<option value="50">경제학과</option>
		<option value="60">일본어과</option>
		<option value="70">영문학과</option>
		<option value="80">중국어과</option>
		<option value="90">IT 비즈니스과</option>
	</select>
  	<select class='status' name='status' id='status' style="display: none">
		<option value="Y">재학</option>
		<option value="N">졸업</option>
	</select>
	<hr>
</header>
  <table class="table">
    <thead class="thead-dark">
      <tr>
        <th>순번</th>
        <th>이름</th>
        <th>학과</th>
        <th>아이디</th>
      </tr>
    </thead>
    <tbody>
 <%for(int i = 0 ; i < prolist.size() ; i++){%>
      <tr>
        <td><script type="text/javascript">document.write(cnt++)</script></td>
        <td><%=prolist.get(i).getMem_name()%></td>
        <td><%=prolist.get(i).getDep_name()%></td>
        <td><%=prolist.get(i).getMem_id()%></td>
      </tr>
 <%}%>
    </tbody>
  </table>
</div>

</body>
</html>

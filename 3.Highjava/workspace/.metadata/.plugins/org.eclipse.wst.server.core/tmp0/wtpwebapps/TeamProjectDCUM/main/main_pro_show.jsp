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
<style>
	body{
		font-family: 'Jua', sans-serif;
	}
	.table{
		width : 90%;
	}
	.menu{
		width : 120px;
	}
	div {
	}
	#d1, #d3{
		display : inline-block;
		float : left;
		width : calc(99.5% - 400px);
		height : 500px;				
	}
	#d2, #d4{
		display : inline-block;
		float : left;
		width : 400px;
		height : 500px;
		padding: 1% 3% 0;
	}
	#d1frame{
		width : 100%;
		height : 500px;
	}
	iframe{
		border : 0px;
	}
	#d3{
		padding-top: 1%; 
	}

</style>
<body>
	<div id="d1">
		<iframe id="d1frame" src="<%=request.getContextPath()%>/work_psj/p_manageStudent/index.jsp"></iframe>
	</div>
	
	<div id="d2">
		<iframe id="d1frame" src="<%=request.getContextPath()%>/sideGongji.do"></iframe>
	</div>
	
	<div id="d3">
		<iframe id="d1frame" src="<%=request.getContextPath()%>/work_psj/Test/index.jsp"></iframe>
	</div>
	
	<div id="d4">
		<iframe id="d1frame" src="<%=request.getContextPath()%>/work_psj/iframe_psj/getwork.jsp"></iframe>
	</div>
</body>
</html>
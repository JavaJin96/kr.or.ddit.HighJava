<%@page import="kr.or.ddit.dcum.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<style>
/* #d1,#d2, iframe{ */
/* 	width : 98%; */
/* 	height : 80px; */
/* 	margin : 1px; */
/* 	padding : 5px; */
/* 	overflow: auto; */
/* } */
#d1{
	margin-top: 10px;
/* 	height : 200px; */
	font-size: 1.5em;
	font-weight:bold; 
}
#d2{
	height : 500px;
}
iframe{
	height : 460px;
/* 	background : black; */
width : 98%;
}
#d3{
/* 	height : 200px; */
	overflow: hidden;
}
img{
	width : 250px;
	height : 200px;
	border: 1px solid;
}
#gopro{
	font-size : 20px;
}
.cs{
	width : 300px;
}
#clatab{
	margin-top : 160px;
}


</style>
<script>
$(function(){
	subName = "";
	// session에서 subName을 가져오기 위한 ajax
 	$.ajax({
		url : "<%=request.getContextPath()%>/ClassInfo.do",
		method : "post",
		success : function(res){
		    subName = res.subName
			$("#d1").html(res.subName);
		    
		    <%
		    MemberVO vo = (MemberVO)session.getAttribute("loginUser");
		    if (vo.getMem_sort_num().equals("2")){
		    %>
			$("#d1").append("<br><br><input type='button' value='교수업무' id='gopro' class='btn btn-danger'><br>");		    	
		    <%
		    }
		    %>
		    
		},
		error : function(xhr){
			alert("상태 : " + xhr.status)
		},
		dataType : "json"
	}) 
	
	
	
	
	
	// 강의공지사항을 가져오는 ajax
	$.ajax({
		url : "<%=request.getContextPath()%>/ClassNotice.do",
		method : "post",
		success : function(res){
			code = "";
			code += "<table border='1' class='table table-light'>";
			code += "<tr><h2>공지사항</h2></tr>";
			code += "<tr><td>글번호</td><td>글제목</td><td>글내용</td><td>작성일</td><td>작성자</td></tr>";
			$.each(res, function(i, v){
			 	code += "<tr><td>" + v.board_num + "</td>";
			 	code += "<td>" + v.board_title + "</td>";
			 	code += "<td> " + v.board_cont + "</td>";
			 	code += "<td>" + v.board_date + "</td>";
			 	code += "<td>" + v.mem_id + "</td></tr>";
			})
			code += "</table>";
			$("#d3").html(code);
		},
		error : function(xhr){
			alert("상태 : " + xhr.status)
		},
		dataType : "json"
	})
	
	
	
	
	
	// subName을 이용해 Class의 세부사항들을 가져오기 위한 ajax
	
	$.ajax({
		url : "<%=request.getContextPath()%>/detailClass.do",
		method : "post",
		success : function(res){
			code = " <table borde='1' id='clatab'><tr>";
			$.each(res, function(i, v){
				code += "<td class='font cs'><img src='../../images/classImage/파이썬 썸네일.png' alt='임시'></td>"
			})	
			code += "</tr>"
			$.each(res,function(i, v){
				code += "<td class='font cs2'>" + v.class_name + "</td>"
			})
			code += "</tr></table>"
			$("#d2").html(code);
			
		},
		error : function(xhr){
			alert("상태 : " + xhr.status)
		},
		dataType : "json"
	})
	
	
	
	// 해당 강의 td부분을 클릭해 동영상 플레이어를 호출하는 부분
	$("#d2").on("click", ".cs2", function(){
		tvalue = $(this).text();
		$.ajax({
			url : "<%=request.getContextPath()%>/viewClass.do",
			data : {
				"className" : tvalue 
			},
			method : "post",
			success : function(res){
				code = "<iframe src='" + res.path + "'>";
				$("#d1").append("<br>" + tvalue);
				$("#d2").html(code);
				$("#d3").html("질의응답");
		
				$.ajax({
					url : "<%=request.getContextPath()%>/classQna.do",
					method : "post",
					data : {
						"className" : tvalue
					},
					success : function(res2){
						codes = "<h2>질의응답</h2>";
						codes += "<table border='1' class='table table-light'>";
						codes += "<tr><td>번호</td><td>제목</td><td>내용</td><td>작성자</td><td>게시일</td></tr>";
						$.each(res2, function(i,v) {
							codes += "<tr class='cont' data-toggle='modal' data-target='#myModal'><td class='cc'>" + v.board_num + "</td>";
							codes += "<td>" + v.board_title + "</td>";
							codes += "<td>" + v.board_cont + "</td>";
							codes += "<td>" + v.board_writer + "</td>";
							codes += "<td>" + v.board_date + "</td></tr>";
						})
						codes += "</table>"
						$("#d3").html(codes);
						alert("해당 강의는 15초 이상 수강해야 출석체크가 완료됩니다.");
						setInterval(() => {
							$.ajax({
								url : "<%=request.getContextPath()%>/chkIn.do",
								data : {
									"className" : tvalue
								},
								method : "post",
								success : function(res){
									if(res.sw == 1){
									alert("출석체크가 완료되었습니다.");										
									}
								},
								error : function(xhr){
									alert("상태 : " + xhr.status)
								},
								dataType : "json"
							})
						}, 15000);
						/* 출석체크 원래는  2400000*/
					},
					error : function(xhr){
						alert("상태 : " + xhr.status)
					},
					dataType : "json"
				})
			},
			error : function(xhr){
				
			},
			dataType : "json"
		})
		

	})
	
	// 교수업무 버튼을 클릭시 교수의 업무버튼 생성
	$("#d1").on("click", "#gopro", function(){
		code = "<div id='d4'>"
		code += "<input type='button' value='과제등록' id='iw1' class='btn btn-primary' data-toggle='modal' data-target='#myModal'>"
		code += "<input type='button' value='강의등록' id='iw2' class='btn btn-primary' data-toggle='modal' data-target='#myModal'>"
		code += "<input type='button' value='공지사항등록' id='iw3' class='btn btn-primary' data-toggle='modal' data-target='#myModal'>"
		code += "</div>"
		$("body").append(code);
	})
	
	// 교수 업무버튼 클릭시 이벤트
	// 과제등록버튼
	$("body").on("click", "#iw1", function(){
		$("#ff").attr("action", "<%=request.getContextPath()%>/insertTaskp.do");
		$("#ff").attr("enctype", "");
		codeh = "<table border='1' class='table table-light'>"
		codeh += "<tr><td>과제명</td><td><input type='text' name='title'></td></tr>"
		codeh += "<tr><td>과제내용</td><td><input type='text' name='cont'></td></tr>"
		codeh += "<tr><td>제출기한</td><td>내일<input type='checkbox' name='date' value='1'>&nbsp;&nbsp;"
		codeh += "2일뒤<input type='checkbox' name='date' value='2'>&nbsp;&nbsp;"
		codeh += "3일뒤<input type='checkbox' name='date' value='3'>&nbsp;&nbsp;"
		codeh += "일주일뒤<input type='checkbox' name='date' value='7'></td></tr>&nbsp;&nbsp;"
		
		codeh += "<tr><td>첨부파일</td><td><input type='file' name='file'></td></tr>"
		codeh += "</table>"
		$("#d4").empty().append(codeh);
		
	})
	
	// 강의등록버튼
	$("body").on("click", "#iw2", function(){
		$("#ff").attr("action", "<%=request.getContextPath()%>/insertClass.do");
		$("#ff").attr("enctype", "multipart/form-data")
		codeci = "<table border='1' class='table table-light'>"
		codeci += "<tr><td>강의명</td><td><input type = 'text' name='name'></td></tr>"
		codeci += "<tr><td>강의설명</td><td><input type = 'text' name='comment'></td></tr>"
		codeci += "<tr><td>강의파일</td><td><input type = 'file' name='file'></td></tr>"
		codeci += "</table>"
		$("#d4").empty().append(codeci);
		/*  location.href = "<%=request.getContextPath()%>/work_psj/p_class/insertClass.jsp";*/
	})
	
	// 공지사항등록버튼
	$("body").on("click", "#iw3", function(){
		$("#ff").attr("action", "<%=request.getContextPath()%>/insertNotice.do");
		$("#ff").attr("enctype", "");
		codeni = "<table border='1' class='table table-light'>"
		codeni += "<tr><td>글제목</td><td><input type = 'text' name='title'></td></tr>"
		codeni += "<tr><td>글내용</td><td><input type = 'text' name='cont'></td></tr>"
		codeni += "</table>"
		$("#d4").empty().append(codeni);
		
	
	})
	
})
</script>
</head>
<body>
	<div id="d1"> <h1>이곳은 그냥 NAV</h1></div>
	<div id="d2" class="container p-3 my-3"> </div>
	<div id="d3"> <h4>강의 공지사항</h4></div>
	
<!-- The Modal -->
<div class="modal" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Modal Heading</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>
	
	  <form action="<%=request.getContextPath()%>/insertTaskp.do" method="post" id="ff">
      <!-- Modal body -->
      <div class="modal-body" id="d4">

      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <input type="submit" class="btn btn-danger"  value='등록'>
        <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
      </div>
      </form>

    </div>
  </div>
</div>
	

</body>
</html>
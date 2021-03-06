<%@page import="kr.or.ddit.dcum.vo.ClassStudentVO"%>
<%@page import="kr.or.ddit.dcum.vo.SubjectVO"%>
<%@page import="kr.or.ddit.ysh.controller.subject"%>
<%@page import="kr.or.ddit.dcum.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script src="<%=request.getContextPath()%>/js/student.js"></script>

<style>
 #sp{
 	color: white;
 }

 #d6 {
 width : 600px;
 height :50px;
  
 }
 
 
 .container{
 width: 880px;
 height: 50px;
 float: left;
 } 
 
 .bbshCont{
 	
	width: 1000px;
	height: 1000px;
 	float: left;
 }
 

 
 #d1{
   height: 1000px;
 }
 
 #tab1{
 width: 100%;
 height: 200px;
 
 }
 #tab2{
  width: 100%;
 height: 200px;
 }
  <!-- 새로만든 div -->
  #view2{
	border: 1px solid black;
	width: 600px;
	height: 300px;

 }

</style>
<script>
<% 
MemberVO loginMember = (MemberVO)session.getAttribute("loginUser");

%>

<% 

ClassStudentVO student = (ClassStudentVO)request.getAttribute("student");
SubjectVO subject = (SubjectVO)request.getAttribute("subject");
%>

 	//성적 조회 
 	//성적조회도 수정필요 점수값
 	//요놈이 메인
 	
	$(function(){
	$('#btn1').on('click',function(){
			
		memid = <%= loginMember.getMem_id() %>;
		//2022-02-16 수정중
		$.ajax({ 
		
			url : "<%=request.getContextPath()%>/StudentSum.do",			
			data : {"memid" : memid},
			type :"get",
			success : function(res){
				
				code = "";
				code+= '<table class="table table-striped">';
				code+= '<tr>'
				code+= '<td><h3>'+ '<%=loginMember.getMem_name() %>&nbsp&nbsp'+'님 의 영역별 취득 현황</h3>'+'</td>';		
			    code+= '</tr><tr>'
				code+=' <td><h4>'+ '<%=loginMember.getMem_name() %>' + '님 확인후 문제시 담당자 연락부탁드립니다. ' + '</h4>'+'<td>';
				code+= '</tr>'
			    code+= '</table>'
			    code+= '<table class="table table-striped" id="tab1">';
			    code+= '<tr>';
				code+= '<th>과목구분</th>';
				code+= '<th> </th>';
				code+= '<th>과목명</th>';
				code+= '<th> </th>';
				code+= '<th> </th>';
				code+= '<th></th>';
				code+= '<th>학과 점수</th>';
				code+= '</tr>';
				code+= '</thead>';
				
				var score = 0;
				$.each(res, function(i, v ){
					
			    code+= '<tr>';
			    code+= '<th>전공</th>';
			    code+= '<td> </td>';
			    code+= '<td>'+v.sub_name+'</td>';
			    code+= '<td> </td>';
			    code+= '<td> </td>';
			    code+= '<td> </td>';
			    code+= '<td>'+ v.sub_score +'</td>'; 
			    code+= '</tr>';
			    score += Number(v.sub_score);
			  
				})
				
				console.log(score)
			    code+= '<tr>';
			    code+= '<th>학과 취득 점수</th>';
			    code+= '<td> </td>';
			    code+= '<td> </td>';
			    code+= '<td> </td>';
			    code+= '<td> </td>';
			    code+= '<td> </td>';
			    code+= '<td>'+score+'</td>';  //(140-score)
			    code+= '</tr>';
			    code+= '</table>'; 
			    code+= '<br><br>';
			    code+= '</div>';
			    
			    $("#d1").empty().append(code);
			    
			    btn2();
			    
			},
			
			error : function(xhr){
				alert("상태 : " + xhr.status);
				
			},
			
			
			dataType : 'json'
		})
	}) //클릭이벤트 종료
	
		
	//$('#btn2').on('click',function(){
	//성적조회 btn1 실행시 btn2 까지 자동실행
    btn2 = function() {		
	$.ajax({
		url :  "<%=request.getContextPath()%>/subject.do",
		type : "get",
		success : function(res){
			
		rcode = "";	
//         rcode+='<dd></dd>';
        rcode+='<div id="d5">';
        rcode+='<span><h4>수강중인 과목</h4></span>';
        rcode+='<table class="table table-striped"id="tab2">';
        
       /*  rcode+='<colgroup>';
        rcode+='<col width="100px"/>';
        rcode+='<col width="*"/>';
        rcode+='<col width="100px"/>';
        rcode+='<col width="100px"/>';
        rcode+='<col width="100px"/>';
        rcode+='</colgroup>';  */
        
        rcode+='<thead>';
        rcode+='<tr>';
        rcode+='<th>교과구분</th>';
        rcode+='<th>교과목명</th>';
        rcode+='<th>직급</th>';
        rcode+='<th>이름</th>';
        rcode+='<th> </th>';
        rcode+='</tr>';
        rcode+='</thead>';
        rcode+='<tbody><tr>';
        
        //2022-02-16 수정 본 교수 이름 , 직급 불러오기
        $.each(res, function(i, v ){
       
        rcode+='<th>전공</th>';
        rcode+='<td>'+ v.sub_name +'</td>';
        rcode+='<td>'+v.mem_sort_nm+'</td>';
        rcode+='<td>'+v.mem_name+'</td>';
        rcode+='<td> </td>'
        rcode+='</tr><tr>';
        
        })
      
        rcode+='</tr></tbody>';
        rcode+='</table></div>';
     
        $("#d1").append(rcode);
		},
		
		error : function(xhr){
			alert("상태 : " + xhr.status);
			
		},
     
		dataType : 'json'
		
		
		
		})
	} //2번째 펑션 종료
		
		
		//수강 관리  2022 - 02 - 15 부분수정 완료
	 $('#btn2').on('click',function(){
			
		 memid =<%= loginMember.getMem_id() %>
		 
		 
		 
		 //수강신청 상태인 과목 가져오기 
			
		 
		$.ajax({
			url : "<%=request.getContextPath()%>/SubjectList.do",
			data : {"memid" : memid},
			type : 'get',
			success : function(res){
				
				
				
				tcode='';
				
				
				tcode+='<div class="bbshCont" >';
				tcode+= '<h3>'+'<%=loginMember.getMem_name() %>&nbsp&nbsp'+'님의 수강신청 페이지</h3>';
				tcode+= '<br><br>'
		        tcode+='<div class="bbsSub"><h4>수강 신청</h4></div>';
		        
		        tcode+='<div class="fr">'
		        tcode+='</div>';
		        
		        tcode+='<div class="scrTable half page_11HR mt30">'; 
		        tcode+='</div>';
		        
		        tcode+='<table  class="table table-striped">';
		        
		        
		        
		        tcode+='<thead>';
		        tcode+='<tr>';
		        tcode+='<th>-</th>';
		        tcode+='<th>과목코드</th>';
		        tcode+='<th>교과목명</th>';
		        tcode+='<th>학생정원</th>';
		        tcode+='<th>교수명</th>';
		        tcode+='<th>학점</th>';
		        tcode+='<th>수강</th>';		        
		        tcode+='</tr>';
		        tcode+='</thead>';
		       
		        tcode+='<tbody id="enrollView1">';  
		        $.each(res, function(i, v ){
		         
			        tcode+='<tr class="view">';
			        tcode+='<td>-</td>';
			        tcode+='<td class="code">'+v.sub_num+'</td>';
			        tcode+='<td>'+v.sub_name+'</td>';
			        tcode+='<td>'+v.sub_cnt+'</td>';
			        tcode+='<td>'+v.mem_id+'</td>';
			        tcode+='<td>'+v.status+'</td>';
			        tcode+='<td><button type="button" class="btn btn-primary bbsBtn" >신청</button></td></tr>';
		        
			        //class="btn btn-outline-primary
		        });	
				tcode+='</tbody>'
			    tcode+='</table>'		
			    
// 			    tcode+='<br><br>'
		       
			    tcode +='<div id="view2">'
			    tcode +='<h4>수강신청 내역</h4>'
			    tcode+='<table  class="table table-striped">';
			    tcode+='<thead>';
		        tcode+='<tr>';
		        tcode+='<th>No</th>';
		        tcode+='<th>과목코드</th>';
		        tcode+='<th>교과목명</th>';
		        tcode+='<th>학생정원</th>';
		        tcode+='<th>교수명</th>';
		        tcode+='<th>학점</th>';
		        tcode+='<th>수강</th>';		        
		        tcode+='</tr>';
		        tcode+='<tbody id="enrollView2">';
			   tcode+='</table>'
			   tcode +='</div>';
			   
			   tcode +='</div>';
			    
			   
			   $('#d1').html(tcode);
			   
			   
			   $.ajax({
				    url : '<%=request.getContextPath()%>/SubjectList2.do',
			    	data : {"memid" : memid},
			    	type : 'get',
			    	success : function(res){
			    		  
			    		hcode="";
			    		  
			    		$.each(res, function(i, v ){ 
			 		         	
			    			 
			    			  
						    hcode+='<tr class="view3">';
						    hcode+='<td>-</td>';
						    hcode+='<td class="code2">'+v.sub_num+'</td>';
						    hcode+='<td>'+v.sub_name+'</td>';
						    hcode+='<td>'+v.sub_cnt+'</td>';
						    hcode+='<td>'+v.mem_id+'</td>';
						    hcode+='<td>'+v.status+'</td>';
						    hcode+='<td><button type="button" class="btn btn-danger cancel" data="'+v.sub_num+'" >신청취소</button></td></tr>';
			    		  
			    		});
			    		
			    	      $('#enrollView2').html(hcode);
			    	      
			    	      
			    	
			    	},
			    	dataType : 'json'


				   })//ajax 종료
			
			},
			
			
			error : function(xhr){
			alert("상태 : " + xhr.status);	
			},
			
			dataType : 'json'
		
			
			})
	
	   }) // 이벤트 종료
	   //삭제버튼 활성화
	   
	   $('#d1').on('click','.cancel',function(){
		  
		   
		   
		   yn = confirm("정말 삭제 하시겠습니까?");
			
		   if(yn){	
		
				$(this).parents('.view3').remove();
		   }		
		   
	   	subnum = $(this).parents('.view3').find(".code2").text();
	   
		$.ajax({
			url : '<%=request.getContextPath()%>/DeleteSubject.do',
			data : {"subnum" : subnum},
			type : 'get',
			success : function(res){
				
			
			},
			error : function(xhr){
				alert("상태 확인 :" + xhr.status);	
			},
			
			dataType : 'json'
		
		})//ajax 종료
		
	   
	   
	   
	   })//onclick 이벤트 종료
	   
	   
	
	

		//수강신청 append , parents , 수정완료 취소버튼활성화
	 	$('#d1').on('click','.bbsBtn', function(){
	 
	 		 confirm("수강 신청 하시겠습니까?");
				
		 // 2022 - 02 - 16 수정본 	
		subnum = $(this).parents('.view').find(".code").text();
		userid = <%= loginMember.getMem_id() %>
			
		
			
			var selTr = $(this).parents(".view").html();  //tr없다 
			console.log(selTr);
			
			/* $(this).text("신청취소");
			$(this).attr("class", "cancel"); */
			$(this).parents(".view").remove();
			
			

		//$("#enrollView2").append(selTr.html());
			
		//selTr.remove();
			
	
			$.ajax({
				url : "<%=request.getContextPath()%>/viewInsert.do",
				data:{
					"subnum" : subnum,
					"userid" : userid
				},
				
				type:"post",
				success : function(res){
					
					
					t = "<tr class='view3'>";
					t += selTr;
					t += "</tr>"
					
					$('#enrollView2').append(t);
					$('#enrollView2 .view3 .bbsBtn').text("신청취소");
					$('#enrollView2 .view3 .bbsBtn').attr("class","btn btn-danger cancel");
				},
				error : function(xhr){
					alert("상태 : " + xhr.status);
				},
				dataType : "json"
			});
			
			
	 	})
			
		//학적을 조회하는 ajax
		$('#btn3').on('click',function(){
			
				memid = <%=loginMember.getMem_id() %>
			
			
 			$.ajax({
				url : "<%=request.getContextPath()%>/StudentList.do", 
				data : {"memid" : memid },
 				type: "get",
 				success : function(res){
					
 				Icode = "";	
 				Icode +='<div>'
 				Icode +='<h2>학생 정보</h2>'
 				Icode +='<p><h4>환영합니다. DDIT UNIVERSITY</h4></p>'
 				Icode +='<div class="card" style="width:400px">'
 				Icode +='<img class="card-img-top" src="../images/main/사자2.jpg" alt="Card image" style="width:100%">'	
 				Icode +='</div>'
 				Icode +='</div>'
 				Icode +='<br>'
 				Icode += '<table class="table table-striped">'
 				Icode += '<thead>'
 				Icode += '<tr>'
				Icode += '<th><h2>'+'<%=loginMember.getMem_name()%>&nbsp&nbsp'+'님의 학적 정보</h2></th>' 
 				Icode += '</tr><tr>'
 				Icode += '<th><p><h4>학적 변동시 관리자에게 문의해주세요.</h4></p></th>'            
 				Icode += '</tr></thead>'
 				Icode += '<table class="table table-striped">'
 				Icode += '<thead>'
 				Icode += '<tr>'
 				Icode += '<th>나의 학번</th>'
 				Icode += '<th>나의 학과</th>'
 				Icode += '<th>입 학 일</th>'
 				Icode += '<th>졸업여부</th>'
 				Icode += '</tr>'
 				Icode += '</thead>'
 				
 				$.each(res,function(i, v){
 				Icode += '<tbody>'
 				Icode += '<tr>'
 				Icode += '<td>'+v.mem_id+'</td>'
 				Icode += '<td>'+v.dep_num+'</td>'
 				Icode += '<td>'+v.start_date+'</td>'
 				Icode += '<td>'+v.end_date+'</td>'				
 				Icode += '</tr>'
 				Icode += '</tbody>'		
 				})
 				Icode += '</table>'
 				Icode += '<br><br>'
 				Icode += '<p><h4>학적 변동시 관리자에게 문의해주세요.</h4></p>' 
 				Icode += '<table class="table table-striped">'
 				Icode += '<thead>'
 				Icode += '<tr>'
 				Icode += '<th>재학 여부</th>'
 				Icode += '<th>총 점수</th>'
 				Icode += '</tr>'
 				Icode += '</thead>'			
 				$.each(res,function(i, v){
 				Icode += '<tbody>'
 				Icode += '<tr>'
 				Icode += '<td>'+v.status+'</td>'
 				Icode += '<td>'+v.total_score+'</td>'			
 				Icode += '</tr>'
 				Icode += '</tbody>'		
 				})
 				
 				Icode += '</div>'
 					$("#d1").empty().append(Icode);
 				},
 				error : function(xhr){
 					alert("상태 : " + status); 
 				},
 				dataType : 'json'
 			})
 		})
		
		
	})


</script>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand/logo -->
  <a class="navbar-brand" href="#">
    <img src="../images/icon/학사관리.png" alt="gdff" style="width:40px;">
  </a>
  
  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="#" id="btn1">성적관리</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#" id="btn2">수강관리</a>
    </li>
     <li class="nav-item">
      <a class="nav-link" href="#" id="btn3">학적관리</a>
    </li>
    
    <li class="nav-item">
      <a class="nav-link" href="<%=request.getContextPath()%>/allProfessorList.do" id="btn4">휴학/복학/자퇴관리</a>
    </li>

  </ul>
   <span id="sp"><h4>[<%=loginMember.getMem_sort_nm()%>] <%=loginMember.getMem_name() %>님 반갑습니다.</h4></span>
</nav>
	
	<%-- <div class="container">
  <h2>학사관리</h2>
  <span><h4>[<%=loginMember.getMem_sort_nm()%>] <%=loginMember.getMem_name() %>님 반갑습니다.</h4></span>
 	 <ul class="nav">
    <li class="nav-item">
      <a class="nav-link" type="button" id="btn1">성적관리</a>
   		 </li>
   		 
    <li class="nav-item">
      <a class="nav-link" href="#" id="btn2">수강관리</a>
    	</li>
    <li class="nav-item">
      <a class="nav-link" href="#" id="btn3">장학관리</a>
    	</li>
  		<li class="nav-item">
      <a class="nav-link" href="#" id="btn5">학적관리</a>
   	 		</li>
  		</ul>
  		
  		
	</div> --%>
	
	
	
	<br><br>
	
	
	<div id="d1">
	
	</div>
	
	
	
	
</body>
</html>
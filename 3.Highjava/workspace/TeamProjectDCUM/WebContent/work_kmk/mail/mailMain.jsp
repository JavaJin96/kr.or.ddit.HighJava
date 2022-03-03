<%@page import="kr.or.ddit.dcum.vo.MessageVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.dcum.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쪽지 기능</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<script src="<%=request.getContextPath()%>/js/student.js"></script>

<style>
img{
	width: 44px;
	height: 45px;
}
.container{
	width: 1000px;
	height: 1000px;
}
#la{
	width: 60px;
	height: 24px;
}
.table table-striped{
	width:1000px;
}

</style>

<% 
 MemberVO loginMember = (MemberVO)session.getAttribute("loginUser"); 
List<MessageVO> mailList = (List<MessageVO>)request.getAttribute("mailList");
%>

<script>

$(function(){
	
	//쪽지확인하기
	$('#btn2').on('click',function(){
		
		memid = '<%= loginMember.getMem_id() %>'
		
		
		$.ajax({
			url : '<%=request.getContextPath()%>/MailList.do' ,
			data : {"memid" : memid,
				"sw" : "1"},
			type : 'get',
			success:function(res){
		
				
				$("#b1").html(code);
				
			},
			
			error:function(xhr){
				alert("상태: " + xhr.status);
			
			
			},
			dataType : 'json'
			
		})	//아작스
	
	})//이벤트
	
	//삭제이벤트 생성
	$('#b1').on('click','.delete',function(){
		
		mesnum = $(this).attr("data");
		alert(mesnum)
		
		yn = confirm("정말 삭제 하시겠습니까?");
		if(yn){
			$(this).parents('tr').remove();
		}
		
		
		$.ajax({
			url : "<%=request.getContextPath()%>/DeleteMail.do",
			data : {"mesnum" : mesnum},
			type : "get",
			success : function(res){
				
			},
			error : function(xhr){
				
			},
			dataType : 'json'
		})
	})//이벤트종료
	
	//쪽지 불러오기
	$('#b1').on('click','#inbtn',function(){
		cont = $(this).attr("data");
		$.ajax({
			url : '<%=request.getContextPath()%>/MailList.do' ,
			data : {"memid" : cont,
					"sw" : "2"},
			type : 'get',	
			success : function(res){
				codem = '';
				codem +='<div>'
				codem +='<h2>쪽지 보기</h2>'
				codem +='<table class="table table-bordered">'
				codem +='<thead>'
			 	codem +='<tr>'
			 	codem +='<th>번호</th>'
				codem +='<th>보낸이</th>'
				codem +='<th>받는이</th>'
				codem +='<th>내용</th>'
				codem +='<th>날짜</th>'
				codem +='</tr>'
				codem +='</thead>'
				codem +='<tbody>'
				codem +='<tr>'
				codem +='<td>'+res.mes_num+'</td>'
				codem +='<td>'+res.bal_mem_id+'</td>'
				codem +='<td>'+res.su_mem_id+'</td>'
				codem +='<td>'+res.mes_cont+'</td>'
				codem +='<td>'+res.mes_date+'</td>'			
				codem +='</tr>'
				codem +='</tbody>'
				$("#myModalBod").empty().append(codem);
			},
			error : function(xhr){
				alert(xhr.status);
			},
			dataType : 'json'
		})		
	})//이벤트
	//쪽지 쓰기 
	 $('#tobtn').on('click',function(){
		$('#toModal');
	 })	
	 
	 //모달창 닫기 이벤트
	 $('#toModal').on('hide.bs.modal', function(){
		 $('.text').val(""); 
	 }) 
	 //mymailto();
	 //서버로 전송	
	$('#tobut').on('click',function(){
	//	 console.log($('#mailin').serializeArray());
		a= confirm("전송하시겠습니까?");
		if(a){
		    mymailto();
		}
		$('#toModal').modal('hide');
	})
	
	/* 사용자가 듣고있는 수업들을 조회하여 s1 에 넣어주는 ajax */
		$.ajax({
			url : "<%=request.getContextPath()%>/ViewSubject.do",
			method : "post", 
			success : function(res){
				code = "";
				$.each(res, function(i, v){
				code += "<option>" + v.sub_name + "</option>"
			})
			$("#s1").append(code);
				
			},
			error : function(xhr){
			alert("상태 : "+ xhr.status)
			},
			dataType : "json"
		})
	
	$("#s1").on("change", function(){
		subname = $("#s1").val();
		$.ajax({
			url : "<%=request.getContextPath()%>/ViewSubject2.do",
			method : "post",
			data : {"data": subname},
			success : function(res){
			codee = "";
			$.each(res, function(i, v){
			codee += "<option>" + v.mem_id + "</option>"
				})
    $("#s2").empty().append(codee);	
			  //select선택하면 
			  //text로
			 sel=$('#s2 option:selected').val();
			  $('#sunam').val(sel);
			},
			error : function(xhr){
			alert("상태 : "+ xhr.status)
			},
			dataType : "json"
		})
	})
})// 펑션

</script>

</head>
<body>

<!--  <nav class="navbar navbar-expand-sm bg-dark navbar-dark"> -->
<!--   <!-- Brand/logo --> 
<!--   <a class="navbar-brand"> -->
<!--   </a> -->
<!--    <ul class="navbar-nav"> -->
<!--     <li class="nav-item"> -->
<!--     	<a class="nav-link" type="button" id="tobtn" data-toggle="modal" data-target="#toModal">쪽지쓰기</a> -->
<!--      <input class="nav-link" type="button" id="tobtn" data-toggle="modal" data-target="#toModal" value="쪽지 쓰기">  -->
<!--     </li> -->
<!--     <li class="nav-item"> -->
<!--     	<input type="button" class="nav-link" id="btn2" value="쪽지 확인 하기"> -->
<!--      <a class="nav-link" type="button" id="btn2">쪽지 확인 하기</a> -->
<!--     </li> -->
<!--   </ul> -->
<!-- </nav> -->
     <br>
	<div id="accordion">
		<h4>
			[<%=loginMember.getMem_name()%>님] 쪽지함 <img src="<%=request.getContextPath() %>/images/icon/쪽지.png" alt="gdff">
		</h4>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th>번호</th>
					<th>날짜</th>
					<th>내용</th>
					<th>보낸이</th>
					<th>받는이</th>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
				<%if(mailList!=null){ 
					for(MessageVO v : mailList){%>
					<td><%=v.getMes_num()%></td>
					<td><%=v.getMes_date()%></td>
					<td><%=v.getMes_cont()%></td>
					<td><%=v.getBal_mem_id()%></td>
					<td><%=v.getSu_mem_id()%></td>
					<td><input type="button" class="btn btn-primary" id="inbtn" data-toggle="modal" data-target="#myModal" data=" + v.mes_num +"
						value="쪽지확인"></td>
					<td><input type="button" class="btn btn-primary delete"	data="+v.mes_num+" value="삭제하기"></td>
				<%}} %>
				</tr>
			</tbody>
		</table>
	</div>

	<!-- 쪽지  상세확인 -->
	 <div class="modal" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <div class="modal-header">
        <h4 class="modal-title"><%=loginMember.getMem_name()%>&nbsp 님 의 쪽지</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>
   
		<!-- 쪽지 상세내용 조회 -->  
      <div class="modal-body" id="myModalBod">
      
      </div>

      
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
      </div>

    </div>
  </div>
</div> 
	
	
<!-- 답장보내는 모달 -->
	 <div class="modal" id="toModal">
  <div class="modal-dialog">
    <div class="modal-content">

     
      <div class="modal-header">
        <h4 class="modal-title">쪽지쓰기</h4>
        <button type="button" class="close" data-dismiss="modal"></button>
      </div>

    
      <div class="modal-body">
       
       <form id="mailin">
        	<label id="la">보낸이</label>
        	<input type="text" id="banam" name="banam" value="<%=loginMember.getMem_id() %>">
        	<br>
             <label id="la">검색</label>
        	<select name="searchtype" id="s1">
                <option>수업을 선택하세요.</option>
             </select>
        	<select name="searchtype" id="s2">
                <option>상대방을 선택하세요.</option>
             </select>
        	<br><br>
        	<label id="la">받는이</label>
        	<input class="text" type="text" id="sunam" name="sunam" >
        	<br>
        	<label>내용</label>
        	<br>
        	<textarea class="text" rows="10" cols="50" id="area" name ="cont"></textarea>
        
        	<br><br>
        	<input type="button" value="전송" id="tobut">
        
        </form>  
      </div>

      
      <div class="modal-footer">
        <button type="button" class="tbtn btn-danger" data-dismiss="modal">취소</button>
      </div>

    </div>
  </div>
</div>  
</body>
</html>

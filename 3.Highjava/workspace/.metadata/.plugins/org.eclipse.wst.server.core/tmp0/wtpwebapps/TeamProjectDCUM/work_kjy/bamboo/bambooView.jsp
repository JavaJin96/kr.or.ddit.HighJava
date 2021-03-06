<%@page import="kr.or.ddit.dcum.vo.MemberVO"%>
<%@page import="kr.or.ddit.dcum.vo.BambooReplyVO"%>
<%@page import="kr.or.ddit.dcum.vo.BambooVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="http://localhost/test/css/main.css"> -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/cmu_board_view.css">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- 게시글 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/cmu_board_view.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script>
<%
	BambooVO bamVo = (BambooVO)request.getAttribute("bambooVo");
	List<BambooReplyVO> rebamboo = (List<BambooReplyVO>)request.getAttribute("rebambooVo");
	MemberVO loginMember = (MemberVO)session.getAttribute("loginUser");
%>

	$(function(){
		//글 목록으로 되돌아가기
		$('#bambooList').on('click', function(){
			location.href="<%= request.getContextPath() %>/bamboo.do";
		})
		
// 		var gubun = "";
		//글 삭제 모달창 띄우기
		$('#deleteBamboo').on('click', function(){
			$('#deleteModal').modal('show');
			
			bonum = $(this).parents().find('.sec_num').val();
			
			//모달창에 게시글 번호를 셋팅
			$('.delhid').val(bonum);
		})
		
		//모달창에서 삭제버튼
		$('#del').on('click', function(){
			form = $('#bambooForm').get(0);
			form.action = "<%= request.getContextPath() %>/deleteBamboo.do";
			form.submit();
		})
		
		//댓글, 글삭제
<%-- 		
		$('#del').on('click', function(){
			var form = null;
			if(gubun=="Bamboo"){
				form = $('#bambooForm').get(0);
				form.action = "<%= request.getContextPath() %>/deleteBamboo.do";
				
			}else if(gubun=="ReBamboo"){
				form = $('#rebambooForm');
				form.action = "<%= request.getContextPath() %>/deleteReBamboo.do"; 
			}
			gubun="";
			
			if(form!=null){
				form.submit();
			} 
			 
			$('#deleteModal').modal('hide');
			
		}) --%>
		
		//글 수정
		$('#updateBamboo').on('click', function(){
			var form = $('#bambooForm').get(0);
			form.action = "<%= request.getContextPath() %>/updateBambooForm.do";
			form.submit();
		})
		
		//-------------------------------------------------------------------------
		
		//댓글 입력시 줄바꿈
		$('#insertReply').on('click', function(){
			var str = $('#reply').val();
			str = str.replace(/(?:\r\n|\r|\n)/g, '<br/>');
			$('#reply').val(str);
			
// 			$('#reply').val().replace(/\n/g, "<br>");
			
			//댓글 아이디 숫자 +1씩
// 			name = $('#rewriter').val();
			
		})
		
		//댓글 삭제 모달창 띄우기
		$('.deleteReBamboo').on('click', function(){
			$("#redeleteModal").modal('show');
			
			renum = $(this).parent().find('.renum').val();
			
			//모달창에 댓글 번호를 셋팅
			$('.redelhid').val(renum);
		})
		
		//모달에서 댓글 삭제
		$('#redel').on('click', function(){
			var form = this.form;
			//alert("test=>" + $(form).attr("id"));
			form.action = "<%= request.getContextPath() %>/deleteReBamboo.do"; 
			form.submit();
		})
		
		//댓글 수정
		$('.updateReBamboo').on('click', function(){
			if($(this).val() == "수정"){
				cont = $(this).parents('tbody').find('.contre').html();
				cont = cont.replace(/<br>/g, "\n");
				
				cont1 = '<textarea rows="4" cols="147" placeholder="내용 입력" class="reply" name="sec_re_cont">'+ cont + '</textarea>';
			    $(this).parents('tbody').find('.contre').html(cont1);
			    
			    $(this).attr("value", "완료");
			    
			    $('.deleteReBamboo').hide();
			    $('.cancel').show();
			    
			    //취소 버튼
			    $('.cancel').on('click', function(){
			    	location.href="<%= request.getContextPath() %>/bambooView.do?sec_num=<%= bamVo.getSec_num() %>";
			    })
			
			//수정 버튼
			}else if($(this).val() == "완료"){
				str1 = $(this).parents('tbody').find('.reply').val();
				str1 = str1.replace(/\n/g, '<br/>');
				$(this).parents('tbody').find('.reply').val(str1);
				
				var form = $('#rebambooForm').get(0);
				form.action = "<%= request.getContextPath() %>/updateReBamboo.do";
				form.submit();
		    }
			
		})
		
		//새로 고침
// 		$('#reReply').on('click', function(){
// 			 $("#reList").load(location.href + "#reList");
// 		})
		
	})
		

</script>

</head>
<body>


	<div class="container">
	<h2>대나무숲</h2>
	
	<!-- 게시글 창 -->
	<form id="bambooForm">
		<input type="hidden" class="sec_num" name="sec_num" value="<%= bamVo.getSec_num() %>">
		<input type="hidden" class="mem_id" name="mem_id" value="<%= loginMember.getMem_id() %>">
	</form>
	            
		<table class="table">
			<thead>
				<tr class="table-success">
					<th colspan="3" id="title"><%= bamVo.getSec_title() %></th>
				</tr>
			</thead>

			<tbody>
				<tr>
					<td id="writer">사람🙋‍♂️</td>
					<td></td>
					<td id="date"><%= bamVo.getSec_date() %></td>
				</tr>
			
		  		<tr>
					<td id="cont" colspan="3"><%= bamVo.getSec_cont() %></td>
				</tr>
				
				<tr>
					<td colspan="3">
				  	<% if(loginMember != null && loginMember.getMem_id().equals(bamVo.getMem_id()) || loginMember.getMem_sort_nm().equals("교수")) { %>
				  		
				  		<input type="button" value="수정" id="updateBamboo" class="btn btn-dark" style="float:right; margin:5px;">
				  		<input type="button" value="삭제" id="deleteBamboo" class="btn btn-dark" style="float:right; margin:5px;">
				  	<% } %>
					</td>
				</tr>
			</tbody>
  		</table>
  		
  	</div>
  		
  		
	<!-- 댓글 리스트 -->
	<div class="container" id="reList">
	<form id="rebambooForm">
	<table class="table">
		<thead>
			<tr class="table-success">
				<th colspan="4">댓글</th>
			</tr>
		</thead>
		<%
			for(BambooReplyVO revo : rebamboo){
		%>
		<tbody>
	  		<tr>
				<td id="rewr">🎋<%= revo.getSec_re_writer() %>🎋</td>
				<td></td>
				<td></td>
				<td id="redate"><%= revo.getSec_re_date() %></td>
				
			</tr>
			
			<tr>
				<td colspan="3" class="contre"><%= revo.getSec_re_cont() %></td>
				<td class="rebut">
				
				<% if(loginMember != null && loginMember.getMem_id().equals(revo.getMem_id()) || loginMember.getMem_sort_nm().equals("교수")) { %>
					<!-- 로그인한 사람이랑 일치할때만 뜨도록 수정 -->
					<input type="hidden" value="<%= bamVo.getSec_num() %>" name="sec_num">
					<input type="hidden" value="<%= revo.getSec_re_num() %>" name="sec_re_num" class="renum">
					<input type="hidden" value="<%= revo.getSec_re_writer() %>" name="sec_re_writer">
					
					<input type="button" value="수정" class="updateReBamboo btn btn-dark">
					<input type="button" value="삭제" class="deleteReBamboo btn btn-dark">
					<input type="button" value="취소" class="cancel" style="display: none;"  class="btn btn-secondary">
				<% } %>
				</td>
			</tr>
		</tbody>
		<% 
		}
		%>
			
 		</table>
		</form>
 		
 		
 		<!-- 댓글 입력창 -->
 		<form action="<%=request.getContextPath()%>/insertReBamboo.do" mothod="post">
<!--  			<input type="button" value="새로 고침" id="reReply"> -->
 			<br><br>
	  		<textarea rows="4" cols="147" placeholder="내용 입력" id="reply" name="sec_re_cont"></textarea>
			<input type="hidden" id="rewriter" name="sec_re_writer" value="대나무">
			<input type="hidden" name="sec_num" value="<%= bamVo.getSec_num() %>">
			<input type="hidden" name="mem_id" value="<%= loginMember.getMem_id() %>">
			<br>
			<input type="submit" value="입력" id="insertReply" class="btn btn-secondary">
		</form>
		<br><br>
		
		<!-- 목록 -->
		<button type="button" id="bambooList"class="btn">
			<img src="<%=request.getContextPath()%>/images/icon/목록아이콘.PNG">
		</button>
	</div>
	
	
	<!-- 게시글 삭제창 -->
	<div class="modal fade" id="deleteModal">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
	
				<!-- Modal Header -->
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				
				<!-- Modal body -->
				<div class="modal-body">
					<form id="wrform">
						<label>정말 삭제하시겠습니까?</label>
						<input type="hidden" name="del" class="delhid">
					</form>
				</div>
				
				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" id="del">삭제</button>
					<button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
				</div>
				
			</div>
		</div>
	</div>
	
	<!-- 댓글 삭제창 -->
	<div class="modal fade" id="redeleteModal">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
	
				<form id="wrform">
					<!-- Modal Header -->
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					
					<!-- Modal body -->
					<div class="modal-body">
							<label>정말 삭제하시겠습니까?</label>
							<input type="hidden" name="sec_num" value="<%=bamVo.getSec_num() %>" >
							<input type="hidden" name="sec_re_num" class="redelhid">
					</div>
					
					<!-- Modal footer -->
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" id="redel">삭제</button>
						<button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
					</div>
				</form>
				
			</div>
		</div>
	</div>

</body>
</html>
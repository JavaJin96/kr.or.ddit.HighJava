<%@page import="kr.or.ddit.dcum.vo.MemberVO"%>
<%@page import="kr.or.ddit.dcum.vo.CommuReplyVO"%>
<%@page import="kr.or.ddit.dcum.vo.CommunityVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- 게시글 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/cmu_board_view.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<style>
</style>

<script>
<%
	CommunityVO commuVo = (CommunityVO)request.getAttribute("commuVo");
	List<CommuReplyVO> reCommuVo = (List<CommuReplyVO>)request.getAttribute("reCommuVo");
	MemberVO loginMember = (MemberVO)session.getAttribute("loginUser");
%>

	$(function(){
		//글 목록으로 되돌아가기
		$('#commuList').on('click', function(){
			location.href="<%= request.getContextPath() %>/community.do";
		})
		
		//글 삭제 모달창 띄우기
		$('#deleteCommu').on('click', function(){
			$('#deleteModal').modal('show');
			
			bonum = $(this).parents().find('.cmu_num').val();
			
			//모달창에 게시글 번호를 셋팅
			$('.delhid').val(bonum);
		})
		
		//모달창에서 삭제버튼
		$('#del').on('click', function(){
			form = $('#CommuForm').get(0);
			form.action = "<%= request.getContextPath() %>/deleteCommunity.do";
			form.submit();
		})
		
		//글 수정
		$('#updateCommu').on('click', function(){
			var form = $('#CommuForm').get(0);
			form.action = "<%= request.getContextPath() %>/updateCommunityForm.do";
			form.submit();
		})
		
		//-------------------------------------------------------------------------
		
		//댓글 입력시 줄바꿈
		$('#insertReply').on('click', function(){
			var str = $('#reply').val();
			str = str.replace(/(?:\r\n|\r|\n)/g, '<br/>');
			$('#reply').val(str);
			
		})
		
		//댓글 삭제 모달창 띄우기
		$('.deleteReCommu').on('click', function(){
			$("#redeleteModal").modal('show');
			
			renum = $(this).parent().find('.renum').val();
			
			//모달창에 댓글 번호를 셋팅
			$('.redelhid').val(renum);
		})
		
		//모달에서 댓글 삭제
		$('#redel').on('click', function(){
			var form = this.form;
			form.action = "<%= request.getContextPath() %>/deleteReCommunity.do"; 
			form.submit();
		})
		
		//댓글 수정
		$('.updateReCommu').on('click', function(){
			if($(this).val() == "수정"){
				cont = $(this).parents('tbody').find('.contre').html(); //br포함
				cont = cont.replace(/<br>/g, "\n");
				//cont = cont.replace(/\n/g, '<br>');
				
				cont1 = '<textarea rows="4" cols="147" placeholder="내용 입력" class="reply" name="cmu_re_cont">'+ cont + '</textarea>';
			    $(this).parents('tbody').find('.contre').html(cont1);
			    
			    $(this).attr("value", "완료");
			    
			    $('.deleteReCommu').hide();
			    $('.cancel').show();
			    
			    //취소 버튼
			    $('.cancel').on('click', function(){
			    	location.href="<%= request.getContextPath() %>/communityView.do?cmu_num=<%= commuVo.getCmu_num() %>";
			    })
			
			//수정 버튼
			}else if($(this).val() == "완료"){
				
				str1 = $(this).parents('tr').find('.reply').val();
				str1 = str1.replace(/\r/g, "").replace(/\n/g, "<br>");
				$(this).parents('tr').find('.contre').html(str1);
				
				
				var form = $('#reCommuForm').get(0);
 				form.action = "<%= request.getContextPath() %>/updateReCommunity.do";
 				form.submit();
		    }
			
		})
		
		//새로 고침
		$('#reReply').on('click', function(){
			location.reload();
		})
		
	})
</script>

</head>
<body>
<br>
	<div class="container">
	<h2>커뮤니티</h2>
	
	<!-- 게시글 창 -->
	<form id="CommuForm">
		<input type="hidden" class="cmu_num" name="cmu_num" value="<%= commuVo.getCmu_num() %>">
		<input type="hidden" class="mem_id" name="mem_id" value="<%= loginMember.getMem_id() %>">
	</form>
	            
		<table class="table">
			<thead>
				<tr class="table-warning">
					<th colspan="3" id="title">[<%= commuVo.getCmu_sort() %>] <%= commuVo.getCmu_title() %></th>
				</tr>
			</thead>

			<tbody>
				<tr>
					<td id="writer">작성자 : <%= commuVo.getCmu_writer() %></td>
					<td></td>
					<td id="date">작성일자 : <%= commuVo.getCmu_date() %></td>
				</tr>
			
		  		<tr>
					<td id="cont" colspan="3"><%= commuVo.getCmu_cont() %></td>
				</tr>
				
				<tr>
					<td colspan="3">
					<% if(loginMember != null && loginMember.getMem_id().equals(commuVo.getMem_id()) || loginMember.getMem_sort_nm().equals("교수")) { %>
				  		<input type="button" value="수정" id="updateCommu" class="btn btn-dark">
				  		<input type="button" value="삭제" id="deleteCommu" class="btn btn-dark">
				  	<% } %>
					</td>
				</tr>
			</tbody>
  		</table>
  	<hr>	
  	</div>
  		
	<!-- 댓글 리스트 -->
	<div class="container">
	<form id="reCommuForm">
	<table class="table">
		<thead>
			<tr class="table-warning">
				<th colspan="4">댓글</th>
			</tr>
		</thead>
		<%
			for(CommuReplyVO revo : reCommuVo){
		%>
		<tbody>
		<%-- <input type="hidden" name="cmu_re_num" value="<%= revo.getCmu_re_num() %>">
		<input type="hidden" name="cmu_num" value="<%= revo.getCmu_num() %>"> --%>
	  		<tr>
				<td id="rewr"><%= revo.getCmu_re_writer() %>
					<input type="hidden" name="cmu_re_writer" value="<%= revo.getCmu_re_writer() %>">
				</td>
				<td></td>
				<td></td>
				<td id="redate"><%= revo.getCmu_re_date() %>
				</td>
			</tr>
			
			<tr>
				<td colspan="3" class="contre"><%= revo.getCmu_re_cont() %>
					<input type="hidden" name="cmu_re_cont" value="<%= revo.getCmu_re_cont() %>">
				</td>
				<td class="rebut">
				<% if(loginMember != null && loginMember.getMem_id().equals(revo.getMem_id()) || loginMember.getMem_sort_nm().equals("교수")) { %>
					<input type="hidden" value="<%= commuVo.getCmu_num() %>" name="cmu_num" >
					<input type="hidden" value="<%= revo.getCmu_re_num() %>" name="cmu_re_num" class="renum">
					<input type="hidden" value="<%= revo.getCmu_re_writer() %>" name="cmu_re_writer">
					
					<input type="button" value="수정" class="updateReCommu btn btn-dark" >
					<input type="button" value="삭제" class="deleteReCommu btn btn-dark" >
					<input type="button" value="취소" class="cancel" style="display: none;" class="btn btn-secondary">
				<% } %>
				</td>
			</tr>
			
		</tbody>
		<% 
		}
		%>
			
 		</table>
 		</form>
 		<hr>
 		<!-- 댓글 입력창 -->
 		<form action="<%=request.getContextPath()%>/insertReCommunity.do" mothod="post">
	  		<textarea rows="4" cols="147" placeholder="내용 입력" id="reply" name="cmu_re_cont"></textarea>
			<input type="hidden" id="rewriter" name="cmu_re_writer" value="<%= loginMember.getMem_name() %>">
			<input type="hidden" name="cmu_num" value="<%= commuVo.getCmu_num() %>">
			<input type="hidden" name="mem_id" value="<%= loginMember.getMem_id() %>">
			<br>
			<input type="submit" value="입력" id="insertReply" class="btn btn-secondary">
		</form>
		<br><br>
		
		<!-- 목록 -->
		<button type="button" id="commuList" class="btn">
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
					<button type="button" class="btn btn-dark" id="del">삭제</button>
					<button type="button" class="btn btn-dark" data-dismiss="modal">취소</button>
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
							<input type="hidden" name="cmu_num" value="<%=commuVo.getCmu_num() %>" >
							<input type="hidden" name="cmu_re_num" class="redelhid">
					</div>
					
					<!-- Modal footer -->
					<div class="modal-footer">
						<button type="button" class="btn btn-dark" id="redel">삭제</button>
						<button type="button" class="btn btn-dark" data-dismiss="modal">취소</button>
					</div>
				</form>
				
			</div>
		</div>
	</div>

</body>
</html>
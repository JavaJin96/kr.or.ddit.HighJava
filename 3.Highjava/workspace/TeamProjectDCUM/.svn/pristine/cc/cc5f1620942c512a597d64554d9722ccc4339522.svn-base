<%@page import="kr.or.ddit.dcum.vo.MemberVO"%>
<%@page import="kr.or.ddit.dcum.vo.GongjiVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 게시글 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<style>
	#date{
		text-align: right;
	}
	
	#bambooList{
		margin : 5px;
	}
	
	#updateGongji{
		float : right;
		margin : 5px;
	}
	
	#deleteGongji{
		float : right;
		margin : 5px;
	}
	
	#del{
		text-align : left;
	}
</style>

<script>
	$(function(){
		
		//공지 목록
		$('#gongjiList').on('click', function(){
			location.href="<%= request.getContextPath() %>/gongji.do";
		})
		
		//공지 삭제
		$('#deleteGongji').on('click', function(){
			$('#deleteModal').modal('show');
		})
		
		$('#del').on('click', function(){
			var form = $('#gongjiForm').get(0);
			form.action = "<%= request.getContextPath() %>/deleteGongji.do";
			form.submit();
			
			$('#deleteModal').modal('hide');
		})
		
		//공지 수정
		$('#updateGongji').on('click', function(){
			var form = $('#gongjiForm').get(0);
			form.action = "<%= request.getContextPath() %>/updateGongjiForm.do";
			form.submit();
		})
	})
	
</script>

</head>
<body>

<%
	GongjiVO gongVo = (GongjiVO)request.getAttribute("gongjiVo");
	MemberVO loginMember = (MemberVO)session.getAttribute("loginUser");
%>
	<div class="container">
	<h2>공지</h2>
	<p>공지게시판 입니다.</p>
	
	
	<!-- 게시글 창 -->
	<form id="gongjiForm">
		<input type="hidden" id="gongji_num" name="gongji_num" value="<%= gongVo.getGongji_num() %>">
	</form>
	            
		<table class="table">
			<thead>
				<tr>
					<th colspan="3" id="title"><%= gongVo.getGongji_nm() %></th>
				</tr>
			</thead>

			<tbody>
				<tr>
					<td id="writer">관리자</td>
					<td></td>
					<td id="date"><%= gongVo.getGongji_date() %></td>
				</tr>
			
		  		<tr>
					<td id="cont" colspan="3"><%= gongVo.getGongji_cont() %></td>
				</tr>
				
				<tr>
					<td colspan="3">
					<% if(loginMember != null && loginMember.getMem_sort_nm().equals("교수")) { %>
				  		<!-- 로그인한 사람이랑 일치할때만 뜨도록 수정 -->
				  		<input type="button" value="수정" id="updateGongji">
				  		<input type="button" value="삭제" id="deleteGongji">
				  	<% } %>
					</td>
				</tr>
			</tbody>
			
  		</table>
  		
  		<!-- 목록 -->
		<button type="button" id="gongjiList" class="btn">
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
					</form>
				</div>
				
				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal" id="del">삭제</button>
					<button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
				</div>
				
			</div>
		</div>
	</div>
</body>
</html>
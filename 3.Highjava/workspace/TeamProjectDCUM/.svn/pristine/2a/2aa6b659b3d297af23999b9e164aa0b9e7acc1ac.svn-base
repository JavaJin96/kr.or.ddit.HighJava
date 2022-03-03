<%@page import="kr.or.ddit.dcum.vo.MemberVO"%>
<%@page import="kr.or.ddit.dcum.vo.StudyApplyVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.dcum.vo.StudyVO"%>
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
	
	#updateStudy{
		float : right;
		margin : 5px;
	}
	
	#deleteStudy{
		float : right;
		margin : 5px;
	}
	
	#del{
		text-align : left;
	}
	
	#apply{
		display : show;
	}
	#but-icon{
		width: 21px;
		height: 18px;
	}
</style>

<script>

<%
	StudyVO svo = (StudyVO)request.getAttribute("studyVo");
	List<StudyApplyVO> studentVo = (List<StudyApplyVO>)request.getAttribute("studentVo");
	MemberVO loginMember = (MemberVO)session.getAttribute("loginUser");
%>

	$(function(){
		
		//스터디 목록
		$('#studyList').on('click', function(){
			location.href="<%= request.getContextPath() %>/study.do";
		})
		
		//뷰에서 스터디 삭제
		$('#deleteStudy').on('click', function(){
			$('#deleteModal').modal('show');
		})
		
		//뷰에서 삭제 버튼
		$('#del').on('click', function(){
			var form = $('#studyForm').get(0);
			form.action = "<%= request.getContextPath() %>/deleteStudy.do";
			form.submit();
			
			$('#deleteModal').modal('hide');
		})
		
		//스터디 수정
		$('#updateStudy').on('click', function(){
			var form = $('#studyForm').get(0);
			form.action = "<%= request.getContextPath() %>/updateStudyForm.do";
			form.submit();
		})
		
		//뷰에서 스터디 신청
		$('#apply').on('click', function(){

			$('#insertModal').modal('show');

			sbnum = '<%= svo.getSb_num() %>';
			$('.hiddensb').val(sbnum);
			
		})
		
		//스터디 신청시 인원이 다 차면 신청 버튼 사라짐
		var total = '<%= svo.getTotal_cnt() %>';
		var current = '<%= svo.getCurrent_cnt() %>';
		
		if( total == current ) $('#apply').attr('style', "display:none;");
		
		//모달창에서 신청 버튼
		$('#wrform').on('submit', function(){
			
			$(this).attr('action', "<%= request.getContextPath() %>/insertApply.do");
			$(this).attr('method', 'post');
			$(this).submit();
		})
		
		<%-- $('#applyStudy').on('click', function(){
			form = $('#wrform').get(0);
			form.action = "<%= request.getContextPath() %>/insertApply.do?";
			form.submit();
		}) --%>
		
		//뷰에서 스터디 취소
		$('.cancelApply').on('click', function(){
			$('#cancelModal').modal('show');
			
			sbid = $(this).parent().parent().find('.dep').attr("value");
			$('.hiddenid').val(sbid);
		})
		
		//모달창에서 예약취소 버튼
		$('#cancelStudy').on('click', function(){
			var form = this.form;
			form.action = "<%= request.getContextPath() %>/deleteApply.do";
			form.submit();
		})
		
	})
	
</script>

</head>
<body>

	<div class="container">
	<h2>스터디모집</h2>
	
	<!-- 게시글 창 -->
	<form id="studyForm">
		<input type="hidden" name="mem_id" value="<%= svo.getMem_id() %>">
	            
		<table class="table">
			<thead>
				<tr class="table-info">
					<th colspan="3" id="title">[<%= svo.getSb_sort() %>] <%= svo.getSb_title() %></th>
				</tr>
			</thead>

			<tbody>
				<tr>
					<td id="writer"><%= svo.getSb_writer() %></td>
					<td></td>
					<td id="date"><%= svo.getSb_date() %></td>
				</tr>
			
		  		<tr>
					<td id="cont" colspan="3"><%= svo.getSb_cont() %>
						<br><br>
				<%
					String strDisable = "";
					for(StudyApplyVO rivo : studentVo){
						if(rivo.getMem_id().equals(loginMember.getMem_id())){
							strDisable = "disabled";
						}
					}
					if(loginMember != null && !loginMember.getMem_sort_nm().equals("교수")) {
				%>	
						<button type="button"  id="apply" <%= strDisable %> class="btn">
						신청하기 <img id="but-icon" src="<%=request.getContextPath()%>/images/icon/신청하기.PNG">
						</button>
						<input type="hidden" id="sb_num" name="sb_num" value="<%= svo.getSb_num() %>">
				<% } %>
					</td>
				</tr>
				
				
				<tr>
					<td colspan="3">
					<% if(loginMember != null && loginMember.getMem_id().equals(svo.getMem_id()) || loginMember.getMem_sort_nm().equals("교수")) { %>
				  		<!-- 로그인한 사람이랑 일치할때만 뜨도록 수정 -->
				  		<input type="button" value="수정" id="updateStudy" class="btn btn-dark">
				  		<input type="button" value="삭제" id="deleteStudy" class="btn btn-dark">
				  	<% } %>
					</td>
				</tr>
			</tbody>
  		</table>
  	</form>
  	</div>
  	
  	<!-- 예약 리스트 -->
  	<div class="container">
  	<form id="studyApplyForm">
  	<table class="table">
  		<thead>
			<tr class="table-info">
				<th colspan="4">예약 현황</th>
			</tr>
		</thead>
		
		<tbody>
			<tr>
				<td id="total" colspan="2">모집 인원 : <%= svo.getTotal_cnt() %></td>
				<td id="current" colspan="2">현재 인원 : <%= svo.getCurrent_cnt() %></td>
			</tr>
			
			<%
				for(StudyApplyVO rivo : studentVo){
			%>
		
			<tr>
				<td id="name"><%= rivo.getMem_name() %></td>
				<td id="gender"><%= rivo.getMem_gender() %></td>
				<td class="dep" value="<%= rivo.getMem_id() %>"><%= rivo.getMem_id() %></td>
				<td>
				<% if(loginMember != null && loginMember.getMem_id().equals(rivo.getMem_id()) || loginMember.getMem_sort_nm().equals("교수")) { %>
					<!-- 로그인 한 사람만 뜨게 -->
					<input type="button" value="취소" class="cancelApply" class="btn btn-dark">
				<% } %>
				</td>
			</tr>
		</tbody>
		<%
			}
		%>
  	</table>
  	<hr>
		<!-- 목록 -->
		<button type="button" id="studyList" class="btn">
			<img src="<%=request.getContextPath()%>/images/icon/목록아이콘.PNG">
		</button>
  	</form>
  	</div>
  	
  	<!-- 스터디 신청창 -->
	<div class="modal fade" id="insertModal">
	
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
	
				<!-- Modal Header -->
				<div class="modal-header">
				<h4 class="modal-title">스터디 신청</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					
				</div>
				
				<form id="wrform" onsubmit="resturn false;">
				<!-- Modal body -->
				<div class="modal-body">
						<label>이름 : <%= loginMember.getMem_name() %></label><br>
						<input type="hidden" name="mem_name" value="<%= loginMember.getMem_name() %>">
						
						<label>성별 : <%= loginMember.getMem_gender() %></label><br>
						<input type="hidden" name="mem_gender" value="<%= loginMember.getMem_gender() %>">
						
						<label>학번 : <%= loginMember.getMem_id() %></label><br>
						<input type="hidden" name="mem_id" value="<%= loginMember.getMem_id() %>">
						
						<input type="hidden" name="sb_num" class="hiddensb">
						
				</div>
				
				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="submit" class="btn btn-danger" id="applyStudy">확인</button>
					<button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
				</div>
				</form>
				
			</div>
		</div>
	</div>
	
	<!-- 스터디 취소창 -->
	<div class="modal fade" id="cancelModal">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
			
			<form id="delform">
				<!-- Modal Header -->
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				
				<!-- Modal body -->
				<div class="modal-body">
					
						<label>정말 취소하시겠습니까?</label>
						<input type="hidden" name="sb_num" value="<%= svo.getSb_num() %>">
						<input type="hidden" name="mem_id" class="hiddenid">
					
				</div>
				
				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" id="cancelStudy">예약 취소</button>
					<button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
				</div>
			</form>
			
			</div>
		</div>
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
					<form id="formdel">
						<label>정말 삭제하시겠습니까?</label>
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
</body>
</html>
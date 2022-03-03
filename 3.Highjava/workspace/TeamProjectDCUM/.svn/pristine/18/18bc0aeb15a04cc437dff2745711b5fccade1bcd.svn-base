<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.dcum.vo.Temp_ReservationVO"%>
<%@page import="kr.or.ddit.dcum.vo.temp_StudentInfoVO"%>
<%@page import="kr.or.ddit.dcum.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- jquery -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/updateInfo.css">
<script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<!-- 외부소스 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<% 
 List<Temp_ReservationVO> roomlist = (List<Temp_ReservationVO>)request.getAttribute("roomlist");
 List<Temp_ReservationVO> seatlist  = (List<Temp_ReservationVO>)request.getAttribute("seatlist");
MemberVO loginMember = (MemberVO)session.getAttribute("loginUser");
%>

<script type="text/javascript">
$(function(){
	$('#room-but').on('click',function(){
		rent_num = $('#rent_num').text()
		$.ajax({
			url:'<%=request.getContextPath()%>/deleteRoom.do',
			data : {'rent_num':rent_num},
			method : 'get',
			success : function(res){
				alert(res)
				location.href="<%=request.getContextPath()%>/allRentList.do"
			},
			error : function(xhr){
				alert("status : "+xhr.status);
			},
			dataType : 'json'
		})
	})
	
	$('.seat-but').on('click',function(){
		seat_num = $('#seat_num').text()
		now = new Date();
		systime = now.toLocaleTimeString()
		$.ajax({
			url:'<%=request.getContextPath()%>/updateSeat.do',
			data : {'seat_num':seat_num},
			method : 'get',
			success : function(res){
				alert(res)
				location.href="<%=request.getContextPath()%>/allRentList.do"
			},
			error : function(xhr){
				alert("status : "+xhr.status);
			},
			dataType : 'json'
		})
	})
	$('.end-but').on('click',function(){
		seat_num = $('#seat_num').text()
		$.ajax({
			url:'<%=request.getContextPath()%>/deleteSeat.do',
			data : {'seat_num':seat_num},
			method : 'get',
			success : function(res){
				alert(res)
				location.href="<%=request.getContextPath()%>/allRentList.do"
			},
			error : function(xhr){
				alert("status : "+xhr.status);
			},
			dataType : 'json'
		})
	})
	
	
})
</script>

<body>
	<div class="container">
		<br>
		<h3>시설물 예약현황</h3>
		<p id="p1">스터디룸/열람실 예약현황입니다.</p>
		<hr>
		<caption>[ 스터디룸 예약현황 ]</caption>
		<table class="table dark-table">
			<thead class="thead-dark">
				<tr>
					<th>스터디룸</th>
					<th>예약날짜</th>
					<th>예약시간</th>
					<th>신청인원</th>
					<th>예약취소</th>
				</tr>
			</thead>
			<tbody>
			<%if(roomlist==null){%>
				<tr>
					<td>
					<p style="text-align: center;">예약내역이 없습니다.</p>
					<td>
				</tr>
			<%}else{ 
				for(Temp_ReservationVO r : roomlist){
			%>
				<tr>
					<td class="room" id="rent_num"><%=r.getRent_num()%></td>
					<td class="room" id="rent_date"><%=r.getRent_date()%></td>
					<td class="room" id="rent_time"><%=r.getRent_time()%></td>
					<td class="room" id="rent_count"><%=r.getRent_count()%></td>
					<td class="room">
						<button class="btn btn-warning" id="room-but">취소</button>
					</td>
				</tr>
			<%}}%>
			</tbody>
		</table>
		<br>
		<hr>
		<caption>[ 열람실 예약현황 ]</caption>
		<table class="table dark-table">
			<thead class="thead-dark">
				<tr>
					<th>좌석번호</th>
					<th>시작시간</th>
					<th>종료시간</th>
					<th>사용연장</th>
					<th>사용종료</th>
				</tr>
			</thead>
			<tbody>
			<%if(seatlist==null){%>
				<tr>
					<td>
					<p style="text-align: center;">예약내역이 없습니다.</p>
					<td>
				</tr>
			<%}else{ 
				for(Temp_ReservationVO s : seatlist){
			%>
				<tr>
					<td class="seat" id="seat_num"><%=s.getSeat_num()%></td>
					<td class="seat" id="start_time"><%=s.getStart_time()%></td>
					<td class="seat" id="end_time"><%=s.getEnd_time()%></td>
					<td class="seat">
						<button class="btn btn-warning seat-but">사용연장</button>
					</td>
					<td class="seat">
						<button class="btn btn-warning end-but">사용종료</button>
					</td>
				</tr>
			<%}}%>
			</tbody>
		</table>

		<hr>


	</div>
</body>
</html>
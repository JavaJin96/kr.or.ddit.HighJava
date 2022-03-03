<%@page import="kr.or.ddit.dcum.vo.temp_StudentInfoVO"%>
<%@page import="kr.or.ddit.dcum.vo.StudentVO"%>
<%@page import="kr.or.ddit.dcum.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">
<head>
<title>Bootstrap Card</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- jquery -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/reservation.css">
<script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<!-- 외부소스 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<style>
#but-zip {
	margin-top: 3%;
}
div{
	display: inline-block;
}
#re-div{
float: left;
}
</style>
<script>

$(function() {
// 1. 예약하기 버튼 클릭
	$('.re-but').on('click', function() {
		
		$('#re-div').show();
		rent_num = $(this).attr('name');
		$('.roomName').text("[스터디룸 "+rent_num+"호] 예약하기")
			
	// 1-1. 예약 상세 팝업생성==================================		
		// 1)스터디룸 예약 불러오기(select)	
		$('#rent_date').on('change', function() {
			$('#but-zip').show();
			rent_date = $('#rent_date').val();
			rent_num = rent_num
			$.ajax({
				url : '<%=request.getContextPath()%>/searchRoomrent.do',
				data : {
					'rent_date' : rent_date ,
					'rent_num' : rent_num 
					},
				success : function(res){
					rent_time = ""
					$.each(res,function(i,v){
						rent_time = v.rent_time;
						$('.time-but').each(function(j,z){
							if($(z).text()==rent_time){
								$(z).attr('disabled',true)
							}
						})
					})
				},
				error : function(xhr){
					alert("status : "+xhr.status)
				},
				dataType : 'json'
			})
			
			// 2)스터디룸 예약(insert)==================================		
			// 2-1) 날짜 , 시간 , 인원 선택		
			$('.time-but').on('click', function() {
				$('.time-but').css({'background-color':'white','color':'gray'})
				$(this).css({'background-color':'gray','color':'white'})
				rent_time = $(this).text()
			})
			
			// 2-2) 예약하기 버튼(servlet이동)
			$('#submit').on('click', function() {
				rent_count = $('#rent_count').val();
				$.ajax({
					url :'<%=request.getContextPath()%>/insertRoomrent.do',
					data : {
						'rent_date' : rent_date,
						'rent_time' : rent_time, 
						'rent_num'  : rent_num ,
						'rent_count': rent_count
						},
					type:'post',	
					success : function(res){
						alert("["+rent_num+"호]"+res)
						$('#re-div').text("").hide()
						location.href="<%=request.getContextPath()%>/allRentList.do"
					},
					error : function(xhr){
						alert("status : "+xhr.status)
					},
					dataType : 'json'
				})
			})
			
		})
	})
// ==========================================	
now = new Date();
// sysdate = today.toLocaleString();
// 2. 필터 클릭해서 열람실 불러오기	
		$('#filter').on('change', function() {
			 $('.res').val("").hide();
			 roomType= $('#filter').val();
			 // 필터 열람실 클릭시
			 if(roomType=="seat"){
				$('.room').hide();
				$('.seat').show();
				
				// 열람실 현재 예약현황 불러오기 
				$.ajax({
					url : '<%=request.getContextPath()%>/searchSeatrent.do',
					success : function(res){
						seat_num = ""
						$.each(res,function(i,v){
							seat_num = v.seat_num;
							$('.seat-but').each(function(j,z){
								if($(z).text()==seat_num){
									$(z).attr('disabled',true)
								}
							})
						})
					},
					error : function(xhr){
						alert("status : "+xhr.status)
					},
					dataType : 'json'
				})
				
				
				
				//1) 좌석 클릭시 열람실 예약정보 띄우기
				$('.seat-but').on('click', function() {
					seat_num=$(this).text();
					start_time = now.toLocaleTimeString();
					now.setHours(now.getHours() + 2);
					end_time = now.toLocaleTimeString();
// 					end_time = now.toLocaleTimeString().setHours(now.toLocaleTimeString().getHours(2)) 
			 		$('.res-seat').show();
			 		$('#seat_num').text(seat_num);
			 		$('#start_time').empty().text(start_time);
			 		$('#end_time').empty().text(end_time);
				})
				//2) 예약버튼클릭
				$('#seat-res-but').on('click',function(){
					$.ajax({
						url : '<%=request.getContextPath()%>/insertSeatrent.do',
						data : { 
							'seat_num' : seat_num
						},
						type : 'get',
						success : function(res){
							alert("["+seat_num+"]번 좌석"+res)
							location.href="<%=request.getContextPath()%>/allRentList.do"
						},
						error : function(xhr){
							alert("status : "+xhr.status)
						},
						dataType : 'json'
						})
					})
			// 필터 스터디룸 클릭시	
			 }else{
				 $('.room').show();
				 $('.seat').hide();
			 }
		})
//====================================================		
		
})
</script>
</head>
<%
	MemberVO loginMember = (MemberVO)session.getAttribute("loginUser");
	temp_StudentInfoVO studentInfo = (temp_StudentInfoVO) session.getAttribute("studentInfo");
%>
<body>
	<div class="container">
		<header>
			<br>
			<h3>시설물 예약</h3>

			<select id="filter" style="float: right;">
				<option value="room" selected>스터디룸</option>
				<option value="seat">열람실</option>
			</select>

		</header>

		<!-- 스터디룸 -->
		<div class="content room">
			<span id="p1">스터디룸 예약하기</span>
			<hr>
			<div class="card">
				<img class="card-img-top" src="../../images/classImage/스터디룸2.jpg"
					alt="Card image" style="width: 100%">
				<div class="c-body" style="height: 100%">
					<h4 class="card-title">스터디룸 201호</h4>
					<p class="card-text">대형 스크린 공기청정기<br>수용인원 : 6명(최소 3명)</p>
					<button class="re-but btn btn-info" name="201">예약하기</button>
				</div>
			</div>

			<div class="card">
				<img class="card-img-top" src="../../images/classImage/스터디룸2.jpg"
					alt="Card image" style="width: 100%">
				<div class="c-body">
					<h4 class="card-title">스터디룸 202호</h4>
					<p class="card-text">대형 스크린 공기청정기<br>수용인원 : 6명(최소 3명)</p>
					<button class="re-but btn btn-info" name="202">예약하기</button>
				</div>
			</div>
		</div>

		<!-- 열람실 -->
		<div class="content seat" style="display: none;">
			<span id="p1">열람실 예약하기</span>
			<hr>
			<span>코로나19 방역수칙에 의거 한칸씩 띄워앉아 주세요.</span> <br> <br>
			<div id="seat-table">
			<table id="seat" name="100" style="width:unset">
				<tr>
					<td>
						<button type="button" class="seat-but">1</button>
						<button type="button" class="seat-but" disabled>2</button>
						<button type="button" class="seat-but">3</button>
						<button type="button" class="seat-but" disabled>4</button>
					</td>
					<td>
						<button type="button" class="seat-but">5</button>
						<button type="button" class="seat-but" disabled>6</button>
						<button type="button" class="seat-but">7</button>
						<button type="button" class="seat-but" disabled>8</button>
					</td>
				</tr>
				<tr>
					<td>
						<button type="button" class="seat-but" disabled>9</button>
						<button type="button" class="seat-but">10</button>
						<button type="button" class="seat-but" disabled>11</button>
						<button type="button" class="seat-but">12</button>
					</td>
					<td>
						<button type="button" class="seat-but" disabled>13</button>
						<button type="button" class="seat-but">14</button>
						<button type="button" class="seat-but" disabled>15</button>
						<button type="button" class="seat-but">16</button>
					</td>
				</tr>
				<tr>
					<td>
						<button type="button" class="seat-but">17</button>
						<button type="button" class="seat-but" disabled>18</button>
						<button type="button" class="seat-but">19</button>
						<button type="button" class="seat-but" disabled>21</button>
					</td>
					<td>
						<button type="button" class="seat-but">22</button>
						<button type="button" class="seat-but" disabled>23</button>
						<button type="button" class="seat-but">24</button>
						<button type="button" class="seat-but" disabled>25</button>
					</td>
				</tr>
				<tr>
					<td>
						<button type="button" class="seat-but" disabled>26</button>
						<button type="button" class="seat-but">27</button>
						<button type="button" class="seat-but" disabled>28</button>
						<button type="button" class="seat-but">29</button>
					</td>
					<td>
						<button type="button" class="seat-but" disabled>30</button>
						<button type="button" class="seat-but">31</button>
						<button type="button" class="seat-but" disabled>32</button>
						<button type="button" class="seat-but">33</button>
					</td>
				</tr>
				<tr id="ipgu">
					<td colspan="2" style="height: 20px"><br>🚪 입구</td>
				</tr>
			</table>
			</div>

			<div class="res res-seat" style="display: none;float: right;width:60%">
				<h5 style="font-weight: bold">예약자 정보</h5>
				<p>
					열람실은 예약시간부터 2시간 동안 이용가능합니다.<br> 시간연장은 종료시간 30분 전부터 가능합니다. 
				</p>
				<table class="table table-bordered">
					<tr>
						<th class="table-success res-head">학 번</th>
						<td><%=loginMember.getMem_id()%></td>
						<td rowspan="4" style="vertical-align: bottom;">
							<button id="seat-res-but" class="btn btn-info btn-block" >예약</button>
						</td>
					</tr>
					<tr>
						<th class="table-success res-head">좌 석 번 호</th>
						<td id="seat_num" name="seat_num"></td>
					</tr>
					<tr>
						<th class="table-success res-head">시 작 시 간</th>
						<td id="start_time" name="start_time"></td>
					</tr>
					<tr>
						<th class="table-success res-head">종 료 시 간</th>
						<td id="end_time" name="end_time"></td>
					</tr>
				</table>
			</div>
		</div>

		<footer>
			<br>
			<div class="content res res-room" id="re-div" style="display: none;">
				<h5 class="roomName"></h5>
				<table class="table table-hover">
					<tr>
						<th>예약자</th>
						<td><%=loginMember.getMem_name() %>
						<!--아이디 검색해서 이름 도출 
							<input type="text" name="mem_id" id="mem_id">
 							<button id="searchId-but" class="btn btn-dark btn-sm">검색</button>
 							<div id="alert1" style="display: inline-block;margin-left:1% "></div> -->
						</td>
					</tr>
					<tr>
						<th>예약날짜</th>
						<td><input type="date" name="rent_date" id="rent_date">
							<!-- 							<button class="btn btn-dark btn-sm">가능여부확인</button> -->
							<div id="alert2"></div>
							<div id="but-zip" style="display: none;">
								<button type="button" class="time-but btn btn-outline-secondary btn-sm">10:00</button>
								<button type="button" class="time-but btn btn-outline-secondary btn-sm">11:00</button>
								<button type="button" class="time-but btn btn-outline-secondary btn-sm">12:00</button>
								<button type="button" class="time-but btn btn-outline-secondary btn-sm">13:00</button>
								<button type="button" class="time-but btn btn-outline-secondary btn-sm">14:00</button>
								<button type="button" class="time-but btn btn-outline-secondary btn-sm">15:00</button>
								<button type="button" class="time-but btn btn-outline-secondary btn-sm">16:00</button>
							</div></td>
					</tr>
					<tr>
						<th>사용인원</th>
						<td>
							<input type="number" min="3" max="6" 
							id="rent_count" name="rent_count"> (최소인원: 3명 / 최대인원 : 6명)
						</td>
					</tr>
				</table>
				<button id="submit" class="btn btn-dark">예약하기</button>
			</div>
		</footer>



	</div>
</body>
</html>
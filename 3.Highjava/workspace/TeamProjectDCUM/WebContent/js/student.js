

	studentSum = function(){
		$.ajax({
			url : "/TeamProjectDCUM/StudentSum.do",			
			type :"get",
			success : function(res){
				alert(res.sw);
				
				
			},
			
			error : function(xhr){
				alert("상태 : " + xhr.status);
				
			},
			
			
			dataType : 'json'
		
		
		});
	}
	
	
	//매일 전송 js
	mymailto = function(){
			$.ajax({
				url : "/TeamProjectDCUM/MailInsert.do",
				data : $('#mailin').serializeArray(),
				type : 'post',
				success : function(res){
				
				
				
				},
				error : function(xhr){
					alert("상태 : " + xhr.status);
				},
				dataType : 'json'
				
			
			
			});
			
		}
		
	
	//수강신청 수정 예정
	
	updateStudentStatus = function(){
		alert("js도착")
		$.ajax({
			url : "<%=request.getContextPath()%>/StudentList.do",
			type: "get",
			success : function(res){
				Icode ='<div>'
				Icode +='<h2>학생 정보</h2>'
				Icode +='<p>환영합니다. DDIT UNIVERSITY</p>'
				Icode +='<div class="card" style="width:400px">'
				Icode +='<img class="card-img-top" src="../images/main/사자2.jpg" alt="Card image" style="width:100%">'
				Icode +='<div class="card-body">'
				Icode +='<h4 class="card-title">'+'<%=loginMember.getMem_name()%>'+'</h4>'
				Icode +='<p class="card-text">대덕사이버대학교</p>'		
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
	}
		
		
		
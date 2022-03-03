<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
	String cookieUserId = "";	// 쿠키에 저장된 userID값이 저장될 변수
	String chk = ""; 	// 체크박스 체크용 변수
	
	Cookie[] cookies = request.getCookies();
	if(cookies != null || cookies.length > 0 ){
		for(Cookie ck : cookies){
			if(ck.getName().equals("userID")){
				//내가 찾는 쿠키명인지 확인
				cookieUserId = ck.getValue();	// 쿠키값 구하기
				chk = "checked";
				
			}
		}
	}
	
%>
<title>로그인 페이지</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/cookieLoginServlet.do" method="post">
		<table style="margin:0 auto;">
			<tr>
				<td>ID : </td>
				<td> <input type="text" name="userid" value="<%=cookieUserId %>" placehoder="ID를 입력하세요." ></td>				
			</tr>
			<tr>
				<td>PASS : </td>
				<td> <input type="password" name="userpass" placehoder="Password를 입력하세요." ></td>				
			</tr>
			<tr>
				<td colspan="2">
					<input type="checkbox" name="chkid" value="check" <%=chk %>> ID기억하기
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align:center;">
					<input type="submit" value="Login"> ID기억하기
				</td>
			</tr>
		</table>
	</form>
	
	
	
	
</body>
</html>
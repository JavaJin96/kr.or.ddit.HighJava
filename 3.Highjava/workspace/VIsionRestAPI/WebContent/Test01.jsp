<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
    <script>
        // SDK를 초기화 합니다. 사용할 앱의 JavaScript 키를 설정해 주세요.
        Kakao.init('118061b034a20645132f9680a2908f7c');

        // SDK 초기화 여부를 판단합니다.
        console.log(Kakao.isInitialized());
    </script>


</body>
</html>
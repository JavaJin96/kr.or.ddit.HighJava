<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 카드 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<style>
/*---------------------- 슬라이드 ----------------------------*/
.slider{
    width: 1040px;
    height: 390px;
    position: relative;
    margin: 3% auto;
    overflow: hidden; /* 현재 슬라이드 오른쪽에 위치한 나머지 슬라이드 들이 보이지 않도록 가림 */
/*     text-align: center; */
	display: flex;
}
.slider input[type=radio]{
    display: none;
}
img{
	width : 1040px;
	height : 390px;
}

ul.imgs{
    padding: 0;
    margin: 0;
    list-style: none;    
}
ul.imgs li{
    position: absolute;
    left: 640px;
    transition-delay: 1s; /* 새 슬라이드가 이동해 오는 동안 이전 슬라이드 이미지가 배경이 보이도록 지연 */
    padding: 0;
    margin: 0;
}

.bullets{
    position: absolute;
    left: 50%;
    transform: translateX(-50%);
    bottom: -6px;
    z-index: 2;
}

.bullets label{
    display: inline-block;
    border-radius: 50%;
    background-color: rgba(0,0,0,0.55);
    width: 20px;
    height: 20px;
    cursor: pointer;
}

/* 현재 선택된 불릿 배경 흰색으로 구분 표시 */
.slider input[type=radio]:nth-child(1):checked~.bullets>label:nth-child(1){
    background-color: orange;
}

.slider input[type=radio]:nth-child(2):checked~.bullets>label:nth-child(2){
    background-color: orange;
}

.slider input[type=radio]:nth-child(3):checked~.bullets>label:nth-child(3){
    background-color: orange;
}

.slider input[type=radio]:nth-child(4):checked~.bullets>label:nth-child(4){
    background-color: orange;
}

 .slider input[type=radio]:nth-child(1):checked~ul.imgs>li:nth-child(1){ 
     left: 0; 
     transition: 0.5s; 
     z-index:1; 
 } 

 .slider input[type=radio]:nth-child(2):checked~ul.imgs>li:nth-child(2){ 
     left: 0; 
     transition: 0.5s; 
     z-index:1; 
 } 

 .slider input[type=radio]:nth-child(3):checked~ul.imgs>li:nth-child(3){ 
     left: 0; 
     transition: 0.5s; 
     z-index:1; 
 } 

 .slider input[type=radio]:nth-child(4):checked~ul.imgs>li:nth-child(4){ 
     left: 0; 
     transition: 0.5s; 
     z-index:1; 
 } 

</style>


</head>
<body>

	<div class="slider" targer="ifr">
	    <input type="radio" name="slide" id="slide1" checked>
	    <input type="radio" name="slide" id="slide2">
	    <input type="radio" name="slide" id="slide3">
	    <input type="radio" name="slide" id="slide4">
	    
	    <ul id="imgholder" class="imgs">
	        <li><img src="../../images/main/학생.jpg"  targer="ifr"></li>
	        <li><img src="../../images/main/학생2.jpg" targer="ifr"></li>
	        <li><img src="../../images/main/학생3.jpg" targer="ifr"></li>
	        <li><img src="../../images/main/학생4.jpg" targer="ifr" ></li>
	    </ul>
	    
	    <div class="bullets">
	        <label for="slide1">&nbsp;</label>
	        <label for="slide2">&nbsp;</label>
	        <label for="slide3">&nbsp;</label>
	        <label for="slide4">&nbsp;</label>
	    </div>
	</div>


</body>
</html>
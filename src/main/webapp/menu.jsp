<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style type="text/css">
nav#sub_menu { /* 서브메뉴 왼쪽으로 위치 */
	float: left;
	margin-right: 10px;
	font-family: "맑은 고딕";
	text-align: center;
}

nav#sub_menu ul li {
	list-style-type: none;
	margin-top: 10px;
}

nav#sub_menu a {
	text-decoration: none;
	color: #666;
	border-bottom: 1px dotted #999;
	display: block;
	width: 100px;
	height: 25px;
	padding: 5px;
}

nav#sub_menu a:hover {
	border-bottom: 1px solid black;
}

nav#sub_menu ul {
	margin-left: -20px;
}

button{
	color: white;
	background-color: #464646;
	width: 80px; 
	height: 33px;
}
</style>

<nav id="sub_menu">
	<ul>
		<li><a href='getSignMain.do'>메인 화면</a></li>
		<li><a href='signForm.do'>기안서 작성</a></li>
		<br />
		<li><a href='getSignTemList.do'>임시 저장함</a></li>
		<li><a href='getSignBackList.do'>반려 문서함</a></li>
		<br />
		<li><a href='getSignSenList.do'>결재 상신함</a></li>
		<li><a href='getSignRecList.do'>결재 수신함</a></li>
		<li><a href='getSignCmpList.do'>완료 문서함</a></li>
	</ul>
	<br />
	<p align="center">
	<button onclick="location.href='logout.do'"><b>Logout</b></button>
	</p>
</nav>
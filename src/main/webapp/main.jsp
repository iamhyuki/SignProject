<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
<link rel="stylesheet" href="css/sign.css">

</head>
<body>
<%@ include file="menu.jsp" %>

<div class="page">
<h2 align="right">${user.name }(${user.rank})님 반갑습니다.&nbsp;&nbsp;&nbsp;</h2> <!-- 사용자이름, 직급 -->
<br />
	<div align="center">
		<table class="mainT" border="1" >
			<tr bgcolor="#c8c8c8">
				<td>임시저장</td>
				<td>반려</td>
				<td>상신</td>
				<td>수신</td>
				<td>완료</td>
			</tr>
			<tr>
				<td><a href="getSignTemList.do">${signCount[0]}건</a></td>
				<td><a href="getSignBackList.do">${signCount[1]}건</a></td>
				<td><a href="getSignSenList.do">${signCount[2]}건</a></td>
				<td><a href="getSignRecList.do">${signCount[3]}건</a></td>
				<td><a href="getSignCmpList.do">${signCount[4]}건</a></td>
			</tr>
		</table>
	</div>
</div>
</body>
</html>
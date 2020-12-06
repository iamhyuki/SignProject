<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
</head>
<body>
 	<div align="center">
 		<h1>로그인페이지</h1>
 		<hr>
 		<form action="getUser.do" method="post">
 			<table>
	 			<tr>
 					<td><b>ID</b></td>
 					<td><input type="text" name="user_id" value="${easyLogin.user_id }" size="15"></td>
 				</tr>
 				<tr>
 					<td><b>PASSWORD</b></td>
 					<td><input type="password" name="user_pw" value="${easyLogin.user_pw }" size="15"></td>
 					<td colspan="2"><input type="submit" value="로그인"></td>
 				</tr>
 				<tr>
 				</tr>
 			</table>
 		</form>
 	</div>
</body>
</html>
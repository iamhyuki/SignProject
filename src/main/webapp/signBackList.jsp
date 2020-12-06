<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>반려문서함</title>
<link rel="stylesheet" href="css/sign.css">

</head>
<body>
<%@ include file="menu.jsp" %>

<div class="page">
	<h2 align="right">${user.name }(${user.rank})님의 반려문서함입니다.&nbsp;&nbsp;&nbsp;</h2>
	<br />
	<div align="center">
		<table class="tableTSB" border="1" >
			<tr bgcolor="#c8c8c8">
				<td>결재번호</td>
				<td>제목</td>
				<td>작성일</td>
				<td>문서상태</td>
			</tr>
			<c:if test="${empty backList}">
				<td colspan="4" align="center">반려된 문서가 없습니다.</td>
			</c:if>
			<c:forEach items="${backList }" var="list">
			<tr>
				<td>${list.doc_code }</td>
				<td><a href="getSignDocDetail.do?doc_code=${list.doc_code }">${list.title}</a></td>
				<td>${list.writedate }</td>
				<td>반려</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<% 
	SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기안서 작성 페이지</title>
<link rel="stylesheet" href="css/sign.css">
<script src="script/jquery-2.2.3.min.js"></script>
<script src="script/sign.js"></script>
</head>


<body>
<%@ include file="menu.jsp" %>
	
<div class="page" style="width: 1024px;">
	
	<h1 align="center">기안서</h1>
	
	<div align="right">
		<input type="button" value="결재선지정" onclick="lineUp();"/>
		<input type="submit" value="임시저장" onclick="insertTemp()"/>
		<input type="button" value="작성취소" onclick="goBack();"/>
	</div>
	
	<form name="formm" action="insertSignDoc.do?doc_status=1" method="post" enctype="multipart/form-data">
	<input type="hidden" id="user_id" name="user_id" value="${user.user_id }">
	<input type="hidden" name="name" value="${user.name }">
	<input id="doc_status" type="hidden" name="doc_status" value="1">
	<input type="hidden" id="sign_turn" name="sign_turn" value="" />
	<div class="tables">
		
		<table border="1">
			<tr>
				<td width="100">결재번호</td>
				<td>자동채번</td>
			</tr>
			<tr>
				<td width="100">기안자</td>
				<td>${user.name }</td> 
			</tr>
			<tr>
				<td width="100">작성일자</td>
				<td><%= sd.format(new Date()) %></td>
			</tr>
		</table>
		
		<div id="signTable" align="right">
			<!-- 결재선 지정 시 테이블 요소 삽입예정 -->
		</div>
	</div>
	
	<div style="position:relative; margin: 10px 0px 0px 10px;">
		<table>
			<tr>
				<td>제목 :</td>
				<td><input type="text" name="title" size="100" style="float: left;"></td>
			</tr>
			<tr>
				<td colspan="2">
				<textarea rows="50" cols="100" name="content" placeholder="내용을 입력하세요." style="width:990px; height: 500px;"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">첨부파일&nbsp;&nbsp;<input type="button" value="파일추가" onclick="addFileIndex();"></td>
			</tr>
			<tr>
				<td id="fileIndex" colspan="2"></td>
			</tr>
		</table>
	</div>
	<br />
	<p align="center"><input type="submit" value="결재요청" /></p>
	</form>
</div>
	
</body>
</html>
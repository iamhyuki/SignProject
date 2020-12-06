<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
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
		<input type="button" value="기안서삭제" onclick="location.href='deleteSignDoc.do?doc_code=${doc.doc_code}'" />
		<input type="button" value="작성취소" onclick="goBack();"/>
	</div>
	
	<form action="updateSignDoc.do" method="post" enctype="multipart/form-data" name="formm">
	<input type="hidden" id="user_id" name="user_id" value="${user.user_id}" />
	<input type="hidden" name="doc_code" value="${doc.doc_code}" />
	<input type="hidden" id="sign_turn" name="sign_turn" value="${G_COUNT-1}" />
	<input type="hidden" id="file_sysname" name="file_sysname" value="" />
	<input type="hidden" id="del_file" name="del_file[]" value="" />
	<div class="tables">
		
		<table border="1">
			<tr>
				<td width="100">결재번호</td>
				<td>${doc.doc_code }</td>
			</tr>
			<tr>
				<td width="100">기안자</td>
				<td>${doc.name }</td> 
			</tr>
			<tr>
				<td width="100">작성일자</td>
				<td>${doc.writedate }</td>
			</tr>
		</table>
		
		<div id="signTable" align="right">
			<!-- 결재선 지정 시 테이블 요소 삽입예정 -->
			<c:forEach items="${group }" var="group">
				<div>
					<input type="hidden" value="${group.sign_turn }" name="s_turn[]">
					<input type="hidden" value="${group.sign_id }" name="s_id[]">
					<input type="hidden" value="${group.sign_type }" name="s_type[]">
					<table border="1">
						<tr>
							<td>${group.sign_type }</td>
						</tr>
						<tr>
							<td>${group.name }(${group.rank })</td>
						</tr>
						<tr>
							<td>
								<c:if test="${group.sign_status == 0}">-</c:if>
								<c:if test="${group.sign_status == 1}">결재</c:if>
							</td>
						</tr>
					</table>
				</div>
			</c:forEach>
		</div>
	</div>
	
	<div style="position:relative; margin: 10px 0px 0px 10px;">
		<table>
			<tr>
				<td>제목 :</td>
				<td><input type="text" name="title" size="100" value="${doc.title}"></td>
			</tr>
			<tr>
				<td colspan="2">
				<textarea rows="50" cols="100" name="content" placeholder="내용을 입력하세요." 
				style="width:990px; height: 500px;">${doc.content}</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">첨부파일&nbsp;&nbsp;<input type="button" value="파일추가" onclick="addFileIndex();"></td>
			</tr>
			<c:forEach items="${file }" var="file">
			<tr>
				<td colspan="2">
				<a href="#" onclick="fileDown('${file.sysname}'); return false;">${file.orgname }</a>&nbsp;&nbsp;
				<input type="button" id="Del_Btn" onclick="fileDelBtn('${file.sysname}');" value="첨부파일삭제">
			</tr>
			</c:forEach>
			<tr>
				<td colspan="2" id="fileIndex"></td>
			</tr>
		</table>
	</div>
	<br />
	<p align="center"><input type="submit" value="결재요청" /></p>
	
	</form>
</div>
	
</body>
</html>
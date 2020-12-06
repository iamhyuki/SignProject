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
		<label>문서상태 : 
		<c:if test="${doc.doc_status== 1 }">대기중</c:if>
		<c:if test="${doc.doc_status== 2 }">심사중</c:if>
		<c:if test="${doc.doc_status== 3 }">반려</c:if>
		<c:if test="${doc.doc_status== 4 }">결재완료</c:if>
		</label>
	</div>
	<form name="formm" enctype="multipart/form-data" method="post">
		<input type="hidden" id="file_sysname" name="file_sysname" value="" />
	</form>
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
			<c:forEach items="${group }" var="group">
				<div>
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
				<td><input type="text" size="100" value="${doc.title }" readonly="readonly"></td>
			</tr>
			<tr>
				<td colspan="2">
				<textarea rows="50" cols="100" placeholder="내용을 입력하세요."
				 style="width:990px; height: 500px;" readonly="readonly">${doc.content }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">첨부파일</td>
			</tr>
			<c:forEach items="${file }" var="file">
			<tr>
				<td colspan="2">
				<a href="#" onclick="fileDown('${file.sysname}'); return false;">${file.orgname }</a>
			</tr>
			</c:forEach>
		</table>
	</div>
	<br />
	<p align="center">
	
	<!-- 사용자가 결재순서의 결재자이면서 문서상태가 1,2일 경우 생성 -->
	<c:if test="${doc.doc_status == 1 || doc.doc_status == 2}">
		<c:if test="${doc.user_id != user.user_id}">
			<c:if test="${doc.sign_id == user.user_id}">
				<button onclick="location.href='updateStatus.do?doc_code=${doc.doc_code}&sign_id=${user.user_id}&doc_status=5'">결재</button>&nbsp;&nbsp;&nbsp;
				<button onclick="location.href='updateStatus.do?doc_code=${doc.doc_code}&doc_status=3'">반려</button>&nbsp;&nbsp;&nbsp;
			</c:if>
			<!-- 결재순서의 결재자가 아닌 경우 -->
			<c:if test="${doc.sign_id != user.user_id}">
				<button onclick="waitAlert();">결재대기</button>&nbsp;&nbsp;&nbsp;
			</c:if>
		</c:if>
	</c:if>

	<!-- 기안자와 사용자가 같으며 문서상태가 1,3(대기,반려)상태의 경우 생성 -->
	<c:if test="${doc.doc_status == 1 || doc.doc_status == 3}">
		<c:if test="${user.user_id == doc.user_id}">
			<button onclick="location.href='updateStatus.do?doc_code=${doc.doc_code}&doc_status=0'">회수</button>&nbsp;&nbsp;&nbsp;
		</c:if>
	</c:if>
	<!-- 기본세팅 버튼 -->
		<button onclick="goBack();">목록으로</button>
	</p>
</div>
	
</body>
</html>
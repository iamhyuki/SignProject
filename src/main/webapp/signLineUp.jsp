<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결재선 지정화면</title>
<script src="script/jquery-2.2.3.min.js"></script>

<script type="text/javascript">
	$(document).ready(
			function() {

				$('#c').click(
						function() {
							var val1 = $('#s1 option:selected').val();
							var text1 = $('#s1 option:selected').text();

							var op1 = "<option value="+ val1 + ">" + text1
									+ " /합의" + "</option>";

							$('#s2').prepend(op1);
						}); // 합의로 추가

				$('#s').click(
						function() {
							var val1 = $('#s1 option:selected').val();
							var text1 = $('#s1 option:selected').text();

							var op1 = "<option value="+ val1 + ">" + text1
									+ " /결재" + "</option>";

							$('#s2').prepend(op1);
						}); // 결재로 추가

				$('#d').click(function() {
					$('#s2 option:selected').remove();
				}); // 선택항목 제거

				$("#up").click(function() {
					var opt = $("#s2 option:selected");
					if (opt.size() > 0) {
						opt.insertBefore(opt.prev());
					}
				}); // 선택항목 순서 위로

				$("#down").click(function() {
					var opt = $("#s2 option:selected");
					if (opt.size() > 0) {
						opt.insertAfter(opt.next());
					}
				}); // 선택항목 순서 아래로

				$('#check').click(function() {
					var optVal = new Array();
					var optText = new Array();

					$(opener.document).find('#signTable').empty();	
					
					var size = $('#s2').children().size()-1;
					
					for (var i = 0; i < $('#s2').children().size(); i++) {			
						optVal[i] = $('#s2').children().eq(i).val();
						optText[i] = $('#s2').children().eq(i).text();
						
						var type = optText[i].substring(optText[i].lastIndexOf("/")+1);
						var user = optText[i].substring(0, optText[i].lastIndexOf("/"));
						var userid = optVal[i];
						
						
						var turnStr = "<input type=hidden value = " + i + " name=s_turn[] />";
						var idStr = "<input type=hidden value= " + userid + " name=s_id[] />";
						var typeStr = "<input type=hidden value= " + type + " name=s_type[] />"; 
						var tagStr = "<div><table border=1><tr><td><b>" + type + "</b></td></tr><tr><td>"
										+ user + "</td></tr><tr><td>-</td></tr></table></div>"

						var allStr = turnStr + idStr + typeStr + tagStr;
				
						$(opener.document).find('#signTable').append(allStr);
						$(opener.document).find('#sign_turn').attr("value", size);
					}
					self.close();
				}); // 지정완료 => 부모 태그에 값 추가

			});
</script>
</head>

<body>
	<div align="center">
		<h3>결재선 지정 페이지입니다.</h3>
		<h6>결재 순서는 아래 사용자부터 위로 차례대로 진행되며, 맨 위의 사용자는 최종 결재자입니다.</h6>
		<table>
			<tr>
				<td>
				
				<select id="s1" size="10" style="width: 150px">
					<!-- 사원목록 option 생성 -->
					<c:forEach items="${userList }" var="list">
						<option value="${list.user_id}">${list.name}(${list.rank})</option>
					</c:forEach>
				</select>
				
				</td>
				<td>
					<button id="c">합의→</button> <br />
					<button id="s">결재→</button> <br /> <br />
					<button id="d">←제거</button>
				</td>
				<td><select id="s2" size="10" style="width: 180px">

				</select></td>
				<td>
					<button id="up">↑</button> <br /> <br />
					<button id="down">↓</button>
				</td>
			</tr>
		</table>
		<br />
		<button id="check">지정완료</button>
	</div>
</body>

</html>
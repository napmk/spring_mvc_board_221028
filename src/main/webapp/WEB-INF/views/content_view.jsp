<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>글내용보기</title>
</head>
<body>	
	<h2>글내용보기</h2>
	<hr>
	 <table border="1" cellpadding="0" cellspacing="0" width="500">
	 	<tr>
	 		<th width="100">글번호</th>
	 		<td>${content.bid }</td>
	 	</tr> 
	 	<tr>
	 		<th>글쓴이</th>
	 		<td>${content.bname }</td>
	 	</tr> 
	 	<tr>
	 		<th>글제목</th>
	 		<td>${content.btitle }</td>
	 	</tr> 
	 	<tr>
	 		<th valign="top">내용</th>
	 		<td height="300" valign="top">${content.bcontent }</td>
	 	</tr> 
	 	<tr>
	 		<th>등록일</th>
	 		<td>${content.bdate }</td>
	 	</tr> 
	 	<tr>
	 		<td colspan="2" align="right">
	 			<input type="button" value="답변" onclick="javascript:window.location='reply_write?bid=${content.bid}'">
	 			<input type="button" value="수정" onclick="javascript:window.location='modify_view?bid=${content.bid}'">
	 			<input type="button" value="삭제" onclick="javascript:window.location='delete?bid=${content.bid }'">
	 			<input type="button" value="목록" onclick="javascript:window.location='list'">
	 		</td>
	 	</tr>
	</table>
</body>
</html>
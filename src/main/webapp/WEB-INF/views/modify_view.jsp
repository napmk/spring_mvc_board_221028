<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>글내용수정</title>
</head>
<body>	
	<h2>글내용수정</h2>
	<hr>
	 <table border="1" cellpadding="0" cellspacing="0" width="500">
	 	<form action="modify"> <!-- -이거 갖여오기 -->
	 	<input type="hidden" name="bid" value="${content.bid }"><!-- !!! 팁화면에 나오지 않으면 type를 hidden으로 처리해서 리퀘스트 객체에 저장하여 다같이 감 -->
	 	<tr>
	 		<th width="100">글번호</th>
	 		<td>${content.bid }</td>
	 	</tr> 
	 	<tr>
	 		<th>글쓴이</th>
	 		<td><input type="text" value="${content.bname }" name="bname" ></td>
	 	</tr> 
	 	<tr>
	 		<th>글제목</th>
	 		<td><input type="text" value="${content.btitle }" name="btitle"></td>
	 	</tr> 
	 	<tr>
	 		<th valign="top">내용</th>
	 		<td height="300" valign="top">
	 			<textarea rows="20" cols="45" name="bcontent">${content.bcontent }</textarea>
	 		</td>
	 	</tr> 
	 	<tr>
	 		<th>등록일</th>
	 		<td>${content.bdate }</td>
	 	</tr> 
	 	<tr>
	 		<td colspan="2" align="right">
	 			<input type="submit" value="완료">
	 			<input type="reset" value="취소">
	 			<input type="button" value="목록" onclick="javascript:window.location='list'">
	 		</td>
	 	</tr>
	 	</form>
	</table>
</body>
</html>
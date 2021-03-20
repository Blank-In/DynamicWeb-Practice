<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
	<%request.setCharacterEncoding("utf-8"); %>
	<h2>게시글 수정</h2>
	<hr>
	<form action="/MemberPro/editPost" method="post" enctype="multipart/form-data">
		<table border="1" style="width: 400">
		<tr>
			<td align="left">제목</td>
			<td>
				<input class="cls1" value=<%=request.getParameter("title")%> type="text" name="title" maxlength="20"/>
			</td>
		</tr>
		<tr>
			<td align="left">본문</td>
			<td>
				<input class="cls1" type="text" value=<%=request.getParameter("lore")%> name="lore" size="50" maxlength="200"/>
			</td>
		</tr>
		<tr>
			<td align="left">파일첨부</td>
			<td>
				<input type="file" name="fileName">
			</td>
		</tr>
	</table>
	<br>
	<input type="hidden" name="number" value=<%=request.getParameter("number") %>>
	<input type="hidden" name="id" value=<%=request.getParameter("id") %>>
	<input type="submit" value="수정하기">
	</form>
</body>
</html>
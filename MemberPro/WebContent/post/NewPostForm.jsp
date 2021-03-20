<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
</head>
<body>
	<h2>게시글 작성</h2>
	<hr>
	<form action="/MemberPro/addPost" method="post" enctype="multipart/form-data">
		<table border="1" style="width: 400">
		<tr>
			<td align="left">제목</td>
			<td>
				<input class="cls1" type="text" name="title" maxlength="20"/>
			</td>
		</tr>
		<tr>
			<td align="left">본문</td>
			<td>
				<input class="cls1" type="text" name="lore" size="50" maxlength="200"/>
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
	<input type="submit" value="글쓰기">
	</form>
</body>
</html>
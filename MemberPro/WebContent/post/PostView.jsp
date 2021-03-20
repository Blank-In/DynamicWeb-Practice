<%@ page import="my.member.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/MemberPro/member/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%
	int number = Integer.parseInt(request.getParameter("number"));
	PostDAO dao=new PostDAO();
	PostDTO dto=dao.selectPost(number);
	%>
	
	<table border="1">
		<tr class="cls1">
			<th>
				<h1><%=dto.getTitle()%></h1>
			</th>
			<td><%=dto.getCreateDate() %></td>
		</tr>
		<tr>
			<td colspan="2"><%=dto.getLore() %></td>
		</tr>
		<tr>
			<td>첨부파일</td>
			<td><a href="/MemberPro/File/<%=dto.getFileName()%>"><%=dto.getOriginFileName()%></a></td>
		</tr>
	</table>
	<hr>
	<form method="post" action="EditPostForm.jsp" style="float:left">
		<input type="hidden" name="title" value=<%=dto.getTitle() %>>
		<input type="hidden" name="lore" value=<%=dto.getLore() %>>
		<input type="hidden" name="number" value=<%=dto.getNumber() %>>
		<input type="hidden" name="id" value=<%=dto.getID() %>>
		<input type="submit" value="수정">
	</form>
	<form method="post" action="/MemberPro/deletePost">
		<input type="hidden" name="number" value=<%=dto.getNumber() %>>
		<input type="hidden" name="id" value=<%=dto.getID() %>>
		<input type="submit" value="삭제">
	</form>
</body>
</html>
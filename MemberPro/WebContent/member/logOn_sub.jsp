<%@page import="my.member.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%
	String id = (String)session.getAttribute("loginId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LogOn</title>
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<table border="1" style="width:330px">
		<tr class="cls1">
			<th colspan="4" align="center">
				<font color="blue"> <%=id %> </font> 님 로그인중.
			</th>
		</tr>
		<tr class="cls2">
			<td align="center">
				<a href="updateForm_sub.jsp">정보수정</a>
			</td>
			<td align="center">
				<a href="deleteForm_sub.jsp">회원탈퇴</a>
			</td>
			<td align="center">
				<a href="logoutProc.jsp">로그아웃</a>
			</td>
			<td align="center">
				<a href="<%=request.getContextPath()%>/post/NewPostForm.jsp">게시글 작성</a>
			</td>
		</tr>
	</table>
	<hr>
	<table border="1" style="min-width: 330px">
		<tr class="cls2">
			<td>번호</td>
			<td>제목</td>
			<td>글쓴이</td>
			<td>작성일</td>
		</tr>
	<%
		PostDAO dao=new PostDAO();
		List<PostDTO> list=dao.selectPosts();
		for(int selection=0;selection<list.size();++selection){%>
				<tr class="cls2">
					<td><%=list.get(selection).getNumber()%></td>
					<td><a href="<%=request.getContextPath()%>/post/PostView.jsp?number=<%=list.get(selection).getNumber()%>"><%=list.get(selection).getTitle()%></a></td>
					<td><%=list.get(selection).getID()%></td>
					<td><%=list.get(selection).getCreateDate()%>
				</tr>
		<%}
	%></table>
</body>
</html>
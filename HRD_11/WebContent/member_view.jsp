<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ page import="Member.*"%>
<%@ page import="java.util.List" %>
<jsp:include page="views/header.jsp"></jsp:include>
<section>
	<div class="container">
		<p class="title">회원목록조회/수정</p>
		<table>
			<tr>
				<th>회원번호</th>
				<th>회원성명</th>
				<th>전화번호</th>
				<th>가입일자</th>
				<th>통신사</th>
				<th>고객등급</th>
				<th>거주지역</th>
			</tr>
			<%List<MemberDTO> list=MemberDAO.MemberList();
			for(int a=0;a<list.size();a++){%>
			<tr>
				<td><a href="member_edit.jsp?edit=<%=list.get(a).getCustno()%>" style="color: white"><%=list.get(a).getCustno() %></a></td>
				<td><%=list.get(a).getCustname() %></td>
				<td><%=list.get(a).getPhone() %></td>
				<td><%=list.get(a).getJoindate() %></td>
				<td><%=list.get(a).getAddress() %></td>
				<td><%=list.get(a).getGrade() %></td>
				<td><%=list.get(a).getCity() %></td>
			</tr>
			<%}%>
		</table>
	</div>
</section>
<jsp:include page="views/footer.jsp"></jsp:include>
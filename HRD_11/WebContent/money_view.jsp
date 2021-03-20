<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Member.*"%>
<%@ page import="java.util.*" %>
<jsp:include page="views/header.jsp"></jsp:include>
<section>
	<div class="container">
		<p class="title">회원매출조회</p>
		<table>
			<tr>
				<th>회원번호</th>
				<th>회원성명</th>
				<th>고객등급</th>
				<th>매출</th>
			</tr>
			<%List<MoneyDTO> list=MemberDAO.MoneyList();
			for(int a=0;a<list.size();a++){%>
			<tr>
				<td><%=list.get(a).getCustno() %></td>
				<td><%=list.get(a).getCustname() %></td>
				<td><%=list.get(a).getGrade() %></td>
				<td><%=list.get(a).getMoney() %></td>
			</tr>
			<%}%>
		</table>
	</div>
</section>
<jsp:include page="views/footer.jsp"></jsp:include>
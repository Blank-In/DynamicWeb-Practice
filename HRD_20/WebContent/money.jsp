<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Shop.*"%>
<%@ page import="java.util.*" %>
<jsp:include page="views/header.jsp"></jsp:include>
<section>
	<h2 class="title">회원매출조회</h2>
	<table border="1">
		<tr>
			<td>회원번호</td>
			<td>회원성명</td>
			<td>고객등급</td>
			<td>매출</td>
		</tr>
		<%List<MoneyDTO> list=ShopDAO.getMoneyAll();
		for(int a=0;a<list.size();a++){%>
		<tr>
			<td><%=list.get(a).getCustno() %></td>
			<td><%=list.get(a).getCustname() %></td>
			<td><%=list.get(a).getGrade() %></td>
			<td><%=list.get(a).getPrice() %></td>
		</tr>
		<%}%>
	</table>
</section>
<jsp:include page="views/footer.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="Shop.*" %>
<%
	List<ShopDTO> list=(List<ShopDTO>)request.getAttribute("list");
%>
<jsp:include page="views/header.jsp"></jsp:include>
<section>
	<h2 class="title">회원목록 조회/수정</h2>
	<table border="1">
		<tr>
			<td>회원번호</td>
			<td>회원성명</td>
			<td>전화번호</td>
			<td>통신사</td>
			<td>가입일자</td>
			<td>고객등급</td>
			<td>거주지역</td>
		</tr>
		<%for(int a=0;a<list.size();a++){%>
		<tr>
			<td><a href="edit.jsp?originno=<%=list.get(a).getCustno() %>"><%=list.get(a).getCustno()%></a></td>
			<td><%=list.get(a).getCustname()%></td>
			<td><%=list.get(a).getPhone()%></td>
			<td><%=list.get(a).getAddress()%></td>
			<td><%=list.get(a).getJoindate()%></td>
			<td><%=list.get(a).getGrade()%></td>
			<td><%=list.get(a).getCity()%></td>
		</tr>
		<%}%>
	</table>
</section>
<jsp:include page="views/footer.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Member.*" %>
<%int number=Integer.parseInt(request.getParameter("edit")); %>
<%MemberDTO dto=MemberDAO.getUser(number); %>
<jsp:include page="views/header.jsp"></jsp:include>
<script type="text/javascript" src="views/script.js"></script>
	<section>
		<div class="container">
			<p class="title">홈쇼핑 회원 정보 수정</p>
			<form action="/memberEdit" method="post" name="memberForm">
				<input type="hidden" name="originno" value="<%=dto.getCustno() %>">
				<table>
					<tr>
						<th>회원번호</th>
						<td><input type="number" name="custno" value="<%=dto.getCustno()%>"></td>
					</tr>
					<tr>
						<th>회원성명</th>
						<td><input type="text" name="custname" value="<%=dto.getCustname() %>"></td>
					</tr>
					<tr>
						<th>회원전화</th>
						<td><input type="text" name="phone" value="<%=dto.getPhone() %>"></td>
					</tr>
					<tr>
						<th>회원주소</th>
						<td><input type="text" name="address" value="<%=dto.getAddress() %>"></td>
					</tr>
					<tr>
						<th>가입일자</th>
						<td><input type="date" name="joindate" value="<%=dto.getJoindate() %>"></td>
					</tr>
					<tr>
						<th>고객등급(A:VIP,B:일반,C:직원")</th>
						<td><input type="text" name="grade" value="<%=dto.getGrade() %>"></td>
					</tr>
					<tr>
						<th>도시코드</th>
						<td><input type="text" name="city" value="<%=dto.getCity() %>"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="button" onclick="valueCheck('회원정보수정이 완료되었습니다.')" value="수정">
							<a href="member_view.jsp" >조회</a>
						</td>
					</tr>
				</table>
			</form>
	    </div>    
	</section>
<jsp:include page="views/footer.jsp"></jsp:include>

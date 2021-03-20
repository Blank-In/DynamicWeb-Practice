<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Member.*" %>
<jsp:include page="views/header.jsp"></jsp:include>
<script type="text/javascript" src="views/script.js"></script>
	<section>
		<div class="container">
			<p class="title">홈쇼핑 회원 등록</p>
			<form action="/memberInsert" method="post" name="memberForm">
			<table>
					<tr>
						<th>회원번호(자동발생)</th>
						<td><input type="number" name="custno" readonly="readonly" value=<%=MemberDAO.lastNum() %>></td>
					</tr>
					<tr>
						<th>회원성명</th>
						<td><input type="text" name="custname"></td>
					</tr>
					<tr>
						<th>회원전화</th>
						<td><input type="text" name="phone"></td>
					</tr>
					<tr>
						<th>회원주소</th>
						<td><input type="text" name="address"></td>
					</tr>
					<tr>
						<th>가입일자</th>
						<td><input type="date" name="joindate"></td>
					</tr>
					<tr>
						<th>고객등급(A:VIP,B:일반,C:직원")</th>
						<td><input type="text" name="grade"></td>
					</tr>
					<tr>
						<th>도시코드</th>
						<td><input type="text" name="city"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="button" onclick="valueCheck('회원등록이 완료 되었습니다!')" value="등록">
							<a href="member_view.jsp" >조회</a>
						</td>
					</tr>
				</table>
			</form>
	    </div>    
	</section>
<jsp:include page="views/footer.jsp"></jsp:include>

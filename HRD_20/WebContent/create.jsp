<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String idx =(String)request.getAttribute("idx"); %>
<script type="text/javascript">
	function OnClick() {
		if(document.regForm.custname.value=="") {
			alert('이름을 입력해주세요.');
			document.regForm.custname.focus();
			return;
		}
		if(document.regForm.phone.value=="") {
			alert('회원전화를 입력해주세요.');
			document.regForm.phone.focus();
			return;
		}
		if(document.regForm.joindate.value=="") {
			alert('가입일자를 입력해주세요.');
			document.regForm.joindate.focus();
			return;
		}
		if(document.regForm.city.value=="") {
			alert('도시를 입력해주세요.');
			document.regForm.city.focus();
			return;
		}		
		
		document.regForm.submit();
	
	}
</script>

<jsp:include page="views/header.jsp"></jsp:include>
<section>
	<h2 class="title">홈쇼핑 회원등록</h2>
	<form action="/create" name="regForm" method="post">
		<table border="1">
			<tr>
				<td>회원번호(자동발생)</td>
				<td><input type="text" name="custno" value="<%=idx%>"></td>
			</tr>
			<tr>
				<td>회원성명</td>
				<td><input type="text" name="custname"></td>
			</tr>
			<tr>
				<td>회원전화</td>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<td>통신사[SK,KT,LG]</td>
				<td>
					<input type="radio" name="address" value="SK">SK
					<input type="radio" name="address" value="KT">KT
					<input type="radio" name="address" value="LG">LG
				</td>
			</tr>
			<tr>
				<td>가입일자</td>
				<td><input type="text" name="joindate"></td>
			</tr>
			<tr>
				<td>고객등급[A:VIP, B:일반, C:직원]</td>
				<td>
					<select name="grade">
						<option value="A">VIP</option>
						<option value="B">일반</option>
						<option value="C">직원</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>도시코드</td>
				<td><input type="text" name="city"></td>
			</tr>	
			<tr>
				<td colspan="2">
					<input type="button" onclick="OnClick()" value="등록">
					<input type="button" value="조회">
				</td>
			</tr>										
		</table>
	</form>
</section>
<jsp:include page="views/footer.jsp"></jsp:include>
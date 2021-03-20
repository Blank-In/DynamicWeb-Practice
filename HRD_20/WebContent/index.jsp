<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String rst=(String)request.getAttribute("rst");
	if(rst!=null){
		out.print("<script>alert('회원등록이 완료되었습니다.')</script>");
		request.setAttribute("rst",null);
	}
%>
<jsp:include page="views/header.jsp"></jsp:include>
<section>
	<div class="title">
		<h2>쇼핑몰 회원관리 프로그램</h2>
	</div>
	<p>
		쇼핑몰 회원정보와 회원매출정보를 데이터베이스를 구축하고 회원관리 프로그램을 작성하는 프로그램이다.<br/>
		프로그램 작성 순서<br/>
		1. 회원정보 테이블을 생성한다.<br/>
		2. 매출정보 테이블을 생성한다.<br/>
		3. 회원정보, 매출정보 테이블에 제시된 문제지의 참조데이터를 추가 생성한다.<br/>
		4. 회원정보 입력 화면프로그램을 작성한다.<br/>
		5. 회원정보 조회 프로그램을 작성한다.<br/>
		6. 회원매출정보 조회 프로그램을 작성한다.<br/>
	</p>
</section>
<jsp:include page="views/footer.jsp"></jsp:include>
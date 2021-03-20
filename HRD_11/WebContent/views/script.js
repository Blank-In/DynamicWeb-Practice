function valueCheck(string){
	if(document.memberForm.custname.value==""){
		alert("회원성명이 입력되지 않았습니다.");
		document.memberForm.custname.focus();
		return;
	}
	if(document.memberForm.phone.value==""){
		alert("회원전화가 입력되지 않았습니다.");
		document.memberForm.phone.focus();
		return;
	}
	if(document.memberForm.address.value==""){
		alert("회원주소가 입력되지않았습니다.");
		document.memberForm.address.focus();
		return;
	}
	if(document.memberForm.joindate.value==""){
		alert("가입일자가 입력되지 않았습니다.");
		document.memberForm.joindate.focus();
		return;
	}
	if(document.memberForm.grade.value==""){
		alert("고객등급이 입력되지 않았습니다.");
		document.memberForm.grade.focus();
		return;
	}
	if(document.memberForm.city.value==""){
		alert("도시코드가 입력되지 않았습니다.");
		document.memberForm.city.focus();
		return;
	}
	alert(string);
	document.memberForm.submit();
}
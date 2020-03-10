<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function echeck() {
	if(emcheck.emailcheck.value==""){
		alert("인증번호를 입력하세요.");
		emcheck.emailcheck.focus();
	}
	else if(emcheck.emailcheck.value!="${emps}"){
		alert("인증번호가 틀렸습니다.");
		emcheck.emailcheck.focus();
	}else{
		alert("인증완료");
		opener.frm.check.value="checked";
		opener.frm.email1.readOnly="true";
		opener.frm.email2.value="${email2}";
		opener.frm.email2.readOnly="true";
		opener.frm.emailbutton.type="hidden";
		self.close();
	}
	
}
</script>
</head>
<body>
<form name="emcheck">
이메일 : <input type="text" value="${email }" readonly="readonly"> <br>
인증번호 : <input type="text" name="emailcheck"> <br>
</form>
<button onclick="echeck()">인증번호 확인</button>
</body>
</html>
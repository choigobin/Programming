<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/header.jsp"%>
<iframe src="#" name="iframe" style="width:0px; height:0px; border:0; visibility:hidden;"></iframe>	
<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-title">회원가입</h2>
	</div>
	
	<div class="write-form">
		<table summery="회원가입 글쓰기 테이블 입니다">
			<caption class="readonly">회원가입 입력폼</caption>			
			<colgroup>
				<col width="20%">
				<col width="80%">
			</colgroup>
			<tbody>
			<form name="new_user" method="post" action="/mail" onclick="formcheck();">
			
				<fieldset>
					<legend class="readonly">입력폼</legend>
					<tr>
						<th scope="row">
							<label for="id">아이디</label>
						</th>
						<td>
							<input type="text" name="id" id="id" class="minput"> 
							<input type="button" class="btn-write" name="idck" value="중복확인" onClick="IDcheck()">
						</td>
					</tr>
					<tr>
						<th scope="row"><lavel for="pass1">패스워드</lavel></th>
						<td><input type="passwrod" name="pw" id="pass1"  class="minput"></td>
					</tr>
					<tr>
						<th scope="row">패스워드 확인</th>
						<td><input type="passwrod" name="repw"  class="minput">
						<span id="pwdcheck"> </span></td>
					</tr>
					<tr>
						<th scope="row">이름</th>
						<td><input type="text" name="name"  class="minput"></td>
					</tr>
					<tr>
						<th scope="row">연락처</th>
						<td><input type="text" name="tel"  class="minput"></td>
					</tr>
					<tr>
						<th scope="row">이메일</th>
						
						<td style="vertical-align: middle;">
							<input type="text" name="email1" maxlength="20" onfocus="this.value='';" style="width:250px;"> 
							@ <input type="text" name="email2" style="width:250px;" maxlength="15" value="" disabled >
								<select name="email" onchange="email_change()" style="height:40px;">
	     							<option value="">선택하세요</option>
	     							<option value="9">직접입력</option>
	     							<option value="gmail.com">gmail.com</option>
	     							<option value="naver.com">naver.com</option>
	     							<option value="daum.net">daum.net</option>
	     							<option value="nate.com">nate.com</option>
	 							</select>
 							<input type="button" class="btn-write" name="authbutton" value="인증하기" onClick="emailCheck()">
							<br>
							<input type=hidden name=inputkey size=13 maxlength=13 placeholder="인증번호 입력" style="margin-top:5px; width:250px;" value="">
							<span id="notice"> </span>
							<br><span id="timer"> </span>
							<input type=hidden name=authkey value="">
							<input type=hidden name=emailconfirm value="0">
						</td>
					</tr>
                    <input type=hidden name=acctype value="0">
					<tr>
						<td colspan="2">
							<input type="button" value="취소" class="btn-write" onclick="cancel()">
							<input type="submit" value="등록"  class="btn-reset" >
							
						</td>
					</tr>
					</fieldset>
				</form>
			</tbody>
		</table>
	</div>
		
</div>

<script>
	function IDcheck(){
		window.open("../id_check","아이디 확인","width=350 height=260");
		pw_check();
	}
	
	function email_change(){
		  if(document.new_user.email.options[document.new_user.email.selectedIndex].value == ""){
		   document.new_user.email2.disabled = true;
		   document.new_user.email2.value = "";
		  }
		  if(document.new_user.email.options[document.new_user.email.selectedIndex].value == '9'){
		   document.new_user.email2.disabled = false;
		   document.new_user.email2.value = "";
		   document.new_user.email2.focus();
		  } else{
		   document.new_user.email2.disabled = true;
		   document.new_user.email2.value = document.new_user.email.options[document.new_user.email.selectedIndex].value;
		  }
	}
	function emailCheck(){
		if(new_user.email1.value == "" ||  new_user.email2.value==""){
			alert("이메일 주소를 입력하세요");
			new_user.email1.focus();
			return;
		}
		var emailRule = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i; //이메일 정규식
		if(!emailRule.test(new_user.email2.value)) {            
			alert("이메일 주소 형식 오류");  //경고
			return;
		}
		new_user.action = "../mail";
		new_user.method = "post";
		new_user.target = "iframe";
		new_user.submit();
		fncClearTime();
	    initTimer();
	    alert(new_user.email1.value);
	    new_user.inputkey.setAttribute('type','text');
	    new_user.authbutton.value="재인증";
	    key_check();
	}
	
	var iSecond; //초단위로 환산
	var timerchecker = null;
	function fncClearTime() { iSecond = 30;	}
	 
	function Lpad(str, len) {
	    str = str + "";
	    while (str.length < len) {
	        str = "0" + str;
	    }
	    return str;
	}
	 
	function initTimer() {
	    var timer = document.getElementById("timer");
	    //rHour = parseInt(iSecond / 3600);
	    //rHour = rHour % 60;
	 
	    rMinute = parseInt(iSecond / 60);
	    rMinute = rMinute % 60;
	 
	    rSecond = iSecond % 60;
	 
	    if (iSecond > 0) {
	        timer.innerHTML = "&nbsp;" + Lpad(rMinute, 2) + "분 " + Lpad(rSecond, 2) + "초 ";
	        iSecond--;
	        timerchecker = setTimeout("initTimer()", 1000); // 1초 간격으로 체크
	        timerchecker = setTimeout("key_check()", 500);
	        document.new_user.inputkey.disabled = false;
	    } else {
	    	timer.innerHTML = "&nbsp;&nbsp;&nbsp; 인증 시간이 초과했습니다";
	    	document.new_user.inputkey.disabled = true;
			document.new_user.inputkey.value = "";
	    }
	}
		
	function key_check() {
	    var check = document.getElementById("notice");
	    if (new_user.authkey.value != ""){
	    	check.innerHTML = "&nbsp;&nbsp;&nbsp; (test) 인증키 있음";
	    }
	    
	    if (new_user.authkey.value == ""){
	    	check.innerHTML = "&nbsp;&nbsp;&nbsp; (test) 인증키 없음";
	    }else if(new_user.inputkey.value != new_user.authkey.value) {
	    	document.getElementById("notice").style.color = 'gray';
	    	check.innerHTML = "&nbsp;&nbsp;&nbsp; 올바른 인증번호를 입력하세요";
	    	new_user.mailconfirm.value=0;
	 	} else {
	 		document.getElementById("notice").style.color = 'blue';
	   		check.innerHTML = "&nbsp;&nbsp;&nbsp; 인증번호가 확인되었습니다.";
	   		new_user.mailconfirm.value=1;
	    }
	}
	
	function pw_check() {
	    var check = document.getElementById("pwdcheck");
	    timerchecker = setTimeout("pw_check()", 500);
	    if(new_user.repw.value ==""){
	    	document.getElementById("pwdcheck").style.color = 'gray';
	    	check.innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp; 비밀번호를 입력하세요";
	    }else if (new_user.pw.value != new_user.repw.value) {
	    	document.getElementById("pwdcheck").style.color = 'red';
	    	check.innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp; 비밀번호가 맞지 않습니다.";
	 	}else {
	 		document.getElementById("pwdcheck").style.color = 'blue';
	   		check.innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp; 비밀번호가 일치합니다.";
	    }
	}

	function formcheck() {
		if(new_user.id.value=="") {
			alert("아이디입력하세요");
			new_user.id.focus();
			return;
		}
		if(new_user.id.value.length<5 || new_user.id.value.length>12){
			alert("아이디 입력 범위 오류");
			new_user.id.focus();
			return;
		}
		var idp = /^[a-zA-Z0-9]{5,12}$/;
		if(!idp.test(new_user.id.value)){
			alert("아이디 형식 오류");
			new_user.userid.focus();
			return false;
		}
		if(new_user.pw.value=="") {
			alert("패스워드입력하세요");
			new_user.pw.focus();
			return false;
		}
		if(new_user.pw.value != new_user.repw.value) {
			alert("패스워드를 확인하세요");
			new_user.pw.focus();
			return false;
		}
		if(new_user.pwd.value.length<8 || new_user.pwd.value.length>14){
			alert("비밀번호 입력 범위 오류");
			new_user.pwd.focus();
			return false;
		}
		var pwp = /[a-zA-Z0-9]{8,14}/;
		var check = /^(?=.*[a-zA-Z])(?=.*[!@#$%^~*+=-])(?=.*[0-9]).{8,14}$/;
		if(!check.test(new_user.pw.value)){
			alert("비밀번호 형식 오류");
			new_user.pwd.focus();
			return false;
		}
		if(new_user.name.value.length<1 || new_user.name.value.length>5){
			alert("이름 입력 범위 오류.");
			new_user.name.focus();
			return false;
		}
		var np = /[가-힣]{1,5}/;
		if(!np.test(new_user.name.value)){
			alert("이름 형식 오류");
			new_user.name.focus();
			return false;
		}
		var tp = /^[0-9]{3}-[0-9]{3,4}-[0-9]{4}$/;
		if(!tp.test(new_user.tel.value)){
			alert("전화번호 형식 오류");
			new_user.tel.focus();
			return false;
		}
		if(new_user.emailconfirm.value=="0"){
			alert("이메일이 인증되지 않았습니다.");
			new_user.email1.focus();
			return false;
		}
		return true;
	}
	
	function cancel(){
		var rs = confirm("입력을 취소하시겠습니까?");
		if(rs){
			//location.reload();
			//history.go(-1);
			location.href="index.jsp";
		}
	}
</script>

<%@ include file="/footer.jsp"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/header.jsp"%>

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
			<form name="my" method="post" action="/MemberInsert.do"  onsubmit="return formcheck();">
				<fieldset>
					<legend class="readonly">입력폼</legend>
					<tr>
						<th scope="row">
							<label for="id">아이디</label>
						</th>
						<td>
							<input type="text" name="id" id="id" class="minput"> 
							<a href="" class="btn-write">중복확인</a>
						</td>
					</tr>
					<tr>
						<th scope="row"><lavel for="pass1">패스워드</lavel></th>
						<td><input type="password" name="pass1" id="pass1"  class="minput"></td>
					</tr>
					<tr>
						<th scope="row">패스워드 확인</th>
						<td><input type="password" name="pass2"  class="minput"></td>
					</tr>
					<tr>
						<th scope="row">이름</th>
						<td><input type="text" name="name"  class="minput"></td>
					</tr>
					<tr>
						<th scope="row">전화번호</th>
						<td><input type="text" name="phone"  class="minput"></td>
					</tr>
					<tr>
						<th scope="row">이메일</th>
						<td>
							<input type="text" name="email1" class="email"> @
							<input type="text" name="email2"  class="email"> 
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="button" value="취소"  class="btn-reset" onclick="javascript:if(confirm('작성 내용을 지우시겠습니까?')){my.reset();}">
							<input type="submit" value="가입" class="btn-write">
						</td>
					</tr>
					</fieldset>
				</form>
			</tbody>
		</table>
	</div>
		
</div>

<script>
	function formcheck() {
		if(my.id.value=="") {
			alert("아이디입력하세요");
			my.id.focus();
			return false;
		}
		if(my.pass1.value=="") {
			alert("패스워드입력하세요");
			my.pass1.focus();
			return false;
		}
		if(my.pass1.value != my.pass2.value) {
			alert("패스워드를 확인하세요");
			my.pass2.focus();
			return false;
		}
		if(my.name.value=="") {
			alert("이름을 입력하세요");
			my.name.focus();
			return false;
		}
		if(my.phone.value=="") {
			alert("전화번호를 입력하세요");
			my.phone.focus();
			return false;
		}
		if(my.email1.value=="") {
			alert("이메일을 입력하세요");
			my.email1.focus();
			return false;
		}
		if(my.email2.value=="") {
			alert("이메일주소를 입력하세요");
			my.email2.focus();
			return false;
		}
		return true;
	}
</script>

<%@ include file="/footer.jsp"%>
















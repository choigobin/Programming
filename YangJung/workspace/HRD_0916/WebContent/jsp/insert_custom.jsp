<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<html>
<head>
<meta charset="UTF-8">
<title>Main 화면</title>
<style type="text/css">
table,th,td{border:1px solid black;}
</style>
<script type="text/javascript">
function check(){
	if(document.insert.id.value==""){
		alert("아이디를 입력하세요.");
		document.insert.id.focus();
	}
	else if(document.insert.name.value==""){
		alert("이름을 입력하세요.");
		document.insert.name.focus();
	}
	else if(document.insert.passwd.value==""){
		alert("비밀번호를 입력하세요.");
		document.insert.passwd.focus();
	}
	else if(document.insert.passwd2.value==""){
		alert("확인 비밀번호를 입력하세요.");
		document.insert.passwd2.focus();
	}
	else if(document.insert.passwd.value!=document.insert.passwd2.value){
		alert("비밀번호가 일치하지 않습니다.");
		document.insert.passwd2.focus();
	}
	else{
		document.insert.submit();
	}
}
</script>
</head>
<body>
<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String user = "yangjung";
	String password = "1234";
	String url ="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn = DriverManager.getConnection(url, user, password);
	request.setCharacterEncoding("utf-8");
	int a = 0;
	try{
		String sql = "SELECT last_number FROM USER_SEQUENCES WHERE SEQUENCE_NAME = UPPER('hrd0916')";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()){
			a = rs.getInt(1)+1;
			
		}
				
	}catch (SQLException e){
		out.println("테이블 호출 실패"+e.getMessage());
	}finally{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
	}
%>
<table width=100% height=100%>
<jsp:include page="header.jsp"/>
<jsp:include page="nav.jsp"/>
<tr>
<td valign="top" height='80%' bgcolor="gray">
<form name="insert" method="post" action="custom_insert.jsp" >
<span style="font-weight:bold;font-size:20px;">고객 정보 등록화면</span>
<table align="center" width=80%>
<tr>
<th width="120">아이디</th><td><input type="text" size="30" name="id" value="<%=a %>"></td>
</tr>
<tr>
<th>이름</th><td><input type="text" size="30" name="name"></td>
</tr>
<tr>
<th>비밀번호</th><td><input type="password" size="30" name="passwd"></td>
</tr>
<tr>
<th>비밀번호확인</th><td><input type="password" size="30" name="passwd2"></td>
</tr>
<tr>
<th>성별</th><td>
<input type="radio" size="30" name="gender" value="1">남
<input type="radio" size="30" name="gender" value="2">여</td>
</tr>
<tr>
<th>이름</th><td><input type="text" size="30" name="email1">@
<select name="email2">
	<option value="naver.com">naver.com</option>
	<option value="korea.com">korea.com</option>
</select>
</td>
</tr>
<tr>
<th>핸드폰</th><td>
<select name="ph1" style="width:82;">
	<option value="010">010</option>
	<option value="011">011</option>
	<option value="019">019</option>
</select>
 - <input type="text" size="7" name="ph2"> - <input type="text" size="7" name="ph3">
</td>
</tr>
<tr>
<th>전화번호</th><td>
<input type="text" size="7" name="tel1"> - 
<input type="text" size="7" name="tel2"> - 
<input type="text" size="7" name="tel3">
</td>
</tr>
<tr>
<th>주소</th><td><input type="text" size="60" name="adress"></td>
</tr>
<tr>
<th>차량번호</th><td><input type="text" size="30" name="carnumber"></td>
</tr>
<tr>
<th>차량종류</th><td><input type="text" size="30" name="cartype"></td>
</tr>
<tr>
<th colspan="2">
<button type="button" onclick="javascript:check()">고객등록</button> <button type="reset">다시작성</button>
</th>
</tr>
</table>
</form>
</td>
</tr>
<jsp:include page="footer.jsp"/>
</table>
</body>
</html>
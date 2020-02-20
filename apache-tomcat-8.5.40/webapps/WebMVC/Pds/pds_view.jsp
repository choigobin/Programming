<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>다운로그 자료실 관리 - 관리자페이지</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css"> 
<!-- 
body,td,tr,table{font-size:9pt; font-family:tahoma;color:#666666;line-height:160%;} 

A:link {font-family:tahoma;font-size:9pt;color:#666666;text-decoration:none;} 
A:visited {font-family:tahoma;font-size:9pt;color:#666666;text-decoration:none;} 
A:active {font-family:tahoma;font-size:9pt;color:#666666;text-decoration:none;} 
A:hover {font-family:tahoma;font-size:9pt;color:#009900;text-decoration:underline;} 
--> 
</style> 
<script language="JavaScript" type="text/JavaScript">

function pds_delete() {
	   var urlString;
	    urlString = "PdsServlet?cmd=pds_delete&idx=${vo.idx}&page=${page}" ;
	    window.open(urlString, "pds_delete"," resizable=yes,x=150,y=150,width=300,height=170");
}


</script>

</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td><jsp:include page="/include/top_menu.jsp" flush="true" /></td></tr>
	<tr>
		<td align="center" height="100%" valign=middle><br>
			<table width="30%" border="1" cellspacing="0" cellpadding="3" bgcolor="#FFCC66" bordercolor="#FFFFFF" bordercolorlight="#000000">
				<tr> 
					<td height=40 align="center" style="font-size: 15px;"><b>다운로드 자료실</b></a>
					</b></td>
				</tr>
			</table><br>
			<table width="60%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td><table width="100%" border="0" cellpadding="6" cellspacing="1" bgcolor="DDDDDD">
							<tr>
								<td align="center" bgcolor="EcECEC"><strong>제목</strong></td>
								<td colspan=3 bgcolor="ffffff">${vo.subject}</td>
							</tr>
							<tr>
								<td width="20%" align="center" bgcolor="EcECEC"><strong>작성자</strong></td>
								<td width="40%" bgcolor="ffffff">${vo.name }</td>
								<td width="20%" align="center" bgcolor="EcECEC"><strong>이메일</strong></td>
								<td align="center" bgcolor="ffffff">${vo.email }</td>
							</tr>
							<tr>
								<td width="20%" align="center" bgcolor="EcECEC"><strong>등록일</strong></td>
								<td width="40%" bgcolor="ffffff">${vo.regdate}</td>
								<td width="20%" align="center" bgcolor="EcECEC"><strong>조회수</strong></td>
								<td align="center" bgcolor="ffffff">${vo.readcnt}</td>
							</tr>
							<tr bgcolor="EcECEC">
								<td align="center" bgcolor="EcECEC"><strong>내용</strong></td>
								<td colspan=3 bgcolor="ffffff">${contents}</td>
							</tr>
							<tr>
								<td align="center" bgcolor="EcECEC"><strong>첨부파일</strong></td>
								<td colspan=3 bgcolor="ffffff">${vo.filename}</td>
							</tr>
						</table>
					</td>
				</tr>
			</form>
			</table><br>
			<table width="60%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td align=center>
						<a href="PdsServlet?cmd=pds_edit&idx=${vo.idx}&page=${page}"><b>[수정]</b></a>&nbsp; 
						<a  href="javascript:pds_delete();"><b>[삭제]</b></a>&nbsp; 
						<a href="PdsServlet?cmd=pds_list&page=${page}"><b>[목록]</b></a>
					</td>
				</tr>
			</table>
</body>
</html>

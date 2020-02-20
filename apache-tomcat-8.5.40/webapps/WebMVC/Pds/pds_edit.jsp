<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
<title>다운로드 자료실 관리 - 관리자페이지</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
	color: #606060;
}
body {
	margin-left: 0px;
	margin-top: 0px;
}
-->
</style>
<script language="JavaScript" type="text/JavaScript">

function check() {
	// 제목 입력 검사
	if(!pds.subject.value) {
		alert("제목을 입력하세요");
		pds.subject.select();
		return ;
	}
	// 내용 입력 검사
	if(!pds.contents.value) {
		alert("내용을 입력하세요");
		pds.contents.select();
		return ;
	}
	pds.submit();
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
					<td>
					<form name="pds" method="post" enctype="multipart/form-data" action="PdsServlet?cmd=pds_edit_pro">
					<input type="hidden" name="page" value="${page}">
					<input type="hidden" name="idx" value="${vo.idx}">
					<input type="hidden" name="oldfile" value="${vo.filename}">
					<table width="100%" border="0" cellpadding="6" cellspacing="1" bgcolor="DDDDDD">
							<tr>
								<td width="20%" align="center" bgcolor="EcECEC"><strong>작성자</strong></td>
								<td bgcolor="ffffff"><input name="name" type="text" value="${vo.name}" readonly style="width:450; height:18; padding:2; border:1 solid slategray" size="120"></td>
							</tr>
							<tr>
								<td width="20%" align="center" bgcolor="EcECEC"><strong>이메일</strong></td>
								<td bgcolor="ffffff"><input name="eamil" type="text" value="${vo.email}"  style="width:450; height:18; padding:2; border:1 solid slategray" size="120"></td>
							</tr>
							<tr>
								<td width="20%" align="center" bgcolor="EcECEC"><strong>제목</strong></td>
								<td bgcolor="ffffff"><input name="subject" type="text" value="${vo.subject}"  style="width:450; height:18; padding:2; border:1 solid slategray" size="120"></td>
							</tr>
							<tr bgcolor="EcECEC">
								<td align="center" bgcolor="EcECEC"><strong>내용</strong></td>
								<td bgcolor="ffffff"><textarea name="contents" cols="10" rows="10" style="width:490; height:200; padding:2; border:1 solid slategray" tabindex="2">${vo.contents}</textarea></td>
							</tr>
							<tr>
								<td width="20%" align="center" bgcolor="EcECEC"><strong>첨부파일</strong></td>
								<td bgcolor="ffffff"><input name="filename" type="file" value=""  style="width:450; height:30; padding:2; border:1 solid slategray" size="120"></td>
							</tr>
							<tr>
								<td width="20%" align="center" bgcolor="EcECEC"><strong>비밀번호</strong></td>
								<td bgcolor="ffffff"><input name="pass" type="password" value=""  style="width:450; height:18; padding:2; border:1 solid slategray" size="120"></td>
							</tr>
						</table>
					</td>
				</tr>

			</table><br>
			<table width="60%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td align=center><a href="javascript:check()"><b> [수정]</b></a>&nbsp; 
					<a href="javascript:history.back();"><b>[취소]</b></a>
					</td>
				</tr>
			</table>
</body>
</html>

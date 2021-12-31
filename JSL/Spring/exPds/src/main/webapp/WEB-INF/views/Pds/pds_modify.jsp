<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head><title>자료 등록 수정</title><link rel="stylesheet" type="text/css" href="/css/stylesheet.css">

<script type="text/javascript">
	function send() {
		var check;
		fetch("http://localhost:8089/Pds/pwcheck?pw="+pds.pass.value+"&idx="+pds.idx.value,{
				method:'GET',
		})
		.then(response =>  response.json())
		.then(data => {
			console.log(data);	
			check = data.idx;
			if(check==1){
				pds.submit();			
			}else{
				alert("비번오류");
			}
		})
		return;
	}
	
	function cancel() {
		history.back();
		return;
	}
	
</script>
</head>
<body topmargin="0" leftmargin="0">



<table border="0" width="800">
<tr>
  <td width="20%" height="500" valign="top" bgcolor="#ecf1ef">

  <!--  로그인 폼 추가부분 -->

  </td>
  <td width="80%" valign="top">&nbsp;<br>
  <img src="/img/bullet-01.gif"><font size="3" face="돋움" color="blue">
  <b> 뮤직자료실</b></font><font size="2"> - 자료 수정하기</font><p>
  <img src="/img/bullet-03.gif"><font size="2" face="돋움" color="orange"> 잠깐</font> &nbsp;
  <img src="/img/bullet-02.gif"><font size="2" face="돋움">는 필수 입력 사항입니다.</font><p>
  
  <!-- 맞나??ㅠㅠㅠㅠ 맞아요-->
    <form name="pds" method="post" action="pds_modify" enctype="multipart/form-data">
		<table border="0">
    <tr>
      <td width="5%" align="right"><img src="/img/bullet-02.gif"></td>
      <td width="15%"><font size="2 face="돋움"">글쓴이</font></td>
      <td width="80%"><input type="text" size="20" name="name"  value="${pds.name}" readonly></td></tr>
    <tr>
      <td align="right">&nbsp;</td>
      <td ><font size="2 face="돋움"">메일주소</font></td>
      <td><input type="text" size="20" name="email" value="${pds.email}"></td></tr>
    <tr>
      <td align="right"><img src="/img/bullet-02.gif"></td>
      <td><font size="2" face="돋움">제목</font></td>
      <td><input type="text" size="60" name="subject" value="${pds.subject}"></td></tr>
    <tr>
      <td align="right"><img src="/img/bullet-02.gif"></td>
      <td><font size="2" face="돋움">자료설명</font></td>
      <td><textarea wrap="physical" rows="10" name="contents" cols="60">${pds.contents}</textarea></td></tr>
      
      
    <tr>
      <td align="right"><img src="/img/bullet-02.gif"></td>
      <td><font size="2" face="돋움">파일첨부</font></td>
      <td>
      	<input type="file" name="filename" size="30"  value="${pds.filename}">
      	<input type="hidden" name="fileOrign" value="${pds.filename}">
      	<input type="hidden" name="idx" value="${pds.idx}">
      	<!-- <input type="hidden" name="pass" value="${pds.pass}"> -->
      </td>
      </tr>
      
      
    <tr>
      <td align="right"><img src="/img/bullet-02.gif"></td>
      <td><font size="2" face="돋움">비밀번호</font></td>
      <td><input type="password" size="10" name="pass" ></td></tr>
    <tr>
      <td align="right">&nbsp;</td>
      <td><font size="2">&nbsp;</font></td>
      <td><input type="button" value="수정하기" onclick="send()">&nbsp;
      <input type="button" value="돌아가기" onclick="cancel()"></td></tr>
    </table>
    </form>
    </td>
    
  </tr>
  </table>
</body>
</html>

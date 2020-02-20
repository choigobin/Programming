<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>공지사항 관리 - 관리자페이지</title>
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
<script language="javascript">
function b_sCh() {
	if(!b_search.key.value) {
		alert("검색어를 입력하세요");
		b_search.key.select();
	}
	b_search.submit();
}
</script>

</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr><td><jsp:include page="/include/top_menu.jsp" flush="true" />
		</td>
	</tr>
	<tr>
		<td align="center" height="100%" valign=middle><br>
			<table width="30%" border="1" cellspacing="0" cellpadding="3" bgcolor="#FFCC66" bordercolor="#FFFFFF" bordercolorlight="#000000">
				<tr> 
					<td height=40 align="center" style="font-size: 15px;"><b>공지사항 </b></a>
						</b></td>
				</tr>
			</table><br>
			<table width="80%" border="0" cellspacing="0" cellpadding="0">
				<tr>
                    <td height="20">* 총 등록수 : <font color=red>${totcount}</font> 건</td>
                </tr>
                <tr>
                  <td>
                    <table width="100%" border="0" cellpadding="6" cellspacing="1" bgcolor="DDDDDD">
                      <tr bgcolor="EcECEC">
                        <td width="15%" align="center" bgcolor="EcECEC"><strong>번호</strong></td>
						<td align="center" bgcolor="EcECEC"><strong>제목</strong></td>
                        <td width="20%" align="center"><strong>등록일자</strong></td>
                        <td width="20%" align="center"><strong>수정일자</strong></td>
                        <td width="10%" align="center"><strong>조회수</strong></td>
                      </tr>
                      <c:forEach var="list" items="${list}">
                      <tr>
                        <td align="center" bgcolor="#FFFFFF">${listcount}</td>
                        <td bgcolor="#FFFFFF"><a href="NoticeServlet?cmd=notice_view&idx=${list.idx}&page=${page}" class="unnamed1">${list.subject}</a></td>
                        <td align="center" bgcolor="#FFFFFF">${list.regdate}</td>
                        <td align="center" bgcolor="#FFFFFF">${list.updatedate}</td>
						<td align="center" bgcolor="#FFFFFF">${list.readcnt}</td>
                      </tr>

                      <c:set var="listcount" value="${listcount-1}" />

                      </c:forEach>
					  <c:if test="${empty list}">
					  <tr>
						<td colspan="4" align="center"><font face="돋움" size="2">등록된 자료가 없습니다</font></td>
					  </tr>
					  </c:if>
                      
	                  <tr>
                         <td height="35" colspan="10" align="center" bgcolor="#FFFFFF">${pageSkip}</td>
                      </tr>
                      <tr>
                        <td colspan="10" align="center" bgcolor="#FFFFFF">
                          <form action="${url}" method="post" name="b_search" >
                          <table width="610" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                              <td width=80% height="30" colspan="2" align="right">
								<select name="search" class="textfield">
									<option value="subject" <c:if test="${query=='subject'}"> selected</c:if>>제 목</option>
									<option value="contents" <c:if test="${query=='contents'}"> selected</c:if>>내 용</option>
								</select>
								<input name="key" type="text" class="textfield" size="30" value="${key}"></td>
                              <td width=20% align="right"><a href="javascript:b_sCh()"><b>[검색]</b></a>  &nbsp;
                              <a href="NoticeServlet?cmd=notice_write&page=${page}"><b>[글쓰기]</b></a></td>
                            </tr>
                       		</tr>		
                      	   </table>
                      	   </form>
                        </td>
                     </tr>
                    </table>
                  </td>
                 </tr>
           </table>
       </td>
     </tr>
</table>                
</body>
</html>

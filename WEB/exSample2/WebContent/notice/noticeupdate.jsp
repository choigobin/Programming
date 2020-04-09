<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<%
int no = Integer.parseInt(request.getParameter("no"));
NoticeVO vo = new NoticeVO();
NoticeDao dao = new NoticeDao();
vo = dao.viewNotice(no);
%>
<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-title">공지사항</h2>
	</div>
	
	<div class="write-form">
		<table summery="갤러리 글쓰기 테이블 입니다">
			<caption class="readonly">공지사항 입력폼</caption>			
			<colgroup>
				<col width="20%">
				<col width="80%">
			</colgroup>
			<tbody>
			<form name="my" method="post" action="/NoticeUpdate.do" onsubmit="return formcheck();">
					<tr>
						<th>제목<input type="hidden" name="no" value="<%=vo.getNo() %>"></th>
						<td><input type="text" name="title" value="<%=vo.getTitle()%>"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="contents"><%=vo.getContents()%></textarea></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="전송" class="btn-write">
							<input type="button" value="목록"  class="btn-reset" onclick="javascript:location.href='/notice/notice.jsp'">
						</td>
					</tr> 
				</form>
			</tbody>
		</table>
	</div>
		
</div>

<script>
	function formcheck() {
		if(my.title.value=="") {
			alert("제목입력하세요");
			my.title.focus();
			return false;
		}
		if(my.content.value=="") {
			alert("내용입력하세요");
			my.contnet.focus();
			return false;
		}
		return true;
	}
</script>

<%@ include file="/footer.jsp"%>
















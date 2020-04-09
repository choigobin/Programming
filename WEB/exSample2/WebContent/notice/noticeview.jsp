<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<%
int no = Integer.parseInt(request.getParameter("no"));
NoticeVO vo = new NoticeVO();
NoticeDao dao = new NoticeDao();
vo = dao.viewNotice(no);
dao.readNotice(no);
%>
<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-view-title"><%=vo.getTitle() %></h2>
		<p class="sub-view-wd">관리자 | <%=vo.getDate() %></p>
	</div>
	<div class="sub-view-contnet">
		<%=vo.getContents().replace("\n", "<br>") %>
	</div>
	<div class="sub-view-bottom">
		<c:if test="${user.getGrade() eq 'A'}">
			<a href="/notice/noticeupdate.jsp?no=<%=no %>" class="btn-modify">수정</a>&nbsp;&nbsp;
			<a href="javascript:avent()" class="btn-delete">삭제</a>&nbsp;&nbsp;
		</c:if>
		<a href="/notice/notice.jsp" class="btn-list">목록</a>&nbsp;&nbsp;
	</div>
		
</div>
<script>
function avent(){
	if(confirm("<%=no+"번 공지를 삭제하겠습니까?"%>") == true) {
		location.href="/NoticeDelete.do?no=<%=no%>";
	}else {
		return;
	}
}
</script>


<%@ include file="/footer.jsp"%>
















<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<%
int no = Integer.parseInt(request.getParameter("no"));
QaVO vo = new QaVO();
QaDao dao = new QaDao();
vo = dao.viewQa(no);
dao.readQa(no);
pageContext.setAttribute("id", vo.getUserid());
%>
<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-view-title"><%=vo.getTitle() %></h2>
		<p class="sub-view-wd"><%=vo.getUserid() %> | <%=vo.getInsertdate() %></p>
	</div>
	<div class="sub-view-contnet">
		<%=vo.getContents().replace("\n", "<br>") %>
	</div>
	<div class="qareply" style="padding-bottom:30px;">
		<h2 style="padding-bottom:16px;">답변</h2>
		<%
			if(vo.getReply() != "" && vo.getReply() != null){
				%><%=vo.getReply().replace("\n", "<br>")%><%
			}else{
				%>아직 답변이 없습니다.<%
			}
		%>
	</div>
	<div class="sub-view-bottom">
	<c:if test="${user.getGrade() eq 'A'}">
		<a href="/qa/qareply.jsp?no=<%=vo.getNo() %>" class="btn-delete">답변</a>&nbsp;&nbsp;
	</c:if>
	<c:if test="${user.getGrade() eq 'A' or user.getUserid() eq id}">
		<a href="javascript:void(0)" class="btn-delete" onclick="avent();">삭제</a>&nbsp;&nbsp;
	</c:if>	
		<a href="/qa/qa.jsp" class="btn-list">목록</a>&nbsp;&nbsp;
	</div>
		
</div>
<script>
function avent(){
	if(confirm("질문을 삭제하시겠습니까?") == true) {
		location.href="/QaDelete.do?no=<%=vo.getNo()%>";
	}else {
		return;
	}
}
</script>
<%@ include file="/footer.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<%
int no = Integer.parseInt(request.getParameter("no"));
QaVO vo = new QaVO();
QaDao dao = new QaDao();
vo = dao.viewQa(no);
%>
<form name="my" method="post" action="/QaReply.do" onsubmit="return formcheck();">
<input type="hidden" name="no" value=<%=vo.getNo() %>>
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
		<textarea name="reply" style="width:100%; height:300px;"><%
			if(vo.getReply() != "" && vo.getReply() != null){
				%><%=vo.getReply().replace("\n", "<br>")%><%
			}
		%></textarea>
	</div>	
	<div class="sub-view-bottom">
		<input type="submit" value="답변 저장" class="btn-write">
		<input type="button" value="목록"  class="btn-reset" onclick="javascript:location.href='/qa/qa.jsp'">
	</div>
</div>
</form>

<script>
	function formcheck() {
		if(my.reply.value=="") {
			alert("답변을 입력하세요");
			my.reply.focus();
			return false;
		}
		return true;
	}
</script>

<%@ include file="/footer.jsp"%>
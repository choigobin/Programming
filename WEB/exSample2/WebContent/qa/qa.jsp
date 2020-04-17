<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/header.jsp"%>

<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-title">질문답변</h2>
		<div class="sub-search">
			<form name="my" method="post" action="qasearch.do" onsubmit="return check()">
				<select name="sel" class="sel">
					<option value="title">제목</option>
					<option value="content">내용</option>
				</select>
				<input type="text" name="cont" class="text">
				<input type="submit" value="검색" class="btn">
			</form>
		</div>
	</div>
	
	<div class="content-body">
		<table class="qatable">
			<caption class="readonly">질문답변 표</caption>
			<colgroup>
				<col width="6%">
				<col width="48%">
				<col width="10%">
				<col width="15%">
				<col width="11%">
				<col width="10%">
			</colgroup>
			<tbody>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>답변상태</th>
					<th>날짜</th>
					<th>조회수</th>
				</tr>
<%
QaDao dao = new QaDao();
String pg = request.getParameter("pg")==null ? "1" : request.getParameter("pg");
int now = Integer.parseInt(pg);
if(now<1) now = 1;
int max = (dao.countQa()+9)/10;
List<QaVO> list = dao.selectQa(now);
for(QaVO vo : list){
	%>
	<tr>
		<td><%=vo.getNo() %></td>
		<td class="tleft"><a href="/qa/qaview.jsp?no=<%=vo.getNo()%>"><%=vo.getTitle() %></a></td>
		<td><%=vo.getUserid() %></td>
		<td>
			<%
			if(vo.getReply() != "" && vo.getReply() != null ){
				%><span  class="gray">답변완료</span><%
			}else{
				%><span  class="red">답변대기</span><%
			}
			%>
		</td>
		<td><%=vo.getInsertdate() %></td>
		<td><%=vo.getReadcnt()%></td>
	</tr>
	<%
}
%>
			</tbody>
		</table>
	</div>
		<div class="paging">
			<ul>
				<li><a href="/qa/qa.jsp?pg=<%=now-1%>">이전</a></li>
				<%
				for(int x=now-2 < 1 ? 1:now-2; x<=(now+2 < max ? now+2:max); x++){
					%><li><a href="/qa/qa.jsp?pg=<%=x%>"><%=x%></a></li><%
				}
				%>
				<li><a href="/qa/qa.jsp?pg=<%=now+1 < max ? now+1:max%>">다음</a></li>
			</ul>
			<c:if test="${not empty user}">
				<a href="/qa/qawrite.jsp" class="btn-write">글쓰기</a>
			</c:if>
		</div>

</div>
<%@ include file="/footer.jsp"%>
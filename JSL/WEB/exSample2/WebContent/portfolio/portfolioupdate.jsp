<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<%
int no = Integer.parseInt(request.getParameter("no"));
PortfolioVO vo = new PortfolioVO();
PortfolioDao dao = new PortfolioDao();
vo = dao.viewPortfolio(no);
%>
<script type="text/javascript" src="<c:url value='/se2/js/HuskyEZCreator.js'/>" charset="utf-8"></script>
<div class="contain">
	<div class="sub-topcontent">
		<h2 class="sub-title">포트폴리오</h2>
	</div>
	<div class="write-form">
	<form id="frm" method="post" action="/PortfolioUpdate.do">
		<table>
			<caption class="readonly">포트폴리오 입력폼</caption>			
			<colgroup>
				<col class="w20">
				<col class="w80">
			</colgroup>
			<tbody>
					<tr>
						<th><label for="title">제목</label></th>
						<td><input type="text" name="title" id="title" value="<%=vo.getTitle()%>"></td>
					</tr>
					<tr>
						<th><label for="content">내용</label></th>
						<td><textarea name="contents" id="ir1"></textarea></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="button" value="저장" id="save" class="btn-write">
							<input type="button" value="목록"  class="btn-reset" onclick="javascript:location.href='/portfolio/portfolio.jsp'">
						</td>
					</tr>
				
			</tbody>
		</table>
		</form>
	</div>		
</div>
<script type="text/javascript"> 
var oEditors = [];
$(function(){ 
	nhn.husky.EZCreator.createInIFrame({ 
		oAppRef: oEditors, 
		elPlaceHolder: "ir1", 
		//SmartEditor2Skin.html 파일이 존재하는 경로 
		sSkinURI: "/se2/SmartEditor2Skin.html", 
		htParams : { 
			// 툴바 사용 여부 (true:사용/ false:사용하지 않음) 
			bUseToolbar : true, // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음) 
			bUseVerticalResizer : true, 
			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음) 
			bUseModeChanger : false, 
			fOnBeforeUnload : function(){ } 
			}, 
			fOnAppLoad : function(){ 
				//기존 저장된 내용의 text 내용을 에디터상에 뿌려주고자 할때 사용 
				oEditors.getById["ir1"].exec("PASTE_HTML", ["<%=vo.getContents()%>"]); 
				}, 
				fCreator: "createSEditor2" 
				}); 
	}); 
$("#save").click(function(){
	oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []); 
	$("#frm").submit();
})
	</script>
<%@ include file="/footer.jsp"%>
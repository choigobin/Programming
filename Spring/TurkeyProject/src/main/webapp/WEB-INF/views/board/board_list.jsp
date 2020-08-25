<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<link href="../css/all_style.css?ver=2" rel="stylesheet">

<div class="all">

	<%@ include file="../include/header.jsp"%>
	
	<c:if test="${pro_vo != null}">
		<!-- 관리자 -->
		<c:if test="${pro_vo.pro_code == '00000'}">
			<%@ include file="../include/navigation_adm.jsp"%>
			<div class="contents">
				<div class="board_name">
					자유 게시판
				</div>
				<div class="board_menu_adm">
					<table>
						<colgroup>
							<col width="90px">
							<col width="415px">
							<col width="190px">
							<col width="190px">
							<col width="115px">
						</colgroup>
						<tr class="board_menu_adm_detail">
							<th>번호</th>
							<th>제목</th>
							<th>등록일</th>
							<th>학번</th>
							<th style="border-right: none !important">조회수</th>
						</tr>
						<c:if test="${empty list}">
							<tr onMouseOver="style.backgroundColor='#D1EEEE'" onMouseOut="style.backgroundColor=''"  class="stu_contents_board_more_menu_detail2">
								<td align="center" colspan="5" height="25"  style="border-right: none !important">등록된 자료가 없습니다.</td>
							</tr>
						</c:if>
						<c:forEach var="board" items="${list}">
							<tr class="board_menu_adm_list">
								<td>${listcount}</td>
								<td><a href="board_readcnt?idx=${board.idx}&page=${page}&search=${pageVO.search}&key=${pageVO.key}">${board.title }</a></td>
								<td>${board.regdate.substring(0,10) }</td>
								<td>${board.stu_code }</td>
								<td style="border-right: none !important">${board.readcnt }</td>
							</tr>
						<c:set var="listcount" value="${listcount-1}"></c:set>
						</c:forEach>
					</table>
				</div>
				<div class="board_menu_adm_search">
					<div class="board_menu_adm_search_page">${pagelist}</div>
					<form name="board" method="post" action="board_list">
						<input type="hidden" name="page" value="${page}">
						<select name="search">
							<option value="title">제목</option>
							<option value="contents">내용</option>
							<option value="stu_code">학번</option>
						</select>
						<input type="text" name="key" class="text" value="${pageVO.key}">
						<input type="submit" value="검색" class="btn" onClick="search()">
					</form>
				</div>
			</div>
		</c:if>
		
		<!-- 교수 -->
		<c:if test="${pro_vo.pro_code != '00000'}">
			<%@ include file="../include/navigation_pro.jsp"%>
			
			<div class="contents">
				<div class="board_name">
					자유 게시판
				</div>
				<div class="board_menu_pro">
					<table>
						<colgroup>
							<col width="90px">
							<col width="415px">
							<col width="190px">
							<col width="190px">
							<col width="115px">
						</colgroup>
						<tr class="board_menu_pro_detail">
							<th>번호</th>
							<th>제목</th>
							<th>등록일</th>
							<th>학번</th>
							<th style="border-right: none !important">조회수</th>
						</tr>
						<c:if test="${empty list}">
							<tr onMouseOver="style.backgroundColor='#D1EEEE'" onMouseOut="style.backgroundColor=''"  class="stu_contents_board_more_menu_detail2">
								<td align="center" colspan="5" height="25"  style="border-right: none !important">등록된 자료가 없습니다.</td>
							</tr>
						</c:if>
						<c:forEach var="board" items="${list}">
							<tr class="board_menu_pro_list">
								<td>${listcount}</td>
								<td><a href="board_readcnt?idx=${board.idx}&page=${page}&search=${pageVO.search}&key=${pageVO.key}">${board.title }</a></td>
								<td>${board.regdate.substring(0,10) }</td>
								<td>${board.stu_code }</td>
								<td style="border-right: none !important">${board.readcnt }</td>
							</tr>
						<c:set var="listcount" value="${listcount-1}"></c:set>
						</c:forEach>
					</table>
				</div>
				<div class="board_menu_pro_search">
					<div class="board_menu_pro_search_page">${pagelist}</div>
					<form name="board" method="post" action="board_list">
						<input type="hidden" name="page" value="${page}">
						<select name="search">
							<option value="title">제목</option>
							<option value="contents">내용</option>
							<option value="stu_code">글쓴이</option>
						</select>
						<input type="text" name="key" class="text" value="${pageVO.key}">
						<input type="submit" value="검색" class="btn" onClick="search()">
					</form>
				</div>
			</div>
		</c:if>
	</c:if>
		
	<!-- 학생 -->
	<c:if test="${stu_vo != null}">
	
		<%@ include file="../include/navigation_stu.jsp"%>
		
		<div class="contents">
			<div class="board_name">
				자유 게시판
			</div>
			<div class="board_write_stu">
				<input type="button" value="글쓰기" onClick="location.href='board_write?page=${page}'">
			</div>
			<div class="board_menu_stu">
				<table>
					<colgroup>
						<col width="90px">
						<col width="415px">
						<col width="190px">
						<col width="190px">
						<col width="115px">
					</colgroup>
					<tr class="board_menu_stu_detail">
						<th>번호</th>
						<th>제목</th>
						<th>등록일</th>
						<th>학번</th>
						<th style="border-right: none !important">조회수</th>
					</tr>
					<c:if test="${empty list}">
						<tr onMouseOver="style.backgroundColor='#D1EEEE'" onMouseOut="style.backgroundColor=''"  class="stu_contents_board_more_menu_detail2">
							<td align="center" colspan="5" height="25"  style="border-right: none !important">등록된 자료가 없습니다.</td>
						</tr>
					</c:if>
					<c:forEach var="board" items="${list}">
						<tr class="board_menu_stu_list">
							<td>${listcount}</td>
							<td><a href="board_readcnt?idx=${board.idx}&page=${page}&search=${pageVO.search}&key=${pageVO.key}">${board.title }</a></td>
							<td>${board.regdate.substring(0,10) }</td>
							<td>${board.stu_code }</td>
							<td style="border-right: none !important">${board.readcnt }</td>
						</tr>
					<c:set var="listcount" value="${listcount-1}"></c:set>
					</c:forEach>
				</table>
			</div>
			<div class="board_menu_stu_search">
				<div class="board_menu_stu_search_page">${pagelist}</div>
				<form name="board" method="post" action="board_list">
					<input type="hidden" name="page" value="${page}">
					<select name="search">
						<option value="title">제목</option>
						<option value="contents">내용</option>
						<option value="stu_code">학번</option>
					</select>
					<input type="text" name="key" class="text" value="${pageVO.key}">
					<input type="submit" value="검색" class="btn" onClick="search()">
				</form>
			</div>
		</div>
	</c:if>
	<%@ include file="../include/footer.jsp"%>
</div>


<script>
function search(){
	if(board.key.value == ""){
		alert("검색어를 입력하세요");
		board.key.focus();
		return;
	}
	
	board.submit();
}
</script>
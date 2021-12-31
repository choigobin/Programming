<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<link href="../css/all_style.css?ver=4" rel="stylesheet">

<div class="all">

	<%@ include file="../include/header.jsp"%>
	
	<c:if test="${pro_vo != null}">

		<!-- 관리자 -->
		<c:if test="${pro_vo.pro_code == '00000'}">
			<%@ include file="../include/navigation_adm.jsp"%>
			
			<div class="contents">
			<div class="board_name">
				공지게시판
			</div>
			<c:if test="${pro_vo != null}">
				<c:if test="${pro_vo.pro_code == '00000'}">
					<div class="board_write_adm">
						<input type="button" value="글쓰기" onClick="location.href='notice_insert?page=${page}'" style="margin-right:150px;">
					</div>
				</c:if>
			</c:if>
			<div class="board_menu_adm">
				<table>
					<colgroup>
						<col width="74px">
						<col width="417px">
						<col width="183px">
						<col width="170px">
						<col width="105px">
						<col width="70px">
					</colgroup>
					<tr class="board_menu_adm_detail">
						<th>번호</th>
						<th>제목</th>
						<th>등록일</th>
						<th>이름</th>
						<th>조회수</th>
						<th style="border-right: none !important">파일</th>
					</tr>
					<c:if test="${empty list}">
						<tr onMouseOver="style.backgroundColor='#D1EEEE'" onMouseOut="style.backgroundColor=''"  class="stu_contents_board_more_menu_detail2">
							<td align="center" colspan="6" height="25"  style="border-right: none !important">등록된 자료가 없습니다.</td>
						</tr>
					</c:if>
					<c:forEach var="notice" items="${list}">
						<tr class="board_menu_adm_list">
							<td>${listcount}</td>
							<td><a href="notice_readcnt?idx=${notice.idx}&page=${page}&search=${pageVO.search}&key=${pageVO.key}">${notice.title }</a></td>
							<td>${notice.regdate.substring(0,10) }</td>
							<td>관리자</td>
							<td>${notice.readcnt }</td>
							<td style="border-right: none !important">
								<c:if test="${!empty notice.ori_filename}">
									<img src="/img/file_adm.png">
								</c:if>
							</td>
						</tr>
					<c:set var="listcount" value="${listcount-1}"></c:set>
					</c:forEach>
				</table>
			</div>
			<div class="board_menu_adm_search">
				<div class="board_menu_adm_search_page">${pagelist}</div>
				<form name="notice" method="post" action="notice_list">
					<input type="hidden" name="page" value="${page}">
					<select name="search">
						<option value="title">제목</option>
						<option value="contents">내용</option>
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
				공지게시판
			</div>
			<div class="board_menu_pro">
				<table>
					<colgroup>
						<col width="74px">
						<col width="417px">
						<col width="183px">
						<col width="170px">
						<col width="105px">
						<col width="70px">
					</colgroup>
					<tr class="board_menu_pro_detail">
						<th>번호</th>
						<th>제목</th>
						<th>등록일</th>
						<th>이름</th>
						<th>조회수</th>
						<th style="border-right: none !important">파일</th>
					</tr>
					<c:if test="${empty list}">
						<tr onMouseOver="style.backgroundColor='#D1EEEE'" onMouseOut="style.backgroundColor=''"  class="stu_contents_board_more_menu_detail2">
							<td align="center" colspan="6" height="25"  style="border-right: none !important">등록된 자료가 없습니다.</td>
						</tr>
					</c:if>
					<c:forEach var="notice" items="${list}">
						<tr class="board_menu_pro_list">
							<td>${listcount}</td>
							<td><a href="notice_readcnt?idx=${notice.idx}&page=${page}&search=${pageVO.search}&key=${pageVO.key}">${notice.title }</a></td>
							<td>${notice.regdate.substring(0,10) }</td>
							<td>관리자</td>
							<td>${notice.readcnt }</td>
							<td style="border-right: none !important">
								<c:if test="${!empty notice.ori_filename}">
									<img src="/img/file_pro.png">
								</c:if>
							</td>
						</tr>
					<c:set var="listcount" value="${listcount-1}"></c:set>
					</c:forEach>
				</table>
			</div>
			<div class="board_menu_pro_search">
				<div class="board_menu_pro_search_page">${pagelist}</div>
				<form name="notice" method="post" action="notice_list">
					<input type="hidden" name="page" value="${page}">
					<select name="search">
						<option value="title">제목</option>
						<option value="contents">내용</option>
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
				공지게시판
			</div>
			<div class="board_menu_stu">
				<table>
					<colgroup>
						<col width="74px">
						<col width="417px">
						<col width="183px">
						<col width="170px">
						<col width="105px">
						<col width="70px">
					</colgroup>
					<tr class="board_menu_stu_detail">
						<th>번호</th>
						<th>제목</th>
						<th>등록일</th>
						<th>이름</th>
						<th>조회수</th>
						<th style="border-right: none !important">파일</th>
					</tr>
					<c:if test="${empty list}">
						<tr onMouseOver="style.backgroundColor='#D1EEEE'" onMouseOut="style.backgroundColor=''"  class="stu_contents_board_more_menu_detail2">
							<td align="center" colspan="6" height="25"  style="border-right: none !important">등록된 자료가 없습니다.</td>
						</tr>
					</c:if>
					<c:forEach var="notice" items="${list}">
						<tr class="board_menu_stu_list">
							<td>${listcount}</td>
							<td><a href="notice_readcnt?idx=${notice.idx}&page=${page}&search=${pageVO.search}&key=${pageVO.key}">${notice.title }</a></td>
							<td>${notice.regdate.substring(0,10) }</td>
							<td>관리자</td>
							<td>${notice.readcnt }</td>
							<td style="border-right: none !important">
								<c:if test="${!empty notice.ori_filename}">
									<img src="/img/file_stu.png">
								</c:if>
							</td>
						</tr>
					<c:set var="listcount" value="${listcount-1}"></c:set>
					</c:forEach>
				</table>
			</div>
			<div class="board_menu_stu_search">
				<div class="board_menu_stu_search_page">${pagelist}</div>
				<form name="notice" method="post" action="notice_list">
					<input type="hidden" name="page" value="${page}">
					<select name="search">
						<option value="title">제목</option>
						<option value="contents">내용</option>
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
	if(notice.key.value == ""){
		alert("검색어를 입력하세요");
		notice.key.focus();
		return;
	}
	
	notice.submit();
}
</script>
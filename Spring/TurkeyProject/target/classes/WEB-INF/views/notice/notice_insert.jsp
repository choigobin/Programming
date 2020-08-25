<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link href="../css/all_style.css?ver=2" rel="stylesheet">

<div class="all">

	<%@ include file="../include/header.jsp"%>

	<c:if test="${pro_vo != null}">

		<!-- 관리자 -->
		<c:if test="${pro_vo.pro_code == '00000'}">
		
			<%@ include file="../include/navigation_adm.jsp"%>
			
			<div class="contents">
			<div class="board_name">글쓰기</div>
					<div class="board_form_detail_pro_manage">
						<form name="notice" method="post" action="notice_insert_pro"
							enctype="multipart/form-data">
							<input type="hidden" name="page" value="${page}">
							<div class="stu_contents_board_write_form_g">
								<table>
									<tr>
										<th>제목</th>
										<td><input type="text" name="title"></td>
									</tr>
									<tr>
										<th>파일</th>
										<td><input type="file" name="filename"></td>
									</tr>
								</table>
							</div>
							<div class="stu_contents_board_write_form_h">
								<table>
									<tr>
										<th>내용</th>
										<td><textarea name="contents"></textarea></td>
									</tr>
								</table>
							</div>
							<div class="board_write_adm">
								<input type="button" value="등록" onClick="javascript:send()" style="margin-right:410px; margin-top:30px;">
							</div>
						</form>
					</div>

				</div>
		</c:if>
	</c:if>

	<%@ include file="../include/footer.jsp"%>
</div>





<script>
	function send() {
		notice.submit();
	}
</script>

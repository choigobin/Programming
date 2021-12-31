<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="../css/all_style.css?ver=2" rel="stylesheet">

<div class="all">

	<%@ include file="../include/header.jsp"%>

	<c:if test="${pro_vo != null}">

		<!-- 관리자 -->
		<c:if test="${pro_vo.pro_code == '00000'}">
			<%@ include file="../include/navigation_adm.jsp"%>
			<div class="contents">
				<div class="board_form">
					<div class="board_form_detail_adm_name" style="text-align:left;">
						${board.title }
					</div>
					<div class="board_form_detail_pro_manage">
						<div class="board_form_detail_adm_manage_in">
							<div class="board_form_detail_pro_manage_in_list">
								<a href="board_list?page=${page}">목록</a>
							</div>
							<c:if test="${stu_vo != null}">
								<c:if test="${stu_vo.stu_code == board.stu_code}">
									<div class="board_form_detail_pro_manage_in_list">
										<a href="board_modify?idx=${board.idx }&page=${page}">수정</a>
									</div>
									<div class="board_form_detail_pro_manage_in_list">
										<a href="javascript:del()">삭제</a>
									</div>
								</c:if>
							</c:if>
							<div class="board_form_detail_pro_manage_in_inform">
								글쓴이 : <b>${board.stu_code }</b>
							</div>
						</div>
						<div class="stu_contents_board_inform">
							<div class="stu_contents_board_inform_in_adm">
								${board.regdate.substring(0,10) } / ${board.readcnt } view
							</div>
						</div>
						<div class="stu_contents_board_contents">
							<div class="stu_contents_board_contents_in">
								${board.contents }
								<c:if test="${stu_vo != null}">
									<div class="stu_contents_board_contents_comments_write">
										<form name="b_com" method="post" action="comment_write?page=${page}&search=${search}&key=${key}">
											<table>
												<tr>
													<input type="hidden" name="idx" value="${board.idx}">
													<input type="hidden" name="stu_code" value="${stu_vo.stu_code }">
													<td><input type="text" name="stu_name" value="${stu_vo.stu_name }" readonly></td>
													<td><textarea name="comments" placeholder="댓글을 작성해 주세요."></textarea></td>
													<td><input type="button" value="등록" onClick="javascript:send()"></td>
												</tr>
											</table>
										</form>
									</div>
								</c:if>
								<div class="stu_contents_board_contents_comments_view" style="padding-top:60px;">
									<table>
										<c:forEach var="comment" items="${list}">
											<tr>
												<th>${comment.stu_name }</th>
												<td style="width:365px;" >
													${comment.comments }
												</td>
											</tr>
										</c:forEach>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:if>
		
		<!-- 교수 -->
		<c:if test="${pro_vo.pro_code != '00000'}">
			<%@ include file="../include/navigation_pro.jsp"%>
			
			<div class="contents">
				<div class="board_form">
					<div class="board_form_detail_pro_name" style="text-align:left;">
						${board.title }
					</div>
					<div class="board_form_detail_pro_manage">
						<div class="board_form_detail_pro_manage_in">
							<div class="board_form_detail_pro_manage_in_list">
								<a href="board_list?page=${page}">목록</a>
							</div>
							<c:if test="${stu_vo != null}">
								<c:if test="${stu_vo.stu_code == board.stu_code}">
									<div class="board_form_detail_pro_manage_in_list">
										<a href="board_modify?idx=${board.idx }&page=${page}">수정</a>
									</div>
									<div class="board_form_detail_pro_manage_in_list">
										<a href="javascript:del()">삭제</a>
									</div>
								</c:if>
							</c:if>
							<div class="board_form_detail_pro_manage_in_inform">
								글쓴이 : <b>${board.stu_code }</b>
							</div>
						</div>
						<div class="stu_contents_board_inform">
							<div class="stu_contents_board_inform_in_pro">
								${board.regdate.substring(0,10) } / ${board.readcnt } view
							</div>
						</div>
						<div class="stu_contents_board_contents">
							<div class="stu_contents_board_contents_in">
								${board.contents }
								<c:if test="${stu_vo != null}">
									<div class="stu_contents_board_contents_comments_write">
										<form name="b_com" method="post" action="comment_write?page=${page}&search=${search}&key=${key}">
											<table>
												<tr>
													<input type="hidden" name="idx" value="${board.idx}">
													<input type="hidden" name="stu_code" value="${stu_vo.stu_code }">
													<td><input type="text" name="stu_name" value="${stu_vo.stu_name }" readonly></td>
													<td><textarea name="comments" placeholder="댓글을 작성해 주세요."></textarea></td>
													<td><input type="button" value="등록" onClick="javascript:send()"></td>
												</tr>
											</table>
										</form>
									</div>
								</c:if>
								<div class="stu_contents_board_contents_comments_view" style="padding-top:60px;">
									<table>
										<c:forEach var="comment" items="${list}">
											<tr>
												<th>${comment.stu_name }</th>
												<td style="width:365px;" >
													${comment.comments }
												</td>
											</tr>
										</c:forEach>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:if>
	</c:if>
	
	<!-- 학생 -->
	<c:if test="${stu_vo != null}">
		<%@ include file="../include/navigation_stu.jsp"%>
		<div class="contents">
				<div class="board_form">
					<div class="board_form_detail_stu_name" style="text-align:left;">
						${board.title }
					</div>
					<div class="board_form_detail_stu_manage">
						<div class="board_form_detail_stu_manage_in">
							<div class="board_form_detail_stu_manage_in_list">
								<a href="board_list?page=${page}">목록</a>
							</div>
							<c:if test="${stu_vo != null}">
								<c:if test="${stu_vo.stu_code == board.stu_code}">
									<div class="board_form_detail_pro_manage_in_list">
										<a href="board_modify?idx=${board.idx }&page=${page}">수정</a>
									</div>
									<div class="board_form_detail_pro_manage_in_list">
										<a href="javascript:del()">삭제</a>
									</div>
								</c:if>
							</c:if>
							<div class="board_form_detail_pro_manage_in_inform">
								글쓴이 : <b>${board.stu_code }</b>
							</div>
						</div>
						<div class="stu_contents_board_inform">
							<div class="stu_contents_board_inform_in_stu">
								${board.regdate.substring(0,10) } / ${board.readcnt } view
							</div>
						</div>
						<div class="stu_contents_board_contents">
							<div class="stu_contents_board_contents_in">
								${board.contents }
								<c:if test="${stu_vo != null}">
									<div class="stu_contents_board_contents_comments_write">
										<form name="b_com" method="post" action="comment_write?page=${page}&search=${search}&key=${key}">
											<table>
												<tr>
													<input type="hidden" name="idx" value="${board.idx}">
													<input type="hidden" name="stu_code" value="${stu_vo.stu_code }">
													<td><input type="text" name="stu_name" value="${stu_vo.stu_name }" readonly></td>
													<td><textarea name="comments" placeholder="댓글을 작성해 주세요."></textarea></td>
													<td><input type="button" value="등록" onClick="javascript:send()" style="height:35px;"></td>
												</tr>
											</table>
										</form>
									</div>
								</c:if>
								<div class="stu_contents_board_contents_comments_view">
									<table>
										<c:forEach var="comment" items="${list}">
											<tr>
												<th>${comment.stu_name }</th>
												<td style="width:365px;" >
													${comment.comments }
												</td>
												<td>
													<c:if test="${stu_vo.stu_code == comment.stu_code}">
														<input type="button" value="삭제" onClick="location.href='comment_delete?c_idx=${comment.c_idx }&idx=${board.idx}&page=${page}&search=${search}&key=${key}'" style="height:35px;">
														<input type="button" value="수정" style="height:35px;" onClick="window.open('comment_modify?c_idx=${comment.c_idx }', 'comment_modify_form', 'height=540,width=510')">
													
													</c:if>
												</td>
											</tr>
										</c:forEach>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
	</c:if>
	
	<%@ include file="../include/footer.jsp"%>
</div>





<script>
function del(){
	if(confirm("정말로 삭제 하시겠습니까?")){
		location.href="board_delete?idx=" + ${board.idx} +"&page=" + ${page}
	}else{
		return;
	}
}

function send() {
	if(b_com.comments.value == "") {
		alert("내용을 입력하여 주십시오.");
		b_com.comments.focus();
		return;
	}
	b_com.submit();
}

</script>
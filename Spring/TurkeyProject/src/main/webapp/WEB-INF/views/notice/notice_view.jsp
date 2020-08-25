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
				${notice.title }
			</div>
			<div class="board_form_detail_pro_manage">
				<div class="board_form_detail_adm_manage_in">
					<div class="board_form_detail_pro_manage_in_list">
						<a href="notice_list?page=${page}">목록</a>
					</div>
					<c:if test="${pro_vo != null}">
						<c:if test="${pro_vo.pro_code == '00000'}">
							<div class="board_form_detail_pro_manage_in_list">
								<a href="notice_modify?idx=${notice.idx }&page=${page}">수정</a>
							</div>
							<div class="board_form_detail_pro_manage_in_list">
								<a href="javascript:del()">삭제</a>
							</div>
						</c:if>
					</c:if>
					<div class="board_form_detail_pro_manage_in_inform">
						${notice.regdate.substring(0,10) } / ${notice.readcnt } view
					</div>
				</div>
				<div class="stu_contents_board_inform">
					<div class="stu_contents_board_inform_in_adm">
						<c:if test="${!empty notice.ori_filename}">
    						<a href="/resources/upload/${notice.filename}" download>
    							<img src="../img/file_adm.png" align="middle" width="22" height="20" border="0">
    						</a>
    					</c:if>
					</div>
				</div>
				<div class="stu_contents_board_contents">
					<div class="stu_contents_board_contents_in">
						${notice.contents }
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
				${notice.title }
			</div>
			<div class="board_form_detail_pro_manage">
				<div class="board_form_detail_pro_manage_in">
					<div class="board_form_detail_pro_manage_in_list">
						<a href="notice_list?page=${page}">목록</a>
					</div>
					<c:if test="${pro_vo != null}">
						<c:if test="${pro_vo.pro_code == '00000000'}">
							<div class="board_form_detail_pro_manage_in_list">
								<a href="notice_modify?idx=${notice.idx }&page=${page}">수정</a>
							</div>
							<div class="board_form_detail_pro_manage_in_list">
								<a href="javascript:del()">삭제</a>
							</div>
						</c:if>
					</c:if>
					<div class="board_form_detail_pro_manage_in_inform">
						${notice.regdate.substring(0,10) } / ${notice.readcnt } view
					</div>
				</div>
				<div class="stu_contents_board_inform">
					<div class="stu_contents_board_inform_in_pro">
						<c:if test="${!empty notice.ori_filename}">
    						<a href="/resources/upload/${notice.filename}" download>
    							<img src="../img/file_pro.png" align="middle" width="22" height="20" border="0">
    						</a>
    					</c:if>
					</div>
				</div>
				<div class="stu_contents_board_contents">
					<div class="stu_contents_board_contents_in">
						${notice.contents }
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
				${notice.title }
			</div>
			<div class="board_form_detail_stu_manage">
				<div class="board_form_detail_stu_manage_in">
					<div class="board_form_detail_stu_manage_in_list">
						<a href="notice_list?page=${page}">목록</a>
					</div>
					<div class="board_form_detail_pro_manage_in_inform">
						${notice.regdate.substring(0,10) } / ${notice.readcnt } view
					</div>
				</div>
				<div class="stu_contents_board_inform">
					<div class="stu_contents_board_inform_in_stu">
						<c:if test="${!empty notice.ori_filename}">
    						<a href="/resources/upload/${notice.filename}" download>
    							<img src="../img/file_stu.png" align="middle" width="22" height="20" border="0">
    						</a>
    					</c:if>
					</div>
				</div>
				<div class="stu_contents_board_contents">
					<div class="stu_contents_board_contents_in">
						${notice.contents }
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
		location.href="notice_delete?idx=" + ${notice.idx} +"&page=" + ${page}
	}else{
		return;
	}
}
</script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/header.jsp"></jsp:include>
<jsp:include page="/notice/subnavi.jsp"></jsp:include>

	<div class="container">
		<div class="board_view">
			<h2>[공지] 공지제목이 출력됩니다</h2>
			<p class="info"><span class="user">홍길동</span> | 2018-10-18 | <i class="fa fa-eye"></i> 321</p>
			<div class="board_body">
				<p>공지사항 내용이 출력됩니다</p>
				<p>안녕하세요 JSL인재개발원입니다.</p>
				<p>일본해외취업에 또는 K-Move 연수에 관심이 있으신분들은</p>
				<p>일본해외취업설명회 동영상을 통해 궁금증을 해결하시길 바라겠습니다.</p>
			</div>
			<div class="prev_next">
				<a href="" class="btn_prev"><i class="fa fa-angle-left"></i>
				<span class="prev_wrap">
					<strong>이전글</strong><span>이전글제목표시</span>
				</span>
				</a>
				<div class="btn_3wrap">
					<a href="/notice/notice.jsp">목록</a> <a href="notice_modify.html">수정</a> <a href="notice_delete.html" onClick="return confirm('삭제하시겠어요?')">삭제</a>
				</div>
				<a href="" class="btn_next">
				<span class="next_wrap">
					<strong>다음글</strong><span>다음글제목표시</span>
				</span>
				<i class="fa fa-angle-right"></i></a>
			</div>
		</div>
	</div>

	<!-- end contents -->
	
	<script>
		$(function() {
			$(".location  .dropdown > a").on("click",function(e) {
				e.preventDefault();
				if($(this).next().is(":visible")) {
					$(".location  .dropdown > a").next().hide();
				} else {
					$(".location  .dropdown > a").next().hide();
					$(this).next().show();
				}
			});
		});
	</script>
	

<jsp:include page="/footer.jsp"></jsp:include>

 </body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/header.jsp"></jsp:include>	
<jsp:include page="/qna/subnavi.jsp"></jsp:include>

	<div class="container">
	  <div class="write_wrap">
	  <h2 class="sr-only">질문과 답변 글쓰기</h2>
	  <form name="notice" method="post" action="qa_reply.jsp">
	  <!-- action을 처리하기전에 check()사용자 함수를 실행하고 되돌아 와라-->
			<table class="bord_table">
				<caption class="sr-only">공지사항 입력 표</caption>
				<colgroup>
					<col width="20%">
					<col width="*">
				</colgroup>
				<tbody>
					<tr class="first">
						<th>글쓴이</th>
						<td>홍길동</td>
					</tr>
					<tr>
						<th>제목</th>
						<td>입학절차가 궁금합니다</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>입학하기를 희망하기에 입학절차와 필요한 서류가 무엇인지 자세히 알려주세요</td>
					</tr>
					<tr>
						<th>첨부</th>
						<td><img src="" alt=""></td>
					</tr>
					<tr>
						<th>답변</th>
						<td><textarea name="reply"></textarea></td>
					</tr>
				</tbody>
			</table>
			<div class="btn_wrap">
				<input type="submit" value="저장" class="btn_ok">&nbsp;&nbsp;<input type="reset" value="다시쓰기" class="btn_reset">&nbsp;&nbsp;<input type="button" value="목록" class="btn_list" onClick="location.href='/qna/qa.jsp';">
			</div>
		</form>
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










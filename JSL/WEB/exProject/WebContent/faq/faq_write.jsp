<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/header.jsp"></jsp:include>
<jsp:include page="/faq/subnavi.jsp"></jsp:include>

	<div class="container">
	  <div class="write_wrap">
	  <h2 class="sr-only">글쓰기</h2>
	  <form name="faq" method="post" action="faq_insert.html" onsubmit="return check()">
	  <!-- action을 처리하기전에 check()사용자 함수를 실행하고 되돌아 와라-->
			<table class="bord_table">
				<caption class="sr-only">자주하는 질문 입력 표</caption>
				<colgroup>
					<col width="20%">
					<col width="*">
				</colgroup>
				<tbody>
					
					<tr>
						<th>질문</th>
						<td><input type="text" name="title"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="contents"></textarea></td>
					</tr>
					
				</tbody>
			</table>
			<div class="btn_wrap">
				<input type="submit" value="저장" class="btn_ok">&nbsp;&nbsp;<input type="reset" value="다시쓰기" class="btn_reset">&nbsp;&nbsp;<input type="button" value="목록" class="btn_list" onClick="location.href='/faq/faq.jsp';">
			</div>
		</form>
	  </div>
	  
	</div>
	<!-- end contents -->
	<script>
		function check() {
			
			if(faq.title.value=="") {
				alert("제목을 입력");
				faq.title.focus();
				return false;
			}
			if(faq.contents.value=="") {
				alert("내용을 입력");
				faq.contents.focus();
				return false;
			}
			return true;
		}
	</script>
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
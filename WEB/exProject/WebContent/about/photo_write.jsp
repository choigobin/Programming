<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/header.jsp"></jsp:include>
	<!-- sub contents -->
	<div class="sub_title">
		<h2>갤러리 글쓰기</h2>
		<div class="container">
		  <div class="location">
			<ul>
				<li class="btn_home">
					<a href="index.jsp"><i class="fa fa-home btn_plus"></i></a>
				</li>
				<li class="dropdown">
					<a href="/about/gratings.jsp">기업소개<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="/about/gratings.jsp">기업소개</a>
						<a href="/portfolio/portfolio.jsp">포트폴리오</a>
						<a href="/notice/notice.jsp">커뮤니티</a>
					</div>
				</li>
				<li class="dropdown">
					<a href="">갤러리 글쓰기<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="/about/gratings.jsp">인사말</a>
						<a href="/about/history.jsp">연혁</a>
						<a href="/about/gratings.jsp">교직원소개</a>
						<a href="/about/photo.jsp">갤러리</a>
						<a href="/about/map.jsp">찾아오시는길</a>
					</div>
				</li>
			</ul>
		  </div>
		</div><!-- container end -->
	</div>

	<div class="container">
	  <div class="write_wrap">
	  <h2 class="sr-only">갤러리 글쓰기</h2>
	  <form name="photo" method="post" action="photo_insert.html" onsubmit="return check()">
	  <!-- action을 처리하기전에 check()사용자 함수를 실행하고 되돌아 와라-->
			<table class="bord_table">
				<caption class="sr-only">공지사항 입력 표</caption>
				<colgroup>
					<col width="20%">
					<col width="*">
				</colgroup>
				<tbody>
					
					<tr>
						<th>제목</th>
						<td><input type="text" name="title"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="contents"></textarea></td>
					</tr>
					<tr>
						<th>첨부</th>
						<td><input type="file" name="photo"></td>
					</tr>
				</tbody>
			</table>
			<div class="btn_wrap">
				<input type="submit" value="저장" class="btn_ok">&nbsp;&nbsp;<input type="reset" value="다시쓰기" class="btn_reset">&nbsp;&nbsp;<input type="button" value="목록" class="btn_list" onClick="location.href='photo.html';">
			</div>
		</form>
	  </div>
	  
	</div>
	<!-- end contents -->
	<script>
		function check() {
			
			if(photo.title.value=="") {
				alert("제목을 입력");
				photo.title.focus();
				return false;
			}
			if(photo.contents.value=="") {
				alert("내용을 입력");
				photo.contents.focus();
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










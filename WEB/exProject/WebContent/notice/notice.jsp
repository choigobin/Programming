<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/header.jsp"></jsp:include>
<jsp:include page="/notice/subnavi.jsp"></jsp:include>

	<div class="container">
	  <div class="search_wrap">
		<div class="record_group">
			<p>총게시글<span><?=$count?></span>건</p>
		</div>
		<div class="search_group">
			<form name="myform" method="get" action="notice.html">
				<select name="sel" class="select">
					<option value="1">제목</option>
					<option value="2">내용</option>
				</select>
				<input type="text" name="search" class="search_word">
				<button class="btn_search" type="submit"><i class="fa fa-search"></i><span class="sr-only">검색버튼</span></button>
			</form>
		</div>
	  </div> <!-- search end -->
	  <div class="bord_list">
		<table class="bord_table" summary="이표는 번호,제목,글쓴이,날자,조회수로 구성되어 있습니다">
			<caption class="sr-only">공지사항 리스트</caption>
			<colgroup>
				<col width="10%">
				<col width="*">
				<col width="10%">
				<col width="10%">
				<col width="10%">
			</colgroup>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>8</td>
					<td class="title"><a href="/notice/notice_view.jsp">입학절차에 대하여 알고 싶어요</a></td>
					<td>관리자</td>
					<td>18-10-16</td>
					<td>187</td>
				</tr>
				<tr>
					<td>7</td>
					<td class="title"><a href="/notice/notice_view.jsp">무엇이 궁금한가요?</a></td>
					<td>관리자</td>
					<td>18-10-16</td>
					<td>187</td>
				</tr>
				<tr>
					<td>6</td>
					<td class="title"><a href="/notice/notice_view.jsp">궁굼한내용제목입니다</a></td>
					<td>관리자</td>
					<td>18-10-16</td>
					<td>187</td>
				</tr>
			</tbody>
		</table>
		<div class="paging">
			<a href=""><i class="fa  fa-angle-double-left"></i></a>
			<a href=""><i class="fa fa-angle-left"></i></a>
			<a href="" class="active">1</a>
			<a href="">2</a>
			<a href="">3</a>
			<a href="">4</a>
			<a href="">5</a>
			<a href=""><i class="fa fa-angle-right"></i></a>
			<a href=""><i class="fa  fa-angle-double-right"></i></a>
			<a href="/notice/notice_write.jsp" class="btn_write">글쓰기</a>
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
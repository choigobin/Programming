<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/header.jsp"></jsp:include>
	<!-- sub contents -->
	<div class="sub_title">
		<h2>갤러리</h2>
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
					<a href="">갤러리<i class="fa fa-plus btn_plus"></i></a>
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
	  <div class="search_wrap">
		<div class="record_group">
			<p>총게시글<span>120</span>건</p>
		</div>
		<div class="search_group">
			<form name="myform" action="">
				<select name="sel" class="select">
					<option value="1">제목</option>
					<option value="2">내용</option>
				</select>
				<input type="text" name="search" class="search_word">
				<button class="btn_search"><i class="fa fa-search"></i><span class="sr-only">검색버튼</span></button>
			</form>
		</div>
	  </div> <!-- search end -->
	  <div class="bord_list">
	    <div class="gallery_wrap">
			<ul>
				<li>
					<a href=""><img src="../images/gallery.jpg" alt=""></a>
					<span class="title">제목입니다</span><div class="gallery_count"><span class="count"><i class="fa fa-eye"></i></span><span>&nbsp;231</span></div>
				</li>
				<li>
					<a href=""><img src="../images/gallery.jpg" alt=""></a>
					<span class="title">제목입니다</span><div class="gallery_count"><span class="count"><i class="fa fa-eye"></i></span><span>&nbsp;231</span></div>
				</li>
				<li>
					<a href=""><img src="../images/gallery.jpg" alt=""></a>
					<span class="title">제목입니다</span><div class="gallery_count"><span class="count"><i class="fa fa-eye"></i></span><span>&nbsp;231</span></div>
				</li>
				<li>
					<a href=""><img src="../images/gallery.jpg" alt=""></a>
					<span class="title">제목입니다</span><div class="gallery_count"><span class="count"><i class="fa fa-eye"></i></span><span>&nbsp;231</span></div>
				</li>
				<li>
					<a href=""><img src="../images/gallery.jpg" alt=""></a>
					<span class="title">제목입니다</span><div class="gallery_count"><span class="count"><i class="fa fa-eye"></i></span><span>&nbsp;231</span></div>
				</li>
				<li>
					<a href=""><img src="../images/gallery.jpg" alt=""></a>
					<span class="title">제목입니다</span><div class="gallery_count"><span class="count"><i class="fa fa-eye"></i></span><span>&nbsp;231</span></div>
				</li>
				<li>
					<a href=""><img src="../images/gallery.jpg" alt=""></a>
					<span class="title">제목입니다</span><div class="gallery_count"><span class="count"><i class="fa fa-eye"></i></span><span>&nbsp;231</span></div>
				</li>
				<li>
					<a href=""><img src="../images/gallery.jpg" alt=""></a>
					<span class="title">제목입니다</span><div class="gallery_count"><span class="count"><i class="fa fa-eye"></i></span><span>&nbsp;231</span></div>
				</li>
				<li>
					<a href=""><img src="../images/gallery.jpg" alt=""></a>
					<span class="title">제목입니다</span><div class="gallery_count"><span class="count"><i class="fa fa-eye"></i></span><span>&nbsp;231</span></div>
				</li>
			</ul>
		  </div>
		
		<!-- modal process -->

		<div class="modal">
			
			<div class="modal_background">
			</div>
			<div class="modal_content">
				<a href=""><i class="fa fa-close"></i></a>
				<div class="modal_body">
					<img src="images/gallery.jpg" alt="">
				</div>
			</div>
		</div>

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
			<a href="photo_write.html" class="btn_write">글쓰기</a>
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

		$(".gallery_wrap > ul > li > a").on("click",function(e) {
			e.preventDefault();
			$(".modal").fadeIn(1000);
			

			});
		$(".modal .modal_content > a").on("click", function(e) {
			e.preventDefault();
			$(".modal").fadeOut(1000);
		});

		});
	</script>
	
<jsp:include page="/footer.jsp"></jsp:include>

 </body>
</html>










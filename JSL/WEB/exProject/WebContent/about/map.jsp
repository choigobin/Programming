<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/header.jsp"></jsp:include>
	<!-- sub contents -->
	<div class="sub_title">
		<h2>찾아오시는길</h2>
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
					<a href="">찾아오시는길<i class="fa fa-plus btn_plus"></i></a>
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
		<div class="text_center">
				<p><strong>JSL인재개발원(대전)</strong></p>
				<span class="col_bar"></span>
		</div>

		<div class="map_cont">
			<div id="map" style="width:100%;"><p><img src="../images/map.jpg" alt="" style="width:100%;"></p><p style="margin-top:20px;"><a href="https://map.naver.com/?searchCoord=32943c64d98f3649838fdf2bf0437f0d59b1cb6998a34a4238977cdb8ed8c84f&query=67mE7KC87KeB7JeF7KCE66y47ZWZ6rWQ&menu=location&street=on&tab=1&lng=c6bc0397ad9741b833c37da6a2a0a8c9&mapMode=0&vrpanofov=120&vrpanoid=5JmgegTvhY7Ow%2B0byAEPFA%3D%3D&mpx=36ba12183157e689ec1a06cb0032dcc7e2ce2f14dadff5a58bdd9987af435973f7b2edb298b3bcf011fccc47676667ee5407459eefe2d2bba46a16cec8e28f1e&vrpanopan=26.77051835202983&vrpanotilt=0&lat=99d0c44b63a1955617ff2a3195fc3bf6&dlevel=12&enc=b64" style="padding:10px; border:1px solid #ddd;" target="_blank">지도크게보기</a></p>
			<p style="padding-top:50px; line-height:180%;"><strong>주소</strong><br>
				(대전센터)대전광역시 중구 계룡로 825 (용두동, 희영빌딩) 5층,6층/ (서울센터)서울특별시 송파구 올림픽로 35길 104 ( 장미C상가 403호 )</p>
				<p style="padding-top:20px; line-height:180%;"><strong>고객센터</strong><br>
				042-242-4412</p>
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
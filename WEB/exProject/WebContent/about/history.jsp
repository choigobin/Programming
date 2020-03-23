<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/header.jsp"></jsp:include>
	<!-- sub contents -->
	<div class="sub_title">
		<h2>연혁</h2>
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
					<a href="">연혁<i class="fa fa-plus btn_plus"></i></a>
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
		<div class="history_wrap">
			<h3 class="title3">연혁</h3>
			<ul class="history_list">
				<li>
					<strong class="years">
						<span>2018</span>
						<span>년</span>
					</strong>
					<ul>
						<li>
							<strong class="year">06월</strong>
							<ul>
								<li>
									<span>06.10</span>
									<ul>
										<li>국가기간 전략산업 승인</li>
									</ul>
								</li>
							</ul>
						</li>
						<li>
							<strong class="year">05월</strong>
							<ul>
								<li>
									<span>05.22</span>
									<ul>
										<li>스마트기반응용SW개발학과 졸업</li>
										<li>빅데이터기반응용SW개발학과 졸업</li>
									</ul>
								</li>
							</ul>
						</li>
					</ul>
				</li>
				<li>
					<strong class="years">
						<span>2017</span>
						<span>년</span>
					</strong>
					<ul>
						<li>
							<strong class="year">03월</strong>
							<ul>
								<li>
									<span>03.10</span>
									<ul>
										<li>국가기간 전략산업 승인</li>
									</ul>
								</li>
							</ul>
						</li>
						<li>
							<strong class="year">01월</strong>
							<ul>
								<li>
									<span>01.22</span>
									<ul>
										<li>스마트기반응용SW개발학과 졸업</li>
										<li>빅데이터기반응용SW개발학과 졸업</li>
									</ul>
								</li>
							</ul>
						</li>
					</ul>
				</li>
			</ul>
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










<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/header.jsp"></jsp:include>
	
	<!-- sub contents -->
	<div class="sub_title">
		<h2>접속자 로그인</h2>
		<div class="container">
		  <div class="location">
			<ul>
				<li class="btn_home">
					<a href="/index.jsp"><i class="fa fa-home btn_plus"></i></a>
				</li>
				<li class="dropdown">
					<a href="">메뉴<i class="fa fa-plus btn_plus"></i></a>
					<div class="dropdown_menu">
						<a href="/about/gratings.jsp">기업소개</a>
						<a href="/portfolio/portfolio.jsp">포트폴리오</a>
						<a href="/notice/notice.jsp">커뮤니티</a>
					</div>
				</li>
			</ul>
		  </div>
		</div><!-- container end -->
	</div>

	<div class="container">
		<form name="frmLogin" method="post">
			<div class="member_boxL">
                <h2>개인회원</h2>
                <div class="login_form">
                    <div class="fl_clear"><label for="mbrId">아이디</label><input name="mbrId" id="mbrId" type="text"></div>
                    <div class="fl_clear"><label for="scrtNo">비밀번호</label><input name="scrtNo" id="scrtNo" type="password"></div>
                    <a class="btn_login btn_Blue" href="javascript:fn_login();">로그인</a>
                </div>
               
            </div>
		</form>
	  
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
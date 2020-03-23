<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/header.jsp"></jsp:include>
<jsp:include page="/portfolio/subnavi.jsp"></jsp:include>

	<div class="container">
		<div class="board_view">
			<h2>스마트기반응용SW개발과정 입학식</h2>
			<p class="info"><span class="user">홍길동</span> | 2018-10-18 | <i class="fa fa-eye"></i> 321</p>
			<div class="board_body">
				<p>저는 사물인터넷 응용소프트웨어 과정을  수료하고 ‘서른한 살, 첫 취직’에성공했습니다.</p>

<p>그 전에 저는 4년의 절망적인 시간을 보냈습니다.</p> 

​<p>결혼을 하고 내 아이가 세상에 나오는 기쁨을 만끽하기도 전에 이렇다 할 직업도 가지지 못한 저는 취업실패와공무원시험 불합격으로 좌절과 우울함의 시간을 보냈습니다.</p>

<p>하지만 가장인 제가 포기할 수는 없었고 길을 찾던 중 떠오른 것이 지나다니며 봤던 직업전문학교였습니다.</p> 

​<p>자신감이 바닥을 치던 저는 무작정 찾아간 직업전문학교의 상담실에서 취직을 할 수 있다는 희망의 기운을 가지고돌아왔습니다</p>

<p>그리고 오리엔테이션이 지나고 강의를 하루하루 들으며 인생 처음 해 본 코딩에서 희망의 기운이 취직을 할 수 있다는확신으로 바뀌고 있음을 깨달았습니다.</p> 

​<p>하나하나, 한 사람한 사람 자세히 설명을 해주셔서 어려운 내용도 쉽게 따라갈 수 있었습니다.</p> 

<p>지금은 그 확신이 틀리지 않았음을 몸소 느끼며 회사에서 퇴근 후에 이 글을 쓰고 있습니다.</p> 

​<p>돌아갈 수만 있다면 조금이라도 망설였던 저 자신에게 넌 할 수 있다고, 그리고고맙다고 전해주고 싶습니다.</p>
<img src="images/gallery.jpg" alt="">
			</div>
			<div class="prev_next">
				<a href="" class="btn_prev"><i class="fa fa-angle-left"></i>
				<span class="prev_wrap">
					<strong>이전글</strong><span>이전글제목표시</span>
				</span>
				</a>
				<div class="btn_3wrap">
					<a href="/portfolio/portfolio.jsp">목록</a> <a href="portfolio_modify.jsp">수정</a> <a href="portfolio_delete.jsp" onClick="return confirm('삭제하시겠어요?')">삭제</a>
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

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,model.*" %>
<%request.setCharacterEncoding("utf-8"); %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
	<title>CHOI KANGMIN</title>
	<link href="/css/font-awesome.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
	<link href="/css/common.css" rel="stylesheet">
	<link href="/css/mystyle.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
  <script>
    $(function(){
    	
      $('.slider').bxSlider({
    	  mode: 'fade',
    	  captions: true,
    	  auto: true,
    	  autoHover: true,
    	  speed: 1000
      });
      
      $(".sitemap").click(function() {
			$(".sitewrap").slideDown();
		})
	  $("#close").click(function() {
			$(".sitewrap").slideUp();
		})
		
	  $(".nav > nav > .navi > li").hover(function() {
		  $(this).children(".navi2").stop().slideDown();
	  }, function() {
		  $(this).children(".navi2").stop().slideUp();
	  });
		
    });
  </script>

</head>
<body>
	<div class="header">
		<header>
			<div class="topnav">
				<ul>
				<%
				if(session.getAttribute("user")!=null){
					%>
					<li>
						<c:if test="${user.getGrade() eq 'A'}">
							관리자 
						</c:if>
						${user.getName()} 님 
						<a href="/member/logout.jsp">로그아웃</a>
					</li>
					<%
				}else{
					%>
					<li><a href="/member/login.jsp">로그인</a></li>
					<li><a href="/member/member.jsp">회원가입</a></li>
					<%
				}
				%>
					<li><a href="javascript:void(0)" class="sitemap">사이트맵</a></li>
				</ul>
			</div>
			<div class="navigation">
				<h1 class="logo"><a href="/index.jsp">CHOI KANGMIN</a></h1>
				<div class="nav">
					<nav>
						<ul class="navi">
							<li><a href="/about/about.jsp">내소개</a>
								<ul class="navi2">
									<li><a href="/about/about.jsp">이력서</a></li>
									<li><a href="/about/about2.jsp">자기소개서</a></li>
								</ul>
							</li>
							<li><a href="/portfolio/portfolio.jsp">포트폴리오</a>
								<ul class="navi2">
									<li><a href="#">웹개발</a></li>
								</ul>
							</li>
							<li><a href="/gallery/gallery.jsp">학습공간</a>
								<ul class="navi2">
									<li><a href="#">JAVA</a></li>
									<li><a href="#">SerVlet</a></li>
									<li><a href="#">JSP</a></li>
									<li><a href="#">Oracle</a></li>
								</ul>
							</li>
							<li><a href="/qa/qa.jsp">질문답변</a>
								<ul class="navi2">
									<li><a href="#">FAQ</a></li>
									<li><a href="#">질문게시판</a></li>
								</ul>
							</li>
							<li><a href="/notice/notice.jsp">공지사항</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</header>
	</div>
	
	<div class="line"></div>
	
	<div class="sitewrap">
		<span class="fa fa-close" id="close" style="cursor:pointer"></span>
		<div class="inner">
			<span class="map"><a href="/about/about.jsp" style="color: white">내소개</a></span>
			<span class="map"><a href="/portfolio/portfolio.jsp" style="color: white">포트폴리오</a></span>
			<span class="map"><a href="/gallery/gallery.jsp" style="color: white">학습공간</a></span>
			<span class="map"><a href="/qa/qa.jsp" style="color: white">질문답변</a></span>
			<span class="map"><a href="/notice/notice.jsp" style="color: white">공지사항</a></span>
		</div>
	</div>
	
	
	
	
	
	
	
	
	
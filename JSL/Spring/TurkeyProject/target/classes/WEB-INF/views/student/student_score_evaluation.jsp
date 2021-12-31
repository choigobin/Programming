<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    

<link href="../css/turkey_style.css?ver=2" rel="stylesheet">

<title>Turkey University</title>

	<div class="post_check">
		<div class="post_check_miniheader">
			<img src="/img/turkey_1.png">
			<div class="post_check_miniheader_name">Turkey University</div>
			<div class="post_check_miniheader_description">JSL Information Portal System</div>
		</div>
		<div class="evaluation_lecture_name">
			<b>${vo.sub_name}</b> 강의 평가
		</div>
		<div class="evaluation_lecture_form">
			<form>
					<div class="starRev">
		  		
 							<span class="starR on">${pyung.list_pyung_score}</span>
					  		
 					 		
					  		<span class="starR">2</span>
					  		<span class="starR">3</span>
					  		<span class="starR">4</span>
					  		<span class="starR">5</span>
					</div>
			</form>
		</div>
	</div>
	
<script src="/js/jquery-1.11.3.min.js"></script>
<script src="/js/star.js"></script>
<script>
$('.starRev span').click(function(){
	  $(this).parent().children('span').removeClass('on');
	  $(this).addClass('on').prevAll('span').addClass('on');
	  return false;
	});
</script>

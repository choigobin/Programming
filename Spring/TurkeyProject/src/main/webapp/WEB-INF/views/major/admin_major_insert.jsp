<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link href="../css/all_style.css?ver=2" rel="stylesheet">

<div class="all">

	<%@ include file="../include/header.jsp"%>

	<%@ include file="../include/navigation_adm.jsp"%>

	<div class="admin_contents">
		<div class="admin_contents_category">
			<div class="admin_contents_category_menu_select">
				<a href="">학과 정보 등록</a>
			</div>
			<div class="admin_contents_category_menu">
				<a href="">학과별 학생 조회</a>
			</div>
			<div class="admin_contents_category_menu">
				<a href="">학과별 교수 조회</a>
			</div>
		</div>

		<div class="admin_contents_main">
			<div class="admin_contents_main_in">
				<div class="admin_contents_main_a">
					<form name="admin">
						<div class="admin_contents_main_a_1">
							<div class="admin_contents_main_a_1_photo">
								<input type="file" name="filename">
							</div>
						</div>

						<div class="admin_contents_main_a_2">
							<div class="admin_contents_main_a_2_table">
								<table>
									<tr>
										<th>학번</th>
										<td><input type="text" name="userid"></td>
									</tr>
									<tr>
										<th>성명(한글)</th>
										<td><input type="text" name="userid"></td>
									</tr>
									<tr>
										<th>생년월일</th>
										<td>
											<select name="year" style="width:72px;">
												<option value="1985">1985
												<option value="1986">1986
												<option value="1987">1987
												<option value="1997">1997
											</select>
											<select name="month" style="width:53px;">
												<option value="01">01
												<option value="02">02
												<option value="03">03
												<option value="04">04
												<option value="05">05
												<option value="06">06
												<option value="07">07
												<option value="08">08
												<option value="09">09
												<option value="10">10
												<option value="11">11
												<option value="12">12
											</select>
											<select name="day" style="width:53px;">
												<option value="01">01
												<option value="02">02
												<option value="03">03
												<option value="04">04
											</select>
												
										</td>
									</tr>
									<tr>
										<th>성별</th>
										<td>
											<input type="radio" name="gender" value="남자">남자
											<input type="radio" name="gender" value="여자">여자
										</td>
									</tr>
								</table>
							</div>
						</div>

						<div class="admin_contents_main_a_3">
							<div class="admin_contents_main_a_3_table">
								<table>
									<tr>
										<th>학과</th>
										<td>
											<select name="major">
												<option value="경영학과">경영학과
												<option value="경제학과">경제학과
												<option value="IT학과">IT학과
												<option value="일본어학과">일본어학과
											</select>
										</td>
									</tr>
									<tr>
										<th>성명(영어)</th>
										<td><input type="text" name="userid"></td>
									</tr>
									<tr>
										<th>국적</th>
										<td>
											<select name="nationality">
												<option value="한국">한국
												<option value="일본">일본
												<option value="중국">중국
												<option value="미국">미국
											</select>
										</td>
									</tr>
									<tr>
										<th>학적상태</th>
										<td>
											<select name="stu_state">
												<option value="-1">학년선택
												<option value="0">전체
												<option value="1">1학년
												<option value="2">2학년
												<option value="3">3학년
												<option value="4">4학년
												<option value="휴학">휴학
												<option value="수료">수료
												<option value="졸업">졸업
											</select>
										</td>
									</tr>
								</table>
							</div>
						</div>
					</form>
				</div>
				<div class="admin_contents_main_b">
					<div class="admin_contents_main_b_address">
						<table>
							<tr>
								<th>▶ 학생 주소</th>
							</tr>
							<tr>
								<th>우편번호</th>
								<td>
									<input type="text" name="userid">&nbsp;
									<a href="#" onClick="post_check()"><img src="../images/search.png"></a>
								</td>
							</tr>
							<tr>
								<th>상세주소</th>
								<td>
									<input type="text" name="email_1" style="width:260px;">
									<input type="text" name="email_2" style="width:260px;">
								</td>
							</tr>
						</table>
					</div>
					<div class="admin_contents_main_b_contact">
						<table>
							<tr>
								<th>▶ 학생 연락처</th>
							</tr>
							<tr>
								<th>전화번호</th>
								<td>
									<select name="tel_1">
										<option value="010">010
										<option value="011">011
									</select><b> - </b>
									<input type="text" name="tel_2"><b> - </b>
									<input type="text" name="tel_3">
								</td>
							</tr>
							<tr>
								<th>이메일</th>
								<td>&nbsp;&nbsp;&nbsp;
									<input type="text" name="email_1" style="width:130px;"><b> @ </b>
									<input type="text" name="email_2" style="width:130px;">
									<select name="email_3" style="width:130px;">
										<option value="0">직접입력
										<option value="naver.com">naver.com
										<option value="daum.net">daum.net
										<option value="gmail.com">gmail.com
									</select>
								</td>
							</tr>
						</table>
					</div>
					<div class="admin_contents_main_b_send">
						<input type="button" value="등록">
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../include/footer.jsp"%>
</div>

<script>
	function post_check() {
		window.open("admin_stu_insert_post.jsp", "admin_stu_insert_post",
		"width=510 height=540");
		
	}
</script>
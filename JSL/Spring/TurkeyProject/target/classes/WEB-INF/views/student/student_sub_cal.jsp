<%@page import="com.jslhrd.domain.SubjectVO"%>
<%@page import="javax.security.auth.Subject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.*"%>
<%@page import="com.jslhrd.controller.*"%>

<link href="../css/all_style.css?ver=2" rel="stylesheet">

<style>
table td {
	width: 200px;
	height: 45px;
	text-align: center;
	border-bottom: 0.3px solid #8C8C8C;
	background-color: #fff;
	letter-spacing: 1.5px; /*자간 간격 */
	font-size:13px;
}
</style>

<script>
	function stu_search() {
		if (stu.year.selectedIndex==0) {
			alert('조회하실 년도를 선택해주세요');
			return false;
		}
		if (stu.semester.selectedIndex==0) {
			alert('조회하실 학기를 선택해주세요');
			return false;
		}
	stu.submit();
	}
</script>

<div class="all">

	<%@ include file="../include/header.jsp"%>

	<div class="navigation_stu">
		<ul>
			<li><a href="/Turkey/student_view">정보 조회</a></li>
			<li><a href="/Turkey/student_score">성적 조회</a></li>
			<li style="background-color: #FFF;"><a href="/Turkey/student_sub_cal" style="color: #2F5597;">시간표 조회</a></li>
			<li><a href="/Turkey/student_attendance">출결 조회</a></li>
			<li><a href="/Turkey/illjung_list2">학사일정</a></li>
			<li><a href="/Turkey/student_apply">수강신청</a></li>
		</ul>
	</div>

	<div class="contents">
			<div class="contents_inform_view_stu">
				<div class="contents_inform_view_detail">
				<div class="stu_detail_search">
					<form name="stu" method="post" action="student_sub_cal">
						<select name="year">
							<option value="-1">년도선택
							<c:forEach var="list" items="${list}">
								<option value="${list.year}" />${list.year}
							</c:forEach>
						</select>
						<select name="semester">
							<option value="-1">학기선택
							<option value="1">1학기
							<option value="2">2학기
						</select>
						<input type="button" value="조회" onClick="stu_search()">
					</form>
				
					<%
						List<SubjectVO> s = null;
					
						if(request.getAttribute("list2") != null){
							s = (List<SubjectVO>) request.getAttribute("list2");
						}

						String[] bon = new String[99]; 		// 리스트 돌 때의 TIME_A 본체 저장
						String[] bon1 = new String[99]; 	// 리스트 돌 때의 TIME_B 본체 저장
						String[] name = new String[99]; 	// 과목이름
						String[] code = new String[99];
						String[] aname = new String[99]; 	// 월요일과목
						String[] bname = new String[99];	// 화요일과목
						String[] cname = new String[99];	// 수요일과목
						String[] dname = new String[99];	// 목요일과목
						String[] ename = new String[99];	// 금요일과목
						
						String nname=" "; // 과목이름
						
						int var=0; // 2자리 3자리 구분

						String[] acheck = new String[99]; 	// 월요일 체크 (TIME_A)
						String[] acheck1 = new String[99]; 	// 월요일 체크 (TIME_B)
						String[] bcheck = new String[99]; 	// 화요일 체크 (TIME_A)
						String[] bcheck1 = new String[99]; 	// 화요일 체크 (TIME_B)
						String[] ccheck = new String[99]; 	// 수요일 체크 (TIME_A)
						String[] ccheck1 = new String[99]; 	// 수요일 체크 (TIME_B)
						String[] dcheck = new String[99]; 	// 목요일 체크 (TIME_A)
						String[] dcheck1 = new String[99]; 	// 목요일 체크 (TIME_B)
						String[] echeck = new String[99]; 	// 금요일 체크 (TIME_A)
						String[] echeck1 = new String[99]; 	// 금요일 체크 (TIME_B)


						int size = s.size();

						for (int i = 0; i < size; i++) {
							bon[i] = s.get(i).getTime_a();
							bon1[i] = s.get(i).getTime_b();
							name[i] = s.get(i).getSub_name();
							code[i] = s.get(i).getSub_code();
							
						}
						for(int x=0; x<bon.length; x++){
							if(bon[x]==null){
								bon[x]="0";
							}
							if(bon1[x]==null){
								bon1[x]="0";
							}
						}
						
					%>
					<table>
						<tr>
							<td>
								<table>
									<tr>
										<td>시간</td>
									</tr>
									<tr>
										<td>1교시<br>(9:00 - 9:50)</td>
									</tr>
									<tr>
										<td>2교시<br>(10:00 - 10:50)</td>
									</tr>
									<tr>
										<td>3교시<br>(11:00 - 11:50)</td>
									</tr>
									<tr>
										<td>4교시<br>(12:00 - 12:50)</td>
									</tr>
									<tr>
										<td>5교시<br>(13:00 - 13:50)</td>
									</tr>
									<tr>
										<td>6교시<br>(14:00 - 14:50)</td>
									</tr>
									<tr>
										<td>7교시<br>(15:00 - 15:50)</td>
									</tr>
									<tr>
										<td>8교시<br>(16:00 - 16:50)</td>
									</tr>
									<tr>
										<td>9교시<br>(17:00 - 17:50)</td>
									</tr>
								</table>
							</td>
							<td>
								<table>
									<tr>
										<td
											<%	for (int x = 0; x < bon.length; x++) {
												if (bon[x] != null) {
													if ("A".equals(bon[x].substring(0, 1))) {
														acheck[x] = Integer.toString(x);
														aname[x]=name[x];
													}
												}
												if (bon1[x] != null) {
													if ("A".equals(bon1[x].substring(0, 1))) {
														acheck1[x] = Integer.toString(x);
														aname[x]=name[x];
													}
												}
											}
			%>>월</td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (acheck[x] == null) {
						acheck[x] = "100";
					}
					if (acheck1[x] == null) {
						acheck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(acheck[x])) {
								if ("1".equals(bon[y].substring(1, 2)) || "1".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=aname[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(acheck1[x])) {
								if ("1".equals(bon1[y].substring(1, 2)) || "1".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=aname[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(acheck[x])) {
								if ("1".equals(bon[y].substring(1, 2)) || "1".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 1) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=aname[y];}
							}
							if (y == Integer.parseInt(acheck1[x])) {
								if ("1".equals(bon[y].substring(1, 2)) || "1".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 1) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=aname[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (acheck[x] == null) {
						acheck[x] = "100";
					}
					if (acheck1[x] == null) {
						acheck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(acheck[x])) {
								if ("2".equals(bon[y].substring(1, 2)) || "2".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=aname[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(acheck1[x])) {
								if ("2".equals(bon1[y].substring(1, 2)) || "2".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=aname[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(acheck[x])) {
								if ("2".equals(bon[y].substring(1, 2)) || "2".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 2) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=aname[y];}
							}
							if (y == Integer.parseInt(acheck1[x])) {
								if ("2".equals(bon[y].substring(1, 2)) || "2".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 2) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=aname[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (acheck[x] == null) {
						acheck[x] = "100";
					}
					if (acheck1[x] == null) {
						acheck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(acheck[x])) {
								if ("3".equals(bon[y].substring(1, 2)) || "3".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=aname[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(acheck1[x])) {
								if ("3".equals(bon1[y].substring(1, 2)) || "3".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=aname[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(acheck[x])) {
								if ("3".equals(bon[y].substring(1, 2)) || "3".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 3) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=aname[y];}
							}
							if (y == Integer.parseInt(acheck1[x])) {
								if ("3".equals(bon[y].substring(1, 2)) || "3".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 3) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=aname[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (acheck[x] == null) {
						acheck[x] = "100";
					}
					if (acheck1[x] == null) {
						acheck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(acheck[x])) {
								if ("4".equals(bon[y].substring(1, 2)) || "4".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=aname[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(acheck1[x])) {
								if ("4".equals(bon1[y].substring(1, 2)) || "4".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=aname[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(acheck[x])) {
								if ("4".equals(bon[y].substring(1, 2)) || "4".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 4) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=aname[y];}
							}
							if (y == Integer.parseInt(acheck1[x])) {
								if ("4".equals(bon[y].substring(1, 2)) || "4".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 4) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=aname[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (acheck[x] == null) {
						acheck[x] = "100";
					}
					if (acheck1[x] == null) {
						acheck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(acheck[x])) {
								if ("5".equals(bon[y].substring(1, 2)) || "5".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=aname[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(acheck1[x])) {
								if ("5".equals(bon1[y].substring(1, 2)) || "5".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=aname[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(acheck[x])) {
								if ("5".equals(bon[y].substring(1, 2)) || "5".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 5) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=aname[y];}
							}
							if (y == Integer.parseInt(acheck1[x])) {
								if ("5".equals(bon[y].substring(1, 2)) || "5".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 5) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=aname[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (acheck[x] == null) {
						acheck[x] = "100";
					}
					if (acheck1[x] == null) {
						acheck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(acheck[x])) {
								if ("6".equals(bon[y].substring(1, 2)) || "6".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=aname[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(acheck1[x])) {
								if ("6".equals(bon1[y].substring(1, 2)) || "6".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=aname[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(acheck[x])) {
								if ("6".equals(bon[y].substring(1, 2)) || "6".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 6) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=aname[y];}
							}
							if (y == Integer.parseInt(acheck1[x])) {
								if ("6".equals(bon[y].substring(1, 2)) || "6".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 6) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=aname[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (acheck[x] == null) {
						acheck[x] = "100";
					}
					if (acheck1[x] == null) {
						acheck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(acheck[x])) {
								if ("7".equals(bon[y].substring(1, 2)) || "7".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=aname[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(acheck1[x])) {
								if ("7".equals(bon1[y].substring(1, 2)) || "7".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=aname[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(acheck[x])) {
								if ("7".equals(bon[y].substring(1, 2)) || "7".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 7) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=aname[y];}
							}
							if (y == Integer.parseInt(acheck1[x])) {
								if ("7".equals(bon[y].substring(1, 2)) || "7".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 7) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=aname[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (acheck[x] == null) {
						acheck[x] = "100";
					}
					if (acheck1[x] == null) {
						acheck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(acheck[x])) {
								if ("8".equals(bon[y].substring(1, 2)) || "8".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=aname[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(acheck1[x])) {
								if ("8".equals(bon1[y].substring(1, 2)) || "8".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=aname[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(acheck[x])) {
								if ("8".equals(bon[y].substring(1, 2)) || "8".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 8) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=aname[y];}
							}
							if (y == Integer.parseInt(acheck1[x])) {
								if ("8".equals(bon[y].substring(1, 2)) || "8".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 8) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=aname[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (acheck[x] == null) {
						acheck[x] = "100";
					}
					if (acheck1[x] == null) {
						acheck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(acheck[x])) {
								if ("9".equals(bon[y].substring(1, 2)) || "9".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=aname[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(acheck1[x])) {
								if ("9".equals(bon1[y].substring(1, 2)) || "9".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=aname[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(acheck[x])) {
								if ("9".equals(bon[y].substring(1, 2)) || "9".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 9) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=aname[y];}
							}
							if (y == Integer.parseInt(acheck1[x])) {
								if ("9".equals(bon[y].substring(1, 2)) || "9".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 9) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=aname[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
								</table>
							</td>
							<td>
								<table>
									<tr>
										<td
											<%
			for (int x = 0; x < bon.length; x++) {
				if (bon[x] != null) {
					if ("B".equals(bon[x].substring(0, 1))) {
						bcheck[x] = Integer.toString(x);
						bname[x]=name[x];
					}
				}
				if (bon1[x] != null) {
					if ("B".equals(bon1[x].substring(0, 1))) {
						bcheck1[x] = Integer.toString(x);
						bname[x]=name[x];
					}
				}
			}

			%>>화</td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (bcheck[x] == null) {
						bcheck[x] = "100";
					}
					if (bcheck1[x] == null) {
						bcheck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(bcheck[x])) {
								if ("1".equals(bon[y].substring(1, 2)) || "1".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=bname[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(bcheck1[x])) {
								if ("1".equals(bon1[y].substring(1, 2)) || "1".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=bname[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(bcheck[x])) {
								if ("1".equals(bon[y].substring(1, 2)) || "1".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 1) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=bname[y];}
							}
							if (y == Integer.parseInt(bcheck1[x])) {
								if ("1".equals(bon[y].substring(1, 2)) || "1".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 1) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=bname[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (bcheck[x] == null) {
						bcheck[x] = "100";
					}
					if (bcheck1[x] == null) {
						bcheck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(bcheck[x])) {
								if ("2".equals(bon[y].substring(1, 2)) || "2".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=bname[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(bcheck1[x])) {
								if ("2".equals(bon1[y].substring(1, 2)) || "2".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=bname[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(bcheck[x])) {
								if ("2".equals(bon[y].substring(1, 2)) || "2".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 2) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=bname[y];}
							}
							if (y == Integer.parseInt(bcheck1[x])) {
								if ("2".equals(bon[y].substring(1, 2)) || "2".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 2) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=bname[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (bcheck[x] == null) {
						bcheck[x] = "100";
					}
					if (bcheck1[x] == null) {
						bcheck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(bcheck[x])) {
								if ("3".equals(bon[y].substring(1, 2)) || "3".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=bname[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(bcheck1[x])) {
								if ("3".equals(bon1[y].substring(1, 2)) || "3".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=bname[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(bcheck[x])) {
								if ("3".equals(bon[y].substring(1, 2)) || "3".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 3) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=bname[y];}
							}
							if (y == Integer.parseInt(bcheck1[x])) {
								if ("3".equals(bon[y].substring(1, 2)) || "3".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 3) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=bname[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (bcheck[x] == null) {
						bcheck[x] = "100";
					}
					if (bcheck1[x] == null) {
						bcheck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(bcheck[x])) {
								if ("4".equals(bon[y].substring(1, 2)) || "4".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=bname[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(bcheck1[x])) {
								if ("4".equals(bon1[y].substring(1, 2)) || "4".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=bname[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(bcheck[x])) {
								if ("4".equals(bon[y].substring(1, 2)) || "4".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 4) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=bname[y];}
							}
							if (y == Integer.parseInt(bcheck1[x])) {
								if ("4".equals(bon[y].substring(1, 2)) || "4".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 4) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=bname[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (bcheck[x] == null) {
						bcheck[x] = "100";
					}
					if (bcheck1[x] == null) {
						bcheck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(bcheck[x])) {
								if ("5".equals(bon[y].substring(1, 2)) || "5".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=bname[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(bcheck1[x])) {
								if ("5".equals(bon1[y].substring(1, 2)) || "5".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=bname[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(bcheck[x])) {
								if ("5".equals(bon[y].substring(1, 2)) || "5".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 5) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=bname[y];}
							}
							if (y == Integer.parseInt(bcheck1[x])) {
								if ("5".equals(bon[y].substring(1, 2)) || "5".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 5) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=bname[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (bcheck[x] == null) {
						bcheck[x] = "100";
					}
					if (bcheck1[x] == null) {
						bcheck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(bcheck[x])) {
								if ("6".equals(bon[y].substring(1, 2)) || "6".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=bname[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(bcheck1[x])) {
								if ("6".equals(bon1[y].substring(1, 2)) || "6".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=bname[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(bcheck[x])) {
								if ("6".equals(bon[y].substring(1, 2)) || "6".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 6) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=bname[y];}
							}
							if (y == Integer.parseInt(bcheck1[x])) {
								if ("6".equals(bon[y].substring(1, 2)) || "6".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 6) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=bname[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (bcheck[x] == null) {
						bcheck[x] = "100";
					}
					if (bcheck1[x] == null) {
						bcheck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(bcheck[x])) {
								if ("7".equals(bon[y].substring(1, 2)) || "7".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=bname[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(bcheck1[x])) {
								if ("7".equals(bon1[y].substring(1, 2)) || "7".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=bname[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(bcheck[x])) {
								if ("7".equals(bon[y].substring(1, 2)) || "7".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 7) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=bname[y];}
							}
							if (y == Integer.parseInt(bcheck1[x])) {
								if ("7".equals(bon[y].substring(1, 2)) || "7".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 7) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=bname[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (bcheck[x] == null) {
						bcheck[x] = "100";
					}
					if (bcheck1[x] == null) {
						bcheck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(bcheck[x])) {
								if ("8".equals(bon[y].substring(1, 2)) || "8".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=bname[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(bcheck1[x])) {
								if ("8".equals(bon1[y].substring(1, 2)) || "8".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=bname[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(bcheck[x])) {
								if ("8".equals(bon[y].substring(1, 2)) || "8".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 8) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=bname[y];}
							}
							if (y == Integer.parseInt(bcheck1[x])) {
								if ("8".equals(bon[y].substring(1, 2)) || "8".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 8) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=bname[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (bcheck[x] == null) {
						bcheck[x] = "100";
					}
					if (bcheck1[x] == null) {
						bcheck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(bcheck[x])) {
								if ("9".equals(bon[y].substring(1, 2)) || "9".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=bname[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(bcheck1[x])) {
								if ("9".equals(bon1[y].substring(1, 2)) || "9".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=bname[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(bcheck[x])) {
								if ("9".equals(bon[y].substring(1, 2)) || "9".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 9) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=bname[y];}
							}
							if (y == Integer.parseInt(bcheck1[x])) {
								if ("9".equals(bon[y].substring(1, 2)) || "9".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 9) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=bname[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
								</table>
							</td>
							<td>
								<table>
									<tr>
										<td
											<%
			for (int x = 0; x < bon.length; x++) {
				if (bon[x] != null) {
					if ("C".equals(bon[x].substring(0, 1))) {
						ccheck[x] = Integer.toString(x);
						cname[x]=name[x];
					}
				}
				if (bon1[x] != null) {
					if ("C".equals(bon1[x].substring(0, 1))) {
						ccheck1[x] = Integer.toString(x);
						cname[x]=name[x];
					}
				}
			}

			%>>수</td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (ccheck[x] == null) {
						ccheck[x] = "100";
					}
					if (ccheck1[x] == null) {
						ccheck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(ccheck[x])) {
								if ("1".equals(bon[y].substring(1, 2)) || "1".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=cname[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(ccheck1[x])) {
								if ("1".equals(bon1[y].substring(1, 2)) || "1".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=cname[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(ccheck[x])) {
								if ("1".equals(bon[y].substring(1, 2)) || "1".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 1) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=cname[y];}
							}
							if (y == Integer.parseInt(ccheck1[x])) {
								if ("1".equals(bon[y].substring(1, 2)) || "1".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 1) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=cname[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (ccheck[x] == null) {
						ccheck[x] = "100";
					}
					if (ccheck1[x] == null) {
						ccheck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(ccheck[x])) {
								if ("2".equals(bon[y].substring(1, 2)) || "2".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=cname[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(ccheck1[x])) {
								if ("2".equals(bon1[y].substring(1, 2)) || "2".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=cname[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(ccheck[x])) {
								if ("2".equals(bon[y].substring(1, 2)) || "2".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 2) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=cname[y];}
							}
							if (y == Integer.parseInt(ccheck1[x])) {
								if ("2".equals(bon[y].substring(1, 2)) || "2".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 2) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=cname[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (ccheck[x] == null) {
						ccheck[x] = "100";
					}
					if (ccheck1[x] == null) {
						ccheck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(ccheck[x])) {
								if ("3".equals(bon[y].substring(1, 2)) || "3".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=cname[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(ccheck1[x])) {
								if ("3".equals(bon1[y].substring(1, 2)) || "3".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=cname[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(ccheck[x])) {
								if ("3".equals(bon[y].substring(1, 2)) || "3".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 3) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=cname[y];}
							}
							if (y == Integer.parseInt(ccheck1[x])) {
								if ("3".equals(bon[y].substring(1, 2)) || "3".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 3) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=cname[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (ccheck[x] == null) {
						ccheck[x] = "100";
					}
					if (ccheck1[x] == null) {
						ccheck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(ccheck[x])) {
								if ("4".equals(bon[y].substring(1, 2)) || "4".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=cname[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(ccheck1[x])) {
								if ("4".equals(bon1[y].substring(1, 2)) || "4".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=cname[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(ccheck[x])) {
								if ("4".equals(bon[y].substring(1, 2)) || "4".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 4) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=cname[y];}
							}
							if (y == Integer.parseInt(ccheck1[x])) {
								if ("4".equals(bon[y].substring(1, 2)) || "4".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 4) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=cname[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (ccheck[x] == null) {
						ccheck[x] = "100";
					}
					if (ccheck1[x] == null) {
						ccheck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(ccheck[x])) {
								if ("5".equals(bon[y].substring(1, 2)) || "5".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=cname[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(ccheck1[x])) {
								if ("5".equals(bon1[y].substring(1, 2)) || "5".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=cname[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(ccheck[x])) {
								if ("5".equals(bon[y].substring(1, 2)) || "5".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 5) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=cname[y];}
							}
							if (y == Integer.parseInt(ccheck1[x])) {
								if ("5".equals(bon[y].substring(1, 2)) || "5".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 5) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=cname[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (ccheck[x] == null) {
						ccheck[x] = "100";
					}
					if (ccheck1[x] == null) {
						ccheck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(ccheck[x])) {
								if ("6".equals(bon[y].substring(1, 2)) || "6".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=cname[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(ccheck1[x])) {
								if ("6".equals(bon1[y].substring(1, 2)) || "6".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=cname[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(ccheck[x])) {
								if ("6".equals(bon[y].substring(1, 2)) || "6".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 6) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=cname[y];}
							}
							if (y == Integer.parseInt(ccheck1[x])) {
								if ("6".equals(bon[y].substring(1, 2)) || "6".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 6) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=cname[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (ccheck[x] == null) {
						ccheck[x] = "100";
					}
					if (ccheck1[x] == null) {
						ccheck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(ccheck[x])) {
								if ("7".equals(bon[y].substring(1, 2)) || "7".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=cname[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(ccheck1[x])) {
								if ("7".equals(bon1[y].substring(1, 2)) || "7".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=cname[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(ccheck[x])) {
								if ("7".equals(bon[y].substring(1, 2)) || "7".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 7) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=cname[y];}
							}
							if (y == Integer.parseInt(ccheck1[x])) {
								if ("7".equals(bon[y].substring(1, 2)) || "7".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 7) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=cname[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (ccheck[x] == null) {
						ccheck[x] = "100";
					}
					if (ccheck1[x] == null) {
						ccheck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(ccheck[x])) {
								if ("8".equals(bon[y].substring(1, 2)) || "8".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=cname[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(ccheck1[x])) {
								if ("8".equals(bon1[y].substring(1, 2)) || "8".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=cname[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(ccheck[x])) {
								if ("8".equals(bon[y].substring(1, 2)) || "8".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 8) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=cname[y];}
							}
							if (y == Integer.parseInt(ccheck1[x])) {
								if ("8".equals(bon[y].substring(1, 2)) || "8".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 8) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=cname[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (ccheck[x] == null) {
						ccheck[x] = "100";
					}
					if (ccheck1[x] == null) {
						ccheck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(ccheck[x])) {
								if ("9".equals(bon[y].substring(1, 2)) || "9".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=cname[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(ccheck1[x])) {
								if ("9".equals(bon1[y].substring(1, 2)) || "9".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=cname[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(ccheck[x])) {
								if ("9".equals(bon[y].substring(1, 2)) || "9".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 9) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=cname[y];}
							}
							if (y == Integer.parseInt(ccheck1[x])) {
								if ("9".equals(bon[y].substring(1, 2)) || "9".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 9) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=cname[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
								</table>
							</td>
							<td>
								<table>
									<tr>
										<td
											<%
			for (int x = 0; x < bon.length; x++) {
				if (bon[x] != null) {
					if ("D".equals(bon[x].substring(0, 1))) {
						dcheck[x] = Integer.toString(x);
						dname[x]=name[x];
					}
				}
				if (bon1[x] != null) {
					if ("D".equals(bon1[x].substring(0, 1))) {
						dcheck1[x] = Integer.toString(x);
						dname[x]=name[x];
					}
				}
			}

			%>>목</td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (dcheck[x] == null) {
						dcheck[x] = "100";
					}
					if (dcheck1[x] == null) {
						dcheck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(dcheck[x])) {
								if ("1".equals(bon[y].substring(1, 2)) || "1".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=dname[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(dcheck1[x])) {
								if ("1".equals(bon1[y].substring(1, 2)) || "1".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=dname[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(dcheck[x])) {
								if ("1".equals(bon[y].substring(1, 2)) || "1".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 1) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=dname[y];}
							}
							if (y == Integer.parseInt(dcheck1[x])) {
								if ("1".equals(bon[y].substring(1, 2)) || "1".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 1) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=dname[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (dcheck[x] == null) {
						dcheck[x] = "100";
					}
					if (dcheck1[x] == null) {
						dcheck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(dcheck[x])) {
								if ("2".equals(bon[y].substring(1, 2)) || "2".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=dname[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(dcheck1[x])) {
								if ("2".equals(bon1[y].substring(1, 2)) || "2".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=dname[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(dcheck[x])) {
								if ("2".equals(bon[y].substring(1, 2)) || "2".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 2) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=dname[y];}
							}
							if (y == Integer.parseInt(dcheck1[x])) {
								if ("2".equals(bon[y].substring(1, 2)) || "2".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 2) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=dname[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (dcheck[x] == null) {
						dcheck[x] = "100";
					}
					if (dcheck1[x] == null) {
						dcheck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(dcheck[x])) {
								if ("3".equals(bon[y].substring(1, 2)) || "3".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=dname[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(dcheck1[x])) {
								if ("3".equals(bon1[y].substring(1, 2)) || "3".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=dname[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(dcheck[x])) {
								if ("3".equals(bon[y].substring(1, 2)) || "3".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 3) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=dname[y];}
							}
							if (y == Integer.parseInt(dcheck1[x])) {
								if ("3".equals(bon[y].substring(1, 2)) || "3".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 3) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=dname[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (dcheck[x] == null) {
						dcheck[x] = "100";
					}
					if (dcheck1[x] == null) {
						dcheck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(dcheck[x])) {
								if ("4".equals(bon[y].substring(1, 2)) || "4".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=dname[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(dcheck1[x])) {
								if ("4".equals(bon1[y].substring(1, 2)) || "4".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=dname[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(dcheck[x])) {
								if ("4".equals(bon[y].substring(1, 2)) || "4".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 4) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=dname[y];}
							}
							if (y == Integer.parseInt(dcheck1[x])) {
								if ("4".equals(bon[y].substring(1, 2)) || "4".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 4) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=dname[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (dcheck[x] == null) {
						dcheck[x] = "100";
					}
					if (dcheck1[x] == null) {
						dcheck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(dcheck[x])) {
								if ("5".equals(bon[y].substring(1, 2)) || "5".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=dname[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(dcheck1[x])) {
								if ("5".equals(bon1[y].substring(1, 2)) || "5".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=dname[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(dcheck[x])) {
								if ("5".equals(bon[y].substring(1, 2)) || "5".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 5) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=dname[y];}
							}
							if (y == Integer.parseInt(dcheck1[x])) {
								if ("5".equals(bon[y].substring(1, 2)) || "5".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 5) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=dname[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (dcheck[x] == null) {
						dcheck[x] = "100";
					}
					if (dcheck1[x] == null) {
						dcheck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(dcheck[x])) {
								if ("6".equals(bon[y].substring(1, 2)) || "6".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=dname[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(dcheck1[x])) {
								if ("6".equals(bon1[y].substring(1, 2)) || "6".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=dname[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(dcheck[x])) {
								if ("6".equals(bon[y].substring(1, 2)) || "6".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 6) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=dname[y];}
							}
							if (y == Integer.parseInt(dcheck1[x])) {
								if ("6".equals(bon[y].substring(1, 2)) || "6".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 6) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=dname[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (dcheck[x] == null) {
						dcheck[x] = "100";
					}
					if (dcheck1[x] == null) {
						dcheck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(dcheck[x])) {
								if ("7".equals(bon[y].substring(1, 2)) || "7".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=dname[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(dcheck1[x])) {
								if ("7".equals(bon1[y].substring(1, 2)) || "7".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=dname[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(dcheck[x])) {
								if ("7".equals(bon[y].substring(1, 2)) || "7".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 7) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=dname[y];}
							}
							if (y == Integer.parseInt(dcheck1[x])) {
								if ("7".equals(bon[y].substring(1, 2)) || "7".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 7) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=dname[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (dcheck[x] == null) {
						dcheck[x] = "100";
					}
					if (dcheck1[x] == null) {
						dcheck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(dcheck[x])) {
								if ("8".equals(bon[y].substring(1, 2)) || "8".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=dname[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(dcheck1[x])) {
								if ("8".equals(bon1[y].substring(1, 2)) || "8".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=dname[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(dcheck[x])) {
								if ("8".equals(bon[y].substring(1, 2)) || "8".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 8) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=dname[y];}
							}
							if (y == Integer.parseInt(dcheck1[x])) {
								if ("8".equals(bon[y].substring(1, 2)) || "8".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 8) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=dname[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (dcheck[x] == null) {
						dcheck[x] = "100";
					}
					if (dcheck1[x] == null) {
						dcheck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(dcheck[x])) {
								if ("9".equals(bon[y].substring(1, 2)) || "9".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=dname[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(dcheck1[x])) {
								if ("9".equals(bon1[y].substring(1, 2)) || "9".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=dname[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(dcheck[x])) {
								if ("9".equals(bon[y].substring(1, 2)) || "9".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 9) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=dname[y];}
							}
							if (y == Integer.parseInt(dcheck1[x])) {
								if ("9".equals(bon[y].substring(1, 2)) || "9".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 9) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=dname[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
								</table>
							</td>
							<td>
								<table>
									<tr>
										<td
											<%
			for (int x = 0; x < bon.length; x++) {
				if (bon[x] != null) {
					if ("E".equals(bon[x].substring(0, 1))) {
						echeck[x] = Integer.toString(x);
						ename[x]=name[x];
					}
				}
				if (bon1[x] != null) {
					if ("E".equals(bon1[x].substring(0, 1))) {
						echeck1[x] = Integer.toString(x);
						ename[x]=name[x];
					}
				}
			}

			%>>금</td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (echeck[x] == null) {
						echeck[x] = "100";
					}
					if (echeck1[x] == null) {
						echeck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(echeck[x])) {
								if ("1".equals(bon[y].substring(1, 2)) || "1".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=ename[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(echeck1[x])) {
								if ("1".equals(bon1[y].substring(1, 2)) || "1".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=ename[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(echeck[x])) {
								if ("1".equals(bon[y].substring(1, 2)) || "1".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 1) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=ename[y];}
							}
							if (y == Integer.parseInt(echeck1[x])) {
								if ("1".equals(bon[y].substring(1, 2)) || "1".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 1) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=ename[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (echeck[x] == null) {
						echeck[x] = "100";
					}
					if (echeck1[x] == null) {
						echeck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(echeck[x])) {
								if ("2".equals(bon[y].substring(1, 2)) || "2".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=ename[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(echeck1[x])) {
								if ("2".equals(bon1[y].substring(1, 2)) || "2".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=ename[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(echeck[x])) {
								if ("2".equals(bon[y].substring(1, 2)) || "2".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 2) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=ename[y];}
							}
							if (y == Integer.parseInt(echeck1[x])) {
								if ("2".equals(bon[y].substring(1, 2)) || "2".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 2) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=ename[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (echeck[x] == null) {
						echeck[x] = "100";
					}
					if (echeck1[x] == null) {
						echeck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(echeck[x])) {
								if ("3".equals(bon[y].substring(1, 2)) || "3".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=ename[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(echeck1[x])) {
								if ("3".equals(bon1[y].substring(1, 2)) || "3".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=ename[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(echeck[x])) {
								if ("3".equals(bon[y].substring(1, 2)) || "3".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 3) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=ename[y];}
							}
							if (y == Integer.parseInt(echeck1[x])) {
								if ("3".equals(bon[y].substring(1, 2)) || "3".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 3) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=ename[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (echeck[x] == null) {
						echeck[x] = "100";
					}
					if (echeck1[x] == null) {
						echeck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(echeck[x])) {
								if ("4".equals(bon[y].substring(1, 2)) || "4".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=ename[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(echeck1[x])) {
								if ("4".equals(bon1[y].substring(1, 2)) || "4".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=ename[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(echeck[x])) {
								if ("4".equals(bon[y].substring(1, 2)) || "4".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 4) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=ename[y];}
							}
							if (y == Integer.parseInt(echeck1[x])) {
								if ("4".equals(bon[y].substring(1, 2)) || "4".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 4) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=ename[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (echeck[x] == null) {
						echeck[x] = "100";
					}
					if (echeck1[x] == null) {
						echeck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(echeck[x])) {
								if ("5".equals(bon[y].substring(1, 2)) || "5".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=ename[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(echeck1[x])) {
								if ("5".equals(bon1[y].substring(1, 2)) || "5".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=ename[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(echeck[x])) {
								if ("5".equals(bon[y].substring(1, 2)) || "5".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 5) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=ename[y];}
							}
							if (y == Integer.parseInt(echeck1[x])) {
								if ("5".equals(bon[y].substring(1, 2)) || "5".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 5) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=ename[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (echeck[x] == null) {
						echeck[x] = "100";
					}
					if (echeck1[x] == null) {
						echeck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(echeck[x])) {
								if ("6".equals(bon[y].substring(1, 2)) || "6".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=ename[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(echeck1[x])) {
								if ("6".equals(bon1[y].substring(1, 2)) || "6".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=ename[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(echeck[x])) {
								if ("6".equals(bon[y].substring(1, 2)) || "6".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 6) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=ename[y];}
							}
							if (y == Integer.parseInt(echeck1[x])) {
								if ("6".equals(bon[y].substring(1, 2)) || "6".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 6) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=ename[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (echeck[x] == null) {
						echeck[x] = "100";
					}
					if (echeck1[x] == null) {
						echeck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(echeck[x])) {
								if ("7".equals(bon[y].substring(1, 2)) || "7".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=ename[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(echeck1[x])) {
								if ("7".equals(bon1[y].substring(1, 2)) || "7".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=ename[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(echeck[x])) {
								if ("7".equals(bon[y].substring(1, 2)) || "7".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 7) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=ename[y];}
							}
							if (y == Integer.parseInt(echeck1[x])) {
								if ("7".equals(bon[y].substring(1, 2)) || "7".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 7) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=ename[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (echeck[x] == null) {
						echeck[x] = "100";
					}
					if (echeck1[x] == null) {
						echeck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(echeck[x])) {
								if ("8".equals(bon[y].substring(1, 2)) || "8".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=ename[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(echeck1[x])) {
								if ("8".equals(bon1[y].substring(1, 2)) || "8".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=ename[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(echeck[x])) {
								if ("8".equals(bon[y].substring(1, 2)) || "8".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 8) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=ename[y];}
							}
							if (y == Integer.parseInt(echeck1[x])) {
								if ("8".equals(bon[y].substring(1, 2)) || "8".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 8) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=ename[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
									<tr>
										<td
											<%
												var = 0;
												nname = "";
											for (int x = 0; x < bon.length; x++) {
				for (int y = 0; y < bon.length; y++) {
					if (echeck[x] == null) {
						echeck[x] = "100";
					}
					if (echeck1[x] == null) {
						echeck1[x] = "100";
					}
					if (bon[y] != null) {
						if (bon[y].trim().length()==2 || bon1[y].trim().length()==2) {
							if (y == Integer.parseInt(echeck[x])) {
								if ("9".equals(bon[y].substring(1, 2)) || "9".equals(bon[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=ename[y];
								var=1;			
								}
							}
							if (y == Integer.parseInt(echeck1[x])) {
								if ("9".equals(bon1[y].substring(1, 2)) || "9".equals(bon1[y].substring(2, 3))
										) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=ename[y];
											var=1;}
							}
						} else if(var==0){
							if (y == Integer.parseInt(echeck[x])) {
								if ("9".equals(bon[y].substring(1, 2)) || "9".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 9) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=ename[y];}
							}
							if (y == Integer.parseInt(echeck1[x])) {
								if ("9".equals(bon[y].substring(1, 2)) || "9".equals(bon[y].substring(2, 3))
										|| (Integer.parseInt(bon[y].substring(1, 2)) + 1) == 9) {%>
											style="background-color: #2F5597; color: #fff;"
											<%nname=ename[y];}
							}
						}
					}
				}
			}%>><%=nname %></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="../include/footer.jsp"%>
</div>
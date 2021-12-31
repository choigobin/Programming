<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<html>
<head>
<meta charset="UTF-8">
<title>레이아웃</title>
</head>
<body>
<table width="100%" height="100%" border="0" cellpading="0" celspacing="0" align="center">
<jsp:include page="header.jsp" flush="false" />
<jsp:include page="nav.jsp" flush="false" />
<tr bgcolor="gray">
	<td valign="top">
	<p align="center"><span style="font-weight:bold; font-size:1.2em">
	성적조회 목록
</span></p>
<% 
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String url ="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	String user = "yangjung";
	String password = "1234";
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn = DriverManager.getConnection(url, user, password);
	request.setCharacterEncoding("utf-8");
	int x = 0;
	try{
		String sql="select count(*) from examtbl";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			int a = rs.getInt(1);
			x += a;
			}	
	} catch (SQLException e){
		out.println("테이블 호출 실패 : "+e.getMessage());
	}finally{
		if(rs !=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
		
	}
%>
<table border="1" width ="100%">
	<tr>
		<th>학년</th>
		<th>반</th>
		<th>번호</th>
		<th>성명</th>
		<th>국어</th>
		<th>영어</th>
		<th>수학</th>
		<th>역사</th>
		<th>총점</th>
		<th>평균</th>
	</tr>
<% 	
	conn = DriverManager.getConnection(url, user, password);

	int suma = 0;
	int sumb = 0;
	int sumc = 0;
	int sumd = 0;
	try{
		String sql="select * from examtbl order by sno";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			String sno = rs.getString(1);
			String sname = rs.getString(2);
			String kor = rs.getString(3);
			String eng = rs.getString(4);
			String math = rs.getString(5);
			String hist = rs.getString(6);
			String sn1=sno.substring(0,1);
			String sn2=sno.substring(1,3);
			String sn3=sno.substring(3,5);
			int a = Integer.parseInt(kor);
			int b = Integer.parseInt(eng);
			int c = Integer.parseInt(math);
			int d = Integer.parseInt(hist);
			int sum = a+b+c+d;
			double avg = Math.round(((a+b+c+d)*1000)/4)/1000.0;
			suma +=a; sumb +=b; sumc +=c; sumd +=d;
			%>
			<tr>
				<td align="center"><%=sn1%></td>
				<td align="center"><%=sn2%></td>
				<td align="center"><%=sn3%></td>
				<td align="center"><%=sname%></td>
				<td align="right"><%=kor%></td>
				<td align="right"><%=eng%></td>
				<td align="right"><%=math%></td>
				<td align="right"><%=hist%></td>
				<td align="right"><%=sum%></td>
				<td align="right"><%=avg%></td>
			</tr>
			<%
			}	
	} catch (SQLException e){
		out.println("테이블 호출 실패 : "+e.getMessage());
	}finally{
		if(rs !=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
		
	}
	double asum = Math.round(((suma+sumb+sumc+sumd)*1000)/4)/1000.0;
	double xsum = Math.round((((suma+sumb+sumc+sumd)*1000)/x)/4)/1000.0;
%>
<tr>
	<td></td><td></td><td></td>
	<th>총점</th>
	<td align="right"><%=suma%></td>
	<td align="right"><%=sumb%></td>
	<td align="right"><%=sumc%></td>
	<td align="right"><%=sumd%></td>
	<td align="right"><%=suma+sumb+sumc+sumd%></td>
	<td align="right"><%=asum%></td>
</tr>
<tr>
	<td></td><td></td><td></td>
	<th>총평균</th>
	<td align="right"><%=suma/x%></td>
	<td align="right"><%=sumb/x%></td>
	<td align="right"><%=sumc/x%></td>
	<td align="right"><%=sumd/x%></td>
	<td align="right"><%=(suma+sumb+sumc+sumd)/x%></td>
	<td align="right"><%=xsum%></td>
</table>
<jsp:include page="footer.jsp" flush="false" />
</table>
</body>
</html>
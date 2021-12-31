<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<p align="center"><span style="font-weight:bold; font-size:1.2em">
교과목 명세
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
	
	try{
		String sql="select count(*) from COURSE_TBL";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			String a = rs.getString(1);
			%>
			총 <%= a %>개의 교과목이 있습니다.
			<%
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
		<th>과목 ID</th>
		<th>과목명</th>
		<th>학점</th>
		<th>강사</th>
		<th>요일</th>
		<th>시작</th>
		<th>종료</th>
	</tr>
<% 	
		conn = DriverManager.getConnection(url, user, password);
	try{
		String sql="select id,a.name,credit,c.name,b.name,start_hour,end_end from COURSE_TBL a,week b, lecturer_tbl c where a.week=b.week and a.lecturer=c.idx order by id";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			String a = rs.getString(1);
			String b = rs.getString(2);
			String c = rs.getString(3);
			String d = rs.getString(4);
			String e = rs.getString(5);
			String f = rs.getString(6);
			String g = rs.getString(7);
			%>
			<tr>
				<td><%=a%></td>
				<td><%=b%></td>
				<td><%=c%></td>
				<td><%=d%></td>
				<td><%=e%></td>
				<td><%=f%></td>
				<td><%=g%></td>
			<%
			}	
	} catch (SQLException e){
		out.println("테이블 호출 실패 : "+e.getMessage());
	}finally{
		if(rs !=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(conn!=null) conn.close();
		
	}
%>
</table>
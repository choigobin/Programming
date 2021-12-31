<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%
Connection conn = null;
PreparedStatement pstmt = null;

String user = "yangjung";
String password = "1234";
String url ="jdbc:oracle:thin:@127.0.0.1:1521:orcl";

String id = request.getParameter("id");
String name = request.getParameter("name");
String price = request.getParameter("price");
String description = request.getParameter("description");
String manufacturer = request.getParameter("manufacturer");
String category = request.getParameter("category");
String instock = request.getParameter("instock");
String condition = request.getParameter("condition");

Class.forName("oracle.jdbc.driver.OracleDriver");
conn = DriverManager.getConnection(url, user, password);
request.setCharacterEncoding("utf-8");

try{
	String sql ="insert into productTbl values(?,?,?,?,?,?,?,?)";
	pstmt=conn.prepareStatement(sql);
	pstmt.setString(1, id);
	pstmt.setString(2, name);
	pstmt.setString(3, price);
	pstmt.setString(4, description);
	pstmt.setString(5, category);
	pstmt.setString(6, manufacturer);
	pstmt.setString(7, instock);
	pstmt.setString(8, condition);
	pstmt.executeUpdate();
	out.println("<script>location.href='insert_product.jsp'; alert('상품 정보등록이 완료 되었습니다.');</script>");
	
}catch(Exception e){
	out.print(e.getMessage()+"데이터 입력 실패");
}finally{
	if(pstmt!=null) pstmt.close();
	if(conn!=null) conn.close();
}
%>
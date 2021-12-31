package member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.ListMembers(); //listMembers(): 회원 정보를 조회하는 메소드
		
		out.print("<html><body>");
		out.print("<table border=1><tr>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td></tr>");
		
		for(int i=0; i<list.size();i++) {
			MemberVO mem = list.get(i);
			
			String id = mem.getId();
			String pwd = mem.getPwd();
			String name = mem.getName();
			String email = mem.getEmail();
			Date joinDate = mem.getJoinDate();
			
			out.print("<tr>");
			out.print("<td>"+id+"</td>"+"<td>"+pwd+"</td>"+"<td>"+name+"</td>"+"<td>"+email+"</td>"+"<td>"+joinDate+"</td>");
			out.print("</tr>");
		}
		
		out.print("</table></body></html>");
		
		
		
	}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}

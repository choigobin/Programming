package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import KISA.SHA256;
import model.*;
import sun.misc.BASE64Encoder;

/**
 * Servlet implementation class MemberInsertServlet
 */
@WebServlet("/Insert")
public class MemberInsertServletPro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertServletPro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		MemberVO vo = new MemberVO();
		MemberDAO dao = MemberDAO.getInstance();
		
		
		vo.setName(request.getParameter("name"));
		vo.setUserid(request.getParameter("userid"));
		String passwd = request.getParameter("passwd");
		SHA256 s = new SHA256(passwd.getBytes());
		BASE64Encoder Base64Encoder = new BASE64Encoder();
		vo.setPasswd(Base64Encoder.encode(s.GetHashCode()));
		vo.setTel(request.getParameter("tel"));
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		boolean flag = dao.memberInsert(vo);
		if(flag) {
			out.println("<script>");
			out.println("alert('등록 성공');");
			out.println("location.href='/ServletMember/ListServlet';");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('등록 실패');");
			out.println("history.back();");
			out.println("</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

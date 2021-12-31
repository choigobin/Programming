package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDao;
import model.MemberVO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		MemberVO vo = new MemberVO();
		MemberDao dao = new MemberDao();
		String userid = request.getParameter("id");
		String userpw = request.getParameter("pw");
		vo = dao.selectMember(userid, userpw);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(vo.getUserid()==null) {
			out.println("<script>alert('로그인에 실패했습니다'); location.href='/member/login.jsp';</script>");
			out.flush();
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("user", vo);
			out.println("<script>alert('로그인에 성공했습니다'); location.href='/index.jsp';</script>");
			out.flush();
		}
	}

}

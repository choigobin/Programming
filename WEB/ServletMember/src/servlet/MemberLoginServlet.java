package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import model.MemberDAO;

/**
 * Servlet implementation class MemberInsertServlet
 */
@WebServlet("/MemberLoginServlet")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("Member/userlogin_form.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		MemberDAO dao = MemberDAO.getInstance();
		int row = dao.memberLogin(userid, passwd);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		if(row==-1) {
			out.println("<script>");
			out.println("alert('아이디가 존재하지않습니다');");
			out.println("history.back();");
			out.println("</script>");
		}else if(row==0) {
			out.println("<script>");
			out.println("alert('비밀번호가 맞지않습니다');");
			out.println("history.back();");
			out.println("</script>");
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("userid", userid);
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("Member/userlogin_ok.jsp");
			dispatcher.forward(request, response);
		}
	}

}

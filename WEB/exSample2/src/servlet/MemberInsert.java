package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDao;
import model.MemberVO;

/**
 * Servlet implementation class MemberInsert
 */
@WebServlet("/MemberInsert.do")
public class MemberInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsert() {
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
		vo.setUserid(request.getParameter("id"));
		vo.setUserpw(request.getParameter("pass1"));
		vo.setName(request.getParameter("name"));
		vo.setPhone(request.getParameter("phone"));
		vo.setEmail(request.getParameter("email1")+"@"+request.getParameter("email2"));
		MemberDao dao = new MemberDao();
		int result = dao.insertMember(vo);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(result==0) {
			out.println("<script>alert('계정등록에 실패했습니다'); location.href='/index.jsp';</script>");
			out.flush();
		}else {
			out.println("<script>alert('계정이 등록 되었습니다'); location.href='/member/login.jsp';</script>");
			out.flush();
		}
	}

}

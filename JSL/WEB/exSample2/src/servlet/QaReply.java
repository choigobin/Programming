package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.QaDao;
import model.QaVO;

/**
 * Servlet implementation class NoticeInsert
 */
@WebServlet("/QaReply.do")
public class QaReply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QaReply() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		QaVO vo = new QaVO();
		vo.setNo(Integer.parseInt(request.getParameter("no")));
		vo.setReply(request.getParameter("reply"));
		QaDao dao = new QaDao();
		int result = dao.replyQa(vo);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(result==0) {
			out.println("<script>alert('답변 등록에 실패했습니다'); location.href='/qa/qa.jsp';</script>");
			out.flush();
		}else {
			out.println("<script>alert('답변이 등록 되었습니다'); location.href='/qa/qa.jsp';</script>");
			out.flush();
		}
		
	}

}

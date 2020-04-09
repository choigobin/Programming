package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NoticeDao;
import model.NoticeVO;

/**
 * Servlet implementation class NoticeInsert
 */
@WebServlet("/NoticeUpdate.do")
public class NoticeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdate() {
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
		NoticeVO vo = new NoticeVO();
		vo.setNo(Integer.parseInt(request.getParameter("no")));
		vo.setTitle(request.getParameter("title"));
		vo.setContents(request.getParameter("contents"));
		NoticeDao dao = new NoticeDao();
		int result = dao.updateNotice(vo);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(result==0) {
			out.println("<script>alert('공지사항 수정에 실패했습니다'); location.href='/notice/notice.jsp';</script>");
			out.flush();
		}else {
			out.println("<script>alert('공지사항이 수정 되었습니다'); location.href='/notice/notice.jsp';</script>");
			out.flush();
		}
		
	}

}

package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PortfolioDao;
import model.PortfolioVO;

/**
 * Servlet implementation class NoticeInsert
 */
@WebServlet("/PortfolioUpdate.do")
public class PortfolioUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PortfolioUpdate() {
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
		PortfolioVO vo = new PortfolioVO();
		vo.setNo(Integer.parseInt(request.getParameter("no")));
		vo.setTitle(request.getParameter("title"));
		vo.setContents(request.getParameter("contents"));
		PortfolioDao dao = new PortfolioDao();
		int result = dao.updatePortfolio(vo);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(result==0) {
			out.println("<script>alert('포트폴리오 수정에 실패했습니다'); location.href='/portfolio/portfolio.jsp';</script>");
			out.flush();
		}else {
			out.println("<script>alert('포트폴리오가 수정 되었습니다'); location.href='/portfolio/portfolio.jsp';</script>");
			out.flush();
		}
		
	}

}

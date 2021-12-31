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
 * Servlet implementation class PortfolioInsert
 */
@WebServlet("/PortfolioInsert.do")
public class PortfolioInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PortfolioInsert() {
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
		PortfolioVO vo = new PortfolioVO();
		vo.setTitle(request.getParameter("title"));
		vo.setContents(request.getParameter("contents"));
		PortfolioDao dao = new PortfolioDao();
		int result = dao.insertPortfolio(vo);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(result==0) {
			out.println("<script>alert('포트폴리오 작성에 실패했습니다'); location.href='/portfolio/portfolio.jsp';</script>");
			out.flush();
		}else {
			out.println("<script>alert('포트폴리오가 등록 되었습니다'); location.href='/portfolio/portfolio.jsp';</script>");
			out.flush();
		}
		
	}

}

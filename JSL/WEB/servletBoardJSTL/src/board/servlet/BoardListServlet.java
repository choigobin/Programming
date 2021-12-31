package board.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import board.model.BoardVO;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/board_list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//BoardDAO dao = BoardDAO.getInstance();
		BoardDAO dao = new BoardDAO();
		int cnt = dao.boardCount();
		List<BoardVO> list = dao.boardList();
		
		request.setAttribute("total", cnt);
		request.setAttribute("list", list);
		
		RequestDispatcher dispater = 
				request.getRequestDispatcher("Board/board_list.jsp");
		dispater.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		BoardDAO dao = new BoardDAO();
		String type = request.getParameter("type");
		String key = "";
		if(request.getParameter("key")!=null) {
			key = request.getParameter("key");
		}
		List<BoardVO> list = dao.searchList(type, key);
		int cnt = dao.boardCount(type, key);
		request.setAttribute("total", cnt);
		request.setAttribute("list", list);
		request.setAttribute("tpye", type);
		request.setAttribute("key", key);
		
		
		RequestDispatcher dispater = 
				request.getRequestDispatcher("Board/board_list.jsp");
		dispater.forward(request, response);
		
	}

}

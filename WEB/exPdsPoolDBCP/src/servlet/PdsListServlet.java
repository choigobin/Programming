package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PdsDAO;
import model.PdsVO;
import util.DBConn;

/**
 * Servlet implementation class PdsListServlet
 */
@WebServlet("/Pds_list")
public class PdsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PdsListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		try {
			conn = DBConn.getConnection();
			PdsDAO dao = PdsDAO.getInstance();
			String type="1";
			String key = "1";
			int page = 1;
			if(request.getParameter("type") != null) {
				type = request.getParameter("type");
			}
			if(request.getParameter("key") != null) {
				key = request.getParameter("key");
			}
			if(request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
			}
			List<PdsVO> list = dao.pdsList(conn,type,key,page);
			request.setAttribute("list", list);
			request.setAttribute("total", dao.pdsCount(conn,type,key));
			RequestDispatcher dispatcher = request.getRequestDispatcher("Pds/pds_list.jsp");
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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

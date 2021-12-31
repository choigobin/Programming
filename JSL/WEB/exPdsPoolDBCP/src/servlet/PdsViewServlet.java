package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import model.PdsDAO;
import model.PdsVO;
import util.DBConn;

/**
 * Servlet implementation class PdsListServlet
 */
@WebServlet("/Pds_view")
public class PdsViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PdsViewServlet() {
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
			int idx = Integer.parseInt(request.getParameter("idx"));
			String str = "pds_view"+idx;
			Cookie[] cookies = request.getCookies();
			boolean bool = true;
			for(Cookie ck : cookies) {
				if(ck.getName().equals(str)) {
					bool=false;
					break;
				}
			}
			if(bool) {
				Cookie info = new Cookie(str, ""+System.currentTimeMillis());
				info.setMaxAge(600);
				response.addCookie(info);
				dao.readCnt(conn,idx);
			}
			PdsVO vo = dao.pdsSelect(conn,idx);
			request.setAttribute("vo",vo);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Pds/pds_view.jsp");
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

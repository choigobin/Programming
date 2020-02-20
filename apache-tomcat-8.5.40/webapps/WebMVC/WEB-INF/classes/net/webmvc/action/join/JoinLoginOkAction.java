package net.webmvc.action.join;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.webmvc.action.Action;
import net.webmvc.dao.JoinDAO;
import net.webmvc.util.DBConn;
import net.webmvc.util.DBUtil;

public class JoinLoginOkAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;

		String url = "Admin/login_ok.jsp";
		String id = request.getParameter("adid");
		String pass = request.getParameter("adpass");
		
		JoinDAO DAO = JoinDAO.getInstance();
		try {
			conn = DBConn.getConnection();
			int row = DAO.login(conn, id, pass);
			if (row == 1) {
				HttpSession session = request.getSession();
				session.setAttribute("User", id);
			}
			request.setAttribute("row", row);			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}

	}

}

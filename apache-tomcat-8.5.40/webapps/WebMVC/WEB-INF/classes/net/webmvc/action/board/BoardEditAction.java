package net.webmvc.action.board;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.webmvc.action.Action;
import net.webmvc.dao.BoardDAO;
import net.webmvc.dto.BoardVO;
import net.webmvc.util.DBConn;
import net.webmvc.util.DBUtil;


public class BoardEditAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		int nowpage = Integer.parseInt(request.getParameter("page"));
		BoardDAO dao = BoardDAO.getInstance();
		
		Connection conn=null;
		try {
			conn = DBConn.getConnection();
			BoardVO vo = dao.boardSelect(conn,idx);
			request.setAttribute("vo", vo);
			request.setAttribute("page", nowpage);
			RequestDispatcher dispater = request.getRequestDispatcher("Board/board_edit.jsp");
			dispater.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}


	}

}

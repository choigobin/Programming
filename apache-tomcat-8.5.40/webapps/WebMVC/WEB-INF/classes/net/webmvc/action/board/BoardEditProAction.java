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

public class BoardEditProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int idx=Integer.parseInt(request.getParameter("idx"));
		int nowpage=Integer.parseInt(request.getParameter("page"));
		String name=request.getParameter("name");
		String subject=request.getParameter("subject");
		String contents=request.getParameter("contents");
		String pass=request.getParameter("pass");
		String email=request.getParameter("email");
		
		BoardVO vo = new BoardVO();
		vo.setIdx(idx);
		vo.setName(name);
		vo.setSubject(subject);
		vo.setContents(contents);
		vo.setEmail(email);
		vo.setPass(pass);
		
		BoardDAO dao = BoardDAO.getInstance();
		Connection conn = null;
		try {
			conn = DBConn.getConnection();
			int row = dao.boardEdit(conn,vo);
			request.setAttribute("row", row);
			request.setAttribute("page", nowpage);
			RequestDispatcher dispater = request.getRequestDispatcher("Board/board_edit_pro.jsp");
			dispater.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
	}

}

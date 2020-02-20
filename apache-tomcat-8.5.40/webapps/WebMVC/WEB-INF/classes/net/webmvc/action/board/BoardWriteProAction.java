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


public class BoardWriteProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		String subject=request.getParameter("subject");
		String contents=request.getParameter("contents");
		String pass=request.getParameter("pass");
		String email=request.getParameter("email");
		int nowpage = 1;
		if(request.getParameter("page") != null && !request.getParameter("page").equals("")) {
			nowpage=Integer.parseInt(request.getParameter("page")); 
		}
		
		BoardVO vo = new BoardVO();
		vo.setName(name);
		vo.setSubject(subject);
		vo.setContents(contents);
		vo.setEmail(email);
		vo.setPass(pass);
		BoardDAO dao = BoardDAO.getInstance();
		Connection conn = null;
		try {
			conn = DBConn.getConnection();
			int row = dao.boardInsert(conn,vo);
			request.setAttribute("page", nowpage);
			request.setAttribute("row", row);
			RequestDispatcher dispater = request.getRequestDispatcher("/Board/board_write_pro.jsp");
			dispater.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}

	}

}

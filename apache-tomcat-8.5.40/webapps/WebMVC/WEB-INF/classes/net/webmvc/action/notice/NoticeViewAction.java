package net.webmvc.action.notice;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.webmvc.action.Action;
import net.webmvc.dao.NoticeDAO;
import net.webmvc.dto.NoticeVO;
import net.webmvc.util.DBConn;
import net.webmvc.util.DBUtil;
import net.webmvc.util.SqlMark;

public class NoticeViewAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		int nowpage = Integer.parseInt(request.getParameter("page"));
		NoticeDAO dao = NoticeDAO.getInstance();
		Connection conn=null;
		try {
			conn = DBConn.getConnection();
			NoticeVO vo = dao.noticeSelect(conn,idx);
			
			request.setAttribute("vo", vo);
			request.setAttribute("nowpage", nowpage);
			request.setAttribute("contents", SqlMark.lineBreak(vo.getContents()));
			RequestDispatcher dispater = request.getRequestDispatcher("Notice/notice_view.jsp");
			dispater.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
	}
}

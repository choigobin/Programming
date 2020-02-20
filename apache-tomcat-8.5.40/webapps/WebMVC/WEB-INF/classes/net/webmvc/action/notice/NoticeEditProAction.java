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

public class NoticeEditProAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int idx=Integer.parseInt(request.getParameter("idx"));
		int nowpage=Integer.parseInt(request.getParameter("page"));
		String subject=request.getParameter("subject");
		String contents=request.getParameter("contents");
		
		NoticeVO vo = new NoticeVO();
		vo.setIdx(idx);
		vo.setSubject(subject);
		vo.setContents(contents);
		
		NoticeDAO dao = NoticeDAO.getInstance();
		Connection conn = null;
		try {
			conn = DBConn.getConnection();
			int row = dao.noticeEdit(conn,vo);
			request.setAttribute("row", row);
			request.setAttribute("page", nowpage);
			RequestDispatcher dispater = request.getRequestDispatcher("Notice/notice_edit_pro.jsp");
			dispater.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
	}
}

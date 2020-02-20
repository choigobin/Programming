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

public class NoticeWriterProAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String subject=request.getParameter("subject");
		String contents=request.getParameter("contents");
		int nowpage = 1;
		if(request.getParameter("page") != null && !request.getParameter("page").equals("")) {
			nowpage=Integer.parseInt(request.getParameter("page")); 
		}
		
		NoticeVO vo = new NoticeVO();
		vo.setSubject(subject);
		vo.setContents(contents);
		NoticeDAO dao = NoticeDAO.getInstance();
		Connection conn = null;
		try {
			conn = DBConn.getConnection();
			int row = dao.noticeInsert(conn,vo);
			request.setAttribute("page", nowpage);
			request.setAttribute("row", row);
			RequestDispatcher dispater = request.getRequestDispatcher("/Notice/notice_write_pro.jsp");
			dispater.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
	}
}

package net.webmvc.action.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.webmvc.action.Action;

public class NoticeWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nowpage=request.getParameter("page");
		request.setAttribute("nowpage", nowpage);
		RequestDispatcher dispater = request.getRequestDispatcher("Notice/notice_write.jsp");
		dispater.forward(request, response);
	}

}

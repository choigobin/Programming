package net.webmvc.action.pds;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.webmvc.action.Action;

public class PdsWriteAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nowpage=request.getParameter("page");
		request.setAttribute("page", nowpage);
		RequestDispatcher dispater = request.getRequestDispatcher("Pds/pds_write.jsp");
		dispater.forward(request, response);
		
	}

}

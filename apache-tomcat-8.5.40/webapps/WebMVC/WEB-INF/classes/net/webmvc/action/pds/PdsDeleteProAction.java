package net.webmvc.action.pds;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.webmvc.action.Action;
import net.webmvc.dao.PdsDAO;
import net.webmvc.util.DBConn;
import net.webmvc.util.DBUtil;

public class PdsDeleteProAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		int nowpage = Integer.parseInt(request.getParameter("page"));
		String pass = request.getParameter("pass");
		
		//String saveDir = request.getRealPath("/") + "Pds/upload/";
		String saveDir=request.getContextPath()+"/Pds/upload";
		
		PdsDAO dao = PdsDAO.getInstance();
		Connection conn=null;
		try {
			conn = DBConn.getConnection();
			int row = dao.pdsDelete(conn,idx, pass, saveDir);
			request.setAttribute("row", row);
			request.setAttribute("page", nowpage);
			RequestDispatcher dispater = request.getRequestDispatcher("Pds/pds_delete_pro.jsp");
			dispater.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
	}
}

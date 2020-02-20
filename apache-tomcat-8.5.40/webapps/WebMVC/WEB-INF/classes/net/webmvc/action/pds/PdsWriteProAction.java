package net.webmvc.action.pds;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import net.webmvc.action.Action;
import net.webmvc.dao.PdsDAO;
import net.webmvc.dto.PdsVO;
import net.webmvc.util.DBConn;
import net.webmvc.util.DBUtil;

public class PdsWriteProAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("Pds/upload");
		String encType = "UTF-8";
		int sizeLimit = 2 * 1024 * 1024;// 2MB
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit,
				encType, new DefaultFileRenamePolicy());
		//new DefaultFileRenamePolicy()(a.bm -> a1.bmp)
		String name = multi.getParameter("name");
		String email = multi.getParameter("email");
		String pass = multi.getParameter("pass");
		String subject = multi.getParameter("subject");
		String contents = multi.getParameter("contents");
		String filename = multi.getFilesystemName("filename");
		int nowpage = 1;
		if(request.getParameter("page") != null && !request.getParameter("page").equals("")) {
			nowpage=Integer.parseInt(request.getParameter("page")); 
		}

		PdsVO vo = new PdsVO();
		vo.setName(name);
		vo.setPass(email);
		vo.setPass(pass);
		vo.setSubject(subject);
		vo.setContents(contents);
		vo.setFilename(filename);

		PdsDAO dao = PdsDAO.getInstance();
		Connection conn = null;
		try {
			conn = DBConn.getConnection();
			int row = dao.pdsWrite(conn,vo);
			request.setAttribute("page", nowpage);
			request.setAttribute("row", row);
			RequestDispatcher dispater = request.getRequestDispatcher("/Pds/pds_write_pro.jsp");
			dispater.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
	}
}

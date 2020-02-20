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

public class PdsEditProAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("Pds/upload");
		String encType = "UTF-8";
		int sizeLimit = 2 * 1024 * 1024;// 2MB
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit,
				encType, new DefaultFileRenamePolicy());
		//new DefaultFileRenamePolicy()(a.bm -> a1.bmp)
		
		int idx=Integer.parseInt(multi.getParameter("idx"));
		int nowpage=Integer.parseInt(multi.getParameter("page"));
		String oldfile=multi.getParameter("oldfile");
		String name = multi.getParameter("name");
		String email = multi.getParameter("email");
		String pass = multi.getParameter("pass");
		String subject = multi.getParameter("subject");
		String contents = multi.getParameter("contents");
		String filename = multi.getFilesystemName("filename");

		PdsVO vo = new PdsVO();
		vo.setIdx(idx);
		vo.setName(name);
		vo.setPass(email);
		vo.setPass(pass);
		vo.setSubject(subject);
		vo.setContents(contents);
		// 첨부파일이 없을 경우 예정 파일 유지
		if(filename.equals("")) {
			vo.setFilename(oldfile);
		}else {
			vo.setFilename(filename);
		}
		
		PdsDAO dao = PdsDAO.getInstance();
		Connection conn = null;
		try {
			conn = DBConn.getConnection();
			int row = dao.pdsEdit(conn,vo);
			request.setAttribute("row", row);
			request.setAttribute("page", nowpage);
			RequestDispatcher dispater = request.getRequestDispatcher("Pds/pds_edit_pro.jsp");
			dispater.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
	}
}

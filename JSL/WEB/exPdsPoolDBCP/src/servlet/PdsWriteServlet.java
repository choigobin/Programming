package servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.PdsDAO;
import model.PdsVO;
import util.DBConn;

/**
 * Servlet implementation class PdsWriteServlet
 */
@WebServlet("/pds_write")
public class PdsWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PdsWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Pds/pds_write.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		try {
			conn = DBConn.getConnection();
			request.setCharacterEncoding("utf-8");
			
			ServletContext context = getServletContext();
			String path = context.getRealPath("upload");
			String encType ="UTF-8";
			int maxSize=2*1024*1024;
			MultipartRequest multi = 
					new MultipartRequest(request,path,maxSize,encType,new DefaultFileRenamePolicy());
			String name=multi.getParameter("name");
			String pass=multi.getParameter("pass");
			String email=multi.getParameter("email");
			String subject=multi.getParameter("subject");
			String contents=multi.getParameter("contents");
			String filename = multi.getFilesystemName("filename");
			
			PdsVO vo = new PdsVO();
			vo.setName(name);
			vo.setPass(pass);
			vo.setEmail(email);
			vo.setSubject(subject);
			vo.setContents(contents);
			vo.setFilename(filename);
			
			PdsDAO dao = PdsDAO.getInstance();
			int row = dao.pdsWrite(conn,vo);
			
			request.setAttribute("row", row);
			response.sendRedirect("Pds_list");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}

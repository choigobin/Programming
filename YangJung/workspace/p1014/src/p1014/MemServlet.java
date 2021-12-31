package p1014;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemServlet
 */
@WebServlet("/MemServlet")
public class MemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String birth = request.getParameter("birth");
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		VO vo =new VO();
		vo.setId(Integer.parseInt(request.getParameter("id")));
		vo.setPassword(request.getParameter("password"));
		vo.setName(request.getParameter("name"));
		vo.setGender(request.getParameter("gender"));
		try {
			vo.setBirth(transFormat.parse(birth));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		vo.setMail(request.getParameter("email1")+request.getParameter("email2"));
		vo.setPhone(request.getParameter("tel1")+"-"+request.getParameter("tel2")+"-"+request.getParameter("tel3"));
		vo.setAddress(request.getParameter("address"));
		vo.setNickname(request.getParameter("nick"));
		DAO dao = new DAO();
		dao.insert(vo);
		response.sendRedirect("insert_member.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

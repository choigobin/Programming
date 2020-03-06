package servlet.guest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.guest.*;
import java.util.*;
/**
 * Servlet implementation class GusetList
 */
@WebServlet("/GusetList")
public class GusetList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GusetList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page= 1;
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		GuestDAO dao = GuestDAO.getInstance();
		int total = dao.countGuest();
		int tpage = (int)(total+9)/10;
		if(page>tpage) {
			page=tpage;
		}
		if(page<1) {
			page=1;
		}
		List<GuestVO> list = dao.selectGuest(page);
		request.setAttribute("page", page);
		request.setAttribute("total", total);
		request.setAttribute("tpage", tpage);
		request.setAttribute("list", list);
		RequestDispatcher dispatch = request.getRequestDispatcher("Guest/guest_list.jsp");
		dispatch.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

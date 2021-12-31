package exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test_01
 */
@WebServlet("/Test_01")
public class Test_01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test_01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String job = request.getParameter("job");
		String[] interest = request.getParameterValues("interest");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.println("당신이 선택한 직업 : ");
		out.print(job);
		out.println("<hr>당신이 선택한 관심 분야 : ");
		if(interest == null) {
			out.print("선택한 항목이 없습니다.");
		}else {
			for(String x : interest) {
				out.println(x);
			}
		}
		out.println("<br><a href='javascript:history.go(-1)'>다시</a>");
		out.print("</body></html>");
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String job = request.getParameter("job");
		String[] interest = request.getParameterValues("interest");
		String inter ="";
		for(String x : interest) {
			inter += " "+x;
		}
		request.setAttribute("job", job);
		request.setAttribute("inter", inter);
		request.setAttribute("name", request.getParameter("name"));
		request.setAttribute("pass", request.getParameter("pass1")+"-"+request.getParameter("pass2"));
		RequestDispatcher rd = request.getRequestDispatcher("select_pro.jsp");
		rd.forward(request, response);
	}

}

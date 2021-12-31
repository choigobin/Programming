package p1008;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gugu")
public class guguTest extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int dan = Integer.parseInt(request.getParameter("dan"));
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>로그인</title></head><body>");
		out.println("<table border='1' width='70%'><tr><td colspan='2' bgcolor='yellow' align='center'>"+dan+" 단 출력</td></tr>");
		for(int i=1; i<10;i++) {
			out.println("<tr>");
			out.println("<td align='center'>");
			out.println(dan+"*"+i);
			out.println("</td>");
			out.println("<td align='center'>");
			out.println(dan*i);
			out.println("</td>");
			out.println("</tr>");
			}
		out.println("</table></body></html>");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

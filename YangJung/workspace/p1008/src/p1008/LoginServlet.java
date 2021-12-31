package p1008;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public void init() throws ServletException {
		System.out.println("init 메서드 호출");
	}
   
    public LoginServlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		System.out.println("아이디 : "+user_id);
		System.out.println("비밀번호 : "+user_pw);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(user_id.equals("admin")) {
			out.println("<html>");
			out.println("<head><title>로그인</title></head>");
			out.println("<body><h2>관리자로 로그인 하셨습니다.</h2>");
			out.println("<input type='button' value='회원정보 수정하기'>");
			out.println("<input type='button' value='회원정보 삭제하기'>");
			out.println("</body></html>");
			
		}
		else {
			out.println("<html>");
			out.println("<head><title>로그인</title></head>");
			out.println("<body><h2>"+user_id+" 님!! 로그인 하셨습니다.</h2>");
			out.println("</body></html>");
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}
}

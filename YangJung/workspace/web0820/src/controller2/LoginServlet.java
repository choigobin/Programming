package controller2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member2.MeberDAO;
import member2.MemberVO;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get 방식  호출");
		// 한글 인코딩 처리
		//request.setCharacterEncoding("utf-8");
		//response.setContentType("text/html;charset=utf-8");
		// 웹브라우저에 출력
		//PrintWriter out = response.getWriter();
		//out.print("get방식 호출");
		
		RequestDispatcher rd = request.getRequestDispatcher("member/login.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post 방식  호출");
		//login.jsp 에서 넘어온 값처리 
		
		String url="member/login.jsp";
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		
		//사용자 인증 과정 처리
		//MeberDAO dao = new MeberDAO();
		//int result = dao.userCheck(userid,pwd);
		int result = 0;
		
		if (result ==1) {//정상적으로 로그인
			//db에 회원 정보 추출하여 객체에 보관
			//MemberVO vo = dao.getMember(userid);
			
			//HttpSession session = request.getSession();
			//session.setAttribute("loginUser", vo);
			request.setAttribute("message", "회원 가입에 성공했습니다.");
			
			//회원 전용 페이지로 이동
			url = "main.jsp";
		}else if(result ==0) {//비밀번호 불일치
			request.setAttribute("message", "비밀번호가 맞지 않습니다.");
		}else if (result==-1) {//비회원
			request.setAttribute("message", "회원이 아닙니니다.");
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}

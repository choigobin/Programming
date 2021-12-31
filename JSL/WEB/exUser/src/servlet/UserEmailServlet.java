package servlet;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserEmailServlet
 */
@WebServlet("/user_email")
public class UserEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserEmailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("User/user_email_check.jsp");
		dispatcher.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String host = "smtp.gmail.com";
		final String username = "javakara12"; //네이버 아이디를 입력해주세요. @nave.com은 입력하지 마시구요. 
		final String password = "비밀번호"; //네이버 이메일 비밀번호를 입력해주세요. 
		int port=465; //포트번호 // 메일 내용 
		String recipient = request.getParameter("email"); //받는 사람의 메일주소를 입력해주세요. 
		String subject = "회원가입 인증"; //메일 제목 입력해주세요. 
		int emps = (int)(Math.random()*90000+10000);
		request.setAttribute("email", recipient);
		request.setAttribute("email2", recipient.split("@")[1]);
		request.setAttribute("emps", emps);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("User/user_email_check.jsp");
		dispatcher.forward(request, response);
		
		String body = ""+emps; //메일 내용 입력해주세요. 
		Properties props = System.getProperties(); // 정보를 담기 위한 객체 생성 // SMTP 서버 정보 설정 
		props.put("mail.smtp.host", host); 
		props.put("mail.smtp.port", port); 
		props.put("mail.smtp.auth", "true"); 
		props.put("mail.smtp.ssl.enable", "true"); 
		props.put("mail.smtp.ssl.trust", host); 
		//Session 생성 
		Session session = Session.getInstance(props, new javax.mail.Authenticator() { 
			String un=username; 
			String pw=password; 
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() { 
				return new javax.mail.PasswordAuthentication(un, pw); 
				} 
			}); 
		session.setDebug(true); //for debug 
		Message mimeMessage = new MimeMessage(session); //MimeMessage 생성
		try {
			mimeMessage.setFrom(new InternetAddress("javakara12@gmail.com"));
			mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); //수신자셋팅 //.TO 외에 .CC(참조) .BCC(숨은참조) 도 있음
			mimeMessage.setSubject(subject); //제목셋팅
			mimeMessage.setText(body); //내용셋팅 
			Transport.send(mimeMessage); //javax.mail.Transport.send() 이용
			System.out.println("전송완료");
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //발신자 셋팅 , 보내는 사람의 이메일주소를 한번 더 입력합니다. 이때는 이메일 풀 주소를 다 작성해주세요. 
		
	}

}

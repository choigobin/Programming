package servlet;
 
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
 
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
 
/**
 * Servlet implementation class test
 */
@WebServlet("/test")
public class test extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
        super();
        // TODO Auto-generated constructor stub
    }
 
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
    
        //이름 기반으로 (WAS 안에서)
        Context context;
        try {
            context = new InitialContext();
            //ClassforName.() 처럼 '이름'으로 object retrieve 해주는 함수 lookup()
            DataSource dbcp = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
          
            //POOL 안에서 연결 객체를 하나 얻어내는 코드 
            conn = dbcp.getConnection();
            System.out.println("연결성공");
        } catch (NamingException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }
 
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
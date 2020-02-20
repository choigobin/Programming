package net.webmvc.action.board;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.webmvc.action.Action;
import net.webmvc.dao.BoardDAO;
import net.webmvc.dto.BoardVO;
import net.webmvc.util.DBConn;
import net.webmvc.util.DBUtil;
import net.webmvc.util.PageIndex;

public class BoardListAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		try {
			conn = DBConn.getConnection();
			BoardDAO dao = BoardDAO.getInstance();
		
			String url="BoardServlet?cmd=board_list";
			String addtag="",s_query="",search="", key="", h_key="";
			if(request.getParameter("key") != null && !request.getParameter("key").equals("")) {
				search = request.getParameter("search");
				key = request.getParameter("key");
				s_query=search + " like '%" + key + "%'";
				addtag= "&search="+search + "&key=" + key;
			}
			int nowpage=1;
			int maxlist=10;	// 페이지당 글 수
			int totpage=1;
		
			int totcount = 0;
			if(key.equals("")){
				totcount = dao.boardCount(conn);// 총 글 수
			}else {
				totcount= dao.boardCount(conn,s_query);// 총 글 수
			}
			// 총 페이지수 계산
			if(totcount % maxlist == 0) {
				totpage=totcount/maxlist;
			}else {
				totpage=totcount/maxlist+1;
			}
		
			if(totpage==0) totpage=1;
		
			if(request.getParameter("page") != null && 
					!request.getParameter("page").equals("")) {
				nowpage=Integer.parseInt(request.getParameter("page"));
			}
		
			if(nowpage>totpage) {
				nowpage=totpage;
			}
		
			int pagestart=(nowpage-1)*maxlist;	//페이지 시작번호(예 0, 10)
			int endpage=nowpage*maxlist;	//페이지 끝(10, 20)
		
			int listcount = totcount-((nowpage-1)*maxlist);
		
			List<BoardVO> list = null;
			if(key.equals("")) {
				list= dao.boardList(conn,pagestart,endpage);
			}else {
				list= dao.boardList(conn,s_query,pagestart,endpage);
			}
			request.setAttribute("totcount", totcount);
			request.setAttribute("addtag", addtag);
			request.setAttribute("url", url);
			request.setAttribute("page", nowpage);
			request.setAttribute("totpage", totpage);
			request.setAttribute("listcount", listcount);
			request.setAttribute("list", list);
			// 페이지 스킵 처리
			String pageSkip = PageIndex.pageList(nowpage, totpage, url, addtag);
			request.setAttribute("pageSkip", pageSkip);	
		
			RequestDispatcher dispater = request.getRequestDispatcher("Board/board_list.jsp");
			dispater.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
	}

}

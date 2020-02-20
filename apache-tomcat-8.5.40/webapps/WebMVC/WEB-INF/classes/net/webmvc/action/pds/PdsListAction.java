package net.webmvc.action.pds;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.webmvc.action.Action;
import net.webmvc.dao.PdsDAO;
import net.webmvc.dto.PdsVO;
import net.webmvc.util.DBConn;
import net.webmvc.util.DBUtil;
import net.webmvc.util.PageIndex;

public class PdsListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		try {
			conn = DBConn.getConnection();
			PdsDAO dao = PdsDAO.getInstance();
		
			String url="PdsServlet?cmd=pds_list";
			String addtag="",s_query="",search="", key="", h_key="";
			if(request.getParameter("key") != null && !request.getParameter("key").equals("")) {
				search = request.getParameter("search");
				key = request.getParameter("key");
				s_query=search + " like '%" + key + "%'";
				addtag= "&search="+search + "&key=" + key;
			}
			int nowpage=1;
			int maxlist=10;	
			int totpage=1;
		
			int totcount = 0;
			if(key.equals("")){
				totcount = dao.pdsCount(conn);
			}else {
				totcount= dao.pdsCount(conn,s_query);
			}
			
		
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
		
			int pagestart=(nowpage-1)*maxlist;	
			int endpage=nowpage*maxlist;
		
			int listcount = totcount-((nowpage-1)*maxlist);
		
			List<PdsVO> list = null;
			if(key.equals("")) {
				list= dao.pdsList(conn,pagestart,endpage);
			}else {
				list= dao.pdsList(conn,s_query,pagestart,endpage);
			}
			request.setAttribute("totcount", totcount);
			request.setAttribute("addtag", addtag);
			request.setAttribute("url", url);
			request.setAttribute("page", nowpage);
			request.setAttribute("totpage", totpage);
			request.setAttribute("listcount", listcount);
			request.setAttribute("list", list);
			
			String pageSkip = PageIndex.pageList(nowpage, totpage, url, addtag);
			request.setAttribute("pageSkip", pageSkip);	
		
			RequestDispatcher dispater = request.getRequestDispatcher("Pds/pds_list.jsp");
			dispater.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
	}
}

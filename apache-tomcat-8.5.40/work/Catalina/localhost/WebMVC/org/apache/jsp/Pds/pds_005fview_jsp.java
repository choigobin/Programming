/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.40
 * Generated at: 2019-07-08 02:29:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.Pds;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class pds_005fview_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/standard.jar", Long.valueOf(1562113686000L));
    _jspx_dependants.put("jar:file:/C:/Program%20Files/Java/apache-tomcat-8.5.40/webapps/WebMVC/WEB-INF/lib/standard.jar!/META-INF/c.tld", Long.valueOf(1098678690000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title>다운로그 자료실 관리 - 관리자페이지</title>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n");
      out.write("<style type=\"text/css\"> \n");
      out.write("<!-- \n");
      out.write("body,td,tr,table{font-size:9pt; font-family:tahoma;color:#666666;line-height:160%;} \n");
      out.write("\n");
      out.write("A:link {font-family:tahoma;font-size:9pt;color:#666666;text-decoration:none;} \n");
      out.write("A:visited {font-family:tahoma;font-size:9pt;color:#666666;text-decoration:none;} \n");
      out.write("A:active {font-family:tahoma;font-size:9pt;color:#666666;text-decoration:none;} \n");
      out.write("A:hover {font-family:tahoma;font-size:9pt;color:#009900;text-decoration:underline;} \n");
      out.write("--> \n");
      out.write("</style> \n");
      out.write("<script language=\"JavaScript\" type=\"text/JavaScript\">\n");
      out.write("\n");
      out.write("function pds_delete() {\n");
      out.write("\t   var urlString;\n");
      out.write("\t    urlString = \"PdsServlet?cmd=pds_delete&idx=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vo.idx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("&page=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${page}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" ;\n");
      out.write("\t    window.open(urlString, \"pds_delete\",\" resizable=yes,x=150,y=150,width=300,height=170\");\n");
      out.write("}\n");
      out.write("\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
      out.write("\t<tr><td>");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/include/top_menu.jsp", out, true);
      out.write("</td></tr>\n");
      out.write("\t<tr>\n");
      out.write("\t\t<td align=\"center\" height=\"100%\" valign=middle><br>\n");
      out.write("\t\t\t<table width=\"30%\" border=\"1\" cellspacing=\"0\" cellpadding=\"3\" bgcolor=\"#FFCC66\" bordercolor=\"#FFFFFF\" bordercolorlight=\"#000000\">\n");
      out.write("\t\t\t\t<tr> \n");
      out.write("\t\t\t\t\t<td height=40 align=\"center\" style=\"font-size: 15px;\"><b>다운로드 자료실</b></a>\n");
      out.write("\t\t\t\t\t</b></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t</table><br>\n");
      out.write("\t\t\t<table width=\"60%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td><table width=\"100%\" border=\"0\" cellpadding=\"6\" cellspacing=\"1\" bgcolor=\"DDDDDD\">\n");
      out.write("\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t<td align=\"center\" bgcolor=\"EcECEC\"><strong>제목</strong></td>\n");
      out.write("\t\t\t\t\t\t\t\t<td colspan=3 bgcolor=\"ffffff\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vo.subject}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"20%\" align=\"center\" bgcolor=\"EcECEC\"><strong>작성자</strong></td>\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"40%\" bgcolor=\"ffffff\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vo.name }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"20%\" align=\"center\" bgcolor=\"EcECEC\"><strong>이메일</strong></td>\n");
      out.write("\t\t\t\t\t\t\t\t<td align=\"center\" bgcolor=\"ffffff\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vo.email }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"20%\" align=\"center\" bgcolor=\"EcECEC\"><strong>등록일</strong></td>\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"40%\" bgcolor=\"ffffff\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vo.regdate}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"20%\" align=\"center\" bgcolor=\"EcECEC\"><strong>조회수</strong></td>\n");
      out.write("\t\t\t\t\t\t\t\t<td align=\"center\" bgcolor=\"ffffff\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vo.readcnt}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t<tr bgcolor=\"EcECEC\">\n");
      out.write("\t\t\t\t\t\t\t\t<td align=\"center\" bgcolor=\"EcECEC\"><strong>내용</strong></td>\n");
      out.write("\t\t\t\t\t\t\t\t<td colspan=3 bgcolor=\"ffffff\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contents}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t<td align=\"center\" bgcolor=\"EcECEC\"><strong>첨부파일</strong></td>\n");
      out.write("\t\t\t\t\t\t\t\t<td colspan=3 bgcolor=\"ffffff\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vo.filename}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t</table>\n");
      out.write("\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t</form>\n");
      out.write("\t\t\t</table><br>\n");
      out.write("\t\t\t<table width=\"60%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td align=center>\n");
      out.write("\t\t\t\t\t\t<a href=\"PdsServlet?cmd=pds_edit&idx=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vo.idx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("&page=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${page}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"><b>[수정]</b></a>&nbsp; \n");
      out.write("\t\t\t\t\t\t<a  href=\"javascript:pds_delete();\"><b>[삭제]</b></a>&nbsp; \n");
      out.write("\t\t\t\t\t\t<a href=\"PdsServlet?cmd=pds_list&page=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${page}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"><b>[목록]</b></a>\n");
      out.write("\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t</table>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.37
 * Generated at: 2022-02-16 09:50:03 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.work_005fkjy.gongji;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import kr.or.ddit.dcum.vo.MemberVO;
import kr.or.ddit.dcum.vo.GongjiVO;

public final class gongjiView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("kr.or.ddit.dcum.vo.MemberVO");
    _jspx_imports_classes.add("kr.or.ddit.dcum.vo.GongjiVO");
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("\r\n");
      out.write("<!-- 게시글 -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\">\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js\"></script>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("\t#date{\r\n");
      out.write("\t\ttext-align: right;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t#bambooList{\r\n");
      out.write("\t\tmargin : 5px;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t#updateGongji{\r\n");
      out.write("\t\tfloat : right;\r\n");
      out.write("\t\tmargin : 5px;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t#deleteGongji{\r\n");
      out.write("\t\tfloat : right;\r\n");
      out.write("\t\tmargin : 5px;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t#del{\r\n");
      out.write("\t\ttext-align : left;\r\n");
      out.write("\t}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//공지 목록\r\n");
      out.write("\t\t$('#gongjiList').on('click', function(){\r\n");
      out.write("\t\t\tlocation.href=\"");
      out.print( request.getContextPath() );
      out.write("/gongji.do\";\r\n");
      out.write("\t\t})\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//공지 삭제\r\n");
      out.write("\t\t$('#deleteGongji').on('click', function(){\r\n");
      out.write("\t\t\t$('#deleteModal').modal('show');\r\n");
      out.write("\t\t})\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$('#del').on('click', function(){\r\n");
      out.write("\t\t\tvar form = $('#gongjiForm').get(0);\r\n");
      out.write("\t\t\tform.action = \"");
      out.print( request.getContextPath() );
      out.write("/deleteGongji.do\";\r\n");
      out.write("\t\t\tform.submit();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$('#deleteModal').modal('hide');\r\n");
      out.write("\t\t})\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//공지 수정\r\n");
      out.write("\t\t$('#updateGongji').on('click', function(){\r\n");
      out.write("\t\t\tvar form = $('#gongjiForm').get(0);\r\n");
      out.write("\t\t\tform.action = \"");
      out.print( request.getContextPath() );
      out.write("/updateGongjiForm.do\";\r\n");
      out.write("\t\t\tform.submit();\r\n");
      out.write("\t\t})\r\n");
      out.write("\t})\r\n");
      out.write("\t\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");

	GongjiVO gongVo = (GongjiVO)request.getAttribute("gongjiVo");
	MemberVO loginMember = (MemberVO)session.getAttribute("loginUser");

      out.write("\r\n");
      out.write("\t<div class=\"container\">\r\n");
      out.write("\t<h2>공지</h2>\r\n");
      out.write("\t<p>공지게시판 입니다.</p>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 게시글 창 -->\r\n");
      out.write("\t<form id=\"gongjiForm\">\r\n");
      out.write("\t\t<input type=\"hidden\" id=\"gongji_num\" name=\"gongji_num\" value=\"");
      out.print( gongVo.getGongji_num() );
      out.write("\">\r\n");
      out.write("\t</form>\r\n");
      out.write("\t            \r\n");
      out.write("\t\t<table class=\"table\">\r\n");
      out.write("\t\t\t<thead>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th colspan=\"3\" id=\"title\">");
      out.print( gongVo.getGongji_nm() );
      out.write("</th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</thead>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td id=\"writer\">관리자</td>\r\n");
      out.write("\t\t\t\t\t<td></td>\r\n");
      out.write("\t\t\t\t\t<td id=\"date\">");
      out.print( gongVo.getGongji_date() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t  \t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td id=\"cont\" colspan=\"3\">");
      out.print( gongVo.getGongji_cont() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td colspan=\"3\">\r\n");
      out.write("\t\t\t\t\t");
 if(loginMember != null && loginMember.getMem_sort_nm().equals("교수")) { 
      out.write("\r\n");
      out.write("\t\t\t\t  \t\t<!-- 로그인한 사람이랑 일치할때만 뜨도록 수정 -->\r\n");
      out.write("\t\t\t\t  \t\t<input type=\"button\" value=\"수정\" id=\"updateGongji\">\r\n");
      out.write("\t\t\t\t  \t\t<input type=\"button\" value=\"삭제\" id=\"deleteGongji\">\r\n");
      out.write("\t\t\t\t  \t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</tbody>\r\n");
      out.write("\t\t\t\r\n");
      out.write("  \t\t</table>\r\n");
      out.write("  \t\t\r\n");
      out.write("  \t\t<!-- 목록 -->\r\n");
      out.write("\t\t<button type=\"button\" id=\"gongjiList\" class=\"btn\">\r\n");
      out.write("\t\t\t<img src=\"");
      out.print(request.getContextPath());
      out.write("/images/icon/목록아이콘.PNG\">\r\n");
      out.write("\t\t</button>\r\n");
      out.write("  \t</div>\r\n");
      out.write("  \t\r\n");
      out.write("  \t<!-- 게시글 삭제창 -->\r\n");
      out.write("\t<div class=\"modal fade\" id=\"deleteModal\">\r\n");
      out.write("\t\t<div class=\"modal-dialog modal-dialog-centered\">\r\n");
      out.write("\t\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t<!-- Modal Header -->\r\n");
      out.write("\t\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<!-- Modal body -->\r\n");
      out.write("\t\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t\t<form id=\"wrform\">\r\n");
      out.write("\t\t\t\t\t\t<label>정말 삭제하시겠습니까?</label>\r\n");
      out.write("\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<!-- Modal footer -->\r\n");
      out.write("\t\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\" id=\"del\">삭제</button>\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">취소</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
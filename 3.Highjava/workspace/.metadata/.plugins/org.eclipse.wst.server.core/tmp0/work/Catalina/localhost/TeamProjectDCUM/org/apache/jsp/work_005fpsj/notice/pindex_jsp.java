/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.37
 * Generated at: 2022-02-17 07:17:39 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.work_005fpsj.notice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class pindex_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\">\r\n");
      out.write("  <script src=\"https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js\"></script>\r\n");
      out.write("  <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\r\n");
      out.write("  <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath());
      out.write("/js/jquery-3.6.0.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("$(function(){\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 교수가 보는 강의공지 화면\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 자신이 쓴 강의공지 불러오기\r\n");
      out.write("\t\turl : \"");
      out.print(request.getContextPath());
      out.write("/pNotice.do\",\r\n");
      out.write("\t\tmethod : \"post\",\r\n");
      out.write("\t\tsuccess : function(res){\r\n");
      out.write("\t\t\tcode = \"\";\r\n");
      out.write("\t\t\tcode += \"<table border='1' class='table table-light'>\";\r\n");
      out.write("\t\t\tcode += \"<tr><h2>내가쓴 강의공지사항</h2></tr>\";\r\n");
      out.write("\t\t\tcode += \"<tr><td>강의명</td><td>글제목</td><td>글내용</td><td>작성일</td></tr>\";\r\n");
      out.write("\t\t\t$.each(res, function(i, v){\r\n");
      out.write("\t\t\t \tcode += \"<tr><td>\" + v.sub_name + \"</td>\";\r\n");
      out.write("\t\t\t \tcode += \"<td>\" + v.board_title + \"</td>\";\r\n");
      out.write("\t\t\t \tcode += \"<td> \" + v.board_cont + \"</td>\";\r\n");
      out.write("\t\t\t \tcode += \"<td>\" + v.board_date + \"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\";\r\n");
      out.write("\t\t\t \tcode += \"<input type='button' value='수정' class='btn btn-danger modify' data-toggle='modal' data-target='#myModal' data='\" + v.board_num + \"'>\";\r\n");
      out.write("\t\t\t \tcode += \"<input type='button' value='삭제' class='btn btn-danger delete ' data='\" + v.board_num + \"'></td></tr>\";\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t\tcode += \"</table>\";\r\n");
      out.write("\t\t\t$(\"body\").append(code);\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\terror : function(xhr){\r\n");
      out.write("\t\t\talert(\"상태 : \" + xhr.status)\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tdataType : \"json\"\r\n");
      out.write("\t})\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t// 내가 쓴 강의 공지 리스트에서 수정버튼 이벤트(모달창으로 시작)\r\n");
      out.write("\t$(\"body\").on(\"click\", \".modify\", function(){\r\n");
      out.write("\t\tbnum = $(this).attr(\"data\");\r\n");
      out.write("\t\talert(bnum);\r\n");
      out.write("\t\t$(\"#ff\").attr(\"action\", \"");
      out.print(request.getContextPath());
      out.write("/modifyNotice.do\");\r\n");
      out.write("\t\tcodem = \"<table border='1' class='table table-light'>\";\r\n");
      out.write("\t\tcodem += \"<tr><td>글제목</td>\";\r\n");
      out.write("\t\tcodem += \"<td><input type='text' name='title'></td></tr>\";\r\n");
      out.write("\t\tcodem += \"<tr><td>글내용</td>\";\r\n");
      out.write("\t\tcodem += \"<td><input type='text' name='cont'>\";\r\n");
      out.write("\t\tcodem += \"<input type='text' hidden value='\" + bnum + \"' name='bnum'><td></tr>\";\r\n");
      out.write("\t\tcodem += \"</table>\";\r\n");
      out.write("\t\t$(\".modal-body\").empty().append(codem);\r\n");
      out.write("\t})\r\n");
      out.write("\t\r\n");
      out.write("\t// 내가 쓴 강의 공지 리스트에서 삭제버튼 이벤트(모달창)\r\n");
      out.write("\t$(\"body\").on(\"click\", \".delete\", function(){\r\n");
      out.write("\t\tbnum2 = $(this).attr(\"data\");\r\n");
      out.write("\t\talert(bnum2);\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\turl : \"");
      out.print(request.getContextPath());
      out.write("/deleteNotice.do\",\r\n");
      out.write("\t\t\tdata : {\r\n");
      out.write("\t\t\t\t\"bnum\" : bnum2\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tmethod : \"post\",\r\n");
      out.write("\t\t\tsuccess : function(res){\r\n");
      out.write("\t\t\t\tif(res.sw == \"ok\"){\r\n");
      out.write("\t\t\t\t\talert(\"삭제되었습니다.\");\r\n");
      out.write("\t\t\t\t\tlocation.href=\"");
      out.print(request.getContextPath());
      out.write("/work_psj/notice/pindex.jsp\";\t\t\t\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\terror : function(xhr){\r\n");
      out.write("\t\t\t\talert(\"상태 : \" + xhr.status)\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tdataType : \"json\"\r\n");
      out.write("\t\t})\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t})\r\n");
      out.write("\t\t\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("})\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"modal\" id=\"myModal\">\r\n");
      out.write("  <div class=\"modal-dialog\">\r\n");
      out.write("    <div class=\"modal-content\">\r\n");
      out.write("\r\n");
      out.write("      <!-- Modal Header -->\r\n");
      out.write("      <div class=\"modal-header\">\r\n");
      out.write("        <h4 class=\"modal-title\">Modal Heading</h4>\r\n");
      out.write("        <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\r\n");
      out.write("      </div>\r\n");
      out.write("\t\r\n");
      out.write("\t  <form action=\"\" method=\"post\" id=\"ff\">\r\n");
      out.write("      <!-- Modal body -->\r\n");
      out.write("      <div class=\"modal-body\" id=\"d4\">\r\n");
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("      <!-- Modal footer -->\r\n");
      out.write("      <div class=\"modal-footer\">\r\n");
      out.write("        <input type=\"submit\" class=\"btn btn-danger\"  value='등록'>\r\n");
      out.write("        <button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">닫기</button>\r\n");
      out.write("      </div>\r\n");
      out.write("      </form>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
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
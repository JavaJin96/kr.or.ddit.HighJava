/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.37
 * Generated at: 2022-02-17 07:55:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.main;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import kr.or.ddit.dcum.vo.MemberVO;
import java.util.List;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("kr.or.ddit.dcum.vo.MemberVO");
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
      out.write("<title>Coming Soon - Start Bootstrap Theme</title>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<script src=\"../js/jquery-3.6.0.min.js\"></script>\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\" />\r\n");
      out.write("<meta name=\"description\" content=\"\" />\r\n");
      out.write("<meta name=\"author\" content=\"\" />\r\n");
      out.write("<link rel=\"icon\" type=\"image/x-icon\" href=\"assets/favicon.ico\" />\r\n");
      out.write("<!-- Font Awesome icons (free version)-->\r\n");
      out.write("<script src=\"https://use.fontawesome.com/releases/v5.15.4/js/all.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<!-- Google fonts-->\r\n");
      out.write("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" />\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Tinos:ital,wght@0,400;0,700;1,400;1,700&amp;display=swap\" rel=\"stylesheet\" />\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=DM+Sans:ital,wght@0,400;0,500;0,700;1,400;1,500;1,700&amp;display=swap\" rel=\"stylesheet\" />\r\n");
      out.write("<!-- Core theme CSS (includes Bootstrap) -->\r\n");
      out.write("<link href=\"css/styles.css\" rel=\"stylesheet\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\">\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("tr,td{\r\n");
      out.write("\tpadding: 5px;\r\n");
      out.write("}\r\n");

	// 세션 데이터 가져오기 
	MemberVO loginMember = (MemberVO) session.getAttribute("loginUser");

      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("<script>\r\n");
      out.write("$(function(){\r\n");
      out.write("\t$('#bibun-but').on('click',function() {\r\n");
      out.write("\t\t$(\"#myModal\").modal(\"show\");\r\n");
      out.write("\t})\r\n");
      out.write("\r\n");
      out.write("\t$('#modal-but').on('click',function(){\r\n");
      out.write("\t\tmem_id = $('#bibun-id').val().trim();\r\n");
      out.write("\t\tmem_mail = $('#bibun-mail').val().trim();\r\n");
      out.write("\t\r\n");
      out.write("\t\tif(mem_id.length >0  && mem_mail.length >0 ){\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl: '");
      out.print(request.getContextPath());
      out.write("/resetPass.do',\r\n");
      out.write("\t\t\t\tmethod : 'post',\r\n");
      out.write("\t\t\t\tdata : { \r\n");
      out.write("\t\t\t\t\t\"mem_id\" : mem_id ,\r\n");
      out.write("\t\t\t\t\t\"mem_mail\" : mem_mail\t\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tsuccess : function(res){\r\n");
      out.write("\t\t\t\t\talert(res)\r\n");
      out.write("\t\t\t\t\t$('.modal fade').val(\"\");\r\n");
      out.write("\t\t\t\t\t$(\"#myModal\").modal(\"hide\");\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\terror : function(xhr){\r\n");
      out.write("\t\t\t\t\talert(\"status : \"+xhr.status)\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tdataType : 'json'\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t}\r\n");
      out.write("\t})\r\n");
      out.write("})\t\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");

	if (loginMember == null) {

      out.write("\r\n");
      out.write("\t<!-- Background Video-->\r\n");
      out.write("\t<video class=\"bg-video\" playsinline=\"playsinline\" autoplay=\"autoplay\"\r\n");
      out.write("\t\tmuted=\"muted\" loop=\"loop\">\r\n");
      out.write("\t\t<source src=\"assets/mp4/bg.mp4\" type=\"video/mp4\" />\r\n");
      out.write("\t</video>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- Masthead-->\r\n");
      out.write("\t<div class=\"masthead\" data-backdrop=\"static\">\r\n");
      out.write("\t\t<div class=\"masthead-content text-white\">\r\n");
      out.write("\t\t\t<div class=\"container-fluid px-4 px-lg-0\">\r\n");
      out.write("\t\t\t\t<h1 class=\"fst-italic lh-1 mb-4\">Deadeok Human Resource Developememt Center</h1>\r\n");
      out.write("\t\t\t\t<p class=\"mb-5\">안녕하세요. <br>대덕인재개발원 사이버강의실입니다.</p>\r\n");
      out.write("\t\t\t\t<form id=\"contactForm\" action=\"http://localhost/TeamProjectDCUM/login.do\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"2\" id=\"radioTd\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"radio\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"sort\" name=\"mem_sort_num\" value=1> 학생 \r\n");
      out.write("\t\t\t\t\t\t\t<input\r\n");
      out.write("\t\t\t\t\t\t\t\ttype=\"radio\" class=\"sort\" name=\"mem_sort_num\" value=2>\r\n");
      out.write("\t\t\t\t\t\t\t\t교수 \r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td>아이디</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td><input class=\"form-control\" type=\"text\" id=\"id\"\r\n");
      out.write("\t\t\t\t\t\t\t\tname=\"mem_id\"></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td>비밀번호</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td><input class=\"form-control\" type=\"password\" id=\"pass\"\r\n");
      out.write("\t\t\t\t\t\t\t\tname=\"mem_pass\"></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr class=\"col-auto\">\r\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"submit\" class=\"btn btn-primary\" value=\"로그인\" id=\"login\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<button class=\"btn btn-primary\" id=\"bibun-but\" type=\"button\">비밀번호초기화</button>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t                       \r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\t\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("<!-- The Modal -->\r\n");
      out.write("\t<div class=\"modal fade\" id=\"myModal\" >\r\n");
      out.write("\t\t<div class=\"modal-dialog modal-dialog-centered\">\r\n");
      out.write("\t\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t\t<!-- Modal Header -->\r\n");
      out.write("\t\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t\t<h4 class=\"modal-title\"> 비밀번호 초기화 🗝  </h4>\r\n");
      out.write("\t\t\t\t</div>  \r\n");
      out.write("\t\t\t\t<!-- Modal body -->\r\n");
      out.write("\t\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t\t<div id=\"div1\" class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label>아이디</label> \r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"bibun-id\" name=\"mem_id\" required>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div id=\"div2\" class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label>이메일</label> \r\n");
      out.write("\t\t\t\t\t\t<input type=\"mail\"\tclass=\"form-control\" id=\"bibun-mail\" name=\"mem_mail\"\r\n");
      out.write("\t\t\t\t\t\tplaceholder=\"ex) Sample@naver.com\" required>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!-- Modal footer -->\r\n");
      out.write("\t\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t\t<button type=\"submit\" class=\"btn btn-secondary btn-lg btn-block\" id=\"modal-but\">확인</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
 }else if(loginMember.getMem_sort_num().equals("1")){ 
      out.write("\r\n");
      out.write("\t<script>location.href = \"http://localhost/TeamProjectDCUM/main/main.jsp\"; </script>\r\n");
 }else if(loginMember.getMem_sort_num().equals("2")){ 
      out.write("\r\n");
      out.write("\t<script>location.href = \"http://localhost/TeamProjectDCUM/main/mainp.jsp\"; </script>\r\n");
 } 
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
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

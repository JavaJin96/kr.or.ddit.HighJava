/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.37
 * Generated at: 2022-02-18 00:43:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.work_005fpsj.class_;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import kr.or.ddit.dcum.vo.MemberVO;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<style>\r\n");
      out.write("/* #d1,#d2, iframe{ */\r\n");
      out.write("/* \twidth : 98%; */\r\n");
      out.write("/* \theight : 80px; */\r\n");
      out.write("/* \tmargin : 1px; */\r\n");
      out.write("/* \tpadding : 5px; */\r\n");
      out.write("/* \toverflow: auto; */\r\n");
      out.write("/* } */\r\n");
      out.write("#d1{\r\n");
      out.write("\tmargin-top: 10px;\r\n");
      out.write("/* \theight : 200px; */\r\n");
      out.write("\tfont-size: 1.5em;\r\n");
      out.write("\tfont-weight:bold; \r\n");
      out.write("}\r\n");
      out.write("#d2{\r\n");
      out.write("\theight : 500px;\r\n");
      out.write("}\r\n");
      out.write("iframe{\r\n");
      out.write("\theight : 460px;\r\n");
      out.write("/* \tbackground : black; */\r\n");
      out.write("width : 98%;\r\n");
      out.write("}\r\n");
      out.write("#d3{\r\n");
      out.write("/* \theight : 200px; */\r\n");
      out.write("\toverflow: hidden;\r\n");
      out.write("}\r\n");
      out.write("img{\r\n");
      out.write("\twidth : 250px;\r\n");
      out.write("\theight : 200px;\r\n");
      out.write("}\r\n");
      out.write("#gopro{\r\n");
      out.write("\tfont-size : 20px;\r\n");
      out.write("}\r\n");
      out.write(".cs{\r\n");
      out.write("\twidth : 300px;\r\n");
      out.write("}\r\n");
      out.write("#clatab{\r\n");
      out.write("\tmargin-top : 160px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("<script>\r\n");
      out.write("$(function(){\r\n");
      out.write("\tsubName = \"\";\r\n");
      out.write("\t// session?????? subName??? ???????????? ?????? ajax\r\n");
      out.write(" \t$.ajax({\r\n");
      out.write("\t\turl : \"");
      out.print(request.getContextPath());
      out.write("/ClassInfo.do\",\r\n");
      out.write("\t\tmethod : \"post\",\r\n");
      out.write("\t\tsuccess : function(res){\r\n");
      out.write("\t\t    subName = res.subName\r\n");
      out.write("\t\t\t$(\"#d1\").html(res.subName);\r\n");
      out.write("\t\t    \r\n");
      out.write("\t\t    ");

		    MemberVO vo = (MemberVO)session.getAttribute("loginUser");
		    if (vo.getMem_sort_num().equals("2")){
		    
      out.write("\r\n");
      out.write("\t\t\t$(\"#d1\").append(\"<br><br><input type='button' value='????????????' id='gopro' class='btn btn-danger'><br>\");\t\t    \t\r\n");
      out.write("\t\t    ");

		    }
		    
      out.write("\r\n");
      out.write("\t\t    \r\n");
      out.write("\t\t},\r\n");
      out.write("\t\terror : function(xhr){\r\n");
      out.write("\t\t\talert(\"?????? : \" + xhr.status)\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tdataType : \"json\"\r\n");
      out.write("\t}) \r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t// ????????????????????? ???????????? ajax\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t\turl : \"");
      out.print(request.getContextPath());
      out.write("/ClassNotice.do\",\r\n");
      out.write("\t\tmethod : \"post\",\r\n");
      out.write("\t\tsuccess : function(res){\r\n");
      out.write("\t\t\tcode = \"\";\r\n");
      out.write("\t\t\tcode += \"<table border='1' class='table table-light'>\";\r\n");
      out.write("\t\t\tcode += \"<tr><h2>????????????</h2></tr>\";\r\n");
      out.write("\t\t\tcode += \"<tr><td>?????????</td><td>?????????</td><td>?????????</td><td>?????????</td><td>?????????</td></tr>\";\r\n");
      out.write("\t\t\t$.each(res, function(i, v){\r\n");
      out.write("\t\t\t \tcode += \"<tr><td>\" + v.board_num + \"</td>\";\r\n");
      out.write("\t\t\t \tcode += \"<td>\" + v.board_title + \"</td>\";\r\n");
      out.write("\t\t\t \tcode += \"<td> \" + v.board_cont + \"</td>\";\r\n");
      out.write("\t\t\t \tcode += \"<td>\" + v.board_date + \"</td>\";\r\n");
      out.write("\t\t\t \tcode += \"<td>\" + v.mem_id + \"</td></tr>\";\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t\tcode += \"</table>\";\r\n");
      out.write("\t\t\t$(\"#d3\").html(code);\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\terror : function(xhr){\r\n");
      out.write("\t\t\talert(\"?????? : \" + xhr.status)\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tdataType : \"json\"\r\n");
      out.write("\t})\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t// subName??? ????????? Class??? ?????????????????? ???????????? ?????? ajax\r\n");
      out.write("\t\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t\turl : \"");
      out.print(request.getContextPath());
      out.write("/detailClass.do\",\r\n");
      out.write("\t\tmethod : \"post\",\r\n");
      out.write("\t\tsuccess : function(res){\r\n");
      out.write("\t\t\tcode = \" <table borde='1' id='clatab'><tr>\";\r\n");
      out.write("\t\t\t$.each(res, function(i, v){\r\n");
      out.write("\t\t\t\tcode += \"<td class='font cs'><img src='../../images/main/????????????.png' alt='??????'></td>\"\r\n");
      out.write("\t\t\t})\t\r\n");
      out.write("\t\t\tcode += \"</tr>\"\r\n");
      out.write("\t\t\t$.each(res,function(i, v){\r\n");
      out.write("\t\t\t\tcode += \"<td class='font cs2'>\" + v.class_name + \"</td>\"\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t\tcode += \"</tr></table>\"\r\n");
      out.write("\t\t\t$(\"#d2\").html(code);\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\terror : function(xhr){\r\n");
      out.write("\t\t\talert(\"?????? : \" + xhr.status)\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tdataType : \"json\"\r\n");
      out.write("\t})\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t// ?????? ?????? td????????? ????????? ????????? ??????????????? ???????????? ??????\r\n");
      out.write("\t$(\"#d2\").on(\"click\", \".cs2\", function(){\r\n");
      out.write("\t\ttvalue = $(this).text();\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\turl : \"");
      out.print(request.getContextPath());
      out.write("/viewClass.do\",\r\n");
      out.write("\t\t\tdata : {\r\n");
      out.write("\t\t\t\t\"className\" : tvalue \r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tmethod : \"post\",\r\n");
      out.write("\t\t\tsuccess : function(res){\r\n");
      out.write("\t\t\t\tcode = \"<iframe src='\" + res.path + \"'>\";\r\n");
      out.write("\t\t\t\t$(\"#d1\").append(\"<br>\" + tvalue);\r\n");
      out.write("\t\t\t\t$(\"#d2\").html(code);\r\n");
      out.write("\t\t\t\t$(\"#d3\").html(\"????????????\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\turl : \"");
      out.print(request.getContextPath());
      out.write("/classQna.do\",\r\n");
      out.write("\t\t\t\t\tmethod : \"post\",\r\n");
      out.write("\t\t\t\t\tdata : {\r\n");
      out.write("\t\t\t\t\t\t\"className\" : tvalue\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tsuccess : function(res2){\r\n");
      out.write("\t\t\t\t\t\tcodes = \"<h2>????????????</h2>\";\r\n");
      out.write("\t\t\t\t\t\tcodes += \"<table border='1' class='table table-light'>\";\r\n");
      out.write("\t\t\t\t\t\tcodes += \"<tr><td>??????</td><td>??????</td><td>??????</td><td>?????????</td><td>?????????</td></tr>\";\r\n");
      out.write("\t\t\t\t\t\t$.each(res2, function(i,v) {\r\n");
      out.write("\t\t\t\t\t\t\tcodes += \"<tr class='cont' data-toggle='modal' data-target='#myModal'><td class='cc'>\" + v.board_num + \"</td>\";\r\n");
      out.write("\t\t\t\t\t\t\tcodes += \"<td>\" + v.board_title + \"</td>\";\r\n");
      out.write("\t\t\t\t\t\t\tcodes += \"<td>\" + v.board_cont + \"</td>\";\r\n");
      out.write("\t\t\t\t\t\t\tcodes += \"<td>\" + v.board_writer + \"</td>\";\r\n");
      out.write("\t\t\t\t\t\t\tcodes += \"<td>\" + v.board_date + \"</td></tr>\";\r\n");
      out.write("\t\t\t\t\t\t})\r\n");
      out.write("\t\t\t\t\t\tcodes += \"</table>\"\r\n");
      out.write("\t\t\t\t\t\t$(\"#d3\").html(codes);\r\n");
      out.write("\t\t\t\t\t\talert(\"?????? ????????? 15??? ?????? ???????????? ??????????????? ???????????????.\");\r\n");
      out.write("\t\t\t\t\t\tsetInterval(() => {\r\n");
      out.write("\t\t\t\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\t\t\t\turl : \"");
      out.print(request.getContextPath());
      out.write("/chkIn.do\",\r\n");
      out.write("\t\t\t\t\t\t\t\tdata : {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\"className\" : tvalue\r\n");
      out.write("\t\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t\tmethod : \"post\",\r\n");
      out.write("\t\t\t\t\t\t\t\tsuccess : function(res){\r\n");
      out.write("\t\t\t\t\t\t\t\t\tif(res.sw == 1){\r\n");
      out.write("\t\t\t\t\t\t\t\t\talert(\"??????????????? ?????????????????????.\");\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t\terror : function(xhr){\r\n");
      out.write("\t\t\t\t\t\t\t\t\talert(\"?????? : \" + xhr.status)\r\n");
      out.write("\t\t\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\t\t\tdataType : \"json\"\r\n");
      out.write("\t\t\t\t\t\t\t})\r\n");
      out.write("\t\t\t\t\t\t}, 15000);\r\n");
      out.write("\t\t\t\t\t\t/* ???????????? ?????????  2400000*/\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\terror : function(xhr){\r\n");
      out.write("\t\t\t\t\t\talert(\"?????? : \" + xhr.status)\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tdataType : \"json\"\r\n");
      out.write("\t\t\t\t})\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\terror : function(xhr){\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tdataType : \"json\"\r\n");
      out.write("\t\t})\r\n");
      out.write("\t\t\r\n");
      out.write("\r\n");
      out.write("\t})\r\n");
      out.write("\t\r\n");
      out.write("\t// ???????????? ????????? ????????? ????????? ???????????? ??????\r\n");
      out.write("\t$(\"#d1\").on(\"click\", \"#gopro\", function(){\r\n");
      out.write("\t\tcode = \"<div id='d4'>\"\r\n");
      out.write("\t\tcode += \"<input type='button' value='????????????' id='iw1' class='btn btn-primary' data-toggle='modal' data-target='#myModal'>\"\r\n");
      out.write("\t\tcode += \"<input type='button' value='????????????' id='iw2' class='btn btn-primary' data-toggle='modal' data-target='#myModal'>\"\r\n");
      out.write("\t\tcode += \"<input type='button' value='??????????????????' id='iw3' class='btn btn-primary' data-toggle='modal' data-target='#myModal'>\"\r\n");
      out.write("\t\tcode += \"</div>\"\r\n");
      out.write("\t\t$(\"body\").append(code);\r\n");
      out.write("\t})\r\n");
      out.write("\t\r\n");
      out.write("\t// ?????? ???????????? ????????? ?????????\r\n");
      out.write("\t// ??????????????????\r\n");
      out.write("\t$(\"body\").on(\"click\", \"#iw1\", function(){\r\n");
      out.write("\t\t$(\"#ff\").attr(\"action\", \"");
      out.print(request.getContextPath());
      out.write("/insertTaskp.do\");\r\n");
      out.write("\t\t$(\"#ff\").attr(\"enctype\", \"\");\r\n");
      out.write("\t\tcodeh = \"<table border='1' class='table table-light'>\"\r\n");
      out.write("\t\tcodeh += \"<tr><td>?????????</td><td><input type='text' name='title'></td></tr>\"\r\n");
      out.write("\t\tcodeh += \"<tr><td>????????????</td><td><input type='text' name='cont'></td></tr>\"\r\n");
      out.write("\t\tcodeh += \"<tr><td>????????????</td><td>??????<input type='checkbox' name='date' value='1'>&nbsp;&nbsp;\"\r\n");
      out.write("\t\tcodeh += \"2??????<input type='checkbox' name='date' value='2'>&nbsp;&nbsp;\"\r\n");
      out.write("\t\tcodeh += \"3??????<input type='checkbox' name='date' value='3'>&nbsp;&nbsp;\"\r\n");
      out.write("\t\tcodeh += \"????????????<input type='checkbox' name='date' value='7'></td></tr>&nbsp;&nbsp;\"\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tcodeh += \"<tr><td>????????????</td><td><input type='file' name='file'></td></tr>\"\r\n");
      out.write("\t\tcodeh += \"</table>\"\r\n");
      out.write("\t\t$(\"#d4\").empty().append(codeh);\r\n");
      out.write("\t\t\r\n");
      out.write("\t})\r\n");
      out.write("\t\r\n");
      out.write("\t// ??????????????????\r\n");
      out.write("\t$(\"body\").on(\"click\", \"#iw2\", function(){\r\n");
      out.write("\t\t$(\"#ff\").attr(\"action\", \"");
      out.print(request.getContextPath());
      out.write("/insertClass.do\");\r\n");
      out.write("\t\t$(\"#ff\").attr(\"enctype\", \"multipart/form-data\")\r\n");
      out.write("\t\tcodeci = \"<table border='1' class='table table-light'>\"\r\n");
      out.write("\t\tcodeci += \"<tr><td>?????????</td><td><input type = 'text' name='name'></td></tr>\"\r\n");
      out.write("\t\tcodeci += \"<tr><td>????????????</td><td><input type = 'text' name='comment'></td></tr>\"\r\n");
      out.write("\t\tcodeci += \"<tr><td>????????????</td><td><input type = 'file' name='file'></td></tr>\"\r\n");
      out.write("\t\tcodeci += \"</table>\"\r\n");
      out.write("\t\t$(\"#d4\").empty().append(codeci);\r\n");
      out.write("\t\t/*  location.href = \"");
      out.print(request.getContextPath());
      out.write("/work_psj/p_class/insertClass.jsp\";*/\r\n");
      out.write("\t})\r\n");
      out.write("\t\r\n");
      out.write("\t// ????????????????????????\r\n");
      out.write("\t$(\"body\").on(\"click\", \"#iw3\", function(){\r\n");
      out.write("\t\t$(\"#ff\").attr(\"action\", \"");
      out.print(request.getContextPath());
      out.write("/insertNotice.do\");\r\n");
      out.write("\t\t$(\"#ff\").attr(\"enctype\", \"\");\r\n");
      out.write("\t\tcodeni = \"<table border='1' class='table table-light'>\"\r\n");
      out.write("\t\tcodeni += \"<tr><td>?????????</td><td><input type = 'text' name='title'></td></tr>\"\r\n");
      out.write("\t\tcodeni += \"<tr><td>?????????</td><td><input type = 'text' name='cont'></td></tr>\"\r\n");
      out.write("\t\tcodeni += \"</table>\"\r\n");
      out.write("\t\t$(\"#d4\").empty().append(codeni);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\r\n");
      out.write("\t})\r\n");
      out.write("\t\r\n");
      out.write("})\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"d1\"> <h1>????????? ?????? NAV</h1></div>\r\n");
      out.write("\t<div id=\"d2\" class=\"container p-3 my-3\"> </div>\r\n");
      out.write("\t<div id=\"d3\"> <h4>?????? ????????????</h4></div>\r\n");
      out.write("\t\r\n");
      out.write("<!-- The Modal -->\r\n");
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
      out.write("\t  <form action=\"");
      out.print(request.getContextPath());
      out.write("/insertTaskp.do\" method=\"post\" id=\"ff\">\r\n");
      out.write("      <!-- Modal body -->\r\n");
      out.write("      <div class=\"modal-body\" id=\"d4\">\r\n");
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("      <!-- Modal footer -->\r\n");
      out.write("      <div class=\"modal-footer\">\r\n");
      out.write("        <input type=\"submit\" class=\"btn btn-danger\"  value='??????'>\r\n");
      out.write("        <button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">??????</button>\r\n");
      out.write("      </div>\r\n");
      out.write("      </form>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
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

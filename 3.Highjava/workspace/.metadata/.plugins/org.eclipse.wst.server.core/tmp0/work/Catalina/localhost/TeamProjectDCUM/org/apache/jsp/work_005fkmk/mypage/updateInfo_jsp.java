/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.37
 * Generated at: 2022-02-15 10:53:51 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.work_005fkmk.mypage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import kr.or.ddit.dcum.vo.temp_StudentInfoVO;
import kr.or.ddit.dcum.vo.StudentVO;
import kr.or.ddit.dcum.vo.MemberVO;

public final class updateInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("kr.or.ddit.dcum.vo.temp_StudentInfoVO");
    _jspx_imports_classes.add("kr.or.ddit.dcum.vo.StudentVO");
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>ddit cyber university</title>\r\n");
      out.write("<!-- jquery -->\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/js/jquery-3.6.0.min.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"http://localhost/TeamProjectDCUM/css/updateInfo.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"http://localhost/TeamProjectDCUM/css/mypage.css\">\r\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write(" <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\">\r\n");
      out.write("<script\tsrc=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\r\n");
      out.write("<script\tsrc=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js\"></script>  \r\n");
 
MemberVO loginMember = (MemberVO)session.getAttribute("loginUser");
temp_StudentInfoVO studentInfo = (temp_StudentInfoVO)session.getAttribute("studentInfo");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("$(function(){\r\n");
      out.write("\t$('#bibun-but').on('click',function(){\r\n");
      out.write("\t\t$(\"#myModal\").modal(\"show\");\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t// 비밀번호 규칙 정규식 : 6~20 영문 대소문자  , 최소 1개의 숫자 혹은 특수 문자를 포함해야 함\r\n");
      out.write("\t\tpassreg =/^(?=.*[a-zA-Z])((?=.*\\d)|(?=.*\\W)).{6,20}$/\r\n");
      out.write("\t\toldpassvalue=\"\"\r\n");
      out.write("\t\tpassvalue =\"\"\r\n");
      out.write("\t\tchkpassvalue =\"\"\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$('#oldPass').on('keyup',function(){\r\n");
      out.write("\t\t\toldpassvalue = $(this).val().trim();\r\n");
      out.write("\t\t\tif(oldpassvalue==\"");
      out.print(loginMember.getMem_pass());
      out.write("\") {\r\n");
      out.write("\t\t\t\t$(this).css('border', '2px solid green');\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t})\r\n");
      out.write("\t\t$('#newPass').on('keyup',function(){\r\n");
      out.write("\t\t\tpassvalue = $(this).val().trim();\r\n");
      out.write("\t\t\tif(passreg.test(passvalue)) {\r\n");
      out.write("\t\t\t\t$(this).css('border', '2px solid green');\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t})\r\n");
      out.write("\t\t$('#chkPass').on('keyup',function(){\r\n");
      out.write("\t\t\tchkpassvalue = $(this).val().trim();\r\n");
      out.write("\t\t\tif(passreg.test(passvalue)) {\r\n");
      out.write("\t\t\t\t$(this).css('border', '2px solid green');\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t})\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$('#modal-but').on('click', function() {\r\n");
      out.write("\t\t\tif(oldpassvalue.length < 1 ){\r\n");
      out.write("\t\t\t\talert(\"현재 비밀번호를 입력해주세요.\")\r\n");
      out.write("\t\t\t\t$('#oldPass').css('border', '2px solid red');\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\telse if(oldpassvalue!=\"");
      out.print(loginMember.getMem_pass());
      out.write("\"){\r\n");
      out.write("\t\t\t\talert(\"현재 비밀번호가 일치하지 않습니다.\")\r\n");
      out.write("\t\t\t\t$('#oldPass').css('border', '2px solid red');\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\telse if(passvalue.length < 1 ){\r\n");
      out.write("\t\t\t\talert(\"변경할 비밀번호를 입력해주세요.\")\r\n");
      out.write("\t\t\t\t$('#newPass').css('border', '2px solid red');\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\telse if(passvalue==\"");
      out.print(loginMember.getMem_pass());
      out.write("\"){\r\n");
      out.write("\t\t\t\talert(\"변경할 비밀번호는 현재 비밀번호와 다르게 입력해주세요\")\r\n");
      out.write("\t\t\t\t$('#newPass').css('border', '2px solid red');\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\telse if(!passreg.test(passvalue)) {\r\n");
      out.write("\t\t\t\talert(\"비밀번호가 올바르지 않습니다.\\n영문 대소문자(최소 1개의 숫자 혹은 특수문자 포함) 6자리 이상으로\\n만들어야합니다.\")\r\n");
      out.write("\t\t\t\t$('#newPass').css('border', '2px solid red');\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\telse if(chkpassvalue< 1 ){\r\n");
      out.write("\t\t\t\talert(\"비밀번호를 재입력해주세요.\")\r\n");
      out.write("\t\t\t\t$('#chkPass').css('border', '2px solid red');\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\telse if(chkpassvalue != passvalue) {\r\n");
      out.write("\t\t\t\talert(\"비밀번호가 일치하지 않습니다.\")\r\n");
      out.write("\t\t\t\t$('#chkPass').css('border', '2px solid red');\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\telse{\r\n");
      out.write("\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\turl : \"");
      out.print(request.getContextPath());
      out.write("/updatePass.do\",\r\n");
      out.write("\t\t\t\t\tdata : { 'mem_pass': passvalue },\r\n");
      out.write("\t\t\t\t\ttype : 'post',\r\n");
      out.write("\t\t\t\t\tsuccess : function() {\r\n");
      out.write("\t\t\t\t\t\talert(\"변경성공\");\r\n");
      out.write("\t\t\t\t\t\t$('.form-control').val(\"\");\r\n");
      out.write("\t\t\t\t\t\t$(\"#myModal\").modal(\"hide\");\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\terror : function(xhr) {\r\n");
      out.write("\t\t\t\t\t\talert(\"상태 : \" + xhr.status);\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\tdataType : 'html'\r\n");
      out.write("\t\t\t\t})\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t})\r\n");
      out.write("\t})\r\n");
      out.write("\t\r\n");
      out.write("\t$('#modifyModal').on('hide.bs.modal',function(){\r\n");
      out.write("\t\t$('.form-control').val(\"\");\r\n");
      out.write("\t})\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t$('#up-but').on('click',function(){\r\n");
      out.write("\t\t$('#bibun-but').hide();\r\n");
      out.write("\t\tbir = '<input type=\"text\" class=\"updateInfo\" style=\"width:500px;\" value='+$('#bir').text()+'>';\r\n");
      out.write("\t\t$('#bir').html(bir);\r\n");
      out.write("\t\thp = '<input type=\"text\" class=\"updateInfo\" style=\"width:500px;\" value='+$('#hp').text()+'>';\r\n");
      out.write("\t\t$('#hp').html(hp);\r\n");
      out.write("\t\tmail = '<input type=\"mail\" class=\"updateInfo\"style=\"width:500px;\"  value='+$('#mail').text()+'>';\r\n");
      out.write("\t\t$('#mail').html(mail);\r\n");
      out.write("\t\tcont = '\\\"'+$('#add').text()+'\\\"'\r\n");
      out.write("\t\tadd = '<input type=\"text\" class=\"updateInfo\" style=\"width:500px;\" value='+cont+'>';\r\n");
      out.write("\t\t$('#add').html(add);\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$('#submit').show();\r\n");
      out.write("\t\t$('#no-but').show();\r\n");
      out.write("\t\t$(this).hide();\r\n");
      out.write("\t\r\n");
      out.write("\t})\r\n");
      out.write("\t\r\n");
      out.write("\t$('#td-but-parent').on('click','#submit',function(){\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\turl:'");
      out.print(request.getContextPath());
      out.write("/updateInfo.do',\r\n");
      out.write("\t\t\tdata:{\r\n");
      out.write("\t\t\t\t'mem_bir' : $('#bir .updateInfo').val().trim(),\r\n");
      out.write("\t\t\t\t'mem_hp' :  $('#hp .updateInfo').val().trim(),\r\n");
      out.write("\t\t\t\t'mem_mail' : $('#mail .updateInfo').val().trim(),\r\n");
      out.write("\t\t\t\t'mem_add' : $('#add .updateInfo').val().trim()\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tmethod : 'post',\r\n");
      out.write("\t\t\tsuccess :function(res){\r\n");
      out.write("\t\t\t\tif(res > 0){\r\n");
      out.write("\t\t\t\t\talert(\"회원정보 수정성공\");\r\n");
      out.write("\t\t\t\t\tlocation.reload(true);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\telse{\r\n");
      out.write("\t\t\t\t\talert(\"회원정보 수정실패\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\terror : function(xhr){\r\n");
      out.write("\t\t\t\talert(\"status : \"+xhr.status);\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tdataType : 'json'\r\n");
      out.write("\t\t})\r\n");
      out.write("\t})\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("})\r\n");
      out.write("</script>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("\t<br>\r\n");
      out.write("  <h3>개인정보</h3>\r\n");
 if(loginMember.getMem_sort_num().equals("1")){ 
      out.write("\r\n");
      out.write("  <p id=\"p1\">인적사항 외 수정사항은 관리자에게 문의하세요.</p>\r\n");
      out.write("  <hr>\r\n");
      out.write("  <caption> 학과정보 </caption>\r\n");
      out.write("  <table class=\"table dark-table\" >\r\n");
      out.write("    <thead class=\"thead-dark\">\r\n");
      out.write("      <tr>\r\n");
      out.write("        <th>이름</th>\r\n");
      out.write("        <th>학과</th>\r\n");
      out.write("        <th>학번</th>\r\n");
      out.write("        <th>입학일</th>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </thead>\r\n");
      out.write("    <tbody>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td>");
      out.print(loginMember.getMem_name() );
      out.write("</td>\r\n");
      out.write("        <td>");
      out.print(studentInfo.getDep_name());
      out.write("</td>\r\n");
      out.write("        <td>");
      out.print(studentInfo.getMem_id());
      out.write("</td>\r\n");
      out.write("        <td>");
      out.print(studentInfo.getStart_date());
      out.write("</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </tbody>\r\n");
      out.write("  </table>\r\n");
}else if(loginMember.getMem_sort_num().equals("2")){ 
      out.write("\r\n");
      out.write("  <hr>\r\n");
      out.write("  <caption> 학과정보 </caption>\r\n");
      out.write("  <table class=\"table dark-table\" >\r\n");
      out.write("    <thead class=\"thead-dark\">\r\n");
      out.write("      <tr>\r\n");
      out.write("        <th>이름</th>\r\n");
      out.write("        <th>학과</th>\r\n");
      out.write("        <th>아이디</th>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </thead>\r\n");
      out.write("    <tbody>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <td>");
      out.print(loginMember.getMem_name() );
      out.write("</td>\r\n");
      out.write("        <td>컴퓨터학과</td>\r\n");
      out.write("        <td>");
      out.print(loginMember.getMem_id());
      out.write("</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </tbody>\r\n");
      out.write("  </table>\r\n");
}
      out.write("        \r\n");
      out.write("  <br>\r\n");
      out.write("  <caption > 인적사항 </caption>\r\n");
      out.write("  <table class=\"table\">\r\n");
      out.write("    <thead class=\"thead-light\">\r\n");
      out.write("      <tr class=\"img_t\">\r\n");
      out.write(" \t\t<td class=\"img_t\"> <img id=\"photo\" src=\"../../images/main/사자2.jpg\" > </td>\r\n");
      out.write("\t\t<td class=\"img_t\" id=\"td-but-parent\">\r\n");
      out.write("\t\t\t<button type=\"button\" class=\"btn btn-secondary\" id=\"up-but\" >인적사항수정</button>\r\n");
      out.write("\t\t\t<button type=\"button\" class=\"btn btn-secondary\" style=\"display:none;\" id=\"submit\" >확인</button>\r\n");
      out.write("\t\t\t<button class=\"btn btn-secondary\" id=\"no-but\" style=\"display:none;\"  \r\n");
      out.write("\t\t\t\t\tonclick=\"location.href='updateInfo.jsp'\">취소</button>\r\n");
      out.write("\t\t\t<button type=\"button\" class=\"btn btn-secondary\" id=\"bibun-but\" >비밀번호변경</button>\r\n");
      out.write("      \t</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("      \t<th>생년월일</th>\r\n");
      out.write("        <td id=\"bir\">");
      out.print(studentInfo.getMem_bir());
      out.write("</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <th>핸드폰번호</th>\r\n");
      out.write("        <td id=\"hp\">");
      out.print(studentInfo.getMem_hp());
      out.write("</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    \r\n");
      out.write("      <tr>\r\n");
      out.write("        <th>이메일</th>\r\n");
      out.write("        <td id=\"mail\">");
      out.print(studentInfo.getMem_mail());
      out.write("</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("      <tr>\r\n");
      out.write("        <th>주소</th>\r\n");
      out.write("        <td id=\"add\">");
      out.print(studentInfo.getMem_add());
      out.write("</td>\r\n");
      out.write("      </tr>\r\n");
      out.write("    </thead>\r\n");
      out.write("  </table>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!-- The Modal -->\r\n");
      out.write("\t<div class=\"modal fade\" id=\"myModal\" >\r\n");
      out.write("\t\t<div class=\"modal-dialog modal-dialog-centered\">\r\n");
      out.write("\t\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t\t<!-- Modal Header -->\r\n");
      out.write("\t\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t\t<h4 class=\"modal-title\">🔒비밀번호 변경🔒</h4>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!-- Modal body -->\r\n");
      out.write("\t\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t\t<div id=\"div1\" class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"pwd\">현재 비밀번호 입력</label> \r\n");
      out.write("\t\t\t\t\t\t<input type=\"password\" class=\"form-control\" id=\"oldPass\" placeholder=\"현재 비밀번호를 입력해주세요\" required>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div id=\"div1\" class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"pwd\">변경할 비밀번호 입력</label> \r\n");
      out.write("\t\t\t\t\t\t<input type=\"password\" class=\"form-control\" id=\"newPass\" \r\n");
      out.write("\t\t\t\t\t\tplaceholder=\"영문 대소문자 6자리 (최소 1개의 숫자 혹은 특수문자 포함)\" name=\"mem_pass\" required>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div id=\"div2\" class=\"form-group\">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"pwd\">변경할 비밀번호 재입력</label> \r\n");
      out.write("\t\t\t\t\t\t<input type=\"password\"\tclass=\"form-control\" id=\"chkPass\" \r\n");
      out.write("\t\t\t\t\t\tplaceholder=\"Enter password\" required>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<!-- Modal footer -->\r\n");
      out.write("\t\t\t\t<div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t\t<button type=\"submit\" class=\"btn btn-secondary btn-lg btn-block\" id=\"modal-but\" >확인</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
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

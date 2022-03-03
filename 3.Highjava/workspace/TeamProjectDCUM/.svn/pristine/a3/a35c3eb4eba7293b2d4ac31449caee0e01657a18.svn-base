<%@page import="kr.or.ddit.dcum.vo.SubjectTiVO"%>
<%@page import="kr.or.ddit.dcum.vo.SubjectVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%
 	//서블릿 연결 되어있는 jsp
   List<SubjectTiVO> list2 = (List<SubjectTiVO>)request.getAttribute("list2");
 %>
   
   
    [
    
    
    <%
 	if(list2 != null && list2.size() > 0) {
    
 	for(int i=0; i<list2.size(); i++ ){	
 		SubjectTiVO vo = list2.get(i);
 		if( i > 0 ) out.print(",");
    %>
    
    
    
    	{
    	"sub_name"  : "<%= vo.getSub_name()%>",
		"mem_sort_nm" : "<%=vo.getMem_sort_nm() %>",
		"mem_name" : "<%=vo.getMem_name() %>"
    	}
    
    
    
    <%
      }
 	}
    %>  
    
    
    
    
    ]
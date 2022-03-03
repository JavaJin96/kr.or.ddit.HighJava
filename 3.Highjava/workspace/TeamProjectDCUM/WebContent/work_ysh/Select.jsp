<%@page import="kr.or.ddit.dcum.vo.ClassSubjectVO"%>
<%@page import="kr.or.ddit.dcum.vo.ClassStudentVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  <%
   List<ClassSubjectVO> list = (List<ClassSubjectVO>)request.getAttribute("list");
 %>
   
 [  
   
    <%
 	if(list != null && list.size() > 0) {
    
    	
    
 	for(int i=0; i<list.size(); i++ ){	
 		ClassSubjectVO vo = list.get(i);
 		if( i > 0 ) out.print(",");
 		
    %>
    
    
      {
      
    	
    	"mem_id"  : "<%= vo.getMem_id()%>",
		"sub_num" : "<%=vo.getSub_num()%>",
		"sub_score" : "<%= vo.getSub_score()%>",
   		"sub_name" : "<%= vo.getSub_name() %>"
    	}
    
    
    
    <%
    
      }
 	}
 	
    %>  
    ]
    
   
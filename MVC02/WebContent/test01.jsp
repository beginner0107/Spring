<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- JSP 주석 --%>
<%!
	public int hap(int s, int e){
	int sum = 0;
	for(int i=s; i<=e; i++){
		sum+=i;
	}
	return sum;
	}
%>

<%
	int sum = 0;
	for(int i = 1; i<=10; i++){
		sum += i;
	}
// request, response : 
// session, out, config, application, pageContext
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test</title>
</head>
<body>
1~10까지의 총합 = <%=sum %><br>
55~350까지의 총합 = <%=hap(55, 350) %>
</body>
</html>
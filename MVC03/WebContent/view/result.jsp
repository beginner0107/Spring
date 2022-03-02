<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	String email = request.getParameter("email");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 회원의 이름 : <%=name %><br>
 회원의 나이 : <%=age %><br>
 회원의 이메일 : <%=email %>
</body>
</html>
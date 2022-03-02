<%@page import="kr.bit.model.MyCalC"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	MyCalC c = new MyCalC();
	int v = c.hap(1, 300);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test02</title>
</head>
<body>
<table border = '1'>
	<tr>
		<td>1~300까지의 총합</td>
		<td><%=v %></td>
	</tr>
</table>
</body>
</html>
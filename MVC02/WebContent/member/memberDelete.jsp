<%@page import="kr.bit.model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	int num = Integer.parseInt(request.getParameter("num"));
	MemberDAO dao = new MemberDAO();
	int cnt = dao.deleteMember(num);
	if(cnt>0){
		response.sendRedirect("memberList.jsp");
	}else{
		throw new ServletException("not delete");
	}
%>
package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;

@SuppressWarnings("serial")
@WebServlet("/memberDelete.do")
public class MemberDeleteController extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int num = Integer.parseInt(request.getParameter("num"));
		MemberDAO dao = new MemberDAO();
		int cnt = dao.deleteMember(num);
		if(cnt==1) {
			response.sendRedirect("/MVC03/memberList.do");
		}else {
			throw new ServletException("not delete");
		}
	}
}

package kr.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

@SuppressWarnings("serial")
@WebServlet("/memberContent.do")
public class MemberContentController extends HttpServlet{
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int num = Integer.parseInt(request.getParameter("num"));
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.memberContent(num);	
		
		request.setAttribute("vo", vo);
		
		RequestDispatcher rd = request.getRequestDispatcher("member/memberContent.jsp");
		rd.forward(request, response);
	}
}

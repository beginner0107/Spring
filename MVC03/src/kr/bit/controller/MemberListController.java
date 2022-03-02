package kr.bit.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

@SuppressWarnings("serial")
@WebServlet("/memberList.do")
public class MemberListController extends HttpServlet{	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) 
											throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 1. 클라이언트의 요청을 받기(memberList.do)
		MemberDAO dao = new MemberDAO();
		// 2. 회원 전체 리스트 가져오기(Model 연동)
		ArrayList<MemberVO> list = dao.memberList();
		
		// 객체 바인딩(request 바인딩)
		request.setAttribute("list", list);
		// forward기법
		RequestDispatcher rd = request.getRequestDispatcher("member/memberList.jsp");
		rd.forward(request, response);
	}
}

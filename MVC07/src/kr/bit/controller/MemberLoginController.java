package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

public class MemberLoginController implements Controller{
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String ctx = request.getContextPath();
		
		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");
		
		MemberVO vo = new MemberVO();
		vo.setId(user_id);
		vo.setPass(password);
		
		MemberDAO dao = new MemberDAO();
		String user_name = dao.memberLogin(vo);
		// user_name에 값이 있으면 인증이 성공한 것이고, user_name에 값이 없으면 회원인증이 실패한 경우
		HttpSession session = request.getSession();
		if(user_name!=null && !"".equals(user_name)) {
			// 성공
			session.setAttribute("userId", user_id);
			session.setAttribute("userName", user_name);
		}else {
			// 실패
			session.setAttribute("userId", "");
			session.setAttribute("userName", "");
			session.setAttribute("msg", "사용자 정보가 올바르지 않습니다.");
		}
		
		return "redirect:" + ctx + "/memberList.do";
	}

}

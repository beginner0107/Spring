package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;

public class MemberDbcheckController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		MemberDAO dao = new MemberDAO();
		String id = request.getParameter("id");
		String dbDouble = dao.memberDbcheck(id); // YES or NO
		// 다음페이지 정보를 넘겨주지 않고
		// 이 컨트롤러가 memberRegister 쪽으로 바로 response
		response.getWriter().print(dbDouble);
		
		return null;
	}

}

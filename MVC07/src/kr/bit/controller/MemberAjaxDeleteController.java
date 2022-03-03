package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;

public class MemberAjaxDeleteController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		int num = Integer.parseInt(request.getParameter("num"));
		MemberDAO dao = new MemberDAO();
		int cnt = dao.memberDelete(num);
		if(cnt==1) {
			request.getSession().invalidate();
			response.getWriter().print(cnt);
		}else {
			throw new ServletException("not delete");
		}
		return null;
	}

}

package kr.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberLogoutController implements Controller{
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String ctx = request.getContextPath();
		// 세션을 가져와서 세션을 제거
		// 세션을 제거하는 방법
		// 1. 강제로
		request.getSession().invalidate();
		// 2. 브라우져를 종료하는 것(JESSIONID 브라우져 쿠키에 저장)
		// 3. 세션이 종료될 때까지 기다리는 것(세션타임아웃 : 30초=1800초)
		return "redirect:" + ctx + "/memberList.do";
	}

}

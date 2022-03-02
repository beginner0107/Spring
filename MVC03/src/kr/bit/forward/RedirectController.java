package kr.bit.forward;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForwardController
 */
@WebServlet("/rc.do")
public class RedirectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. forward 실습
//		int su = 100;
		String name = "park";
		int age = 45;
		String email = "aaa@naver.com";
		// View page(result.jsp)로 data를 전달하여  View Page에서 출력
		// Controller에서 View로 페이지를 전환하는 방법
		// 1. redirect
		// 2. forward
//		request.setAttribute("data", data); // 객체 바인딩(request binding)
		response.sendRedirect("view/result.jsp?name="+name+"&age="+age+"&email="+email); 
		
	}

}

package kr.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloStart
 */
@WebServlet("/h.do")
public class HelloStart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 클라이언트의 요청을 받는 작업(파라메터 수집) -> Controller(Servlet)
		// 2. 처리하는 작업(비즈니스 로직) -> Model(Java class)
		int sum = 0;
		for(int i = 1; i<=10; i++) {
			sum += i;
		}
		
		// 3. 요청한 클라이언트에게 응답하는 작업(프리젠테이션 로직) -> View(JSP)
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<body>");
		pw.println(sum);
		pw.println("</body>");
		pw.println("</html>");
		
		// Servlet과 Model로 회원관리 만들기
		
	}

}

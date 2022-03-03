package kr.bit.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.bit.model.MemberDAO;

public class FileDelController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String ctx = request.getContextPath();
		String filename = request.getParameter("filename");
		int num = Integer.parseInt(request.getParameter("num"));
		// filename이 한글인 경우 get으로 받기 때문에 인코딩을 해주어야 한다.
		filename = URLEncoder.encode(filename, "utf-8");
		// filename에 +기호가 있는 경우(구글 크롬 브라우저)
		filename = filename.replace("+", " ");
		
		// 파일을 삭제 후 DB에 filename 삭제
		String UPLOAD_DIR = "file_repo";
		String uploadPath = request.getServletContext().getRealPath("")+File.separator+UPLOAD_DIR; // 물리적인 파일의 경로
		// 파일 객체 생성
		File file = new File(uploadPath+"\\"+filename);
		if(file.exists()) {
			file.delete();
			System.out.println("디렉토리에서 파일 삭제");
		}
		// 테이블에서도 파일을 null 처리를 해야 한다(update)
		MemberDAO dao = new MemberDAO();
		dao.memberDeleteFile(num);
		
		
		return "redirect:"+ctx+"/memberContent.do?num="+ num;
	}
}

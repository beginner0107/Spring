package kr.narp.myapp1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class FileController {
	@RequestMapping("/upload.do")
	public String upload(MultipartHttpServletRequest multipartRequest, HttpServletRequest request, Model model) throws Exception { // 스프링에서 제공해주는 파일업로드할 때 사용하는 클래스
		// 파일이 저장될 실제 경로
		String UPLOAD_DIR = "repo"; // webContent 아래                                //  \\ /
		String uploadPath = request.getServletContext().getRealPath("")+File.separator+UPLOAD_DIR;
		
		// id, name
		Map map = new HashMap(); // (Key, Value)
//		String id = multipartRequest.getParameter("id"); 
//		String name = multipartRequest.getParameter("name"); 
		// Enumeration -> 나열, 열거형
		Enumeration<String> e= multipartRequest.getParameterNames(); // id, name
//		System.out.println(id + " : " + name);
		while(e.hasMoreElements()) {
			String name = e.nextElement(); //id
			String value = multipartRequest.getParameter(name);
//			System.out.println(name + " : " + value);
			map.put(name, value);
		}
		// 파일을 담고 있는 파라메터 읽어오기
		Iterator<String>it = multipartRequest.getFileNames(); // 파일이름이 아니라 -> 파라메터이름(file1, file2 ...)
		List<String>fileList = new ArrayList<>();
		while(it.hasNext()) {
			String paramfName = it.next();
//			System.out.println(paramfName);
			MultipartFile mFile = multipartRequest.getFile(paramfName); // 파일(이름, 타입, 크기 ....)
			String oName = mFile.getOriginalFilename(); // 실제 업로드된 파일이름
//			System.out.println(oName);
			fileList.add(oName);
			// 파일을 업로드 할 경로를 확인?
			File file = new File(uploadPath+"\\"+paramfName); // file1
			int i = 1;
			if(mFile.getSize()!=0) {
				if(!file.exists()) {
					if(file.getParentFile().mkdirs()) {
						file.createNewFile(); // 임시로 파일을 생성한다.
					} 
				}
				mFile.transferTo(new File(uploadPath+"\\"+oName)); // 파일 업로드
			}
		}
		map.put("fileList", fileList);	
		model.addAttribute("map", map);
		return "result";
	}
	
	@RequestMapping("/download.do")
	public void download(@RequestParam("filename") String filename,
			HttpServletResponse response,
			HttpServletRequest request) throws Exception{
//		String filename = request.getParameter("filename");
//		System.out.println(filename);
		
		String UPLOAD_DIR = "repo";
		String uploadPath = request.getServletContext().getRealPath("")+File.separator+UPLOAD_DIR; // 물리적인 주소
		File f = new File(uploadPath+"\\"+filename);
		// 클라이언트로부터 넘어오는 파일이름에 한글이 깨지지 않게하기 위함
		filename = URLEncoder.encode(filename, "UTF-8");
		filename = filename.replace("+", " "); // 크롬(브라우저) 공백이 있는 경우 " " -> "+"로 바뀌기 떄문
		// 다운로드 준비로 서버에서 클라이언트에게 다운로드 준비를 시키는 부분(다운로드 창을 띄운다)
		response.setContentLength((int)f.length());
		response.setContentType("application/x-msdownload;charset=utf-8");
		response.setHeader("Content-Disposition", "attachment;filename="+filename+";"); 
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		// 실제 다운로드를 하는 부분
		FileInputStream in = new FileInputStream(f);// 파일 읽기 준비
		OutputStream out = response.getOutputStream(); 
		byte[]buffer = new byte[104];
		while(true) {
			int count = in.read(buffer);
			if(count==-1) {
				break;
			}
			out.write(buffer, 0, count); // 다운로드(0%......100%)
		} // _while_
		in.close();
		out.close();
	}
}

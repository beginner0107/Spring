package kr.inflearn.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.inflearn.service.MemberService;
import lombok.extern.slf4j.Slf4j;
@Controller
@Slf4j
public class FileController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/fileAdd.do", produces="application/text;charset=utf8")
	@ResponseBody
	public String fileAdd(HttpServletRequest request)
			throws IOException, ServletException{
		String UPLOAD_DIR = "file_repo"; // webContent 아래                                윈도우 //, 리눅스 \\
		String uploadPath = request.getServletContext().getRealPath("")+File.separator+UPLOAD_DIR;
		File currentDirPath = new File(uploadPath); // 업로드할 경로를 File 객체로 만들기
		if(!currentDirPath.exists()) {
			currentDirPath.mkdir();
		}
		// 파일을 업로드 할때 먼저 저장될 임시 저장경로를  설정
		// file upload시 필요한 API
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath); // currentDirPath에 저장
		factory.setSizeThreshold(1024*1024); // 용량 1mb
		
		String fileName = null;
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {      // items --> FileItem[  ], FileItem[  ], FileItem[  ]
			List<FileItem> items = upload.parseRequest(request); // request 안에 여러개의 파일이 된 경우...
			System.out.println(items.size());
			for(int i=0;i<items.size();i++) {
				FileItem fileItem = items.get(i); // 하나의 파일 정보들이 담아져 있음.
				// fileItem에 있는 데이터가 일반 파라미터인지 파일인지 // Ajax로 구현 X 때
				if(fileItem.isFormField()) { // 폼필드이면
					System.out.println(fileItem.getFieldName()+"="+fileItem.getString("utf-8"));
				}else { // 파일이면
					if(fileItem.getSize()>0) {
						int idx = fileItem.getName().lastIndexOf("\\"); // \\(Window), /(Linux)
						if(idx==-1) {
							idx = fileItem.getName().lastIndexOf("/");
						}
						fileName = fileItem.getName().substring(idx+1); // 파일 이름
						File uploadFile = new File(currentDirPath+"\\"+fileName);
						// 파일의 중복 체크
						if(uploadFile.exists()) {
							fileName = System.currentTimeMillis()+"_"+fileName;
							uploadFile = new File(currentDirPath+"\\"+fileName);
						}
						fileItem.write(uploadFile); // 임시경로 -> 새로운 경로에 파일을 쓰기
					}
				}
			} // _for_
		} catch (Exception e) {
			e.printStackTrace();
		}
		// $.ajax()쪽으로 업로드된 최종 파일이름을 전송시켜준다.
		log.info("fileName : {}", fileName);
		return fileName;
	}
	@RequestMapping("/fileGet.do")
	public String fileGet(String filename, HttpServletRequest request, HttpServletResponse response) 
											throws IOException, ServletException {
		String UPLOAD_DIR = "file_repo";
		String uploadPath = request.getServletContext().getRealPath("")+File.separator+UPLOAD_DIR;
		File f = new File(uploadPath+"\\"+filename);
		
		filename = URLEncoder.encode(filename, "UTF-8");
		filename = filename.replace("+", " "); // 크롬(브라우저) 공백이 있는 경우 " " -> "+"로 바뀌기 떄문
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
		return null;
	}
	@RequestMapping("/fileDel.do")
	public String fileDel(int num, String filename, HttpServletRequest request)
								throws IOException, ServletException{
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
		memberService.memberDeleteFile(num);
		return "redirect:/member/memberContent.do?num="+num;
	}
	
}

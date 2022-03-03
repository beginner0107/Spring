package kr.bit.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileAddController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
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
		response.setContentType("text/html;charset=euc-kr");
		response.getWriter().print(fileName);
		return null;
	}
}

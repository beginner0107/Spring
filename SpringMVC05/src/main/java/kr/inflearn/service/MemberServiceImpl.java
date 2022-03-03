package kr.inflearn.service;

import java.io.File;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.inflearn.mapper.MemberMapper;
import kr.inflearn.model.MemberVO;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberMapper mapper;
	
	@Override
	public List<MemberVO> memberList() {
		List<MemberVO>list = mapper.memberList();
		return list;
	}

	@Override
	public void memberInsert(MemberVO member, String mode) {
	log.info("{} , MemberVO : {}", System.class.getName(), member.toString());
		if(mode.equals("fadd")) {
			mapper.memberInsertFile(member);
		}else {
			mapper.memberInsert(member);
		}
	}

	@Override
	public void memberDelete(int num, String filename, String uploadPath)throws Exception{
		if(filename.equals("")) {
			mapper.memberDelete(num);
		}else {
			filename = URLEncoder.encode(filename, "utf-8");
			// filename에 +기호가 있는 경우(구글 크롬 브라우저)
			filename = filename.replace("+", " ");
			// 파일을 삭제 후 DB에 filename 삭제
			// 파일 객체 생성
			File file = new File(uploadPath+"\\"+filename);
			if(file.exists()) {
				file.delete();
				System.out.println("디렉토리에서 파일 삭제");
			}
			mapper.memberDeleteFile(num);
			mapper.memberDelete(num);
		}
	}

	@Override
	public MemberVO memberContent(int num) {
		MemberVO member = mapper.memberContent(num);
		return member;
	}

	@Override
	public void memberUpdate(MemberVO member, String mode) {
		if(mode.equals("fupdate")) {
			mapper.memberUpdateFile(member);
		}else {
			mapper.memberUpdate(member);
		}
	}

	@Override
	public String memberLogin(String id, String pass) {
		HashMap<String, String>map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pass", pass);
		String name = mapper.memberLogin(map);
		return name;
	}

	@Override
	public String memberDbcheck(String id) {
		String dbDouble = mapper.memberDbcheck(id);
		return dbDouble;
	}

	@Override
	public void memberDeleteFile(int num) {
		mapper.memberDeleteFile(num);
	}

	@Override
	public void memberUpdateFile(MemberVO member) {
		mapper.memberUpdateFile(member);
	}

}

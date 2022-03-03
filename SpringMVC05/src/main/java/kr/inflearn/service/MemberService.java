package kr.inflearn.service;

import java.util.List;

import kr.inflearn.model.MemberVO;
public interface MemberService {
	public List<MemberVO> memberList();
	public void memberInsert(MemberVO member, String mode);
	public void memberDelete(int num, String filename, String uploadPath)throws Exception;
	public MemberVO memberContent(int num);
	public void memberUpdate(MemberVO member, String mode);
	public String memberLogin(String id, String pass);
	public String memberDbcheck(String id);
	public void memberDeleteFile(int num);
	public void memberUpdateFile(MemberVO member);
}

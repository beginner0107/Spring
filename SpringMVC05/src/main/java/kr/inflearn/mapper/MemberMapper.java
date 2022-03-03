package kr.inflearn.mapper;

import java.util.HashMap;
import java.util.List;

import kr.inflearn.model.MemberVO;

public interface MemberMapper {
	public List<MemberVO> memberList();
	public void memberInsert(MemberVO member);
	public void memberInsertFile(MemberVO member);
	public void memberDelete(int num);
	public MemberVO memberContent(int num);
	public void memberUpdate(MemberVO member);
	public String memberLogin(HashMap<String, String>hashmap);
	public String memberDbcheck(String id);
	public void memberDeleteFile(int num);
	public void memberUpdateFile(MemberVO member);
}

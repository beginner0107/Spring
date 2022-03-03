package kr.bit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.bit.model.MemberVO;
@Mapper // MyBatis(SqlSessionFactory + SqlSession) 생략을 해도 큰 문제 X
public interface MemberMapper {
	@Select("select * from member")
	public List<MemberVO> memberList(); // -- SQL id="memberList"
	@Insert("Insert into member(id, pass, name, age, email, phone) values(#{id}, #{pass}, #{name}, #{age}, #{email}, #{phone})")
	public int memberInsert(MemberVO vo); // -- SQL id="memberInsert"
	@Update("update member set age=#{age}, email=#{email}, phone=#{phone} where num=#{num}")
	public int memberUpdate(MemberVO vo); // -- SQL id="memberUpdate"
	@Delete("delete from member where num=#{num}")
	public int memberDelete(int num); // -- SQL id="memberDelete"
	@Select("select * from member where num=#{num}")
	public MemberVO memberContent(int num); // -- SQL id="memberContent"
}

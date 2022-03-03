package kr.bit.model;
// mybatis

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class MemberDAO {
	@Autowired
	private SqlSessionFactory sqlSessionFactory; // [0 0 0 0 0]
	// config.xml 읽어야 함.
	
	// 회원 전체 리스트보기
	public List<MemberVO> memberList(){
		// Connection + Statement => SqlSession
		SqlSession session =  sqlSessionFactory.openSession();
//		session.selectList("Sql문장과 관련된 무언가");
		List<MemberVO>list =  session.selectList("memberList");
		session.close(); // 반납
		return list;
	}
	
	public int memberInsert(MemberVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.insert("memberInsert", vo);
		session.commit();
		session.close();
		return cnt;
	}
	
	public int memberUpdate(MemberVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.update("memberUpdate", vo);
		session.commit();
		session.close();
		return cnt;
	}
	
	public int memberDelete(int num) {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.delete("memberDelete", num);
		session.commit();
		session.close();
		return cnt;
	}
	
	public MemberVO memberContent(int num) {
		SqlSession session = sqlSessionFactory.openSession();
		MemberVO vo =  session.selectOne("memberContent", num);
		session.close();
		return vo;
	}
}

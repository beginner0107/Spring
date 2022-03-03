package kr.bit.model;
// mybatis

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {
	private static SqlSessionFactory sqlSessionFactory; // [0 0 0 0 0]
	// config.xml 읽어야 함.
	
	// 초기화 블럭 - 프로그램실행시 딱 한번만 실행되는 코드영역
	static {
		String resource = "kr/bit/mybatis/config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource); // 읽기
			sqlSessionFactory = 
					new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
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

	public String memberLogin(MemberVO vo) {
		SqlSession session = sqlSessionFactory.openSession();
		String user_name = session.selectOne("memberLogin", vo);
		session.close();
		return user_name;
	}
}

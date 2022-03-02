package kr.bit.model;
// JDBC -> MyBatis, JPA
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class MemberDAO {
	private Connection conn; 
	private PreparedStatement ps;
	private ResultSet rs;
	
	// 데이터베이스 연결객체 생성
	public void getConnect() {
		String URL = "jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "root";
		String password = "1234";
		// MySQL Driver Loading
		
		try {
			// 동적로딩(실행 시점에서 객체를 생성하는 방법)
			Class.forName("com.mysql.jdbc.Driver"); // 메모리에 로딩 -> 동적로딩 방법
			// 
			conn = DriverManager.getConnection(URL, user, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 회원저장 동작
	public int memberInsert(MemberVO vo) {
		// SQL에서 ?를 파라메터라고 함.
		String SQL = "INSERT INTO MEMBER (id, pass, name, age, email, phone) VALUES(?, ?, ?, ?, ?, ?)";
		getConnect();
		// SQL 문장을 전송하는 객체 생성
		int cnt = -1;
		try {
			ps = conn.prepareStatement(SQL); // 미리 컴파일을 시키는 것 (free compile)(속도가 빠르게)
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPass());
			ps.setString(3, vo.getName());
			ps.setInt(4, vo.getAge());
			ps.setString(5, vo.getEmail());
			ps.setString(6, vo.getPhone());
			
			cnt = ps.executeUpdate(); // 전송(실행) 
			// 성공하면 1 실패하면 0
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}
	// 회원 리스트 목록
	public ArrayList<MemberVO> memberList(){
		ArrayList<MemberVO>list = new ArrayList<MemberVO>();
		String SQL = "SELECT * FROM MEMBER";
		getConnect();
		try {
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			while(rs.next()) { // 선 조건
				int num = rs.getInt("num");
				String id = rs.getString("id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				MemberVO vo = new MemberVO(num, id, pass, name, age, email, phone);
				list.add(vo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}
	
	// 하나 select하기
	public MemberVO memberContent(int num) {
		MemberVO vo = new MemberVO();
		String SQL = "SELECT * FROM MEMBER WHERE NUM ="+ num;
		getConnect();
		try {
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			if(rs.next()) {
				vo.setNum(rs.getInt("num"));
				vo.setId(rs.getString("id"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setAge(rs.getInt("age"));
				vo.setPhone(rs.getString("phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return vo;
	}
	
	// 수정
	public int updateMember(MemberVO vo) {
		String SQL = "update member set age = ?, email = ?, phone = ?  where num = ?";
		getConnect();
		int cnt = -1;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, vo.getAge());
			ps.setString(2, vo.getEmail());
			ps.setString(3, vo.getPhone());
			ps.setInt(4, vo.getNum());
			cnt = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}
	
	// 삭제
	public int deleteMember(int num) {
		String SQL = "delete from member where num = " + num;
		getConnect();
		int cnt = -1;
		try {
			ps = conn.prepareStatement(SQL);
			cnt = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}
	
	// 데이터베이스 연결 끊기
	public void dbClose() {
		try {
			if(rs!=null) rs.close();
			if(ps!=null)ps.close();
			if(conn!=null)conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

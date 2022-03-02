<%@page import="kr.bit.model.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.bit.model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	// 1. 클라이언트의 요청을 받기(memberList.do)
	MemberDAO dao = new MemberDAO();
	// 2. 회원 전체 리스트 가져오기(Model 연동)
	ArrayList<MemberVO> list = dao.memberList();
%>
<!DOCTYPE html>
<html>
<head>
<title>회원 목록</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">
function deleteFn(num){
	location.href="memberDelete.jsp?num="+num; 
}
</script>
</head>
<body>
 <table class = "table table-bordered">
  <tr>
  	<th>번호</th>
  	<th>아이디</th>
  	<th>비밀번호</th>
  	<th>이름</th>
  	<th>나이</th>
  	<th>이메일</th>
  	<th>전화번호</th>
  	<th>삭제</th>
  </tr>
  <% 
  	for(MemberVO vo : list){%>
  		<tr>
  		  <td><%=vo.getNum() %></td>
  		  <td><a href = "memberContent.jsp?num=<%=vo.getNum()%>"><%=vo.getId() %></a></td>
  		  <td><%=vo.getPass() %></td>
  		  <td><%=vo.getName() %></td>
  		  <td><%=vo.getAge() %></td>
  		  <td><%=vo.getEmail() %></td>
  		  <td><%=vo.getPhone() %></td>
  		  <th><input type="button" value="삭제" onclick="deleteFn(<%=vo.getNum() %>)" class="btn btn-warning"></th>
  		</tr>
  	<%}
  %>
  <tr>
  	<td colspan="8" align="right">
  		<input type="button" value="회원가입" onclick="location.href='memberRegister.html'" class="btn btn-primary">
  	</td>
  </tr>
 </table>
</body>
</html>
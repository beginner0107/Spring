<%@page import="kr.bit.model.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.bit.model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }"/>
<%
	//ArrayList<MemberVO>list = (ArrayList<MemberVO>)request.getAttribute("list");
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
	location.href="${root}/memberDelete.do?num="+num; 
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
  <c:if test="${!empty list }">
  <c:forEach var="vo" items="${list }">
  		<tr>
  		  <td>${vo.num }</td>
  		  <td><a href = "/MVC04/memberContent.do?num=${vo.num }">${vo.id }</a></td>
  		  <td>${vo.pass }</td>
  		  <td>${vo.name }</td>
  		  <td>${vo.age }</td>
  		  <td>${vo.email }</td>
  		  <td>${vo.phone }</td>
  		  <th><input type="button" value="삭제" onclick="deleteFn(${vo.num})" class="btn btn-warning"></th>
  		</tr>
  </c:forEach>		
  </c:if>
  <c:if test="${empty list }">
  		<tr>
  		  <td colspan="8" align="center">회원 목록이 비어있습니다.</td>
  		</tr>
  </c:if>
  <tr>
  	<td colspan="8" align="right">
  		<input type="button" value="회원가입" onclick="location.href='${root}/memberRegister.do'" class="btn btn-primary">
  	</td>
  </tr>
 </table>
</body>
</html>
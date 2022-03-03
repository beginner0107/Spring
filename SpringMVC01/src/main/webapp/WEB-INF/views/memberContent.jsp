<%@page import="kr.bit.model.MemberVO"%>
<%@page import="kr.bit.model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }"/>
<%
	//MemberVO vo = (MemberVO)request.getAttribute("vo");
%>
<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="UTF-8">
<title>회원 상세보기</title>
</head>
<body>
  <form action="${root}/memberUpdate.do" method="post">
    <input type = "hidden" name = "num" value="${vo.num }" >
    <table class="table table-bordered">
      <c:if test="${vo!=null }">
      <tr>
        <td colspan="2">${vo.name } 회원의 상세보기</td>
      </tr>
      <tr>
      	<td>번호</td>
      	<td>${vo.num }</td>
      </tr>
      <tr>
      	<td>아이디</td>
      	<td>${vo.id }</td>
      </tr>
      <tr>
      	<td>비밀번호</td>
      	<td>${vo.pass }</td>
      </tr>
      <tr>
      	<td>이름</td>
      	<td>${vo.name }</td>
      </tr>
      <tr>
      	<td>나이</td>
      	<td><input type="text" name="age" value="${vo.age }"></td>
      </tr>
      <tr>
      	<td>이메일</td>
      	<td><input type="text" name="email" value="${vo.email }"></td>
      </tr>
      <tr>
      	<td>전화번호</td>
      	<td><input type="text" name="phone" value="${vo.phone }"></td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <input type = "submit" value="수정하기" class="btn btn-primary">
          <input type = "reset" value="취소하기" class="btn btn-warning">
          <input type = "button" value="리스트" class = "btn btn-info" onclick="location.href='${root}/memberList.do'">
        </td>
      </tr>
      </c:if>
    </table>
  </form> 
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원을 등록하는 UI</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
회원가입 화면
<form action="${root}/memberInsert.do" method = "post">
<table class="table table-bordered">
<colgroup>
<col style="width: 126px">
<col style="width: 699px">
</colgroup>
<tbody>
  <tr>
    <td class="tg-baqh">아이디</td>
    <td class="tg-0lax"><input type = "text" name = "id"></td>
  </tr>
  <tr>
    <td class="tg-baqh">패스워드</td>
    <td class="tg-0lax"><input type = "password" name = "pass"></td>
  </tr>
  <tr>
    <td class="tg-baqh">이름</td>
    <td class="tg-0lax"><input type = "text" name = "name"></td>
  </tr>
  <tr>
    <td class="tg-baqh">나이</td>
    <td class="tg-0lax"><input type = "text" name = "age"></td>
  </tr>
  <tr>
    <td class="tg-baqh">이메일</td>
    <td class="tg-0lax"><input type = "text" name = "email"></td>
  </tr>
  <tr>
    <td class="tg-baqh">전화번호</td>
    <td class="tg-0lax"><input type = "text" name = "phone"></td>
  </tr>
  <tr>
    <td class="tg-0lax" colspan="2" align="center">
    	<input type = "submit" value = "가입" class="btn btn-primary"/>
    	<input type = "reset" value = "취소" class="btn btn-warning"/>
    <br></td>
  </tr>
</tbody>
</table>
<div align="center">
<a href = "${root}/memberList.do">회원 목록</a>
</div>
</form>
</body>
</html>
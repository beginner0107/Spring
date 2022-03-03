<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<title>회원 목록</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
	table td{
			vertical-align: middle !important;
	}
</style>
<script type="text/javascript">
	$(function(){
		<c:if test="${!empty msg}">
				alert("${msg}");
				<c:remove var="msg" scope="session" />
		</c:if>
	});
	
	function deleteFn(num, filename){
		//alert(filename);
		if(filename!=''||filename!=null){
			// 파일 이름이 있는 경우
				location.href="${root}/member/delete.do?num="+num+"&filename="+filename;
		}else{
				location.href="${root}/member/delete.do?num="+num; 
		}
		//location.href="${root}/member/delete.do?num="+num; 
	}
	function check(){
		if($("#user_id").val().trim()==''){
				alert("아이디를 입력하세요");
				return false;
			}
		if($("#password").val().trim()==''){
				alert("비밀번호를 입력하세요");
				return false;
			}
		return true;
	}
	function logout(){
		location.href="<c:url value='/member/logout.do' />"; 
	}
</script>
</head>
<body>
<div class= "container">
	<h2>회원 관리 시스템</h2>
	<div class= "panel panel-default">
		<div class= "panel-heading">
			<c:if test="${sessionScope.userId==null || sessionScope.userId=='' }"> <!-- 세션 -->
		  <form class="form-inline" action="${root }/member/login.do" method="post">
			  <div class="form-group">
			    <label for="user_id">ID:</label>
			    <input type="text" class="form-control" id="user_id" name="user_id">
			  </div>
			  <div class="form-group">
			    <label for="password">Password:</label>
			    <input type="password" class="form-control" id="password" name="password">
			  </div>
			  <button type="submit" class="btn btn-default" onclick="return check()" >로그인</button>
			</form>
			</c:if>
			<c:if test="${sessionScope.userId!=null && sessionScope.userId!='' }">
			${sessionScope.userName }님 환영합니다.
			<button type="submit" class="btn btn-warning" onclick="logout()" >로그아웃</button>
			</c:if>
			</div>
		<div class= "panel-body">
			<div class="table-responsive">          
		      <table class="table table-hover">
		        <thead>
		          <tr>
		         		<th>번호</th>
						  	<th>아이디</th>
						  	<th>비밀번호</th>
						  	<th>이름</th>
						  	<th>나이</th>
						  	<th>이메일</th>
						  	<th>전화번호</th>
						  	<th>이미지</th>
						  	<th>삭제</th>
		          </tr>
			   		</thead>
				    <tbody>
						<c:if test="${!empty list }">
						  <c:forEach var="vo" items="${list }">
						  		<tr>
						  		  <td>${vo.num }</td>
						  		  <c:if test="${sessionScope.userId eq vo.id }">
						  		  	<td><a href = "${root }/member/memberContent.do?num=${vo.num }">${vo.id }</a></td>
						  		  </c:if>
						  		  <c:if test="${sessionScope.userId!=vo.id }">
						  		  	<td>${vo.id }</td>
						  		  </c:if>
						  		  <td>${vo.pass }</td>
						  		  <td>${vo.name }</td>
						  		  <td>${vo.age }</td>
						  		  <td>${vo.email }</td>
						  		  <td>${vo.phone }</td>
						  		  <td>
						  		  	<c:if test="${vo.filename !=null && vo.filename!='' }">
						  		  		<img src="${root}/<c:out value='file_repo/${vo.filename }'/>" width="60px" height="60px">
						  		  	</c:if>
						  		  </td>
						  		  <c:if test="${sessionScope.userId==vo.id }">
						  		  	<th><input type="button" value="삭제" onclick="deleteFn(${vo.num}, '${vo.filename }')" class="btn btn-warning"></th>
						  		  </c:if>
						  		   <c:if test="${sessionScope.userId!=vo.id }">
						  		 		 <th><input type="button" value="삭제" class="btn btn-warning" disabled="disabled"></th>
						  		  </c:if>
						  		</tr>
						  </c:forEach>		
						  </c:if>
						  <c:if test="${empty list }">
						  		<tr>
						  		  <td colspan="8" align="center">회원 목록이 비어있습니다.</td>
						  		</tr>
						  </c:if>
						  <c:if test="${sessionScope.userId==null || sessionScope.userId=='' }">
						  	<tr>
						  		<td colspan="9" align="left">
						  			<input type="button" value="회원가입" onclick="location.href='${root}/member/register.do'" class="btn btn-primary">
						  		</td>
						  	</tr>
							</c:if>
						  <c:if test="${sessionScope.userId!=''&& sessionScope.userId!=null }">
						  	<tr>
						  		<td colspan="9" align="right">
						  			<input type="button" value="자유게시판" onclick="location.href='${root}/board/list.do'" class="btn btn-primary">
						  		</td>
						  	</tr>
						  </c:if>
				    </tbody>
				  </table>
			</div>
		</div>
		<div class= "panel-footer">
			회원관리 ERP System(naver@naver.com)
		</div>
	</div>
</div>
</body>
</html>
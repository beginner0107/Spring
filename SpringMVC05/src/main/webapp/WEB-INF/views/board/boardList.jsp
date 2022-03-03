<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="root" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function(){
			$("#regBtn").click(()=>{
					location.href="<c:url value='/board/register.do'/>";
			});
	});
	
	function logout(){
		location.href="<c:url value='/member/logout.do' />"; 
	}
</script>
</head>
<body>
<div class="container">
  <h2>메인 화면</h2>
  <div class="panel panel-default">
    <div class="panel-heading">Spring Web MVC 게시판 만들기
    </div>
    <div class="panel-body">
    	 <div class="table-responsive">          
			  <table class="table">
			    <thead>
			      <tr>
			        <th>게시물 번호</th>
			        <th>제목</th>
			        <th>조회수</th>
			        <th>등록자</th>
			        <th>등록일</th>
			        <th>첨부파일</th>
			      </tr>
			    </thead>
			    <tbody>
			    <c:forEach var="vo" items="${list }">
			      <tr>
			        <td>${vo.idx }</td>
			        <td><a href="<c:url value='/board/get.do?bno=${vo.idx }'/>">${vo.title }</a></td>
			        <td>${vo.count }</td>
			        <td>${vo.writer }</td>
			        <td><fmt:formatDate pattern="yyyy-MM-dd" value="${vo.indate }"/></td>
			        <td>
			      </tr>
			    </c:forEach>
			    	<tr>
					    <c:if test="${sessionScope.userId!=''&& sessionScope.userId!=null }">
					    		<td colspan="5">
								  	<input type="button" value="회원리스트" onclick="location.href='${root}/member/list.do'" class="btn btn-info">
								  	<input type="button" value="로그아웃" onclick="logout()" class="btn btn-warning">
								  </td>
								  <td colspan="1" align="right">
								  	<input type="button" value="글쓰기" onclick="location.href='${root}/board/register.do'" class="btn btn-primary">
								  </td>
							</c:if>
						</tr>
			    </tbody>
			  </table>
		  </div>
    </div>
    <div class="panel-footer">인프런 화이팅
    </div>
  </div>
</div>
</body>
</html>
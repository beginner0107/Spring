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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function update(){
		document.form1.action="<c:url value='/memberUpdate.do' />";
		document.form1.submit();
	}
	function formreset(){
		document.form1.reset();
	}
</script>
<meta charset="UTF-8">
<title>회원 상세보기</title>
</head>
<body>
<div class="container">
	<h2>상세화면</h2>
  <div class="panel panel-default">
    <div class="panel-heading">
	    <c:if test="${sessionScope.userId!=null && sessionScope.userId!='' }">
			  <label>${sessionScope.userName }님 환영합니다.</label>
			</c:if>
			<c:if test="${sessionScope.userId==null || sessionScope.userId=='' }">
			  <h3>안녕하세요</h3>
			</c:if>
    </div>
    <div class="panel-body">
    <form id="form1" name="form1" class="form-horizontal"  method="post">
    	<input type = "hidden" name = "num" value="${vo.num }" >
    	<div class="form-group">
    		<label class="control-label col-sm-2">번호:</label>
    			<div class="col-sm-10">
    				<c:out value="${vo.num }" />
    			</div>
    	</div>
    	<div class="form-group">
    		<label class="control-label col-sm-2">아이디:</label>
    			<div class="col-sm-10">
    				<c:out value="${vo.id }" />
    			</div>
    	</div>
    	<div class="form-group">
    		<label class="control-label col-sm-2">비밀번호:</label>
    			<div class="col-sm-10">
    				<c:out value="${vo.pass }" />
    			</div>
    	</div>
    	<div class="form-group">
    		<label class="control-label col-sm-2">이름:</label>
    			<div class="col-sm-10">
    				<c:out value="${vo.name }" />
    			</div>
    	</div>
    	<div class="form-group">
    		<label class="control-label col-sm-2">나이:</label>
    			<div class="col-sm-10">
    				<input type="text" name="age" style="width: 10%;" value='<c:out value="${vo.age }" />'>
    			</div>
    	</div>
    	<div class="form-group">
    		<label class="control-label col-sm-2">이메일:</label>
    			<div class="col-sm-10">
    				<input type="text" name="email" value='<c:out value="${vo.email}" />'>
    			</div>
    	</div>
    	<div class="form-group">
    		<label class="control-label col-sm-2">전화번호:</label>
    			<div class="col-sm-10">
    				<input type="text" name="phone" value='<c:out value="${vo.phone}" />'>
    			</div>
    	</div>
    	</form>
    </div>
    <div class="panel-footer" style="text-align: center;">
    	<c:if test="${!empty sessionScope.userId }">
    		<c:if test="${sessionScope.userId==vo.id }">
    	 		<input type = "button" value="수정하기" class="btn btn-primary" onclick="update()">
    	 	</c:if>
    		<c:if test="${sessionScope.userId!=vo.id }">
    	 		<input type = "button" value="수정하기" class="btn btn-primary" onclick="update()" disabled="disabled">
    	 	</c:if>
    	</c:if>
       <input type = "button" value="취소하기" class="btn btn-warning" onclick="formreset()">
       <input type = "button" value="리스트" class = "btn btn-info" onclick="location.href='${root}/memberList.do'">
    </div>
  </div>
</div>
</body>
</html>
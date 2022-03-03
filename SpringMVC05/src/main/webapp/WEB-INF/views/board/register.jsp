<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function(){
			$("#list").click(()=>{
				location.href="<c:url value='/board/list.do'/>";
			});
	});
	
</script>
</head>
<body>
<div class="container">
	<h2>Board Register</h2>
  <div class="panel panel-default">
    <div class="panel-heading">Board Register</div>
    <div class="panel-body">
    	<form action="<c:url value='/board/register.do'/>" method="post" enctype="multipart/form-data">
			  <div class="form-group">
			    <label for="title">Title:</label>
			    <input type="text" class="form-control" id="title" name="title">
			  </div>
			  <div class="form-group">
			    <label for="contents">TextArea:</label>
			    <textarea class="form-control" rows="3" id="contents" name="contents"></textarea>
			  </div>
			  <div class="form-group">
			    <label for="writer">Writer:</label>
			    <input type="text" class="form-control" id="writer" name="writer" value="${sessionScope.userId }" readonly="readonly">
			  </div>
				<br/>
			  <button type="submit" class="btn btn-default">등록</button>
			  <button type="reset" class="btn btn-default">취소</button>
			  <button id="list" type="button" class="btn btn-info">리스트</button>
			</form>
    </div>
    <div class="panel-footer">인프런 화이팅</div>
  </div>
</div>
</body>
</html>
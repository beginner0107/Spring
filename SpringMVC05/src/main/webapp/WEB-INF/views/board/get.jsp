<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 조회 페이지</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
		$(function(){
				$("#list").click(()=>{
						location.href="<c:url value='/board/list.do'/>";
				});
				$("#modify").click(()=>{
						//var idx = $("#idx").val();
						//location.href="<c:url value='/modify.do'/>?bno="+idx;
						location.href="<c:url value='/board/modify.do'/>?bno=${board.idx}";
				});
		});
</script>
</head>
<body>
<div class="container">
	<h2>Board Read</h2>
  <div class="panel panel-default">
    <div class="panel-heading">Board Read Page</div>
    <div class="panel-body">
			 <div class="form-group">
			   <label for="title">Bno:</label>
			   <input type="text" class="form-control" id="idx" name="idx" value="${board.idx }" readonly="readonly">
			 </div>
			 <div class="form-group">
			   <label for="title">Title:</label>
			   <input type="text" class="form-control" id="title" name="title" value="${board.title }" readonly="readonly">
			 </div>
			 <div class="form-group">
 					<label for="contents">Text area:</label>
			    <textarea class="form-control" rows="3" id="contents" name="contents" readonly="readonly">${board.contents }</textarea>
			 </div>
			 <div class="form-group">
			   <label for="writer">Writer:</label>
			   <input type="text" class="form-control" id="writer" name="writer" value="${board.writer }" readonly="readonly">
			 </div>
			 <c:if test="${sessionScope.userId eq board.writer }">
			 		<button id="modify" class="btn btn-default">Modify</button>
			 </c:if>
			 <button id="list" class="btn btn-info">List</button>
    </div>
    <div class="panel-footer">인프런 화이팅</div>
  </div>
</div>
</body>
</html>
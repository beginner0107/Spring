<%@page import="kr.bit.model.MemberVO"%>
<%@page import="java.util.ArrayList"%>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
function deleteFn(num){
	location.href="${root}/memberDelete.do?num="+num; 
}
function btnClick(){
	$.ajax({
		url: "<c:url value='/memberAjaxList.do'/>",
		type: "get",
		dataType: "json",
		success : resultHtml,
		error : function(){alert("error");}
	});
}
function resultHtml(data){
	console.log(data);
	var html="<table class='table table-bordered'>";
	html+="<tr>";
  html+="<th>번호</th>";	
  html+="<th>아이디</th>";	
  html+="<th>비밀번호</th>";	
  html+="<th>이름</th>";	
  html+="<th>나이</th>";	
  html+="<th>이메일</th>";	
  html+="<th>전화번호</th>";	
  html+="</tr>";
  $.each(data, function(index, obj){
			html+="<tr>";
		  html+="<td>"+obj.num+"</td>";
			html+="<td>"+obj.id+"</td>";	  	
			html+="<td>"+obj.pass+"</td>";	  	
			html+="<td>"+obj.pass+"</td>"	;  	
			html+="<td>"+obj.age+"</td>";	  	
			html+="<td>"+obj.email+"</td>";	  	
			html+="<td>"+obj.phone+"</td>";	  	
		html+="</tr>";	
	});
	html+="</table>";
	
	$("#list").html(html);
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
  		  <td><a href = "${root }/memberContent.do?num=${vo.num }">${vo.id }</a></td>
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
  <tr>
  	<td colspan="8">
  		<input type="button" value="Ajax로 회원리스트보기" onclick="btnClick()"/>
  	</td>
  </tr>
 </table>
 <div id="list">여기에 회원리스트가 출력</div>
</body>
</html>
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
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	function add(){
		document.form1.action="<c:url value='/member/memberInsert.do' />";
		document.form1.submit();
	}
	function formreset(){
		document.form1.reset();
	}
	function doublecheck(){
		if($("#id").val()==''){
			//alert("/아이디를 입력하세요.");
			$("#id").focus();
			return;
		}
		var id=$("#id").val();
		$.ajax({
			url : "<c:url value='/member/memberDbcheck.do'/>",
			type : "POST",
			data : {"id" : id},
			success : dbCheck,
			error : function(){alert('error');}
		});
	}
	
	function dbCheck(data){
		console.log(data);
		if(data !="NO"){
				alert('중복된 아이디 입니다.');
				$("#id").val('');
				$("#id").focus();
		}else{
			alert('사용가능한 아이디입니다.')
			$("#id").focus();
		}
	}
	function add2(){
			if($("#file").val()!=''){ // 파일이 첨부가 된 경우 
				var formData = new FormData();
				//alert($("input[name=file]")[0].files[0]);
				formData.append("file", $("input[name=file]")[0].files[0]);
				$.ajax({
					url : "<c:url value='/fileAdd.do'/>", // fileAdd.do(파일업로드)
					type : "post",
					data : formData,
					processData : false,
					contentType : false,
					success : function(data){ // 업로드된 실재파일 이름을 전달 받기
						//alert(data);
						$("#filename").val(data);
						document.form1.action="<c:url value='/member/insert.do'/>?mode=fadd"; // text 데이터를 저장하는 부분
						document.form1.submit(); // id, pass, name, age, email, phone, filename
					},
					error : function(){alert("error");}
				});
			}else{ // 파일이 첨부 되지 않은 경우
				document.form1.action="<c:url value='/member/insert.do'/>?mode=add"; // text 데이터를 저장하는 부분
				document.form1.submit(); // id, pass, name, age, email, phone
			}
	}
</script>
</head>
<body>
<div class="container">
  <h2>회원가입화면</h2>
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
		  <form class="form-horizontal" id="form1" name="form1" method="post">
			    <div class="form-group">
					   <label class="control-label col-sm-2" for="id">아이디:</label>
					   <div class="col-sm-10">
					   		<table>
					   			<tr>
					   				<td><input type="text" class="form-control" id="id" placeholder="아이디를 입력하세요" name="id"></td>
					   				<td><input type="button" value="중복체크" onclick="doublecheck()" class="btn btn-warning" /></td>
					   			</tr>
					   		</table>
					     
					   </div>
					</div>
					<div class="form-group">
					   <label class="control-label col-sm-2" for="pass">비밀번호:</label>
					   <div class="col-sm-10">          
					     <input type="password" class="form-control" id="pass" placeholder="비밀번호를 입력하세요" name="pass" style="width: 30%;">
					   </div>
					</div>
					<div class="form-group">
					   <label class="control-label col-sm-2" for="name">이름:</label>
					   <div class="col-sm-10">          
					     <input type="text" class="form-control" id="name" placeholder="이름을 입력하세요" name="name" style="width: 30%;" >
					   </div>
					</div>
					<div class="form-group">
					   <label class="control-label col-sm-2" for="age">나이:</label>
					   <div class="col-sm-10">          
					     <input type="text" class="form-control" id="age" placeholder="나이입력" name="age" style="width: 15%;">
					   </div>
					</div>
					<div class="form-group">
					   <label class="control-label col-sm-2" for="email">이메일:</label>
					   <div class="col-sm-10">          
					     <input type="text" class="form-control" id="email" placeholder="이메일을 입력하세요" name="email"style="width: 30%;">
					   </div>
					</div>
					<div class="form-group">
					   <label class="control-label col-sm-2" for="phone">전화번호:</label>
					   <div class="col-sm-10">          
					     <input type="text" class="form-control" id="phone" placeholder="전화번호를 입력하세요" name="phone" style="width: 30%;">
					   </div>
					</div>
					<div class="form-group">
					   <label class="control-label col-sm-2" for="phone">첨부파일:</label>
					   <div class="col-sm-10">          
					     <input type="file" class="control-label" id="file" name="file">
					   </div>
					</div>
						<input type="hidden" name="filename" id="filename" value="" />
				</form>
			</div>	    
	   </div>
    <div class="panel-footer" style="text-align:center;">
		    <c:if test="${sessionScope.userId==null || sessionScope.userId=='' }">
		    	<input type = "button" value="등록" class="btn btn-primary" onclick="add2()">
				</c:if>
		    <c:if test="${sessionScope.userId!=null && sessionScope.userId!='' }">
		    	<input type = "button" value="등록" class="btn btn-warning" disabled="disabled">
				</c:if>
		    <input type = "button" value="취소하기" class="btn btn-warning" onclick="formreset()">
      	<input type = "button" value="리스트" class = "btn btn-info" onclick="location.href='${root}/member/list.do'">
    </div>
</div>
</body>
</html>
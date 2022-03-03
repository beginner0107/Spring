<h2>1. Servlet과 Model 회원관리(MVC01)</h2>

* Eclipse(GovFrameWork)
* JDK 8
* MYSQL 5.6.21
<br><br>

<h3>:books: 사용 Library :books:</h3>
* mysql-connector-java-5.1.31.jar

<h3>요구사항</h3>
1. 회원 가입<br>
2. 회원 목록<br>
3. 회원 정보 수정<br>
4. 회원 탈퇴<br>
5. 회원 상세 보기<br>
<br>

<h3>Member Table</h3>

```sql
-- member table 생성
create table member(
 num int primary key auto_increment,
 id varchar(20) not null,
 pass varchar(20) not null,
 name varchar(30) not null,
 age int not null,
 email varchar(30) not null,
 phone varchar(30) not null,
 unique key(id)
);
```

<br>
<h3>:memo:구조</h3>
<p>
<img width="176" alt="image" src="https://user-images.githubusercontent.com/81161819/156308915-7f9db4ba-6f45-4413-b34b-b911f0c6849d.png">&nbsp&nbsp&nbsp<img width="152" alt="image" src="https://user-images.githubusercontent.com/81161819/156308999-f0804b54-ccfc-40c3-ac83-2b02a441d85a.png">
</p>
<br>
1. JDBC를 통해 MYSQL과 연동 (MODEL) - MemberDAO<br>
2. 데이터를 주고 받을 MemberVO 생성<br>
3. Client 요청을 받을 각각의 CRUD Controller 생성
<br>

<h3>Servlet 구동원리</h3>
* Client 요청 -> HttpServlet을 상속받은 Controller(여러 개)를 호출 <br>
-> Read는 PrintWriter를 이용, Redirect 부분은 HttpServletResponse 객체를 이용해 처리. 
<br><br><br>
<h2>2. MVC Model 1 회원관리 (MVC02)</h2>
* Eclipse(GovFrameWork)<br>
* JDK 8<br>
* MYSQL 5.6.21<br>
<br><br>
<h3>요구사항</h3>
1. 회원 가입<br>
2. 회원 목록<br>
3. 회원 정보 수정<br>
4. 회원 탈퇴<br>
5. 회원 상세 보기<br>
<br>
<h3>Member Table</h3>
이전과 동일
<br>
<h3>:memo:구조</h3>
<p>
 <img width="229" alt="image" src="https://user-images.githubusercontent.com/81161819/156376065-7f9c4837-90d2-4ba8-b4c8-377dec070e1d.png">
</p>
<br>
1. JDBC를 통해 MYSQL과 연동 (MODEL) - MemberDAO<br>
2. 데이터를 주고 받을 MemberVO 생성<br>
3. JSP(<% %>스크립틀릿으로 작성)에서 Controller, View 역할을 담당한다. 
<br><br>
<h3>Model1 구동원리 (MVC02)</h3>
* Client 요청(JSP) -> JSP를 해석하여 Java코드로 변환시키고 MemberDAO와 연동하여 데이터를 받아온다. <br>
-> 받아온 데이터를 <%= %>를 통해 View를 완성 -> Client에게 응답. 
<br><br>

<h2>3. MVC MODEL 2 회원 관리(MVC03)</h2>

* Eclipse(GovFrameWork)
* JDK 8<br>
* MYSQL 5.6.21
<br><br>

<h3>:books: 사용 Library :books:</h3>
* mysql-connector-java-5.1.31.jar<br>
* jstl-1.2.jar

<h3>요구사항</h3>
1. 회원 가입<br>
2. 회원 목록<br>
3. 회원 정보 수정<br>
4. 회원 탈퇴<br>
5. 회원 상세 보기<br>
<br>

<h3>Member Table</h3>
이전과 동일
<br>
<h3>:memo:구조</h3>
<p>
<img width="206" alt="image" src="https://user-images.githubusercontent.com/81161819/156393764-d66f9f71-951b-493e-86b7-9368e173b34d.png">
</p>
<br>
1. JDBC를 통해 MYSQL과 연동 (MODEL) - MemberDAO<br>
2. 데이터를 주고 받을 MemberVO 생성<br>
3. Client 요청을 받을 각각의 CRUD Controller 생성
<br><br>

<h3>MODEL 2 구동원리</h3>
* Client 요청 -> HttpServlet을 상속받은 개별의 컨트롤러가 요청을 받는다<br>
 -> Controller는 원하는 데이터를 Model(MemberDAO)을 통해 가져오고 -> HttpServletRequest 객체에 담아 <br>
 -> RequestDispatcher 객체를 이용해 forward(객체 바인딩) 하여 원하는 Jsp에 데이터를 보낸 후 <br>
 -> request.getAttribute()해서 받거나, 또는 EL tag를 사용해서 {} 데이터를 View에 담아 <br>
 -> Client에게 응답한다.<br>
 <br>
 <img width="663" alt="image" src="https://user-images.githubusercontent.com/81161819/156395333-16e7b2e2-89bf-4f4e-bd9c-30778bf90cc4.png">
<br><br>



<h2>4. FrontController와 POJO를 이용한 MVC변형 (MVC04)</h2>
● Eclipse(GovFrameWork)<br>
● JDK 8<br>
● MYSQL 5.6.21
<br><br>
<h3>요구사항</h3>
1. 회원 가입<br>
2. 회원 목록<br>
3. 회원 정보 수정<br>
4. 회원 탈퇴<br>
5. 회원 상세 보기<br>
<br>
<h3>Member Table</h3>
이전과 동일
<br>
<h3>:memo:구조</h3>
<p>
<img width="224" alt="image" src="https://user-images.githubusercontent.com/81161819/156401086-8cbcf348-d237-45c5-95af-2d9537c0bcb9.png">
</p>
<br>
1. JDBC를 통해 MYSQL과 연동 (MODEL) - MemberDAO<br>
2. 데이터를 주고 받을 MemberVO 생성<br>
3. Client에 요청이 오면 제일 먼저 그 요청을 받아 분석할 FrontController 생성<br>
4. 겹치는 부분 HttpServletRequest, HttpServletResponse 부분을 Interface로 빼고 (Controller)<br>
5. 개별 CRUD Controller 생성하고 implement 상속하여 사용한다. <br>
<br><br>
<h3>FrontController 구동원리</h3>
* Client 요청 -> 제일 먼저 FrontController가 요청을 받아 분석<br>
-> 요청에 따른 분기 작업 -> HandlerMapping은 HashMap으로 이루어져 있어 요청이 넘어오면 분기해서 알맞은 Controller를 Return <br>
-> CRUD 작업이 이루어지고 JSP 페이지의 이름을 다시 FrontController로 넘겨준다 <br>
-> redirect와 forward를 분기하고 forward는 RequestDispatcher를 이용하여 이루어진다<br>
(ViewResolver가 "/WEB-INF/member/" + nextPage + ".jsp" 이런 형식으로 만들어 requestDispatcher(여기)에 넣어주게 된다) 
<br><br>


<h2>5. JDBC와 MyBatis 설정 (MVC05)</h2>
● Eclipse(GovFrameWork)<br>
● JDK 8<br>
● MYSQL 5.6.21
<br><br>
<h3>:books: 사용 Library :books:</h3>
● mysql-connector-java-5.1.31.jar<br>
● mybatis-3.4.6.jar<br>
● jstl-1.2.jar<br>

<h3>요구사항</h3>
1. 회원 가입<br>
2. 회원 목록<br>
3. 회원 정보 수정<br>
4. 회원 탈퇴<br>
5. 회원 상세 보기<br>
<br>
<h3>Member Table</h3>
이전과 동일
<br>
<h3>:memo:구조</h3>
<p>
<img width="232" alt="image" src="https://user-images.githubusercontent.com/81161819/156477329-61fdbbe4-32f1-4fd9-bee9-86e5f0c0a5e8.png">
</p>
<br>
1. Mybatis framework를 통해 MYSQL과 연동 (MODEL) - MemberDAO<br>
2. config.xml, db.properties, MemberMapper.xml 생성.<br>
<img width="739" alt="image" src="https://user-images.githubusercontent.com/81161819/156478221-f20c7782-cf88-4672-9cf3-304f9077ce89.png">
<br>
3. 데이터를 주고 받을 MemberVO 생성<br>
4. Client에 요청이 오면 제일 먼저 그 요청을 받아 분석할 FrontController 생성<br>
5. 겹치는 부분 HttpServletRequest, HttpServletResponse 부분을 Interface로 빼고 (Controller)<br>
6. 개별 CRUD Controller 생성하고 implement 상속하여 사용한다. <br>
<br><br>
<h3>FrontController 구동원리</h3>
(MVC04)와 동일
<br><br>


<h2>6. Session을 이용한 로그인 처리 (MVC06)</h2>
● Eclipse(GovFrameWork)<br>
● JDK 8<br>
● MYSQL 5.6.21
<br><br>
<h3>:books: 사용 Library :books:</h3>
● mysql-connector-java-5.1.31.jar<br>
● mybatis-3.4.6.jar<br>
● jstl-1.2.jar<br>

<h3>요구사항</h3>
1. 회원 가입<br>
2. 회원 목록<br>
3. 회원 정보 수정<br>
4. 회원 탈퇴<br>
5. 회원 상세 보기<br>
<br>
<h3>Member Table</h3>
이전과 동일
<br>
<h3>:memo:구조</h3>
<p>
<img width="218" alt="image" src="https://user-images.githubusercontent.com/81161819/156481455-730c2d47-76be-48b8-9712-e3c7cfe076ca.png"></p>
<br>
1. Mybatis framework를 통해 MYSQL과 연동 (MODEL) - MemberDAO<br>
2. config.xml, db.properties, MemberMapper.xml 생성.<br>
3. 데이터를 주고 받을 MemberVO 생성<br>
4. Client에 요청이 오면 제일 먼저 그 요청을 받아 분석할 FrontController 생성<br>
5. 겹치는 부분 HttpServletRequest, HttpServletResponse 부분을 Interface로 빼고 (Controller)<br>
6. 개별 CRUD Controller 생성하고 implement 상속하여 사용한다. <br>
7. 기존에 WebContent(=webapp)안에 넣어 놓으면 누구든지 접근이 가능하기 때문에 보안 X -> WEB-INF 안에 넣어준다. 
<br><br>
<h3>추가된 부분</h3>
1. MemberLoginController : request.getSession으로 세션을 가져오고 로그인이 성공하면 session.setAttribute<br>
2. MemberLogoutContorller : request.getSession().invalidate() 세션을 제거하면서 로그인 로그아웃 기능 
<br><br>


<h2>7. Ajax기술을 이용한 회원관리 및 파일 업로드 기능 구현 (MVC07)</h2>
● Eclipse(GovFrameWork)<br>
● JDK 8<br>
● MYSQL 5.6.21
<br><br>
<h3>:books: 사용 Library :books:</h3>
● mysql-connector-java-5.1.31.jar<br>
● mybatis-3.4.6.jar<br>
● jstl-1.2.jar<br>
● gson-2.8.5.jar<br>
● jstl-1.2.jar<br>
● commons-fileupload-1.3.3.jar<br>
● commons-io-2.6.jar<br>

<h3>요구사항</h3>
1. 회원 가입<br>
2. 회원 목록<br>
3. 회원 정보 수정<br>
4. 회원 탈퇴<br>
5. 회원 상세 보기<br>
<br>
<h3>Member Table</h3>
<pre>
<code>
create table member(
 num int primary key auto_increment,
 id varchar(20) not null,
 pass varchar(20) not null,
 name varchar(30) not null,
 age int not null,
 email varchar(30) not null,
 phone varchar(30) not null,
 filename varchar(100),
 unique key(id)
);
</code>
</pre>
<br>
<h3>:memo:구조</h3>
<p>
<img width="224" alt="image" src="https://user-images.githubusercontent.com/81161819/156485231-f1d50eb5-1e0c-4124-ac12-113abaf1ed9b.png"></p>
<br>
(MVC06)과 동일
<br><br>
<h3>추가된 부분</h3>
1. FileAddController : DiskFileItemFactory, ServletFileUpload 사용하여 파일 저장하고 파일 이름을 ajax로 return <br>
2. FileGetController : 첨부파일 다운로드를 담당하는 Controller<br>
3. FileDelController : 파일을 삭제 후 DB에 기록되어 있는 filename 삭제<br>
4. MemberDbcheckController : 회원가입 할 때 중복 체크 해주는 Controller<br>
<br><br>

<h2>8. 기존에 했던 프로젝트 변환하기(POJO 하나로 - Spring Legacy Project)(SpringMVC01)</h2>
● Eclipse(GovFrameWork)<br>
● JDK 1.8<br>
● MYSQL 5.6.21<br>
● springframework version 3.1.1.RELEASE
<br><br>
<h3>:books: 사용 Library(pom.xml) :books:</h3>
<p>
	<ul>
		<li>gson 2.8.5</li>
		<li>mysql-connector-java 5.1.31</li>
		<li>mybatis 3.4.5</li>
		<li>mybatis-spring 1.3.0</li>
		<li>spring-jdbc 3.1.1.RELEASE</li>
		</ul>
</p>
<h3>요구사항</h3>
이전과 동일(회원관리)
<br>
<h3>Member Table</h3>
(MVC06과 동일)
<br>
<h3>:memo:구조</h3>
<p>
 <img width="181" alt="image" src="https://user-images.githubusercontent.com/81161819/156490488-0d620557-d714-4b96-a355-f00b3fb5e5a7.png">

</p>
<br>
1. Controller를 하나로 만든다.(기존)<br>
2. WEB-INF/mybatis 폴더 생성. config.xml, db.properties 등록<br>
3. 같은 패키지 이름으로 kr.bit.mybatis 안에 MemberMapper.xml
<br><br>
<h3>기존 dynamic Web Project와 다른 점(편리한 점)</h3>
1. 여러개의 POJO를 하나로 줄일 수 있다. 메서드로 Mapping <br>
2. servlet.context-xml 안에 ViewResolver가 구현<br>
3. root.context-xml 안에 DB 설정(configLocation, mapperLocation등록)<br>
4. web.xml 접근 -> ContextLoaderListner가 root.context.xml 를 읽고 -> DispacherServlet이 servlet-context.xml을 읽고 DI작업을 해준다.(Bean 등록)
<br><br>


<h2>9. Mybatis 사용법 2가지, 다중파일업로드(SpringMVC02)</h2>
● Eclipse(GovFrameWork)<br>
● JDK 1.8<br>
● MYSQL 5.6.21<br>
● springframework version 3.1.1.RELEASE
<br><br>
<h3>:books: 사용 Library(pom.xml) :books:</h3>
<p>
<ul>
		<li>gson 2.8.5</li>
		<li>mysql-connector-java 5.1.31</li>
		<li>mybatis 3.4.5</li>
		<li>mybatis-spring 1.3.0</li>
		<li>spring-jdbc 3.1.1.RELEASE</li>
		<li>javax.servlet 3.1.0</li>
	<li>jackson-databind 2.6.3</li>
	<li>jackson-mapper-asl 1.9.13</li>
	<li>commons-fileupload 1.2.1</li>
	<li>commons-io 1.4</li>
</ul>
</p>
<h3>요구사항</h3>
이전과 동일(회원관리)
<br>
<h3>Member Table</h3>
(MVC06과 동일)
<br>
<h3>:memo:구조</h3>
<p>
<img width="203" alt="image" src="https://user-images.githubusercontent.com/81161819/156498855-6a970583-eef8-4903-a7f1-5333d4c901a6.png">
</p>
<br><br>
<h3>SpringMVC02에 추가된 부분</h3>
1. Mapper를 설정하는 두가지 방법 <br><br>
&nbsp 1) MemberMapper class와 MemberMapper.xml을 같은 위치에다가 놓고 sessionFacotry에 dataSource, configLocation, mapperLocation 등록<br><br>
&nbsp 2) MemberMapper class를 생성하고 어노테이션 @Select, @Insert, @Update("query"), root-context.xml -> sessionFactory에 mapperLocation빼고 등록<br><br>
2. Commons 파일 업로드<br><br>
&nbsp 1) uploadForm에서 다중파일을 업로드(enctype="multipart/form-data" -> Enumeration<String> e = multipartRequest.getParameterNames()<br><br>
&nbsp 2) HashMap에 속성(id,name)과 값(id="값", name="값")들을 저장.<br> <br>
&nbsp 3) 파일을 담고 있는 파라메터 읽어오기 Iterator it = multipartRequest.getFileNames();<br><br>
&nbsp 4) 반복문을 돌려 List에 파일 이름을 담는다. <br><br>
&nbsp 5) 파일의 업로드된 파일이름(getOriginalFilename)을 List에 저장하고 2)에서 만들었던 HashMap에 리스트를 넣는다.<br><br>
3. 다운로드<br><br>
&nbsp 1) filename을 매개변수로 받고<br><br>
&nbsp 2) response객체에 setContentLength, setContentType, setHeader 설정을 해준후<br><br>
&nbsp 3) FileInputStream, OutputStream, byte[]buffer = new byte[104]; 파일을 읽어(input) 다운로드(Output) 해준다. <br><br>
<br><br>
	
<h2>10. 게시판 CRUD(SpringMVC03)</h2>
● Eclipse(GovFrameWork)<br>
● JDK 1.8<br>
● MYSQL 5.6.21<br>
● springframework version 3.1.1.RELEASE
<br><br>
<h3>:books: 사용 Library(pom.xml) :books:</h3>
<p>
<ul>
		<li>gson 2.8.5</li>
		<li>mysql-connector-java 5.1.31</li>
		<li>mybatis 3.4.5</li>
		<li>mybatis-spring 1.3.0</li>
		<li>spring-jdbc 3.1.1.RELEASE</li>
		<li>javax.servlet 3.1.0</li>
	<li>jackson-databind 2.6.3</li>
	<li>jackson-mapper-asl 1.9.13</li>
	<li>commons-fileupload 1.2.1</li>
	<li>commons-io 1.4</li>
</ul>
</p>
<h3>요구사항</h3>
1. 게시글 리스트<br>
2. 게시글 상세보기<br>
3. 게시글 삭제, 수정<br>
4. 조회수 누적<br>
<br>
<h3>Board Table</h3>
<pre>
<code>
create table tb_board(
	idx int not null auto_increment, -- 자동증가(아이디)
	title varchar(100) not null, -- 제목
	contents varchar(4000) not null, -- 내용
	count int, -- 조회수
	writer varchar(30) not null, -- 작성자
	indate datetime default now() not null, -- 등록일
	primary key(idx)
)
</code>
</pre>
<br>
<h3>:memo:구조</h3>
<p>
<img width="196" alt="image" src="https://user-images.githubusercontent.com/81161819/156504130-bbdf0276-011d-45cb-bcc8-7d4ee7afa850.png">
</p>
<br><br>
<h3>SpringMVC03 이전 프로젝트와 다른 부분</h3>
1. 비즈니스 로직를 처리하는 Service클래스를 만들어서 사용한다. <br><br>
2. 조회수는 보통 쿠키를 이용해서 처리하지만 여기서는 간단하게 만들었기 때문에 조회수가 새로고침 시 계속 증가한다는 단점을 가지고 있다. <br><br>


<h2>11. 게시판 CRUD + 회원관리(SpringMVC05)</h2>
● Eclipse(GovFrameWork)<br>
● JDK 1.8<br>
● MYSQL 5.6.21<br>
● springframework version 3.1.1.RELEASE
<br><br>
<h3>:books: 사용 Library(pom.xml) :books:</h3>
<p>
<ul>
		<li>gson 2.8.5</li>
		<li>mysql-connector-java 5.1.31</li>
		<li>mybatis 3.4.5</li>
		<li>mybatis-spring 1.3.0</li>
		<li>spring-jdbc 3.1.1.RELEASE</li>
		<li>javax.servlet 3.1.0</li>
	<li>jackson-databind 2.6.3</li>
	<li>jackson-mapper-asl 1.9.13</li>
	<li>commons-fileupload 1.2.1</li>
	<li>commons-io 1.4</li>
</ul>
</p>
<h3>요구사항</h3>
1. 게시글 리스트, 비회원, 회원 모두 접근 가능<br>
2. 게시글 상세보기, 비회원, 회원 모두 접근 가능<br>
3. 게시글 삭제, 수정, 본인일 경우에만 삭제, 수정 가능<br>
4. 조회수 누적, 쿠키를 사용해서 24시간 유지<br>
5. 회원 가입 
6. 회원 상세보기
7. 회원 삭제, 수정(본인인 경우에만 가능)
<br>
<h3>Board Table</h3>
<pre>
<code>
create table tb_board(
	idx int not null auto_increment, -- 자동증가(아이디)
	title varchar(100) not null, -- 제목
	contents varchar(4000) not null, -- 내용
	count int, -- 조회수
	writer varchar(30) not null, -- 작성자
	indate datetime default now() not null, -- 등록일
	primary key(idx)
)
create table member1(
 num int primary key auto_increment,
 id varchar(20) not null,
 pass varchar(20) not null,
 name varchar(30) not null,
 age int not null,
 email varchar(30) not null,
 phone varchar(30) not null,
 filename varchar(100),
 unique key(id)
)
</code>
</pre>
<br>
<h3>:memo:구조</h3>
<p>
<img width="212" alt="image" src="https://user-images.githubusercontent.com/81161819/156505608-04dd5b80-bf22-42a3-8c44-f56f74571033.png">
</p>
<br><br>
<h3>SpringMVC05 이전 프로젝트와 다른 부분</h3>
1. 다른 점이 있다기 보다 {sessionScope.userId} seseionScope으로 가입된 상태를 유지하고 게시글 글을 작성하고 수정, 삭제가 가능하게 만들었다. <br><br>
2. 조회수를 쿠키를 통해 해결하였다. <br><br>


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
<br><br>
<h3>추가된 부분</h3>
1. MemberLoginController : request.getSession으로 세션을 가져오고 로그인이 성공하면 session.setAttribute
2. MemberLogoutContorller : request.getSession().invalidate() 세션을 제거하면서 로그인 로그아웃 기능 
<br><br>

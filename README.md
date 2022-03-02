<h2>1. Servlet과 Model로 회원관리 만들기(MVC01)</h2>

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
<h2>2. MVC Model 1 구조로 회원관리 만들기 (MVC02)</h2>
* Eclipse(GovFrameWork)
* JDK 8
* MYSQL 5.6.21
<br><br>
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
 <img width="229" alt="image" src="https://user-images.githubusercontent.com/81161819/156376065-7f9c4837-90d2-4ba8-b4c8-377dec070e1d.png">
</p>
<br>
1. JDBC를 통해 MYSQL과 연동 (MODEL) - MemberDAO<br>
2. 데이터를 주고 받을 MemberVO 생성<br>
3. JSP(<% %>스크립틀릿으로 작성)에서 Controller, View 역할을 담당한다. 
<br>
<h3>Model1 구동원리</h3>
* Client 요청(JSP) -> JSP를 해석하여 Java코드로 변환시키고 MemberDAO와 연동하여 데이터를 받아온다. <br>
-> 받아온 데이터를 <%= %>를 통해 View를 완성 -> Client에게 응답. 
<br><br>

<h2>2. MVC MODEL 2 회원 관리(MVC01)</h2>

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
<img width="206" alt="image" src="https://user-images.githubusercontent.com/81161819/156393764-d66f9f71-951b-493e-86b7-9368e173b34d.png">
</p>
<br>
1. JDBC를 통해 MYSQL과 연동 (MODEL) - MemberDAO<br>
2. 데이터를 주고 받을 MemberVO 생성<br>
3. Client 요청을 받을 각각의 CRUD Controller 생성
<br>

<h3>MODEL 2 구동원리</h3>
* Client 요청 -> HttpServlet을 상속받은 개별의 컨트롤러가 요청을 받는다<br>
 -> Controller는 원하는 데이터를 Model(MemberDAO)을 통해 가져오고 -> HttpServletRequest 객체에 담아 <br>
 -> RequestDispatcher 객체를 이용해 forward(객체 바인딩) 하여 원하는 Jsp에 데이터를 보낸 후 <br>
 -> request.getAttribute()해서 받거나, 또는 EL tag를 사용해서 {} 데이터를 View에 담아 <br>
 -> Client에게 응답한다.<br>
 <br>
 <img width="663" alt="image" src="https://user-images.githubusercontent.com/81161819/156395333-16e7b2e2-89bf-4f4e-bd9c-30778bf90cc4.png">

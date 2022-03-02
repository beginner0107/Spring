<h1>1. Servlet과 Model로 회원관리 만들기</h1>

* Eclipse(GovFrameWork)
* JDK 11
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

<h3>[Member] Table</h3>

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

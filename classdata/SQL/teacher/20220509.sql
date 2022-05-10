create table dept_temp as select * from dept;

insert into dept_temp (deptno, dname, loc) values (50,'DATABASE','SEOUL');
select * from dept_temp;

insert into dept_temp(deptno, dname, loc) values (60,'NETWORK');
insert into dept_temp(deptno, dname, loc) values (60,'NETWORK','BUSAN','WRONG');
insert into dept_temp(deptno, dname, loc) values ('WRONG','NETWORK','BUSAN');
insert into dept_temp(deptno, dname, loc) values (600,'NETWORK','BUSAN');

-- 10-4 (컬럼명 생략)
insert into dept_temp values (60, 'NETWORK','BUSAN');

-- 10-5 (null값 입력)
insert into dept_temp (deptno,dname,loc) 
values (70, 'WEB',null);

select * from dept_temp;

-- 10-6 (빈문자열)
insert into dept_temp (deptno,dname,loc) 
values (80, 'MOBILE','');

-- 컬럼명을 생략하지 않는 예
INSERT INTO 테이블명 (
    col1, col2, col3,
    col4, col5, col6,
    col7, col8, col9
) VALUES (
    val1, val2, val3,
    val4, val5, val6,
    val7, val8, val9
);

-- 10-7
insert into dept_temp (deptno, loc) values (90,'INCHEON');
select * from dept_temp;

-- 10-8
create table emp_temp as select * from emp where 1<> 1;
select * from emp_temp;

-- 10-9
insert into emp_temp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
values (9999,'홍길동','PRESIDENT',null,'2001/01/01',5000,1000,10);
select * from emp_temp;
insert into emp_temp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
values (1111,'성춘향','MANAGER',9999,'2001-01-05',4000,null,20);

insert into emp_temp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
values (2111,'이순신','MANAGER',9999,TO_DATE('07/01/2001','DD/MM/YYYY'),4000,null,20);
select * from emp_temp;

insert into emp_temp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
values (3111,'심청이','MANAGER',9999,sysdate,4000,null,30);
select * from emp_temp;

insert into emp_temp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
select e.empno, e.ename, e.job, e.mgr, e.hiredate, e.sal, e.comm, e.deptno
from emp e, salgrade s
where e.sal between s.losal and s.hisal
and s.grade=1;

select * from emp_temp;

create table dept_temp2 as select * from dept;
select * from dept_temp2;

-- where없음
update dept_temp2 set loc='SEOUL';
select *from dept_temp2;

rollback;

-- where 있음
update dept_temp2 set dname='DATABASE', loc='SEOUL' where deptno=40;
select *from dept_temp2;

-- subquery로 수정
update dept_temp2 set (dname, loc) =  (select dname, loc from dept where deptno=40)
where deptno=40;
select *from dept_temp2;

update dept_temp2 set loc='SEOUL'
where deptno=(select deptno from dept_temp2 where dname='OPERATIONS');

-- 조건 확인
select * from dept_temp2 where deptno=40;

create table emp_temp2 as select * from emp;
select * from emp_temp2;

delete from emp_temp2 where job='MANAGER';
select * from emp_temp2;


create table chap10hw_emp as select * from emp;
create table chap10hw_dept as select * from dept;
create table chap10hw_salgrade as select * from salgrade;

-- Q1
insert into chap10hw_dept(deptno,dname,loc)
values (50, 'ORACLE','BUSAN');
insert into chap10hw_dept(deptno,dname,loc)
values (60, 'SQL','ILSAN');
insert into chap10hw_dept(deptno,dname,loc)
values (70, 'SELECT','INCHEON');
insert into chap10hw_dept(deptno,dname,loc)
values (80, 'DML','BUNDANG');
select * from chap10hw_dept;

insert into chap10hw_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
values (7201, 'TEST_USER1', 'MANAGER', 7788, '2016-01-02', 4500, null, 50);
insert into chap10hw_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
values (7202, 'TEST_USER2', 'CLERK', 7201, '2016-02-21', 1800, null, 50);
insert into chap10hw_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
values (7203, 'TEST_USER3', 'ANALYST', 7201, '2016-04-11', 3400, null, 60);
insert into chap10hw_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
values (7204, 'TEST_USER4', 'SALESMAN', 7201, '2016-05-31', 2700, 300, 60);
insert into chap10hw_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
values (7205, 'TEST_USER5', 'CLERK', 7201, '2016-07-20', 2600, null, 70);
insert into chap10hw_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
values (7206, 'TEST_USER6', 'CLERK', 7201, '2016-09-08', 2600, null, 70);
insert into chap10hw_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
values (7207, 'TEST_USER7', 'LECTURE', 7201, '2016-10-28', 2300, null, 80);
insert into chap10hw_emp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
values (7208, 'TEST_USER8', 'STUDENT', 7201, '2018-03-09', 1200, null, 80);
select * from chap10hw_emp;

--Q3
update chap10hw_emp set
deptno=70
where sal > (select avg(sal) from chap10hw_emp where deptno=50);
select * from chap10hw_emp order by deptno;

--Q4
update chap10hw_emp set
sal = sal*1.1, deptno=80
where hiredate > (select min(hiredate) from chap10hw_emp where deptno=60);
select * from chap10hw_emp order by deptno;

--Q5
delete from chap10hw_emp
where empno in (
select empno
from chap10hw_emp e, chap10hw_salgrade s
where e.sal between s.losal and s.hisal
and s.grade=5);
select * from chap10hw_emp;

create table dept_tcl as select * from dept;
select * from dept_tcl;
insert into dept_tcl values (50, 'DATABASES', 'SEOUL');
update dept_tcl set loc='BUSAN' where deptno=40;
delete from dept_tcl where dname='RESEARCH';
select * from dept_tcl;

rollback;
select * from dept_tcl;

commit;
select * from dept_tcl;

-- savepoint(저장지점)
insert into dept_tcl values (60, 'AAA','SEOUL');
savepoint sp1;
insert into dept_tcl values (70, 'BBB','SEOUL');
savepoint sp2;
insert into dept_tcl values (80, 'CCC','SEOUL');
rollback to sp2; -- sp2지점 이전 commit
select * from dept_tcl;

commit;

update dept_tcl set loc='SEOUL' where deptno=30;
select * from dept_tcl;
commit;

create table emp_ddl(
    empno number(4),
    ename varchar2(10),
    job varchar2(9),
    mgr number(4),
    hiredate date,
    sal number(7,2),
    comm number(7,2),
    deptno number(2)
);
desc emp_ddl;

create table dept_ddl as select * from dept;
select * from dept_ddl;

create table emp_alter as select * from emp;

select * from emp_alter;

-- 컬럼추가
alter table emp_alter add hp varchar2(20);

-- 컬럼명 변경
alter table emp_alter rename column hp to tel;
select * from emp_alter;

-- 타입 수정
alter table emp_alter modify empno number(5);

-- 컬럼 삭제
alter table emp_alter drop column tel;

truncate table emp_alter2;
select * from emp_alter2;
-- 결과는 동일
-- 차이점(truncate은 DDL이므로 삭제 후 롤백 불가, 테이블용량 초기화)
delete from emp_alter2;

create index idx_emp_sal on emp(sal);
/*
인덱스
- 데이터를 빠르게 검색하기 위한 색인 기술
- B-tree(balanced tree) 자료구조(이진트리의 변형된 알고리즘) 사용
장점
- 검색속도 빨라짐
- 시스템 부하를 줄여(성능 향상)
단점
- 추가 저장공간 필요
- 인덱스 생성 시간 필요
- DML(insert, update, delete) 작업 시 성능 저하
*/

-- 실행 계획 (explain plan)
explain plan for select * from emp where ename = 'SCOTT';
select * from table(dbms_xplan.display);
-- F10(위에 왼쪽에서 3번째 아이콘)
select * from emp where ename = 'SCOTT';

-- 인덱스 생성
create index IDX_EMP_ENAME on emp (ename);

/*
인덱스를 적용할 컬럼?
- where 조건절에 자주 사용되는 컬럼
- 조인 조건에 사용되는 컬럼
- 두개 이상의 조건이 포함되는 경우 복합 인덱스 지정
- 복합 인덱스는 조회 조건이 모든 컬럼이 동시에 지정(복합인덱스-empno,sal, 조건-empno,sal)

* 주의 사항
- PK, UNIQUE 제약조건에서는 자동 생성
- 해당 컬럼을 가공하기 전 상태에서 조건 지정
- 인덱스 여부도 데이터 모델링 시 고려 필요
- LIKE는 인덱스 미적용 가능성 높음(%S%)
*/
-- emp테이블의 deptno를 인덱스 지정
create index idx_emp_deptno on emp(deptno);
select * from dept where deptno=20; -- unique scan
select * from emp where deptno=20; -- range scan
select * from emp where deptno is not null; -- full scan

-- 인덱스 스캔 유도
select /*+INDEX_RS*/
    deptno
from emp where deptno=20;

-- 이름의 첫자가 S인
select * from emp where substr(ename,1,1)='S'; -- 인덱스 미적용
select * from emp where ename like 'S%';

-- 복합인덱스
create index idx_emp_empnodeptno on emp(empno, deptno); -- 복합인덱스
select * from emp where empno=7788 and deptno=20; -- 개별인덱스
-- 복합인덱스 사용 시 조건의 앞에다가 PK로 지정

create view vw_emp20 as (select empno, ename, job ,deptno from emp where deptno=20);

-- 권한 부여 (grant)
-- sys가 testuser에게 create view 권한을 부여
-- grant create view to testuser;
select * from vw_emp20;
-- 권한 회수 (revoke)

select max(empno)+1 from emp;

create table dept_sequence as select * from dept where 1<> 1;
select * from dept_sequence;

-- 시퀀스 사용
-- 현재값 (currval)
select seq_dept_sequence.currval from dual;
-- 다음값 (nextval)
select seq_dept_sequence.nextval from dual;

insert into dept_sequence(deptno, dname, loc)
values (seq_dept_sequence.nextval, 'DATABASE','SEOUL');

select * from dept_sequence;

insert into dept (dname, loc) values ('ABC','DEF'); -- NOT NULL
insert into dept (deptno, dname, loc) values (10,'ABC','DEF'); -- UNIQUE

-- FK (참조열에 값이 존재하지 않는 경우)
insert into emp(empno, ename, job, mgr, hiredate, sal, comm, deptno)
values (9999,'홍길동','CLERK','7788','2017-04-30',1200,null,50);

-- 자식(emp테이블)에서 deptno(30)을 참조하고 있으면 삭제불가
-- 삭제하려면 emp의 deptno가 30인 모든 데이터를 삭제 후 dept테이블에서 삭제
delete from dept where deptno=30;

-- 10장 
-- 테이블 생성(DROP)
CREATE TABLE dept_temp AS SELECT * FROM dept;

-- 테이블 삭제 (DROP)
DROP TABLE dept_temp;
-- 테이블이 아닌 데이터를 삭제하는 경우에는 'DELETE' 명령어 사용

-- 테이블에 데이터 추가 (INSERT INTO, VALUES)
INSERT INTO dept_temp (deptno, dname, loc)
VALUES (50, 'DATABASE', 'SEOUL');

SELECT * from dept_temp;

-- COMMIT 하지 않으면 실제 DB에 저장되지 않음

-- INSERT문에서 자주 나는 오류들

INSERT INTO dept_temp (deptno, dname, loc) VALUES (60, 'NETWORK');                -- 컬럼 수 (3) > 데이터 수 (2) 
INSERT INTO dept_temp (deptno, dname, loc) VALUES (60, 'NETWORK', 'BUSAN', 'WRONG'); -- 컬럼 수 (3) > 데이터 수 (4)
-- 입력하는 컬럼 수와 데이터 수가 일치 하지 않을 경우

INSERT INTO dept_temp (deptno, dname, loc) VALUES ('WRONG', 'NETWORK', 'BUSAN');  -- 숫자형 => 문자형
INSERT INTO dept_temp (deptno, dname, loc) VALUES (600, 'NETWORK', 'BUSAN');      -- 2자리 => 3자리
--  컬럼에 명시된 자료형과 다른값이 입력될 경우

-- INSERT시 컬럼명을 생략이 가능하나 열에 들어갈 모든 데이터를 순서대로 입력해야한다.
INSERT INTO dept_temp VALUES (60, 'NETWORK', 'BUSAN');
SELECT * FROM dept_temp;

/*    NULL 입력하기    */
-- NULL 값을 지정하여 입력하기
INSERT INTO dept_temp (deptno, dname, loc) VALUES (70, 'WEB', NULL);
SELECT * FROM dept_temp;
-- 빈 문자열로 NULL 입력하기
INSERT INTO dept_temp (deptno, dname, loc) VALUES (80, 'MOBILE', '');
SELECT * FROM dept_temp;
-- 컬럼명을 생략해서 NULL 입력하기
INSERT INTO dept_temp (deptno, loc) VALUES (90, 'INCHEON');
SELECT * FROM dept_temp;
-- 보통 공백으로 NULL값을 입력하기보다는 NULL을 지정하거나 열을 지정하지 않는 방식으로 NULL을 입력함

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


-- 테이블 형태만 복사하기 (데이터는 복사X)
CREATE TABLE emp_temp 
    AS SELECT * 
        FROM emp 
        WHERE 1 <> 1;  -- 1 <> 1은 항상 FALSE이기 때문에 데이터는 입력이 안됨
        
SELECT * FROM emp_temp;

-- 날짜 데이터 입력하기
-- 날짜 형식에 맞춰서 입력하면 됨
-- (1)
INSERT INTO emp_temp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
VALUES (9999, '홍길동', 'PRESIDENT', NULL, '2001/01/01', 5000, 1000, 10);
-- (2)
INSERT INTO emp_temp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
VALUES (1111, '성춘향', 'MANAGER', 9999, '2001-01-05', 4000, NULL, 20);

SELECT * FROM emp_temp;

-- (3) 날짜형식을 인식하지 못할경우 TO_DATE를 사용해서 날짜표기방식 알려주기
INSERT INTO emp_temp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
VALUES (2111, '이순신', 'MANAGER', 9999, TO_DATE('07/01/2001', 'dd/mm/yyyy'), 4000, NULL, 20);

SELECT * FROM emp_temp;
-- (4) SYSDATE를 사용하여 날짜 입력하기
INSERT INTO emp_temp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
VALUES (3111, '심청이', 'MANAGER', 9999, SYSDATE, 4000, NULL, 30);

SELECT * FROM emp_temp;

-- 서브쿼리를 이용해서 데이터 입력하기 -> VALUES절 사용 X
INSERT INTO emp_temp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
    SELECT e.empno, e.ename, e.job, e.mgr, e.hiredate, e.sal, e.comm, e.deptno
    FROM emp e, salgrade s
    WHERE e.sal BETWEEN s.losal AND s.hisal
    AND s.grade = 1;
    
SELECT * FROM emp_temp;


-- 데이터 수정하기 (UPDATE)
/* UPDATE 테이블명 SET 컬럼명=데이터, 컬럼명=데이터 WHERE ~  (WHERE절은 생략가능*/
CREATE TABLE dept_temp2 AS SELECT * FROM dept;
SELECT * FROM dept_temp2;

-- WHERE 없음 => 테이블 안에 모든 데이터가 바뀜 (조심해서 다뤄야함! ★★★★)
UPDATE dept_temp2 SET loc='SEOUL';
SELECT * FROM dept_temp2;

-- 롤백기능 : 수정한 내용을 원상태로 되돌림 (INSERT, UPDATE, DELETE 실행 취소)
-- TCL명령어 중 하나임
-- CREATE문을 하는 순간 자동으로 commit이 됨 -> CREATE 이전 실행문들은 롤백이 안됨
ROLLBACK;

UPDATE dept_temp2 
SET 
    dname = 'DATABASE', 
    loc = 'SEOUL' 
WHERE deptno = 40;

SELECT * FROM dept_temp2;

-- 서브쿼리로 데이터를 수정하기
UPDATE dept_temp2
SET
    (dname, loc) = (SELECT dname, loc
                    FROM dept
                    WHERE deptno = 40)
WHERE deptno=40;

SELECT * FROM dept_temp2;

-- WHERE절에 서브쿼리 사용
UPDATE dept_temp2
SET loc = 'SEOUL'
WHERE deptno = (SELECT deptno
                FROM dept_temp2
                WHERE dname = 'OPERATIONS');

/* 실수하지 않는 방법*/
-- 조건확인 후에 수정 진행해라
SELECT * FROM dept_temp2 WHERE deptno = 40;


/* 데이터 삭제하기 */

-- 테이블 복사
CREATE TABLE emp_temp2 AS SELECT * FROM emp;
SELECT * FROM emp_temp2;

-- DELECT FROM 테이블명 WHERE 조건
DELETE FROM emp_temp2 WHERE job = 'MANAGER';
SELECT * FROM emp_temp2;



/* 10장 연습문제*/

CREATE TABLE chap10hw_emp AS SELECT * FROM emp;
CREATE TABLE chap10hw_dept AS SELECT * FROM dept;
CREATE TABLE chap10hw_salgrade AS SELECT * FROM salgrade;

-- Q1
INSERT INTO 
chap10hw_dept (deptno, dname, loc)
VALUES (50, 'ORACLE', 'BUSAN');

INSERT INTO chap10hw_dept (deptno, dname, loc) VALUES (60, 'SQL', 'ILSAN');
INSERT INTO chap10hw_dept (deptno, dname, loc) VALUES (70, 'SELECT', 'INCHEON');
INSERT INTO chap10hw_dept (deptno, dname, loc) VALUES (80, 'DML', 'BUNDANG');

SELECT * FROM chap10hw_dept;

-- Q2
INSERT INTO chap10hw_emp
VALUES (7201, 'TEST_USER1', 'MANAGER', 7788, '2016-01-02', 4500, null, 50);
INSERT INTO chap10hw_emp
VALUES (7202, 'TEST_USER2', 'CLERK', 7201, '2016-02,21',1800, null, 50);
INSERT INTO chap10hw_emp
VALUES (7203, 'TEST_USER3', 'ANALYST', 7201, '2016-04-11', 3400, null, 60);
INSERT INTO chap10hw_emp
VALUES (7204, 'TEST_USER4', 'SALESMAN', 7201, '2016-05-31', 2700, 300, 60);
INSERT INTO chap10hw_emp (empno, ename, job, mgr, hiredate, sal, deptno)
VALUES (7205, 'TEST_USER5', 'CLERK', 7201, '2016-07-20', 2600, 70);
INSERT INTO chap10hw_emp
VALUES (7206, 'TEST_USER6', 'CLERK', 7201, '2016-09-08', 2600,null, 70);
INSERT INTO chap10hw_emp
VALUES (7207, 'TEST_USER7', 'LECTURER', 7201, '2016-10-28', 2300, NULL, 80);
INSERT INTO chap10hw_emp
VALUES (7208, 'TEST_USER8', 'STUDENT', 7201, '2018-03-09', 1200, NULL, 80);
SELECT * FROM chap10hw_emp;

-- Q3
SELECT deptno, AVG(sal) FROM chap10hw_emp WHERE deptno=50 GROUP BY deptno;

UPDATE chap10hw_emp
SET deptno = 70
WHERE sal > (SELECT AVG(sal) 
                FROM chap10hw_emp
                WHERE deptno = 50
                GROUP BY deptno);
SELECT * FROM chap10hw_EMP ORDER BY deptno;


-- Q4
SELECT MIN(hiredate) 
FROM chap10hw_emp
WHERE deptno = 60;

UPDATE chap10hw_emp
SET deptno = 80,
    sal = sal * 1.1
WHERE hiredate >  (SELECT MIN(hiredate) 
                    FROM chap10hw_emp
                    WHERE deptno = 60);
    
SELECT * FROM chap10hw_emp ORDER BY deptno;


-- Q5
SELECT empno
FROM chap10hw_emp, chap10hw_salgrade
WHERE sal BETWEEN losal AND hisal
AND grade = 5;

DELETE FROM chap10hw_emp
    WHERE empno IN (SELECT empno
                    FROM chap10hw_emp, chap10hw_salgrade
                    WHERE sal BETWEEN losal(+) AND hisal(+)
                    AND grade = 5);
                    

SELECT * FROM chap10hw_emp;


/*  11장 트랜잭션 제어와 세션   */
/*
트랜잭션 : 더 이상 분할할 수 없는 최소 수행단위, 논리적인 작업단위

ALL or NOTHING
- 하나의 트랜잭션 내에 있는 여러 명령어를 한번에 수행하여 작업을 완료하거나 모든 작업을 취소한다.

TCL : 트랜잭션을 제어하기 위해 사용하는 명령어 (명령어 예 - COMMIT, ROLLBACK)


접속 => 세션 (접속되어있는 상태)
*/

CREATE TABLE dept_tcl AS SELECT * FROM dept;
SELECT * FROM dept_TCL;

INSERT INTO dept_tcl VALUES (50, 'DATABASE', 'SEOUL');
UPDATE dept_tcl SET loc = 'BUSAN' WHERE deptno = 50;
DELETE FROM dept_tcl WHERE dname = 'RESEARCH';
SELECT * FROM dept_tcl;

ROLLBACK; -- 트랜잭션을 취소하는 명령어
COMMIT;  -- 트랜잭션을 영원히 반영하는 명령어
-- COMMIT으로 반영된 내용은 되돌릴 수 없으므로 신중하게 진행해야함!!

-- SAVEPOINT : ROLLBACK 명령어로 작업을 취소할 때 취소할 지점을 지정할 수 있음 (ROLLBACK TO ~)

INSERT INTO dept_tcl VALUES (60, 'AAA', 'SEOUL');
SAVEPOINT sp1;
INSERT INTO dept_tcl VALUES (70, 'BBB', 'SEOUL');
SAVEPOINT sp2;
INSERT INTO dept_tcl VALUES (80, 'CCC', 'SEOUL');
ROLLBACK TO sp2;

SELECT * FROM dept_tcl;

COMMIT;
-- 세션 (session) : 접속 시작부터 접속 종료까지의 전체기간
-- "세션이 여러개" -> 현재 서버에 접속해있는 연결이 여러개 있다는 의미
-- 같은 계정이라도 접속방법이 다르면 다른 세션임

-- 조회 일관성(Read Consistency, ★★) : 트랜잭션이 완료되기 전까지 다른 세션에서는 데이터 조작 전 상태의 내용이 일관적으로 조회, 출력, 검색되는 특성


-- LOCK : 하나의 데이터를 여러 곳에서 동시에 조작하려 할 때 발생할 혼란을 막기 위한 요소
UPDATE dept_tcl SET loc = 'SEOUL' WHERE deptno = 30;
SELECT * FROM dept_tcl;
COMMIT;


/*
LOCK : 하나의 데이터를 여러 곳에서 동시에 조작하려 할 때 발생할 혼란을 막기 위한 요소

행 레벨 록 (row level lock) 
 - where절을 통해 특정 데이터를 조작할 경우 해당 조건에 속하는 행만 lock이 걸림
 - table 전체 행이 lock이 걸린 경우에도 insert문은 수행이 가능함

테이블 레벨 록 (table level lock)
 - 행의 수와 상관없이 데이터가 변경 중인 테이블은 table 자체에 lock이 걸림 (table단위 잠금)
*/


/*     12장 데이터 정의어(DDL) - (테이블 관련 데이터 정의어)    */

-- CREATE, ALTER, DROP 와 같은 DDL 실행은 COMMIT와 같은 효과를 나타냄

CREATE TABLE EMP_DDL (
    empno   NUMBER(4),
    ename   VARCHAR2(10),
    job     VARCHAR2(9),
    mgr     NUMBER(4),
    hiredate DATE,
    sal     NUMBER(7,2),
    comm    NUMBER(7,2),
    deptno  NUMBER(2)
);

DESC emp_DDL;

CREATE TABLE dept_ddl AS SELECT * FROM dept;
SELECT * FROM dept_ddl;

-- ALTER : 테이블을 변경하는 명령어
CREATE TABLE emp_alter AS SELECT * FROM emp;
SELECT * FROM emp_alter;

-- ADD : 테이블에 열 추가하는 명령어 (ATLER과 함께 사용)
ALTER TABLE emp_alter ADD hp VARCHAR2(20);

-- RENAME : 열의 이름을 변경하는 명령어 (ATLER과 함께 사용)
ALTER TABLE emp_alter RENAME COLUMN hp to TEL;

-- MODIFY : 열의 자료형을 변경하는 명령어 (ALTER과 함께 사용)
ALTER TABLE emp_alter MODIFY empno NUMBER(5);
desc emp_alter;

-- DROP COLUMN : 특정 열을 삭제하는 명령어 (ALTER과 함께 사용)
ALTER TABLE emp_alter DROP COLUMN tel;


-- 테이블의 데이터를 삭제하는 TRUNCATE
TRUNCATE TABLE emp_alter;
SELECT * FROM emp_ALTER;
-- TRUNCATE 와 결과는 같음
DELETE FROM emp_ALTER2; 

-- 차이점 
-- 1. TRUNCATE는 DDL이므로 삭제 후 롤백 불가, DELETE는 롤백 가능
-- 2. 테이블 용량이 초기화 됨, DELETE는 용량이 사라지지 않음
-- 3. DROP TABLE : 테이블 자체를 삭제


/*    13장 - 객체 종류    */

/*인덱스 (★★★★★)
PK(기본키) or 고유키(Unique key)일 경우에 인덱스는 자동으로 생성됨
인덱스 : 데이터를 빠르게 검색하기 위한 색인 기술
B-tree(Balanced tree) 자료구조(이진트리의 변형된 알고리즘) 사용

장점
- 검색속도 빨라짐
- 시스템 부하를 줄여줌 (성능 향상)

단점 
- 추가 저장공간 필요
- 인덱스 생성 시간 필요
- DML(INSERT, UPDATE, DELETE) 작업시 성능 저하
*/
CREATE INDEX idx_emp_sal ON EMP(sal);


-- 실행 계획 (explain plan)
EXPLAIN PLAN for SELECT * FROM emp WHERE ename = 'SCOTT';
SELECT * FROM table(dbms_xplan.display);

-- Cost가 높다는 건 느리다는 의미
-- F10키 - 위에 왼쪽에서 3번째 아이콘 ("계획 설명")
SELECT * FROM emp WHERE ename = 'SCOTT';

-- 인덱스 생성
CREATE index IDX_emp_Ename on emp (ename);

/*
인덱스를 적용할 컬럼 (?)
- WHERE 조건절에서 자주 사용되는 컬럼
- 조인 조건에 사용되는 컬럼
- 두개 이상의 조건이 포함되는 경우 -> 복합 인덱스 지정
- 복합 인덱스는 조회 조건이 모든 컬럼이 동시에 지정되어야 함 (복합인덱스 - empno, sal => 조건 - empno, sal)

* 주의사항
- PK, UNIQUE 제약조건에서는 자동 생성
- 해당 컬럼을 가공하기 전 상태에서 조건 지정해야함 -> 함수를 사용해서 데이터를 가공한 결과값은 인덱스 X
- 인덱스 여부도 데이터 모델링 시 고려 필요함
- LIKE는 인덱스 미적용 가능성 높음(예 - %s%)
*/

-- emp 테이블의 deptno를 인덱스 지정
CREATE INDEX idx_emp_deptno ON emp(deptno);
SELECT * FROM dept WHERE deptno = 20; -- unique scan
SELECT * FROM emp WHERE deptno = 20; -- range scan
SELECT * FROM emp WHERE deptno IS NOT NULL; -- full scan

-- 인덱스 스캔 유도
SELECT      /*+INDEX_RS*/ 
    deptno
FROM emp WHERE deptno = 20;

-- 이름의 첫자가 S인
SELECT * FROM emp WHERE SUBSTR(ename, 1, 1)='S'; -- 인덱스 미적용 (가공과정을 거쳤기 때문)
SELECT * FROM emp WHERE ename LIKE 'S%'; -- Range scan


-- 복합 인덱스
SELECT * FROM emp WHERE empno = 7788 AND deptno=20; -- 개별 인덱스 (EMPno, deptno 각각 개별 인덱스)

CREATE INDEX idx_emp_empnodeptno ON emp(empno, deptno); -- 복합인덱스 생성
SELECT * FROM emp WHERE empno = 7788 AND deptno=20; 

-- 복합인덱스 사용시 조건의 앞에다가 PK로 지정해야 효과가 있음 (위에서는 empno가 PK임)


/*  뷰 (VIEW)

정규화 : 테이블을 쪼개는 행위  (시험에 나오는 내용, 따로 공부할 것)
- join을 해야함
1차 정규화 : 
2차 정규화 : 
3차 정규화 : 

반정규화 : 테이블을 합치는 행위
- join할 필요가 없음
- 중복을 줄이고, 조회속도를 향상시킴

테이블을 join하면 속도가 느려지는 단점이 있음 
따라서 초기에 view를 만들어줘서 매번 join을 해야하는 것을 막음 (속도 개선효과)

뷰의 사용 목적 
1. 편리성
2. 보안성 (각 테이블에 대한 접근권한 X, 만들어진 view 테이블에만 접근권한이 있음)
3. 속도개선

*/


CREATE VIEW VM_EMP20
    AS (SELECT empno, ename, job, deptno
        FROM emp
        WHERE deptno = 20);
        -- 오류 : 권한이 불충분합니다. (sys가 권한을 부여해준 뒤 실행)

-- 권한 부여 (GRANT)
-- sys가 testuser에게 create view 권한을 부여해야함 (GRANT CREATE VIEW TO testuser;)
SELECT 1000 FROM vm_emp20;
-- 권한 회수 (REVOKE)



-- 시퀀스 (sequence)

-- 예전방식
SELECT MAX(empno)+1 FROM emp;   -- 다음번호를 부여할 값 확인하기
INSERT INTO emp .... ;          -- 확인된 번호를 통해서 데이터 삽입하기

-- 현재 방식 -> 시퀀스 생성


CREATE TABLE dept_sequence AS SELECT * FROM dept WHERE 1 <> 1;  -- 실무에서 이런식으로 테이블 복사할 경우 제약조건 설정이 되지 않음
SELECT * FROM dept_sequence;

-- 시퀀스 사용방법
-- 현재값 (currval)
SELECT seq_dept_sequence.currval FROM dual;  -- 처음에는 아직 값이 없어서 에러남
-- 다음값 (nextval)
SELECT seq_dept_sequence.nextval FROM dual;

INSERT INTO dept_sequence (deptno, dname, loc)
VALUES (seq_dept_sequence.nextval, 'DATABASE', 'SEOUL');

SELECT * FROM dept_sequence;

/*       14장
제약조건

종류
- NOT NULL : null값 허용하지 X
- UNIQUE : 중복 X
- PRIMARY KEY : not null + unique + index 지정
- FOREIGN KEY : 다른 테이블의 열을 참조하는 키
- CHECK : 설정한 조건식은 만족하는 데이터만 입력 가능


데이터 무결성(Data intefrity) : 데이터의 정확성과 일관성을 보장
- 영역 무결성(domain integrity) 
- 개체 무결성(entity integrity) 
- 참조 무결성(referential integrity)
*/

INSERT INTO dept (dname, loc) VALUES ('ABC', 'DEF'); -- 오류 발생(NOT NULL) : 기본키가 있는 열에 데이터를 입력하지 않았기 때문
INSERT INTO dept (deptno, dname, loc) VALUES (10, 'ABC', 'DEF'); -- 오류 발생(UNIQUE) : 기본키 열에 이미 동일한 값이 존재함


-- 외래키 (FOREIGN KEY)
INSERT INTO emp(empno, ename, job, mgr, hiredate, sal, comm, deptno)
VALUES (9999, '홍길동', 'CLERK', '7788', TO_DATE('2017/04/30', 'YYYY/MM/DD'), 1200, NULL, 50); 
-- 오류 발생 "무결성제약조건(FK_DEPTNO) 위배 - 부모키가 없습니다."
-- 외래키가 참조하는 dept테이블에 50이 없기때문에 오류 발생

DELETE FROM dept WHERE deptno=30;
-- 오류 발생 "무결성제약조건(FK_DEPTNO) 위배 - 자식 레코드가 발견되었습니다."
-- 자식(emp 테이블)에서 deptno(30)을 참조하고 있으면 삭제 불가
-- 삭제하려면 emp의 deptno가 30인 모든 데이터를 삭제 후 dept 테이블에서 삭제가 가능함

-- CASCADE : 열 데이터를 삭제할 때 참조하고 있는 데이터도 함께 삭제
-- CONSTRAINT [제약조건 이름] REFERENCES 참조테이블 (참조할 열) ON DELETE CASCADE 

-- SET NULL : 열 데이터를 삭제할때 참조하고 있는 데이터를 NULL로 수정
-- CONSTRAINT [제약조건 이름] REFERENCES 참조테이블 (참조할 열) ON DELETE SET NULL



/* 15장 권한 관리


계정 생성 - SYS계정에서 진행 
CREATE USER C##ORCLSTUDY IDENTIFIED BY oracle;
-- 사용자 계정명 앞에 'C##'이 있어야 만들 수 있음

-- C##을 없앤 계정을 만들수 있는 명령어
ALTER SESSION SET "_oracle_script"=true;
CREATE USER ORCLSTUDY IDENTIFIED BY oracle;

계정에 권한 부여 - SYS계정에서 진행 
GRANT CREATE SESSION TO orclstudy;
*/


-- 시스템권한, 객체권한

/*
orclstudy 계정 워크시트에서 TESTUSER 스키마(사용자)의 emp 테이블을 조회할 경우
SELECT * FROM testuser.emp; 
-- 권한이 없는 경우 오류 발생 : 테이블 또는 뷰가 존재하지 않습니다. 
 
-- orclstudy 계정에게 testuser에 있는 emp테이블의 select 권한 부여 (sys계정)
GRANT SELECT ON TESTUSER.emp TO orclstudy;

-- 권한 회수 (sys계정)
REVOKE SELECT ON testuser.emp FROM orclstudy;
*/

-- 롤 : 여러 권한을 한번에 부여하고 해제할 수 있도록 여러 권한을 묶어놓은 그룹

-- 직원 테이블에서 직원명 조회

SELECT 
    DISTINCT deptno
FROM emp
    WHERE deptno >= 20;
    
    
select distinct deptno from emp;
select deptno from emp group by dept;
select distinct job, deptno from emp;

select ename, sal, sal*12 from emp;
select ename, sal, comm, sal*12+comm as 연봉 from emp;  -- as 별칭을 부여할 때 사용
-- comm값에 null값이 포함되어서 null값으로 출력됨 (null 값은 연산 불가)

-- null이면 0으로 처리해주는 함수 : NVL(a , b)    (a = 열 이름, b= null값이 반환할 값)
select ename, sal, comm, sal*12+NVL(comm, 0) as 연봉 from emp;
select comm, nvl(comm, 0) from emp;


SELECT *
FROM emp
ORDER BY sal desc;


SELECT *
FROM emp
ORDER BY deptno ASC, sal DESC;
-- 선언한 순서대로 정렬 1순위, 2순위
-- ASC는 기본값이므로 생각하는 경우가 많음
-- ORDER BY는 항상 문장 맨 끝에 와야함

-- 리터럴값 출력 (select와 from 사이에 숫자 or 문자(' '))
SELECT ename, job, '직원', 1 from emp;   -- 값 자체가 열에 그대로 출력됨

SELECT * FROM emp;
SELECT * FROM emp WHERE deptno = 30;
SELECT * FROM emp WHERE deptno < 30;

SELECT * FROM emp WHERE deptno = 30 AND job = 'SALESMAN';
-- SQL문의 기본 형식은 대소문자를 구별하지 않으나 테이블에 들어있는 데이터의 대소문자는 구분해줘야함
/*
Allen
allen (x), ALLEN (X)

where 대문자변경함수(ename) = 대문자변경함수(검색어)
allen (O), ALLEN (O), aLLEN (O)
*/

SELECT * FROM emp WHERE deptno = 30 OR JOB = 'CLERK';

SELECT e.*, sal*12 FROM emp e WHERE sal * 12 = 36000;
-- 연봉이 36000인 직원의 정보
-- e : alias 사용 (별칭) 

SELECT * FROM emp WHERE sal >= 3000;
-- 급여가 3000 이상인 사원정보

SELECT * FROM emp WHERE sal >= 2500 AND job = 'ANALYST';
-- 급여가 2500 이상이고 직업이 ANALYST인 사원정보

-- 글자를 비교할 수도 있음
SELECT * FROM emp WHERE ename < 'B';    -- 첫자를 비교
SELECT * FROM emp WHERE ename = 'B';
SELECT * FROM emp WHERE ename < 'BM';   -- 두번째 글자 비교

-- 같지 않다는 의미로 사용되는 연산기호 ( !=, <>, ^= )
SELECT * FROM emp WHERE sal != 3000;
SELECT * FROM emp WHERE sal <> 3000;
SELECT * FROM emp WHERE sal ^= 3000;

-- 위 연산과 동일한 의미로 조건식 앞에 NOT을 붙이기도 함
SELECT * FROM emp WHERE NOT sal = 3000;

-- IN 연산자 (OR 연산자의 중복사용을 막기 위함)
SELECT * FROM emp WHERE job = 'MANAGER' OR job = 'SALESMAN' OR job = 'CLERK';
SELECT * FROM emp WHERE job IN ('MANAGER', 'SALESMAN', 'CLERK');

-- IN 연산자와 NOT 연산자 복합사용
SELECT * FROM emp WHERE job NOT IN ('MANAGER', 'SALESMAN', 'CLERK');

-- 연산자 BETWEEN a AND b  : a와 b 사이의 값 (a, b 포함)
SELECT * FROM emp WHERE sal BETWEEN 2000 AND 3000;  -- 포함


-- 1981년 입사한 직원
SELECT * FROM emp WHERE hiredate BETWEEN '1981-01-01' and '1981-12-31'; -- 가능
SELECT * FROM emp WHERE hiredate BETWEEN '81-01-01' and '81-12-31';     -- 가능
-- SELECT * FROM emp WHERE hiredate BETWEEN '1981' and '1982';          -- 불가능

-- LIKE 연산자 ( '_', '%' )
SELECT * FROM emp WHERE ename LIKE 'S%';
SELECT * FROM emp WHERE ename LIKE '%S';
SELECT * FROM emp WHERE job LIKE '%S%'; -- 특정 단어가 포함된 검색

-- NULL 값인 것만 출력하기 (IS NULL)
SELECT ename, sal, comm FROM emp WHERE comm IS NULL;

-- NULL 값 제외하고 출력하기 (IS NOT NULL)
SELECT ename, sal, comm FROM emp WHERE comm IS NOT NULL;

-- UNION 연산자 (합집합, 중복제거)
-- 두개의 SELECT문 사이에 사용되는 연산자
SELECT empno, ename, sal, deptno
FROM emp
    WHERE deptno = 10
UNION
SELECT empno, ename, sal, deptno
FROM emp
    WHERE deptno = 20;

-- 열의 개수가 다르면 에러가 남
SELECT empno, ename, sal, deptno
FROM emp
    WHERE deptno = 10
UNION
SELECT empno, ename, sal
FROM emp
    WHERE deptno = 20;


-- 열의 개수는 맞지만 자료형이 다를때 -> 에러가 나옴
SELECT empno, ename, sal, deptno
FROM emp
    WHERE deptno = 10
UNION
SELECT empno, ename, sal, job
FROM emp
    WHERE deptno = 20;

-- 열의 순서가 다르나 자료형이 같을때 => 문제없이 출력되나 값이 이상하게 나온다
SELECT empno, ename, sal, deptno
FROM emp
    WHERE deptno = 10
UNION
SELECT empno, ename, deptno, sal
FROM emp
    WHERE deptno = 20;

-- UNION ALL (합집합, 중복출력)
-- 동일한 row도 그냥 출력함
SELECT empno, ename, sal, deptno
FROM emp
    WHERE deptno = 10
UNION ALL
SELECT empno, ename, sal, deptno
FROM emp
    WHERE deptno = 10;


-- p125 Q1
SELECT *
FROM emp
WHERE ename LIKE '%S';

-- p125 Q2
SELECT empno, ename, job, sal, deptno
FROM emp
WHERE deptno = 30 AND job = 'SALESMAN';

-- p125 Q3
-- 집합연산자를 사용하지 않은 방식
SELECT empno, ename, sal, deptno
FROM emp
WHERE deptno IN (20, 30) AND sal > 2000;
-- 집합 연산자를 사용한 방식
SELECT empno, ename, sal, deptno
FROM emp
WHERE deptno IN (20, 30)
INTERSECT
SELECT empno, ename, sal, deptno
FROM emp
WHERE sal > 2000;
-- 정렬을 하고 싶은 경우에는 맨 마지막에 ORDER BY를 사용해야함

-- p125 Q4
SELECT *
FROM emp
WHERE NOT (sal >= 2000 AND sal <= 3000);

-- p125 Q5
SELECT ename, empno, sal, deptno
FROM emp
WHERE ename LIKE '%E%' AND deptno=30
INTERSECT
SELECT ename, empno, sal, deptno
FROM emp
WHERE NOT (sal >1000 AND sal < 2000);

-- p125 Q6
SELECT *
FROM emp
WHERE comm IS NULL AND mgr IS NOT NULL AND job IN ('MANAGER', 'CLERK')
INTERSECT
SELECT *
FROM emp
WHERE NOT (ename LIKE '_L%');


-- 6장 : 함수
SELECT ename, upper(ename), lower(ename), initcap(ename) FROM emp;

-- 사용자가 검색한 검색어

SELECT * FROM emp WHERE ename LIKE '%scott%'; -- 소문자일 경우에만 검색됨
SELECT * FROM emp WHERE ename LIKE '%SCOTT%'; -- 대문자일경우에만 검색됨
SELECT * FROM emp WHERE UPPER(ename) LIKE UPPER('%SCOTT%');  -- 대소문자 상관없이 검색됨

-- LENGTH() : 문자열 길이 구하기
SELECT ename, LENGTH(ename) from emp; 
SELECT ename, LENGTH(ename) FROM emp WHERE LENGTH(ename) >=5;

-- LENGTHB() : 문자열의 바이트 수 반환 (바이트랑 헷갈리면 안될 것)
-- 영어는 글자당 1바이트, 한글은 글자당 2바이트

SELECT LENGTH('홍길동님'), LENGTHB('홍길동님') from dual;
SELECT sysdate from dual;

-- SUBSTR() : 문자열 일부를 추출
SELECT 
    job, SUBSTR(job, 1, 2), SUBSTR(job, 3, 2), SUBSTR(job, 5)
FROM emp;

-- 두번째 값이 0부터 시작하는 경우가 있음 -> 검색하지 말고 직접 해보는게 빠름
SELECT SUBSTR('안녕하세요', 1) FROM dual;
SELECT SUBSTR('안녕하세요', 2) FROM dual;


-- INSTR() : 문자열 데이터 안에서 특정 문자 위치를 찾는 함수
-- Oracle index는 1부터 시작함!
SELECT INSTR('HELLO', 'L') FROM dual;
SELECT INSTR('HELLO', 'A') FROM dual; -- 찾는 값이 없으면 0
SELECT INSTR('HELLO', 'E') FROM dual;
-- 프로그래밍언어에서 특정 문자열이 들어있는지 확인할때 주로 사용함 (DB에서는 LIKE를 사용)


-- REPLACE() : 특정 문자를 다른 문자로 바꾸는 함수, 자주 사용됨
SELECT '010-1234-5678' AS REPLACE_BEFORE,
    REPLACE('010-1234-5678', '-', ' ') AS REPLACE_1, 
    REPLACE('010-1234-5678', '-') AS REPLACE_2,          -- 3번째 인수가 없는경우 빈 문자('')열로 대체해줌 => REPLACE_3과 동일
    REPLACE('010-1234-5678', '-', '') AS REPLACE_3       -- 입력값이 없는 NULL과는 다름!
FROM dual;

-- LTRIM (left trim) : 왼쪽을 깎아줌
SELECT LTRIM('         hello                    ') FROM dual;
-- RTRIM (Rigth trim) : 오른쪽을 깎아줌
SELECT RTRIM('         hello                    ') FROM dual;
-- TRIM : 양쪽을 다 깍아줌
SELECT TRIM('         hello                    ') AS T FROM dual;
-- 원래 특정 문자를 trim하는 용도로 사용함 (잘 사용 안함)
-- both : 왼쪽+오른쪽, leading : 왼쪽, trailing : 오른쪽
SELECT TRIM(both '+' from '+++HELLO+++++') AS a FROM dual;
SELECT TRIM(leading '+' from '+++HELLO+++++') AS a FROM dual;
SELECT TRIM(trailing '+' from '+++HELLO+++++') AS a FROM dual;
-- 주로 공백을 제거하는 용도로 사용됨
-- '서울시', '       서울시', '서울시         '


-- h e    l   l  o
SELECT trim('h e    l   l  o') FROM dual;   -- 공백 제거 안됨
SELECT replace('h e    l   l  o', ' ', '') as a FROM dual;   -- replace로 공백 제거


-- LPAD, RPAD : 빈공간을 특정 문자로 채워줌
SELECT 'Oracle',
    LPAD('Oracle', 10, '#') AS LPAD_1, 
    RPAD('Oracle', 10, '#') AS RPAD_1,
    LPAD('Oracle', 10) AS LPAD_2,
    RPAD('Oracle', 10) AS RPAD_2
FROM dual;

-- CONCAT : 문자열을 연결하는데 사용됨 (|| 연산자도 동일한 기능을 함)
SELECT CONCAT(empno, CONCAT(' : ', ename)) FROM emp;
SELECT empno || ' : ' || ename FROM emp;        -- oracle에서만 사용할 수 있기때문에 안쓰는게 좋으나 편함

-- 퀴즈
-- 이름(ename) 출력시 
-- SMITH -> **ITH
-- WARD -> **RD

-- 방법1
SELECT ename, SUBSTR(ename, 1, 2), REPLACE(ename,SUBSTR(ename, 1,2),'**')
FROM emp;

-- 방법 2
SELECT 
    ename, SUBSTR(ename,3), '**'||SUBSTR(ename,3), CONCAT('**', SUBSTR(ename, 3))
FROM emp;

-- 종합
SELECT 
    ename, 
    CONCAT('**', SUBSTR(ename,3))  방법1, 
    REPLACE(ename, SUBSTR(ename, 1, 2), '**') 방법2
from emp;
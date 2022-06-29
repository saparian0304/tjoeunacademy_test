-- p195 7.4 그룹화와 관련된 여러 함수

-- ROLLUP : 하위 합계 생성

SELECT 
    deptno, SUM(sal)
FROM emp
GROUP BY deptno;

-- ROLLUP 함수 사용 : 데이터의 합계 출력
SELECT
    deptno, SUM(sal)
FROm emp
GROUP BY ROLLUP(deptno);

-- 그룹화열 여러개 지정 가능
SELECT 
    deptno, job, SUM(sal)
FROM emp
GROUP BY ROLLUP(deptno, job)
ORDER BY deptno;

-- GROUPING
SELECT
    deptno, job, SUM(sal),
    GROUPING(deptno), GROUPING(job) --해당컬럼의 합계이면 1, 그렇지 않으면 0
FROM emp
GROUP BY ROLLUP(deptno, job)
ORDER BY deptno, job;

-- GROUPING SETS : 컬럼별 별도 합계
SELECT
    deptno, job, SUM(sal)
FROM emp
GROUP BY GROUPING SETS(deptno, job);    -- deptno별 합계, job별 합계가 따로 나옴


-- CUBE : 모든 조합의 결합가능한 그룹핑
SELECT
    deptno, job, SUM(sal)
FROM emp
GROUP BY CUBE(deptno, job)
ORDER BY deptno, job;


-- p212 연습문제
-- Q1

SELECT
    deptno,
    TRUNC(AVG(sal)) AVG_SAL,
    MAX(sal) MAX_SAL,
    MIN(sal) MIN_SAL,
    count(*) CNT
FROM emp
GROUP BY deptno
ORDER BY deptno desc;
/*문제풀이

SELECT 
    deptno, 
    TRUNC(AVG(Sal)) AVG_SAL,
    MAX(sal) MAX_SAL,
    MIN(sal) MIN_SAL,
    COUNT(*) CNT
FROM emp
GROUP BY deptno
ORDER BY deptno DESC;
*/

-- Q2
SELECT
    job, COUNT(*)
FROM emp
GROUP BY job
HAVING COUNT(*) >= 3;
/*문제풀이
SELECT
    job, COUNT(*)
FROM emp
GROUP BY job
HAVING COUNT(*) >= 3;
*/

-- Q3

SELECT
    TO_CHAR(hiredate,'YYYY') HIRE_YEAR, 
    deptno, 
    COUNT(*) CNT
FROM emp
GROUP BY TO_CHAR(hiredate,'YYYY'), deptno;
--ORDER BY HIRE_YEAR DESC, deptno;
-- 답안의 출력기준이 이상하다?

/* 문제풀이
SELECT 
    SUBSTR(hiredate, 1, 4),
    deptno,
    COUNT(*) CNT
FROM emp
GROUP BY SUBSTR(hiredate, 1, 4), deptno
ORDER BY SUBSTR(hiredate, 1, 4) DESC, DEPTNO ASC;
*/

-- Q4
SELECT
  EXIT_COMM, 
  count(*) CNT
FROM (
    SELECT
        CASE 
            WHEN comm IS NULL THEN 'O'
            ELSE 'X'
        END AS EXIT_COMM
    FROM emp
) a
GROUP BY EXIT_COMM ;
-- 강사님 풀이가 더 간단함

/* 문제풀이
SELECT
    NVL2(comm, 'O','X') EXIST_COMM, COUNT(*)
FROM emp
GROUP BY NVL2(comm, 'O', 'X');
*/

-- Q5
SELECT
    deptno, TO_CHAR(hiredate, 'YYYY') HIRE_YEAR,
    COUNT(*) CNT, 
    MAX(sal) MAX_SAL,
    SUM(sal) SUM_SAL,
    AVG(sal) AVG_SAL
FROM emp
GROUP BY ROLLUP(deptno, TO_CHAR(hiredate, 'YYYY'))
ORDER BY deptno, HIRE_YEAR;
/* 문제풀이
SELECT
    deptno, 
    SUBSTR(hiredate, 1, 4) HIRE_YEAR,
    count(*) CNT,
    MAX(sal) MAX_SAL,
    SUM(sal) SUM_SAL,
    AVG(sal) AVG_SAL
FROM emp
GROUP BY ROLLUP(deptno, SUBSTR(hiredate, 1, 4))
ORDER BY deptno;
*/

/* 추가문제
부서별 해당직급자 수와 급여합계

출력 예)
부서번호, MANAGER 수, MANAGER 급여합계, SALESMAN 수, SALESMAN 급여합계, CLERK수, CLERK급여합계
3 row로 출력되어야 함 (부서번호로 10, 20, 30 각각 1row씩)
*/

SELECT 
    deptno, job, count(job), SUM(sal)
FROM emp
GROUP BY deptno, job
HAVING JOB IN ('MANAGER', 'SALESMAN', 'CLERK');
-- 위는 틀렸음 , 문제풀이 참조
/* 문제풀이

SELECT
    deptno,
    SUM(DECODE( job, 'MANAGER', 1, 0)) MANAGER_수,
    SUM(DECODE(job, 'MANAGER', sal, 0)) MANAGER_합계,
    SUM(DECODE( job, 'SALESMAN', 1, 0)) SALESMAN_수,
    SUM(DECODE(job, 'SALESMAN', sal, 0)) SALESMAN_합계,
    SUM(DECODE( job, 'CLERK', 1, 0)) CLERK_수,
    SUM(DECODE(job, 'CLERK', sal, 0)) CLERK_합계    
FROM emp
GROUP BY deptno;

*/


/******************
     8장(★★★★★)
*******************/

/*
JOIN의 종류
* cross join (크로스 조인) : 가능한 모든 행 조인
* equi join (등가 조인, ★★) : 조건이 일치하는 결과 출력 => inner join
* non equi join (비등가 조인) : 조건이 일치하지 않는 결과 출력
* outer join (외부 조인, ★★) : 양쪽 테이블의 한쪽만 조건이 일치해도 출력 => left join, rigth join에 사용
* self join (자체 조인) : 자기 자신 테이블 조인

*/

-- 8-1 Cross Join
-- emp : 14 rows, dept : 4  -> 14 * 4 = 56 (CROSS join)
-- 기준이 없이 table을 그냥 가져다 붙임 (이런식으로 사용 잘 안함)
SELECT 
    *
FROM emp, dept      
ORDER BY empno;     

SELECT * FROM dept;

-- 8-2  등가조인 (equi join)
SELECT *
FROM emp, dept
WHERE emp.deptno = dept.deptno      -- 등가조인을 위한 조건 설정
ORDER BY empno;

-- 별칭 설정
SELECT
    *
FROm emp e, dept d
WHERE e.deptno = d.deptno
ORDER BY empno;


-- 실제 실무에서는 *을 잘 사용하지 않고 직접 column명을 입력해줌
-- 변경사항이 생겼을 경우 프로그램 수정이 쉽지 않기때문




SELECT 
    ename, empno, dname, e.deptno
FROM emp e, dept d
WHERE e.deptno = d.deptno    
ORDER BY empno;


-- 표준(ansi) 조인방식
--  , -> join
-- where -> on
SELECT
    e.empno, e.ename, dname, d.deptno
FROM emp e JOIN dept d          -- 표준방식 : ',' -> JOIN
ON e.deptno = d.deptno          -- 표준방식 : WHERE -> ON
ORDER BY empno;


-- 자체 조인
/*
예) EMP 테이블
사원명과 직속상관의 이름을 같이 출력하고 싶은 경우
*/

-- 직원번호, 직원명, 상사직원번호, 상사명
-- 상사명은 emp 테이블에 없기때문에 동일한 table을 join해줌
-- 상사가 없는 경우는 출력이 X
SELECT e1.empno, e1.ename, e1.mgr, e2.ename
FROM emp e1, emp e2
WHERE e1.mgr = e2.empno;


-- 상사가 없는 경우도 출력하는 경우 (LEFT OUTER JOIN)
SELECT e1.empno, e1.ename, e1.mgr, e2.ename
FROM emp e1, emp e2
WHERE e1.mgr = e2.empno(+);     -- (+) : LEFT OUTER JOIN

-- ANSI 방식(표준)
SELECT 
    e1.empno, e1.ename, e1.mgr, e2.ename
FROM emp e1 LEFT OUTER JOIN emp e2      -- left/right 없는 경우 inner join라고 보통 의사소통이 됨
ON e1.mgr = e2.empno;


-- 직원번호, 직원명, 직원부서명, 상사직원번호, 상사명, 상사 부서명
SELECT
    e1.empno, e1.ename, d.dname, e1.mgr, e2.ename
FROM emp e1, emp e2, dept d
WHERE e1.mgr = e2.empno(+)
AND e1.deptno = d.deptno;


SELECT
    e1.empno, e1.ename, d.dname, e1.mgr, e2.ename
FROM emp e1 LEFT OUTER JOIN emp e2
ON e1.mgr = e2.empno
JOIN dept d ON e1.deptno = d.deptno;


/*기본 구조

1. INNER JOIN
1-1 oracle 형식
FROM t1, t2
WHERE t1.x = t2.x;

1-2 표준형식
FROM t1 JOIN t2
ON t1.x = t2.x;

2. OUTTER JOIN
2-1 oracle 형식
FROM t1, t2
WHERE t1.x = t2.x(+)

2-2 표준형식
FROM t1 LEFT JOIN t2
ON t1.x = t2.x
*/

-- CONNECT BY (계층형 / 트리구조) 조회 : Oracle에서만 가능
-- 기본구조
SELECT
    empno, mgr, ename
FROM emp
START WITH mgr IS NULL      -- 시작 조건 (START WITH + 조건식)
CONNECT BY PRIOR empno = mgr; -- 조인 조건

-- 추가 구조
SELECT
    level,                  -- 계층형태를 알려줌
    LPAD(' ', 4*(LEVEL -1)) || empno,   -- 계층형태를 눈으로 보기 쉽게 하기 위함
    mgr, ename
FROM emp
START WITH mgr IS NULL      -- 시작 조건 (START WITH + 조건식)
CONNECT BY PRIOR empno = mgr; -- 조인 조건

-- p239 연습문제
-- Q1
-- 이전방식
SELECT 
    d.deptno, dname, e.empno, e.ename, sal
FROM dept d, emp e
WHERE e.sal > 2000 AND e.deptno = d.deptno
ORDER BY deptno, e.empno;

-- 표준방식
SELECT
    d.deptno, d.dname, e.empno, e.ename, e.sal
FROM dept d JOIN emp e
ON d.deptno = e.deptno AND e.sal>2000
ORDER BY deptno, e.empno;

/* 문제풀이
-- 이전방식
SELECT
    d.deptno, d.dname, e.empno, e.ename, e.sal
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND sal > 2000
ORDER BY deptno, empno;

-- ANSI방식
SELECT
    d.deptno, d.dname, e.empno, e.ename, e.sal
FROM emp e JOIN dept d
ON e.deptno = d.deptno
AND sal > 2000
ORDER BY deptno, empno;
*/

-- Q2
-- 이전방식
SELECT 
    d.deptno, d.dname, 
    TRUNC(AVG(e.sal)) AVG_SAL,
    MAX(e.sal) MAX_SAL,
    MIN(e.sal) MIN_SAL,
    COUNT(*)
FROM dept d, emp e
WHERE d.deptno = e.deptno
GROUP BY d.deptno, d.dname
ORDER BY d.deptno;

-- 표준방식
SELECT 
    d.deptno, d.dname, 
    TRUNC(AVG(e.sal)) AVG_SAL,
    MAX(e.sal) MAX_SAL,
    MIN(e.sal) MIN_SAL,
    COUNT(*) CNT
FROM dept d JOIN emp e
ON d.deptno = e.deptno
GROUP BY d.deptno, d.dname
ORDER BY d.deptno;

/* 문제풀이
-- Q2
-- 이전방식
SELECT
    e.deptno, d.dname,
    TRUNC(AVG(sal)) AVG_SAL, MAX(sal) MAX_SAL, MIN(sal) MIN_SAL, COUNT(*) CNT
FROM emp e, dept d
WHERE e.deptno = d.deptno
GROUP BY e.deptno, d.dname
ORDER BY e.deptno;

-- ANSI 방식
SELECT
    e.deptno, d.dname,
    TRUNC(AVG(sal)) AVG_SAL, MAX(sal) MAX_SAL, MIN(sal) MIN_SAL, COUNT(*) CNT
FROM emp e JOIN dept d
ON e.deptno = d.deptno
GROUP BY e.deptno, d.dname
ORDER BY e.deptno;
*/

-- Q3
-- 이전방식
SELECT
    d.deptno, d.dname, e.empno, e.ename, e.job, e.sal
FROM dept d, emp e
WHERE d.deptno = e.deptno(+)
ORDER BY d.deptno, e.ename;

-- 표준방식
SELECT
    d.deptno, d.dname, e.empno, e.ename, e.job, e.sal
FROM dept d LEFT JOIN emp e
ON d.deptno = e.deptno
ORDER BY d.deptno, e.ename;

/* 문제풀이
-- Q3
-- 이전방식
SELECT
    d.deptno, dname, empno, ename, job, sal
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno
ORDER BY d.deptno, ename;

-- ANSI 방식
SELECT
    d.deptno, dname, empno, ename, job, sal
FROM emp e RIGHT OUTER JOIN dept d      -- right join으로 푸셨음
ON e.deptno = d.deptno
ORDER BY d.deptno, ename;
*/

-- Q4
-- 이전방식
SELECT
    d.deptno, d.dname, e.empno, e.ename, e.mgr, e.sal, d.deptno,
    s.losal, s.hisal, s.grade, e.mgr, e1.ename
FROM dept d, emp e, salgrade s, emp e1
WHERE d.deptno = e.deptno(+) 
AND e.sal BETWEEN s.losal(+) AND s.hisal(+)         -- (+)기호를 사용한 우측테이블에 전부 넣어야함
AND e.mgr = e1.empno (+)
ORDER BY d.deptno, e.empno;

-- 표준방식
SELECT
    d.deptno, d.dname, e.empno, e.ename, e.MGR, e.sal, e.deptno,
    s.losal, s.hisal, s.grade,
    e.mgr, e1.ename
FROM dept d LEFT JOIN emp e
ON d.deptno = e.deptno
LEFT JOIN salgrade s
ON e.sal BETWEEN s.losal AND s.hisal
LEFT JOIN emp e1
ON e.mgr = e1.empno
ORDER BY d.deptno, e.empno;

/* 문제풀이
-- Q4
-- 이전 방식
SELECT
    d.deptno, dname, e.empno, e.ename, e.mgr, e.sal,
    e.deptno deptno_1, losal, hisal, grade,
    e2.empno MGR_EMPNO, e2.ename MGR_ENAME
FROM emp e, dept d, salgrade s, emp e2
WHERE e.deptno(+) = d.deptno
AND e.sal BETWEEN s.losal(+) AND s.hisal(+)
AND e.mgr = e2.empno(+)
ORDER BY d.deptno, e.empno;

-- ANSI 방식
SELECT 
    d.deptno, d.dname, e.empno, e.ename, e.mgr, e.sal, e.deptno deptno_1,
    s.losal, s.hisal, s.grade,
    e2.empno MGR_EMPNO, e2.ename MGR_ENAME
FROM emp e RIGHT JOIN dept d ON e.deptno = d.deptno
LEFT JOIN salgrade s ON e.sal BETWEEN s.losal AND s.hisal
LEFT JOIN emp e2 ON e.mgr = e2.empno
ORDER BY d.deptno;
*/


/******************
     9장(★★★★★) - 서브쿼리
*******************/ 

-- JONES보다 급여를 많이 받는 직원정보 구하기
SELECT sal FROM emp WHERE ename = 'JONES';  -- 결과값 : 2975
SELECT * FROM emp WHERE sal > 2975;


-- 위 두 SQL문을 합친 것
-- SELECT문을 괄호로 감싼 것 => 서브쿼리

-- 단일행 서브쿼리 ( =, !=, >, <, ....) : 실행값이 1 row인 쿼리
SELECT * FROM emp WHERE sal > (SELECT sal FROM emp WHERE ename = 'JONES'); 
-- 비교를 위해 서브쿼리를 사용할 경우 결과값이 1개가 아닌 경우에는 에러가 날 수 있음


-- 다중행 서브쿼리 (IN, NOT IN, ANY, ALL) : 실행값이 1 row 이상인 쿼리


-- 단일행 서브쿼리
SELECT
    *
FROM emp
WHERE hiredate < (SELECT hiredate
                    FROM emp
                    WHERE ename = 'SCOTT');

SELECT
    e.empno, e.ename, e.job, e.sal, d.deptno, d.dname, d.loc
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND e.deptno = 20
AND e.sal > (SELECT AVG(sal) FROM emp);


-- 다중행 서브쿼리
/*

* IN        : 메인쿼리의 데이터가 서브쿼리의 결과값과 하나라도 일치하면 true
* ANY, SOME : 메인쿼리의 조건식을 만족하는 서브쿼리 결과가 하나 이상이면 true
* ALL       : 메인쿼리 조건식을 서브쿼리 결과값 모두가 만족하면 true
* EXISTS    : 서브쿼리의 결과가 하나라도 존재하면 true

*/


-- IN
SELECT 
    *
FROM emp
WHERE sal IN (SELECT MAX(sal)
                FROM emp
                GROUP BY deptno
);
                
            
-- ANY    
SELECT 
    *
FROM emp
WHERE sal < ANY (SELECT MAX(sal)
                FROM emp            -- 서브쿼리 결과값 : 2850, 3000, 5000
                GROUP BY deptno     -- 3개 중에 하나보다 작기만 하면 됨
);



-- 9-18 : 비교할 열이 여러개인 다중열 서브쿼리
SELECT
    *
FROM emp
WHERE (deptno, sal) IN (SELECT deptno, MAX(sal)
                        FROM emp
                        GROUP BY deptno);
                        
/*
뷰(VIEW)
- 가상의(논리적) 테이블
- INLINE VIEW (코드 안에 뷰)

*/

-- SELECT문을 사용해서 가상의 테이블(view)을 만들고 FROM의 대상으로 사용할 수 있음
SELECT *
FROM (SELECT 
        *
    FROM emp 
    WHERE deptno = 20
) a;


SELECT MAX(AVG_SAL)
FROM (
    SELECT deptno, AVG(sal) AVG_SAL from emp GROUP BY deptno
) a;


-- 9-19
-- 두개의 view를 JOIN한 예
SELECT
    E10.empno, E10.ename, E10.deptno, D.dname, D.loc
FROM (SELECT * FROM emp WHERE deptno = 10) E10,
    (SELECT * FROM dept) D
WHERE E10.deptno = D.deptno;

/*
데이터가 많은 경우
JOIN을 하고 조건을 넣는 것과                       -> 단순 JOIN
데이터를 줄여서 JOIN하는 것과는 속도차이가 있음    -> VIEW를 이용해서 데이터를 줄인 후 JOIN
*/


-- 9-20

WITH
e10 AS (SELECT * FROM emp WHERE deptno = 10),
d   AS (SELECT * FROM dept)
SELECT  e10.empno, e10.ename, e10.deptno, d.dname, d.loc
FROM e10, d
WHERE e10.deptno = d.deptno;


-- 스칼라 서브쿼리 => 단일행, 하나의 값
-- - SELECT절에 오는 서브쿼리로 반드시 하나의 결과만 반환함
-- - 속도가 느림
-- 직원명과 부서명 출력
SELECT deptno, ename,
    (SELECT dname FROM dept WHERE deptno=emp.deptno) AS dname
FROM emp;


-- 페이징처리 => rownum 이용, 서브쿼리 2번 사용

-- rownum : 행에 번호를 부여해줌
SELECT rownum, empno, ename   
FROM emp
WHERE rownum BETWEEN 1 AND 10
ORDER BY hiredate;              -- ORDER BY가 나중에 실행되기때문에 정렬이 제대로 안됨

-- 2번 감싸야 페이징 처리가 된다 (서브쿼리 안에 서브쿼리)
-- 게시판에 정렬을 하기위함 
SELECT 
    *
FROM (
    SELECT rownum rnum, a.*     -- 넘버를 부여하는 서브쿼리
    FROM (
        SELECT empno, ename     -- 시간대 순으로 정렬하는 서브쿼리
        FROM emp
        ORDER BY hiredate
    ) a
) b
WHERE b.rnum BETWEEN 1 AND 10;  -- 페이징 처리를 위한 BETWEEN 조건절

-- 인터넷에 한번만 감싸는 형태로 페이징처리 구현했다고 하지만 그렇게 할 경우 다음페이지 구현이 되지를 않음

/*
서브쿼리 사용 가능한 위치
- WHERE 조건문
- 컬럼 (스칼라 서브쿼리)
- HAVING 조건문
- FROM 뒤에 (INLINE VIEW)
*/



-- 9장 연습문제
-- p262 Q1

SELECT
    job, empno, ename, sal, e.deptno, d.dname
FROM emp e, dept d
WHERE job = (SELECT job FROM emp WHERE ename='ALLEN')
AND e.deptno = d.deptno;


-- p262 Q2
SELECT
    empno, ename, dname, hiredate, loc, sal, grade
FROM emp e, dept d, salgrade s
WHERE e.deptno = d.deptno
    AND e.sal BETWEEN s.losal AND s.hisal
    AND sal > (SELECT AVG(sal) FROM emp)
ORDER BY sal DESC, empno;


-- p263 Q3
SELECT 
    empno, ename, job, e.deptno, dname, loc
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND job != ALL (SELECT job FROM emp WHERE deptno = 30)
AND e.deptno = 10
ORDER BY job;

-- p263 Q4
-- 다중행함수를 사용하는 방법
SELECT
    empno, ename, sal, grade
FROM emp e, salgrade s
WHERE e.sal BETWEEN s.losal AND s.hisal 
AND sal > (SELECT MAX(sal) FROM emp WHERE job = 'SALESMAN')
ORDER BY empno;

-- 다중행함수를 사용하지 않는 방법

SELECT
    empno, ename, sal, grade
FROM emp e, salgrade s
WHERE sal > all (SELECT sal FROM emp WHERE job = 'SALESMAN')
AND sal BETWEEN s.losal AND s.hisal
ORDER BY empno;



-- 다시
-- Q1
SELECT 




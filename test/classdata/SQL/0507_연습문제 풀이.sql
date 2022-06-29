--5장 연습문제
--Q1

SELECT
    empno, ename, job, mgr, hiredate, sal, comm, deptno
FROM emp
WHERE ename like '%S';


--Q2
SELECT
    empno, ename, job, sal, deptno
FROM emp
WHERE deptno = 30 AND job = 'SALESMAN';

-- Q3
SELECT
    empno, ename, job, sal, deptno
FROM emp
WHERE deptno IN (20, 30) AND sal > 2000;

SELECT 
    empno, ename, job, sal, deptno
FROM emp
WHERE sal > 2000
INTERSECT
SELECT empno, ename, job, sal, deptno
FROM emp
WHERE deptno IN (20, 30);

-- Q4
SELECT
    empno, ename, job, mgr, hiredate, sal, comm, deptno
FROM emp
WHERE sal < 2000 OR sal > 3000;

-- Q5
SELECT
    ename, empno, sal, deptno
FROM emp
WHERE ename LIKE '%E%' 
AND deptno = 30
AND sal NOT BETWEEN 1000 AND 2000;

-- Q6
SELECT
    empno, ename, job, mgr, hiredate, sal, comm, deptno
FROM emp
WHERE comm IS NULL
AND job IN ('MANAGER', 'CLERK')
AND mgr IS NOT NULL
AND ename NOT LIKE '_L%';

/*
6장 연습문제
*/

-- Q1
SELECT
    empno, SUBSTR(empno, 1, 2)||'**' MASKING_EMPNO,
    ename, REPLACE(ename, SUBSTR(ename, 2, 4), '****') MASKING_ENAME
FROM emp
WHERE LENGTH(ename) = 5;

-- Q2
SELECT
    empno, ename, sal,
    TRUNC(sal/21.5, 2) DAY_PAY,
    ROUND(sal/21.5/8, 1) TIME_PAY
FROM emp;

-- Q3
SELECT
    empno, ename, hiredate,
    TO_CHAR(NEXT_DAY(ADD_MONTHS(hiredate, 3),'월'), 'YYYY-MM-DD') R_JOB,
    NVL(TO_CHAR(comm), 'N/A') comm
FROM emp;

-- Q4
SELECT
    empno, ename, mgr,
    CASE
        WHEN mgr IS NULL THEN '0000'
        WHEN SUBSTR(mgr, 1, 2)=75 THEN '5555'
        WHEN SUBSTR(mgr, 1, 2)=76 THEN '6666'
        WHEN SUBSTR(mgr, 1, 2)=77 THEN '7777'
        WHEN SUBSTR(mgr, 1, 2)=78 THEN '8888'
        ELSE TO_CHAR(mgr)
    END CHG_MGR    
FROM emp;


/*
7장 연습문제
*/

-- Q1
SELECT
    deptno, 
    TRUNC(AVG(sal)) AVG_SAL, 
    MAX(sal) MAX_SAL,
    MIN(sal) MIN_SAL,
    COUNT(*) cnt
FROM emp
GROUP BY deptno
ORDER BY deptno DESC;

-- Q2
SELECT
    job, COUNT(*)
FROM emp
GROUP BY job
HAVING job IN ('CLERK', 'SALESMAN', 'MANAGER');

-- Q3
SELECT
    TO_CHAR(hiredate, 'YYYY') HIRE_YEAR, deptno, COUNT(*) CNT
FROM emp
GROUP BY deptno, TO_CHAR(hiredate, 'YYYY');

-- Q4
SELECT
    NVL2(comm, 'O', 'X') EXIST_COMM, 
    COUNT(*) CNT
FROM emp
GROUP BY NVL2(comm, 'O', 'X');

-- Q5
SELECT
    deptno, 
    TO_CHAR(hiredate, 'yyyy') HIRE_YEAR, 
    COUNT(*) CNT,
    MAX(sal) MAX_SAL, 
    SUM(sal) SUM_SAL, 
    AVG(sal) AVG_SAL
FROM emp
GROUP BY ROLLUP(deptno, TO_CHAR(hiredate, 'yyyy'))
ORDER BY deptno;
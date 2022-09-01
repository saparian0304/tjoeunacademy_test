/* 
7장 연습문제 풀이
*/

-- Q1

SELECT 
    deptno, 
    TRUNC(AVG(Sal)) AVG_SAL,
    MAX(sal) MAX_SAL,
    MIN(sal) MIN_SAL,
    COUNT(*) CNT
FROM emp
GROUP BY deptno
ORDER BY deptno DESC;

-- Q2

SELECT
    job, COUNT(*)
FROM emp
GROUP BY job
HAVING COUNT(*) >= 3;

-- Q3

SELECT 
    SUBSTR(hiredate, 1, 4),
    deptno,
    COUNT(*) CNT
FROM emp
GROUP BY SUBSTR(hiredate, 1, 4), deptno
ORDER BY SUBSTR(hiredate, 1, 4) DESC, DEPTNO ASC;

-- Q4
SELECT
    NVL2(comm, 'O','X') EXIST_COMM, COUNT(*)
FROM emp
GROUP BY NVL2(comm, 'O', 'X');

-- Q5

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


/* 추가문제
부서별 해당직급자 수와 급여합계

출력 예)
부서명, MANAGER 수, MANAGER 급여합계, SALESMAN 수, SALESMAN 급여합계, CLERK수, CLERK급여합계
*/


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


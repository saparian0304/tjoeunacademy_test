/*
연습문제 풀이
*/
-- Q1

SELECT
    job, empno, ename, sal, e.deptno, dname
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND job = (SELECT job FROM emp WHERE ename = 'ALLEN');

-- Q2
SELECT
    empno, ename, dname, hiredate, loc, sal, grade
FROM emp e, dept d, salgrade s
WHERE e.deptno = d.deptno
AND sal > (SELECT AVG(sal) FROM emp)
AND sal BETWEEN s.losal AND s.hisal
ORDER BY sal DESC, empno;

-- Q3
SELECT
    empno, ename, job, e.deptno, dname, loc
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND job NOT IN (SELECT job FROM emp WHERE deptno = 30)
AND d.deptno = 10;

-- Q4 : 다중행함수 사용하기
SELECT
    empno, ename, sal, grade
FROM emp e, salgrade
WHERE sal BETWEEN losal AND hisal
AND sal > (SELECT MAX(sal) FROM emp WHERE job = 'SALESMAN')
ORDER BY empno;

-- Q4 : 다중행함수 사용 안하기
SELECT 
    empno, ename, sal, grade
FROM emp e, salgrade
WHERE sal BETWEEN losal AND hisal
AND sal > ALL (SELECT sal FROM emp WHERE job = 'SALESMAN')
ORDER BY empno;
/*
8장 연습문제 풀이 (p239)
*/

-- Q1
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

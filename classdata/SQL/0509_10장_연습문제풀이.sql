/*10장 연습문제 풀이*/
-- Q1, Q2 : SQL문 하나씩 실행해야함
-- Q3
UPDATE chap10hw_emp SET
deptno = 70
WHERE sal > (SELECT avg(sal) FROM chap10hw_emp WHERE deptno=50);

-- Q4
UPDATE chap10hw_emp SET
sal = sal * 1.1, dept = 80
WHERE hiredate > (SELECT MIN(hiredate) FROM chap10hw_emp WHERE deptno=6);

-- Q5
DELETE FROM chap10hw_emp
    WHERE empno IN (SELECT empno
                    FROM chap10hw_emp, chap10hw_salgrade
                    WHERE sal BETWEEN losal(+) AND hisal(+)
                    AND grade = 5);
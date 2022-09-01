--Q1
select
    job, empno, ename, sal, e.deptno, dname
from emp e, dept d
where e.deptno = d.deptno
and job = (select job from emp where ename='ALLEN');

-- Q2
select
    e.empno, ename, dname, hiredate, loc, sal, grade
from emp e, dept d, salgrade s
where e.deptno = d.deptno
and e.sal between s.losal and s.hisal
and e.sal > (select avg(sal) from emp)
order by sal desc, e.empno asc;

-- Q3
select
    e.empno, ename, job, e.deptno, dname, loc
from emp e, dept d
where e.deptno = d.deptno
and e.deptno = 10
and e.job not in (select job from emp where deptno=30);

-- Q4
select
    e.empno, ename, sal, grade
from emp e, salgrade s
where e.sal between s.losal and s.hisal
and e.sal > (select max(sal) from emp where job='SALESMAN')
order by empno;

-- max¾øÀÌ
select
    e.empno, ename, sal, grade
from emp e, salgrade s
where e.sal between s.losal and s.hisal
and e.sal > all (select sal from emp where job='SALESMAN')
order by empno;
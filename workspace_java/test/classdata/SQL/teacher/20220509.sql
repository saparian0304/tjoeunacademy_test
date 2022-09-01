create table dept_temp as select * from dept;

insert into dept_temp (deptno, dname, loc) values (50,'DATABASE','SEOUL');
select * from dept_temp;

insert into dept_temp(deptno, dname, loc) values (60,'NETWORK');
insert into dept_temp(deptno, dname, loc) values (60,'NETWORK','BUSAN','WRONG');
insert into dept_temp(deptno, dname, loc) values ('WRONG','NETWORK','BUSAN');
insert into dept_temp(deptno, dname, loc) values (600,'NETWORK','BUSAN');

-- 10-4 (�÷��� ����)
insert into dept_temp values (60, 'NETWORK','BUSAN');

-- 10-5 (null�� �Է�)
insert into dept_temp (deptno,dname,loc) 
values (70, 'WEB',null);

select * from dept_temp;

-- 10-6 (���ڿ�)
insert into dept_temp (deptno,dname,loc) 
values (80, 'MOBILE','');

-- �÷����� �������� �ʴ� ��
INSERT INTO ���̺�� (
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
values (9999,'ȫ�浿','PRESIDENT',null,'2001/01/01',5000,1000,10);
select * from emp_temp;
insert into emp_temp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
values (1111,'������','MANAGER',9999,'2001-01-05',4000,null,20);

insert into emp_temp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
values (2111,'�̼���','MANAGER',9999,TO_DATE('07/01/2001','DD/MM/YYYY'),4000,null,20);
select * from emp_temp;

insert into emp_temp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
values (3111,'��û��','MANAGER',9999,sysdate,4000,null,30);
select * from emp_temp;

insert into emp_temp (empno, ename, job, mgr, hiredate, sal, comm, deptno)
select e.empno, e.ename, e.job, e.mgr, e.hiredate, e.sal, e.comm, e.deptno
from emp e, salgrade s
where e.sal between s.losal and s.hisal
and s.grade=1;

select * from emp_temp;

create table dept_temp2 as select * from dept;
select * from dept_temp2;

-- where����
update dept_temp2 set loc='SEOUL';
select *from dept_temp2;

rollback;

-- where ����
update dept_temp2 set dname='DATABASE', loc='SEOUL' where deptno=40;
select *from dept_temp2;

-- subquery�� ����
update dept_temp2 set (dname, loc) =  (select dname, loc from dept where deptno=40)
where deptno=40;
select *from dept_temp2;

update dept_temp2 set loc='SEOUL'
where deptno=(select deptno from dept_temp2 where dname='OPERATIONS');

-- ���� Ȯ��
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

-- savepoint(��������)
insert into dept_tcl values (60, 'AAA','SEOUL');
savepoint sp1;
insert into dept_tcl values (70, 'BBB','SEOUL');
savepoint sp2;
insert into dept_tcl values (80, 'CCC','SEOUL');
rollback to sp2; -- sp2���� ���� commit
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

-- �÷��߰�
alter table emp_alter add hp varchar2(20);

-- �÷��� ����
alter table emp_alter rename column hp to tel;
select * from emp_alter;

-- Ÿ�� ����
alter table emp_alter modify empno number(5);

-- �÷� ����
alter table emp_alter drop column tel;

truncate table emp_alter2;
select * from emp_alter2;
-- ����� ����
-- ������(truncate�� DDL�̹Ƿ� ���� �� �ѹ� �Ұ�, ���̺�뷮 �ʱ�ȭ)
delete from emp_alter2;

create index idx_emp_sal on emp(sal);
/*
�ε���
- �����͸� ������ �˻��ϱ� ���� ���� ���
- B-tree(balanced tree) �ڷᱸ��(����Ʈ���� ������ �˰���) ���
����
- �˻��ӵ� ������
- �ý��� ���ϸ� �ٿ�(���� ���)
����
- �߰� ������� �ʿ�
- �ε��� ���� �ð� �ʿ�
- DML(insert, update, delete) �۾� �� ���� ����
*/

-- ���� ��ȹ (explain plan)
explain plan for select * from emp where ename = 'SCOTT';
select * from table(dbms_xplan.display);
-- F10(���� ���ʿ��� 3��° ������)
select * from emp where ename = 'SCOTT';

-- �ε��� ����
create index IDX_EMP_ENAME on emp (ename);

/*
�ε����� ������ �÷�?
- where �������� ���� ���Ǵ� �÷�
- ���� ���ǿ� ���Ǵ� �÷�
- �ΰ� �̻��� ������ ���ԵǴ� ��� ���� �ε��� ����
- ���� �ε����� ��ȸ ������ ��� �÷��� ���ÿ� ����(�����ε���-empno,sal, ����-empno,sal)

* ���� ����
- PK, UNIQUE �������ǿ����� �ڵ� ����
- �ش� �÷��� �����ϱ� �� ���¿��� ���� ����
- �ε��� ���ε� ������ �𵨸� �� ��� �ʿ�
- LIKE�� �ε��� ������ ���ɼ� ����(%S%)
*/
-- emp���̺��� deptno�� �ε��� ����
create index idx_emp_deptno on emp(deptno);
select * from dept where deptno=20; -- unique scan
select * from emp where deptno=20; -- range scan
select * from emp where deptno is not null; -- full scan

-- �ε��� ��ĵ ����
select /*+INDEX_RS*/
    deptno
from emp where deptno=20;

-- �̸��� ù�ڰ� S��
select * from emp where substr(ename,1,1)='S'; -- �ε��� ������
select * from emp where ename like 'S%';

-- �����ε���
create index idx_emp_empnodeptno on emp(empno, deptno); -- �����ε���
select * from emp where empno=7788 and deptno=20; -- �����ε���
-- �����ε��� ��� �� ������ �տ��ٰ� PK�� ����

create view vw_emp20 as (select empno, ename, job ,deptno from emp where deptno=20);

-- ���� �ο� (grant)
-- sys�� testuser���� create view ������ �ο�
-- grant create view to testuser;
select * from vw_emp20;
-- ���� ȸ�� (revoke)

select max(empno)+1 from emp;

create table dept_sequence as select * from dept where 1<> 1;
select * from dept_sequence;

-- ������ ���
-- ���簪 (currval)
select seq_dept_sequence.currval from dual;
-- ������ (nextval)
select seq_dept_sequence.nextval from dual;

insert into dept_sequence(deptno, dname, loc)
values (seq_dept_sequence.nextval, 'DATABASE','SEOUL');

select * from dept_sequence;

insert into dept (dname, loc) values ('ABC','DEF'); -- NOT NULL
insert into dept (deptno, dname, loc) values (10,'ABC','DEF'); -- UNIQUE

-- FK (�������� ���� �������� �ʴ� ���)
insert into emp(empno, ename, job, mgr, hiredate, sal, comm, deptno)
values (9999,'ȫ�浿','CLERK','7788','2017-04-30',1200,null,50);

-- �ڽ�(emp���̺�)���� deptno(30)�� �����ϰ� ������ �����Ұ�
-- �����Ϸ��� emp�� deptno�� 30�� ��� �����͸� ���� �� dept���̺��� ����
delete from dept where deptno=30;

-- ���� ���̺��� ������ ��ȸ

SELECT 
    DISTINCT deptno
FROM emp
    WHERE deptno >= 20;
    
    
select distinct deptno from emp;
select deptno from emp group by dept;
select distinct job, deptno from emp;

select ename, sal, sal*12 from emp;
select ename, sal, comm, sal*12+comm as ���� from emp;  -- as ��Ī�� �ο��� �� ���
-- comm���� null���� ���ԵǾ null������ ��µ� (null ���� ���� �Ұ�)

-- null�̸� 0���� ó�����ִ� �Լ� : NVL(a , b)    (a = �� �̸�, b= null���� ��ȯ�� ��)
select ename, sal, comm, sal*12+NVL(comm, 0) as ���� from emp;
select comm, nvl(comm, 0) from emp;


SELECT *
FROM emp
ORDER BY sal desc;


SELECT *
FROM emp
ORDER BY deptno ASC, sal DESC;
-- ������ ������� ���� 1����, 2����
-- ASC�� �⺻���̹Ƿ� �����ϴ� ��찡 ����
-- ORDER BY�� �׻� ���� �� ���� �;���

-- ���ͷ��� ��� (select�� from ���̿� ���� or ����(' '))
SELECT ename, job, '����', 1 from emp;   -- �� ��ü�� ���� �״�� ��µ�

SELECT * FROM emp;
SELECT * FROM emp WHERE deptno = 30;
SELECT * FROM emp WHERE deptno < 30;

SELECT * FROM emp WHERE deptno = 30 AND job = 'SALESMAN';
-- SQL���� �⺻ ������ ��ҹ��ڸ� �������� ������ ���̺� ����ִ� �������� ��ҹ��ڴ� �����������
/*
Allen
allen (x), ALLEN (X)

where �빮�ں����Լ�(ename) = �빮�ں����Լ�(�˻���)
allen (O), ALLEN (O), aLLEN (O)
*/

SELECT * FROM emp WHERE deptno = 30 OR JOB = 'CLERK';

SELECT e.*, sal*12 FROM emp e WHERE sal * 12 = 36000;
-- ������ 36000�� ������ ����
-- e : alias ��� (��Ī) 

SELECT * FROM emp WHERE sal >= 3000;
-- �޿��� 3000 �̻��� �������

SELECT * FROM emp WHERE sal >= 2500 AND job = 'ANALYST';
-- �޿��� 2500 �̻��̰� ������ ANALYST�� �������

-- ���ڸ� ���� ���� ����
SELECT * FROM emp WHERE ename < 'B';    -- ù�ڸ� ��
SELECT * FROM emp WHERE ename = 'B';
SELECT * FROM emp WHERE ename < 'BM';   -- �ι�° ���� ��

-- ���� �ʴٴ� �ǹ̷� ���Ǵ� �����ȣ ( !=, <>, ^= )
SELECT * FROM emp WHERE sal != 3000;
SELECT * FROM emp WHERE sal <> 3000;
SELECT * FROM emp WHERE sal ^= 3000;

-- �� ����� ������ �ǹ̷� ���ǽ� �տ� NOT�� ���̱⵵ ��
SELECT * FROM emp WHERE NOT sal = 3000;

-- IN ������ (OR �������� �ߺ������ ���� ����)
SELECT * FROM emp WHERE job = 'MANAGER' OR job = 'SALESMAN' OR job = 'CLERK';
SELECT * FROM emp WHERE job IN ('MANAGER', 'SALESMAN', 'CLERK');

-- IN �����ڿ� NOT ������ ���ջ��
SELECT * FROM emp WHERE job NOT IN ('MANAGER', 'SALESMAN', 'CLERK');

-- ������ BETWEEN a AND b  : a�� b ������ �� (a, b ����)
SELECT * FROM emp WHERE sal BETWEEN 2000 AND 3000;  -- ����


-- 1981�� �Ի��� ����
SELECT * FROM emp WHERE hiredate BETWEEN '1981-01-01' and '1981-12-31'; -- ����
SELECT * FROM emp WHERE hiredate BETWEEN '81-01-01' and '81-12-31';     -- ����
-- SELECT * FROM emp WHERE hiredate BETWEEN '1981' and '1982';          -- �Ұ���

-- LIKE ������ ( '_', '%' )
SELECT * FROM emp WHERE ename LIKE 'S%';
SELECT * FROM emp WHERE ename LIKE '%S';
SELECT * FROM emp WHERE job LIKE '%S%'; -- Ư�� �ܾ ���Ե� �˻�

-- NULL ���� �͸� ����ϱ� (IS NULL)
SELECT ename, sal, comm FROM emp WHERE comm IS NULL;

-- NULL �� �����ϰ� ����ϱ� (IS NOT NULL)
SELECT ename, sal, comm FROM emp WHERE comm IS NOT NULL;

-- UNION ������ (������, �ߺ�����)
-- �ΰ��� SELECT�� ���̿� ���Ǵ� ������
SELECT empno, ename, sal, deptno
FROM emp
    WHERE deptno = 10
UNION
SELECT empno, ename, sal, deptno
FROM emp
    WHERE deptno = 20;

-- ���� ������ �ٸ��� ������ ��
SELECT empno, ename, sal, deptno
FROM emp
    WHERE deptno = 10
UNION
SELECT empno, ename, sal
FROM emp
    WHERE deptno = 20;


-- ���� ������ ������ �ڷ����� �ٸ��� -> ������ ����
SELECT empno, ename, sal, deptno
FROM emp
    WHERE deptno = 10
UNION
SELECT empno, ename, sal, job
FROM emp
    WHERE deptno = 20;

-- ���� ������ �ٸ��� �ڷ����� ������ => �������� ��µǳ� ���� �̻��ϰ� ���´�
SELECT empno, ename, sal, deptno
FROM emp
    WHERE deptno = 10
UNION
SELECT empno, ename, deptno, sal
FROM emp
    WHERE deptno = 20;

-- UNION ALL (������, �ߺ����)
-- ������ row�� �׳� �����
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
-- ���տ����ڸ� ������� ���� ���
SELECT empno, ename, sal, deptno
FROM emp
WHERE deptno IN (20, 30) AND sal > 2000;
-- ���� �����ڸ� ����� ���
SELECT empno, ename, sal, deptno
FROM emp
WHERE deptno IN (20, 30)
INTERSECT
SELECT empno, ename, sal, deptno
FROM emp
WHERE sal > 2000;
-- ������ �ϰ� ���� ��쿡�� �� �������� ORDER BY�� ����ؾ���

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


-- 6�� : �Լ�
SELECT ename, upper(ename), lower(ename), initcap(ename) FROM emp;

-- ����ڰ� �˻��� �˻���

SELECT * FROM emp WHERE ename LIKE '%scott%'; -- �ҹ����� ��쿡�� �˻���
SELECT * FROM emp WHERE ename LIKE '%SCOTT%'; -- �빮���ϰ�쿡�� �˻���
SELECT * FROM emp WHERE UPPER(ename) LIKE UPPER('%SCOTT%');  -- ��ҹ��� ������� �˻���

-- LENGTH() : ���ڿ� ���� ���ϱ�
SELECT ename, LENGTH(ename) from emp; 
SELECT ename, LENGTH(ename) FROM emp WHERE LENGTH(ename) >=5;

-- LENGTHB() : ���ڿ��� ����Ʈ �� ��ȯ (����Ʈ�� �򰥸��� �ȵ� ��)
-- ����� ���ڴ� 1����Ʈ, �ѱ��� ���ڴ� 2����Ʈ

SELECT LENGTH('ȫ�浿��'), LENGTHB('ȫ�浿��') from dual;
SELECT sysdate from dual;

-- SUBSTR() : ���ڿ� �Ϻθ� ����
SELECT 
    job, SUBSTR(job, 1, 2), SUBSTR(job, 3, 2), SUBSTR(job, 5)
FROM emp;

-- �ι�° ���� 0���� �����ϴ� ��찡 ���� -> �˻����� ���� ���� �غ��°� ����
SELECT SUBSTR('�ȳ��ϼ���', 1) FROM dual;
SELECT SUBSTR('�ȳ��ϼ���', 2) FROM dual;


-- INSTR() : ���ڿ� ������ �ȿ��� Ư�� ���� ��ġ�� ã�� �Լ�
-- Oracle index�� 1���� ������!
SELECT INSTR('HELLO', 'L') FROM dual;
SELECT INSTR('HELLO', 'A') FROM dual; -- ã�� ���� ������ 0
SELECT INSTR('HELLO', 'E') FROM dual;
-- ���α׷��־��� Ư�� ���ڿ��� ����ִ��� Ȯ���Ҷ� �ַ� ����� (DB������ LIKE�� ���)


-- REPLACE() : Ư�� ���ڸ� �ٸ� ���ڷ� �ٲٴ� �Լ�, ���� ����
SELECT '010-1234-5678' AS REPLACE_BEFORE,
    REPLACE('010-1234-5678', '-', ' ') AS REPLACE_1, 
    REPLACE('010-1234-5678', '-') AS REPLACE_2,          -- 3��° �μ��� ���°�� �� ����('')���� ��ü���� => REPLACE_3�� ����
    REPLACE('010-1234-5678', '-', '') AS REPLACE_3       -- �Է°��� ���� NULL���� �ٸ�!
FROM dual;

-- LTRIM (left trim) : ������ �����
SELECT LTRIM('         hello                    ') FROM dual;
-- RTRIM (Rigth trim) : �������� �����
SELECT RTRIM('         hello                    ') FROM dual;
-- TRIM : ������ �� �����
SELECT TRIM('         hello                    ') AS T FROM dual;
-- ���� Ư�� ���ڸ� trim�ϴ� �뵵�� ����� (�� ��� ����)
-- both : ����+������, leading : ����, trailing : ������
SELECT TRIM(both '+' from '+++HELLO+++++') AS a FROM dual;
SELECT TRIM(leading '+' from '+++HELLO+++++') AS a FROM dual;
SELECT TRIM(trailing '+' from '+++HELLO+++++') AS a FROM dual;
-- �ַ� ������ �����ϴ� �뵵�� ����
-- '�����', '       �����', '�����         '


-- h e    l   l  o
SELECT trim('h e    l   l  o') FROM dual;   -- ���� ���� �ȵ�
SELECT replace('h e    l   l  o', ' ', '') as a FROM dual;   -- replace�� ���� ����


-- LPAD, RPAD : ������� Ư�� ���ڷ� ä����
SELECT 'Oracle',
    LPAD('Oracle', 10, '#') AS LPAD_1, 
    RPAD('Oracle', 10, '#') AS RPAD_1,
    LPAD('Oracle', 10) AS LPAD_2,
    RPAD('Oracle', 10) AS RPAD_2
FROM dual;

-- CONCAT : ���ڿ��� �����ϴµ� ���� (|| �����ڵ� ������ ����� ��)
SELECT CONCAT(empno, CONCAT(' : ', ename)) FROM emp;
SELECT empno || ' : ' || ename FROM emp;        -- oracle������ ����� �� �ֱ⶧���� �Ⱦ��°� ������ ����

-- ����
-- �̸�(ename) ��½� 
-- SMITH -> **ITH
-- WARD -> **RD

-- ���1
SELECT ename, SUBSTR(ename, 1, 2), REPLACE(ename,SUBSTR(ename, 1,2),'**')
FROM emp;

-- ��� 2
SELECT 
    ename, SUBSTR(ename,3), '**'||SUBSTR(ename,3), CONCAT('**', SUBSTR(ename, 3))
FROM emp;

-- ����
SELECT 
    ename, 
    CONCAT('**', SUBSTR(ename,3))  ���1, 
    REPLACE(ename, SUBSTR(ename, 1, 2), '**') ���2
from emp;
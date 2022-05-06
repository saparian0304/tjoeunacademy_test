/*
p174 연습문제 문제풀이
Q1. 
emp에서 이름이 5글자
MASKING_EMPNO - 앞 두자리**
MASKING_ENAME - 첫글자 ****
*/

SELECT
    empno, 
    CONCAT(SUBSTR(empno, 1, 2), '**') MASKING_EMPNO,
    --SUBSTR(empno, 1, 2) || '**' MASKING_EMPNO1, -- 다른 방법
    ename,
    REPLACE(ename, SUBSTR(ename, 2, 4), '****') AS MASKING_ENAME,
    CASE        -- 사원이름이 5글자인 조건이 없을 경우 사용법
        WHEN LENGTH(ename) = 6 THEN SUBSTR(ename, 1, 1) || '*****'
        WHEN LENGTH(ename) = 5 THEN SUBSTR(ename, 1, 1) || '****'
        WHEN LENGTH(ename) = 4 THEN SUBSTR(ename, 1, 1) || '***'
    END AS MASKING_ENAME2
FROM emp;
--WHERE LENGTH(ename) = 5;


/*
p174 Q2 문제풀이
평균근무일수 : 21.5일
하루 근무시간 : 8시간
하루급여 - 소수점 3번째 자리에서 버림
시급 - 소수점 2번째에서 반올림
*/

SELECT
    empno, ename, sal, 
    TRUNC(sal/21.5, 2) AS DAY_PAY,
    ROUND(sal/21.5/8, 1) AS TIME_PAY
    -- ROUND(DAY_PAY/8, 1) AS TIME_PAY  -- 위에서 쓴 alias 사용 불가
FROM emp;

-- SELECT문이 중첩된 경우 안쪽 SELECT문에 있는 alias를 외부 SELECT문에서 사용 가능
SELECT
    DAY_PAY, DAY_PAY/8
FROM (
    SELECT
        empno, ename, sal, 
        TRUNC(sal/21.5, 2) AS DAY_PAY,
        ROUND(sal/21.5/8, 1) AS TIME_PAY
    FROM emp
) a;


/*
p175 Q3  - 문제풀이
정직원 날짜 : 입사 후 3개월이 지난 월요일 날짜
날짜형식 : YYYY-MM-DD
추가수당없는 사원의 COMM : 'N/A'로 출력
*/

SELECT
    empno, ename, hiredate,
    TO_DATE(NEXT_DAY(ADD_MONTHS(hiredate, 3), '월'), 'YYYY-MM-DD') AS R_JOB,
    NVL2(COMM, TO_CHAR(comm),'N/A') AS COMM
    -- NVL(TO_CHAR(comm), 'N/A') -- 더 간단한 방법
FROM emp;


/*
p175 Q4 문제풀이
emp에서 전체
조건 순서대로(위-아래)
*/

SELECT
    empno, ename, 
    NVL(TO_CHAR(mgr), ' ') MGR,
    CASE
        WHEN mgr IS NULL THEN '0000'
        WHEN SUBSTR(mgr, 1, 2) = 75 THEN '5555'
        WHEN SUBSTR(mgr, 1, 2) = 76 THEN '6666'
        WHEN SUBSTR(mgr, 1, 2) = 77 THEN '7777'
        WHEN SUBSTR(mgr, 1, 2) = 78 THEN '8888'        
        ELSE TO_char(mgr)
    END AS CHG_MGR
FROM emp;